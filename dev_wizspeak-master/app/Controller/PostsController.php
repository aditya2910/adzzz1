<?php
App::uses('AppController', 'Controller');
/**
 * Posts Controller
 *
 * @property Post $Post
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 */
class PostsController extends AppController {

/**
 * Components
 *
 * @var array
 */
	public $components = array('Session','Curl');

        public $paginate = array(
            'fields' => array('Post.id', 'Post.title', 'Post.description', 'Post.date_posted', 'Post.link'),
            'limit' => 3,
            'order' => array(
                'Post.id' => 'DESC'
            )
        );
	public function isAuthorized($user) {

		switch ($this->action) {
			case 'replaceURLWithHTMLLinks':
			case 'add_creativity_ajax':
			case 'add':

				return true;
				break;

			case 'add':
			case 'edit':
			case 'delete':
			case 'view':
			case 'videos':
			case 'documents':
			case 'audio':
			case 'friends':
			case 'mentors':
			case 'refresh_wall':
			case 'get_latest_posts':
			case 'save_image':
			case 'add_postvideo_ajax':
			case 'upload_doc':
			case 'upload_audio':
			case 'single_post':
			case 'add_creativity_ajax':
			case 'add_profile_pic':
			case 'add_user_coverpic':


				if($user['role']==1 || $user['role']==2 ){
					return true;
				}
				$this->redirect(array('action' => 'about'));
				return false;
				break;

			case 'more':
			case 'updateGroupName':
			case 'updateGroupDescription':
			case 'profile_photo':
			case 'setting':
			case 'remove_post_ajax':
				if($user['role']==1){
					return true;
				}

				$this->redirect(array('action' => $this->request->param('groupName'),'about'));

				return false;
				break;
			default:
				return false;
		}


		return parent::isAuthorized($user);
	}

/**
 * view method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function view($id = null) {


            $this->layout = 'ajax';

            if ($this->request->is('post')) {

                $post_id = $this->request->data['post_id'];
				$url = "/getPost/".$post_id."/".$this->Auth->user("id");
				$post = $this->Curl->fetchCurl($url);
                $this->set('userPosts' , $post);
				$url1="/userDetails/".$this->Auth->user("id");
				$json_array = $this->Curl->fetchCurl($url1);

				$this->set('userDetails',$json_array);

            }
	}

/**
 * add method
 *
 * @return void
 */
 public function search() {
       $this->Prg->commonProcess();
        $this->Paginator->settings['conditions'] = $this->Post->parseCriteria($this->Prg->parsedParams());
        $this->set('users', $this->Paginator->paginate()); }



/* addv post ajax  */


public function add()
        {

            $this->autoRender = FALSE;



            if ($this->request->is('ajax')) {

                $status['success'] = FALSE;

                $head = $this->replaceURLWithHTMLLinks($this->request->data['title']);
                $description = $this->replaceURLWithHTMLLinks($this->request->data['description']);

                $this->request->data['title'] = $head;
                $this->request->data['description'] = $description;
                $this->request->data['date_posted'] = date('Y-m-d H:i:s');
                $this->request->data['postby_name'] = $this->Auth->user("userId");


				//mentor talk
				if(($this->request->data['wall_type']== 3 ) && ($this->request->data['postby_id'] != $this->request->data['postto_id'])){

					// mentor post will be published my mentor only
					if($this->Auth->user("userId")== $this->request->data['postby_id']){
						//mentor posting
					}else{
						$this->request->data['postto_id'] = $this->request->data['postby_id'];
					}
					$this->request->data['is_private']  = 1;

				}
				$this->request->data['postby_id'] = $this->Auth->user("userId");
				//get from session
               // $this->request->data['wall_type'] = $this->Session->read('Auth.User.wallType');
                //$this->request->data['postto_id'] = $this->Session->read('Auth.User.wallId');
              //  $this->request->data['vertical_id'] = $this->Session->read('Auth.User.verticalId');

				//curl call to save
				$url = "/addPost";

				$data = $this->request->data;
				

				$status = $this->Curl->postHttpCurl($url,$data);


                return json_encode($status);
            }


        }


        public function replaceURLWithHTMLLinks($text) {

            $atext = preg_replace("@((https?://)?([-\w]+\.[-\w\.]+)\w(:\d+)?(/([-\w/_\.\,]*(\?\S+)?)?)*)@", "<a target='_blank' href='$1'>$1</a>", $text);
            // echo $atext;

            $a = htmlentities($text);


            return $a;
        }


        public function remove_post_ajax() {
            $this->layout = null;
            $this->autoRender = false;
            if ($this->request->is('post')) {
                $this->Post->id = $this->request->data['id'];
                $this->Post->saveField('status' ,$this->request->data['status']);
                //echo 'success';
            }
        }

/*
 *
 * save base 64 image
 */

        public function save_image() {
            $this->autoRender = FALSE;
                $response = array('success' => true);

                if ($this->request->is('post')) {

                    try{

                        $files = $this->request->data['imgsrc'];
                        $count = 0;
                        $cnt = count($files);

                        for ($k = 0; $k < $cnt ; $k++) {

                            $imgs = $files[$k];
                            $file = array();
                            $file = explode(';', $imgs);
                            $file_ext = substr($file[0], 11);
                            $str = 'data:image/' . $file_ext . ';base64,';
                            $base64img = str_replace($str, '', $imgs);
                            $data = base64_decode($base64img);
                            $unic_id = time();
                            $pic_name=$unic_id . $count . '_time.' . $file_ext;
                            $file_img = POST_IMAGE_UPLOAD_FOLDER .$pic_name ;
                            file_put_contents($file_img, $data);
							$csuccess = $this->Curl->putCurl('upload/images/'.$pic_name);
							if($csuccess){
								//delete file
								if(!unlink($file_img)){
									echo ("Error deleting $file_img");
								}
							}
                            $response['link_'.$k]= $pic_name;
                            $count++;
                        }

                    }  catch (Exception $ex){
                        $response['success'] = false;
                    }
                    //$this->response->body();
                    return json_encode($response);

                }
        }


        /*
         * save video file
         *
         */



        public function add_postvideo_ajax() {
            $this->autoRender = false;
            if ($this->request->is('POST')) {
                $file = $this->request->data['video']['post_box_video'];
                $status['success'] = FALSE;
                if($file['size'] > 0){

                    $status['file_error'] = False;
                    if( $file['size'] > 100004800){
                        $status['file_error'] = TRUE;
                        $status['success'] = FALSE;
                        return json_encode($status);end();
                    }
                    //format check

                    $ext = pathinfo($file['name'], PATHINFO_EXTENSION);

                    $new_video_name = 'wall_'.time().$this->Auth->user('id').'.'.$ext;

                    $temp_file = $file['tmp_name'];


                    if (move_uploaded_file($temp_file, CRE_VIDEO_PROCESS_FOLDER.$new_video_name)) {

                        $status['success'] = TRUE;
                        $status['feedback'] = 'video uploaded';
                        $status['file_error'] = FALSE;
                        $status['link'] = $new_video_name;
                        return json_encode($status);end();

                    }




                }else{
					debug("file size zero");
				}


            }
        }


        public function upload_doc() {

            $this->autoRender = false;
            if ($this->request->is('POST')) {
               try{
                    $doc = $this->request->data['doc']['doc_file'];

                    if($doc['size'] <= 0){
                        $status['success'] = FALSE;
                        $status['file_error'] = TRUE;
                        $status['feedback'] = 'zero file size';
                        return json_encode($status);end();

                    }
                    //check doc type
                    if($doc['size'] > 5125000){
                        $status['success'] = FALSE;
                        $status['file_error'] = TRUE;
                        $status['feedback'] = 'File size should less than 5 Mb';
                        return json_encode($status);end();

                    }
                    $ext = pathinfo($doc['name'], PATHINFO_EXTENSION);
                    $new_doc = 'doc_'.time().$this->Auth->user('id').'.'.$ext;

                    if (move_uploaded_file($doc['tmp_name'], POST_DOC_UPLOAD_FOLDER.$new_doc)) {

                        $status['success'] = TRUE;
                        $status['feedback'] = 'document uploaded';
                        $status['file_error'] = FALSE;
                        $status['link'] = $new_doc;
                        return json_encode($status);end();

                    }
                } catch (Exception $e) {

                        $status['success'] = FALSE;
                        $status['feedback'] = 'file exception';
                        $status['file_error'] = TRUE;
                        return json_encode($status);end();

                }
            }

        }

        public function upload_audio(){

            $this->autoRender = false;
            if ($this->request->is('POST')) {


                try{
                    $audio = $this->request->data['audio']['audio_file'];

                    if($audio['size'] <= 0){
                        $status['success'] = FALSE;
                        $status['file_error'] = TRUE;
                        $status['feedback'] = 'zero file size';
                        return json_encode($status);end();

                    }
                    //check doc type
                    if($audio['size'] > 15125000){
                        $status['success'] = FALSE;
                        $status['file_error'] = TRUE;
                        $status['feedback'] = 'File size should less than 15 Mb';
                        return json_encode($status);end();

                    }
                    $ext = pathinfo($audio['name'], PATHINFO_EXTENSION);
                    $new_doc = 'audio_'.time().$this->Auth->user('id').'.'.$ext;

                    if (move_uploaded_file($audio['tmp_name'], POST_AUDIO_UPLOAD_FOLDER.$new_doc)) {

                        $status['success'] = TRUE;
                        $status['feedback'] = 'audio uploaded';
                        $status['file_error'] = FALSE;
                        $status['link'] = $new_doc;
                        return json_encode($status);end();

                    }else{throw new Exception('Could not move file');}
                } catch (Exception $e) {

                        $status['success'] = FALSE;
                        $status['feedback'] = $e->getMessage();
                        $status['file_error'] = TRUE;

                        return json_encode($status);end();

                }
            }


        }

        public function refresh_wall() {
            $this->layout = 'ajax';
            $this->autoRender = FALSE;
            if ($this->request->is('post')) {
                    $post_id = $this->request->data['postids'];
                    //$post_id =69;

                    $this->Post->recursive = 1;
                    $data = $this->Post->find('all',array(
                        'conditions' => array('Post.id' => $post_id),
                    ));

                    return json_encode($data);

            }
        }

        public function get_latest_posts() {


            //$this->autoRender = FALSE;
            $this->layout = 'ajax';
            if($this->request->is('ajax')){

                $from_groups = array();
                $from_friends = array();

				$url = $this->request->data['url'];
				$urlpart = explode('/',$url);

				if($urlpart[2]=='localhost'|| $urlpart[2]=='192.168.0.12' || $urlpart[2]=='wizspeak.com'){

					$controller = $urlpart[4];

					if(isset($urlpart[5])){
						$par1 = $urlpart[5];
					}

					if(isset($urlpart[6])){
						$par2 = $urlpart[6];
					}
					if(isset($urlpart[7])){
						$par3 = $urlpart[7];
					}

				}else{
					//server

					$controller = $urlpart[3];

					if(isset($urlpart[4])){
						$par1 = $urlpart[4];
					}
					if(isset($urlpart[5])){
						$par2 = $urlpart[5];
					}
					if(isset($urlpart[6])){
						$par3 = $urlpart[6];
					}


				}

                if($this->request->data['wall_type'] == 1){

					$this->set('userPosts',array());

					if($controller == 'profiles'){

						$wall_id = $this->request->data['wall_id'];

						if(isset($par2) AND $par2 != null){
							$wall_id = $par2;

						}
						$page = 1;
						$url = "/getProfilePost/".$wall_id."/".$this->Auth->user("userId")."/".$page."/".$this->request->data['last_postid'];

						$jsonObject = $this->Curl->fetchCurl($url);
						$this->set('userPosts',$jsonObject);



					}elseif($controller == "ambitions"){

						$page = 1;
						$url = "/getAmbitionHomePost/".$this->Auth->user("id")."/".$page."/".$this->request->data['last_postid'];


						$jsonObject = $this->Curl->fetchCurl($url);

						$this->set('userPosts',$jsonObject);
					}






                }
				if($this->request->data['wall_type'] == 2){

					$this->set('userPosts',array());
					$page = 1;
					$url = "/getGroupPagination/".$par1."/".$this->Auth->user("userId")."/".$page."/".$this->request->data['last_postid'];

					$jsonObject = $this->Curl->fetchCurl($url);

					$this->set('userPosts',$jsonObject);


                }

				if($this->request->data['wall_type'] == 3 || $this->request->data['wall_type'] == 4){

					$this->set("userPosts",array());
					if($controller=='mentor'){

						if($par2 == 'profile'){
							//debug("inside profile gwee");

							$mentorId = $par1;
							$latestPostId = $this->request->data['last_postid'];

							$isAdmin = 0;
							if($this->Auth->user("userId") == $mentorId){
								$isAdmin = 1;

							}

							$url = "/getMentorWallPost/".$mentorId."/".$this->Auth->user("userId")."/".$latestPostId."/1";
							//debug($url);
							$post = $this->Curl->fetchCurl($url);
							//debug($post);

							$this->set("userPosts",$post);

						}

						elseif($par2 == 'talk'){

							$mentorId = $par1;
							$userId = $par3;
							$latestPostId = $this->request->data['last_postid'];
							$page =0;

							$url1 = "/getTalk/" . $mentorId."/".$userId."/".$page."/".$latestPostId;

							$posts = $this->Curl->fetchCurl($url1);
							$this->set("userPosts",$posts);
						}
						elseif($par2 == 'achievement'){


							$mentorId = $par1;
							$userId = $this->Auth->user("id");
							$latestPostId = $this->request->data['last_postid'];
							$page =0;

							$url1 = "/getAchieve/" . $mentorId."/".$userId."/".$page."/".$latestPostId;

							$posts = $this->Curl->fetchCurl($url1);
							$this->set("userPosts",$posts);
						}
					}


				}



            }

        }
    //******************cre image**********************//
        public function upload_creimage(){

            $this->autoRender = false;
            if ($this->request->is('POST')) {


                try{
                    $image = $this->request->data['image']['image_file'];

                    if($image['size'] <= 0){
                        $status['success'] = FALSE;
                        $status['file_error'] = TRUE;
                        $status['feedback'] = 'zero file size';
                        return json_encode($status);end();

                    }
                    //check image type
                    if($image['size'] > 15125000){
                        $status['success'] = FALSE;
                        $status['file_error'] = TRUE;
                        $status['feedback'] = 'File size should less than 15 Mb';
                        return json_encode($status);end();

                    }
                    $ext = pathinfo($image['name'], PATHINFO_EXTENSION);
                    $new_doc = 'creimage_'.time().$this->Auth->user('id').'.'.$ext;

                    if (move_uploaded_file($image['tmp_name'], CRE_IMAGE_UPLOAD_FOLDER.$new_doc)) {

                        $status['success'] = TRUE;
                        $status['feedback'] = 'image uploaded';
                        $status['file_error'] = FALSE;
                        $status['link'] = $new_im;
                        return json_encode($status);end();

                    }else{throw new Exception('Could not move file');}
                } catch (Exception $e) {

                        $status['success'] = FALSE;
                        $status['feedback'] = $e->getMessage();
                        $status['file_error'] = TRUE;

                        return json_encode($status);end();

                }
            }


        }

        public function process(){
            $this->autoRender = False;
            if($this->request->is('ajax')){
                debug($this->request->data);

                if($this->request->data['post_type'] == 3){
                    //video process
                   $this->process_video($this->request->data['post_id']);
                }else{
                   $this->process_audio($this->request->data['post_id']);
                }
            }
        }


        public function process_video($post_id){

                $this->Post->recursive = -1;
                $video = $this->Post->find('first',array(
                            'conditions' => array(
                                'Post.id' => $post_id
                            )
                        ));



                $matches=basename(__FILE__,'.php');
                $actual_link = "http://$_SERVER[HTTP_HOST]$_SERVER[REQUEST_URI]";
                $end = time();
                $here=$matches.".php";
                $video['Post']['link'];
                if (file_exists(CRE_VIDEO_PROCESS_FOLDER.$video['Post']['link'])){

                $in = CRE_VIDEO_PROCESS_FOLDER.$video['Post']['link'];
                //get video length
                ob_start();
                passthru(FFMPEG_PATH." -i $in  2>&1 ");
                $duration = ob_get_contents();
                $full = ob_get_contents();
                ob_end_clean();
                $dura=4000;
                $search = "/duration.*?([0-9]{1,})/";
                $bitrate = "/bitrate.*?([0-9]{1,})/";
                $whatIWant = substr($duration, strpos($duration, "Duration") + 8);
                $rest = substr($whatIWant, 2, 8);

                $div=explode(':',$rest);
                if(count($div)!=3){
                $rest='00:'.$dura;
                $div=explode(':',$rest);
                }
            //pr($div);
            if(count($div)==3){
            //echo "</br> print=";print_r($div);
            $timinsec=$div[0]*3600+$div[1]*60+$div[2];
            //echo 'duration in sec'.$timinsec;
            if($timinsec==0) {
            echo "We are sorry to process this video";
            }


            if($timinsec>0){

                $forth=($timinsec/4);

                $time1=$forth;
                $time2=2*$forth;
                if(!isset($time2)){$time2=1;}


                $duration = preg_match($search, $duration, $matches, PREG_OFFSET_CAPTURE, 3);

                $thumb_name=$this->Auth->user('id').$end."_196x110_thumb.png";
                $video_name=$this->Auth->user('id').$end."_".FFMPEG_VIDEO_NORMAL_SIZE."_video.mp4";
                $link = $this->Auth->user('id').$end;
                exec(FFMPEG_PATH." -itsoffset -$time2  -i $in -vcodec mjpeg -vframes 1 -an -f rawvideo -s 196x110 ".POST_VIDEO_THUMBNAIL_UPLOAD_FOLDER.$thumb_name);


                exec(FFMPEG_PATH." -i $in -s ".FFMPEG_VIDEO_NORMAL_SIZE." -vcodec libx264 -strict -2  ".POST_VIDEO_FOLDER.$video_name." > ffmpeg.log");





                /* deleting the uploaded file */
                $de_file = $in;
                echo 'delete file '.$in;
                if (!unlink($de_file))
                  {
                echo ("Error deleting $de_file");
                exit('end..');
                  }
                else
                  {echo'update post'.$video['Post']['id'];

                    $this->Post->id = $video['Post']['id'];
                    $this->Post->set(array('link' => $link,'status' => 1));
                    $this->Post->save();


                  }

                /* deleting the uploaded file End */



            }
                }
                else{
                //echo 'File format is not supported';
                  if (!unlink($in))
                  {
                  //echo ("Error deleting $in");
                  }
                else
                  {
                  //echo ("Deleted $in");
                  }
                }
                }


        }

        public function process_audio ($post_id) {
            debug($post_id);
                $this->Post->recursive = -1;
                $audio = $this->Post->find('first',array(
                            'conditions' => array(
                                'Post.id' => $post_id
                            )
                        ));

            $end = time();
            if (file_exists(POST_AUDIO_UPLOAD_FOLDER.$audio['Post']['link'])){
                $in= POST_AUDIO_UPLOAD_FOLDER.$audio['Post']['link'];
                exec(FFMPEG_PATH." -i $in ".POST_AUDIO_FOLDER.$this->Auth->user('id').$end.".mp3  > ffmpeg.log");
                $de_file=$in;
                $end = $this->Auth->user('id').$end;
                    if (!unlink($de_file)){
                        echo ("Error deleting $de_file");
                        exit('end..');
                    }
                    else{
                        $this->Post->id=$post_id;
                        $this->Post->set(array('link' => $end,'status'=> 1));
                        $this->Post->save();


                    }
            }
        }





     public function cre_process_video(){

                $this->Post->recursive = -1;
                 $this->autoRender = FALSE;

                $video = $this->Post->find('first',array(
                            'conditions' => array('post_type_id'=> 3,'Post.status' => 0) ,
                            )


                        );



                $matches=basename(__FILE__,'.php');
                $actual_link = "http://$_SERVER[HTTP_HOST]$_SERVER[REQUEST_URI]";
                $end = time();
                $here=$matches.".php";
                $video['Post']['link'];
                pr($video);
                if (file_exists(CRE_VIDEO_PROCESS_FOLDER.$video['Post']['link'])){

                $in = CRE_VIDEO_PROCESS_FOLDER.$video['Post']['link'];
                //get video length
                ob_start();
                passthru(FFMPEG_PATH." -i $in  2>&1 ");
                $duration = ob_get_contents();
                $full = ob_get_contents();
                ob_end_clean();
                $dura=4000;
                $search = "/duration.*?([0-9]{1,})/";
                $bitrate = "/bitrate.*?([0-9]{1,})/";
                $whatIWant = substr($duration, strpos($duration, "Duration") + 8);
                $rest = substr($whatIWant, 2, 8);

                $div=explode(':',$rest);
                if(count($div)!=3){
                $rest='00:'.$dura;
                $div=explode(':',$rest);
                }
            //pr($div);
            if(count($div)==3){
            //echo "</br> print=";print_r($div);
            $timinsec=$div[0]*3600+$div[1]*60+$div[2];
            //echo 'duration in sec'.$timinsec;
            if($timinsec==0) {
            echo "We are sorry to process this video";
            }


            if($timinsec>0){

                $forth=($timinsec/4);

                $time1=$forth;
                $time2=2*$forth;
                if(!isset($time2)){$time2=1;}


                $duration = preg_match($search, $duration, $matches, PREG_OFFSET_CAPTURE, 3);

                $thumb_name=$this->Auth->user('id').$end."_196x110_thumb.png";
                $video_name=$this->Auth->user('id').$end."_".FFMPEG_VIDEO_NORMAL_SIZE."_video.mp4";
                $link = $this->Auth->user('id').$end;
                exec(FFMPEG_PATH." -itsoffset -$time2  -i $in -vcodec mjpeg -vframes 1 -an -f rawvideo -s 540x303 ".CRE_VIDEO_THUMBNAIL_UPLOAD_FOLDER.$thumb_name);


                exec(FFMPEG_PATH." -i $in -s ".FFMPEG_VIDEO_NORMAL_SIZE." -vcodec libx264 -strict -2  ".CRE_VIDEO_UPLOAD_FOLDER.$video_name." > ffmpeg.log");





                /* deleting the uploaded file */
                $de_file = $in;
                echo 'delete file '.$in;
                if (!unlink($de_file))
                  {
                echo ("Error deleting $de_file");
                exit('end..');
                  }
                else
                  {echo'update post'.$video['Post']['id'];

                    $this->Post->id = $video['Post']['id'];
                    $this->Post->set(array('link' => $link,'status' => 1,'date_updated' => date('Y-m-d H:i:s')));
                    $this->Post->save();


                  }

                /* deleting the uploaded file End */



            }
                }
                else{
                //echo 'File format is not supported';
                  if (!unlink($in))
                  {
                  //echo ("Error deleting $in");
                  }
                else
                  {
                  //echo ("Deleted $in");
                  }
                }
                }


        }

        public function single_post() {

            $permission = $this->Access->get_my_role($this->request->params);
             if(!in_array(1, $permission)){
               // $this->redirect($this->referer());
             }
            $this->set('permission',$permission);
            $this->layout = 'ajax';

            if ($this->request->is('post')) {
                    $post_id = $this->request->data['postids'];
                    //$post_id =69;

                    $this->Post->recursive = 1;
                    $post[] = $this->Post->find('first',array(
                        'conditions' => array('Post.id' => $post_id),
                    ));
                    $user['User']['id'] = $this->Auth->user('id');
                    $this->set('posts' , $post);
                    $this->set('user' , $user);
                    //pr($post);

            }
        }



        public function delete() {
            $this->autoRender = FALSE;
            if($this->request->is('POST')){
                $post = $this->request->data;

				$post["user_id"] = $this->Auth->user("id");


				$url = '/deletePost';

				$status = $this->Curl->postHttpCurl($url,$post);

				return json_encode($status);
            }
        }


        public function edit() {
            $this->autoRender = FALSE;
            if($this->request->is('POST')){
				$this->request->data['user_id'] = $this->Auth->user("id");

				$url = '/updatePostText';

				$status = $this->Curl->postHttpCurl($url,$this->request->data);



                return json_encode($status);
            }
        }

    public function add_tag(){


            $this->autoRender = false;

            if(isset($_POST['tags'])){
                    $tags=$_POST['tags'];

                    $this->Post->create();
                        $tags = array('postby_id' => $this->Auth->user('id'),
                            'Post.keyword' => $this->request->data['tags_id']['tags'],

//                           'tag' => $this->request->data['creativity']['tag'],

                        );

                        $this->Post->save($tags) ;


            }


        }




	public function add_creativity_ajax()
	{
		$this->layout = null;
		$this->autoRender = false;
		$status['success'] = true;
		$status['err_msg'] = 'File uploaded ';
		if ($this->request->is('POST')) {
			$poststatus = '1';
			$upload_dir = CRE_IMAGE_UPLOAD_FOLDER;
			if ($this->request->data['creativity']['button_selected'] == 2) {
				$upload_dir = CRE_IMAGE_UPLOAD_FOLDER;
			} elseif ($this->request->data['creativity']['button_selected'] == 3) {
				$upload_dir = CRE_VIDEO_PROCESS_FOLDER;
				$poststatus = '0';
			} elseif ($this->request->data['creativity']['button_selected'] == 5) {
				$upload_dir = CRE_AUDIO_UPLOAD_FOLDER;
				$poststatus = '1';
			} elseif ($this->request->data['creativity']['button_selected'] == 4) {
				$upload_dir = CRE_DOC_FOLDER;
			}
			if ($this->request->data['creativity']['file']['size'] > 0) {
				$uploadOk = 1;
				// Check file size
				if ($this->request->data['creativity']['file']['size'] > 100004800) {
					$uploadOk = 0;
					$status['success'] = false;
					$status['err_msg'] = 'File size is too large ';
				}
				$pic_names = explode('.', $this->request->data['creativity']['file']['name']);
				$picnamecount = count($pic_names);


				$pic_extension = $pic_names[$picnamecount - 1];
				$pic_name = $this->Auth->user('id') . time() . '.' . $pic_extension;


				$target_file = $upload_dir . $pic_name;



				if ($uploadOk > 0) {
					if (move_uploaded_file($this->request->data['creativity']['file']["tmp_name"], $target_file )) {
						//$this->Post->create();

						$credata = $this->Curl->putCurl($upload_dir.$pic_name);
						print_r($credata);

						$data = array('postby_id' => $this->Auth->user('id'),
							'title' => $this->request->data['creativity']['title'],
							//'tag' => $this->request->data['creativity']['tags'],
							'is_private' => '0',
							'post_type_id' => $this->request->data['creativity']['button_selected'],
							'status' => $poststatus,
							'wall_type' => 2,
							'postto_id' => $this->request->data['creativity']['category'],
							'keywords' => 'wizspeak',
							'vertical_id' => 3,
							'date_posted' => date('Y-m-d H:i:s'),
							'link' => $pic_name
						);



						$url = "/addCreativityPost";


						$status = $this->Curl->postHttpCurl($url,$data);


						//$this->Post->save($data);
						$cre_post_id = $this->Post->getInsertID();


					} else {
						$status['success'] = false;
						$status['err_msg'] = 'Some thing went Wrong!! ';
					}
				}
			}
			//return json_encode($status);
		}
	}

	public function add_user_coverpic() {
		$this->autoRender = FALSE;
		$response = array('success' => true);

		if ($this->request->is('post')) {

			try{

				$files = $this->request->data['imgsrc'];
				$count = 0;
				$cnt = count($files);

				for ($k = 0; $k < $cnt ; $k++) {

					$imgs = $files[$k];
					$file = array();
					$file = explode(';', $imgs);
					$file_ext = substr($file[0], 11);
					$str = 'data:image/' . $file_ext . ';base64,';
					$base64img = str_replace($str, '', $imgs);
					$data = base64_decode($base64img);
					$unic_id = time();
					$pic_name=$unic_id . $count . '_cover.' . $file_ext;
					$file_img = COVERPIC_UPLOAD_FOLDER .$pic_name ;

					file_put_contents($file_img, $data);



					$response['link_'.$k]= $pic_name;
					$count++;



					$csuccess = $this->Curl->putCurl(COVERPIC_UPLOAD_FOLDER .$pic_name);
					debug($csuccess);
					if($csuccess){
						unlink(COVERPIC_UPLOAD_FOLDER .$pic_name);

					}else{
						$csuccess = $this->Curl->putCurl(COVERPIC_UPLOAD_FOLDER .$pic_name);
						if($csuccess){unlink(COVERPIC_UPLOAD_FOLDER .$pic_name);}
					}

					$result = $this->Curl->fetchCurl("/addCoverPic/".$pic_name."/".$this->Auth->user("userId"));
					debug($this->Auth->user("userId"));


				}

			}  catch (Exception $ex){
				$response['success'] = false;
			}
			//$this->response->body();
			return json_encode($response);



			return $csuccess ;


		}
	}

	public function add_profile_pic() {
		$this->autoRender = FALSE;
		$response = array('success' => true);

		if ($this->request->is('post')) {

			try{

				$files = $this->request->data['imgsrc'];
				$count = 0;
				$cnt = count($files);

				for ($k = 0; $k < $cnt ; $k++) {

					$imgs = $files[$k];
					$file = array();
					$file = explode(';', $imgs);
					$file_ext = substr($file[0], 11);
					$str = 'data:image/' . $file_ext . ';base64,';
					$base64img = str_replace($str, '', $imgs);
					$data = base64_decode($base64img);
					$unic_id = time();
					$pic_name=$unic_id . $count . '_profile.' . $file_ext;
					$file_img = COVERPIC_UPLOAD_FOLDER .$pic_name ;

					file_put_contents($file_img, $data);



					$response['link_'.$k]= $pic_name;
					$count++;



					$csuccess = $this->Curl->putCurl(COVERPIC_UPLOAD_FOLDER .$pic_name);
					debug($csuccess);
					if($csuccess){
						unlink(COVERPIC_UPLOAD_FOLDER .$pic_name);

					}else{
						$csuccess = $this->Curl->putCurl(COVERPIC_UPLOAD_FOLDER .$pic_name);
						if($csuccess){unlink(COVERPIC_UPLOAD_FOLDER .$pic_name);}
					}

					$result = $this->Curl->fetchCurl("/addUserProfilePic/".$pic_name."/".$this->Auth->user("userId"));
					debug($this->Auth->user("userId"));


				}

			}  catch (Exception $ex){
				$response['success'] = false;
			}
			//$this->response->body();
			return json_encode($response);



			return $csuccess ;


		}
	}


}

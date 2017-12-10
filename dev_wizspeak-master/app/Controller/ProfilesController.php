<?php
App::uses('AppController', 'Controller', 'Post');
/**
 * Posts Controller
 *
 * @property Post $Post
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 */
class ProfilesController extends AppController {

/**
 * Components
 *
 * @var array
 */
	public $components = array('Paginator', 'Session', 'Curl','Crop');
        public $name = 'profile';
        public $uses = array('User');

		private $pageUser = 0;


        public function beforeFilter() {
            parent::beforeFilter();
            $this->Auth->deny(); //fro user defined controllers

            $this->setJsVar('wall_id', $this->Auth->user('id'));
            $this->setJsVar('wall_type',1);
            $this->setJsVar('vertical_id',1);
            $this->setJsVar('is_mentor',0);
            $this->setJsVar('user_id', $this->Auth->user('userId'));
			if(!$this->Auth->user("id")){
				$this->redirect(
					array('controller' => 'users', 'action' => 'logout')
				);

			}
			$this->pageUser = $this->Auth->user('userId');
			if(isset($this->request->params['userId'])){
				$this->pageUser = $this->request->params['userId'];
			}
			$this->setJsVar('wall_id', $this->pageUser);
			$this->set('wall_id', $this->pageUser);


			$userPageRole = 0;
			$userPageRole = $this->getUserRole($this->Auth->user("userId"),$this->pageUser);


			$this->Session->write('Auth.User.role', $userPageRole);//$userPageRole


			$this->set("role",$userPageRole);
			$status = $this->friend_status($this->pageUser);
			$this->set('friend_status',$status);

        }


		public function isAuthorized($user) {

			switch ($this->action) {
				case 'index':
				case 'getUserRole':
					return true;
					break;
				case 'wall':
				case 'images':
				case 'videos':
				case 'documents':
				case 'audio':
				case 'friends':
				case 'mentors':


					if($user['role']==1 || $user['role']==2 ){
						return true;
					}

					return false;
					break;

				case 'more':
				case 'updateGroupName':
				case 'updateGroupDescription':
				case 'profile_photo':
				case 'setting':
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



        public function index() {

			$this->getProfileBaseData();
            $this->layout = 'looged_in_ui_template';
			$select = 'index';
			$this->set('select',$select);


            $this->setJsVar('wall_id', $this->pageUser);

            $this->setJsVar('wall_type',1);
            $this->setJsVar('vertical_id',1);


			$url="/getUserDetails/".$this->pageUser;
			$userDetails = $this->Curl->fetchCurl($url);
			$this->set('userDetails',$userDetails);

			$url1="/userEducation/".$this->pageUser;
			$json_array = $this->Curl->fetchCurl($url1);

			$this->set('educations',$json_array);
			$cid = $userDetails->country;
			$url = "/getUserCountry/" . $cid;

			$getUserCountry = $this->Curl->fetchCurl($url);

			$this->set('country', $getUserCountry[0]);


			$this->loadModel('Countries');
			$data = $this->Countries->find('all', array('fields' => array('id', 'name')));

			for ($i = 0; $i < count($data); $i++) {
				$Countries[$i]['label'] = $data[$i]['Countries']['name'];
				$Countries[$i]['value'] = $data[$i]['Countries']['id'];
			}


			$this->set('countries',$Countries);

        }







	public function wall()
	{

		$this->getProfileBaseData();

		$url="/getUserDetails/".$this->pageUser;

		$this->set('pageUser',$this->pageUser);
		$userDetails = $this->Curl->fetchCurl($url);
		$this->set('userDetails',$userDetails);


		$this->layout = 'looged_in_ui_template';

		$select = 'wall';
		$this->set('select',$select);

		$Friends = $this->pageUser;
		$Groups = array();
		$this->loadModel('Profile');

		$this->Paginator->settings = array('limit' => $this->Auth->user("id"));


		$data = $this->paginate('Profile');


		$this->set('userPosts',$data);
		// $this->set('posts',$data);


	}


	public function friends()
	{



		$select = 'friends';
		$this->set('select',$select);

		$this->getProfileBaseData();


		$url="/getUserDetails/".$this->pageUser;
		$url1="/getUserFriends/".$this->pageUser;

		$userDetails = $this->Curl->fetchCurl($url);
		$userFriends = $this->Curl->fetchCurl($url1);


		$this->set('userFriends',$userFriends);
		$this->set('userDetails',$userDetails);
		$this->layout = 'looged_in_ui_template';


	}



	public function mentors()
	{

		$select = 'mentors';
		$this->set('select',$select);

		$this->getProfileBaseData();


		$url="/getUserDetails/".$this->pageUser;
		$url1="/getUsersMentor/".$this->pageUser;

		$userDetails = $this->Curl->fetchCurl($url);
		$userMentors = $this->Curl->fetchCurl($url1);
		$this->set('userDetails',$userDetails);
		$this->set('userMentors',$userMentors);
		$this->layout = 'looged_in_ui_template';


	}



	public function images()
	{
		$select = 'images';
		$this->set('select',$select);

		$this->getProfileBaseData();
		$url="/getUserDetails/".$this->pageUser;
		$userDetails = $this->Curl->fetchCurl($url);
		$this->set('userDetails',$userDetails);

		$this->layout = 'looged_in_ui_template';

		$this->loadModel('ProfileImage');
		$this->Paginator->settings = array('limit' => $this->Auth->user("id"));
		$data = $this->paginate('ProfileImage');
		$this->set('userImages',$data);


	}



	public function videos()
	{
		$select = 'videos';
		$this->set('select',$select);

		$this->getProfileBaseData();
		$url="/getUserDetails/".$this->pageUser;
		$userDetails = $this->Curl->fetchCurl($url);
		$this->set('userDetails',$userDetails);

		$this->layout = 'looged_in_ui_template';

		$this->loadModel('ProfileVideo');
		$this->Paginator->settings = array('limit' => $this->Auth->user("id"));
		$data = $this->paginate('ProfileVideo');
		$this->set('userVideos',$data);


	}




	public function documents()
	{

		$select = 'documents';
		$this->set('select',$select);

		$this->getProfileBaseData();
		$url="/getUserDetails/".$this->pageUser;
		$userDetails = $this->Curl->fetchCurl($url);
		$this->set('userDetails',$userDetails);

		$this->layout = 'looged_in_ui_template';
		$this->loadModel('ProfileDocument');
		$this->Paginator->settings = array('limit' => $this->Auth->user("id"));
		$data = $this->paginate('ProfileDocument');
		$this->set('userDocuments',$data);


	}





	public function audio()
	{

		$select = 'audio';
		$this->set('select',$select);

		$this->getProfileBaseData();
		$url="/getUserDetails/".$this->pageUser;
		$userDetails = $this->Curl->fetchCurl($url);
		$this->set('userDetails',$userDetails);

		$this->layout = 'looged_in_ui_template';

		$this->loadModel('ProfileDocument');
		$this->Paginator->settings = array('limit' => $this->Auth->user("id"));
		$data = $this->paginate('ProfileDocument');
		$this->set('userAudios',$data);


	}


	public function getUserRole($pageUserId,$loginUserId){


		if($pageUserId == $loginUserId){

			return 1;
		}

		try {
			$result = $this->Curl->fetchCurl("/userProfileRole/".$pageUserId."/".$loginUserId);
		}catch(Exception $e){
			debug("error in feching user role ".$e->getMessage());
		}

		return $result;
	}


	public  function getProfileBaseData(){
//fixed for all users

		$url = "/userProfileBaseData/".$this->Auth->user("userId");

		$pageBase =  $this->Curl->fetchCurl($url);


		$this->set('userDetails',$pageBase->userDetails);



		$this->set('userFriends',$pageBase->frindList);



		$this->set('userMentors',$pageBase->mentorList);



		$this->set('userGroups',$pageBase->userGroup);

		if($this->Auth->user("userId") == $this->pageUser){
			//get others rating on me
			$url3="/getUserRating/".$this->pageUser;

		}else{
			//find my rating on him

			$url3="/getUserUserRating/".$this->pageUser."/".$this->Auth->user("userId");
		}

		$rate = $this->Curl->fetchCurl($url3);

		$this->set('userRating',$rate);
	}



	public function setting()
	{
		$select = 'setting';
		$this->set('select',$select);

		$this->layout = 'looged_in_ui_template';


		if($this->request->is('post')) {

			// is file uploaded by http post
			if (!empty($this->request->data['User']['file']['tmp_name']) && is_uploaded_file($this->request->data['User']['file']['tmp_name'])) {
				$allowedExts = array("image/gif", "image/jpeg", "image/jpg", "image/png", "image/JPG", "image/JPEG");
				$temp = explode(".", $this->request->data['User']['file']["name"]);
				$extension = end($temp);
				$file_type = $this->request->data['User']['file']["type"];
				if(!in_array($file_type, $allowedExts)){
					$this->Flash->success(__('The file type is not supported.'));
					return $this->redirect(['action' => 'profile_photo']);
				}
				if($this->data['User']['file']["error"] > 0){
					$this->Flash->success(__($this->data['file']["error"]));
					return $this->redirect(['action' => 'profile_photo']);
				}
				$file_name = 'Profile_uploaded_pic'.$this->Auth->user('id') . time() . '.' . $extension;
				if (file_exists(PROFILE_IMAGE_PATH.'process/'.$file_name)){
					$this->Flash->success(__('File already exits'));
					return $this->redirect(['action' => 'profile_photo']);
				}
				$moved = move_uploaded_file($this->request->data['User']['file']["tmp_name"], PROFILE_IMAGE_PATH.'process/'.$file_name);
				if(!$moved){
					$this->Flash->success(__('File can\'t be moved'.PROFILE_IMAGE_PATH.'process/'.$file_name));
					return $this->redirect(['action' => 'profile_photo']);
				}

				//$pic_name = $this->image_crop($file_name, $this->request->data['User'],$this->pageUser);

				$img_name = $this->Crop->profile_crop($file_name, $this->request->data['User'],$this->pageUser);
				$csuccess = $this->Curl->putCurl(PROFILE_IMAGE_PATH.'process/'.$img_name);

				if($csuccess){
					unlink(PROFILE_IMAGE_PATH.'process/'.$img_name);
					unlink(PROFILE_IMAGE_PATH.'process/'.$file_name);
				}else{
					$csuccess = $this->Curl->putCurl(PROFILE_IMAGE_PATH.'process/'.$img_name);
					if($csuccess){unlink(PROFILE_IMAGE_PATH.'process/'.$img_name);}
				}

				$result = $this->Curl->fetchCurl("/addUserProfilePic/".$img_name."/".$this->pageUser);
				$result = $this->Curl->fetchCurl("/getFriendStatus/".$img_name."/".$this->pageUser);


				$this->set('avathar' , $img_name);
			}
		}

		//get user ambitions
		$this->getAmbitions();
		$this->getHobbies();

			$this->getProfileBaseData();



	}


	public  function getAmbitions(){
	//get user mapped ambitions
		$cate = 1; //ambition
		$isMentor = 0;//user 0- mentor
		$result = $this->Curl->fetchCurl("/getUserCategories/".$cate."/".$this->Auth->user("userId")."/".$isMentor);
		$this->set("aCategories",$result);


	}



	public  function getHobbies(){
		//get user mapped ambitions
		$cate = 2; //hobbies
		$isMentor = 0;//user 0- mentor
		$result = $this->Curl->fetchCurl("/getUserCategories/".$cate."/".$this->Auth->user("userId")."/".$isMentor);
		$this->set("hCategories",$result);


	}



	public function image_crop($filename, $dimensions,$user_id) {

		debug("inside crop images".PROFILE_IMAGE_PATH.$filename);
		$filepath = PROFILE_IMAGE_PATH.'process/'.$filename;
		$file = WWW_ROOT .$filepath;
		$ini_filename = WWW_ROOT .$filepath;
		$ext = pathinfo($file, PATHINFO_EXTENSION);
		if ($ext == 'png' || $ext == 'PNG') {
			$imgFormat = imagecreatefrompng($ini_filename);
		}
		if ($ext == 'jpeg' || $ext == 'JPEG' || $ext == 'JPG' || $ext == 'jpg') {
			$imgFormat = imagecreatefromjpeg($ini_filename);
		}
		if ($ext == 'gif' || $ext == 'JIF') {
			$imgFormat = imagecreatefromgif($ini_filename);
		}
		if ($ext == 'bmp' || $ext == 'BMP') {
			$imgFormat = imagecreatefromwbmp($ini_filename);
		}
		$img_xy = getimagesize($ini_filename);
		$img_x = $img_xy[0];
		$img_y = $img_xy[1];
		//ratio change
		$x_ratio = 1;
		$y_ratio = 1;
		if (intval($img_x) > 600) {
			$x_ratio = $img_x / 600;
		}
		if (intval($img_y) > 600) {
			$y_ratio = $img_y / 600;
		}
		if ($x_ratio > $y_ratio) {
			$y_ratio = $x_ratio;
		} else {
			$x_ratio = $y_ratio;
		}
		$x = $dimensions['x'];
		$y = $dimensions['y'];
		$w = $dimensions['w'];
		$h = $dimensions['h'];
		//the minimum of xlength and ylength to crop.
		$crop_measure = min(60, 60); //image size needed -constant
		// Set the content type header - in this case image/jpeg
		//header('Content-Type: image/jpeg');
		$to_crop_array = array('x' => intval($x * $x_ratio), 'y' => intval($y * $y_ratio), 'width' => intval($w * $x_ratio), 'height' => intval($h * $y_ratio));
		$thumb_im = imagecrop($imgFormat, $to_crop_array);
		$this_user_pic = 'user_profile_crop' .$this->Auth->user('id') .time() . '.jpeg';
		imagejpeg($thumb_im, PROFILE_IMAGE_PATH.'process/' . $this_user_pic, 100);


		$original_img = imagecreatefromjpeg(PROFILE_IMAGE_PATH.'process/' . $this_user_pic);
		$original_info = getimagesize(PROFILE_IMAGE_PATH.'process/' . $this_user_pic);
		$original_w = $original_info[0];
		$original_h = $original_info[1];
		//mid size
		$thumb_w_mid = PROFILE_IMAGE_MEDIUM;
		$thumb_h_mid = PROFILE_IMAGE_MEDIUM;
		//sml size
		$thumb_w_sml = PROFILE_IMAGE_SMALL;
		$thumb_h_sml = PROFILE_IMAGE_SMALL;
		$thumb_img_mid = imagecreatetruecolor($thumb_w_mid, $thumb_h_mid);
		$thumb_img_sml = imagecreatetruecolor($thumb_w_sml, $thumb_h_sml);
		$img_db_name = 'Avathar_' .$this->Auth->user('id') .time();
		//med icon
		imagecopyresampled($thumb_img_mid, $original_img, 0, 0, 0, 0, $thumb_w_mid, $thumb_h_mid, $original_w, $original_h);
		$pic_name_mid = $img_db_name. '_mid.jpeg';
		imagejpeg($thumb_img_mid, PROFILE_IMAGE_PATH.'user_pic/' . $pic_name_mid);
		//small icon
		imagecopyresampled($thumb_img_sml, $original_img, 0, 0, 0, 0, $thumb_w_sml, $thumb_h_sml, $original_w, $original_h);
		$pic_name_mid = $img_db_name. '_sml.jpeg';
		imagejpeg($thumb_img_sml, PROFILE_IMAGE_PATH.'user_pic/' . $pic_name_mid);
		if(file_exists(WWW_ROOT . $filepath)){
			unlink(WWW_ROOT . $filepath);
		}
		if(file_exists(WWW_ROOT . PROFILE_IMAGE_PATH.'process/' . $this_user_pic)){
			unlink(WWW_ROOT . PROFILE_IMAGE_PATH.'process/' . $this_user_pic);
		}
		imagedestroy($thumb_img_mid);
		imagedestroy($thumb_img_sml);
		imagedestroy($original_img);


		/*
         * save to da $img_db_name
         */

		$result = $this->Curl->fetchCurl("/addUserProfilePic/".$img_db_name."/".$user_id);
		$result = $this->Curl->fetchCurl("/getFriendStatus/".$img_db_name."/".$user_id);
		//debug("/groupProfilePic/".$img_db_name."/".$this->Auth->user("userId"));die();


		return $img_db_name;
	}

	public function friend_status($user_id) {

if($this->Auth->user("userId") != $user_id){

	$status = $this->Curl->fetchCurl("/userUserStatus/".$this->Auth->user("userId")."/".$user_id);
	return $status;
}
		return array();


	}



}

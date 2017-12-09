<?php
App::uses('App\Controller\AppController', 'controller', 'User');


class MentorController extends AppController
{

	public $components = array('Session', 'Curl', 'Paginator','Crop');

	private $mentorId = 0;

	public $uses = array('Post');

	public function beforeFilter()
	{
		parent::beforeFilter();


		$this->setJsVar('user_id', $this->Auth->user('userId'));
		$this->setJsVar('wall_id', $this->Auth->user('userId'));
		$this->setJsVar('is_mentor', 1);

		$this->setJsVar('wall_type', 3);
		$this->setJsVar('vertical_id',1);

		if(!$this->Auth->user("id")){
			$this->redirect(
				array('controller' => 'users', 'action' => 'logout')
			);

		}

		$this->mentorId = $this->Auth->user("userId");
		if(isset($this->request->params['id'])){

			$this->mentorId = $this->request->params['id'];
		}
		$this->setJsVar('wall_id', $this->mentorId);
		$this->set('pageUser', $this->mentorId);

		$role = $this->getMentorVisitorRelation($this->mentorId,$this->Auth->user("userId"));
		$this->set("role",$role);
		$this->role = $role;
		$this->Session->write('Auth.User.role', $role);//will change
		$action = $this->request->params['action'];
		$this->set('action',$action);

	}

	public function isAuthorized($user) {


		switch ($this->action) {
			case 'media':
			case 'video':
			case 'audio':
			case 'text':
			case 'wall':
			case 'protege':
			case 'profile':
			case 'achievement':
			case 'mentor_profile':
			case 'about':
			case 'education':
			case 'experience':
			case 'award':
			case 'certification':
				return true;
				break;

			case 'talk':
			case 'users':

				if($user['role']==1 || $user['role']==2 ){
					return true;
				}
				$this->redirect(array('action' => 'about'));
				return false;
				break;



			case 'updateGroupDescription':
			case 'profile_photo':
			case 'users':
			case 'setting':
			case 'remove_post_ajax':
				if($user['role']==1){
					return true;
				}

				$this->redirect(array('controller' => 'mentor','action' => $this->request->params['id'],'about'));

				return false;
				break;
			default:
				return false;
		}


		return parent::isAuthorized($user);
	}




	public function profile()
	{

		$this->layout = 'mentor';

		$this->getMentorPageBasics($this->mentorId,$this->Auth->user("userId"));

		//get wall posts

		$isAdmin = 0;

		if($this->Auth->user("userId") == $this->mentorId){
			$isAdmin = 1;

		}


		$this->loadModel('Mentor');

		$this->Paginator->settings = array('limit' => 1);


		$data = $this->paginate('Mentor');

		$this->set('userPosts',$data);

	}

	public function about(){

		$this->layout = 'mentor_visitor';

		$this->getMentorPageBasics($this->mentorId,$this->Auth->user("userId"));




		$url1="/userEducation/".$this->mentorId;
		$json_array = $this->Curl->fetchCurl($url1);

		$this->set('educations',$json_array);


		$url1 = "/getUserExperience/" . $this->mentorId;
		$experience = $this->Curl->fetchCurl($url1);

		$this->set('experience', $experience);



	}


	public function wall(){

		$this->layout = 'mentor_visitor';

		$this->getMentorPageBasics($this->mentorId,$this->Auth->user("userId"));




		$this->loadModel('Mentor');

		$this->Paginator->settings = array('limit' => 1);


		$data = $this->paginate('Mentor');

		$this->set('userPosts',$data);
		//debug($data);

	}


	public function achievement(){

		$this->layout = 'mentor_visitor';
		$this->setJsVar('wall_type', 4);

		$this->getMentorPageBasics($this->mentorId,$this->Auth->user("userId"));


		$this->loadModel('MentorAchieve');

		$this->Paginator->settings = array('limit' => 1);


		$data = $this->paginate('MentorAchieve');

		$this->set('userPosts',$data);

	}


	public function protege(){

		$this->layout = 'mentor_visitor';

		$this->getMentorPageBasics($this->mentorId,$this->Auth->user("userId"));




	}


	public function about_() {

		$this->layout = 'mentort2';

		$this->set('user_id', $this->mentorId);
		$this->setJsVar('wall_id', $this->mentorId);
		$this->setJsVar('user_id', $this->Auth->user('userId'));

		$this->getMentorPageBasics($this->mentorId,$this->Auth->user("userId"));

	}



	public function education() {
		$this->layout = 'mentort2';

		$this->getMentorPageBasics($this->mentorId,$this->Auth->user("userId"));

		$this->set('user_id', $this->mentorId);
		$url1="/userEducation/".$this->mentorId;
		$json_array = $this->Curl->fetchCurl($url1);

		$this->set('educations',$json_array);


	}

	public function experience() {

		$this->layout = 'mentort2';
		$this->getMentorPageBasics($this->mentorId,$this->Auth->user("userId"));

		$url1 = "/getUserExperience/" . $this->mentorId;
		$experience = $this->Curl->fetchCurl($url1);

		$this->set('experience', $experience);
		$this->set('user_id', $this->mentorId);

	}

	public function users() {

		$this->layout = 'mentorU';
		$this->getMentorPageBasics($this->mentorId,$this->Auth->user("userId"));




		$url1="/userEducation/".$this->mentorId;
		$json_array = $this->Curl->fetchCurl($url1);

		$this->set('educations',$json_array);

		$url1 = "/getUserExperience/" .$this->mentorId;
		$experience = $this->Curl->fetchCurl($url1);
		$this->set('experience', $experience);

	}

	public function award() {

		$this->layout = 'mentort2';
		$this->getMentorPageBasics($this->mentorId,$this->Auth->user("userId"));

		$url1 = "/getAward/" . $this->mentorId;
		$awards = $this->Curl->fetchCurl($url1);
		$this->set('awards', $awards);
		$this->set('user_id', $this->mentorId);





	}

	public function certification() {

		$this->layout = 'mentort2';
		$this->getMentorPageBasics($this->mentorId,$this->Auth->user("userId"));


		$url1 = "/getCert/" . $this->mentorId;
		$certification = $this->Curl->fetchCurl($url1);
		$this->set('certification', $certification);
		$this->set('user_id', $this->mentorId);

	}


	public function talk() {

		if($this->role==1){
			$this->layout = 'mentor_talk';
		}else{
			$this->layout = 'mentor_visitor';
		}


		$this->getMentorPageBasics($this->mentorId,$this->Auth->user("userId"));
		$mentiId = $this->mentorId;
		$vitorId = $this->Auth->user('id');

		if(isset($this->request->params["pass"][0])){

			$vitorId = $this->request->params["pass"][0];


			$this->loadModel('MentorTalk');

			$this->Paginator->settings = array('limit' => 1);

			$data = $this->paginate('MentorTalk');
			//debug($data);

			$this->setJsVar("wall_id",$vitorId);
			$this->setJsVar("user_id",$mentiId);
			$hasMenti = true;
		}else{
			$data = array();
			$hasMenti = false;

		}

		$this->set("mentiId",$mentiId);
		$this->set('userPosts',$data);
		$this->set("hasMenti",$hasMenti);



	}


	public  function media(){

		$this->layout = 'mentor_visitor';
		$this->getMentorPageBasics($this->mentorId,$this->Auth->user("userId"));


		$type = 2;
		$page = 1;
		if(isset($this->request->params['named']['page'])){

			$page = $this->request->params['named']['page'];
		}
		$this->set("page",$page);

		$url1 = "/getMentorMediaPostCount/".$this->mentorId."/$type";
		$imageCount =  $this->Curl->fetchCurl($url1);


		$url = "/getMentorMediaPost/".$this->mentorId."/".$this->Auth->user("userId")."/$type/$page";
		$images =  $this->Curl->fetchCurl($url);
		$this->set("img",$images);

		$indexCount = (int) ($imageCount/10);
		if(($imageCount%10) > 0){

			$indexCount++;
		}
		$this->set('indexCount',$indexCount);

	}


	public  function video(){

		$this->layout = 'mentor_visitor';
		$this->getMentorPageBasics($this->mentorId,$this->Auth->user("userId"));


		$type = 3;
		$page = 1;
		if(isset($this->request->params['named']['page'])){

			$page = $this->request->params['named']['page'];
		}
		$this->set("page",$page);

		$url1 = "/getMentorMediaPostCount/".$this->mentorId."/$type";
		$imageCount =  $this->Curl->fetchCurl($url1);


		$url = "/getMentorMediaPost/".$this->mentorId."/".$this->Auth->user("userId")."/$type/$page";
		$images =  $this->Curl->fetchCurl($url);
		$this->set("img",$images);

		$indexCount = (int) ($imageCount/10);
		if(($imageCount%10) > 0){

			$indexCount++;
		}
		$this->set('indexCount',$indexCount);

	}


	public  function audio(){

		$this->layout = 'mentor_visitor';
		$this->getMentorPageBasics($this->mentorId,$this->Auth->user("userId"));


		$type = 5;
		$page = 1;
		if(isset($this->request->params['named']['page'])){

			$page = $this->request->params['named']['page'];
		}
		$this->set("page",$page);

		$url1 = "/getMentorMediaPostCount/".$this->mentorId."/$type";
		$imageCount =  $this->Curl->fetchCurl($url1);


		$url = "/getMentorMediaPost/".$this->mentorId."/".$this->Auth->user("userId")."/$type/$page";
		$images =  $this->Curl->fetchCurl($url);
		$this->set("img",$images);

		$indexCount = (int) ($imageCount/10);
		if(($imageCount%10) > 0){

			$indexCount++;
		}
		$this->set('indexCount',$indexCount);

	}
	public  function text(){

		$this->layout = 'mentor_visitor';
		$this->getMentorPageBasics($this->mentorId,$this->Auth->user("userId"));


		$type = 4;
		$page = 1;
		if(isset($this->request->params['named']['page'])){

			$page = $this->request->params['named']['page'];
		}
		$this->set("page",$page);

		$url1 = "/getMentorMediaPostCount/".$this->mentorId."/$type";
		$imageCount =  $this->Curl->fetchCurl($url1);


		$url = "/getMentorMediaPost/".$this->mentorId."/".$this->Auth->user("userId")."/$type/$page";
		$images =  $this->Curl->fetchCurl($url);
		$this->set("img",$images);

		$indexCount = (int) ($imageCount/10);
		if(($imageCount%10) > 0){

			$indexCount++;
		}
		$this->set('indexCount',$indexCount);

	}




	public function setting() {

		$this->layout = 'mentor_visitor';



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

				$pic_name = $this->Crop->profile_crop($file_name, $this->request->data['User'],$this->request->param('groupName'));

				$csuccess = $this->Curl->putCurl(PROFILE_IMAGE_PATH.'process/'.$pic_name);

				if($csuccess){
					unlink(PROFILE_IMAGE_PATH.'process/'.$pic_name);
					unlink(PROFILE_IMAGE_PATH.'process/'.$file_name);
				}else{
					$csuccess = $this->Curl->putCurl(PROFILE_IMAGE_PATH.'process/'.$pic_name);
					if($csuccess){unlink(PROFILE_IMAGE_PATH.'process/'.$pic_name);}
				}

				$result = $this->Curl->fetchCurl("/addUserProfilePic/".$pic_name."/".$this->mentorId);



				$this->set('avathar' , $pic_name);


			}
		}
$this->getExpertise();

		$this->getMentorPageBasics($this->mentorId,$this->Auth->user("userId"));


	}


	public function image_crop($filename, $dimensions,$group_id) {


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

		$result = $this->Curl->fetchCurl("/addUserProfilePic/".$img_db_name."/".$this->Auth->user("userId"));
		//debug("/groupProfilePic/".$img_db_name."/".$this->Auth->user("userId"));


		return $img_db_name;
	}



	public function getMentorPageBasics($mId,$vId){

		$url = "/mentorBaseData/".$mId."/".$vId;


		$pageBase =  $this->Curl->fetchCurl($url);
		//debug($pageBase);

		$this->set('userDetails',$pageBase->userDetails);
		//debug($pageBase->userDetails);

		$this->set('menti',$pageBase->followers);
		//debug($pageBase->followers);

		$this->set('sidePosts',$pageBase->sidePosts);
		//debug($pageBase->sidePosts);

		$this->set('userMentors',$pageBase->mentorList);


		$this->set('userMentorSuggections',$pageBase->suggection);




		if($vId == $mId){
			//get others rating on me
			$url3="/getUserRating/".$mId;

		}else{
			//find my rating on him
			$url3="/getUserUserRating/".$mId."/".$vId;
		}

		$rate = $this->Curl->fetchCurl($url3);

		$this->set('userRating',$rate);

		$cid = $pageBase->userDetails->country;
		$url = "/getUserCountry/" . $cid;

		$getUserCountry = $this->Curl->fetchCurl($url);

		$this->set('country', $getUserCountry[0]);

	}

	private function getMentorPost($mId,$vId,$isAdmin){

		$fromId = 0;
		$url = "/getMentorWallPost/".$mId."/".$vId."/".$fromId."/1";


		return $this->Curl->fetchCurl($url);


		//debug($wallPost);
	}

	private function getMentorVisitorRelation($mentor,$visitor){

		if($mentor === $visitor){
			return 1;
		}

		$url = "/getMentorUserRelation/".$mentor."/".$visitor;
		return $this->Curl->fetchCurl($url);
	}

	public  function getExpertise(){
		//get user mapped ambitions
		$cate = 1; //hobbies
		$isMentor = 1;//user 0- mentor
		$result = $this->Curl->fetchCurl("/getUserCategories/".$cate."/".$this->Auth->user("userId")."/".$isMentor);
		$this->set("allCategories",$result);


	}



}

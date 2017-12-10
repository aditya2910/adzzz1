<?php
App::uses('AppController', 'Controller');
/**
 * Groups Controller
 *
 * @property Group $Group
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 */
class GroupsController extends AppController {

/**
 * Components
 *
 * @var array
 */
	public $components = array('Session', 'Curl', 'Paginator','Crop');



        public function beforeFilter() {
            parent::beforeFilter();
            $this->setJsVar('wall_type',2);
            $this->setJsVar('vertical_id',1);
			$this->setJsVar('wall_id',$this->request->param('groupName'));

			if(!$this->Auth->user("id")){
				$this->redirect(
					array('controller' => 'users', 'action' => 'logout')
				);

			}

			$userGroupRole = 0;
			if(!empty($this->request->param('groupName'))){

				//debug(" id is = ".$this->Auth->user("id") ."  name = ".  $this->request->param('groupName'));

				$userGroupStatus = $this->getUserRole($this->Auth->user("id"),$this->request->param('groupName'));

				$userGroupRole = $userGroupStatus->roleId;
				$userStatus = $userGroupStatus->status;

			}



			$this->set("groupCName",$this->request->param('groupName'));


			$this->set("userGroupRole",$userGroupRole);


			$this->Session->write('Auth.User.role', $userGroupRole);

			$Gbutton = 'Leave Group';

			if($userGroupRole == 3 || $userGroupRole == 0){
				//admin or member
				$Gbutton = "Join Group";
				if($userGroupRole == 3 ){
					if($userStatus == 4 ){
						//user req to join
						$Gbutton = "Cancel Join Request";
					}
					if($userStatus == 5 ){
						//user req to join
						$Gbutton = "Accept Join Request";
					}

				}


			}

			$this->set('Gbutton',$Gbutton);
        }


		public function isAuthorized($user) {

			switch ($this->action) {
				case 'about':
				case 'getUserRole':
					return true;
			break;
				case 'wall':
				case 'images':
				case 'videos':
				case 'documents':
				case 'audio':


				if($user['role']==1 || $user['role']==2 ){
					return true;
				}
				$this->redirect(array('action' => 'about'));
				return false;
			break;

				case 'more':
				case 'updateGroupName':
				case 'updateGroupDescription':
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




		public function about(){

			$this->layout = 'group_layout';


			try {
				$json = $this->getGroupAbout($this->request->param('groupName'), $this->Auth->user("id"));

				}catch(Exception $e){

				debug("error in getting page json"+$e->getMessage());
			}

			$this->set('userMentors',$json->mentorList);
			$this->set('userGroups',$json->userGroups);
			$this->set('userFriends',$json->frindList);
			$this->set('groupDetail',$json->groupDetail);
			$this->set('groupMembers',$json->groupMembers);
			$this->set('groupMemberRequest',$json->groupMemberRequest);
			$this->set('connectedGroups',$json->connectedGroups);
			$this->set('userGroupRole',$json->userGroupRole);


		}




		public function wall(){

			$this->layout = 'group_layout';



			try{
				$json = $this->getGroupWall($this->request->param('groupName'), $this->Auth->user("id"));



		   }catch(Exception $e){

				debug("error in getting page json"+$e->getMessage());
			}
			$this->set('userGroupRole',$json->userGroupRole);
			if($json->userGroupRole == 1 || $json->userGroupRole == 2){

			$this->set('userMentors',$json->mentorList);
			$this->set('userGroups',$json->userGroups);
			$this->set('userFriends',$json->frindList);
			$this->set('groupDetail',$json->groupDetail);
			//$this->set('userPosts',$json->groupPosts);

			}

			$this->Paginator->settings = array('limit' => $this->Auth->user('id'));
			$this->loadModel("MyGroup");

			$data = $this->paginate('MyGroup');

			$this->set('userPosts',$data);


		}


		public function images() {

			$this->layout = 'group_layout';

			try{
				//2- images
				$json = $this->getGroupMedia($this->request->param('groupName'), $this->Auth->user("id"),2);
			}catch(Exception $e){

				debug("error in getting page json"+$e->getMessage());
			}
			$this->set('userMentors',$json->mentorList);
			$this->set('userGroups',$json->userGroups);
			$this->set('userFriends',$json->frindList);
			$this->set('groupDetail',$json->groupDetail);
			$this->set('imageArray',$json->groupPosts);
			$this->set('userGroupRole',$json->userGroupRole);



		}

	public function videos(){
		$this->layout = 'group_layout';

		try{
			//3- images
			$json = $this->getGroupMedia($this->request->param('groupName'), $this->Auth->user("id"),3);

		}catch(Exception $e){

			debug("error in getting page json"+$e->getMessage());
		}
		$this->set('userMentors',$json->mentorList);
		$this->set('userGroups',$json->userGroups);
		$this->set('userFriends',$json->frindList);
		$this->set('groupDetail',$json->groupDetail);
		$this->set('videoArray',$json->groupPosts);
		$this->set('userGroupRole',$json->userGroupRole);


	}


	public function documents(){
		$this->layout = 'group_layout';

		try{
			//4- images
			$json = $this->getGroupMedia($this->request->param('groupName'), $this->Auth->user("id"),4);

		}catch(Exception $e){

			debug("error in getting page json"+$e->getMessage());
		}
		$this->set('userMentors',$json->mentorList);
		$this->set('userGroups',$json->userGroups);
		$this->set('userFriends',$json->frindList);
		$this->set('groupDetail',$json->groupDetail);
		$this->set('docArray',$json->groupPosts);
		$this->set('userGroupRole',$json->userGroupRole);
	}

	public function audio(){
		$this->layout = 'group_layout';

		try{
			$json = $this->getGroupMedia($this->request->param('groupName'), $this->Auth->user("id"),5);
		}catch(Exception $e){

			debug("error in getting page json"+$e->getMessage());
		}
		$this->set('userMentors',$json->mentorList);
		$this->set('userGroups',$json->userGroups);
		$this->set('userFriends',$json->frindList);
		$this->set('groupDetail',$json->groupDetail);
		$this->set('audioArray',$json->groupPosts);
		$this->set('userGroupRole',$json->userGroupRole);


	}


	public function more(){
		$this->layout = 'group_layout';



		if($this->request->is('post')) {
			//debug($this->request->data);die();
			// is file uploaded by http post
			if (!empty($this->request->data['Group']['file']['tmp_name']) && is_uploaded_file($this->request->data['Group']['file']['tmp_name'])) {
				$allowedExts = array("image/gif", "image/jpeg", "image/jpg", "image/png", "image/JPG", "image/JPEG");
				$temp = explode(".", $this->request->data['Group']['file']["name"]);
				$extension = end($temp);
				$file_type = $this->request->data['Group']['file']["type"];
				if(!in_array($file_type, $allowedExts)){
					$this->Flash->success(__('The file type is not supported.'));
					return $this->redirect(['action' => 'profile_photo']);
				}
				if($this->data['Group']['file']["error"] > 0){
					$this->Flash->success(__($this->data['file']["error"]));
					return $this->redirect(['action' => 'profile_photo']);
				}
				$file_name = 'Profile_uploaded_pic'.$this->Auth->user('id') . time() . '.' . $extension;
				if (file_exists(PROFILE_IMAGE_PATH.'process/'.$file_name)){
					$this->Flash->success(__('File already exits'));
					return $this->redirect(['action' => 'profile_photo']);
				}
				$moved = move_uploaded_file($this->request->data['Group']['file']["tmp_name"], PROFILE_IMAGE_PATH.'process/'.$file_name);
				if(!$moved){
					$this->Flash->success(__('File can\'t be moved'.PROFILE_IMAGE_PATH.'process/'.$file_name));
					return $this->redirect(['action' => 'profile_photo']);
				}
				//debug($file_name);
				//debug($this->request->data['Group']);
				$picName = $this->Crop->profile_crop($file_name, $this->request->data['Group'],$this->request->param('groupName'));

				//$pic_name = $this->image_crop($file_name, $this->request->data['Group'],$this->request->param('groupName'));

				$csuccess = $this->Curl->putCurl(PROFILE_IMAGE_PATH.'process/'.$picName);

				if($csuccess){
					unlink(PROFILE_IMAGE_PATH.'process/'.$picName);
					unlink(PROFILE_IMAGE_PATH.'process/'.$file_name);
				}else{
					$csuccess = $this->Curl->putCurl(PROFILE_IMAGE_PATH.'process/'.$picName);
					if($csuccess){unlink(PROFILE_IMAGE_PATH.'process/'.$picName);}
				}

				//save to db
				$result = $this->Curl->fetchCurl("/groupProfilePic/" . $picName."/".$this->request->param('groupName'));



			}
		}



		try{
			$json = $this->getGroupWall($this->request->param('groupName'), $this->Auth->user("id"));

			}catch(Exception $e){

			debug("error in getting page json"+$e->getMessage());
		}
		$this->set('userMentors',$json->mentorList);
		$this->set('userGroups',$json->userGroups);
		$this->set('userFriends',$json->frindList);
		$this->set('groupDetail',$json->groupDetail);
		$this->set('userGroupRole',$json->userGroupRole);


	}


		private function getGroupAbout($groupCustomName,$userId){

			try {
				//debug("/getGroupAbout/" . $groupCustomName."/".$userId);
				$result = $this->Curl->fetchCurl("/getGroupAbout/" . $groupCustomName."/".$userId);
			}catch(Exception $e){
				debug("error in feching about group page json".$e->getMessage());
			}

			return $result;
		}


		private function getGroupWall($groupCustomName,$userId){

			try {
				$result = $this->Curl->fetchCurl("/getGroupWall/" . $groupCustomName."/".$userId."/0");

			}catch(Exception $e){
				debug("error in feching wall group page json".$e->getMessage());
			}

			return $result;
		}

		private function getGroupMedia($groupCustomName,$userId,$mediaType){

			try {
				$result = $this->Curl->fetchCurl("/getGroupMedia/" . $groupCustomName."/".$userId."/".$mediaType."/0");
			}catch(Exception $e){
				debug("error in feching wall group page json".$e->getMessage());
			}

			return $result;
		}

	public function searchGroup(){
		$this->autoRender=FALSE;
		if($this->request->isPost()){
			$gids = array();
			$groupjson = array();
			$myCont = $this->requestAction('groups/get_connected_groups/'.$this->request->data['groupId']);
			foreach($myCont as $cnts){
				$gids[] = $cnts['Group']['id'];
			}

			$this->Group->recursive = 0;
			$groups = $this->Group->find('all',array(
				'conditions' => array(
					'AND' => array(
						'Group.id !=' =>  $gids,
						'Group.status' => 1,
						'Group.name LIKE' => '%'.$this->request->data['searchText'].'%'
					)
				),
				'fields' => array(
					'Group.id','Group.name','Group.description','UserGroupProfilePic.link'
				)
			));
			foreach($groups as $index => $g){
				$auto = array(
					'DisplayName' => $g['Group']['name'],
					'PicLocation' => '/'.MY_APP.'/'.PROFILE_IMAGE_PATH_FINAL.$g['UserGroupProfilePic']['link'].'_sml.jpeg',
					'Reputation' => ' reput',
					'UserUniqueid' => $g['Group']['id'],
				);
				$groupjson[]=$auto;
			}
			echo json_encode($groupjson);
		}
	}


	public function updateGroupName(){


		$this->autoRender = FALSE;

		if ($this->request->is('ajax')) {

			$url = "/updatGroupName";

			$data = $this->request->data;
			debug($data);

			$this->Curl->postHttpCurl($url,$data);


		}
	}

	public function updateGroupDescription(){


		$this->autoRender = FALSE;

		if ($this->request->is('ajax')) {

			$url = "/updateGroupDesciption";

			$data = $this->request->data;

			$this->Curl->postHttpCurl($url,$data);


		}
	}

	public function getUserRole($userId,$groupCusName){

			try {
				$result = $this->Curl->fetchCurl("/userGroupRole/".$userId."/".$groupCusName);

			}catch(Exception $e){
				debug("error in feching user role ".$e->getMessage());
			}

	return $result;
	}




	public function image_crop($filename, $dimensions,$group_id) {

		//debug("inside crop images".PROFILE_IMAGE_PATH.$filename);
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


		$result = $this->Curl->fetchCurl("/groupProfilePic/" . $img_db_name."/".$this->request->param('groupName'));



		return $img_db_name;
	}







}

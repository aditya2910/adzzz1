<?php
App::uses('AppController', 'Controller');
/**
 * UserMentorRatings Controller
 *
 * @property UserMentorRating $UserMentorRating
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 */
class UserMentorRatingsController extends AppController {

/**
 * Components
 *
 * @var array
 */
	public $components = array('Paginator', 'Session','Curl');

	public function isAuthorized($user) {

		switch ($this->action) {
			case 'index':

				return true;
				break;
			case 'rate':
			case 'add':

				if($user['role']==1 || $user['role']==2 ){
					return true;
				}

				return false;
				break;

			case 'more':

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


	public function rate() {
		$this->autoRender = FALSE;
		if($this->request->is('ajax')){


			$this->request->data['user_id'] = $this->Auth->user("id");
			$this->request->data['mentor_id'] =  $this->Session->read('Page.wallId');

			$id = $this->Auth->user("id");
			$url1 = "/checkMentorRating/" . $id;
			$checkfollow = $this->Curl->fetchCurl($url1);
			debug($checkfollow);
			$status ['success'] = FALSE;




			if ($checkfollow[0]->id != null) {


				$url = "/reRating";
				$data = $this->request->data;

				debug($data);
				$status = $this->Curl->postHttpCurl($url,$data);
			}

			else
			{

				$url = "/addRating";
				$data = $this->request->data;
				debug($data);
				$status = $this->Curl->postHttpCurl($url,$data);
			}









		}



		return json_encode($status);
	}


	public function add(){
		$this->autoRender = false;
		if($this->request->is("POST")){

			$url = '/addUserRating/'.$this->request->data['userId'].'/'.$this->Auth->user("userId").'/'.$this->request->data['rate'];
			debug($url);
			$status = $this->Curl->fetchCurl($url);
		}

	}

}

<?php
App::uses('AppController', 'Controller');
/**
 * UserPostViews Controller
 *
 * @property UserPostView $UserPostView
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 */
class UserProfileStatusController extends AppController {

/**
 * Components
 *
 * @var array
 */

	public $components = array('Session','Curl');

	public function isAuthorized($user) {

		switch ($this->action) {
			case 'add_status':
				return true;
				break;

			case 'add':



				if($user['role']==1 || $user['role']==2 ){
					return true;
				}
				$this->redirect(array('action' => 'about'));
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


	public function add_status() {
		$this->autoRender = FALSE;
		if($this->request->is('ajax')){


			$this->request->data['user_id'] = $this->Auth->user("userId");
			$url = "/userStatus";
			$data = $this->request->data;
			debug($data);

			$status = $this->Curl->postHttpCurl($url,$data);


		}

		return json_encode($status);
	}

}

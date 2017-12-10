<?php
App::uses('AppController', 'Controller');
/**
 * UserMentorFollowers Controller
 *
 * @property UserMentorFollower $UserMentorFollower
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 */
class UserMentorFollowersController extends AppController {

/**
 * Components
 *
 * @var array

 */

	public $components = array('Session', 'Curl');
	public function beforeFilter()
	{
		parent::beforeFilter();


		$this->setJsVar('user_id', $this->Auth->user('id'));

		$this->Session->write('Auth.User.role', 1);

	}




	public function remove()
	{
		$this->autoRender = FALSE;
		if ($this->request->is('ajax')) {


			$status['success'] = FALSE;

			$url = "/unFollow";
			$data = $this->request->data;


			$status = $this->Curl->postHttpCurl($url, $data);

		}


		return json_encode($status);

	}

	public function add() {
		$this->autoRender = FALSE;
		if($this->request->is('ajax')){



            $id = $this->Auth->user("id");

			$status['success'] = FALSE;

			$role = $this->getMentorVisitorRelation($this->request->data["mentor_id"] , $this->request->data["user_id"]);


			if ($role == 1) {
				$url = "/reFollow";
				$data = $this->request->data;
				$status = $this->Curl->postHttpCurl($url,$data);
			}

			else
			{

				$url = "/addFollow";
				$data = $this->request->data;

				$status = $this->Curl->postHttpCurl($url,$data);
			}



		}



		return json_encode($status);
	}


	private function getMentorVisitorRelation($mentor,$visitor){

		if($mentor === $visitor){debug($mentor." ".$visitor);
			return 1;

		}

		$url = "/checkMentorFollow/".$mentor."/".$visitor;
		return $this->Curl->fetchCurl($url);
	}

}

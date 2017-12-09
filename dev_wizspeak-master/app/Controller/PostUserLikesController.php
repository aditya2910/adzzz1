<?php
App::uses('AppController', 'Controller');
/**
 * PostUserLikes Controller
 *
 * @property PostUserLike $PostUserLike
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 */
class PostUserLikesController extends AppController {

/**
 * Components
 *
 * @var array
 */
	public $components = array('Paginator', 'Session', 'Log','Curl');



	public function isAuthorized($user) {

		switch ($this->action) {
			case 'xxxxxxxxxx':
				return true;
				break;

			case 'add':
			case 'remove':

				if($user['role']==1 || $user['role']==2 ){
					return true;
				}
				$this->redirect(array('action' => 'about'));
				return false;
				break;



			case 'add':
			case 'remove':
				if($user['role']==1){
					return true;
				}



				return false;
				break;
			default:
				return false;
		}


		return parent::isAuthorized($user);
	}


        public function add() {
            $this->autoRender = FALSE;
            if($this->request->is('ajax')){


				$this->request->data['user_id'] = $this->Auth->user("id");
				$url = "/addLike";
				$data = $this->request->data;
				$status = $this->Curl->postHttpCurl($url,$data);


            }

            return json_encode($status);
        }


        public function remove() {
            $this->autoRender = FALSE;
            if($this->request->is('ajax')){

				$this->request->data['user_id'] = $this->Auth->user("id");
                $status['post_id'] = $this->request->data['item_id'];
                $status['success'] = FALSE;

				$url = "/removeLike";
				$data = $this->request->data;
				$status = $this->Curl->postHttpCurl($url,$data);

            }



            return json_encode($status);
        }

}

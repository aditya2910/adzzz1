<?php
App::uses('AppController', 'Controller');
/**
 * PostUserComments Controller
 *
 * @property PostUserComment $PostUserComment
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 */
class PostUserCommentsController extends AppController {

/**
 * Components
 *
 * @var array
 */
	public $components = array('Paginator', 'Session', 'Log', 'Curl');

	public function isAuthorized($user) {

		switch ($this->action) {
			case 'get_more_comments':
			case 'latest_cmt':
			case 'replaceURLWithHTMLLinks':

				return true;
				break;

			case 'add_comment':



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

        public function add_comment() {

            $this->autoRender = false;
            if($this->request->is('ajax')){
                $status['success'] = FALSE;
                $comments = $this->replaceURLWithHTMLLinks($this->request->data['comment']);

                $descript_TWO = str_replace('\r\n', '<br>', $comments);
                $this->request->data['comment'] = $comments;
                $this->request->data['user_id'] = $this->Auth->user('id');
                $this->request->data['status'] = 1;
                $this->request->data['date_commented'] = date("Y-m-d H:i:s");

				$url="/addComment";
				$data = $this->request->data;
				$status = $this->Curl->postHttpCurl($url,$data);


                return json_encode($status);
            }
        }


        public function get_more_comments() {

            $this->layout = 'ajax';
            if($this->request->is('POST')){

				$url = "/getMoreComments";
				$data = $this->request->data;
				$data['user_id'] = $this->Auth->user("id");

				$status = $this->Curl->postHttpCurl($url,$data);

				$this->set("cmt",$status);

				//return json_encode($status);
            }
        }





        public function replaceURLWithHTMLLinks($text) {

            $atext = preg_replace("@((https?://)?([-\w]+\.[-\w\.]+)\w(:\d+)?(/([-\w/_\.\,]*(\?\S+)?)?)*)@", "<a target='_blank' href='$1'>$1</a>", $text);
            // echo $atext;

            $a = htmlentities($text);


            return $a;
        }


}

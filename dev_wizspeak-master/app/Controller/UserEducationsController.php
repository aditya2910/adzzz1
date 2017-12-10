<?php
App::uses('AppController', 'Controller');

/**
 * UserEducations Controller
 *
 * @property UserEducation $UserEducation
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 */
class UserEducationsController extends AppController
{

	/**
	 * Components
	 *
	 * @var array
	 */
	public $components = array('Paginator', 'Session', 'Curl');

	public function isAuthorized($user) {

		switch ($this->action) {
			case 'replaceURLWithHTMLLinks':
			case 'error':
				return true;
				break;

			case 'nofunf':

				if($user['role']==1 || $user['role']==2 ){
					return true;
					break;
				}
				$this->redirect(array('action' => 'error'));
				return false;
				break;

			case 'add':
			case 'edit':
			case 'delete':

				if($user['role']==1){
					return true;
				}
			$this->redirect(array('action' => 'error'));
				return false;
				break;
			default:
				return false;
		}
	}




	public function add()
	{
		$this->autoRender = FALSE;
		if ($this->request->is('ajax')) {


			$url = "/addMentorEducation";
			$from = $this->request->data['user_educations']['date_from']['year'] . '-' . $this->request->data['user_educations']['date_from']['month'] . '-01';
			$to = $this->request->data['user_educations']['date_to']['year'] . '-' . $this->request->data['user_educations']['date_to']['month'] . '-01';

			$years = $this->request->data['user_educations']['date_from']['year'].' - '.$this->request->data['user_educations']['date_to']['year'];

			$this->request->data['user_educations']['user_id'] = $this->Auth->user('id');
			$this->request->data['user_educations']['date_from'] = $from;
			$this->request->data['user_educations']['date_to'] = $to;
			$this->request->data['user_educations']['education'];
			$this->request->data['user_educations']['institute'];
			$this->request->data['user_educations']['university'];
			$data = $this->request->data['user_educations'];

			$status = $this->Curl->postHttpCurl($url, $data);
			$id= 0;

			$html= '<div class="edu-desc-row">'.
				'<div class="edu-desc-row-inner">'.
				'<div class="editPencil pencil editDummy" id="'.$id.'">&nbsp;</div>'.
				'<div class="editPencil-remove trash" data="edu"  title="Delete" id="'.$id.'">&nbsp;</div>'.



				'<h4>'.$this->request->data['user_educations']['education'].'</h4>'.
				'<p>'.$this->request->data['user_educations']['institute'].' ('.
				$this->request->data['user_educations']['university']. ' )</p>'.
				'<p>'.$years.'</p>'.
				'</div>'.
				'</div>';
			$html;
			return $html;
		}
		return false;

	}


	public function edit()
	{
		$this->autoRender = FALSE;
		if ($this->request->is('ajax')) {

			$url = "/editMentorEducation";
			$from = $this->request->data['user_education']['date_from']['year'] . '-' . $this->request->data['user_education']['date_from']['month'] . '-01';
			$to = $this->request->data['user_education']['date_to']['year'] . '-' . $this->request->data['user_education']['date_to']['month'] . '-01';

			$yearFrom = $this->request->data['user_education']['date_from']['year'];
			$yearTo = $this->request->data['user_education']['date_to']['year'];

			$this->request->data['user_education']['user_id'] = $this->Auth->user('id');
			$this->request->data['user_education']['date_from'] = $from;
			$this->request->data['user_education']['date_to'] = $to;
			$this->request->data['user_education']['education'];
			$this->request->data['user_education']['institute'];
			$this->request->data['user_education']['university'];
			$data = $this->request->data['user_education'];

			$status['id'] = $data['id'];
			$status['success'] = FALSE;

			$st = $this->Curl->postHttpCurl($url, $data);

			$status = '<h4>'.$this->request->data['user_education']['education'].'</h4>'.
				'<p>'.$this->request->data['user_education']['institute'].' ('.
				$this->request->data['user_education']['university']. ' )</p>'.
				'<p>'.$yearFrom.' - '.$yearTo;

			return $status;

		}

	}


	public function delete() {

		$this->autoRender = FALSE;
		if($this->request->is('ajax')){
			$this->request->data['user_id'] = $this->Auth->user('id');

			$data = $this->request->data;
			$status['success'] = FALSE;
			$status['id'] = $data['id'];
			$url = "/deleteMentorEducation";


			$status = $this->Curl->postHttpCurl($url,$data);


			return json_encode($status);
		}
	}


	public function error(){
		$this->autoRender = false;

		return "Not Autherized to access";
	}
}

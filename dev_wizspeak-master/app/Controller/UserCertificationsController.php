<?php
App::uses('AppController', 'Controller');
/**
 * UserCertifications Controller
 *
 * @property UserCertification $UserCertification
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 */
class UserCertificationsController extends AppController {

	/**
	 * Components
	 *
	 * @var array
	 */
	public $components = array('Paginator', 'Session','Curl');




	public function add() {
		$this->autoRender = FALSE;
		if($this->request->is('ajax')){



			$url = "/addCert";
			$years = $this->request->data['user_certifications']['date_certified']['year'];
			$from = $this->request->data['user_certifications']['date_certified']['year'].'-'.$this->request->data['user_certifications']['date_certified']['month'].'-01';


			$this->request->data['user_certifications']['user_id'] = $this->Auth->user('id');
			$this->request->data['user_certifications']['date_certified'] = $from;

			$data = $this->request->data['user_certifications'];

			$status = $this->Curl->postHttpCurl($url,$data);

			//id should be from curl
			$id = 0;

			$html= '<div class="edu-desc-row">'.
				'<div class="edu-desc-row-inner">'.
				'<div class="editPencil pencil editDummy" id="'.$id.'">&nbsp;</div>'.
				'<div class="editPencil-remove trash" data="certi"  title="Delete" id="'.$id.'">&nbsp;</div>'.

				'<h4>'.$this->request->data['user_certifications']['certification'].'</h4>'.
				'<p>'.$this->request->data['user_certifications']['authority'].'</p>'.
				'<p>'.$years.'</p>'.
				'</div>'.
				'</div>';

			return $html;

		}
		return false;

	}



	public function edit() {
		$this->autoRender = FALSE;
		if($this->request->is('ajax')){



			$url = "/editCert";
			$year = $this->request->data['user_certification']['date_certified']['year'];
			$from = $this->request->data['user_certification']['date_certified']['year'].'-'.$this->request->data['user_certification']['date_certified']['month'].'-01';


			$this->request->data['user_certification']['user_id'] = $this->Auth->user('id');
			$this->request->data['user_certification']['date_certified'] = $from;

			$data = $this->request->data['user_certification'];

			$ss = $this->Curl->postHttpCurl($url,$data);

			$status = '<h4>'.$this->request->data['user_certification']['certification'].'</h4>'.
				'<p>'.$this->request->data['user_certification']['authority'].'</p>'.
				'<p>'.$year.'</p>';

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
			$url = "/deleteCert";


			$status = $this->Curl->postHttpCurl($url,$data);


			return json_encode($status);
		}
	}
	
	


}

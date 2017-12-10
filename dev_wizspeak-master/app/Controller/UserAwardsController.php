<?php
App::uses('AppController', 'Controller');
/**
 * UserAwards Controller
 *
 * @property UserAward $UserAward
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 */
class UserAwardsController extends AppController {

	/**
	 * Components
	 *
	 * @var array
	 */
	public $components = array('Paginator', 'Session','Curl');




	public function add() {
		$this->autoRender = FALSE;
		if($this->request->is('ajax')){



			$url = "/addAward";
			$years = $this->request->data['user_awards']['date_awarded']['year'];
			$from = $this->request->data['user_awards']['date_awarded']['year'].'-'.$this->request->data['user_awards']['date_awarded']['month'].'-01';


			$this->request->data['user_awards']['user_id'] = $this->Auth->user('id');
			$this->request->data['user_awards']['date_awarded'] = $from;

			$data = $this->request->data['user_awards'];

			$status = $this->Curl->postHttpCurl($url,$data);
			$id =0;
			$html= '<div class="edu-desc-row">'.
				'<div class="edu-desc-row-inner">'.
				'<div class="editPencil pencil editDummy" id="'.$id.'">&nbsp;</div>'.
				'<div class="editPencil-remove trash" data="award"  title="Delete" id="'.$id.'">&nbsp;</div>'.


				'<h4>'.$this->request->data['user_awards']['award'].'</h4>'.
				'<p>'.$this->request->data['user_awards']['authority'].'</p>'.
				'<p>'.$years.'</p>'.
				'</div>'.
				'</div>';


			return $html;


		}


	}




	public function edit() {
		$this->autoRender = FALSE;
		if($this->request->is('ajax')){



			$url = "/editAward";
			$year = $this->request->data['user_awards']['date_awarded']['year'];
			$from = $this->request->data['user_awards']['date_awarded']['year'].'-'.$this->request->data['user_awards']['date_awarded']['month'].'-01';


			$this->request->data['user_awards']['user_id'] = $this->Auth->user('id');
			$this->request->data['user_awards']['date_awarded'] = $from;


			$data = $this->request->data['user_awards'];

			$status['id'] = $data['id'];
			$status['success'] = FALSE;




			$this->Curl->postHttpCurl($url,$data);
			//$years = $this->request->data['user_awards']['date_awarded']['year'];
			$status = '<h4>'.$this->request->data['user_awards']['award'].'</h4>'.
				'<p>'.$this->request->data['user_awards']['authority'].'</p>'.
				'<p>'.$year.'</p>';


		}
		return $status;

	}



	public function delete() {

		$this->autoRender = FALSE;
		if($this->request->is('ajax')){
			$this->request->data['user_id'] = $this->Auth->user('id');

			$data = $this->request->data;
			$status['success'] = FALSE;
			$status['id'] = $data['id'];
			$url = "/deleteAward";


			$status = $this->Curl->postHttpCurl($url,$data);


			return json_encode($status);
		}
	}


}

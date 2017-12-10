<?php
App::uses('AppController', 'Controller');
/**
 * UserWorks Controller
 *
 * @property UserWork $UserWork
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 */
class UserWorksController extends AppController {

/**
 * Components
 *
 * @var array
 */
	public $components = array('Paginator', 'Session','Curl');


	public function add() {
		$this->autoRender = FALSE;
		if($this->request->is('ajax')){



			$url = "/addMentorExperience";
			$years = $this->request->data['user_work']['date_from']['year'].' - '.$this->request->data['user_work']['date_to']['year'];
			$from = $this->request->data['user_work']['date_from']['year'].'-'.$this->request->data['user_work']['date_from']['month'].'-01';
			$to = $this->request->data['user_work']['date_to']['year'].'-'.$this->request->data['user_work']['date_to']['month'].'-01';

			$this->request->data['user_work']['user_id'] = $this->Auth->user('id');
			$this->request->data['user_work']['date_from'] = $from;
			$this->request->data['user_work']['date_to'] = $to;
			$data = $this->request->data['user_work'];

			$status = $this->Curl->postHttpCurl($url,$data);
//ID SHOULD BE FROM MYSQL
			$id = 0;

			$html= '<div class="edu-desc-row">'.
				'<div class="edu-desc-row-inner">'.
				'<div class="editPencil pencil editDummy" id="'.$id.'">&nbsp;</div>'.
				'<div class="editPencil-remove trash" data="work"  title="Delete" id="'.$id.'">&nbsp;</div>'.


				'<h4>'.$this->request->data['user_work']['jobtitle'].'</h4>'.
				'<p>'.$this->request->data['user_work']['company']. ' )</p>'.
				'<p>'.$years.'</p>'.
				'</div>'.
				'</div>';


		}
		return $html;

	}



	public function edit() {
		$this->autoRender = FALSE;
		if($this->request->is('ajax')){



			$url = "/editMentorExperience";
			$years = $this->request->data['user_work']['date_from']['year'].' - '.$this->request->data['user_work']['date_to']['year'];
			$from = $this->request->data['user_work']['date_from']['year'].'-'.$this->request->data['user_work']['date_from']['month'].'-01';
			$to = $this->request->data['user_work']['date_to']['year'].'-'.$this->request->data['user_work']['date_to']['month'].'-01';

			$this->request->data['user_work']['user_id'] = $this->Auth->user('id');
			$this->request->data['user_work']['date_from'] = $from;
			$this->request->data['user_work']['date_to'] = $to;

			$data = $this->request->data['user_work'];

			$status['id'] = $data['id'];
			$status['success'] = FALSE;




			$st = $this->Curl->postHttpCurl($url,$data);

			$status = '<h4>'.$this->request->data['user_work']['jobtitle'].'</h4>'.
				'<p>'.$this->request->data['user_work']['company'].'</p>'.
				'<p>'.$years.'</p>';
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
				$url = "/deleteMentorExperience";


				$status = $this->Curl->postHttpCurl($url,$data);


                return json_encode($status);
            }
        }




}

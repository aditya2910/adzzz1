<?php
App::uses('AppModel', 'Model');

class MentorTalk extends AppModel {
	public $useTable = 'posts';



	public function paginate($conditions, $fields, $order, $userId, $page = 1,
							 $recursive = null, $extra = array()){


		App::import('Component','Curl');
		$Curl = new CurlComponent(new ComponentCollection);

		$menterId = Router::getParams()['id'];
		$userId = Router::getParams()['pass'][0];
		$lastId = 0;
		App::uses('CakeSession', 'Model/Datasource');
		$user_id = CakeSession::read('Auth.User.userId');

		$url = "/getTalk/".$menterId."/".$userId."/".$page."/".$lastId;

		$jsonObject = $Curl->fetchCurl($url);

		return $jsonObject;


	}
}


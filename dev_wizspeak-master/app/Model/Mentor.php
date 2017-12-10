<?php
App::uses('AppModel', 'Model');

class Mentor extends AppModel {
	public $useTable = 'posts';



	public function paginate($conditions, $fields, $order, $userId, $page = 1,
							 $recursive = null, $extra = array()){


		App::import('Component','Curl');
		$Curl = new CurlComponent(new ComponentCollection);

		$menterId = Router::getParams()['id'];
		$lastId = 0;
		App::uses('CakeSession', 'Model/Datasource');
		$user_id = CakeSession::read('Auth.User.userId');

		$url = "/getMentorWallPost/".$menterId."/".$user_id."/".$lastId."/".$page;

		$jsonObject = $Curl->fetchCurl($url);

		return $jsonObject;


	}
}


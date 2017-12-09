<?php
App::uses('AppModel', 'Model');

class Profile extends AppModel {
    public $useTable = 'posts';


	public function paginate($conditions, $fields, $order, $userId, $page = 1,
							 $recursive = null, $extra = array()){
		App::import('Component','Curl');
		$Curl = new CurlComponent(new ComponentCollection);

		$userId = Router::getParams()['userId'];
		//$userId = "e04f6e62e64d9c0ddae59244ab3f6899";
		App::uses('CakeSession', 'Model/Datasource');
		$loginId = CakeSession::read('Auth.User.userId');

		$url = "/getProfilePost/".$userId."/".$loginId."/".$page."/0";

		$jsonObject = $Curl->fetchCurl($url);

		return $jsonObject;
	}






}

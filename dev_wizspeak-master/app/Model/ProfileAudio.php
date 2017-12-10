
<?php
App::uses('AppModel', 'Model');

class ProfileAudio extends AppModel {
	public $useTable = 'posts';


	public function paginate($conditions, $fields, $order, $userId, $page = 1,
							 $recursive = null, $extra = array()){
		App::import('Component','Curl');
		$Curl = new CurlComponent(new ComponentCollection);

		$userId = Router::getParams()['userId'];
		//$userId = "e04f6e62e64d9c0ddae59244ab3f6899";

		$mediaType = 5;
		$lastId = 0;

		$url = "/userMedia/".$userId."/".$mediaType."/".$page."/".$lastId;

		$jsonObject = $Curl->fetchCurl($url);

		return $jsonObject;
	}






}

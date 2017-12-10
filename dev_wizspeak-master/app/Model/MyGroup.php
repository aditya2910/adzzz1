<?php
App::uses('AppModel', 'Model');
/**
 * Group Model
 *
 * @property SubCategory $SubCategory
 * @property Createdby $Createdby
 * @property GroupEvent $GroupEvent
 * @property UserGroupRelation $UserGroupRelation
 */
class MyGroup extends AppModel {
	public $useTable = 'posts';

	public function paginate($conditions, $fields, $order, $userId, $page = 1,
							 $recursive = null, $extra = array()){
		App::import('Component','Curl');
		$Curl = new CurlComponent(new ComponentCollection);

		App::uses('CakeSession', 'Model/Datasource');
		$user_id = CakeSession::read('Auth.User.userId');

		$lastId = 0;
		$url = "/getGroupPagination/".Router::getParams()['groupName']."/".$user_id."/".$page."/".$lastId;

		$jsonObject = $Curl->fetchCurl($url);

		return $jsonObject;
	}

}

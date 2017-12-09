<?php
App::uses('AppModel', 'Model');
/**
 * Post Model
 *
 * @property Postby $Postby
 * @property Postto $Postto
 * @property PostType $PostType
 * @property PostUserComment $PostUserComment
 * @property UserPostView $UserPostView
 * @property PostUserLike $PostUserLike
 */
class Post extends AppModel {


	//override pagination

	public function paginate($conditions, $fields, $order, $userId, $page = 1,
							 $recursive = null, $extra = array()){
		App::import('Component','Curl');
		$Curl = new CurlComponent(new ComponentCollection);

		$lastId = 0;
		$url = "/getAmbitionHomePost/".$userId."/".$page."/".$lastId;
		$jsonObject = $Curl->fetchCurl($url);

		return $jsonObject;
	}

}

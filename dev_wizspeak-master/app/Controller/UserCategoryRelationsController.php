<?php
App::uses('AppController', 'Controller');
/**
 * UserCategoryRelations Controller
 *
 * @property UserCategoryRelation $UserCategoryRelation
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 */
class UserCategoryRelationsController extends AppController {

/**
 * Components
 *
 * @var array
 */
	public $components = array('Curl', 'Session');


	public function add(){
		$this->autoRender = false;
		if($this->request->is("ajax")){
			 $data =  $this->request->data;
			$vertical = $data['vertical'];
			$mentor = 0;
			if($vertical==3){
				$vertical = 1;
				$mentor = 1;
			}

			$url1 = "/removeAllUserCatMap/".$vertical."/".$this->Auth->user("userId")."/".$mentor;
			$jsonObject = $this->Curl->fetchCurl($url1);


			foreach ($data['category'] as $item){

				echo $item;


				$url = "/addUserCatRel/".$item."/".$vertical."/".$this->Auth->user("userId")."/".$mentor;
				$jsonObject = $this->Curl->fetchCurl($url);
			}

		}
	}



}

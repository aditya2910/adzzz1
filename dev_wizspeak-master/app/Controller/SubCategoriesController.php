<?php
App::uses('AppController', 'Controller');
/**
 * SubCategories Controller
 *
 * @property SubCategory $SubCategory
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 */
class SubCategoriesController extends AppController {

/**
 * Components
 *
 * @var array
 */
	public $components = array('Paginator', 'Session');

	public function beforeFilter() {
		parent::beforeFilter();
		$this->Auth->allow('get_subcategories');
		if($this->Auth->user()){

			$this->Session->write('Auth.User.role', 1);
		}

	}

        public function get_subcategories (){

            $this->autoRender = false;
            if ($this->request->is('post')) {
                $this->SubCategory->recursive = -1;
                $query = $this->SubCategory->find('all', array(
                            'conditions' =>array('category_id' => $this->request->data['category_id']),
                            'fields' => array('id', 'name')
                ));

                $sub = array();
            for ($i = 0; $i < count($query); $i++) {
                $sub[$i]['name'] = $query[$i]['SubCategory']['name'];
                $sub[$i]['id'] = $query[$i]['SubCategory']['id'];
            }
                return json_encode($sub);
            }
        }

	public function addUserDefined(){

		$this->autoRender = false;
		if($this->request->is('post')){

			if($this->request->data['type']==1){
				//ambition
				$userDefindCategory = 20;
			}elseif($this->request->data['type']==2){
				//hobbies
				$userDefindCategory = 19;
			}elseif($this->request->data['type']==0){
				$userDefindCategory = 20;
			}
			//hoby user defined category

			$result = $this->SubCategory->find('first', array(
				'conditions' => array('SubCategory.name' => $this->request->data['name'],'Category.vertical_id' =>$this->request->data['type']),
				'fields' => array('SubCategory.id')
			));
			if(isset($result['SubCategory'])){
				$res = array(
					'name' => $this->request->data['name'],
					'id' => $result['SubCategory']['id']
				);

			}else{

				$data = array('SubCategory' => array(
					'name' => $this->request->data['name'],
					'category_id' => $userDefindCategory,
					'type' => 2,
					'date_created' => date('Y-m-d H:i:s')
				) );

				if($this->SubCategory->save($data)){

					$res = array(
						'name' => $this->request->data['name'],
						'id' => $this->SubCategory->id
					);

				}

			}



			return json_encode($res);
		}
	}

}

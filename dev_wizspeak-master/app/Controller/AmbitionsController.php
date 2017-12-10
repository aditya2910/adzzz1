<?php
App::uses('AppController', 'Controller');
/**
 * Posts Controller
 *
 * @property Post $Post
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 */

class AmbitionsController extends AppController {

/**sett
 * Components
 *
 * @var array
 */
	public $components = array('Curl', 'Session', 'Page', 'Paginator');
	public $uses = array('Post');

        public function beforeFilter() {
            parent::beforeFilter();

            $this->setJsVar('wall_id', $this->Auth->user('userId'));
			$this->setJsVar('user_id', $this->Auth->user('userId'));
            $this->setJsVar('wall_type',1);
            $this->setJsVar('vertical_id',1);

			if($this->Auth->user("id")){

				$this->Session->write('Auth.User.role', 1);
			}else{
				 $this->redirect(
					array('controller' => 'users', 'action' => 'logout')
				);

			}
			$this->set("vertical",1);

        }


	public function isAuthorized($user) {
		return true;
	}

        public function index(){

			//debug($this->Auth->user());

			$this->layout = 'ambition';


			$this->set('user_id',$this->Auth->user('id'));

			//


			//add group
             if($this->request->is('POST')){

                 $form_data = $this->request->data['create-ambition-group'];
                 $data = array(
                     'name' => $form_data['title'],
                     'description' => $form_data['description'],
                     'sub_category_id' => $form_data['ambitions_subcategory_id'],
                     'type' => 2,
                     'status' => 1,
                     'createdby_id' => $this->Auth->user('id'),
                     'date_created' => date('Y-m-d H:i:s'),
					 'invitedId' => $form_data['invited'],
					 'createdby_id' => $this->Auth->user("id")
                 );
				 //debug($data);

				 $url = "/createGroup";
				 $status = $this->Curl->postHttpCurl($url,$data);

				// $user_group_relations
             }


			//singlr curl call

			$url = "/ambitionPage/".$this->Auth->user("id");
			$jsonObject = $this->Curl->fetchCurl($url);

			//debug($jsonObject);


			$this->set('userDetails',$jsonObject->userDetails);

			$this->set('userFriends',$jsonObject->frindList);

			$this->set('userMentors',$jsonObject->mentorList);


			$this->set('userGroups',$jsonObject->userGroup);
			$this->set('userRating',$jsonObject->userRating);




			$url1="/getAmbitionCategories";
			$categories = $this->Curl->fetchCurl($url1);

			$this->set('categories',$categories);

			//debug($categories);

			$url2 ="/getAmbitionSubCategories";
			$subCategories = $this->Curl->fetchCurl($url2);
			$this->set('subCategories',$subCategories);
			//debug($subCategories);



            /*
             * Create new ambition group
             *
             */


        /*ambition category list start*/
			foreach($categories as $i => $cate){

				$ambition_categorys[$i]['label'] = $cate->name;
				$ambition_categorys[$i]['value'] = $cate->id;
			}

           // debug($ambition_categorys);
            if(count($categories)>0){
            $this->setJsVar('group_categorys',$ambition_categorys );
            }else{
             $this->setJsVar('group_categorys',array());
            }


			foreach($subCategories as $i => $subcate){

				$sub_Categories[$i]['label'] = $subcate->name;
				$sub_Categories[$i]['value'] = $subcate->id;
				$sub_Categories[$i]['refer'] = $subcate->categoryId;

			}


            //debug($ambition_categorys);
            if(count($subCategories)>0){
            $this->setJsVar('group_subcategorys',$sub_Categories );}else{
             $this->setJsVar('group_subcategorys',array());
            }

			$this->Paginator->settings = array('limit' => $this->Auth->user('id'));

			$data = $this->paginate('Post');

			$this->set('userPosts',$data);

			$this->userAmbitions($this->Auth->user("userId"));

         }



	public function userAmbitions($userStr){

		$this->loadModel("UserCategoryRelation");
		$old_mem = $this->UserCategoryRelation->find('all',array(
			'conditions' => array(
				'UserCategoryRelation.user_id' => $this->Auth->user("id"),
				'UserCategoryRelation.vertical_id' => 1,
			),
			'fields' => array(
				'UserCategoryRelation.sub_category_id','SubCategory.name'
			)

		));

		$option = array('0' => 'select');

		if(count($old_mem)>0){

			foreach($old_mem as $cate){

				$option[$cate['UserCategoryRelation']['sub_category_id']] = $cate['SubCategory']['name'];

			}
		}

		$this->set('userCategory',$option);
	}


}

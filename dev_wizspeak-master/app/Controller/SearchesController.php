<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

App::uses('Appcontroller', 'Controller');

class SearchesController extends AppController {

    public $uses = array('User','Group','SubCategory');
	public $components = array('Curl');

    public function beforeFilter() {
            parent::beforeFilter();

            $this->setJsVar('wall_id', $this->Auth->user('id'));
            $this->setJsVar('wall_type',1);
            $this->setJsVar('vertical_id',1);
		$this->Auth->allow('category');

    }

    public function isAuthorized($user) {

        switch ($this->action) {

            case 'main_search':
            case 'search_user':
            case 'search_file':
            case 'search_group':
            case 'cre_search':
            case 'search':
            case 'search_user':
            case 'search_all':
            case 'category':

                return true;
                break;


            case 'main_search':


                if($user['role']==1 || $user['role']==2 ){
                    return true;
                }
                $this->redirect(array('action' => 'about'));
                return false;
                break;

            case 'more':
            case 'updateGroupName':
            case 'updateGroupDescription':
            case 'profile_photo':
            case 'setting':
            case 'remove_post_ajax':
                if($user['role']==1){
                    return true;
                }

                $this->redirect(array('action' => $this->request->param('groupName'),'about'));

                return false;
                break;
            default:
                return false;
        }


        return parent::isAuthorized($user);
    }


    public function main_search()
    {
        $this->autoRender = FALSE;

        if( $this->request->isPost() ) {
            $this->request->data['key'];
            $this->request->data['filter'];

            switch ($this->request->data['filter']){
                case 'USER' :
                    $result0 = $this->search_user($this->request->data['key'],6,0 );
                    $result = $this->search_user($this->request->data['key'],4,1 );
                    $result = array_merge_recursive ($result,$result0);
                    break;

                case 'AMB' :
                    $result = $this->search_group($this->request->data['key'],10,1);
                    break;
                case 'HOB' :
                    $result = $this->search_group($this->request->data['key'],10,2);
                    break;

                case 'TEA' :
                    $result = $this->search_group($this->request->data['key'],10,4);
                    break;

                case 'EVENT' :
                    $result = $this->search_events($this->request->data['key'],5);
                    break;

                case 'ALL' :
                default :
                    $result = $this->search_all($this->request->data['key'],10);


            }

            return json_encode($result);

        }

    }


    public function search_user($key,$count,$mentor) {

            $conditions = array();
            $search_terms = explode(' ', trim($key));
            foreach($search_terms as $search_term){
                $conditions[] = array('User.first_name Like' =>'%'.$search_term.'%');
                $conditions[] = array('User.last_name Like' =>'%'.$search_term.'%');
                /*$conditions[] = array('User.email Like' =>'%'.$search_term.'%');*/
            }

            $andcondition = array( 'User.is_mentor' => $mentor);
            $this->User->recursive = 0;
            $user = $this->User->find('all',array(
                        'conditions' => array('OR' => $conditions ,'AND' => $andcondition ),
                        'fields' => array(
                            'User.id','User.userId','User.first_name','User.last_name','UserGroupProfilePic.link'
                        ),
                        'limit' => $count
                    ));
            $json = array();
            foreach($user as $oneUser){
                $newUser['name']= $oneUser['User']['first_name'].' '.$oneUser['User']['last_name'];
                if(empty($oneUser['UserGroupProfilePic']['link'])){
                    $newUser['pic'] = 'img/mentorReg.jpg';
                }else{
                    $newUser['pic']=  IMAGE_PROFILE_WALL.$oneUser['UserGroupProfilePic']['link'];
                }

                $newUser['about']=  'User';
                 $newUser['url']= '/'.MY_APP."/profiles/".$oneUser['User']['userId'];
                if($mentor){ $newUser['about'] = 'Mentor';

                 $newUser['url']= '/'.MY_APP."/mentor/".$oneUser['User']['userId']."/about";
                }


                $json[] = $newUser;
            }
            return $json;

    }


    public function search_group($key , $count ,$filter){

            $conditions = array();
            $search_terms = explode(' ', trim($key));
            foreach($search_terms as $search_term){
                $conditions[] = array('Group.name Like' =>'%'.$search_term.'%');
                $conditions[] = array('Group.description Like' =>'%'.$search_term.'%');

            }

            $this->Group->recursive = 0;
            $user = $this->Group->find('all',array(
                        'joins' => array(
                            array(
                                'table' => 'categories',
                                'alias' => 'Category',
                                'type' => 'LEFT',
                                'conditions' => array(
                                    'Category.id = SubCategory.category_id'
                                ) )

                        ),
                        'conditions' => array('OR' => $conditions,'AND' => array('Category.vertical_id' => $filter)),
                        'fields' => array(
                            'Group.id','Group.groupId','Group.name','UserGroupProfilePic.link','SubCategory.category_id'
                        ),
                        'limit' => $count
                    ));
            $json = array();
            foreach($user as $oneUser){
                $newUser['name']= $oneUser['Group']['name'];


                if(empty($oneUser['UserGroupProfilePic']['link'])){
                    $newUser['pic'] = 'img/ambition.jpg';
                }else{
                    $newUser['pic']=  IMAGE_PROFILE_WALL.$oneUser['UserGroupProfilePic']['link'];
                }





                $newUser['about']=  '';
                $newUser['url']= '/'.MY_APP.'/groups/'.$oneUser['Group']['groupId'].'/about';

                $json[] = $newUser;
            }
            return $json;

    }

    public function search_all($key,$count)
    {
        $result = $this->search_user($key,2,1);
        $result0 = $this->search_user($key,2,0);
        $result = array_merge_recursive ($result,$result0);
        $result1 = $this->search_group($key,2,1);
        $result= array_merge_recursive ($result,$result1);
        $result2 = $this->search_group($key,2,2);
        $result= array_merge_recursive ($result,$result2);
        $result3 = $this->search_group($key,2,4);
        $result= array_merge_recursive ($result,$result3);
        return $result;
    }


    public function advance(){
        $this->layout = 'advance_search';
        $user['Users']['id'] =$this->Auth->user('id');
        $this->set('user',$user);
    }

    public function search()
        {
        $this->autoRender = FALSE;
        if($this->request->is('post')){
            $count = 5;
            $result = array();
            if($this->request->data['user'] == 'true' ){

                $result01 = $this->search_user($this->request->data['q'] , $count , 0);
                $result = $this->search_user($this->request->data['q'] , $count , 1);
                $result= array_merge_recursive ($result,$result01);
            }
//            if($this->request->data['mentor'] == 'true' ){
//
//                $result0 = $this->search_user($this->request->data['q'] , $count , 'MENTOR');
//                $result= array_merge_recursive ($result,$result0);
//            }
            if($this->request->data['amb']== true ){
                $result1 = $this->search_group($this->request->data['q'],$count,1);
                $result= array_merge_recursive ($result,$result1);
            }
            if($this->request->data['hob']== true ){
                $result2 = $this->search_group($this->request->data['q'],$count,2);
                $result= array_merge_recursive ($result,$result2);
            }
            if($this->request->data['tea']== true ){
                $result3 = $this->search_group($this->request->data['q'],$count,4);
                $result= array_merge_recursive ($result,$result3);
            }
            return json_encode($result);

                return json_encode($this->request->data);
            }



        }

         public function cre_search()
    {
        $this->autoRender = FALSE;

        if( $this->request->isPost() ) {
            $this->request->data['key'];
            $this->request->data['filter'];

            switch ($this->request->data['filter']){
                case 'USER' :
                    $result0 = $this->search_file($this->request->data['key'],6,0 );
                    $result = $this->search_user($this->request->data['key'],4,1 );
                    $result = array_merge_recursive ($result,$result0);
                    break;

                case 'AMB' :
                    $result = $this->search_group($this->request->data['key'],10,1);
                    break;
                case 'HOB' :
                    $result = $this->search_group($this->request->data['key'],10,2);
                    break;

                case 'TEA' :
                    $result = $this->search_group($this->request->data['key'],10,4);
                    break;

                case 'EVENT' :
                    $result = $this->search_events($this->request->data['key'],5);
                    break;

                case 'ALL' :
                default :
                    $result = $this->search_file($this->request->data['key'],10);


            }

            return json_encode($result);




        }

    }
    public function search_cre($key,$count)
    {
        $result = $this->search_file($key,2,1);
        $result0 = $this->search_file($key,2,0);
        $result = array_merge_recursive ($result,$result0);

        return $result;
    }
  public function search_file($key,$count,$mentor) {

            $conditions = array();
            $search_terms = explode(' ', trim($key));
            foreach($search_terms as $search_term){
                $conditions[] = array('Post.title Like' =>'%'.$search_term.'%');
              //  $conditions[] = array('User.last_name Like' =>'%'.$search_term.'%');
                /*$conditions[] = array('User.email Like' =>'%'.$search_term.'%');*/
            }

            $andcondition = array( 'User.is_mentor' => $mentor);
            $this->Post->recursive = 0;
            $user = $this->User->find('all',array(
                        'conditions' => array('OR' => $conditions ,'AND' => $andcondition ),
                        'fields' => array(
                            'User.id','User.first_name','User.last_name','UserGroupProfilePic.link'
                        ),
                        'limit' => $count
                    ));
            $json = array();
            foreach($user as $oneUser){
                $newUser['name']= $oneUser['User']['first_name'].' '.$oneUser['User']['last_name'];
                if(empty($oneUser['UserGroupProfilePic']['link'])){
                    $newUser['pic'] = 'img/mentorReg.jpg';
                }else{
                    $newUser['pic']=  IMAGE_PROFILE_WALL.$oneUser['UserGroupProfilePic']['link'];
                }

                $newUser['about']=  'User';
                 $newUser['url']= '/'.MY_APP."/profiles/".$oneUser['User']['id'];
                if($mentor){ $newUser['about'] = 'Mentor';

                 $newUser['url']= '/'.MY_APP."/mentor/".$oneUser['User']['id'];
                }


                $json[] = $newUser;
            }
            return $json;

    }

	public function category(){

		$this->autoRender = FALSE;

		if( $this->request->isPost() ) {

			switch ($this->request->data['filter']){
				case '1' :

					$result = $this->search_categories($this->request->data['key'],1);
					break;

				case '2' :

					$result = $this->search_categories($this->request->data['key'],2);
					break;
				case '0' :

					$result = $this->search_all_categories($this->request->data['key']);
					break;
			}
			return json_encode($result);
		}
	}


	public  function search_categories($key,$type){

		$conditions[] = array('SubCategory.name Like' => '%'.$key.'%');
		$conditions[] = array('Category.name Like' => '%'.$key.'%');

		$condition1 = array('Category.vertical_id' => $type);
		$this->SubCategory->recursive = 0;
		$user = $this->SubCategory->find('all',array(

			'conditions' => array('OR' => $conditions , 'AND' => $condition1 ),
			'fields' => array(
				'DISTINCT SubCategory.id','SubCategory.name','SubCategory.category_id','Category.vertical_id'
			),
			'limit' => 14
		));

		return $user;

	}

	public  function search_all_categories($key){

		$conditions[] = array('SubCategory.name Like' => '%'.$key.'%');
		$conditions[] = array('Category.name Like' => '%'.$key.'%');

		$this->SubCategory->recursive = 0;
		$user = $this->SubCategory->find('all',array(

			'conditions' => array('OR' => $conditions ),
			'fields' => array(
				'DISTINCT SubCategory.id','SubCategory.name','SubCategory.category_id','Category.vertical_id'
			),
			'limit' => 14
		));

		return $user;

	}

}


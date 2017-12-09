<?php
App::uses('AppController', 'Controller');
/**
 * UserGroupRelations Controller
 *
 * @property UserGroupRelation $UserGroupRelation
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 */
class UserGroupRelationsController extends AppController {

/**
 * Components
 *
 * @var array
 */
	public $components = array('Curl', 'Session');

	public function isAuthorized($user) {

		switch ($this->action) {

			case 'update':

				return true;
				break;

			case 'add':



				if($user['role']==1 || $user['role']==2 ){
					return true;
				}
				$this->redirect(array('action' => 'about'));
				return false;
				break;

			case 'more':
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



        public function update(){
            $this->autoRender = false;
                if($this->request->is('POST')){
                    $groupStr = $this->request->data["item_id"];
                    $status = $this->request->data["status"];

                    $url = "/groupUserStatus/".$groupStr."/".$this->Auth->user("userId")."/".$status;
                    $post = $this->Curl->fetchCurl($url);

debug($post);
                }

        }

        public function add() {
            $this->autoRender = false;
            if($this->request->is('POST')){
                $data = $this->request->data;
                $data['rolesetby_id'] = $this->Auth->user('id');
                $data['status'] = 5;
                $data['invitedby_id'] = $this->Auth->user('id');
                $data['date_invited'] = date('Y-m-d H:i:s');

                $this->UserGroupRelation->recursive = -1;
                $old_mem = $this->UserGroupRelation->find('first',array(
                            'conditions' => array(
                                'UserGroupRelation.user_id' => $data['user_id'],
                                'UserGroupRelation.group_id' => $data['group_id'],
                                'UserGroupRelation.role_id' => $data['role_id']
                            )
                        ));
                $ret = array();

                if(isset($old_mem['UserGroupRelation'])){
                    if($old_mem['UserGroupRelation']['status'] == 2 || $old_mem['UserGroupRelation']['status'] == 3){
                        $this->UserGroupRelation->id =$old_mem['UserGroupRelation']['id'];
                        $this->UserGroupRelation->set('status',5);
                        $this->UserGroupRelation->save();

                        $ret['div'] = $data['user_id'];
                        $ret['id'] = $old_mem['UserGroupRelation']['id'];
                        return json_encode($ret);
                    }


                    if($old_mem['UserGroupRelation']['status'] == 5){
                        $ret['div'] = $data['user_id'];
                        $ret['id'] = $old_mem['UserGroupRelation']['id'];
                        return json_encode($ret);
                    }
                }else{
                    $this->UserGroupRelation->create();
                    $this->UserGroupRelation->set($data);
                    if($this->UserGroupRelation->save()){

                        $id = $this->UserGroupRelation->getLastInsertId();
                        $ret['div'] = $data['user_id'];
                        $ret['id'] = $id;

                        }
                    }

                return json_encode($ret);
            }


        }

        public function remove() {

            $this->autoRender = false;

            if($this->request->is('POST')){

                $this->UserGroupRelation->id = $this->request->data['id'];
                $this->UserGroupRelation->set('status',3);
                $this->UserGroupRelation->save();
            }
        }



}

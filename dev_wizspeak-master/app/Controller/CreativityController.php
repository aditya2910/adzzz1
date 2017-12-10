<?php
App::uses('AppController', 'Controller','PostsController');
/**
 * UserCreativityPosts Controller
 *
 * @property UserCreativityPost $UserCreativityPost
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 */
class CreativityController extends AppController
{

	/**
	 * Components
	 *
	 * @var array
	 */
	public $components = array('Paginator', 'Session', 'Access', 'Log', 'Curl');
	public $uses = array('Post', 'Users', 'Post_types', 'UserPostView');

	public function beforeFilter() {
		parent::beforeFilter();
		if( $this->Auth->user()){
			$this->Session->write('Auth.User.role', 1);
		}else{
			return $this->redirect(['controller' => 'users','action' => 'login']);
		}


	}


	public function index()
	{

		$id = $this->Auth->user('userId');

		$this->layout = 'creativity';


		/****************per strt*************/
		$url1 = "/getCreativityPosts/" . $id . "/2";

		$json_array = $this->Curl->fetchCurl($url1);
		//debug($json_array);
		$this->set('Creativity_img', $json_array);



		/**********************video java******************/

		$url1 = "/getCreativityPosts/" . $id . "/3";
		$json_array = $this->Curl->fetchCurl($url1);

		$this->set('Creativity_vid', $json_array);


		/**********************doc java******************/

		$url1 = "/getCreativityPosts/" . $id . "/4";
		$json_array = $this->Curl->fetchCurl($url1);

		$this->set('Creativity_doc', $json_array);


		/**********************aud java******************/
		$url1 = "/getCreativityPosts/" . $id . "/5";
		$json_array = $this->Curl->fetchCurl($url1);

		$this->set('Creativity_aud', $json_array);


		/*********************per end**************/


		$combobox = $this->Post->find('all', array(
			'conditions' => array('AND' => array('Post.status' => '1', 'vertical_id' => '3'))));

		for ($i = 0; $i < count($combobox); $i++) {
			$CreativityTag[$i]['label'] = $combobox[$i]['Post']['keywords'];
			$CreativityTag[$i]['value'] = $combobox[$i]['Post']['id'];
		}

		if (count($combobox) > 0) {
			$this->set('tags', $CreativityTag);
			$this->setJsVar('creativitytag', $CreativityTag);
		} else {
			$this->set('tags', array());
			$this->setJsVar('creativitytag', array());
		}

	}

	public function view($id = null)
	{
		if (!$this->Posts->exists($id)) {
			throw new NotFoundException(__('Invalid user creativity post'));
		}
		$options = array('conditions' => array('Posts.' . $this->Posts->primaryKey => $id));
		$this->set('Posts', $this->Posts->find('first', $options));
	}

	/**
	 * add method
	 *
	 * @return void
	 */
	public function add()
	{
		if ($this->request->is('post')) {
			$this->Posts->create();
			if ($this->Posts->save($this->request->data)) {
				$this->Session->setFlash(__('The user creativity post has been saved.'));
				return $this->redirect(array('action' => 'index'));
			} else {
				$this->Session->setFlash(__('The user creativity post could not be saved. Please, try again.'));
			}
		}
		$users = $this->Posts->postby_id->find('list');
		$this->set(compact('users'));
	}

	/**
	 * edit method
	 *
	 * @throws NotFoundException
	 * @param string $id
	 * @return void
	 */

	/**
	 * delete method
	 *
	 * @throws NotFoundException
	 * @param string $id
	 * @return void
	 */
	public function delete($id = null)
	{
		$this->Posts->id = $id;
		if (!$this->Posts->exists()) {
			throw new NotFoundException(__('Invalid user creativity post'));
		}
		$this->request->allowMethod('post', 'delete');
		if ($this->Posts->delete()) {
			$this->Session->setFlash(__('The user creativity post has been deleted.'));
		} else {
			$this->Session->setFlash(__('The user creativity post could not be deleted. Please, try again.'));
		}
		return $this->redirect(array('action' => 'index'));
	}

	public function search()
	{
		$this->layout = 'creativity';


	}

	public function player()
	{


		$file_id = $this->request->params['pass'][0];

		$url1 = "/getCreativityPosts/" . $file_id ."/3";

		$json_array = $this->Curl->fetchCurl($url1);

		$this->set('Creativity_vid', $json_array);

		$url1 = "/creativityPlayer/" . $file_id . "/3";

		$json_array = $this->Curl->fetchCurl($url1);

		$this->layout = 'creativity';

		$this->set('Creativity_player', $json_array);

		$url1 = "/getPostComments/" . $file_id . "/3";
		$json_array = $this->Curl->fetchCurl($url1);

		$this->layout = 'creativity';
		$this->set('userPosts', $json_array);


		$user_id = $id = $this->Auth->user('id');
		$url1 = "/userDetails/" . $user_id ;
		$json_array = $this->Curl->fetchCurl($url1);
		$this->set('userdata', $json_array);



		}







	public function audio() {


		$this->layout = 'creativity';
$user_id = $id = $this->Auth->user('id');
		$file_id = $this->request->params['pass'][0];

		$url1 = "/getCreativityPosts/" . $file_id ."/5";

		$json_array = $this->Curl->fetchCurl($url1);

		$this->set('Creativity_aud', $json_array);

		$url1 = "/creativityPlayer/" . $file_id . "/5";

		$json_array = $this->Curl->fetchCurl($url1);


		$this->set('audio', $json_array);

		$url1 = "/getPostComments/" . $file_id . "/5";
		$json_array = $this->Curl->fetchCurl($url1);


		$this->set('userPosts', $json_array);


	    $url1 = "/userDetails/" . $user_id ;
		$json_array = $this->Curl->fetchCurl($url1);
		$this->set('userdata', $json_array);
















	}





	public function music() {
		$this->layout = 'creativity';

//		*****************image*******************
		$id1 = $this->Auth->user('userId');
		$url1 = "/getCreativityCatPost/" . $id1 ."/2". "/2";
		$musicimage = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_mi', $musicimage);

//		*****************video*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/2". "/3";
		$musicvideo = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_mv', $musicvideo);

//		*****************doc*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/2". "/4";
		$musicdoc = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_md', $musicdoc);

//		*****************aud*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/2". "/5";
		$musicaud = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_ma', $musicaud);






	}
//*********************movies**********//
	public function movies() {
		$this->layout = 'creativity';

//		*****************image*******************
		$id1 = $this->Auth->user('userId');
		$url1 = "/getCreativityCatPost/" . $id1 ."/1". "/2";
		$musicimage = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_mi', $musicimage);

//		*****************video*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/1". "/3";
		$musicvideo = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_mv', $musicvideo);

//		*****************doc*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/1". "/4";
		$musicdoc = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_md', $musicdoc);

//		*****************aud*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/1". "/5";
		$musicaud = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_ma', $musicaud);

	}

	//*********************sport**********//
	public function sports() {
		$this->layout = 'creativity';

//		*****************image*******************
		$id1 = $this->Auth->user('userId');
		$url1 = "/getCreativityCatPost/" . $id1 ."/3". "/2";
		$musicimage = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_mi', $musicimage);

//		*****************video*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/3". "/3";
		$musicvideo = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_mv', $musicvideo);

//		*****************doc*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/3". "/4";
		$musicdoc = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_md', $musicdoc);

//		*****************aud*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/3". "/5";
		$musicaud = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_ma', $musicaud);

	}
	//*********************nature**********//
	public function nature() {
		$this->layout = 'creativity';

//		*****************image*******************
		$id1 = $this->Auth->user('userId');
		$url1 = "/getCreativityCatPost/" . $id1 ."/4". "/2";
		$musicimage = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_mi', $musicimage);

//		*****************video*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/4". "/3";
		$musicvideo = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_mv', $musicvideo);

//		*****************doc*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/4". "/4";
		$musicdoc = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_md', $musicdoc);

//		*****************aud*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/4". "/5";
		$musicaud = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_ma', $musicaud);


	}
	//*********************science**********//
	public function science() {
		$this->layout = 'creativity';

//		*****************image*******************
		$id1 = $this->Auth->user('userId');
		$url1 = "/getCreativityCatPost/" . $id1 ."/5". "/2";
		$musicimage = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_mi', $musicimage);

//		*****************video*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/5". "/3";
		$musicvideo = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_mv', $musicvideo);

//		*****************doc*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/5". "/4";
		$musicdoc = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_md', $musicdoc);

//		*****************aud*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/5". "/5";
		$musicaud = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_ma', $musicaud);


	}
	//*********************comedy**********//
	public function comedy() {
		$this->layout = 'creativity';

//		*****************image*******************
		$id1 = $this->Auth->user('userId');

		$url1 = "/getCreativityCatPost/" . $id1 ."/6". "/2";
		$musicimage = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_mi', $musicimage);

//		*****************video*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/6". "/3";
		$musicvideo = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_mv', $musicvideo);

//		*****************doc*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/6". "/4";
		$musicdoc = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_md', $musicdoc);

//		*****************aud*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/6". "/5";
		$musicaud = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_ma', $musicaud);



	}
	//*********************tutorials**********//
	public function tutorials() {
		$this->layout = 'creativity';

//		*****************image*******************
		$id1 = $this->Auth->user('userId');
		$url1 = "/getCreativityCatPost/" . $id1 ."/7". "/2";
		$musicimage = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_mi', $musicimage);

//		*****************video*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/7". "/3";
		$musicvideo = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_mv', $musicvideo);

//		*****************doc*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/7". "/4";
		$musicdoc = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_md', $musicdoc);

//		*****************aud*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/7". "/5";
		$musicaud = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_ma', $musicaud);


	}

	//*********************animation**********//
	public function animation() {
		$this->layout = 'creativity';

//		*****************image*******************
		$id1 = $this->Auth->user('userId');
		$url1 = "/getCreativityCatPost/" . $id1 ."/8". "/2";
		$musicimage = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_mi', $musicimage);

//		*****************video*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/8". "/3";
		$musicvideo = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_mv', $musicvideo);

//		*****************doc*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/8". "/4";
		$musicdoc = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_md', $musicdoc);

//		*****************aud*******************

		$url1 = "/getCreativityCatPost/" . $id1 ."/8". "/5";
		$musicaud = $this->Curl->fetchCurl($url1);
		$this->set('Creativity_ma', $musicaud);


	}

	//*********************most view**********//
	public function mostviewed() {
		$this->layout = 'creativity';


		$id = $this->Auth->user('userId');

		$this->layout = 'creativity';


		/****************per strt*************/
		$url1 = "/getCreativityPosts/" . $id . "/2";

		$json_array = $this->Curl->fetchCurl($url1);
		//debug($json_array);
		$this->set('Creativity_img', $json_array);



		/**********************video java******************/

		$url1 = "/getCreativityPosts/" . $id . "/3";
		$json_array = $this->Curl->fetchCurl($url1);

		$this->set('Creativity_vid', $json_array);


		/**********************doc java******************/

		$url1 = "/getCreativityPosts/" . $id . "/4";
		$json_array = $this->Curl->fetchCurl($url1);

		$this->set('Creativity_doc', $json_array);


		/**********************aud java******************/
		$url1 = "/getCreativityPosts/" . $id . "/5";
		$json_array = $this->Curl->fetchCurl($url1);

		$this->set('Creativity_aud', $json_array);


		/*********************per end**************/


		$combobox = $this->Post->find('all', array(
			'conditions' => array('AND' => array('Post.status' => '1', 'vertical_id' => '3'))));

		for ($i = 0; $i < count($combobox); $i++) {
			$CreativityTag[$i]['label'] = $combobox[$i]['Post']['keywords'];
			$CreativityTag[$i]['value'] = $combobox[$i]['Post']['id'];
		}

		if (count($combobox) > 0) {
			$this->set('tags', $CreativityTag);
			$this->setJsVar('creativitytag', $CreativityTag);
		} else {
			$this->set('tags', array());
			$this->setJsVar('creativitytag', array());
		}


	}

	public function edit()
	{
		$this->layout = 'creativity';
		$edit = $this->Post->find('all',array(
			'conditions'=>array('Post.status' => '1','Post.post_type_id' => '3','vertical_id'=>'3','Post.id'=>$this->request->params['pass'][0]),
			'limit' => 1,
			'order' => array('Post.id' => 'desc'),
			'recursive' => 1
		));
		$this->set('Creativity_edit',$edit);

		$editd = $this->Post->find('all', array(
			'conditions'=>array('Post.status' => '1','vertical_id'=>'3','Post.id'=>$this->request->params['pass'][0]),'Post.postby_id'=>$this->Auth->user('id'),

			'recursive' => 1

		));

		$this->set('Creativity_sa', $editd);

		$cat = array(1 => 'Movies', 2 => 'Music', 3 => 'Sports', 4 => 'Nature', 5 => 'Science', 6 => 'Comedy', 7 => 'Tutorials', 8 => 'Animation');
		$this->set('Creativity_cat', $cat);

	}



}



<?php

App::uses('Component', 'Controller');



/**
 * Created by IntelliJ IDEA.
 * User: gopu
 * Date: 27/5/16
 * Time: 1:41 PM
 */

class StatusShell extends AppShell{
	public $uses = array('Post');

	public function main()
	{
		$posts = $this->Post->find('all', array(
			'conditions' => array(
				'Post.status' => 3,
				'Post.post_type_id' => 3,
			),
			'recursive' => -1
		));



		foreach ($posts as $p_check) {

			$data = array(
				'link' => $p_check['Post']['link'],
				'id' => $p_check['Post']['id']
			);

			$this->checkstatus($data);

		}
	}

	public function  checkstatus($data)
	{

		$id = $data['link'];
		$postid=  $data['id'];



		$url=file_get_contents('https://www.googleapis.com/youtube/v3/videos?id='.$id.'&key=AIzaSyAbzAwTkkNtKfsu0uAqRGZb3M5zDim__DU&part=status');


		$value = json_decode($url);


		foreach($value->items as $item){



			if ($processed = $item->status->uploadStatus == 'processed'){


				$url = "http://localhost:8080/backend/updateStatusVideo";
				$ch = curl_init();
				curl_setopt($ch, CURLOPT_URL,$url);
				curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'POST');
				curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
				curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, 120);
				curl_setopt($ch, CURLOPT_TIMEOUT, 120);
				curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
				$cstatus = $result = curl_exec($ch);
				curl_close($ch);
				return json_decode($cstatus);

				echo json_encode($cstatus);


			}






		}




	}


}

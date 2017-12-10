

<?php

App::uses('Component', 'Controller');

App::import('Vendor','vendor', array('file' => 'youtube/vendor/autoload.php'));

/**
 * Created by IntelliJ IDEA.
 * User: gopu
 * Date: 27/5/16
 * Time: 1:41 PM
 */

class VideoShell extends AppShell {

	public $uses = array('Post');
	public $components = array('Session','Curl','Youtube');

	public function main() {
		$posts =  $this->Post->find('all',array(
			'conditions' => array(
				'Post.status' => 0,
				'Post.post_type_id' => 3,
			),
			'recursive' => -1
		));

		foreach($posts as $s_post){


			$data = array(
				'id' => $s_post['Post']['id'],
				'title' => $s_post['Post']['title'],
				'tag' => $s_post['Post']['keywords'],
				'link' => $s_post['Post']['link']
			);

			 $this->addvideo($data);
					debug($data);


		}
	}

	public function  addvideo($data)

	{
		debug($data);

		$key = file_get_contents('/var/www/html/wizspeak/app/Vendor/youtube/vendor/token.txt');
		debug($key);

		$client_id = '705474616018-jk45dieam0ijso5fdaklelg2srlb0mud.apps.googleusercontent.com';
		$client_secret = 'C0xQqjLTNWgdEev9Ec8Icyct';
		$APPNAME = "wizspeakyoutube";

		$path = '/var/www/html/wizspeak/app/webroot/upload/creativity/video/process/'.$data['link'];
		debug($path);
		$videoPath = $path;
		$videoTitle = $data['title'];
		debug($videoTitle);
		$videoDescription = $data['title'];
		$videoCategory = "22";
		$videoTags = $data['tag'];

		try {

			$client = new Google_Client();
			$client->setClientId($client_id);
			$client->setAccessType('offline');
			$client->setApprovalPrompt('force');
			$client->setAccessToken($key);
			$client->setClientSecret($client_secret);

			if ($client->getAccessToken()) {

				if ($client->isAccessTokenExpired()) {
					$newToken = json_decode($client->getAccessToken());
					$client->refreshToken($newToken->refresh_token);
					$key = '/var/www/html/wizspeak/app/Vendor/youtube/vendor/token.txt';
					debug($key);
					file_put_contents($key, $client->getAccessToken());
				}

				$youtube = new Google_Service_YouTube($client);


				$snippet = new Google_Service_YouTube_VideoSnippet();
				$snippet->setTitle($videoTitle);
				$snippet->setDescription($videoDescription);
				$snippet->setCategoryId($videoCategory);
				$snippet->setTags(explode(",",$videoTags));
				$snippet->setDefaultLanguage("en");
				$snippet->setDefaultAudioLanguage("en");

				$recordingDetails = new Google_Service_YouTube_VideoRecordingDetails();
				$recordingDetails->setLocationDescription("India");
				$recordingDetails->setRecordingDate("2016-01-20T12:34:00.000Z");
				$locationdetails = new Google_Service_YouTube_GeoPoint();
				$locationdetails->setLatitude("38.8833");
				$locationdetails->setLongitude("77.0167");
				$recordingDetails->setLocation($locationdetails);


				$status = new Google_Service_YouTube_VideoStatus();
				$status->setPrivacyStatus("public");
				$status->setPublicStatsViewable(false);
				$status->setEmbeddable(false);
				$video = new Google_Service_YouTube_Video();
				$video->setSnippet($snippet);
				$video->setRecordingDetails($recordingDetails);
				$video->setStatus($status);


				$chunkSizeBytes = 1 * 1024 * 1024;


				$client->setDefer(true);


				$insertRequest = $youtube->videos->insert("status,snippet,recordingDetails", $video);


				$media = new Google_Http_MediaFileUpload(
					$client,
					$insertRequest,
					'video/*',
					null,
					true,
					$chunkSizeBytes
				);
				$media->setFileSize(filesize($videoPath));


				$status = false;

				$handle = fopen($videoPath, "rb");
				while (!$status && !feof($handle)) {
					$chunk = fread($handle, $chunkSizeBytes);
					$status = $media->nextChunk($chunk);
				}

				fclose($handle);



				if ($status->status['uploadStatus'] == 'uploaded') {



						$posts =  $this->Post->find('all',array(
						'conditions' => array(
							'Post.status' => 0,
							'Post.post_type_id' => 3,
						),
						'recursive' => -1
					));


					foreach($posts as $l_post){

						$data = array(
							'ylink' => $status['id'],
							'id' => $l_post['Post']['id'],
						);



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


				$client->setDefer(true);

			} else {
				// @TODO Log error
				echo 'Problems creating the client';
			}

		} catch (Google_Service_Exception $e) {

			print "Caught Google service Exception " . $e->getCode() . " message is " . $e->getMessage();
			print "Stack trace is " . $e->getTraceAsString();
		} catch (Exception $e) {

			print "Caught Google service Exception " . $e->getCode() . " message is " . $e->getMessage();
			print "Stack trace is " . $e->getTraceAsString();
		}




	}

}

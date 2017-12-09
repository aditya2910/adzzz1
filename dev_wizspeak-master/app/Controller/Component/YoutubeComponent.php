<?php
App::uses('Component', 'Controller');

App::import('Vendor','vendor', array('file' => 'youtube/vendor/autoload.php'));





class YoutubeComponent extends Component {


	public function  addvideo($data)
	{
		debug($data);

		$key = file_get_contents($_SERVER['DOCUMENT_ROOT'] . '/wizspeaks/app/Vendor/youtube/vendor/token.txt');

		$client_id = '529155930764-52pd8rqp23f12b5p4pdiu2r7j9ch3p14.apps.googleusercontent.com';
		$client_secret = 'apZUAuJ15Vh2kOWWBlx8pIEG';
		$APPNAME = "wizspeakyoutube";

		$path = $_SERVER['DOCUMENT_ROOT'] . '/wizspeaks/app/webroot/upload/creativity/video/process/'.$data['link'];
		debug($path);
		$videoPath = $path;
		$videoTitle = $data['title'];
		debug($videoTitle);
		$videoDescription = $data['title'];
		$videoCategory = "22";
		$videoTags = "hi,data,sample";

		try {
			// Client init
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
					$key = $_SERVER['DOCUMENT_ROOT'] . '/wizspeaks/app/Vendor/youtube/vendor/token.txt';
					debug($key);
					file_put_contents($key, $client->getAccessToken());
				}

				$youtube = new Google_Service_YouTube($client);

// Create a snipet with title, description, tags and category id
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

// Create a video status with privacy status. Options are "public", "private" and "unlisted".
				$status = new Google_Service_YouTube_VideoStatus();
				$status->setPrivacyStatus("public");
				$status->setPublicStatsViewable(false);
				$status->setEmbeddable(false); // Google defect still not editable https://code.google.com/p/gdata-issues/issues/detail?id=4861

// Create a YouTube video with snippet and status
				$video = new Google_Service_YouTube_Video();
				$video->setSnippet($snippet);
				$video->setRecordingDetails($recordingDetails);
				$video->setStatus($status);

// Size of each chunk of data in bytes. Setting it higher leads faster upload (less chunks,
// for reliable connections). Setting it lower leads better recovery (fine-grained chunks)
				$chunkSizeBytes = 1 * 1024 * 1024;

// Setting the defer flag to true tells the client to return a request which can be called
// with ->execute(); instead of making the API call immediately.
				$client->setDefer(true);

// Create a request for the API's videos.insert method to create and upload the video.
				$insertRequest = $youtube->videos->insert("status,snippet,recordingDetails", $video);

// Create a MediaFileUpload object for resumable uploads.
				$media = new Google_Http_MediaFileUpload(
					$client,
					$insertRequest,
					'video/*',
					null,
					true,
					$chunkSizeBytes
				);
				$media->setFileSize(filesize($videoPath));

// Read the media file and upload it chunk by chunk.
				$status = false;

				$handle = fopen($videoPath, "rb");
				while (!$status && !feof($handle)) {
					$chunk = fread($handle, $chunkSizeBytes);
					$status = $media->nextChunk($chunk);
				}

				fclose($handle);

				/**
				 * Video has successfully been uploaded, now lets perform some cleanup functions for this video
				 */
				if ($status->status['uploadStatus'] == 'uploaded') {
					// Actions to perform for a successful upload
//					$htmlBody .= "<h3>Video Uploaded</h3><ul>";
//					$htmlBody .= sprintf('<li>%s (%s)</li>',
//						$status['snippet']['title'],
						$key = $status['id'];



					echo json_encode($status);
					// print("<pre>".print_r($status,true)."</pre>");


				}

// If you want to make other calls after the file upload, set setDefer back to false
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


debug($htmlBody);

}
}



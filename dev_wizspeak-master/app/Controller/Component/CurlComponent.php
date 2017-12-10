<?php
App::uses('Component', 'Controller');

class CurlComponent extends Component {


		private $path = "http://localhost:8080/backend";


        public function __construct() {



        }

        public function fetchCurl($url){
            $ch1 = curl_init();
            curl_setopt($ch1,CURLOPT_URL,$this->path.$url);
			curl_setopt($ch1,CURLOPT_RETURNTRANSFER,true);
			$output = curl_exec($ch1);
			curl_close($ch1);
			$result = json_decode($output);
			return $result;
        }



		public function postCurl($url,$json){

			$ch = curl_init($this->path.$url);
			curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "POST");
			curl_setopt($ch, CURLOPT_POSTFIELDS, $json);
			curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
			curl_setopt($ch, CURLOPT_HTTPHEADER, array(
					'Content-Type: application/json',
					'Content-Length: ' . strlen($json))
			);

			$result = curl_exec($ch);
		}


	public function postHttpCurl($url,$data){

		$ch = curl_init();
		curl_setopt($ch, CURLOPT_URL, $this->path.$url);
		curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'POST');
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
		curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, 120);
		curl_setopt($ch, CURLOPT_TIMEOUT, 120);
		curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
		$status = $result = curl_exec($ch);
		curl_close($ch);
		return json_decode($status);

	}

	public function putCurl($img_path){

		$file_name_with_full_path = realpath($img_path);

		$url = 'curl -F "action=uploadfile" -F "file=@'.$file_name_with_full_path.'" http://139.162.37.75/uploadfile';
		exec($url,$result);

		if($result[0]='file upload success'){
			return true;
		}
		return $result;

	}






}


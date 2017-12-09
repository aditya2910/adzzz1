<?php
App::uses('Component', 'Controller');

class CropComponent extends Component
{


	private $path = "http://localhost:8080/backend";
	private $cdn = "http://localhost/wizspeak/upload/images/14635727020_time.jpeg";

	public function __construct()
	{


	}


	public function profile_crop($filename, $dimensions,$user_id)
		{

			//debug("inside crop images".PROFILE_IMAGE_PATH.$filename);
			$filepath = PROFILE_IMAGE_PATH.'process/'.$filename;
			$file = WWW_ROOT .$filepath;
			$ini_filename = WWW_ROOT .$filepath;
			$ext = pathinfo($file, PATHINFO_EXTENSION);
			if ($ext == 'png' || $ext == 'PNG') {
				$imgFormat = imagecreatefrompng($ini_filename);
			}
			if ($ext == 'jpeg' || $ext == 'JPEG' || $ext == 'JPG' || $ext == 'jpg') {
				$imgFormat = imagecreatefromjpeg($ini_filename);
			}
			if ($ext == 'gif' || $ext == 'JIF') {
				$imgFormat = imagecreatefromgif($ini_filename);
			}
			if ($ext == 'bmp' || $ext == 'BMP') {
				$imgFormat = imagecreatefromwbmp($ini_filename);
			}
			$img_xy = getimagesize($ini_filename);
			$img_x = $img_xy[0];
			$img_y = $img_xy[1];
			//ratio change
			$x_ratio = 1;
			$y_ratio = 1;
			if (intval($img_x) > 600) {
				$x_ratio = $img_x / 600;
			}
			if (intval($img_y) > 600) {
				$y_ratio = $img_y / 600;
			}
			if ($x_ratio > $y_ratio) {
				$y_ratio = $x_ratio;
			} else {
				$x_ratio = $y_ratio;
			}
			$x = $dimensions['x'];
			$y = $dimensions['y'];
			$w = $dimensions['w'];
			$h = $dimensions['h'];
			//the minimum of xlength and ylength to crop.
			$crop_measure = min(60, 60); //image size needed -constant
			// Set the content type header - in this case image/jpeg
			//header('Content-Type: image/jpeg');
			$to_crop_array = array('x' => intval($x * $x_ratio), 'y' => intval($y * $y_ratio), 'width' => intval($w * $x_ratio), 'height' => intval($h * $y_ratio));
			$thumb_im = imagecrop($imgFormat, $to_crop_array);
			$this_user_pic = 'user_profile_crop' .$user_id .time() . '.jpeg';
			imagejpeg($thumb_im, PROFILE_IMAGE_PATH.'process/' . $this_user_pic, 100);

			return $this_user_pic;

		}

}

?>

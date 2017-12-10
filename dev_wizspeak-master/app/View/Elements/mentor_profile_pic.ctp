<?php
$pic = '/img/uploads/mentor_profile.jpg';
if(@getimagesize($profilePicMain)){

	$pic = $profilePicMain;
}


	echo $this->Html->image($pic,array(
		'url' => $link
	));


?>

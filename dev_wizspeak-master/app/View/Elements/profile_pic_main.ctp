<?php
$pic = '/img/userReg.jpg';
if(@getimagesize($profilePicMain)){

	$pic = $profilePicMain;
}

if($role==1){

	echo $this->Html->image($pic,array(
		'url' => $link
	));
}else{
	echo $this->Html->image($pic);
}

?>

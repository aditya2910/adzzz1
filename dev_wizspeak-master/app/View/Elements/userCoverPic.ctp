<div class="cover-image" >

	<?php
	//debug($userDetails->getCoverPic);
	if(@getimagesize(IMAGE_COVER_PIC.$userDetails->getCoverPic)){

		echo  $this->Html->image( IMAGE_COVER_PIC.$userDetails->getCoverPic);
	}else{
		if($role==1){
			echo $this->Html->image('/img/cover.jpg', array('class'=> 'crop-profile' ));
		}else{
			echo $this->Html->image('/img/nocover.jpg');
		}

	}


	?>
</div>

<?php if($role==1){ ?>
<div class="crop-profile-main">
	<span class="close-button crop-close"></span>
	<div id="img_place2" class="image-place-wrapper">
		<div class="crop-wrapper example">
			<!-- cropper container element -->

			<div class="default-container2">
			</div>
		</div>
	</div>
	<ul class="cmd">


		<div class="share" >
			<input type="button" class="browse-img common-button cropbutton" value="Browse" />
			<input type="button" class="flip-img common-button cropbutton" value="Flip Image" />
			<input type="button" class="rotate-img common-button cropbutton" value="Rotate" />


			<input type="button" class="base64-img common-button cropbutton"  id="saveimage" value="Save Changes" />
			<input type="button" class=" common-button"  id="crop-close" value="Cancel" />
		</div>
	</ul>
</div>
<?php  } ?>

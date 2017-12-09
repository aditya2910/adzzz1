
<div class="profile-row-mids">

	<div class="education-left">
		<div class="upload-profilePic">
			<div class="upload-profilePicinner">
				<?php
				$img = '/img/noUPic.png';
				if(@getimagesize(IMAGE_CHANGE.$userDetails->profilePic)){
				$img = IMAGE_CHANGE.$userDetails->profilePic;

				}
				echo $this->Html->image($img);
				?>

			</div>

		</div>
	</div>

	<div class="education-desc">
		<h3>Select Profile Icon</h3>
		<div class="edu-desc-row">
			<div class="edu-desc-row-inner">
				<?php if($role == 1) { ?>
					<input type='button' value="Select" data-rel="profile-image-crope" class='popup crop-overlay'>
				<?php } ?>
			</div>
		</div>

	</div>

<br><br><br><br><br>
	<div class="education-desc search-cat">
		<h3>User Ambitions</h3>
		<div class="edu-desc-row" id="search" >


			<div class="rows-reg">
				<div class="rows-reg-left">Add Ambitions</div>
				<div class="rows-reg-right">
					<?php echo $this->element("simple_search"); ?>
				</div>
			</div>
			<div class="rows-reg">
				<div class="rows-reg-left">&nbsp;</div>
				<div class="rows-reg-right">
					<div class="ambitions-listsel">
						<?php foreach ($aCategories as $key=>$category) {

							echo "<div class='sel-hob-main' id='".$key."'><div class='sel-copy'>".$category."</div><div class='sel-close'></div></div>";

						} ?>

					</div>
				</div>
			</div>



		</div>
		<div class="share">
			<input type="button" class="common-button share" value="SAVE" style="margin:10px;" id="saveAmb">

		</div>
		<br><br><br>
		<h3>User Hobbies</h3>
		<div class="edu-desc-row" id="search" >


			<div class="rows-reg">
				<div class="rows-reg-left">Add Hobbies</div>
				<div class="rows-reg-right">
					<?php echo $this->element("simple_search_hob"); ?>
				</div>
			</div>
			<div class="rows-reg">
				<div class="rows-reg-left">&nbsp;</div>
				<div class="rows-reg-right">
					<div class="hobbies-listsel">
						<?php foreach ($hCategories as $key=>$category) {

							echo "<div class='sel-hob-main' id='".$key."'><div class='sel-copy'>".$category."</div><div class='sel-close'></div></div>";

						} ?>

					</div>
				</div>
			</div>

		</div>

		<div class="share">
			<input type="button" class="common-button share" value="SAVE" style="margin:10px;" id="saveHob">

		</div>

	</div>



</div>
<?php
echo $this->Form->create('User', array('type'=>'file','id'=>'uploadfile',
	'url' => array('controller' => 'profiles', 'action' => $userDetails->userId , 'setting' )));

?>
<div class="simple_overlay" id="profile-row-mids">
	<div class="createG-left" >
		<h1>Crop Image</h1>
		<div id="img_place"  >
			<img src="" id="target" alt="" />
		</div>
	</div>
	<div class="createG-right" >
		<h3>Select image</h3>
		<div class="group-search">
			<?Php
			echo $this->Form->input('file', array('id' => 'crop_profile_pic_group_file', 'type' => 'file' ,'value' =>'Select' ));
			?>


		</div>

		<div id="preview-pane">
			<div class="preview-container">
				<img src="" class="jcrop-preview" id="imgp" alt="Preview" />
			</div>
		</div>


		<div class="share-button-wrapper">
			<input type="submit" class="common-button share" value="SHARE" />
			<input type="submit" class="common-button cancel" value="CANCEL">
		</div>

	</div>

</div>
<?php
echo $this->Form->input('x',array('id'=>'xx','type'=>'hidden'));
echo $this->Form->input('y',array('id'=>'xy','type'=>'hidden'));
echo $this->Form->input('w',array('id'=>'w','type'=>'hidden'));
echo $this->Form->input('h',array('id'=>'h','type'=>'hidden'));

echo  $this->Form->end(); ?>
<?php
echo $this->Form->input('x',array('id'=>'xx','type'=>'hidden'));
echo $this->Form->input('y',array('id'=>'xy','type'=>'hidden'));
echo $this->Form->input('w',array('id'=>'w','type'=>'hidden'));
echo $this->Form->input('h',array('id'=>'h','type'=>'hidden'));

echo  $this->Form->end(); ?>

<style>
	/* Apply these styles only when #preview-pane has
       been placed within the Jcrop widget */
	.jcrop-holder #preview-pane {
		display: block;
		position: absolute;
		z-index: 7000;
		top: 80px;
		right: -280px;
		padding: 6px;
		border: 1px rgba(0,0,0,.4) solid;
		background-color: white;

		-webkit-border-radius: 6px;
		-moz-border-radius: 6px;
		border-radius: 6px;

		-webkit-box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
		-moz-box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
		box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
	}

	/* The Javascript code will set the aspect ratio of the crop
       area based on the size of the thumbnail preview,
       specified here */
	#preview-pane .preview-container {
		width: 170px;
		height: 170px;
		overflow: hidden;
		z-index: 2001;
	}
	.simple_overlay{
		overflow: hidden;
	}
	.hobbies-listsel,
	.common-input,
	.ambitions-listsel
	{
		border: 1px solid #84708d;
	}
</style>
<?php

echo $this->Html->css('registration/jquery.Jcrop.css');

?>

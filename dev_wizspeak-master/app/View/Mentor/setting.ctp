<div class="profile-mid-section" id="media-tabs" >
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
		<h3>User Expertise</h3>
		<div class="edu-desc-row" id="search" >


			<div class="rows-reg">
				<div class="rows-reg-left">Add Expertise</div>
				<div class="rows-reg-right">
					<?php echo $this->element("mentor_category"); ?>
				</div>
			</div>
			<div class="rows-reg">
				<div class="rows-reg-left">&nbsp;</div>
				<div class="rows-reg-right">
					<div class="expertise-listsel">
						<?php foreach ($allCategories as $key=>$category) {

							echo "<div class='sel-hob-main' id='".$key."'><div class='sel-copy'>".$category."</div><div class='sel-close'></div></div>";

						} ?>

					</div>
				</div>
			</div>



		</div>
		<div class="share">
			<input type="button" class="common-button share" value="SAVE" style="margin:10px;" id="saveAll">

		</div>


	</div>



</div>


</div>

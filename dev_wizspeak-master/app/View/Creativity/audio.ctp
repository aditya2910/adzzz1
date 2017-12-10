<div class="mid-section">
	<div class="row-mid-notification search-notification">
		<input class="search-notif-input" />
		<input class="search-notif-button" type="submit" value="&#xf002;" name="search">
	</div>
	<div class="entrment-video">

		<div class="entrment-video-wrapper">

			<div class="post-users-video">
				<?php echo $this->Html->image('uploads/540.jpg'); ?>
				<audio controls autoplay style="width:100%"> id="example_video_<?php echo $audio->id; ?>"  poster=' <?php echo $this->Html->image('uploads/540.jpg'); ?>' width="100%" height="100%" controls preload="auto" data-setup="{}" controls autoplay>
					<source src="<?php echo APPURL.CRE_AUDIO_UPLOAD_FOLDER.$audio[0]->link ?>" type='audio/mpeg' />

				</audio>

			</div>


		</div>

		<div class="entrment-video-details">
			<h3><?php echo $audio[0]->title;

				?></h3>
			<div class="entrment-video-details2">
				<div class="entrment-videod-left">

					<span>Uploaded by <b><?php echo $audio[0]->postby_name ;


						?></b></span>
				</div>
				<div class="entrment-videod-mid">

					<div class="share">
						<input type="button" value="Follow" class="edit popup" data-rel="sharepopup">
					</div>
				</div>
				<div class="entrment-videod-right">
					<div class="post-users-option">
						<ul class="post-option-ulist">
							<li>
								<span class="star">&nbsp;</span>
							</li>
							<li>
								<span class="share-icon">&nbsp;</span>
							</li>
						</ul>
						<div class="post-likes">3 Views</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="share-box-single">
		<div class="share-box-top">
			<div class="postedby-image">

				<?php echo  $this->Html->image(IMAGE_PROFILE_WALL.$userdata->profilePic ,array(
					'url' => array('controller' =>'profiles',"action" => "about")
				)); ?>


			</div>
			<form id="creativity_comment" name="creativityz" >
				<div class="commnetedby">


					<textarea class="post-textarea" name="comment" placeholder="Hey Guys,......" id="comment"  ></textarea>


					<input type="text" name="post_id"  style="display:none"  value="<?php echo $audio[0]->id; ?>" />


				</div>

		</div>
		<div class="share-box-bottom">
			<div class="share-box-checkbox">
				<div class="custom-check">
					<div class="toogle-tick">
					</div>
					<input type="checkbox" />
				</div>
				<span>Public</span>
			</div>


			<div class="share">
				<input type="button"  id="submit"  value="Share"  />
				</form>
			</div>
		</div>
	</div>

	<?php echo  $this->element('creativity/wall'); ?>
</div>
<div class="right-panel">
	<div class="right-toggle-button">X</div>
	<div class="content-right">
		<div class="friend-mentors">
			<h3 class="mor-videos">More Videos</h3>
			<div class="custom-scroll  friend-list video-list">



				<?php foreach ($Creativity_aud as $key => $aud) {

					?>
					<div  class="filter-box">
						<a href="<?php echo APPURL.'creativity/audio/' . $aud->id ?>">
							<div data-rel="sharepopup-video"  class="filter-box-thumb ">
								<span class="icon-video">&#xf01d</span>
								<span title="<?php echo $aud->title; ?>"</span>


								<?php echo $this->Html->image('uploads/540.jpg'); ?>
							</div>

							<div class="filter-box-details">
								<h3><?php echo $aud->title; ?></h3>
								<div class="details-thumb">Uploaded by
									<b><?php echo $aud->postby_name ; ?></b>
								</div>
							</div>
						</a>

					</div>
				<?php                }  ?>




			</div>
			<div class="mentors addbox">

				<div class="ads">ADS</div>
				<div class="ads">ADS</div>
				<div class="ads">ADS</div>
				<div class="ads">ADS</div>
			</div>

		</div>

	</div>
</div>
<div class="clear"></div>
</div>
</div>
</div>
<div class="clear"></div>



<div class="simple_overlay shareOverlay" id="sharepopup">
	<div class="share-top">

		<div class="postedby-image">
			<img src="assets/images/uploads/profPic.jpg">
		</div>
		<textarea class="comments-share"></textarea>


	</div>
	<div class="share-image">
		<img src="assets/images/uploads/share.jpg" />
	</div>
	<div class="share-with">
		<h3>Shared with:</h3>
		<div class="share-list">

			<div class="sel-hob-main">
				<div class="sel-copy">Army doctors</div>
				<div class="sel-close"></div>
			</div>
			<div class="sel-hob-main">
				<div class="sel-copy">Mentors</div>
				<div class="sel-close"></div>
			</div>
			<a class="more-people">More People</a>
		</div>

	</div>
	<div class="share-bottom overlay-button">
		<div class="disable-notification">
			<div class="checkbox-wrapper">
				<div class="custom-check">
					<div class="toogle-tick">
					</div>
					<input type="checkbox" />
				</div>
				<span class="label-chk">Disable Notification</span>
			</div>
		</div>
		<div class="share-button-wrapper">
			<input type="submit" class="common-button share" value="SHARE">
			<input type="submit" class="common-button cancel" value="CANCEL">
		</div>

	</div>
</div>

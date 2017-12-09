<div class="mid-section">
	<div class="row-mid-notification search-notification">
		<input class="search-notif-input" />
		<input class="search-notif-button" type="submit" value="&#xf002;" name="search">
	</div>
	<div class="entrment-video">


		<div class="entrment-video-wrapper">
			<?php foreach ($Creativity_player as $key => $player) {  ?>
				<div class="post-users-video">
					<iframe title="YouTube video player" class="youtube-player" type="text/html"


							width="540" height="303" src= "<?php echo 'http://www.youtube.com/embed/'.$player->link; ?>?rel=0&amp;autoplay=1&amp;modestbranding=1"
							frameborder="0" allowFullScreen></iframe>


				</div>


			<?php                }  ?>
		</div>

		<div class="entrment-video-details">
			<h3><?php echo $player->title;
				?></h3>


			<div class="entrment-video-details2">
				<div class="entrment-videod-left">

					<span>Uploaded by <b><?php echo $player->postby_name ;


							?></b></span>
				</div>
				<div class="entrment-videod-mid">

					<div class="share">
						<input type="button" value="Follow" class="" data-rel="sharepopup">
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

<!--						<div class="post-likes">--><?php //echo $view; ?><!-- Views</div>-->

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


				<input type="text" name="post_id"  style="display:none"  value="<?php echo $player->id;  ?>" />


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
				<?php foreach ($Creativity_vid as $key => $vid) {

					?>
					<div  class="filter-box">
						<a href="<?php echo APPURL.'creativity/player/' . $vid->id ?>">
							<div data-rel="sharepopup-video"  class="filter-box-thumb ">
								<span class="icon-video">&#xf01d</span>
								<span title="<?php echo $vid->title; ?>"</span>


								<?php echo $this->Html->image('http://img.youtube.com/vi/'.$vid->link.'/mqdefault.jpg');
								?>
							</div>

							<div class="filter-box-details">
								<h3><?php echo $vid->title; ?></h3>
								<div class="details-thumb">Uploaded by
									<b><?php echo $vid->postby_name ; ?></b>
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

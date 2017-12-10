<div class="full-container main-content">
	<div class="fixed-container">
		<div class="left-container-profile">
			<div class="profile-top-section">
				<?php echo $this->element("userCoverPic") ?>
				<div class="cover-desc">
					<div class="cover-inner">
						<div class="cover-inner-left">
							<div class="cover-profile-Pic">
								<?php echo $this->element("profile_pic_main",array('profilePicMain' => IMAGE_PROFILE_MAIN.$userDetails->profilePic,
									'link' => array("controller" => 'profiles','action' => $userDetails->userId,"setting") )); ?>
							</div>
							<div class="cover-pic-Disc">
								<div class="cover-pic-disc-name">
									<h3><?php echo $userDetails->first_name. " ". $userDetails->last_name?></h3>
									<h5 title="<?php echo $userDetails->profileStatus; ?>" ><?php echo substr($userDetails->profileStatus,0,35); ?></h5>
								</div>
								<!--
								<div class="cover-pic-disc-award">
									<div class="rating-wrapper" data-id="<?php echo $userDetails->userId; ?>" >

										<input type="radio" name="example" class="rating" value="1" <?php if($userRating > 1) {?> checked="checked" <?php } ?> />
										<input type="radio" name="example" class="rating" value="2" <?php if($userRating > 2) {?> checked="checked" <?php } ?>  />
										<input type="radio" name="example" class="rating" value="3" <?php if($userRating > 3) {?> checked="checked" <?php } ?>  />
										<input type="radio" name="example" class="rating" value="4" <?php if($userRating > 4) {?> checked="checked" <?php } ?> />
										<input type="radio" name="example" class="rating" value="5" <?php if($userRating > 5) {?> checked="checked" <?php } ?>  />
									</div>
								</div>
								-->

							</div>

							<div class="cover-pic-Disc-right">
								<div class="share">
									<?php if(isset($friend_status->status)){ ?>
										<input type="button" id="friend" class="common-button share friend" data="<?php echo $friend_status->status; ?>" data-id="<?php echo $friend_status->id; ?>" value="<?php echo $friend_status->word; ?>" style="margin:10px;" >
										<?php if($friend_status->status == 1) { ?>

											<input type="button" id="" class="common-button share friend" data="" data-id="<?php echo $friend_status->id; ?>" value="Reject Friend Request" style="margin:10px;" >
										<?php } }?>
								</div>
								<?php if($role==1) { ?>
								<div class="share">
									<span class="pencil crop-profile">&nbsp;</span>
								</div>
								<?php } ?>
							</div>
						</div>



							<?php echo $this->element('profile/user_menu'); ?>

						</div>
					</div>
				</div>
				<div class="profile-main-section">
					<div class="left-panel">
						<div class="content-left">
							<div class="groups">

								<?php echo $this->element('group_list'); ?>

							</div>
						</div>
					</div>

					<div class="profile-mid-section" id="media-tabs" >
						<?php
						$this->Paginator->options['url'] = array('controller' => 'profiles', 'action' => $userDetails->userId,'videos');


						echo $this->element('profile/'.$select);
						?>
					</div>


				</div>
			</div>
			<div class="right-panel">
				<div class="right-toggle-button">X</div>
				<div class="content-right">
					<div class="friend-mentors">
						<?php echo $this->element('friend'); ?>
						<?php echo $this->element('mentor'); ?>
					</div>
				</div>
			</div>

			<div class="clear"></div>
		</div>
	</div>
	<?php   echo $this->element('hidden_forms');  ?>

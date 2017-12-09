<div class="full-container main-content">
	<div class="fixed-container">
		<div class="left-container-profile">
			<div class="profile-top-section">
				<div  class="cover-image" id="cover_pic_div">
					<div id="draggableHelper" style="position: relative; left: ; top: "  >
						<?php ?>

						<?php

						$cover = 'img/banner_profile.jpg';
						$file = GROUP_COVER_PIC.$groupDetail->coverPic.'.jpg';
						//                                debug('asssssssssssss');
						//                                debug(file_exists($file));
						//                                debug($mygroup);
						//                                debug($file);
						if(file_exists($file) && ($groupDetail->coverPic != '')){
							$cover = GROUP_COVER_PIC.$groupDetail->coverPic.'.jpg';
						}


						echo $this->Html->image('/'.$cover,array('id' => 'draggMe')); ?>


					</div>
				</div>

				<div  class="cover-image" id="cover_image_upload" >
					<?Php


					if($userGroupRole==1) {

						$left = 0;
						$top = 0;
						if (isset($mygroup['GroupProfile']['top'])) {
							$top = $mygroup['GroupProfile']['top'];
							$left = $mygroup['GroupProfile']['left'];
						}
						echo $this->Form->create('coverpic', array('type' => 'file', 'id' => 'cover_image_upload_form',
							'url' => array('controller' => 'groups', 'action' => $groupDetail->id)));
						echo $this->Form->input('cover', array('type' => 'hidden', 'value' => 'cover'));
						echo $this->Form->input('file', array('type' => 'file', 'id' => 'cover_pic_upload', 'label' => false));
						echo $this->Form->input('top', array('type' => 'hidden', 'id' => 'cover_top', 'value' => $top));
						echo $this->Form->input('left', array('type' => 'hidden', 'id' => 'cover_left', 'value' => $left));
						echo '<input type="button" value="Drag" id="enable_cover_drag"  />';
						echo $this->Form->submit('save');
						echo $this->form->end();
					}
					?>

				</div>
				<div class="cover-desc">
					<div class="cover-inner">
						<div class="cover-inner-left">
							<div class="cover-profile-Pic">
								<?php echo $this->element("profile_pic_main",array('profilePicMain' => IMAGE_PROFILE_MAIN.$groupDetail->profilePic,
									'link' => array("controller" => 'groups','action' => $groupDetail->customUrl,"about"),'role' => $userGroupRole )); ?>
							</div>
							<div class="cover-pic-Disc">
								<div class="cover-pic-disc-name">
									<h3><?php echo $groupDetail->name ?></h3>
									<h5><?php echo substr($groupDetail->description,-20); ?></h5>

								</div>

							</div>
							<div class="cover-pic-Disc-right">
								<div class="share">


									<input type="button" value="filter" />

									<?php if($userGroupRole==1){ ?>
										<span class="wcamera">&nbsp;</span>
									<?php } ?>




								</div>
							</div>
						</div>
						<!------------------- menu------------------------->

						<?php
						echo $this->element("group/menu");
						?>




						<!------------------- menu------------------------->

					</div>
				</div>
			</div>
			<div class="profile-main-section">
				<div class="left-panel">
					<div class="content-left">
						<div class="groups">

							<?php echo $this->element('group_list',array("helptext" => "Oh, this text is very helpful.")); ?>

						</div>
					</div>
				</div>
				<div class="profile-mid-section">

					<?php

						echo $this->element('group/media-audio');

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
<?php

//  echo $this->Html->script('jquery/jquery.js');

echo $this->element('hidden_forms');

?>

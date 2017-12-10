<div class="friend-list">
	<h2>
		<span class="iocnmen"></span>Who to Follow</h2>
	<div class="custom-scroll mentors-list-main">
		<?php

		foreach($userMentorSuggections as $index => $mentor):
//debug($mentor);
			?>
			<div class="mentor-row">
				<div class="mentor-pic">
					<?php
					$pic = '/img/mentorReg.jpg';
					if(@getimagesize(IMAGE_PROFILE_MAIN.$mentor->profilePic)){

						$pic = IMAGE_PROFILE_MAIN.$mentor->profilePic;
					}

					echo $this->Html->image($pic,array(
						'url' => array(
							'controller'=>'mentor','action'=>$mentor->userId,'about'
						)
					));


					?>
				</div>
				<div class="mentor-detail">
					<h4>
						<?php
						echo $this->Html->link(
							$mentor->first_name." ".$mentor->last_name,
							array(
								'controller' => 'mentor',
								'action' => $mentor->userId.'/about',
								'full_base' => true
							),array('class' => 'row-pic-name')
						);
						?>
					</h4>
					<p>Mentor</p>
				</div>
				<div class="share">

					<?php
					echo $this->Html->link(
						'<input type="button" value="Follow" name="follow"/>',
						array(
							'controller' => 'mentor',
							'action' => $mentor->userId.'/about',
							'full_base' => true
						),array('class' => 'row-pic-name','escape' => false)
					);
					?>
				</div>

			</div>
		<?php endforeach ?>
	</div>
</div>

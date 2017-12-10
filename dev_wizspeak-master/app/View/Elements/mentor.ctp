<div class="mentors">
    <h2>
        <span class="iocnmen"></span>Mentors</h2>
    <div class="custom-scroll mentors-list-main">
    	<?php

	      foreach($userMentors as $index => $mentor):
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
										'controller'=>'mentor','action'=>$mentor->userId,'wall'
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
						'action' => $mentor->userId.'/wall',
						'full_base' => true
					),array('class' => 'row-pic-name')
				);
				?>
                </h4>
                <p>Mentor</p>
            </div>
            <div class="mentor-mail">
				<?php
				echo $this->Html->link(
					'',
					'/mentor/'.$mentor->userId.'/talk/'.$this->Session->read('Auth.User.userId'),
					array('class' => 'envelope')
				);

				?>

            </div>
        </div>
        <?php endforeach ?>
    </div>
</div>

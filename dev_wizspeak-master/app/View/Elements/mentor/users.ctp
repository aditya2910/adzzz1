
            <div class="post-main" id="postboxid" >

                <div class="post-options">
                    <span class="iocnfr"></span>Mentor list</h2>
                    <div class="filter-search">
                        <input type="search" data-sort="cover-pic-disc-name" id="mentor-users-list" placeholder="Search here.." class="friend-search"  />
                    </div>

                </div>

            </div>

            <div class="profile-row-mids">
                <?php
                      foreach($menti as $index => $mentor):

                          ?>

                        <div class="cover-inner-left">
                            <div class="cover-profile-Pic">

								<?php
								$pic = '/img/userReg.jpg';
								if(@getimagesize(IMAGE_PROFILE_MAIN.$mentor->profilePic)){

									$pic = IMAGE_PROFILE_MAIN.$mentor->profilePic;
								}

								echo $this->Html->image($pic,array(
									'url' => array(
										'controller'=>'profiles','action'=>$mentor->userId
									)
								));

								?>

                            </div>
                            <div class="cover-pic-Disc">
								<?php
								$dicComt = '<h3>'.$mentor->first_name.'&nbsp;'.$mentor->last_name.'</h3>'.
									'<h5>'.$mentor->profileStatus.'</h5>';
								$div = $this->Html->div(null,$dicComt,array('class'=>'cover-pic-disc-name'));

								echo $this->Html->link($div,array(
									'controller' => 'profiles',
									'action' => $mentor->userId
								),
									array( 'escape' => false));
								?>

                            </div>
                        </div>

                <?php endforeach; ?>

            </div>

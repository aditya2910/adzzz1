                <div class="left-panel">
                    <div class="content-left">
                        <div class="profile">
							<div class="profile-pic">

								<?php

								echo $this->element('mentor_profile_pic',
									array(
										'link' => array(
											'controller' => 'profiles',
											'action' => $userDetails->userId
										),
										'profilePicMain' => IMAGE_PROFILE_AMB.$userDetails->profilePic
									));

								?>

							</div>
                            <h2 class="profile-name"><?php echo $user['User']['first_name'].' '.$user['User']['last_name'] ?></h2>
                            <p class="profile-abition"></p>
                            <ul class="rating">
                                <li class="active">&nbsp;</li>
                                <li class="active">&nbsp;</li>
                                <li class="active">&nbsp;</li>
                                <li>&nbsp;</li>
                                <li>&nbsp;</li>
                            </ul>
                            <div class="row-leftpanel">
                                <?php if(AuthComponent::user('id') != $user['User']['id']){  if($is_following) {?>
                                <input type="button" value="UN-FOLLOW" class="common-button un-follow" />
                                <?php }else{ ?>
                                <input type="button" value="FOLLOW" class="common-button follow" />
                                <?php } }?>

                            </div>


                        </div>
                        <div class="groups">
                            <?php echo $this->element('menti'); ?>


                        </div>
                    </div>
                </div>
                <div class="mid-section">
                    <?php echo $this->element('mentor/'.$select);  ?>

                </div>

                <div class="right-panel">
                    <div class="right-toggle-button">X</div>
                    <div class="content-right">
                        <div class="friend-mentors">

                            <div class="mentors">
                                <?php if($user_id == AuthComponent::user('id')) {?>
                                <h2>Messages</h2>
                                <div class="custom-scroll mentors-list-main">
                                    <div class="mentor-row">
                                        <div class="mentor-pic">
                                            <img src="img/uploads/mentors.jpg" />
                                        </div>
                                        <div class="mentor-detail">
                                            <h4>Robert Jemes</h4>
                                            <p>Sr. Surgon</p>
                                        </div>
                                        <div class="mentor-mail">
                                            <a href="#" class="envelope"></a>
                                        </div>
                                    </div>
                                    <div class="mentor-row">
                                        <div class="mentor-pic">
                                            <img src="img/uploads/mentors2.jpg" />
                                        </div>
                                        <div class="mentor-detail">
                                            <h4>Jacob Robinson</h4>
                                            <p>Sr. Surgon</p>
                                        </div>
                                        <div class="mentor-mail">
                                            <a href="#" class="envelope"></a>
                                        </div>
                                    </div>
                                    <div class="mentor-row">
                                        <div class="mentor-pic">
                                            <img src="img/uploads/mentors3.jpg" />
                                        </div>
                                        <div class="mentor-detail">
                                            <h4>Erik Mc Williams</h4>
                                            <p>Sr. Surgon</p>
                                        </div>
                                        <div class="mentor-mail">
                                            <a href="#" class="envelope"></a>
                                        </div>
                                    </div>
                                    <div class="mentor-row">
                                        <div class="mentor-pic">
                                            <img src="img/uploads/mentors4.jpg" />
                                        </div>
                                        <div class="mentor-detail">
                                            <h4>Jake Sullivan</h4>
                                            <p>Physicist</p>
                                        </div>
                                        <div class="mentor-mail">
                                            <a href="#" class="envelope"></a>
                                        </div>
                                    </div>
                                    <div class="mentor-row">
                                        <div class="mentor-pic">
                                            <img src="img/uploads/mentors5.jpg" />
                                        </div>
                                        <div class="mentor-detail">
                                            <h4>Aaron Washington</h4>
                                            <p>Gynecologist</p>
                                        </div>
                                        <div class="mentor-mail">
                                            <a href="#" class="envelope"></a>
                                        </div>
                                    </div>
                                    <div class="mentor-row">
                                        <div class="mentor-pic">
                                            <img src="img/uploads/mentors5.jpg" />
                                        </div>
                                        <div class="mentor-detail">
                                            <h4>Aaron Washington</h4>
                                            <p>Gynecologist</p>
                                        </div>
                                        <div class="mentor-mail">
                                            <a href="#" class="envelope"></a>
                                        </div>
                                    </div>
                                    <div class="mentor-row">
                                        <div class="mentor-pic">
                                            <img src="img/uploads/mentors5.jpg" />
                                        </div>
                                        <div class="mentor-detail">
                                            <h4>Aaron Washington</h4>
                                            <p>Gynecologist</p>
                                        </div>
                                        <div class="mentor-mail">
                                            <a href="#" class="envelope"></a>
                                        </div>
                                    </div>

                                </div>
                                <?php }else{ ?>
                                <?php echo $this->element('friend'); ?>
                                <?php } ?>
                            </div>

                        </div>

                    </div>
                </div>
                <div class="clear"></div>
<?php

  //  echo $this->Html->script('jquery/jquery.js');
echo $this->element('report');
?>


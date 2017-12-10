
        <div class="full-container main-content">
            <div class="fixed-container">
                <div class="left-panel">
                    <div class="content-left">
                        <div class="profile">
                            <div class="profile-pic" onclick="profilePage()">
								<?php echo $this->element("profile_pic_main",array('profilePicMain' => IMAGE_PROFILE_AMB.$userDetails->profilePic,
									'link' => array("controller" => 'profiles','action' => $userDetails->userId ),'role' => 1 )); ?>
                            </div>
                            <h2 class="profile-name"><?php

								echo ( $userDetails->first_name.' '.$userDetails->last_name); ?></h2>
                            <p class="profile-abition"><?php echo $userDetails->profileStatus ?></p>
<!--
                            <ul class="rating">
								<?php
								for($r =0;$r < 5;$r++){

									if((5-$userRating) > $r){

										echo '<li>&nbsp;</li>';
									}else{

										echo '<li class="active">&nbsp;</li>';
									}
								}

								?>

                            </ul>
							-->
                        </div>
                        <div class="groups">
                            <?php echo $this->element('group_list',array("helptext" => "Oh, this text is very helpful.")); ?>


                        </div>
                    </div>
                </div>

    <!-- xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx -->
                <!-- POst Section Start -->

                <div class="mid-section" id="mid-section" >
                    <div class="post-main" id="postboxid" >
                        <textarea placeholder="Hey Guys,......" id="post_box" class="post-textarea"></textarea>
                        <div id="preview_postimage" >

                        </div>
                        <div id="preview_postvideo" >


                        </div>
                        <div id="preview_postaudio" >


                        </div>
                        <div id="preview_postdoc" >


                        </div>
                        <progress class="progress-video" value="0" max="100"></progress>
                        <div class="post-options">
                            <ul class="post-ulist">
                                <li>
                                    <span class="camera">&nbsp;</span>
                                </li>
                                <li>
                                    <span class="video-camera">&nbsp;</span>
                                </li>
                                <li>
                                    <span class="file-text">&nbsp;</span>
                                </li>
                                <li>
                                    <span class="volume-off">&nbsp;</span>
                                </li>

                            </ul>
                            <div class="share">
                                <input type="button"  id="share" value="Share"  />
                            </div>

                        </div>


                        <?php  //echo $this->element('google_map'); ?>
                    </div>

                    <div id='Posts'>

                        <?php echo  $this->element('wall'); ?>
                    </div>

                    <?php
					if(count($userPosts)>9){
						echo $this->Paginator->next('more ...');
					}
                    ?>
                </div>


                <!-- POst Section Ends -->
    <!-- xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx -->

                <div class="right-panel">
                    <div class="right-toggle-button">X</div>
                    <div class="content-right">
                        <div class="friend-mentors">

                            <?php echo $this->element('friend'); ?>
                            <?php echo $this->element('mentor'); ?>

                        </div>
                        <div class="adds-main">
                            <div class="adds-row">ADDS</div>
                            <div class="adds-row">ADDS</div>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
<?php

  echo $this->element('popUp');
  echo $this->element('report');

?>

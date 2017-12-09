
            <div class="post-main" id="postboxid" >

                <div class="post-options">
                    <span class="iocnfr"></span>Mentor list</h2>
                    <div class="filter-search">
                        <input type="search" data-sort="cover-pic-disc-name" id="visitor-mentor-search" placeholder="Search here.." class="friend-search"  />
                    </div>

                </div>

            </div>

            <div class="profile-row-mids">
                <?php
                      foreach($userMentors as $index => $mentor):
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
                                <div class="cover-pic-disc-name">
									<h3><?php echo $mentor->first_name;?> <?php echo $mentor->last_name; ?></h3>

                                </div>
                            </div>
                        </div>

                <?php endforeach; ?>

            </div>
<script src="http://listjs.com/no-cdn/list.js"></script>
<script>
    var options = {
  valueNames: [ 'cover-pic-disc-name' ]
};

var userList = new List('users', options);
    </script>

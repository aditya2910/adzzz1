<div class="friend-list">
    <h2>
        <span class="iocnfr"></span>Friends list</h2>
       <div class="custom-scroll friend-list-row-main">


		       <?php //pr($user);

                       //$userFriends = $this->requestAction('user_friends/get_friend_list/'.$user['User']['id']);
			     foreach($userFriends as $index=> $post){

                                if($index % 3 == 0) {
                                if($index != 0){
                                 echo '</div>';
                                   }

                                echo '<div class="group-row">';
                                  } ?>

                            <div class="group-row-box">
		                <div class="online">&nbsp;</div>
		                <div class="row-pic">

							<?php
							$pic = '/img/userReg.jpg';
							if(@getimagesize(IMAGE_PROFILE_MAIN.$post->profilePic)){

								$pic = IMAGE_PROFILE_MAIN.$post->profilePic;
							}

								echo $this->Html->image($pic,array(
									'url' => array(
										'controller'=>'profiles','action'=>$post->userId
									)
								));


							?>
		                </div>
		                <div>
		                	<?php

							echo $this->Html->link(
								$post->first_name." ".$post->last_name,
							array(
							'controller' => 'profiles',
							'action' => $post->userId,
							'full_base' => true
							),array('class' => 'row-pic-name')
							);
							?>
		                </div>
		            </div>

                                <?php
                                if( ($index+1)  == count($userFriends)){
                                    echo '</div>';
                                } }    ?>


      </div>
</div>

<?php
      //  $menti = $this->requestAction('user_mentor_followers/get_mentor_followers/'.$user_id);

?>
                        <div class="group-row-main">
                                <h3>
                                    <span class='group-name'>Protege</span>
                                    <span class='group-number'>(<?php echo  count($menti) ; ?>  -  followers)</span>
                                </h3>
                                <?php foreach($menti as $index => $user) {

                                if($index % 3 == 0) {
                                if($index != 0){
                                 echo '</div>';
                                   }

                                echo '<div class="group-row">';
                                  } ?>

                                    <div class="group-row-box">
                                        <div class="row-pic">

											<?php
											$pic = '/img/userReg.jpg';
											if(@getimagesize(IMAGE_PROFILE_MAIN.$user->profilePic)){

												$pic = IMAGE_PROFILE_MAIN.$user->profilePic;
											}

											echo $this->Html->image($pic,array(
												'url' => array(
													'controller'=>'profiles','action'=>$user->userId
												)
											));


											?>


                                        </div>
                                        <div >
										<h3>
												<?php

											echo $this->Html->link(

												$user->first_name." ".$user->last_name,
												array(
													'controller' => 'profiles',
													'action' => $user->userId
												),
												array('class' => 'row-pic-name')
											);

											 ?>
										</h3>
										</div>
                                    </div>

                                <?php
                                if( ($index+1)  == count($menti)){
                                    echo '</div>';
                                } }    ?>

                            </div>

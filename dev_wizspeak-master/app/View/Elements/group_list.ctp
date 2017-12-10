                            <div class="group-row-main">
                                <h3>
                                    <span class='group-name'>Ambition</span>
                                    <span class='group-number'>(<?php echo  count($userGroups[0]) ; ?>  -  groups)</span>
                                </h3>
                                <?php foreach($userGroups[0] as $index => $group) {

                                if($index % 3 == 0) {
                                if($index != 0){
                                 echo '</div>';
                                   }

                                echo '<div class="group-row">';
                                  } ?>

                                    <div class="group-row-box">
                                        <div class="row-pic">

											<?php
											$pic = '/img/ambition.jpg';
											if(@getimagesize(IMAGE_PROFILE_MAIN.$group->profilePic)){

												$pic = IMAGE_PROFILE_MAIN.$group->profilePic;
											}

											echo $this->Html->image($pic,array(
												'url' => array(
													'controller'=>'groups','action'=>$group->customUrl,'about'
												)
											));


											?>

                                        </div>
                                        <div>

											<?php
											echo $this->Html->link(
												$group->name,
												array('controller' => 'groups' ,'action' => $group->customUrl,"about" ),
												array('class' => 'row-pic-name')

											);

											 ?>
										</div>
                                    </div>

                                <?php
                                if( ($index+1)  == count($userGroups[0])){
                                    echo '</div>';
                                } }    ?>

                            </div>
                            <div class="group-row-main">
                                <h3>
                                    <span class='group-name'>Hobbies</span>
                                    <span class='group-number'>(<?php echo count($userGroups[1]); ?>  -  groups)</span>
                                </h3>
                                <?php foreach($userGroups[1] as $index => $group) {

                                if($index % 3 == 0) {
                                if($index != 0){
                                 echo '</div>';
                                   }

                                echo '<div class="group-row">';
                                  } ?>

                                    <div class="group-row-box">
                                        <div class="row-pic">

											<?php
											$pic = '/img/ambition.jpg';
											if(@getimagesize(IMAGE_PROFILE_MAIN.$group->profilePic)){

												$pic = IMAGE_PROFILE_MAIN.$group->profilePic;
											}

											echo $this->Html->image($pic,array(
												'url' => array(
													'controller'=>'groups','action'=>$group->customUrl,'about'
												)
											));


											?>

                                        </div>
                                        <div>
											<?php
											echo $this->Html->link(
												$group->name,
												array('controller' => 'groups' ,'action' => $group->customUrl,"about" ),
												array('class' => 'row-pic-name')

											);

											?>
											</div>
                                    </div>

                                <?php
                                if( ($index+1)  == count($userGroups[1])){
                                    echo '</div>';
                                } }    ?>

                            </div>





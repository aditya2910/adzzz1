<div class="simple_overlay groupcreate" id="creategroup">
    <div class="createG-left">
        <?php

//        pr($ambition_categorys);
//        pr($ambition_subcategorys);
        echo $this->Form->create('create-ambition-group'); ?>
        <h3>CREATE GROUP</h3>
        <div class="createG-row">
            <div class="createG-row-label">Group Name :</div>
            <div class="createG-row-value">
                <?Php echo $this->Form->input('title',array('class' => 'form-input2', 'label' => false, 'required' => true)); ?>
            </div>
        </div>
		<div class="createG-row">
			<div class="createG-row-label">Category :</div>
			<div class="createG-row-value">

				<!-- search html start -->
				<?Php echo $this->Form->input('ambitions_subcategory_id',array('type' => 'select' ,'options' => $userCategory,'class' => 'custom-select','required' =>true, 'label' => false)); ?>

				<!-- search html ends here -->

			</div>
		</div>

        <div class="createG-row">
            <div class="createG-row-label">Invite Peoples :</div>
            <div class="createG-row-value">
                <div class="invite-peoples">



                </div>
            </div>
        </div>
        <div class="createG-row">
            <div class="createG-row-label">Status :</div>
            <div class="createG-row-value">
                <?Php echo $this->Form->input('about',array('class' => 'form-input2', 'label' => false)); ?>
            </div>
        </div>
        <div class="createG-row">
            <div class="createG-row-label">Description :</div>
            <div class="createG-row-value">
                <?php echo  $this->Form->textarea('description',array('class' => 'create-desc', 'label' => false)); ?>

            </div>
        </div>
        <div class="createG-row">
            <div class="createG-row-label">Accessibility :</div>
            <div class="createG-row-value">

                <div class="share-bottom overlay-button butn-adj">
                    <div class="radio-main">
                        <div class="custom-radio-wrap">

                            <div class="custom-radio">
                                <div class="toogle-tick">
                                </div>
                                <input type="radio" value="pub" name="data[create-ambition-group][visibility]" checked="checked" />
                            </div>
                        </div>
                        <div class="label-radio">Public</div>
                    </div>
                    <div class="radio-main">
                        <div class="custom-radio-wrap">

                            <div class="custom-radio">
                                <div class="toogle-tick">
                                </div>
                                <input type="radio" value="pvt" name="data[create-ambition-group][visibility]"  />
                            </div>
                        </div>
                        <div class="label-radio">Private</div>
                    </div>
                    <div class="share-button-wrapper">
                        <input type="submit" id="invite-friend-group-submit" class="common-button share" value="SHARE">
                        <input type="reset" class="common-button reset" value="CANCEL">
                    </div>
                </div>
            </div>
        </div>
        <?php echo $this->Form->input('invited',array('id' => 'invited','label' => false,'hidden' => true)); ?>

        <?php echo $this->Form->end(); ?>
    </div>
    <div class="createG-right">
        <h3>Friends List</h3>
        <div class="group-search">
            <input type="text" id="filter_friend" class="form-input2 group-search-input" />
            <input type="submit" value="&#xf002;"  class="filterSR-submit group-search-submit" />
        </div>
        <div class="creatG-friends custom-scroll">
            <ul  class="create_group_popup_friend_list">
                <?php
                    foreach($userFriends as $index => $my_friend){

		?>
                <li data-tab="<?php echo $my_friend->id; ?>" class='invite-friend-group' >
                    <div class="group-row-box">
                        <div class="row-pic">
							<?php
							$imagePath = "../img/userReg.jpg";
							if($my_friend->profilePic) {
								$imagePath = IMAGE_PROFILE_WALL.$my_friend->profilePic;
							}

							echo $this->Html->image($imagePath);

                            ?>

                        </div>
                    </div>
                    <div class="nameDisplay">
                        <h3><?php echo $my_friend->first_name.' '.$my_friend->last_name; ?></h3>
                        <p><?php echo $my_friend->profileStatus; ?></p>
                    </div>
                </li>
                    <?php } ?>

            </ul>
        </div>
    </div>

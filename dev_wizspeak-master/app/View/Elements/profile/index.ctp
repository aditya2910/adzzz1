                            <div class="profile-row-mids" id="about_me_labels">
								<?php if($role == 1) { ?>
                                <div class="editPencil pencil" id="about_me">&nbsp;</div>
								<?php } ?>

                                <h3>About</h3>
                                <p><?php echo $userDetails->profileStatus; ?></p>


                            </div>
                            <div class="profile-row-mids" id="about_me_edit" style="display:none;">
                                <textarea id="about_me_edit_text" name="about_me_edit" style="width:99%;font-family: inherit;" rows="4"><?php echo $userDetails->profileStatus;; ?></textarea>
                                <div class="share">
					                <input type="button" class="common-button share" value="SAVE" style="margin:10px;">
					                <input type="button" class="common-button cancel" value="CANCEL" style="margin:10px;">
					            </div>
                            </div>


                            <div class="profile-row-mids">
								<?php if($role == 1) { ?>
                                <div class="editPencil add">&nbsp;</div>
								<?php } ?>
                                <div class="education-left">
                                    <?php echo $this->Html->image('merge/uploads/education.jpg'); ?>
                                    <div class="education-left-desc">St Alberts University</div>
                                </div>
                                <div class="education-desc" id="edu_first">
                                    <h3>Education</h3>
                                    <?php echo $this->Form->create('user_educations',array('type'=>'hidden','id'=>'user_education_id'));  ?>
                                    <div class="edu-desc-row" style="display:none;" id="ui_add">
                                        <div class="edu-desc-row-inner">
                                            <label>Education</label>
                                            <span>
                                                <?php echo $this->Form->input('education',array('id' => 'education_id','type' => 'text','label' => FALSE ,'required' => true)) ?>
                                            </span>
                                        </div>
                                        <div class="edu-desc-row-inner">
                                            <label>School/Institute</label>
                                            <span>
                                                <?php echo $this->Form->input('institute',array('id' => 'institute_id','type' => 'text','label' => FALSE ,'required' => true)) ?>
                                            </span>
                                        </div>
                                        <div class="edu-desc-row-inner">
                                            <label>University</label>
                                            <span>
                                                <?php echo $this->Form->input('university',array('id' => 'institute_id','type' => 'text','label' => FALSE ,'required' => true)) ?>
                                            </span>
                                        </div>
                                        <div class="edu-desc-row-inner">
                                            <label>Date From</label>
                                            <span>
                                            <?php
                                                echo $this->Form->input('date_from', array(
                                                    'type' => 'date',
                                                    'label' => FALSE,
                                                    'type' => 'date',
                                                    'dateFormat' => 'MY',
                                                    'minYear' => date('Y') - 100,
                                                    'maxYear' => date('Y'),
                                                    'required' => true
                                                ));
                                            ?>
                                            </span>
                                        </div>
                                        <div class="edu-desc-row-inner">
                                            <label>Date To</label>
                                            <span>
                                            <?php
                                                echo $this->Form->input('date_to', array(
                                                    'type' => 'date',
                                                    'label' => FALSE,
                                                    'type' => 'date',
                                                    'dateFormat' => 'MY',
                                                    'minYear' => date('Y') - 100,
                                                    'maxYear' => date('Y'),
                                                    'required' => true
                                                ));
                                            ?>
                                            </span>
                                        </div>

                                            <div class="share save-education-details">
                                                <input type="button" class="common-button share" value="SAVE" style="margin:10px;">
                                                <input type="button" class="common-button cancel" value="CANCEL" style="margin:10px;">
                                            </div>
                                    </div>
                                        <?php echo $this->Form->end();   ?>
                                    <div id="test_id"></div>
                                    <?php foreach($educations as $education) {
                                      $date_from = date_parse($education->date_from);
                                      $date_to = date_parse($education->date_to);

                                      $year = $date_from['year']. " - ".$date_to['year'];
                                     ?>

                                    	<div class="edu-desc-row">
	                                    	<div class="edu-desc-row-inner">
												<?php if($role == 1) { ?>
                                                <div class="editPencil pencil editDummy" id="<?php echo $education->id?>">&nbsp;</div>
												<?php } ?>

	                                        <h4><?php echo $education->education?></h4>
	                                        <p><?php echo $education->institute.' ('.$education->university.' )'?></p>
	                                        <p><?php echo $year ?></p>
                                                </div>
                                    	</div>



                                    	<!--Education Edit -->
                                        <?php echo $this->Form->create('user_education',array('type'=>'hidden','id'=>'user_education_id_'.$education->id));  ?>
                                    	<div class="edu-desc-row" style="display:none;"   id="edu_edit<?php echo $education->id ?>">
                                            <div class="edu-desc-row-inner">
                                                <label>Education</label>
                                                <span>
                                                    <?php echo $this->Form->input('education',array('id' => 'education_id','type' => 'text','label' => FALSE ,'required' => true,'value' => $education-> education )) ?>
                                                </span>
                                            </div>
                                            <div class="edu-desc-row-inner">
                                                <label>School/Institute</label>
                                                <span>
                                                    <?php echo $this->Form->input('institute',array('id' => 'institute_id','type' => 'text','label' => FALSE ,'required' => true, 'value' => $education->institute)) ?>
                                                </span>
                                            </div>
                                            <div class="edu-desc-row-inner">
                                                <label>University</label>
                                                <span>
                                                    <?php echo $this->Form->input('university',array('id' => 'institute_id','type' => 'text','label' => FALSE ,'required' => true, 'value' => $education->university)) ?>
                                                    <?php echo $this->Form->input('id',array('type' => 'hidden','label' => FALSE ,'required' => true, 'value' => $education->id )) ?>
                                                </span>
                                            </div>
                                            <div class="edu-desc-row-inner">
                                                <label>Date From</label>
                                                <span>
                                                <?php
                                                    echo $this->Form->input('date_from', array(
                                                        'type' => 'date',
                                                        'label' => FALSE,
                                                        'type' => 'date',
                                                        'dateFormat' => 'MY',
                                                        'minYear' => date('Y') - 100,
                                                        'maxYear' => date('Y'),
                                                        'required' => true,
                                                        'selected' => $education->date_from
                                                    ));
                                                ?>
                                                </span>
                                            </div>
                                            <div class="edu-desc-row-inner">
                                                <label>Date To</label>
                                                <span>
                                                <?php
                                                    echo $this->Form->input('date_to', array(
                                                        'type' => 'date',
                                                        'label' => FALSE,
                                                        'type' => 'date',
                                                        'dateFormat' => 'MY',
                                                        'minYear' => date('Y') - 100,
                                                        'maxYear' => date('Y'),
                                                        'required' => true,
                                                        'selected' => $education->date_to
                                                    ));
                                                ?>
                                                </span>
                                            </div>

                                            <div class="share">
                                                                            <input type="button" class="common-button share edu_edit" value="SAVE"
                                                                                            style="margin:10px;" id="edit-<?php echo $education->id ?>">
                                                                            <input type="button" class="common-button cancel edu_edit" value="CANCEL" style="margin:10px;">
                                            </div>
                                        </div>
                                        <?php echo $this->Form->end(); ?>
                                    <!-- Edu edit end here -->
                                        <?php } ?>



                                </div>
                            </div>



                            <div class="profile-row-mids" id="personal_details">
								<?php if($role == 1) { ?>
                                <div class="editPencil pencil">&nbsp;</div>
								<?php } ?>

                                <div class="education-left">

									<?php
									$pic = '/img/uploads/profilePic_2.jpg';
									if(@getimagesize(IMAGE_PROFILE_BIG.$userDetails->profilePic)){

										$pic = IMAGE_PROFILE_BIG.$userDetails->profilePic;
									}

									echo $this->Html->image($pic);

									?>



                                    <?php /*echo $this->Html->image('/'.$profile_pic,array(
                                        'url'=>array('controller'=>'UserProfiles','action'=>'get_profile_pic')
                                    )); */?>
                                    <div class="education-left-desc"><?php echo $userDetails->first_name. " ". $userDetails->last_name ?></div>
                                </div>
                                <div class="education-desc">
                                    <h3>Personal Details</h3>
                                    <div class="edu-desc-row">
                                        <div class="edu-desc-row-inner" id="birth_on">
                                            <label>Birthday on :</label>
                                            <span><?php echo date('d-M-Y',  strtotime($userDetails->dob)) ; ?></span>
                                        </div>
                                        <div class="edu-desc-row-inner" id="first_name">
                                            <label>First Name :</label>
                                            <span><?php echo $userDetails->first_name?></span>
                                        </div>
                                        <div class="edu-desc-row-inner" id="last_name">
                                            <label>Last Name :</label>
                                            <span><?php echo  $userDetails->last_name?></span>
                                        </div>
                                        <div class="edu-desc-row-inner" id="city">
                                            <label>Country :</label>
                                            <span><?php echo $country?></span>
                                        </div>

                                    </div>
                                    <h3>Contact Details</h3>
                                    <div class="edu-desc-row">

                                        <div class="edu-desc-row-inner" id="mail">
                                            <label>Mail :</label>
                                            <span><?php echo $userDetails->email?></span>
                                        </div>
                                    </div>

                                </div>
                            </div>




                            <div class="profile-row-mids" id="personal_details_edit" style="display:none;">
                            	<div class="education-left">
                                    <?php echo $this->Html->image(IMAGE_CHANGE.$userDetails->profilePic); ?>
                                    <div class="education-left-desc"><?php echo $userDetails->first_name. " ". $userDetails->last_name ?></div>
                                </div>
                                <?php $this->Form->create('User',array('id'=> 'Edit_User_Details')); ?>
                                <div class="education-desc">
                                    <h3>Personal Details</h3>
                                    <div class="edu-desc-row">
                                        <div class="edu-desc-row-inner">
                                            <label>Birthday on</label>
                                            <span>
                                                <?php
                                                    echo $this->Form->input('dob', array(
                                                        'type' => 'date',
                                                        'label' => FALSE,
                                                        'type' => 'date',
                                                        'dateFormat' => 'DMY',
                                                        'minYear' => date('Y') - 113,
                                                        'maxYear' => date('Y') - 13,
                                                        'required' => true,
                                                        'selected' => $userDetails->dob
                                                    ));
                                                ?>

                                            </span>
                                        </div>
                                        <div class="edu-desc-row-inner">
                                            <label>First Name</label>
                                            <span>
                                                <?php echo $this->Form->input('first_name',array('type'=> 'text','id'=> 'first_name_in','required' => TRUE ,'label' => False)); ?>
                                            </span>
                                        </div>
                                        <div class="edu-desc-row-inner">
                                            <label>Last Name</label>
                                            <span>
                                                <?php echo $this->Form->input('last_name',array('type'=> 'text','id'=> 'last_name_in','required' => TRUE ,'label' => False)); ?>
                                            </span>
                                        </div>
                                        <div class="edu-desc-row-inner">
                                            <label>Home town</label>

                                            <span>
                                                <?php echo $this->Form->input('city',array('type'=> 'text','id'=> 'city_in','required' => TRUE ,'label' => False ,'list'=>'data[User][city]')); ?>
<!--
												<datalist id="data[User][city]">
													<?php foreach($countries as $coun){ ?>
													<option value="<?php echo $coun['value'] ?>" label="<?php echo $coun['label'] ?>" ></option>
													<?php } ?>
													-->

												  </datalist>
                                            </span>
                                        </div>

                                    </div>
                                    <h3>Contact Details</h3>
                                    <div class="edu-desc-row">

                                        <div class="edu-desc-row-inner">
                                            <label>Mail</label>
                                            <span>
                                                <?php echo $this->Form->input('email',array('type'=> 'text','id'=> 'mail_in','required' => TRUE ,'label' => False)); ?>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="share-button-wrapper">
                                    <span class="share">
					                <input type="button" class="common-button share" value="SAVE" style="margin:10px;">
					                <input type="button" class="common-button cancel" value="CANCEL" style="margin:10px;">
                                    </span>
				</div>

                                <?php echo $this->Form->end(); ?>
                            </div>


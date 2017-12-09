
                        <div class="post-main" id="postboxid" >
                            <div class="profile-row-mids">
                                <div class="left-container-profile tab1">
                                    <ul>
                                    <li>
                                    <?php echo $this->Html->link('about',$userDetails->userId.'/about'); ?>
                                    </li>
                                    <li>
                                    <?php echo $this->Html->link('education',$userDetails->userId.'/education'); ?>
                                    </li>
                                    <li>
                                    <?php echo $this->Html->link('experience',$userDetails->userId.'/experience'); ?>
                                    </li>
                                    <li>
                                    <?php echo $this->Html->link('Awards',$userDetails->userId.'/award'); ?>
                                    </li>
                                    <li>
                                    <?php echo $this->Html->link('Certifications',$userDetails->userId.'/certification'); ?>
                                    </li>
                                    </ul>
                                </div>
                                <div class="left-container-profile tab2">
                                    <div class="profile-row-mids" id="about_me_labels">
                                        <?php if(AuthComponent::user('id') == $userDetails->id){ ?>
                                        <div class="editPencil pencil" id="about_me">&nbsp;</div>
                                        <?php } ?>
                                        <h3>About</h3>
                                        <p><?php

											echo $userDetails->profileStatus; ?></p>

                                    </div>
                                    <div class="profile-row-mids" id="about_me_edit" style="display:none;">
                                        <textarea id="about_me_edit_text" name="about_me_edit" style="width:99%;font-family: inherit;" rows="4"><?php echo $userDetails->profileStatus; ?></textarea>
                                        <div class="share">
                                                                <input type="button" class="common-button share" value="SAVE" style="margin:10px;">
                                                                <input type="button" class="common-button cancel" value="CANCEL" style="margin:10px;">
                                                            </div>
                                    </div>
                                </div>



                            </div>
                        </div>

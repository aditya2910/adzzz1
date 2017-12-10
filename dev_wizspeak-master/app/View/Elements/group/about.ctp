<style type="text/css">
DIV.list_item_container {
height: 40px;
padding: 0px;
    }
    list_item_container .search-row-sugg{
    max-width:60px;

    }
    .list_item_container.sugg-details{
        width:60px;
    }
    #edit_group_members-replace{
        display: none;
    }
    #connectedGroup_list-replace{
        display: none;
    }
    .pencil{
        color: #91779E;
    }
</style>

                            <div class="profile-row-mids original_about">
                                <h3 class="common-head-h3">Description</h3>



                                <p id='group_about' ><?php echo nl2br($groupDetail->description); ?></p>
                            </div>
                            <div class="profile-row-mids replace_about">
                                <h3 class="common-head-h3">Description</h3>
                                <div contenteditable id='group_about_edit' style='width:98%;height:auto;' > </div>
                                <div class="share">
                                    </br>
                                            <input type="button"  id="save_about" value="Save" />
                                            <span>&nbsp;</span>
                                            <input type="button"  id="cancel_about" value="Cancel" />
                                </div>
                            </div>
                            <div   class="members-main group-profile">
                                <h3 class="common-head-h3">Members (<?Php echo count($groupMembers); ?>)</h3>
								<div class="editPencil pencil">&nbsp;</div>
                                <ul>

                                    <?php foreach($groupMembers as $index => $member){


                                            if(isset($member->userPic) && ($member->userPic != '') ){
                                                $pic=IMAGE_PROFILE_WALL.$member->userPic;
                                            }else{
                                                 $pic = 'uploads/pic1.jpg';
                                            }

                                    ?>
                                    <li>
                                        <div class="memberpic">
                                            <?php echo $this->Html->image($pic); ?>
                                        </div>
                                        <h3><?php echo $member->name; ?></h3>
                                        <p><?php echo '('.$member->role_alias.')'; ?></p>
                                        <div class="chatbtn-main">
                                            <div class="share">

                                                <input type="button" value="chat" />
                                            </div>
                                        </div>
                                    </li>
                                    <?php   }?>


                                </ul>

                            </div>

				<?php if($userGroupRole==2 || $userGroupRole==1)  { ?>
                            <div  id='edit_group_members' class="members-main group-profile">
                                <h3 class="common-head-h3">Invitee (<?Php echo count($groupMemberRequest); ?>)</h3>
                                <div title=" Add New Invitee "  class="editPencil pencil">&nbsp;</div>
                                <ul>

                                    <?php foreach($groupMemberRequest as $index => $member){

                                            if(isset($member->userPic) && ($member->userPic != '') ){
                                                $pic='/'.$member->userPic;
                                            }else{
                                                 $pic = 'uploads/pic1.jpg';
                                            }

                                    ?>
                                    <li>
                                        <div class="memberpic">
                                            <?php echo $this->Html->image($pic); ?>
                                        </div>
                                        <h3><?php echo $member->name; ?></h3>
                                        <p><?php echo '('.$member->role_alias.')'; ?></p>
                                        <div class="chatbtn-main">
                                            <div class="share">
												<?php if($userGroupRole==1) { ?>

													<input type="button" data-id="<?php echo $member->id; ?>"  class="remove-invitee" value="remove" />

												<?php } ?>
                                            </div>
                                        </div>
                                    </li>
                                    <?php   } ?>


                                </ul>


                                <div id='edit-group-members'  >

                                    <div class="groups" >
                                        <div class ='group-row-main'></div>
                                    </div>
                                            <div class="createG-row">
                                                <div class="createG-row-label">Add Users :</div>
                                                <div class="createG-row-value">
                                                    <input type='search' id='search-user-invitee'  class='form-input2' />
                                                </div>
                                            </div>
                                    <div> &nbsp;</div>


                                </div>


                            </div>


                            <div class="members-main group-profile" id="edit_group_members-replace" >
                                <h3 class="common-head-h3">Add New Members </h3>
                                <input type="text" id="auto-addmembers"/>
                        <!-- -->

                            <div  id="added_member_list" ></div>

                                <div class="share">
                                    <input type="button" id="add_more_members"  value="Add" />
                                </div>

                        <!-- -->
                            </div>

                            <div id="connectedGroup_list"  class="members-main group-profile connected">
                                <h3 class="common-head-h3">Connected Groups (<?Php echo count($connectedGroups); ?>)</h3>
								<?php if($userGroupRole==1) { ?>
                                <div  title=" Add New Connected Group "  class="editPencil pencil">&nbsp;</div>
								<?php } ?>
                                <?php
                                foreach($connectedGroups as $index => $group){

                                if( $index == 0 || ($index%7)== 0){
                                    echo '<ul>';
                                }
                                echo '<li>';
                                echo '<div class="memberpic" >';

											$pic = '/img/ambition.jpg';
											if(@getimagesize(IMAGE_PROFILE_MAIN.$group->profilePic)){

												$pic = IMAGE_PROFILE_MAIN.$group->profilePic;
											}

											echo $this->Html->image($pic,array(
												'url' => array(
													'controller'=>'groups','action'=>$group->customUrl,'about'
												)
											));


									


                                echo '</div>';
                                echo '<h3>'.$group->name.'</h3>';
                                echo '</li>';

                                if( $index != 0 && $index == 6 &&($index%7)== 0) {
                                    echo '</ul>';
                                }
                                ?>
                                <?php } ?>



                            </div>

                            <div id="connectedGroup_list-replace"  class="members-main group-profile connected">
                                <h3 class="common-head-h3">Add Connected Groups </h3>
                                <div>&nbsp;</div>
                                <input type="text" id="add_more_groups"  class="form-input2 search-group">

                                <div id="connectedGroup_list-new" class="connected-group-listsel">

                                </div>
                                <div>&nbsp;</div>
                                <div class="share">
                                    <input type="button" id="add_more_groups-button"  value="Add" />
                                    <input type="button" id="add_connect_group_divclose"   value="cancel" />
                                </div>


                            </div>

<?php } ?>

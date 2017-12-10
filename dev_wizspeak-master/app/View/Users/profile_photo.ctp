
            <div class="fixed-container">
                <div class="register-main">
                    <div class="register-left">
                        <div class="user-reg profileReg-pic">
                            <div class="user-regImg">
                                <?php echo $this->Html->image('userReg.jpg'); ?>
                            </div>
                            <div class="user-regDetails">
                                <h2>PROFILE IMAGE</h2>
                                <p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit.</p>
                            </div>
                        </div>
                    </div>
                    <div class="register-right">
                        <div class="step-main">
                            <div class="step-copy">
                                <h3>REGISTRATION</h3>
                                <h2>STEPS</h2>
                            </div>
                            <div class="step-img step4">
                                <div class="bg-percent"></div>

                                <?php echo $this->Html->image("steps.png"); ?>
                                <ul class="step-ulist" >
                                    <li class="no1 active" >1</li>
                                    <li class="no2 active">2</li>
                                    <li class="no3 active">3</li>
                                    <li class="no4">4</li>
                                </ul>
                            </div>
                        </div>

                        <div class="register-form-main upload-profilepic">
                            <div class="upload-profilePic">
                                <div class="upload-profilePicinner">
                                    <?php

										echo $this->Html->image($avathar);


                                    ?>
                                </div>

                            </div>
                            
                            <div class="rows-reg attachfile">
                                <div class="rows-reg-left">Profile Image</div>
                                <div class="rows-reg-right">

                                    <div class="file-upload ">

                                        <input class="common-input" id="uploadFile" placeholder="Choose File" disabled="disabled" />
                                        <div class="fileUpload">
											<span data-rel="profile-image-crope" class="fa-camera popup crop-overlay"></span>



                                        </div>

                                    </div>


                                </div>
                            </div>




							<div class="rows-reg attachfile">
								<div class="rows-reg-left">&nbsp;</div>
								<div class="rows-reg-right skip-next">
									<a href="../users/homePage" >
									<?php if(empty($avathar)) { ?>

										<button class="common-button"  >SKIP</button>
									<?php }else{ ?>
										<button class="common-button" href="../users/homePge" >NEXT</button>
									<?php } ?>
									</a>
								</div>
							</div>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>




			<div class="simple_overlay" id="profile-image-crope">
				<div class="profile-row-mids">
					<div class="createG-left">
						<h1>Crop Image</h1>
						<div id="img_place">
							<div class="crop-wrapper example">
								<!-- cropper container element -->
								<div class="default-container"></div>
							</div>
						</div>
						<div class="share" >
							<ul class="cmd">

								<input type="button" class="flip-img common-button cropbutton" value="Flip Image" />
								<input type="button" class="rotate-img common-button cropbutton" value="Rotate" />
						</div>
						</ul>
					</div>
					<div class="createG-right">
						<h3>Select image</h3>
						<div class="group-search">
							<div class="input file">
								<label for="crop_profile_pic_group_file">File</label>
								<input type="button" class="browse-img common-button" value="Browse" />
							</div>
						</div>
						<br>
						<br>
						<h1>Image Preview</h1>
						<div id="preview-pane">
							<div class="pre"></div>
						</div>
						<div class="share-button-wrapper overlay-button">
							<input type="submit" class="base64-img common-button cancel" value="Save" />

							<input type="submit" class="common-button cancel" value="Cancel">
						</div>
					</div>
				</div>
			</div>



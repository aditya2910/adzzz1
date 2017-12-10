<?php
echo $this->Html->css('jquery-ui');
echo $this->Html->script('script');
?>

<style>
    .error-message
{
  width  : 100%;
  padding: 3px;
  padding-left: 5px;

  font-size: 80%;
  color: white;
  background-color: #900;
  border-radius: 0 0 5px 5px;

  -moz-box-sizing: border-box;
  box-sizing: border-box;
}
	.custom_gender{

		padding: 10px;
		margin-right: 15px;
		margin-left: 10px;
	}
</style>
<div class="fixed-container">
                <div class="register-main">
                    <div class="register-left">
						<div class="easy-register" >
							<h2>EASY REGISTER WITH</h2>
							<p>No worry to find friends, invite then for improve your skillsThis is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollici </p>
							<div class="easy-register-buttons">
								<a class="fb-login" href="../auth/facebook">
									<span class="fa-facebook"></span>
									<span>Sign in with Facebook</span>
								</a>
								<a class="twitter-login" href="../auth/twitter">
									<span class="fa-twitter"></span>
									<span>Sign in with Twitter</span>
								</a>
								<a class="linkdin-login" href="../auth/linkedin">
									<span class="fa-linkedin" ></span>
									<span>Sign in with Linkdin</span>
								</a>
								<a class="gplus-login" href="../auth/google">
									<span class="fa-google-plus" ></span>
									<span>Sign in with Google Plus</span>
								</a>
							</div>
						</div>
                    </div>
                    <div class="register-right">
						<div class="step-main">
							<div class="step-copy">
								<h3>REGISTRATION</h3>
								<h2>STEPS</h2>
							</div>
							<div class="step-img step2">
								<div class="bg-percent"></div>
								<?php echo $this->Html->image("steps.png"); ?>
								<ul class="step-ulist" >
									<li class="no1 active" >1</li>
									<li class="no2 active">2</li>
									<li class="no3">3</li>
									<li class="no4">4</li>
								</ul>
							</div>
						</div>
                        <div class="register-form-main">

                            <?php

                            echo $this->Form->create('User',array("validate",'Method'=>'POST','formnovalidate'=>true ,'action' =>'../users/registration'));
                            echo $this->Form->input('is_mentor',array('id'=>'user_type','value'=> $user_type,'type'=>'hidden'));


                            ?>


							<div class="rows-reg">
                                <div class="rows-reg-left">First Name</div>
                                <div class="rows-reg-right">
                                    <?php
                                     echo $this->Form->input('first_name',array('class'=>'common-input','type'=>'text','label'=>false,'required'=>true, 'value' => $easyUser['first_name']));
                                    ?>
                                </div>
                            </div>
                            <div class="rows-reg">
                                <div class="rows-reg-left">Last Name</div>
                                <div class="rows-reg-right">
                                    <?php
                                     echo $this->Form->input('last_name',array('class'=>'common-input','type'=>'text','label'=>false,'formnovalidate'=>true, 'value' => $easyUser['last_name']));
                                    ?>
                                </div>
                            </div>
                            <div class="rows-reg">
                                <div class="rows-reg-left">Email</div>
                                <div class="rows-reg-right">
                                    <?php
                                     echo $this->Form->input('email',array('class'=>'common-input','type'=>'text','label'=>false,'type'=>'email','formnovalidate'=>true ,'required'=>true, 'value' => $easyUser['email']));
                                    ?>
                                </div>
                            </div>
                            <div class="rows-reg">
                                <div class="rows-reg-left">Password</div>
                                <div class="rows-reg-right">
                                    <?php
                                     echo $this->Form->input('password',array('class'=>'common-input','type'=>'password','label'=>false,'formnovalidate'=>true ,'required'=>true ,'autocomplete'=> 'off' ));
                                    ?>
                                </div>
                            </div>
							<div class="rows-reg">
								<div class="rows-reg-left">DOB</div>
								<div class="rows-reg-right dob">
									<div class="day" >
										<select class="custom-select" name="data[User][dob][day]" options="1 2"  required="required" >
											<option value="">Day</option>
											<?php
											for($day = 1;$day < 32;$day++){

												$sel = "";
												if($easyUser['dob']['day'] == $day){
													$sel = "selected";
												}
												echo '<option '.$sel.'  value="'.$day.'">'.$day.'</option>';
											}

											?>


										</select>
									</div>
									<div class="month" >
										<select class="custom-select"  name="data[User][dob][month]" options="1 2"  required="required" >
											<option <?php if($easyUser['dob']['month']== '0') { echo 'selected';} ?>  value="">Month</option>
											<option <?php if($easyUser['dob']['month']== '01') { echo 'selected';} ?> value="01">January</option>
											<option <?php if($easyUser['dob']['month']== '02') { echo 'selected';} ?> value="02">February</option>
											<option <?php if($easyUser['dob']['month']== '03') { echo 'selected';} ?> value="03">March</option>
											<option <?php if($easyUser['dob']['month']== '04') { echo 'selected';} ?> value="04">April</option>
											<option <?php if($easyUser['dob']['month']== '05') { echo 'selected';} ?> value="05">May</option>
											<option <?php if($easyUser['dob']['month']== '06') { echo 'selected';} ?> value="06">June</option>
											<option <?php if($easyUser['dob']['month']== '07') { echo 'selected';} ?> value="07">July</option>
											<option <?php if($easyUser['dob']['month']== '08') { echo 'selected';} ?> value="08">August</option>
											<option <?php if($easyUser['dob']['month']== '09') { echo 'selected';} ?> value="09">September</option>
											<option <?php if($easyUser['dob']['month']== '10') { echo 'selected';} ?> value="10">October</option>
											<option <?php if($easyUser['dob']['month']== '11') { echo 'selected';} ?> value="11">November</option>
											<option <?php if($easyUser['dob']['month']== '12') { echo 'selected';} ?> value="12">December</option>
										</select>
									</div>
									<div class="year" > <select class="custom-select" name="data[User][dob][year]" options="1 2"  required="required" >
											<?php
											$year = date("Y");
											$startYear = $year - 18;

											for($y = 0;$y < 110;$y++){

												$sel = "";
												if(($startYear-$y) == $easyUser['dob']['year']){
													$sel ="selected";
												}

												echo '<option '.$sel.' value="'.($startYear-$y).'">'.($startYear-$y).'</option>';
											}

											?>

										</select>
									</div>

								</div>
							</div>
                            <div class="rows-reg">
								<div class="rows-reg-left">Gender</div>
								<div class="rows-reg-right">
									<div class="gender-col">
										<label>Male</label>
										<div class="custom-radio">

											<input type="radio" value="1" <?php if($easyUser['gender'] =='male'){echo 'checked';} ?> name="data[User][gender]" >
											<div class="toogle-tick"></div>
										</div>
									</div>
									<div class="gender-col">
										<label>Female</label>
										<div class="custom-radio">
											<input type="radio" value="0" <?php if($easyUser['gender'] =='female'){ echo 'checked'; }?>  name="data[User][gender]" >
											<div class="toogle-tick"></div>
										</div>
									</div>
								</div>

                            </div>
                            <div class="rows-reg">
                                <div class="rows-reg-left">Country</div>
                                <div class="rows-reg-right">
                                    <?php
//                                    echo $this->Form->input('country', array(
//                                        'label'=>false,
//                                        'class'=>'custom-select',
//                                        'empty' => 'Select',
//                                        'required'=>true
//                                    ));

                                    echo $this->Form->input('countryName',array('class'=>'common-input','type'=>'text','label'=>false,'formnovalidate'=>true));
                                    echo $this->Form->input('country',array('type'=>'hidden','label'=>false,'formnovalidate'=>true));
                                    ?>
                                </div>
                            </div>

                            <div class="rows-reg">
                                <div class="rows-reg-left">&nbsp;</div>
                                <div class="rows-reg-right">

                                    <?= $this->Form->button(__('Next'), array('class'=>'common-button')) ?>

                                </div>
                            </div>

                        <?php

                        echo $this->Form->end();
                        ?>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>



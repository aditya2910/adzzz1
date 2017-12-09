
            <div class="fixed-container">
                <div class="login-main">

                    <div class="login-right">
                        <div class="form-main">
                            <?php
                            echo $this->form->create(); ?>
                            <h2>Member Login</h2>
                            <div class="form-row placeholder">
                                <?php
                                echo $this->form->input('email',array('label'=>false,'default'=>$myValue['email'],'placeholder'=>"Email or Mobile number",'class'=>'form-input'));

                                ?>
                                <!--<input type="text"  placeholder="Email or Mobile number" name="username" class="form-input">-->

                            </div>
                            <div class="form-row placeholder">
                                <?php
                                echo $this->form->input('password',array('label'=>false,'default'=>$myValue['email'],'placeholder'=>"password",'class'=>'form-input','title'=>'Enter Password'));
                                ?>
                                <!-- <input type="password" placeholder="password" name="password" class="form-input"> -->
                            </div>
                            <div class="form-row2 keep-me-remember">
                                <!--<input type="checkbox" />-->
								<div class="checkbox-wrapper widthadj">
									<div class="custom-check">
										<div class="toogle-tick">
										</div>
										<?php
										echo $this->form->checkbox('remember_me',array('label'=>false,'default'=>$myValue['remember_me']));
										?>
									</div>
								</div>

                                <span class="keepme">Keep me logged in</span>
                                <input type="submit" value="Log In" class="common-button form-submit">
                            </div>
                            <div class="login-form-bottom">
                                <p>Not a member , Signup Now...</p>
                                <div class="form-row2">

                                    <?php
                                   $this->form->create('Register');

                                    echo $this->form->button('Sign Up',array('label'=>false,'type'=>'button','class'=>'common-button register','onclick'=>"window.location='users/account'"
                                        ));
                                    ?>
                                </div>
                                <p> <!-- <a href="login.ctp">forget your password !</a> --></p>
                            </div>

                        </div>

                    </div>
                    <div class="login-left">
                        <div class="about-main">
                            <h1>Some Words about us</h1>
                            <p>Wizspeak is to provide a spark to one’s “ambition” in life at an early stage and open

								up an avenue to channelize all energies in pursuit of that “ambition”. Achievers in

								every conceivable field in this world are here to support you!</p>

                        </div>
                        <div class="slider-main">
                            <div id="slider1_container">

                                <!-- Loading Screen -->
                                <div u="loading" class="loading-main">
                                    <div class="loading-bg">
                                    </div>
                                    <div class="loading-img">
                                    </div>
                                </div>

                                <!-- Slides Container -->
                                <div u="slides" class="slides-main">
                                    <div>

                                    <?php

                                    echo $this->Html->image("about1.jpg", array(
                                    "alt" => "WIZSPEAK",
                                    'url' => array('controller' => 'pages', 'action' => 'home')
                                    ));
                                    ?>
                                    </div>
                                    <div>
                                    <?php

                                    echo $this->Html->image("about2.jpg", array(
                                    "alt" => "WIZSPEAK",
                                    'url' => array('controller' => 'pages', 'action' => 'home')
                                    ));
                                    ?>

                                    </div>
                                    <div>

                                    <?php

                                    echo $this->Html->image("about3.jpg", array(
                                    "alt" => "WIZSPEAK",
                                    'url' => array('controller' => 'pages', 'action' => 'home')
                                    ));
                                    ?>

                                    </div>
                                    <div>

                                    <?php

                                    echo $this->Html->image("about4.jpg", array(
                                    "alt" => "WIZSPEAK",
                                    'url' => array('controller' => 'pages', 'action' => 'home')
                                    ));
                                    ?>

                                    </div>
                                </div>
                                <!-- Arrow Left -->
                                <span u="arrowleft" class="jssora12l">
                                </span>
                                <!-- Arrow Right -->
                                <span u="arrowright" class="jssora12r">
                                </span>
                                <!-- Arrow Navigator Skin End -->
                            </div>

                        </div>

                    </div>
                </div>
                <div class="clear"></div>
            </div>
<?php

//  echo $this->Session->flash('auth');
//  echo $this->Session->flash();
//  echo $this->form->create();
//
//  echo $this->form->input('email',array('default'=>$myValue['email']));
//  echo $this->form->input('password',array('default'=>$myValue['password']));
//  echo $this->form->checkbox('remember_me',array('default'=>$myValue['remember_me']));
//  echo $this->form->label('remember_me');
//  echo $this->form->end('Login');

  ?>

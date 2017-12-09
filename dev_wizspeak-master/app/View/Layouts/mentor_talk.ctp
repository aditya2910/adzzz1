<!doctype html>
<!--[if IE 8 ]>    <html lang="en" class="ie ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="ie ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title></title>
	<meta name="description" content="">
	<meta name="author" content="">
	<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0, user-scalable=no" />

	<?php


	//pr($notificatons);
	echo $this->Html->scriptBlock('var jsVars = '.$this->Js->object($jsVars).';');
	echo $this->Html->css('jquery.mCustomScrollbar.css');
	echo $this->Html->css('styles.css');
	echo $this->Html->script('modernizr.custom.56100.js');
	echo $this->Html->css('addedstyles.css');
	echo $this->Html->css('jquery-ui_dialog.css');



	?>

</head>

<body>
<div class="main-container profile-page">
	<div class="header-wrapper">
		<div class="full-container header">
			<div class="fixed-container">
				<div class="logo">
					<?php
					echo $this->Html->image("/img/logo.png", array(
						"alt" => "wizspeak",
						'url' => array('controller' => 'ambitions', 'action' => 'index')
					));
					?>
				</div>
				<div class="search-main">

					<?php echo $this->element('main_search'); ?>

				</div>
				<?php echo $this->element('notification'); ?>
				<div class="clear"></div>
			</div>
		</div>

		<div class="full-container secondary-nav">
			<div class="fixed-container">
				<div class="secodnav-left">

					<ul class="ulist-secondaynav">
						<li class="selected-menu">
							<span class="seclectdot">&nbsp;</span>
							<?php
							echo $this->Html->link('Wall' ,array(
								'controller' => 'mentor' ,'action' => $userDetails->userId , 'wall'  ));
							?>
						</li>
						<li class="selected-menu">
							<span class="seclectdot">&nbsp;</span>
							<?php
							echo $this->Html->link('About' ,array(
								'controller' => 'mentor' ,'action' => $userDetails->userId , 'about'  ));
							?>
						</li>
					</ul>

					<div class="left-toggle-button users-icon">&nbsp;</div>
					<div class="ambition-main">
						<div class="ambition">Talk</div>
					</div>
					<ul class="ulist-secondaynav">
						<li class="ambition-drop">
							<ul class="ambition-drop-ulist">
								<?php if($role==1) { ?>
									<li>
									<?php
									echo $this->Html->link("Settings",
										array('controller' => 'mentor', 'action' => $userDetails->userId,'setting' )
									);
									?>
									</li><?php } ?>
								<li>
									<a href="#">Activity log</a>
								</li>
								<li>
									<a href="#">Help</a>
								</li>
							</ul>
						</li>
						<li class="selected-menu mobile-view" >
							<span class="seclectdot">&nbsp;</span>
							<?php
							echo $this->Html->link('Talk' ,array(
								'controller' => 'mentor' ,'action' => $userDetails->userId , 'talk' ));
							?>
						</li>
						<li class="mobile-view cre-tab">
							<span>&nbsp;</span>
							<?php
							echo $this->Html->link('About' ,array(
								'controller' => 'mentor' ,'action' => $userDetails->userId , 'about'  ));
							?>
						</li>
						<li  class="mobile-view cre-tab" >
							<span>&nbsp;</span>
							<?php echo $this->html->link('Wall', array('controller'=>'mentor','action' => $userDetails->userId , 'wall'));?>


						</li>

						<li class="mobile-view cre-tab">
							<span>&nbsp;</span>
							<?php
							echo $this->Html->link('Creativity' ,array(
								'controller' => 'creativity' ,'action' => 'index' ));
							?>

						</li>

					</ul>
				</div>
				<div class="secodnav-right">
					<ul class="ulist-secondaynav-right">
						<li>
							<?php
							echo $this->Html->link('Creativity' ,array(
								'controller' => 'creativity' ,'action' => 'index' ));
							?>
						</li>

					</ul>
				</div>
				<div class="toggle-friend-mentor">
					<ul>

						<?php if($role==1) { ?>
							<li class="mentors-toggle">
								Messages
							</li>

						<?php }else{ ?>
							<li class="friend-toggle">
								Who to Follow
							</li>
							<li class="mentors-toggle">
								Mentors
							</li>
						<?php } ?>

					</ul>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>

	<div class="full-container main-content">
		<div class="fixed-container">
			<div class="left-container-profile">
				<div class="profile-top-section">
					<div class="cover-image">
						<?php echo $this->Html->image('banner_profile.jpg'); ?>
					</div>
					<div class="cover-desc">
						<div class="cover-inner">
							<div class="cover-inner-left">
								<div class="cover-profile-Pic">
									<?php echo $this->element("profile_pic_main",array('profilePicMain' => IMAGE_PROFILE_MAIN.$userDetails->profilePic,
										'link' => array("controller" => 'profiles','action' => $userDetails->userId,"setting") )); ?>
								</div>
								<div class="cover-pic-Disc">
									<div class="cover-pic-disc-name">
										<h3><?php echo $userDetails->first_name.' '.$userDetails->last_name ?></h3>
										<h5><?php echo $userDetails->profileStatus ?></h5>
									</div>
									<div class="cover-pic-disc-award">

										<?php if($role ==2){ ?>

											<input type="button" value="UN-FOLLOW" class="common-button un-follow" />
										<?php } if($role ==3) { ?>

											<input type="button" value="FOLLOW" class="common-button follow" />
										<?php } ?>
									</div>
								</div>
							</div>
							<div class="cover-inner-right">
								<ul class="ulist-covermenu">
									<li <?php if($action=='about'){ ?>class="profileSel" <?php } ?> >

										<?php
										echo $this->Html->link('About' ,array(
											'controller' => 'mentor' ,'action' => $userDetails->userId , 'about'  ));
										?>
										<span>&nbsp;</span>
									</li >
									<li <?php if($action=='achievement'){ ?>class="profileSel" <?php } ?>  >
										<?php
										echo $this->Html->link('Achievement' ,array(
											'controller' => 'mentor' ,'action' => $userDetails->userId , 'achievement'  ));
										?>
										<span>&nbsp;</span>
									</li>
									<li <?php if($action=='wall'){ ?>class="profileSel" <?php } ?>>
										<?php
										echo $this->Html->link('Wall' ,array(
											'controller' => 'mentor' ,'action' => $userDetails->userId , 'wall'  ));
										?>
										<span>&nbsp;</span>
									</li>
									<?php if($role==2){ ?>
										<li <?php if($action=='talk'){ ?>class="profileSel" <?php } ?>>
											<?php
											echo $this->Html->link('Talk' ,array(
												'controller' => 'mentor' ,'action' => $userDetails->userId , 'talk', $this->Session->read('Auth.User.userId')  ));
											?>
											<span>&nbsp;</span>
										</li>
									<?php } ?>
									<li <?php if($action=='protege'){ ?>class="profileSel" <?php } ?> >
										<?php
										echo $this->Html->link('Protage' ,array(
											'controller' => 'mentor' ,'action' => $userDetails->userId , 'protege'  ));
										?>
										<span>&nbsp;</span>
									</li>
									<li <?php if($action=='media'){ ?>class="profileSel" <?php } ?> >
										<?php
										echo $this->Html->link('Media' ,array(
											'controller' => 'mentor' ,'action' => $userDetails->userId , 'media'  ));
										?>
										<span>&nbsp;</span>
									</li>
									<li>
										<a class="gear" href="#">&nbsp;</a>
										<span>&nbsp;</span>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="profile-main-section">
					<div class="left-panel">
						<div class="content-left">
							<div class="groups">
								<?php echo $this->element('menti'); ?>

							</div>
						</div>
					</div>




					<?php echo $this->Session->flash(); ?>
					<?php echo $this->fetch('content'); ?>


				</div>
			</div>
			<div class="right-panel">
				<div class="right-toggle-button">X</div>
				<div class="content-right">
					<div class="friend-mentors">

						<?php
						if($role==1){
							//ur admin of page

							echo $this->element('mentor/sideMsg');
						}else{
							echo $this->element('mentorSuggections');
							echo $this->element('mentor');
						}

						?>

					</div>

				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>



</div>
<div class="clear"></div>

<?php
echo $this->element('sql_dump');
echo $this->Html->script('script.js');
echo $this->Html->script('jquery.mCustomScrollbar.concat.min.js');
echo $this->Html->script('init.js');
echo $this->Html->script('jquery-ui_dialog.js');
echo $this->Html->script('JsFunctions');
echo $this->Html->script('added_script');
echo $this->Html->script('profile');
echo $this->Html->script('scroll/jquery.infinitescroll.min.js');

echo $this->element('hidden_forms');

?>

</body>
</html>

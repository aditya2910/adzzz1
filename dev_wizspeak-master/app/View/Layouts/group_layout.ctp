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
	echo $this->Html->css('audio/style.css');
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

					<div class="left-toggle-button users-icon">&nbsp;</div>
					<div class="ambition-main mobile-view">
						<?php
						if($groupDetail->vertical_id==1){
							?>
							<div class="ambition">Ambition</div>
						<?php }else{ ?>
							<div class="ambition">Hobbies</div>
						<?php } ?>
					</div>


					<ul class="ulist-secondaynav">
						<li>

							<?php echo $this->HTMl->link('Ambition',array('controller'=>'ambitions', 'action' => 'index')); ?>

						</li>
						<li>

							<?php echo $this->HTMl->link('Hobbies',array('controller'=>'hobbies', 'action' => 'index')); ?>

						</li>
						<li class="mobile-view cre-tab">

							<?php
							echo $this->HTMl->link('Creativity',array('controller'=>'creativity', 'action' => 'index'));
							?>
						</li>
					</ul>
				</div>
				<div class="secodnav-right">
					<ul class="ulist-secondaynav-right">
						<li>
							<?php
							echo $this->HTMl->link('Creativity',array('controller'=>'creativity', 'action' => 'index'));
							?>
						</li>

					</ul>
				</div>
				<div class="toggle-friend-mentor">
					<ul>
						<li class="friend-toggle">
							Friends
						</li>
						<li class="mentors-toggle">
							Mentors
						</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>

	<?php echo $this->Session->flash();  ?>
	<?php echo $this->fetch('content'); ?>
</div>
<div class="clear"></div>

<?php
echo $this->element('sql_dump');
echo $this->Html->script('script.js');
echo $this->Html->script('jquery.mCustomScrollbar.concat.min.js');
echo $this->Html->script('jquery-ui-1.10.3.custom.min.js');
echo $this->Html->script('init.js');
echo $this->Html->script('jquery-ui.js');
echo $this->Html->script('scroll/jquery.infinitescroll.min.js');
echo $this->Html->script('JsFunctions');
echo $this->Html->script('added_script');

echo $this->Html->script('profile');
echo $this->Html->script('group');
echo $this->element('report');
echo $this->Html->script('jquery-ui_dialog.js');

echo $this->Html->script('registration/jquery.Jcrop.js');





?>

</body>
</html>

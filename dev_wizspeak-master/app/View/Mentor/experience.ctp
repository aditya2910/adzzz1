<style>
	.tab1{
		width:24%;

	}
	.tab1 li{
		padding-bottom: 15px;

	}
	.tab2{
		width:67%;
		padding-left: 5px;
		border-left: 3px solid #DBDBDB;
		min-height: 160px;
	}

	.profile-row-mids .education-desc {

		width: 100%;
	}
</style>

<div class="left-panel">
	<div class="content-left">
		<div class="profile">
			<div class="profile-pic">

				<?php

				echo $this->element('mentor_profile_pic',
					array(
						'link' => array(
							'controller' => 'profiles',
							'action' => $userDetails->userId
						),
						'profilePicMain' => IMAGE_PROFILE_AMB.$userDetails->profilePic
					));

				?>

			</div>
			<h2 class="profile-name"><?php echo $userDetails->first_name.' '.$userDetails->last_name ?></h2>
			<p class="profile-abition"></p>

			<div class="row-leftpanel">

				<?php if($role ==2){ ?>

					<input type="button" value="UN-FOLLOW" class="common-button un-follow" />
				<?php } if($role ==3) { ?>

					<input type="button" value="FOLLOW" class="common-button follow" />
				<?php } ?>


			</div>



		</div>
		<div class="groups">
			<?php echo $this->element('menti'); ?>


		</div>
	</div>
</div>
<div class="mid-section">
	<?php echo $this->element('mentor/experience'); ?>

</div>
<div class="mid-sec-add">
	<div class="adds-row">ADDS</div>
	<div class="adds-row">ADDS</div>
	<div class="adds-row">ADDS</div>
	<div class="adds-row">ADDS</div>
</div>
<div class="right-panel">
	<div class="right-toggle-button">X</div>
	<div class="content-right">
		<div class="friend-mentors">

			<?php echo $this->element('mentor/sideMsg'); ?>

		</div>

	</div>
</div>
<div class="clear"></div>
<?php

//  echo $this->Html->script('jquery/jquery.js');

?>

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

			<!--
			<div class="cover-pic-disc-award">
				<?php if($role==1 ||$role==2) { ?>
					<div class="rating-wrapper" style="padding-bottom: 0px;" data-id="<?php echo $userDetails->userId; ?>" >

						<input type="radio" name="example" class="rating" value="1" <?php if($userRating > 1) {?> checked="checked" <?php } ?> />
						<input type="radio" name="example" class="rating" value="2" <?php if($userRating > 2) {?> checked="checked" <?php } ?>  />
						<input type="radio" name="example" class="rating" value="3" <?php if($userRating > 3) {?> checked="checked" <?php } ?>  />
						<input type="radio" name="example" class="rating" value="4" <?php if($userRating > 4) {?> checked="checked" <?php } ?> />
						<input type="radio" name="example" class="rating" value="5" <?php if($userRating > 5) {?> checked="checked" <?php } ?>  />
					</div>
				<?php } else{ ?>
					<div class="stars">
						<a  <?php if($userRating > 1) {?> class="badge-img fullStar" <?php }else{ ?>class="badge-img" <?php } ?> value="1"></a>
						<a <?php if($userRating > 2) {?> class="badge-img fullStar" <?php }else{ ?>class="badge-img" <?php } ?> value="2"></a>
						<a <?php if($userRating > 3) {?> class="badge-img fullStar" <?php }else{ ?>class="badge-img" <?php } ?> value="3"></a>
						<a <?php if($userRating > 4) {?> class="badge-img fullStar" <?php }else{ ?>class="badge-img" <?php } ?> value="4"></a>
						<a <?php if($userRating > 5) {?> class="badge-img fullStar" <?php }else{ ?>class="badge-img" <?php } ?> value="5"></a>
					</div>
				<?php } ?>
			</div>

			-->
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
	<?php echo $this->element('mentor/certification'); ?>

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

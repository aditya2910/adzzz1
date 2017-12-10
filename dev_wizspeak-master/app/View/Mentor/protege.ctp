<div class="profile-mid-section" >
<div class="post-main" id="postboxid" >

	<div class="post-options">
		<span class="iocnfr"></span>Protege List</h2>
		<div class="filter-search">
			<input type="search" data-sort="cover-pic-disc-name" id="visitor-friend-search" placeholder="Search here.." class="friend-search"  />
		</div>

	</div>

</div>

<div class="profile-row-mids">
	<?php
	foreach($menti as $index => $post):
		?>

		<div class="cover-inner-left">
			<div class="cover-profile-Pic">


				<?php
				$pic = '/img/userReg.jpg';
				if(@getimagesize(IMAGE_PROFILE_MAIN.$post->profilePic)){

					$pic = IMAGE_PROFILE_MAIN.$post->profilePic;
				}

				echo $this->Html->image($pic,array(
					'url' => array(
						'controller'=>'profiles','action'=>$post->userId
					)
				));

				?>
			</div>
			<div class="cover-pic-Disc">
				<div class="cover-pic-disc-name">
					<h3>
						<?php

						echo $this->Html->link(
							$post->first_name." ".$post->last_name,
							array(
								'controller' => 'profiles',
								'action' => $post->userId,
								'full_base' => true
							)
						);
						?>

					</h3>
					<h5><?php echo $post->profileStatus ?></h5>
				</div>
			</div>
		</div>

	<?php  endforeach; ?>

</div>
</div>


<div class="mentors">

	<h2>Messages</h2>
	<div class="custom-scroll mentors-list-main">

		<?php foreach($sidePosts as $post){

			?>
		<div class="mentor-row">
			<div class="mentor-pic">


				<?php
				$pic = '/img/userReg.jpg';
				if(@getimagesize(IMAGE_PROFILE_MAIN.$post->postby_pic)){

					$pic = IMAGE_PROFILE_MAIN.$post->postby_pic;
				}

				echo $this->Html->image($pic,array(
					'url' => array(
						'controller'=>'profiles','action'=>$post->postUserId
					)
				));


				?>

			</div>
			<div class="mentor-detail">
				<h4><?php
					echo $this->Html->link(
						$post->postby_name,
						array(
							'controller' => 'profiles',
							'action' => $post->postUserId

						)
					);
					//echo $post->postby_name ?></h4>
				<p><?php echo $post->title ?></p>
			</div>
			<div class="mentor-mail">
				<?php echo $this->Html->link(
					'',
					'/mentor/'.$pageUser.'/talk/'.$post->postUserId,
					array('class' => 'envelope')
				); ?>
			</div>
		</div>
		<?php } ?>


	</div>

</div>

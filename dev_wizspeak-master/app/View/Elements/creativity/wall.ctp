
	<div class="row-mid-notification list-notif-search">
		<ul>
			<?php foreach($userPosts as $post){ ?>
			<li>

				<div class="notif-image">
					<?php
					echo  $this->Html->image(IMAGE_PROFILE_WALL.$post->cUserPic);
					?>
				</div>
				<div class="notif-copy">
					<h3><?php echo $post->comenterName; ?></h3>
					<p> <?php echo $post->comment; ?></p>
					<span><?php  echo $this->Time->timeAgoInWords(
							$post->commentedDate,
							array('format' => 'j F, Y', 'end' => '+1 day', 'accuracy' => array('month' => 'month','day' => 'day','hour' => 'hour','minute' => 'minute'))); ?></span>




				</div>
			</li>
			<?php } ?>
		</ul>

	</div>







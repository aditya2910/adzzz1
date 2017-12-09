<?php
if(count($cmt)>3) { ?>
<div class="post-users-comments" data-id="<?php echo $cmt[0]->id; ?>">
	<span class="more_cmt" >View more comments</span>
</div>
<?php }

foreach($cmt as $comment ) {  ?>
<div class="post-users-comments comments" data-id="<?php echo $comment->id; ?>" id="post-users-comment-<?php echo $comment->id; ?>" >

		<div class="postedby-image">
			<?php

			 echo $this->Html->image(IMAGE_PROFILE_WALL_COMMENT.$comment->cUserPic);
			?>
		</div>
		<div class="commnetedby">
			<h3><?php echo $comment->comenterName; ?></h3>
			<p><?php echo  $comment->comment ?></p>


			<div class="like-replay">
				<span class="likes">
					<?php $class_name = "star"; if($comment->iLikes){ $class_name = "starplus"; } ?>
					<span class="<?php echo $class_name; ?>" >&nbsp;&nbsp;&nbsp;</span>
				</span>
				<span class="replay cmt_like_count"><?php echo $comment->likes; ?> likes</span>
				<span class="time">
					<?php  echo $this->Time->timeAgoInWords(
					$comment->commentedDate,
					array('format' => 'j F, Y', 'end' => '+1 day', 'accuracy' => array('month' => 'month','day' => 'day','hour' => 'hour','minute' => 'minute'))); ?>.

				</span>
		   </div>


		</div>
</div>


<?php

} ?>

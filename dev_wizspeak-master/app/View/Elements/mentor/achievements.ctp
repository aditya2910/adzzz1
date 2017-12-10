<?php
foreach($userPosts as $post){
	//debug($post);
	$pvt ="";
	if($post->isPrivate==1){ $pvt ="pvt"; }
	?>
	<div class="post-users <?php echo $pvt; ?> " data-id="" id="post-user-<?php echo $post->id; ?>" >
		<div class="post-users-head">

			<div class="post-user-head-img">
				<?php
				$pic = '/img/userReg.jpg';
				if(@getimagesize(IMAGE_PROFILE_WALL.$post->postby_pic)){
					$pic = IMAGE_PROFILE_WALL.$post->postby_pic;
				}
				echo  $this->Html->image($pic);
				?>

			</div>
			<div class="post-user-head-details">
				<h3><?php echo $post->postby_name;  ?>
					<?php
					if($post->postby_id != $post->postto_id){
						?>
						<span>  <b><?php

								$link = array();
								if($post->wall_type == 1){
									$link = array(
										'controller' => 'profiles',
										'action' => $post->postto_name,
										'wall'
									);
								}elseif($post->wall_type == 2){
									$link = array(
										'controller' => 'groups',
										'action' => $post->postto_name,
										'wall'
									);

								}elseif($post->wall_type == 3){
									$link = array(
										'controller' => 'mentor',
										'action' => $post->postto_name,
										'profile'
									);

								}
								$click = " - ";
								if(empty($post->postPageName)){ $click = ""; }
								echo $this->Html->link($click.$post->postPageName,$link);

								//echo $post->postPageName ?></b></span>

					<?php } ?>
				</h3>
				<p>&nbsp;
					<span></span>
				</p>
			</div>


			<div class="post-edit-wrap" id="<?php echo $post->id; ?>" >
				<div class="edit pencil">&nbsp;</div>
				<div class="postEdit-drop">
					<ul>
						<!-- <li><a href="#">Hide</a> -->
						<?php if($post->postby_id == $this->Session->read('Auth.User.id')) { ?>
							<li><a href="#">Delete this post</a>
							</li>

							<li><a href="#">Edit this post</a>
							</li>
						<?php } ?>
						<li class="popup" data-rel="reportPopup" ><a href="#">Report this post</a>
						</li>
						<!-- <li><a href="#">Unfollow alex</a>  -->
						</li>
						<!-- <li><a href="#">Get Notification</a>  -->
						</li>
						<!-- <li><a href="#">Embed post</a> -->
						</li>
					</ul>
				</div>
			</div>

			<div class="post-user-head-details">
				<h2><?php echo nl2br($post->title); ?></h2>
				<p class="post-text" ><?php echo nl2br($post->description); ?></p>
			</div>



		</div>
		<?php if($post->post_type_id== 3) { ?>

			<div class="post-users-video">



				<iframe title="YouTube video player" class="youtube-player" type="text/html"


						width="100%" height="303" src= "<?php echo 'http://www.youtube.com/embed/'.$post->link; ?>?rel=0"
						frameborder="0" allowFullScreen></iframe>


			</div>
		<?php }
		if($post->post_type_id== 5) { ?>
			<div class="post-users-video">

				<div class="span12">
					<div id="ap2_<?php echo $post->id; ?>" >
						<audio controls>
							<source src="<?php echo APPURL.POST_AUDIO_UPLOAD_FOLDER.$post->link ?>" type="audio/mpeg">
							Your browser does not support the audio element.
						</audio>
						<span class="volume-full">&nbsp;</span>
					</div>


				</div>
			</div>
			<?php
		}
		if($post->post_type_id== 2) { ?>
			<div class="post-users-image">
				<?php  ?>

				<?php echo $this->Html->image(IMAGE_FULL_WALL_DESK.$post->link);?>


			</div>
		<?php }
		if($post->post_type_id== 4) { ?>
			<div class="post-users-video" >

				<a target="_blank" href="<?php echo Configure::read('app_url').POST_DOC_UPLOAD_FOLDER.$post->link ?>"  >&nbsp;&nbsp;&nbsp;<span class="text-file sel-copy">&nbsp;</span></a>

			</div>
		<?php } ?>


		<div class="post-users-option">
			<ul class="post-option-ulist">
				<li><?php
					$class_name = "star";
					if($post->iLikes){
						$class_name = "starplus";
					}
					?>
					<span class="<?php echo $class_name; ?>">&nbsp;</span>
				</li>
				<li>
					<span data-rel="sharepopup"  data-ajax="<?php echo $post->id; ?>"  value="Share"  class="share-icon popup">&nbsp;</span>

					<span data-rel="sharepopup" <?php  ?>   class="<?php ?>">&nbsp;</span>
				</li>
			</ul>

			<div class="post-likes"><?php  echo $post->likes; ?> likes</div>
			<div class="time-post"><?php  echo $this->Time->timeAgoInWords(
					$post->date_posted,
					array('format' => 'j F, Y', 'end' => '+1 day', 'accuracy' => array('month' => 'month','day' => 'day','hour' => 'hour','minute' => 'minute'))); ?></div>
		</div>

		<div class="post-users-comment-div">
			<?php
			if(sizeof($post->comments) > 0){

				?>
				<div class="post-users-comments" data-id="<?php echo $post->comments[0]->id; ?>" >
					<?php if(sizeof($post->comments) > 3){ ?>
					<span class="more_cmt achievements-cmt" >View previous comments</span>
					<?php } ?>
					<p class="more_cmt" >View comments</p>
				</div>
			<?php }

			foreach($post->comments as $comment ){  ?>
			<div class="post-users-comments comments achievements-cmt" data-id="<?php echo $comment->id; ?>" id="post-users-comment-<?php echo $comment->id; ?>" >

				<?php
				//echo $this->requestAction('/users/comment_auther/'.$comment->commenter_id.'/'.$comment->comment.'/'.$comment->id);
				if( empty($comment)){

					echo 'error';
				}else{  ?>



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
				<?php }    }

			?>
		</div>
		<?php   ?>
		<div class="post-users-comments add-comment">
			<div class="postedby-image">
				<?php echo $this->Html->image(IMAGE_PROFILE_WALL_COMMENT.CakeSession::read("Auth.User.UserGroupProfilePic.link"),array(
					'url' => array('controller' =>'profiles',"action" => "index")
				)); ?>

			</div>

			<div class="commnetedby">
				<input type="text" class="postedby-input" placeholder="Type your Comment" />
				<i class="comment-post">&nbsp;</i>

			</div>


		</div>
		<?php  ?>
	</div>

<?php }

?>


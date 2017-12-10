
<div class="profile-mid-section" >
	<?php if($role==1){?>
<div class="post-main" id="postboxid" >
	<input type="text" placeholder="achievement " id="post_head" class="post-title"  />
	<textarea placeholder="  describe ....." id="post_box" class="post-textarea"></textarea>
	<div id="preview_postimage" >

	</div>
	<div id="preview_postvideo" >


	</div>
	<div id="preview_postaudio" >


	</div>
	<div id="preview_postdoc" >


	</div>
	<progress class="progress-video" value="0" max="100"></progress>
	<div class="post-options">
		<ul class="post-ulist">
			<li>
				<span class="camera">&nbsp;</span>
			</li>
			<li>
				<span class="video-camera">&nbsp;</span>
			</li>
			<li>
				<span class="file-text">&nbsp;</span>
			</li>
			<li>
				<span class="volume-off">&nbsp;</span>
			</li>

		</ul>
		<div class="share">
			<input type="button"  id="share" value="Share" />
		</div>

	</div>



</div>
	<?php } ?>
<div id='Posts'>

	<?php


	$this->Paginator->options['url'] = array('controller' => 'profiles', 'action' => $pageUser,'wall');

	echo  $this->element('mentor/achievements'); ?>
</div>

<?php
if(count($userPosts)>9){
	echo $this->Paginator->next('more ...');
}

?>
</div>
<?php echo $this->element('report'); ?>

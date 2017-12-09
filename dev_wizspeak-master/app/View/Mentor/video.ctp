<div class="profile-mid-section">
	<div class="profile-media-top">
		<ul class="profile-mediaUlist">
			<li class="mediaSelect">
                                        <span class="media-share-wrapper">


											<?php
											echo $this->Html->link('<span class="camera">&nbsp;</span>&nbsp;<label>Image</label>',array(
												'controller' => 'mentor','action' => $pageUser,'media'
											),array('escape' => false));
											?>
                                        </span>
			</li>
			<li>
                                        <span class="media-share-wrapper">
											<?php
											echo $this->Html->link('<span class="video-camera">&nbsp;</span>&nbsp;<label>Videos</label>',array(
												'controller' => 'mentor','action' => $pageUser,'video'
											),array('escape' => false));
											?>
                                        </span>
			</li>
			<li>
                                        <span class="media-share-wrapper">
											<?php
											echo $this->Html->link('<span class="file-text">&nbsp;</span>&nbsp;<label>Texts</label>',array(
												'controller' => 'mentor','action' => $pageUser,'text'
											),array('escape' => false));
											?>
                                        </span>
			</li>
			<li>
                                        <span class="media-share-wrapper">
											<?php
											echo $this->Html->link('<span class="volume-off">&nbsp;</span>&nbsp;<label>Audios</label>',array(
												'controller' => 'mentor','action' => $pageUser,'audio'
											),array('escape' => false));
											?>
                                        </span>
			</li>
		</ul>
		<div class="media-sort">
			<ul>
				<li class="sortby">Sort by:</li>
				<li class="media-recent">Recent</li>
				<li>
                                            <span class="mediaS-year">
                                                <select class="custom-select">
                                                    <option>year</option>
                                                    <option>2014</option>
                                                    <option>2013</option>
                                                    <option>2012</option>
                                                    <option>2011</option>
                                                    <option>2010</option>
                                                    <option>2009</option>
                                                </select>
                                            </span>
				</li>
			</ul>
		</div>

	</div>

	<div class="profile-media-content">
		<div class="profile-media-top">
			<div class="media-sort">
				<ul>
					<?php $i = 1; while($i <= $indexCount) {?>

						<?php
						$back = "background:#c4c4c4";
						if($page==$i){
							$back = "background:#8f759c";
						}
						$button =  $this->Html->tag("li",$i,array("class" => "media-recent","style" =>$back));
						echo $this->Html->link($button,array(
							'controller' => "mentor",'action' => $pageUser,"media","page"=>$i
						),array('escape'=>false));
						?>
						<?php?>
						<?php $i ++;} ?>

					<li></li>
				</ul>

			</div>
		</div>

	</div>

	<div class="profile-media-content">
		<?php  foreach ($img as $index => $image) {


			if(($index)%4 ==0){
				echo "<div class='profile-media-row'>";
			}

			echo '<div class="profile-media-item">';
			echo  $this->Html->image(IMAGE_PROFILE_BIG.$image->link);
			echo	'<div class="media-item-details">'.
				'<h3>Robert Jemes</h3>'.
				'<p>'.
				'<span class="map-marker">&nbsp;</span>St. Albert school, Alamba</p>'.
				'</div>'.
				'</div>';
			if(($index+1)%4 ==0){
				echo "</div>";
			}

		}

		if((count($img)+1)%4 > 0){
			echo"</div>";
		}
		?>


	</div>
</div>

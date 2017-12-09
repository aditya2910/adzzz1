<script>

	var availableTags1 = <?php echo json_encode(array()); ?>
</script>
<div class="fixed-container">
	<div class="register-main">
		<div class="register-left stepreg2">
			<div class="user-reg">
				<div class="user-regImg">
					<?php
					echo $this->Html->image('ambition.jpg');
					?>
				</div>
				<div class="user-regDetails">
					<h2>AMBITION</h2>
					<p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit.</p>
				</div>
			</div>
			<div class="mentor-reg">
				<div class="user-regImg">
					<?php
					echo $this->Html->image('hobbies.jpg');
					?>
				</div>
				<div class="user-regDetails">
					<h2>HOBBIES</h2>
					<p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit.</p>
				</div>

			</div>
		</div>
		<div class="register-right">
			<div class="step-main">
				<div class="step-copy">
					<h3>REGISTRATION</h3>
					<h2>STEPS</h2>
				</div>
				<div class="step-img step3">
					<div class="bg-percent"></div>
					<?php
					echo $this->Html->image('steps.png');
					?>

					<ul class="step-ulist" >
						<li class="no1 active" >1</li>
						<li class="no2 active" >2</li>
						<li class="no3 active" >3</li>
						<li class="no4">4</li>
					</ul>
				</div>
			</div>
			<div class="register-form-main">
				<?php echo $this->Form->create('UserProfile', array('id' => 'userCategory', 'method' => 'post')); ?>

				<div class="rows-reg">
					<div class="rows-reg-left">Area of expertise</div>
					<div class="rows-reg-right">
						<?php echo $this->element("mentor_category"); ?>
					</div>
				</div>
				<div class="rows-reg">
					<div class="rows-reg-left">&nbsp;</div>
					<div class="rows-reg-right">
						<div class="expertise-listsel"></div>
					</div>
				</div>

				<div class="rows-reg">
					<div class="rows-reg-left">Ambitions</div>
					<div class="rows-reg-right">
						<?php echo $this->element("simple_search"); ?>
					</div>
				</div>
				<div class="rows-reg">
					<div class="rows-reg-left">&nbsp;</div>
					<div class="rows-reg-right">
						<div class="ambitions-listsel"></div>
					</div>
				</div>


				<div class="rows-reg">
					<div class="rows-reg-left">Hobbies</div>
					<div class="rows-reg-right">
						<?php echo $this->element("simple_search_hob"); ?>
					</div>
				</div>
				<div class="rows-reg">
					<div class="rows-reg-left">&nbsp;</div>
					<div class="rows-reg-right">
						<div class="hobbies-listsel"></div>
					</div>
				</div>







				<div class="rows-reg">
					<div class="rows-reg-left">&nbsp;</div>
					<div class="rows-reg-right">
						<?= $this->Form->button(__('NEXT'),array('class' => "common-button")) ?>

					</div>
				</div>

				<?php echo  $this->Form->end(); ?>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>

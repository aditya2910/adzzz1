<?php //debug($role); ?>
<div class="cover-inner-right">
                <ul class="ulist-covermenu">
                    <li <?php if($select == '' || $select == 'index' ) { echo 'class="profileSel"';} ?>  >
                            <?php echo $this->Html->link(__('About'), array('controller' => 'profiles', 'action' => $userDetails->userId)); ?>
                            <span>&nbsp;</span>
                    </li>
					<?php if(!(($role == 0) OR  ($role == 3)) ) {?>
                    <li <?php if($select == 'wall') { echo 'class="profileSel"';} ?> >
                            <?php echo $this->Html->link(__('My Wall'), array('controller' => 'profiles', 'action' => $userDetails->userId, 'wall' )); ?>
                            <span>&nbsp;</span>
                    </li>
                    <li <?php if($select == 'friends') { echo 'class="profileSel"';} ?> >
                         <?php echo $this->Html->link(__('Friends'), array('controller' => 'profiles', 'action' => $userDetails->userId, 'friends')); ?>
                        <span>&nbsp;</span>
                    </li>
                    <li <?php if($select == 'mentors') { echo 'class="profileSel"';} ?> >
                         <?php echo $this->Html->link(__('Mentors'), array('controller' => 'profiles', 'action' => $userDetails->userId, 'mentors' )); ?>
                        <span>&nbsp;</span>
                    </li>
                    <li <?php
                    $list = array('audio','documents','videos','images');
                    if(in_array($select,$list)) { echo 'class="profileSel"';} ?> >
                         <?php echo $this->Html->link(__('Media'), array('controller' => 'profiles', 'action' => $userDetails->userId, 'images' )); ?>
                        <span>&nbsp;</span>
                    </li>
					<?php if($role == 1) {?>
					<li <?php if($select == 'setting') { echo 'class="profileSel"';} ?> >
						<?php echo $this->Html->link(__('Setting'), array('controller' => 'profiles', 'action' => $userDetails->userId, 'setting' )); ?>
						<span>&nbsp;</span>
					</li>
					<?php  } }  ?>
                </ul>
            </div>

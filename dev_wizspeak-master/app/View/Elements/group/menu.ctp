        <div class="cover-inner-right">
            <ul class="ulist-covermenu">
                <li <?php if($this->request->param('action') == 'about') { echo 'class="profileSel" '; }   ?> >
                    <?php echo $this->html->link(__('About'), array('controller' => $this->params['controller'], 'action' => $this->request->param('groupName'), 'about' )) ?>
                    <span>&nbsp;</span>
                </li>
				<?php if($userGroupRole == 2 || $userGroupRole == 1){  ?>
                <li <?php if($this->request->param('action') == 'wall') { echo 'class="profileSel" '; } ?> >
                    <?php echo $this->html->link(__('Wall'), array('controller' => $this->params['controller'], 'action' => $this->request->param('groupName'), 'wall' )) ?>
                    <span>&nbsp;</span>
                </li>
                <li <?php $med_array = array('media-audio','media-images','media-videos','media-documents');
                if(in_array($this->request->param('action'), $med_array)) { echo 'class="profileSel" '; } ?> >
                    <?php echo $this->html->link(__('Media'), array('controller' => $this->params['controller'], 'action' => $this->request->param('groupName'), 'images' )) ?>
                    <span>&nbsp;</span>
                </li>
                <?php if($userGroupRole == 1){ ?>
                <li <?php if($this->request->param('action') == 'more') { echo 'class="profileSel" '; } ?> >
                    <?php echo $this->html->link(__('More'), array('controller' => $this->params['controller'], 'action' => $this->request->param('groupName'), 'more' )) ?>
                    <span>&nbsp;</span>
                </li>
                <?php } } ?>

            </ul>
        </div>

    <div class="right-extended">
        <ul class="filter-cr">

            <li  <?php if($select=='images') {?>class='filterSel'<?php } ?>  ><span class="camera"></span>

            <?php
            echo $this->Html->link('Images',
                array('controller'=>'groups','action'=>$this->request->param('groupName'),'images'));
            ?>
            </li>
            <li  <?php if($select=='videos') {?>class='filterSel'<?php } ?> ><span class="video-camera"></span>
            <?php
            echo $this->Html->link('Videos',
                array('controller'=>'groups','action'=>$this->request->param('groupName'),'videos'));
            ?>
                </li>
            <li <?php if($select=='documents') {?>class='filterSel'<?php } ?>  ><span class="file-text"></span>
            <?php
            echo $this->Html->link('Documents',
                array('controller'=>'groups','action'=>$this->request->param('groupName'),'documents'));
            ?>
                </li>
            <li  <?php if($select=='audio') {?>class='filterSel'<?php } ?>><span class="volume-off"></span>
            <?php
            echo $this->Html->link('Audios',
                array('controller'=>'groups','action'=>$this->request->param('groupName'),'audio'));
            ?>
                </li>
        </ul>
        <hr></hr>
    </div>

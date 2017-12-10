                       <div id="hidden_forms" style='visibility: hidden'  >
                         <?php
                        echo $this->Form->create('post_box',array('type'=>'hidden','id'=>'form_image'));
                        echo $this->Form->input('image',array('id'=>'post_box_image','type'=>'file','name'=>'postimage[]','label'=>false,'accept' => 'image/*'));
                        echo $this->Form->end();


                        echo $this->Form->create('video', array('id'=> 'post_box_video_form'));
                        echo $this->Form->input('post_box_video',array('id'=> 'post_box_video','type'=> 'file','accept' => 'video/*'));
                        echo $this->Form->end();

                        echo $this->Form->create('audio',array('id' =>'post_box_audio_form' ));
                        echo $this->Form->input('audio_file',array('id'=> 'post_box_audio', 'type' => 'file','accept' => 'audio/*' ));
                        echo $this->Form->end();

                        echo $this->Form->create('doc',array('id' =>'post_box_doc_form' ));
                        echo $this->Form->input('doc_file',array('id'=> 'post_box_doc', 'type' => 'file','accept' => 'application/msword, application/vnd.ms-excel, application/vnd.ms-powerpoint,
text/plain, application/pdf' ));
                        echo $this->Form->end();

                        ?>

                        <form name="cover_pic_pos" action="/wizspeakv254/groups/change_coverpic_pos" method="POST" id="cover_pic_pos">
                            <input type="text" id="cover_top"  name="top"  />
                            <input type="text" id="cover_left"  name="left"  />
                            <input type="text" id="cover_group_id"  name="id"  />
                        </form>
                       </div>

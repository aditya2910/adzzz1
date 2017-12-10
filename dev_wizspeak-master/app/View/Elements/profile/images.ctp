<?php   echo $this->element('profile/media_media_menu'); ?>
    <div class="clear"></div>
    <div class="filter-contents">

                    <!------------- Image --------------->

        <div id="filter-images" class="filter-con-row">
            <div class="post-main" id="postboxid" >

                <div class="post-options">
                    <span class="iocnfr"></span>Images</h2>
                    <div class="filter-search">
                        <input type="search" data-sort="cover-pic-disc-name" id="visitor-image-filter" placeholder="Search here.." class="friend-search"  />
                    </div>

                </div>

            </div>
            <div class="profile-row-mids">
            <div class="filter-con-row-inner" id='user_media_images' >
                <?php foreach($userImages as $index => $img ){ ;  ?>
                <div class="filter-box user_media_image">
                    <div class="filter-box-thumb">
                        <?php echo $this->Html->image(IMAGE_CHANGE.$img->link); ?>
                    </div>
                    <div class="filter-box-details">
                        <h3><?php echo $img->title ?></h3>
                        <div class="details-thumb">Uploaded by <b><?php echo $img->postby_name ?></b>
                        </div>
                    </div>
                </div>
                <?php }
                    if(count($userImages)>0){
                            echo $this->Paginator->next('Show more Images...');
                    }else{
                            echo '<p style="text-align:center;" >No Image Found...</p>';
                    }
                    ?>

            </div>

            </div>
        </div>

    </div>

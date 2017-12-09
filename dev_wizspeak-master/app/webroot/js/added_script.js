/*
 *
 * sandeep
 */

        $(document).ready( function(){

        /*
         * UI listion - users/registration
         */


        /********************************************** post section start *************************************************/

        //image upload listioner
        $('.post-ulist').on('click' , '.camera' ,function(){

            $('#post_box_image').click();
        });

        $('.post-ulist').on('click' , '.video-camera' ,function(){

            $('#post_box_video').click();
        });

        $('.post-ulist').on('click' , '.volume-off' ,function(){

            $('#post_box_audio').click();
        });

        $('.post-ulist').on('click' , '.file-text' ,function(){

            $('#post_box_doc').click();
        });

     console.log(jsVars);

        $('#share').click(function(){

			$(this).prop('disabled', true);
		//check for file upload
            var img_uploaded_length = $('#preview_postimage').children().length;
            var doc_uploaded_length = $('#preview_postdoc').children().length;
            var video_uploaded_length = $('#preview_postvideo').children('.sel-hob-main').length;
            var audio_uploaded_length = $('#preview_postaudio').children('.sel-hob-main').length;
            var text_comment = $('#post_box').val();
			if($('#post_head').length){
				var text_head = $('#post_head').val();
			}else{
				var text_head = "";
			}

			var postHead = text_head.trim();
			var postTxt = text_comment.trim();

            var status = '';
            var msg = '';


		//step 1 upload attachments
			upload_attachments();

            function upload_attachments(){

                if (img_uploaded_length > 0) {

                    upload_img();

                }else if (doc_uploaded_length > 0){


                    upload_doc();

                }else if (video_uploaded_length > 0){

                    upload_video();

                }else if (audio_uploaded_length > 0){

                    upload_audio();
                }else{
					if(postTxt.length > 0 || postHead.length > 0){

						save_post_text('',1,1);
					}else{

						$("#share").removeAttr('disabled');

					}


                }

            }

            function upload_img(){
                var imgs = '';
                var imgsrc = new Array();

                for(i = 0;i < img_uploaded_length; i++){

                    var div = $('#preview_postimage').children('.sel-hob-main');
                    var span = div.children('.sel-image');
                    var img = span.children().eq(0);
                    var img_src = img.attr('src');
                    imgsrc.push(img_src);
                }

                var data = {imgsrc : imgsrc};

                $.ajax({
                    type: "POST",
                    url: baseUrl + 'posts/save_image',
                    data: data,
                    dataType: "JSON",
                    success: function(response) {

                        if(response.success){
                            $('#preview_postimage').html('');
                            $('#form_image').each(function(){
                                this.reset();
                            });
                            disable_enable_remains('camera',1);
                            save_post_text(response.link_0,2,1);
                        }else{
                           alert('some thing went wrong opps!!');
                        }

                    },
                    error: function(response, status) {
                            alert('An unexpected error has occurred!!');
                    }
                });

            }


            function upload_video(){

                var formData = new FormData($('#post_box_video_form')[0]);

                $.ajax({
                    url: baseUrl + 'posts/add_postvideo_ajax',
                    type: 'POST',

                    xhr: function()
                            {
                              var xhr = new window.XMLHttpRequest();
                              xhr.upload.addEventListener("progress", function(evt){

                                    if (evt.lengthComputable) {
                                        var percentComplete = evt.loaded / evt.total;
                                        $('.progress-video').attr({value:evt.loaded,max:evt.total});
                                        //console.log(percentComplete);
                                    }
                              }, false);
                              //Download progress
                              xhr.addEventListener("progress", function(evt){

                                    if (evt.lengthComputable) {
                                        var percentComplete = evt.loaded / evt.total;
                                        //Do something with download progress
                                        //console.log(percentComplete);
                                    }
                              }, false);
                              return xhr;
                              },


                    data: formData,
                    cache: false,
                    contentType: false,
                    processData: false,

                    success: function(result) {

                        console.clear();
                        console.log('xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx');
                        console.log(result);
                        UPinfo = JSON.parse(result);
                        console.log('xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx');
                        $('#post_box_videoIndexForm').each(function(){
                            this.reset();
                        });
                        $("#postboxid .sel-close").click();
                        if(UPinfo.success) {
                            save_post_text(UPinfo.link,3,0);
                        }

                    }

                });

            function progressHandlingFunction(e){

                if(e.lengthComputable){
                    $('.progress-video').attr({value:e.loaded,max:e.total});
                }
            }

            function completeHandler(result){

                $('#preview_postvideo').html('');

            }

                return false;


            }


            function upload_doc(){

                var formData = new FormData($('#post_box_doc_form')[0]);

                $.ajax({
                    url: baseUrl + 'posts/upload_doc',
                    type: 'POST',

                    xhr: function()
                      {
                        var xhr = new window.XMLHttpRequest();
                        //Upload progress
                        xhr.upload.addEventListener("progress", function(evt){
                          if (evt.lengthComputable) {
                            var percentComplete = evt.loaded / evt.total;
                            $('.progress-video').attr({value:evt.loaded,max:evt.total});
                            //console.log(percentComplete);
                          }
                        }, false);
                        //Download progress
                        xhr.addEventListener("progress", function(evt){
                          if (evt.lengthComputable) {
                            var percentComplete = evt.loaded / evt.total;
                            //Do something with download progress
                            //console.log(percentComplete);
                          }
                        }, false);
                        return xhr;
                      },

                    data: formData,
                    cache: false,
                    contentType: false,
                    processData: false,

                    success: function(result) {
                        UPinfo = JSON.parse(result);
                        $('#post_box_doc_form').each(function(){
                            this.reset();
                        });
                        $('.progress-video').attr({value:0,max:100});
                        $("#postboxid .sel-close").click();
                        if(UPinfo.success) {
                            save_post_text(UPinfo.link,4,1);
                        }
                    }

                });
                append_post(post_id);
            }


            //save text in post
            function save_post_text(link,post_type,p_status) {


				is_private = 0;
				if($('#visibility').length){
					var d = $("#visibility input[type='radio']:checked").val();
					if(d=='PVT'){
						is_private = 1;
					}
				}

            var data = {"postby_id": jsVars.user_id ,"postto_id" :jsVars.wall_id  ,"wall_type": jsVars.wall_type, "vertical_id" : jsVars.vertical_id ,"is_private": is_private,"post_type_id": post_type,"title": postHead ,"description" : ""+postTxt+""  ,"status" : p_status,"link" : String(link) };

                console.log(data);
                    $.ajax({
                                type: "POST",
                                url: baseUrl+'posts/add',
                                data: data,
								dataType: "json",
                                success: function(response, status) {
									console.log('xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx');
									console.log(response);
									console.log('xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx');

                                        if(!response.success) {
                                                alert('An unexpected error has occurred!');
                                        }else{
                                            $('#post_box').val('');
                                            $('#post_head').val('');
                                            if(p_status > 0 ){
                                            append_post(response.post_id);
                                            }else{
                                                //no  process

                                            }

                                        }
									$("#share").prop('disabled', false);
                                },
                                error: function(response, status) {

									console.log('XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX');
                                    console.log(response);
                                        alert('An unexpected error has occurred!!');
                                }
                    });

            }


            function append_post(post_id){

            var str = 'post_id=' + post_id;
            $.ajax({
                type: "POST",
                url: baseUrl + 'posts/view',
                data: str
            })
                .done(function(msg) {
                    $('#Posts').prepend(msg);

                    var dom = $.parseHTML(msg);
                    var post_id = $(dom[1]).attr('id').substr(10);
                    if($('#post-user-' + post_id).find('.bxslider').length > 0){
                        $('#post-user-' + post_id).find('.bxslider').bxSlider({infiniteLoop: false, pager: false});
                    }
                });


            }


            function upload_audio(){

                var formData = new FormData($('#post_box_audio_form')[0]);

                $.ajax({
                    url: baseUrl + 'posts/upload_audio',
                    type: 'POST',

                    xhr: function()
                      {
                        var xhr = new window.XMLHttpRequest();
                        //Upload progress
                        xhr.upload.addEventListener("progress", function(evt){
                          if (evt.lengthComputable) {
                            var percentComplete = evt.loaded / evt.total;
                            $('.progress-video').attr({value:evt.loaded,max:evt.total});
                            //console.log(percentComplete);
                          }
                        }, false);
                        //Download progress
                        xhr.addEventListener("progress", function(evt){
                          if (evt.lengthComputable) {
                            var percentComplete = evt.loaded / evt.total;
                            //Do something with download progress
                            //console.log(percentComplete);
                          }
                        }, false);
                        return xhr;
                      },


                    data: formData,
                    cache: false,
                    contentType: false,
                    processData: false,

                    success: function(result) {
                        UPinfo = JSON.parse(result);
                        $('#post_box_audio_form').each(function(){
                            this.reset();
                        });
                        $("#postboxid .sel-close").click();
                        if(UPinfo.success) {
                            save_post_text(UPinfo.link,5,1);
                        }
                    }

                });
            }





        });











        $('#post_box_image').change( function(){
            disable_enable_remains('camera',0);
            display_image(this);
        });

        $('#post_box_video').change(function(e){
              disable_enable_remains('video-camera',0);//diable all other than para1
              display_video(this);
        });

        $('#post_box_audio').change(function(input){
            disable_enable_remains('volume-off',0);
            audio_upload(this);
        });

        $('#post_box_doc').change(function(input){
            disable_enable_remains('file-text',0);
            doc_upload(this);
        });

            $('.power-off').click(function(){
            var okayCancelBox = new MessageBox('do you really want to log out',"yesNo",yesNoHandler);
            okayCancelBox.yesOrNo();
            });

        $('#preview_postimage').on('click', '.sel-close' ,function(){
            $(this).parent('.sel-hob-main').attr('id','remove-pic')
            $('#preview_postimage').children('#remove-pic').remove();
            $('#form_image').each(function(){
            this.reset();
            });
            if( $('#preview_postimage').children('.sel-hob-main').length == 0){
               disable_enable_remains('camera',1);
            }
        });

        $('#preview_postvideo').on('click', '.sel-close' ,function(){
            $(this).parent('.sel-hob-main').attr('id','remove-pic')
            $('#preview_postvideo').children('#remove-pic').remove();
            $('#post_box_videoIndexForm').each(function(){
            this.reset();
            });

            $('.progress-video').css({'dispaly':'none'});
            $('#preview_postvideo').css({"height":"0px"});
            if( $('#preview_postvideo').children('.sel-hob-main').length == 0){
            $('.progress-video').attr({value:0,max:100});
            $('.progress-video').css({'display' : 'none'});
               disable_enable_remains('video-camera',1);
            }
        });

        $("#preview_postaudio").on("click" , '.sel-close' , function(){

            $(this).parent('.sel-hob-main').attr('id','remove-pic')
            $('#preview_postaudio').children('#remove-pic').remove();
            $('#post_box_audio_form').each(function(){
            this.reset();
            });
            $('.progress-video').attr({value:0,max:100});
           $('#preview_postaudio').css({"height":"0px"});
           $('.progress-video').css({'display' : 'none'});
           disable_enable_remains('volume-off',1);
        });

        $("#preview_postdoc").on("click" , '.sel-close' , function(){

            $(this).parent('.sel-hob-main').attr('id','remove-pic')
            $('#preview_postdoc').children('#remove-pic').remove();
            $('#post_box_doc_form').each(function(){
            this.reset();
            });
            $('.progress-video').attr({value:0,max:100});
            $('#preview_postdoc').css({"height":"0px"});
            $('.progress-video').css({'display' : 'none'});
           disable_enable_remains('file-text',1);
        });


        function display_image(input) {

            if (input.files && input.files[0]) {
                var reader = new FileReader();

                /*validate input file javascript*/



                if ($supported_Image_Filetype.indexOf(input.files[0].type) < 0) {
                    alert('file format not supported');
                    disable_enable_remains('camera',1);
                    return false;
                }
                if (input.files[0].size >= 8048000) {
                    alert('Uploaded Image size is more the allowed size');
                    disable_enable_remains('camera',1);
                    return false;
                }
               // alert('validated');
                reader.onload = function(e) {

                    var div = $('<div class="sel-hob-main" >');
                    var span = $('<span class="sel-image" >');
                    var img = $('<img >');
                    img.attr('src', e.target.result);
                    img.css('width', '100px');
                    img.css('height', '100px');
                    img.css('margin', '4px');
                    img.appendTo(span);

                    var close = $('<div class="sel-close" ></div>');
                    close.appendTo(div);
                    span.appendTo(div);
                    div.appendTo('#preview_postimage');

                }
                reader.readAsDataURL(input.files[0]);
            }


        }


        function display_video(input) {

            if (input.files && input.files[0]) {
                var reader = new FileReader();
                /*validate video file javascript*/

                if ($supported_VIdeo_Filetype.indexOf(input.files[0].type) < 0) {
                    alert('file format not supported');
                    disable_enable_remains('video-camera',1);
                    return false;
                }

                if (input.files[0].size >= 100004800) {
                    alert('Uploaded Image size is more the allowed size');
                    disable_enable_remains('video-camera',1);
                    return false;
                }
               // alert('validated');

                var div = '<div class="sel-hob-main" >' +
                        '<span class="video-file sel-copy">&nbsp;</span>' +
                        '<div class="sel-close"></div>' +
                        '</div>';

                $('#preview_postvideo').css({"height": "220px"});
                $('.progress-video').css({"display": "block"});
                $('#preview_postvideo').append(div);

            }
        }

        function audio_upload(input){
            if (input.files && input.files[0]) {
                    var reader = new FileReader();


                    if($supported_Audio_Filetype.indexOf(input.files[0].type) < 0){

                            alert('file format not supported');
                            disable_enable_remains('volume-off',1);
                            return false;
                    }

                    if(input.files[0].size >= 100004800){

                           alert('Uploaded Image size is more the allowed size');
                           disable_enable_remains('volume-off',1);
                           return false;
                    }

                    var div='<div class="sel-hob-main">'+
                        '<span class="audio-file sel-copy">&nbsp;</span>'+
                        '<div class="sel-close"></div>'+
                        '</div>';

                    $('#preview_postaudio').css({"height":"220px"});
                    $('.progress-video').css({"display":"block"});
                    $('#preview_postaudio').append(div);
               }
        }

        function doc_upload(input){
        if (input.files && input.files[0]) {
                var reader = new FileReader();
                console.log(input.files[0].type);

                if($supported_Doc_Filetype.indexOf(input.files[0].type) < 0){

                        alert('file format not supported');
                        disable_enable_remains('file-text',1);
                        return false;
                }

                if(input.files[0].size >= 100004800){

                       alert('Uploaded Image size is more the allowed size');
                       disable_enable_remains('file-text',1);
                       return false;
                }


                var div='<div class="sel-hob-main">'+
                    '<span class="text-file sel-copy">&nbsp;</span>'+
                    '<div class="sel-close"></div>'+
                    '</div>';

                $('#preview_postdoc').css({"height":"220px"});
                $('.progress-video').css({"display":"block"});
                $('#preview_postdoc').append(div);



            }
        }

        function disable_enable_remains(selected,state)
            {
                var num_buttons=$('.post-ulist').children().length;
                for(var button=0;button<num_buttons;button++){
                    thisbutton_li=$('.post-ulist').children().eq(button);
                    this_button=thisbutton_li.children().eq(0);

                    if(this_button.attr('class')!=selected){
                        if(state==0){

                    this_button.css({'display':'none'});

                        }
                        if(state==1){
                    $("."+this_button.attr('class')).css({'display':'block'});
                        }
                    }
                }
            }



        /********************************************** post section end *************************************************/

   new InfinateScrollFun('Posts','post-users','afterLoad').fire();
   new InfinateScrollFun('User_Log','notification-list-row','afterLoad').fire();


			$(".group-search").liveFilter($('#filter_friend'),$('.create_group_popup_friend_list li'));
			$(".profile-mid-section").liveFilter($('#visitor-friend-search'),$('.profile-row-mids .cover-inner-left'));
			$(".profile-mid-section").liveFilter($('#visitor-mentor-search'),$('.profile-row-mids .cover-inner-left'));
			$(".post-options").liveFilter($('#mentor-users-list'),$('.profile-row-mids .cover-inner-left'));
			//$(".filter-contents").liveFilter($('#visitor-video-filter'),$('.user_media_video'));
			//$(".filter-contents").liveFilter($('#visitor-image-filter'),$('.user_media_image'));
			//$(".filter-contents").liveFilter($('#visitor-doc-filter'),$('.user_media_doc'));
			//$(".filter-contents").liveFilter($('#visitor-audio-filter'),$('.user_media_audio'));


        });


            function AfterProcess(data){

            }
/*xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx function call *****************
 *
 *
 */

        function JsVars(data) {

            $data =  $.parseJSON(data);
            user_id = $data.auth;
        }





        function afterLoad(data) {
            //alert('infinate loaded');
        }


        /****************** DoSomething *****************/


    setInterval(doSomething_within, 20000); //check for any new post
    function doSomething_within()
    {
        setTimeout(function() {
        doSomething();
        }, 1000);
    }

    function doSomething() {

        //alert($('#Posts').children().length);

        var post_div_id = get_post_div_ids();
        //alert(post_div_id);
        //alert($('#Posts').children().length);
//        if ($('#Posts').children().length > 0) {
//            $.ajax({
//                type: "POST",
//                url:baseUrl + 'posts/refresh_wall',
//                dataType: "json",
//                data : {postids: post_div_id}
//            })
//                    .done(function(obj) {
////console.clear();
//
//                        for (p = 0; p < obj.length; p++) {
//
//                            var this_post_id = obj[p].Post.id;
//                            var like_count = obj[p].PostUserLike.length ;
//                            var no_comments = obj[p].PostUserComment.length;
//                            var no_likes = obj[p].PostUserLike.length;
//                            class_name = $('#Posts #post-user-'+this_post_id).attr('data-id');
//                            var para_arr = class_name.split("_");
//                            var old_no_comments = para_arr[0];
//                            var old_no_likes = para_arr[1];
//                            if(old_no_likes != no_likes){
//                                $('#Posts #post-user-'+this_post_id).find('.post-likes').html(like_count+' likes');
//                            }
//
//
//
//                        }
//
//
//                         });
//
//
//
//
//
//
//
//        }

        if($('#Posts').length){

            var id = $('#Posts').children().eq(0);
            if ($('#Posts').children().length == 0) {
                var id_num = 0;
            } else {
                var id_num = id.attr('id').substr(10);
            }

            var data = {last_postid: id_num, wall_id: jsVars.wall_id, user_id: jsVars.user_id, wall_type: jsVars.wall_type, vertical_id : jsVars.vertical_id,url : window.location.href };
            console.log(data);
            $.ajax({
                type: "POST",
                url: baseUrl + 'posts/get_latest_posts',
                data: data
            })
            .done(function(msg) {

                $('#Posts').prepend(msg);
                if (msg != '') {
                    var post_div_id = get_post_div_ids();
                    var dom = $.parseHTML(msg);

                    if(!typeof dom[1] == 'undefined'){
                        var post_id = $(dom[1]).attr('id').substr(10);
                        console.log(post_id);
                        if (post_div_id.indexOf(post_id) < 0) {
                            var thisdiv = $('#Posts').prepend(msg).fadeIn("slow");
                            var newpostid = thisdiv.find('.post-users').attr('id').trim();
                            var new_id = newpostid.split('-');
                            $('#post-user-' + new_id[2]).find('.bxslider').bxSlider({infiniteLoop: false, pager: false});
                            if($('#post-user-' + new_id[2]).find('.video-js').length>0){

                            }
                            if($('#post-user-' + new_id[2]).length > 0){
                                var audio_id=$('#post-user-' + new_id[2]).find('.skin-wave').attr('id');
                                dzsap_init("#"+audio_id, {
                                autoplay: "off"
                                //initialize audio player
                            });
                            }

                        }


                    }


                }
            });

            }

        }

    function get_post_div_ids() {
        var post_div_id = new Array();
        for (f = 0; f < $('#Posts').children().length; f++) {
            p_id = $('#Posts').children().eq(f);
            var id = p_id.attr('id').substr(10);
            if (isNaN(id))continue;
            post_div_id.push(id);
        }
        return post_div_id;
    }
    /*********************  end **************************/
    /*********************  comment listioner **************************/

        $('#Posts').on('click','.comment-post', function(){
            var postid = $(this).parents('.post-users').attr('id').substr(10);
            var cmt = $(this).prev().val();
            $(this).prev().val('');
            var String = {post_id: postid,comment :cmt}
			cmt = $.trim(cmt);
			if (!(cmt == null || cmt == "")) {
				post_comment(String);
			}
        });

        $(document).on('click', '.postedby-input', function(e) {

           $(this).keyup(function(e) {
               if (e.keyCode == 13) {

                   var postid = $(this).parents('.post-users').attr('id').substr(10);
                   var cmt = $(this).val();
				   cmt = $.trim(cmt);

                   $(this).blur();
                   var par1 = $(this).parents('.post-users-comments');
                   var par2 = par1.prev();
                   $(this).val('');

                   var String = {post_id: postid,comment :cmt};

                   if (!(cmt == null || cmt == "")) {
                       $(this).val('');
                      post_comment(String);
                   }


               }
           });
       });


        function post_comment(String) {

                var postid = String.post_id;

                   $.ajax({
                       type: "POST",
                       url: baseUrl + 'post_user_comments/add_comment',
                       data: String,
                       cache: false,
                       success: function(result) {
                           console.log(result);
                           data = JSON.parse(result);
                           var imag_src = "/"+app_name+"/"+jsVars.profile_pic;
                           var cmt1 = String.comment.replace(/</g, "&#60;");
                           var cmt2 = cmt1.replace(/>/g, "&#62;");
                           var comt = '<div class="post-users-comments comments" id="post-users-comment-'+data.id+'"  data-id="'+data.id+'" >'+
                                   '<div class="postedby-image">'+
                                   '<img src= '+IMAGE_PROFILE_WALL_COMMENT+data.ProfilePic+' />'+
                                   '</div>'+
                                   '<div class="commnetedby">'+
                                   '<h3><b>'+data.name+'</b></h3>'+
                                   '<p>'+cmt2+'</p>'+
                                   '<div class="like-replay">'+
                                   '<span class="likes" >'+
                                        '<span class="star">&nbsp;&nbsp;&nbsp;</span>'+
                                   '</span>'+
                                   '<span class="replay cmt_like_count">0 likes</span>'+
                                   '<span class="time">just now.</span>'+
                                   '</div>'+
                                   '</div>'+
                                   '</div>';
                           if ($('#post-user-' + postid).find('.post-users-comment-div').children().length == 0) {
                               $('#post-user-' + postid).find('.post-users-comment-div').append(comt);
                           } else {
                               //$('#post-user-' + postid).find('.post-users-comment-div').children().eq(0).before(comt);
							   try {
								   $('#post-user-' + postid).find('.post-users-comment-div').append(comt);
							   }catch (err){
								   alert("errro "+err.message);
							   }
                           }
                           return;

                       }
                   });

        }

       /*
        *
        * post like
        ************************************************/

        $('#Posts').on('click','.post-option-ulist .star', function(){

             var postid = $(this).parents('.post-users').attr('id').substr(10);
             var data ={item_id : postid, item_type : 1};
             new callAjax(data,'post_user_likes/add','AfterLikeAdd').fire();
             $(this).switchClass('star','starplus');


        });

        function AfterLikeAdd(result) {

            data = JSON.parse(result);

            if(!data.success){
                alert('Some thing Went Wrong !!');

                $('#Posts').children('#post-user-'+data.post_id).find('.star').toggleClass('starplus');
            }
            likes = $('#Posts').children('#post-user-'+data.post_id).find('.post-likes').html(data.count+' likes');
			console.log("number of likes is "+data.count);

        }

        $('#Posts').on('click','.post-option-ulist .starplus', function(){

             var postid = $(this).parents('.post-users').attr('id').substr(10);
             var data ={item_id : postid, item_type : 1};
             new callAjax(data,'/post_user_likes/remove','AfterLikeRemove').fire();
             $(this).switchClass('starplus','star');

        });

        function AfterLikeRemove(result) {
            data = JSON.parse(result);
            if(!data.success){
                alert('Some thing Went Wrong !!');

                $('#post-user-'+data.post_id).find('.starplus').toggleClass('star');
            }
            likes = $('#Posts').children('#post-user-'+data.post_id).find('.post-likes').html(data.count+' likes');

        }



        function AfterLike(result)
        {
            Data = JSON.parse(result);
            console.log(Data.count);
            console.log(Data.class);
            console.log(Data.post_id);
            $('#Posts').find('.post-likes').html(Data.count+' Likes');
            $('#Posts').find('.thumbs-up').attr('class',Data.class);
            if(typeof Data.id != 'undefined'){
              $('#Posts').find('.thumbs-up').attr('id',Data.id);
            }

        }

        /**/
        /**/
        /*comment like*************************************************/


        $('#Posts').on('click','.commnetedby .star', function(){

             var postid = $(this).parents('.post-users-comments').attr('data-id');
             var data ={item_id : postid, item_type : 2};
             new callAjax(data,'/post_user_likes/add','AfterComtLikeAdd').fire();
             $(this).switchClass('star','starplus');


        });

        function AfterComtLikeAdd(result) {
            data = JSON.parse(result);

            if(!data.success){
                alert('Some thing Went Wrong !!');

                $('#Posts').find('#post-users-comment-'+data.post_id).find('.starplus').toggleClass('star');
            }
            console.log(data);
            likes = $('#Posts').find('#post-users-comment-'+data.post_id).find('.cmt_like_count').html(data.count+' like');

        }


        $('#Posts').on('click','.commnetedby .starplus', function(){
             var postid = $(this).parents('.post-users-comments').attr('data-id');
             var data ={item_id : postid, item_type : 2};
             new callAjax(data,'/post_user_likes/remove','AfterComtLikeRemove').fire();
             $(this).switchClass('starplus','star');

        });

        function AfterComtLikeRemove(result) {
            data = JSON.parse(result);
            if(!data.success){
                alert('Some thing Went Wrong !!');

                $('#post-user-'+data.post_id).find('.starplus').toggleClass('star');
            }
            likes = $('#Posts').find('#post-users-comment-'+data.post_id).find('.cmt_like_count').html(data.count+' like');

        }


        /************************************* comments like end  ************************************/

		$('#Posts').on('click','.post-users .post-users-comments p.more_cmt', function(){
			$(this).prev().removeClass("achievements-cmt");
			$(this).remove();
			$('.post-users-comments.comments').removeClass("achievements-cmt");

		});

        $('#Posts').on('click','.post-users .post-users-comments span', function(){

           more = $(this).parent('.post-users-comments');
           post = $(this).parents('.post-users');
           postId = post.attr('id');
           post_id = postId.substr(10);
           last_id = $(this).parent('.post-users-comments').attr('data-id');
           var data ={id : last_id, post_id :post_id};
           console.log(last_id);
            $.ajax({
                type: "POST",
                url: baseUrl + 'post_user_comments/get_more_comments',
                data: data,
                cache: false,
                success: function(result) {

                    more.replaceWith(result);
                }
            });

        });





        $(document).on("click",".postEdit-drop a",function(){


            var $post = $(this).closest('div[class="post-users"]');
            var $post_actions = $(this).closest('div[class="post-edit-wrap"]');
            var sel_post_id = $post_actions.attr('id');//got post id
            var data ={post_id : sel_post_id, item_type : 1 };
            if($( this ).text() == 'Delete this post'){

                new callAjax(data,'posts/delete','AfterDeletePost').fire();
                $post.remove();

                //
            }else if($(this ).text() == 'Edit this post'){


				$post.find('.post-users-head .post-user-head-details:eq(1)').css('background','yellow');

                $cmtd = $('#postText'+sel_post_id).children('p[class="post-text"]');

				oldComment = $cmtd.text();

				var height = $cmtd.height();
				$('#postText'+sel_post_id).children('p').replaceWith("<textarea class'post-textarea'>"+oldComment+"</textarea>");

				$cmtd.prop('contenteditable',true);
				$cmtd = $('#postText'+sel_post_id).children('textarea');


				$cmtd.css({'height':'100px','padding-top':'5px','width':'100%'});
				$cmtd.focus();
				$cmtd.after('<p style="cursor:pointer" class="update-text" >save</p>');


				$('#postText'+sel_post_id).on('click','.update-text', function() {
                    new_text = $cmtd.val();
					head =$('#postText'+sel_post_id).children('h2').text();
					$cmtd.replaceWith("<p>"+new_text+"</p>");

                   data.post_title = head;
                   data.post_description = new_text;
                   new callAjax(data,'posts/edit','AfterPostEdit').fire();
					$('#postText'+sel_post_id).children('p[class="update-text"]').remove();
                });
            }else if($(this ).text() == 'dReport this post'){

            }

			$report = data;
            var p_li =$(this).parent();
            var p_ul = p_li.parent();
            var p_div = p_ul.parent();

                $(this).parent(".post-edit-wrap:first").find(".postEdit-drop").toggle();
                ($($('.edit').not(this)).parent().find(".postEdit-drop").hide());

                var scroll = $(document).scrollTop();

                $(document).scrollTop(scroll);
                return false;
        });


    function AfterPostReport(result){
        var data = JSON.parse(result);
        if(data.success){
            Console.log('Post Reported');
        }
    }

	function AfterDeletePost(result){
		var data = JSON.parse(result);
		if(data.success){
			Console.log('Post Reported');
			//alert("error in deleting post");
		}
	}

         //group page edit

$(function() {

        $( "#ambitions_category" ).autocomplete({
        source: jsVars.group_categorys,
        focus: function( event, ui ) {
                    $( "#ambitions_category" ).val( ui.item.label);
                    return false;
                },
                select: function( event, ui ) {
                    var str = $( "#ambitions_category_id" ).val(ui.item.value);
                    loadSubcategories(ui.item.value);
                    return false;
                },
                response: function(event, ui) {

                    console.log(ui.content.length);
                    if (ui.content.length === 0) {
                        $("#add_ambition").css('visibility','visible');
                        $( "#ambitions_category_id" ).val('');

                    }else{
                        $("#add_ambition").css('visibility','hidden');
                    }
                }
        });

        $('#invite-friend-group-submit').click(function(){

            $('#invited').val(invited_friends.toString());
        });

        function loadSubcategories(id)
        {

        var subcate = jsVars.group_subcategorys;
        console.log(subcate);
        var new_sub=new Array();
        var subOption='';
        for(i=0; i < (subcate.length - 1);i++){

            if(subcate[i].refer==id){
                 new_sub.push(subcate[i]);

                 var subOption = subOption+'<option value="'+subcate[i].value+'">'+subcate[i].label+'</option>';

            }

        }

        $( "#ambitions_subcategory" ).autocomplete({
        source: new_sub,
        focus: function( event, ui ) {
                    $( "#ambitions_subcategory" ).val( ui.item.label);
                    return false;
                },
                select: function( event, ui ) {
                     var str = $( "#ambitions_subcategory_id" ).val(ui.item.value);

                    return false;
                },
                response: function(event, ui) {

                    console.log(ui.content.length);
                    if (ui.content.length === 0) {
                        $("#add_subambition").css('visibility','visible');
                        $( "#ambitions_subcategory_id" ).val('');

                    }else{
                        $("#add_subambition").css('visibility','hidden');
                    }

                }
        });

        console.log(new_sub);
        }


        invited_friends=new Array();
        $('.create_group_popup_friend_list').on('click','.invite-friend-group',function(){

            var id = $(this).attr('data-tab');
            var name = $(this).find('.nameDisplay').children('h3').text();

            if(invited_friends.indexOf(id) < 0){
                invited_friends.push(id);
                var tag='<div class="sel-hob-main" data-tab="'+id+'" >'+
                        '<div class="sel-copy">'+name+'</div>'+
                        '<div class="sel-close"></div>'+
                        '</div>';
                $('.invite-peoples').append($(tag));
            }

        });

        //team auto complete
        $( ".select_group_admin" ).autocomplete({
        source: jsVars.GroupAdmin,
        focus: function( event, ui ) {
                    $( this).val( ui.item.label);
                    return false;
                },
                select: function( event, ui ) {

                    var str=$( "#"+$(this).attr('id')+"_id" ).val(ui.item.value);

                    return false;
                },
                response: function(event, ui) {
                    if(ui.content.length == ''){
                        $( "#"+$(this).attr('id')+"_id" ).val('');
                    }
                }
        });


    });

    //searches

        function fetchSeachResults(key,filter){
        //alert(key+filter);

        if(filter==''){ filter='ALL';}
        var data = {key : key, filter : filter};
        var result = new callAjax(data,'searches/main_search','populate_mainsearch').fire();


    }

    function populate_mainsearch(result) {
        var Sresult = JSON.parse(result);
        var msg = '';
        for(i = 0; i < Sresult.length;i++){
            var about = Sresult[i].about;
            if(about != null && about.length > 70){
                about = 'aaaaaaaaaaaa';
            }

            var imag_src = Sresult[i].pic;

            var msg = msg+'<div class="search-row-sugg"><a href="'+Sresult[i].url+'">'+
                        '<div class="sugg-image">'+
                        '<img src= "'+imag_src+'" />'+
                        '</div>'+
                        '<div class="sugg-details">'+
                        '<h2>'+Sresult[i].name+'</h2>'+
                        '<p>'+about+'</p>'+
                        '</div></a>'+
                      '</div>';
        }

            $('.search-main').keydown(function(e) {

            if(e.which==40){
                var $focused = $(':focus');
                if($focused.attr('class') == 'search-input'){
                    console.log($( "#fetch-search-result div:first-child" ));
                    $( "#fetch-search-result div:first-child" ).css("background-color" , "#ffffcc");
                }
               // alert($focused.attr('class'));
            }
            });

        $('#fetch-search-result').html(msg);
    }

    $('.search-main').on('click','.search-button',function(){

        fetchSeachResults($('.search-input').val(),$('.search-input-filter').val());
        $(".search-suggestion").show();
    });


    var MessageBox = function(caption,eventType,newMessageHandler) {
			this.caption = caption;
			this.eventType = eventType;

			$(document).unbind(eventType);
			$(document).on(eventType, newMessageHandler);


			this.yesOrNo = function() {
					var dialog = $('<p style="font-size:15px;" title = "Confirm?">'+this.caption+'</p>').dialog({
							buttons: {
								"Yes": function() {
								   triggerEvent(eventType,"Yes",$(this));
								},
								"No":  function() {
									triggerEvent(eventType,"No",$(this));
								}
							},
						dialogClass: "fixed-dialog"

					});
				};

			this.yesOrNoCancel = function() {
				var dialog = $('<p style="font-size:15px;" title = "Confirm?" >'+this.caption+'</p>').dialog({
						buttons: {
							"Yes": function() {
							   triggerEvent(eventType,"Yes",$(this));
							},
							"No":  function() {
								triggerEvent(eventType,"No",$(this));
							},
							"Cancel":  function() {
                                triggerEvent(eventType,"Cancel",$(this));
                        	}
						}
				});
			};

			this.okayCancel = function() {
				var dialog = $('<p style="font-size:15px;" title = "Confirm">'+this.caption+'</p>').dialog({
						buttons: {
							"Ok": function() {
							  triggerEvent(eventType,"Ok",$(this));
							},
							"Cancel":  function() {
								triggerEvent(eventType,"Cancel",$(this));
							}
						}
				});
			};

			this.error = function() {
				var dialog = $('<p style="color:red;font-size:15px;" title = "Error!!">'+this.caption+'</p>').dialog({
						buttons: {
							"Ok": function() {
							  triggerEvent(eventType,"Ok",$(this));
							}
						}
				});
			};

			this.info = function() {
				var dialog = $('<p style="font-size:15px;" title = "Info!!">'+this.caption+'</p>').dialog({
						buttons: {
							"Ok": function() {
							  triggerEvent(eventType,"Ok",$(this));
							}
						}
				});
			};

			function triggerEvent(eventType,result,dialogRef) {
			  dialogRef.dialog( "close" );
			  $.event.trigger({
				type: eventType,
				message: result,
				time: new Date()
			 });
			}
    };


    function yesNoHandler(e) {

        if(e.message=='Yes'){

        window.location.href=baseUrl+'users/logout';
    }

    }


var formData ={};
var call_note = 0;
    $(".notification ").on("click", function() {

        call_note = call_note ^ 1;
        if(call_note== 1){

        $('#user-notification-div').html('<img style="margin-right:auto;margin-left:auto;" src="/wizspeak/img/ajax-loader.gif" />');;
                $.ajax({
                    url: baseUrl + 'users/notifications',
                    type: 'POST',
                    data: formData,
                    cache: false,
                    contentType: false,
                    processData: false,

                    success: function(result) {
                        console.log(result);
                        $('#user-notification-div').html(result);
                    },
                    error: function (error ,ui){
                      //  alert(error);
                        console.log(error);
                    }

                });

        }
        $(".notification-main").toggleClass("ser-active");
        $(".notification-drop").toggle();
    });


    $('.friend').click( function(){

       var ref_id = $(this).attr('data-id');
       var status_id = $(this).attr('data');
       if(ref_id > 0){
        //
        var data = {user_id_a : jsVars.user_id , user_id_b : jsVars.wall_id, request_status :status_id, id :ref_id};

       }else{
        var data = {user_id_a : jsVars.user_id , user_id_b : jsVars.wall_id, request_status :status_id};
       }

       new callAjax(data,'user_friends/edit_friend','AfterFriendButton').fire();
    });

    function AfterFriendButton(data){

		console.log(data);
		json_data = JSON.parse(data);
		console.log(json_data.word);
		$('.friend').attr('data-id',json_data.data_id);
		$('.friend').attr('data',json_data.id);
		$('.friend').attr('value',json_data.word);
		$('.friend').each(function( index ) {
			if($( this).attr("id") == ""){
$(this).remove();
			}
		});
    }

    $('.remove-invitee').click( function(){
       var id = $(this).attr('data-id');
       $(this).parents('li').remove();
       var data = {id : id};
       console.log(data);
       new callAjax(data,'/user_group_relations/remove','AfterInviteeRemove').fire();

    });

    function AfterInviteeRemove(result){

        console.log(result);
    }

    $('#connectedGroup_list').on('click','.pencil', function(){

        $('#connectedGroup_list-replace').css({'display' :'block' });
    });
        var sel_group = new Array();
/*
                $('#add_more_groups').autocomplete({
                    source: function (request, response) {
                        $.ajax({
                            url: baseUrl + 'groups/searchGroup',
                            data: { searchText: request.term, groupId: jsVars.wall_id },
                            dataType: "json",
                            type: 'POST',
                            success: function (data) {

                                response($.map(data, function (item) {
                                    return {
                                        value: item.DisplayName,
                                        avatar: item.PicLocation,
                                        rep: item.Reputation,
                                        selectedId: item.UserUniqueid
                                    };
                                }))
                            }
                        })
                    },
                    select: function (event, ui) {

                        if(sel_group.indexOf(ui.item.selectedId) < 0){
                            var template = "<div class='sel-hob-main' id='"+ui.item.selectedId+"' ><div class='sel-copy' ><img style='width:30px' src='" + ui.item.avatar + "'>"+ui.item.label+"</div><div class='sel-close' ></div></div>";
                            $('#connectedGroup_list-new').append(template);
                            sel_group.push(ui.item.selectedId);
                            $('#add_more_groups').val('');

                        }

                        return false;
                    },
                    create: function() {
                        $(this).data("ui-autocomplete")._renderItem = function (ul, item) {

                   // var inner_html = '<a><div class="list_item_container"><div class="image"><img src="' + item.avatar + '"></div><div class="label"><h3> Reputation:  ' + item.rep + '</h3></div><div class="description">' + item.label + '</div></div></a><hr/>';

                    var inner_html = '<a><div class="list_item_container"><div class="search-row-sugg" ><div class="sugg-image" ><img src="' + item.avatar + '"></div><div class="sugg-details" ><h3> ' + item.value + ' </h3></div></div></div></a>';
                    return $("<li></li>")
                            .data("item.autocomplete", item)
                            .append(inner_html)
                            .appendTo(ul);
                            }
                    }
                });

*/

    $(".connected-group-listsel").on('click','.sel-close', function(){

        div_id = $(this).parent('.sel-hob-main').attr('id');
        $(this).parent('.sel-hob-main').remove();
        index = sel_group.indexOf(div_id);
       // alert(index);
        if (index > -1) {
            sel_group.splice(index, 1);
        }
    });

    $('#add_more_groups-button').click(function(){

        for(j=0;j<sel_group.length;j++ ){
                var data = {group_id_to:sel_group[j] , group_id_from:jsVars.wall_id, request_status: 'R'};
                var result = new callAjax(data,'/group_group_connects/add_group','afterGroupConnect').fire();

        }
    });


    function afterGroupConnect(result) {
        data = JSON.parse(result);
        if(data.success){
            $('#connectedGroup_list-new').each( function(index){
                console.log( index + ": " + $( this ).attr('id') ) ;

                div = $(this).children('.sel-hob-main');
               // alert(div.attr('id')+' == '+data.id);
                if(div.attr('id') == data.id){
                    $(this).children('.sel-hob-main').remove();
                }
                $('#connectedGroup_list-replace').css({'display' :'none' });
            });
        }
    }

    $('#add_connect_group_divclose').click( function() {

         $('#connectedGroup_list-replace').css({'display' :'none' });
    });



    //mentor follow button

    $('.cover-pic-disc-award').on('click', '.follow', function(){

            var data = {mentor_id :jsVars.wall_id ,user_id :jsVars.user_id}
		console.log(data);
            new callAjax(data,'user_mentor_followers/add','AfterFollow').fire();
            $(this).val('UN-FOLLOW');
            $(this).switchClass('follow','un-follow');
    });

    function AfterFollow(result) {
        var data = JSON.parse(result);
        if(data.success!=1){
          alert('Sorry Some think went Wrong!!');
            $(this).val('FOLLOW');
            $(this).switchClass('follow','follow');
        }

    }

    $('.cover-pic-disc-award').on('click', '.un-follow', function(){

       var data = {mentor_id :jsVars.wall_id ,user_id :jsVars.user_id, status : 2}
       new callAjax(data,'user_mentor_followers/remove','AfterUnFollow').fire();
       $(this).val('FOLLOW');
       $(this).switchClass('un-follow','follow');
    });

    function AfterUnFollow(result) {
        var data = JSON.parse(result);
        if(!data.success){

            $(this).val('UN-FOLLOW');
            $(this).switchClass('follow','un-follow');
        }

    }


    $('.ulist-header').on('click','.more-notification',function(){
        window.location.href = baseUrl+'users/all_notifications';
    });

    $('.rating span').click( function(){

        console.log(this);
        id = $(this).attr('data-id');
        console.log(id);

        var data ={user_id : jsVars.user_id,mentor_id : jsVars.wall_id, rating : id };
        console.log(data);
        new callAjax(data,'/user_mentor_ratings/rate','AfterRate').fire();

    });

    function AfterRate(result) {
        console.log(result);
        data = JSON.parse(result);
        if(data.success){

            mystar = '';
            for(star = 0;star <data.rate;star++){
                mystar = mystar+'<span>&#x2605;</span>';
            }
            $('#my_rate').html(mystar);
        }

    }



function profilePage(){
	window.location.href=baseUrl+'profiles';
}


$('#group-user-status').click( function(){


	if($(this).val() == 'Leave Group'){
		var data ={item_id : jsVars.wall_id, status : 2};
		status = "Join Group";
		sdata = 4;
	}else if($(this).val() =='Join Group'){
		status = "Cancel Join Request";
		sdata = 0;
		var data ={item_id : jsVars.wall_id, status : 4};
	}else if($(this).val() =='Cancel Join Request'){
		status = "Join Group";
		sdata = 4;
        var data ={item_id : jsVars.wall_id, status : 0};
    }else if($(this).val() =='Accept Join Request'){
		status = "Leave Group";
		sdata = 2;
        var data ={item_id : jsVars.wall_id, status : 1};
    }

	$(this).val(status);
	$(this).attr("data-id",sdata);



	new callAjax(data,'user_group_relations/update','AfterGroupAdd').fire();
});


///////////////////////////////////////////////////////////////////////////////////////////////////
//report post

$(function() {
	$('.checked').click(function(e) {
		e.preventDefault();
		var dialog = $('<p>Are you sure?</p>').dialog({
			buttons: {
				"Yes": function() {
					alert('you chose yes');
				},
				"No": function() {
					alert('you chose no');
				},
				"Cancel": function() {
					alert('you chose cancel');
					dialog.dialog('close');
				}
			},
			moveToTop: true
		});
	});
});

////////////////////////////////////////////////////////////////////////////////////////////////////




//add group selction

$(document).ready( function() {


     //
	 // $(".search-cate-group").on("input", function () {
     //
	 // if ($(this).val().length == 0) {
	 // $(".search-cate-suggestion").hide();
	 // } else {
     //
	 // fetchCategories($(this).val(), $(this).next().val());
	 // $(".search-cate-suggestion").show();
     //
	 // }
     //
	 // });
     //
     //
     //
	 // function fetchCategories(key,filter){
	 // //alert(key+filter);
     //
	 // var data = {key : key, filter : filter};
     //
	 // var result = new callAjax(data,'searches/category','populate_simple_serach').fire();
     //
     //
	 // }
     //
	 // $('.search-cate-suggestion').on('click','.amb-cate-sel', function(){
     //
	 // subCatId = $(this).attr("data-id");
	 // subCatName = $(this).find( "h2:first" ).text();
     //
	 // $(".search-cate-group").val(subCatName);
	 // $("#ambitions_subcategory_id").val(subCatId);
	 // $('.search-cate').val("");
	 // $(".search-cate-suggestion").hide();
     //
	 // });
     //
	 // $('.search-cate-suggestion').on('click','.add-new-amb h2 a', function(){
     //
	 // subCatName = $(".search-cate-group").val();
	 // catType = $(".search-cate-group").next().val();
     //
	 // subCatId = 0; //user defined sub cate
	 // subCatName = $.trim(subCatName);
	 // if(subCatName!=""){
	 // var data ={name : subCatName, type : catType};
	 // new callAjax(data,'/sub_categories/addUserDefined','afterAddSubCategory').fire();
     //
	 // }else{
	 // alert("Enter your ambition");
	 // $(".search-cate").focus();
	 // }
	 // //call ajax for add new sub_category
     //
     //re
     //
});



	 $("#reportThisPost").click( function(){




		 item_id =
		 item_type = 1;
		 if($('#rep2').is(':checked')) {
			 item_type =2;
		 }else if($('#rep3').is(':checked')){
			 item_type =3;
		 }else if($('#rep4').is(':checked')){
			 item_type =4;
		 }
		 $report.item_type = item_type;
		 $(this).next().click();
		 new callAjax($report,'user_report_abuses/report','AfterPostReport').fire();

	 });





	 function populate_simple_serach(result) {

	 var Sresult = JSON.parse(result);
	 var msg = '';
	 if(Sresult.length>0){

	 for(i = 0; i < Sresult.length;i++){
	 var about = Sresult[i].about;
	 if(about != null && about.length > 70){
	 about = 'aaaaaaaaaaaa';
	 }

	 $(".add-new-amb .sugg-details").html('<h2>Search your ambition</h2>');
	 var msg = msg+'<div class="search-row-sugg" >'+
	 '<div class="sugg-details amb-cate-sel" data-id="'+Sresult[i]['SubCategory'].id+'" >'+
	 '<h2>'+Sresult[i]['SubCategory'].name+'</h2>'+
	 '</div>'+
	 '</div>';
	 type = Sresult[i]['Category'].vertical_id;
	 }
	 //ambition
	 $('.search-cate-suggestion #fetch-search-result').html(msg);


	 }else{
	 var msg ="";
	 $('.search-cate-suggestion #fetch-search-result').html(msg);
	 $(".add-new-amb .sugg-details").html('<h2>not found ,...... <strong><a>Click to add</a></strong></h2>');
	 }




	 }

	 function afterAddSubCategory(result){
	 var Sresult = JSON.parse(result);

	 if(Sresult.name != "" && Sresult.id != null){
	 $(".search-cate-group").val(Sresult.name);
	 $("#ambitions_subcategory_id").val(Sresult.id);
	 }

	 $('.search-cate').val("");
	 $(".search-cate-suggestion").hide();

	 }






//google

(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
})(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

ga('create', 'UA-78767965-1', 'auto');
ga('send', 'pageview');

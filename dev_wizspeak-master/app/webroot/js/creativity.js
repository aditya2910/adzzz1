 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

  // **********crea image************//
   $(document).ready(function(){

        $('#creativity_share').click(function(){



                var creativity_formData = new FormData($('#creativity_form')[0]);
                //console.log(creativity_formData);

                $.ajax({
                    url: baseUrl + "posts/add_creativity_ajax",
                    type: 'POST',
                    data: creativity_formData,
                    cache: false,
                    contentType: false,
                    processData: false,

                    success: function(response) {

                        $('#creativity_form')[0].reset();
                        $('#preview_cre_image').html('');
                        $(".creativitytags").html('');
                        $(".camera_creative").click();

                    }

                });

		});







    /****************************************************************/
      var form_status = 0;
    $('.camera_creative').click(function(){
       if(form_status==0){
          add_image_meta();
           form_status = 1;
       }else{

           remove_image_meta();
           form_status = 0;
		   $('#creativity_form')[0].reset();
       }
    });



    function add_image_meta(){
        $('#button_selected').val('2');
        $('.creativity-upload-head').text('Upload Image');
         $new=$('.meta-form');
         $('#preview_postimage').append($new);
         $new.show(800);
    }

    function remove_image_meta(){

         $new=$('.meta-form');
         $('#preview_postimage').append($new);
         $new.hide(800);

    }
    /****************************************************************/

    $('.audio_creativity').click(function(){
         if(form_status==0){
           add_audio_meta();
           form_status = 1;
       }else{

           remove_audio_meta();
           form_status = 0;

       }


    });
     function add_audio_meta(){
        $('#button_selected').val('5');
        $('.creativity-upload-head').text('Upload Audio');
         $new=$('.meta-form');
         $('#preview_postimage').append($new);
         $new.show(800);

    }

    function remove_audio_meta(){
         $new=$('.meta-form');
        $('#preview_postimage').append($new);
         $new.hide(800);

        // display_audio(this);
    }
    /****************************************************************/

      $('.video-camera_creative').click(function(){
       if(form_status==0){
           add_video_meta();
           form_status = 1;
       }else{

           remove_video_meta();

           form_status = 0;
		   $('#creativity_form')[0].reset();
       }
    });



    function add_video_meta(){
        $('#button_selected').val('3');
        $('.creativity-upload-head').text('Upload Video');
         $new=$('.meta-form');
         $('#preview_postimage').append($new);
         $new.show(800);
         $
    }

    function remove_video_meta(){
         $new=$('.meta-form');
         $('#preview_postimage').append($new);
         $new.hide(800);
        // display_video(this);
    }

     /****************************************************************/


        $('.doc_creativity').click(function(){
        if(form_status==0){
           add_doc_meta();
           form_status = 1;
       }else{
           remove_doc_meta();
           form_status = 0;
       }
    });
     function add_doc_meta(){
        $('#button_selected').val('4');
        $('.creativity-upload-head').text('Upload Document');
         $new=$('.meta-form');
        // $('#preview_postimage').append($new);
         $new.show(800);

    }

    function remove_doc_meta(){
         $new=$('.meta-form');
       //  $('#preview_postimage').append($new);
         $new.hide(800);
         //display_doc(this);
    }

     /****************************************************************/

    $('#file').change(function(){
		//alert('hiiiiiiiiiiiiiiii'+ $('#button_selected').val());
                if($('#button_selected').val()=='2'){

                        creativity_image(this);
                }else if($('#button_selected').val()=='3'){
                        creativity_video(this);
                }else if($('#button_selected').val()=='4'){
                        creativity_audio(this);
                }else if($('#button_selected').val()=='5'){
                        creativity_doc(this);
                }
    });

    function creativity_image(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            /*validate input file javascript*/

            $supported_filetype = ['image/png', 'image/PNG', 'image/jpeg', 'image/JPEG', 'image/jpg', 'image/JPG', 'image/gif', 'image/JIF', 'image/bmp', 'image/BMP'];

            if ($supported_filetype.indexOf(input.files[0].type) < 0) {
                alert('file format not supported ');
				$('#creativity_form')[0].reset();
                return false;
            }
            if (input.files[0].size >= 1024 * 1024 * 4) {
                alert('Uploaded Image size is more the allowed size');
                return false;
            }

            //reader.onload = function(e) {
            //    var div = $('<span class="sel-image" >');
            //    var img = $('<img >');
            //    img.attr('src', e.target.result);
            //    img.css('width', '100px');
            //    img.css('height', '100px');
            //    img.css('margin', '4px');
            //    img.appendTo(div);
            //    $('#preview_cre_image').html(div);
            //    // $('#preview_postimage').append('<img src="'+e.target.result+'" width="90px" >');
            //}
            reader.readAsDataURL(input.files[0]);
        }
    }


//*****************************************video***************************//



    function creativity_video(input)
        {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                /*validate video file javascript*/

                $supported_filetype = ['video/mp4', 'video/MP4', 'video/x-flv', 'video/FLV', 'video/avi', 'video/AVI', 'video/mov',
                    'video/MOV', 'video/mpeg', 'video/MPEG', 'video/MPG', 'video/x-ms-asf', 'video/mpg', 'video/x-ms-wmv',
                    'video/X-MS-WMV', 'video/3gpp','video/MKV', 'video/3GPP', 'video/wpl', 'video/WPL', 'video/quicktime', 'video/QUICKTIME', 'video/WPL', 'video/x-matroska'];
 //console.log(input.files[0]);
                if ($supported_filetype.indexOf(input.files[0].type) < 0) {
                    alert('Sorry, your file format not supported try again!!');
					$('#creativity_form')[0].reset();
                    return false;
                }

                if (input.files[0].size >= 1024 * 1024 * 500) {
                    alert('Uploaded Video size is more the allowed size (Max. 500MB');
					$('#creativity_form')[0].reset();
                    return false;
                }
                  var div = '<div class="sel-hob-main">' +
                        '<span class="video-file sel-copy">&nbsp;</span>' +
                        '<div class="sel-close"></div>' +
                        '</div>';


                $('#preview_cre_image').html(div);

            }

        }

         //*****************************************audio start***************************//



    function creativity_audio(input){
        if (input.files && input.files[0]) {
                var reader = new FileReader();
                alert('HI'+input.files[0].type);
                $supported_filetype=['audio/aiff','audio/AIFF','audio/au','audio/AU','audio/mid','audio/MID','audio/midi','audio/midi',
                'audio/mp3','audio/MP3','audio/WAV','audio/wav','audio/wma','audio/WMA','audio/mpeg','audio/MPEG'];

                if($supported_filetype.indexOf(input.files[0].type) < 0){

                        alert('file format not supported');
					$('#creativity_form')[0].reset();
                        return false;
                }

                if(input.files[0].size >= 1024 * 1024 * 20){

                       alert('Uploaded Audio size is more the allowed size (Max 20mb)');
					$('#creativity_form')[0].reset();
                       return false;
                }

                var div='<div class="sel-hob-main">'+
                    '<span class="audio-file sel-copy">&nbsp;</span>'+
                    '<div class="sel-close"></div>'+
                    '</div>';


                 $('#preview_cre_image').html(div);
           }
    }
        //*****************************************audio end***************************//
        //*****************************************Doc Start***************************//



        function creativity_doc(input){
          if (input.files && input.files[0]) {
                  var reader = new FileReader();
                   alert('HI doc'+input.files[0].type);
                $supported_filetype=['application/pdf','text/plain','application/vnd.openxmlformats-officedocument.wordprocessingml.document',
                'application/vnd.ms-powerpoint','application/vnd.ms-excel','application/msword'];


                if($supported_filetype.indexOf(input.files[0].type) < 0){

                        alert('file format not supported');
					$('#creativity_form')[0].reset();
                        return false;
                }

                if(input.files[0].size >= 1024 * 1024 * 25){

                       alert('Uploaded Doc size is more the allowed size MAx 25MB');
					$('#creativity_form')[0].reset();
                       return false;
                }


                var div='<div class="sel-hob-main">'+
                    '<span class="text-file sel-copy">&nbsp;</span>'+
                    '<div class="sel-close"></div>'+
                    '</div>';

                $('#preview_cre_image').html(div);



            }
        }

        //*****************************************Doc End***************************//

$('.arrowchat_powered_by').html('');
/*-----------------------------------------gopu-----------------------------------------------------*/

                  function fetchSeachResults(key,filter){
        //alert(key+filter);

        if(filter==''){ filter='ALL';}
        var data = {key : key, filter : filter};
        var result = new callAjax(data,'searches/cre_search/','populate_mainsearch').fire();


    }

    function populate_mainsearch(result) {
        var Sresult = JSON.parse(result);
        var msg = '';
        for(i = 0; i < Sresult.length;i++){
            var about = Sresult[i].about;
            if(about != null && about.length > 70){
                about = 'aaaaaaaaaaaa';
            }

            var msg = msg+'<div class="search-row-sugg"><a href="'+Sresult[i].url+'">'+
                        '<div class="sugg-image">'+
                        '<img src="/wizspeakv254/'+Sresult[i].pic+'" />'+
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
                alert($focused.attr('class'));
            }
            });

        $('#fetch-search-result').html(msg);
    }

    $('.search-main').on('click','.search-button',function(){

        fetchSeachResults($('.search-input').val(),$('.search-input-filter').val());
        $(".search-suggestion").show();
    });

$(function() {

        $( "#ambitions_category" ).autocomplete({

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
                     var str=$( "#ambitions_subcategory_id" ).val(ui.item.value);

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

//   ************************* tag********************

$(function() {
$( "#tags" ).autocomplete({
source: jsVars.creativitytag,
focus: function( event, ui ) {
            $( "#tags" ).val( ui.item.label);
            return false;
        },
        select: function( event, ui ) {
             var str=$( "#tags_id" ).val();
             var selected_id=str.split("-");

             if(selected_id.indexOf(ui.item.value)<0)
             {
            $( "#tags_id" ).val( $( "#tags_id" ).val()+ui.item.value+'-');

            var template = "<div class='sel-hob-main' id='"+ui.item.value+"' ><div class='sel-copy' >"+ui.item.label+"</div><div class='sel-close' ></div></div>";
            $(".creativitytags").append(template);
             }
            $( "#tags" ).val('');
            return false;
        },
        response: function(event, ui) {

            //console.log(ui.content.length);
            if (ui.content.length === 0) {
                $("#add_button_creativity").css('visibility','visible');

            }else{
                $("#add_button_creativity").css('visibility','hidden');
            }
        }
});


$("#add_button_creativity").click(function(){

//   if ($(this).val()==''){alert('null value');
//       return false;
//   }
    var new_tags = $( "#tags" ).val();
   $( "#tags" ).val('');
  //call ajax to add to db
   var dataString = 'tags='+ new_tags;

  	$.ajax({
	type: "POST",
	url: baseUrl + "posts/add_tag",
	data: dataString,
	cache: false,
	success: function(html)
	{
	alert(html);
        $("#add_tags").css('visibility','hidden');
        $( "#tags_id" ).val( $( "#tags_id" ).val()+html+'-');

        var template = "<div class='sel-hob-main' id='"+html+"' ><div class='sel-copy' >"+new_tags+"</div><div class='sel-close' ></div></div>";
        $(".creativitytags").append(template);
	}
	});


});

    $(".creativitytags").on("click" , '.sel-close' , function(){
        $(this).parents(".sel-hob-main:first").remove();
        var div_id =$(this).parents(".sel-hob-main").attr('id');
        //console.log(div_id);
        var str=$( "#tags_id" ).val();
        var selected_id=str.split("-");
        y = jQuery.grep(selected_id, function(value) {
        return value != div_id;
        });
        var ids=y.join("-")+'-';
        $( "#tags_id" ).val(ids);
    });

});
   //searches

        function fetchSeachResults(key,filter){
        //alert(key+filter);

        if(filter==''){ filter='ALL';}
        var data = {key : key, filter : filter};
        var result = new callAjax(data,'searches/cre_search/','populate_mainsearch').fire();


    }

    function populate_mainsearch(result) {
        var Sresult = JSON.parse(result);
        var msg = '';
        for(i = 0; i < Sresult.length;i++){
            var about = Sresult[i].about;
            if(about != null && about.length > 70){
                about = 'aaaaaaaaaaaa';
            }

            var msg = msg+'<div class="search-row-sugg"><a href="'+Sresult[i].url+'">'+
                        '<div class="sugg-image">'+
                        '<img src="/wizspeakv254/'+Sresult[i].pic+'" />'+
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
                alert($focused.attr('class'));
            }
            });

        $('#fetch-search-result').html(msg);
    }

    $('.search-main').on('click','.search-button',function(){

        fetchSeachResults($('.search-input').val(),$('.search-input-filter').val());
        $(".search-suggestion").show();
    });

});



 $('#share').click(function(){

	 //check for file upload
	 var img_uploaded_length = $('#preview_postimage').children().length;
	 var doc_uploaded_length = $('#preview_postdoc').children().length;
	 var video_uploaded_length = $('#preview_postvideo').children('.sel-hob-main').length;
	 var audio_uploaded_length = $('#preview_postaudio').children('.sel-hob-main').length;
	 var text_comment = $('#post_box').val();

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
			 save_post_text('',1,1);

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

		 var formData = new FormData($('#post_box_videoIndexForm')[0]);

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

		 var data = {"postby_id": jsVars.user_id ,"postto_id" :jsVars.wall_id  ,"wall_type": jsVars.wall_type, "vertical_id" : jsVars.vertical_id ,"is_private": 0,"post_type_id": post_type,"title" : ""+text_comment+""  ,"status" : p_status,"link" : String(link) };

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
					 if(p_status > 0 ){
						 append_post(response.post_id);
					 }else{
						 //process
						 console.log("sucess xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						 var data ={post_id : response.post_id, post_type : post_type};
						 new callAjax(data,'/posts/process','AfterProcess').fire();
					 }

				 }

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
					 save_post_text(UPinfo.link,5,0);
				 }
			 }

		 });
	 }





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
			 var comt = '<div class="post-users-comments" id="post-users-comment-'+data.id+'"  data-id="'+data.id+'" >'+
				 '<div class="postedby-image">'+
				 '<img src= "/'+app_name+'/user/profile_photo/user_pic/'+data.ProfilePic+'_sml.jpeg" />'+
				 '</div>'+
				 '<div class="commnetedby">'+
				 '<h3><b>'+data.name+'</b></h3>'+
				 '<p>'+cmt2+'</p>'+
				 '<span class="star">&nbsp;&nbsp;&nbsp;</span>'+
				 '<span class="cmt_like_count">0 like</span>'+
				 '</div>'+
				 '</div>';
			 if ($('#post-user-' + postid).find('.post-users-comment-div').children().length == 0) {
				 $('#post-user-' + postid).find('.post-users-comment-div').append(comt);
			 } else {
				 $('#post-user-' + postid).find('.post-users-comment-div').children().eq(0).before(comt);
			 }
			 return;

		 }
	 });

 }

 /*********************  comment add cre **************************/




 $('#submit').click(function(){


	 var creativity_message= new FormData($('#creativity_comment')[0]);

	 $.ajax({
		 url: baseUrl + 'post_user_comments/add_comment',
		 type: 'POST',
		 data: creativity_message,
		 cache: false,
		 contentType: false,
		 processData: false,

		 success: function (result) {
			 data = JSON.parse(result);
			 var imag_src = "/" + app_name + "/" + jsVars.profile_pic;
			 var comt=	 '<li>'+
				 '<div class="notif-image">' +
				 '<img src= "/' + app_name + '/user/profile_photo/user_pic/' + data.ProfilePic + '_sml.jpeg" />' +
				 '</div>' +
				 '<div class="notif-copy">' +
				 '<h3><b>' + data.name + '</b></h3>' +
				 ' <p> '+ $('#comment').val()+' </p>'+

			 '<span>just now</span>'+
			 '</div>'+
			 '</li>';
			 $('.row-mid-notification').find('ul').prepend(comt);

			 return;

		 }

	 });


 });




 $(function() {
	 $( "#tags" ).autocomplete({
		 source: jsVars.creativitytag,
		 focus: function( event, ui ) {
			 $( "#tags" ).val( ui.item.label);
			 return false;
		 },
		 select: function( event, ui ) {
			 var str=$( "#tags_id" ).val();
			 var selected_id=str.split("-");

			 if(selected_id.indexOf(ui.item.value)<0)
			 {
				 $( "#tags_id" ).val( $( "#tags_id" ).val()+ui.item.value+'-');

				 var template = "<div class='sel-hob-main' id='"+ui.item.value+"' ><div class='sel-copy' >"+ui.item.label+"</div><div class='sel-close' ></div></div>";
				 $(".creativitytags").append(template);
			 }
			 $( "#tags" ).val('');
			 return false;
		 },
		 response: function(event, ui) {

			 //console.log(ui.content.length);
			 if (ui.content.length === 0) {
				 $("#add_button_creativity").css('visibility','visible');

			 }else{
				 $("#add_button_creativity").css('visibility','hidden');
			 }
		 }
	 });


	 $("#add_button_creativity").click(function(){

//   if ($(this).val()==''){alert('null value');
//       return false;
//   }
		 var new_tags = $( "#tags" ).val();
		 $( "#tags" ).val('');
		 //call ajax to add to db
		 var dataString = 'tags='+ new_tags;

		 $.ajax({
			 type: "POST",
			 url: baseUrl + "posts/add_tag",
			 data: dataString,
			 cache: false,
			 success: function(html)
			 {
				 alert(html);
				 $("#add_tags").css('visibility','hidden');
				 $( "#tags_id" ).val( $( "#tags_id" ).val()+html+'-');

				 var template = "<div class='sel-hob-main' id='"+html+"' ><div class='sel-copy' >"+new_tags+"</div><div class='sel-close' ></div></div>";
				 $(".creativitytags").append(template);
			 }
		 });


	 });

	 $(".creativitytags").on("click" , '.sel-close' , function(){
		 $(this).parents(".sel-hob-main:first").remove();
		 var div_id =$(this).parents(".sel-hob-main").attr('id');
		 //console.log(div_id);
		 var str=$( "#tags_id" ).val();
		 var selected_id=str.split("-");
		 y = jQuery.grep(selected_id, function(value) {
			 return value != div_id;
		 });
		 var ids=y.join("-")+'-';
		 $( "#tags_id" ).val(ids);
	 });

 });

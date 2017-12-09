$(document).ready(function() {

    var cropObj, intializeCrop, intializeProfileCrop, cropProfileObj;


    function intializeCrop() {

        cropObj = new CROP();
		profileurl= $(".upload-profilePicinner").find('img').attr('src');
		//alert(profileurl);


        cropObj.init({

            // element to load the cropper into
            container: '.default-container',

            // image to load, accepts base64 string
            image: profileurl,

            // aspect ratio
            width: 300,
            height: 300,

            // prevent image from leaking outside of container. boolean
            mask: false,

            // input[range] attributes
            zoom: {

                // slider step change
                steps: 0.01,

                // minimum and maximum zoom
                min: 1,
                max: 5

            },

            // optional preview. remove this array if you wish to hide it
            preview: {

                // element to load the preview into
                container: '.pre',

                // aspect ratio
                ratio: 0.75,

            },
        });

        $('#profile-image-crope .min-img').on("click", function() {
            cropObj.zoom('min');
        });

        $('#profile-image-crope .browse-img').on("click", function() {
            cropObj.import();
        });

        $('#profile-image-crope .max-img').on("click", function() {
            cropObj.zoom('max');
        });

        $('#profile-image-crope .rotate-img').on("click", function() {
            cropObj.rotate();
        });

        $('#profile-image-crope .flip-img').on("click", function() {
            cropObj.flip();
        });


        $('#profile-image-crope .download-img').on("click", function() {
            cropObj.download(400, 400, 'filename', 'jpeg', $(this).attr('id'));
        });


        $('#profile-image-crope .base64-img').on("click", function() {
          //  alert(cropObj.data(300, 300, 'jpeg').image)

			image_src = cropObj.data(300, 300, 'jpeg').image;

			var imgsrc = new Array();
			imgsrc.push(image_src);

			var data = {imgsrc : imgsrc};
			$.ajax({
				type: "POST",
				url: baseUrl + 'posts/add_profile_pic',
				data: data,

				dataType: "JSON"

			});

			$img = image_src;
			$( ".cover-profile-Pic" ).html("<img src="+$img+" />")
			$( ".upload-profilePicinner" ).html("<img src="+$img+" />")




        });

    }

    function intializeProfileCrop() {

		$("div.cover-image").hide();
        $(".crop-profile-main").addClass("active-crop");

        cropProfileObj = new CROP();
imageurl= $(".cover-image").find('img').attr('src');





        cropProfileObj.init({

            // element to load the cropper into
            container: '.default-container2',

            // image to load, accepts base64 string
            image: imageurl ,


            // aspect ratio
            width: 960,
            height: 380,

            // prevent image from leaking outside of container. boolean
            mask: false,

            // input[range] attributes
            zoom: {

                // slider step change
                steps: 0.01,

                // minimum and maximum zoom
                min: 1,
                max: 5

            },

            // optional preview. remove this array if you wish to hide it
            preview: {

                // element to load the preview into
                container: '.pre2',

                // aspect ratio
                ratio: 0.75,

            },
        });

        $('.crop-profile-main .min-img').on("click", function() {
            cropProfileObj.zoom('min');
        });

        $('.crop-profile-main .browse-img').on("click", function() {
            cropProfileObj.import();
        });

        $('.crop-profile-main .max-img').on("click", function() {
            cropProfileObj.zoom('max');
        });

        $('.crop-profile-main .rotate-img').on("click", function() {
            cropProfileObj.rotate();
        });

        $('.crop-profile-main .flip-img').on("click", function() {
            cropProfileObj.flip();
        });

		$('.crop-profile-main .base64-img').on("click", function() {
			//alert(cropProfileObj.data(960, 380, 'jpeg').image)

			image_src = cropProfileObj.data(960, 380, 'jpeg').image;
			var imgsrc = new Array();
		imgsrc.push(image_src);

		var data = {imgsrc : imgsrc};
		$.ajax({
				type: "POST",
				url: baseUrl + 'posts/add_user_coverpic',
				data: data,

				dataType: "JSON"

			});


			$(".crop-profile-main").removeClass("active-crop");
			$img = image_src;
			$( ".cover-image" ).html("<img src="+$img+" />")
			$("div.cover-image").show();
		});


		$('.crop-profile-main .download-img').on("click", function() {
			cropProfileObj.download(960, 380, 'filename', 'jpeg', $(this).attr('id'));

		});



    }








    $('.crop-overlay').on("click", function() {
        if (!cropObj) {
            intializeCrop();
        }
    });

    $("#crop-close").on("click", function(){
        $(".crop-profile-main").removeClass("active-crop");
		$("div.cover-image").show();
    });

    $('body').on("click", 'li.maskbg', function() {
        $('.crop-wrapper').toggleClass('maskbg');
        $('.default').attr('data-mask', $('.default').attr('data-mask') === 'true' ? 'false' : 'true');
        $('li.maskbg').html($('li.maskbg').html() == 'Mask' ? 'Unmask' : 'Mask');
    });


    $('.crop-profile').on("click", function() {
		$("div.cover-image").hide();
        if (!cropProfileObj) {
            intializeProfileCrop();
        }else{
            $(".crop-profile-main").addClass("active-crop");
        }
    });





	$(".cover-image").click(function() {
		addClass("active-crop");
		return false;
	});

});

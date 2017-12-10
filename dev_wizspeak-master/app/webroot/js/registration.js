/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var availableTags1 = [{"label":"Andorra","value":"1"},{"label":"United Arab Emirates","value":"2"},{"label":"Afghanistan","value":"3"},{"label":"Antigua and Barbuda","value":"4"},{"label":"Anguilla","value":"5"},{"label":"Albania","value":"6"},{"label":"Armenia","value":"7"},{"label":"Angola","value":"8"},{"label":"Antarctica","value":"9"},{"label":"Argentina","value":"10"},{"label":"American Samoa","value":"11"},{"label":"Austria","value":"12"},{"label":"Australia","value":"13"},{"label":"Aruba","value":"14"},{"label":"Aland","value":"15"},{"label":"Azerbaijan","value":"16"},{"label":"Bosnia and Herzegovi","value":"17"},{"label":"Barbados","value":"18"},{"label":"Bangladesh","value":"19"},{"label":"Belgium","value":"20"},{"label":"Burkina Faso","value":"21"},{"label":"Bulgaria","value":"22"},{"label":"Bahrain","value":"23"},{"label":"Burundi","value":"24"},{"label":"Benin","value":"25"},{"label":"Saint Barthelemy","value":"26"},{"label":"Bermuda","value":"27"},{"label":"Brunei","value":"28"},{"label":"Bolivia","value":"29"},{"label":"Bonaire","value":"30"},{"label":"Brazil","value":"31"},{"label":"Bahamas","value":"32"},{"label":"Bhutan","value":"33"},{"label":"Bouvet Island","value":"34"},{"label":"Botswana","value":"35"},{"label":"Belarus","value":"36"},{"label":"Belize","value":"37"},{"label":"Canada","value":"38"},{"label":"Cocos [Keeling] Isla","value":"39"},{"label":"Democratic Republic ","value":"40"},{"label":"Central African Repu","value":"41"},{"label":"Republic of the Cong","value":"42"},{"label":"Switzerland","value":"43"},{"label":"Ivory Coast","value":"44"},{"label":"Cook Islands","value":"45"},{"label":"Chile","value":"46"},{"label":"Cameroon","value":"47"},{"label":"China","value":"48"},{"label":"Colombia","value":"49"},{"label":"Costa Rica","value":"50"},{"label":"Cuba","value":"51"},{"label":"Cape Verde","value":"52"},{"label":"Curacao","value":"53"},{"label":"Christmas Island","value":"54"},{"label":"Cyprus","value":"55"},{"label":"Czech Republic","value":"56"},{"label":"Germany","value":"57"},{"label":"Djibouti","value":"58"},{"label":"Denmark","value":"59"},{"label":"Dominica","value":"60"},{"label":"Dominican Republic","value":"61"},{"label":"Algeria","value":"62"},{"label":"Ecuador","value":"63"},{"label":"Estonia","value":"64"},{"label":"Egypt","value":"65"},{"label":"Western Sahara","value":"66"},{"label":"Eritrea","value":"67"},{"label":"Spain","value":"68"},{"label":"Ethiopia","value":"69"},{"label":"Finland","value":"70"},{"label":"Fiji","value":"71"},{"label":"Falkland Islands","value":"72"},{"label":"Micronesia","value":"73"},{"label":"Faroe Islands","value":"74"},{"label":"France","value":"75"},{"label":"Gabon","value":"76"},{"label":"United Kingdom","value":"77"},{"label":"Grenada","value":"78"},{"label":"Georgia","value":"79"},{"label":"French Guiana","value":"80"},{"label":"Guernsey","value":"81"},{"label":"Ghana","value":"82"},{"label":"Gibraltar","value":"83"},{"label":"Greenland","value":"84"},{"label":"Gambia","value":"85"},{"label":"Guinea","value":"86"},{"label":"Guadeloupe","value":"87"},{"label":"Equatorial Guinea","value":"88"},{"label":"Greece","value":"89"},{"label":"South Georgia and th","value":"90"},{"label":"Guatemala","value":"91"},{"label":"Guam","value":"92"},{"label":"Guinea-Bissau","value":"93"},{"label":"Guyana","value":"94"},{"label":"Hong Kong","value":"95"},{"label":"Heard Island and McD","value":"96"},{"label":"Honduras","value":"97"},{"label":"Croatia","value":"98"},{"label":"Haiti","value":"99"},{"label":"Hungary","value":"100"},{"label":"Indonesia","value":"101"},{"label":"Ireland","value":"102"},{"label":"Israel","value":"103"},{"label":"Isle of Man","value":"104"},{"label":"India","value":"105"},{"label":"British Indian Ocean","value":"106"},{"label":"Iraq","value":"107"},{"label":"Iran","value":"108"},{"label":"Iceland","value":"109"},{"label":"Italy","value":"110"},{"label":"Jersey","value":"111"},{"label":"Jamaica","value":"112"},{"label":"Jordan","value":"113"},{"label":"Japan","value":"114"},{"label":"Kenya","value":"115"},{"label":"Kyrgyzstan","value":"116"},{"label":"Cambodia","value":"117"},{"label":"Kiribati","value":"118"},{"label":"Comoros","value":"119"},{"label":"Saint Kitts and Nevi","value":"120"},{"label":"North Korea","value":"121"},{"label":"South Korea","value":"122"},{"label":"Kuwait","value":"123"},{"label":"Cayman Islands","value":"124"},{"label":"Kazakhstan","value":"125"},{"label":"Laos","value":"126"},{"label":"Lebanon","value":"127"},{"label":"Saint Lucia","value":"128"},{"label":"Liechtenstein","value":"129"},{"label":"Sri Lanka","value":"130"},{"label":"Liberia","value":"131"},{"label":"Lesotho","value":"132"},{"label":"Lithuania","value":"133"},{"label":"Luxembourg","value":"134"},{"label":"Latvia","value":"135"},{"label":"Libya","value":"136"},{"label":"Morocco","value":"137"},{"label":"Monaco","value":"138"},{"label":"Moldova","value":"139"},{"label":"Montenegro","value":"140"},{"label":"Saint Martin","value":"141"},{"label":"Madagascar","value":"142"},{"label":"Marshall Islands","value":"143"},{"label":"Macedonia","value":"144"},{"label":"Mali","value":"145"},{"label":"Myanmar [Burma]","value":"146"},{"label":"Mongolia","value":"147"},{"label":"Macao","value":"148"},{"label":"Northern Mariana Isl","value":"149"},{"label":"Martinique","value":"150"},{"label":"Mauritania","value":"151"},{"label":"Montserrat","value":"152"},{"label":"Malta","value":"153"},{"label":"Mauritius","value":"154"},{"label":"Maldives","value":"155"},{"label":"Malawi","value":"156"},{"label":"Mexico","value":"157"},{"label":"Malaysia","value":"158"},{"label":"Mozambique","value":"159"},{"label":"Namibia","value":"160"},{"label":"New Caledonia","value":"161"},{"label":"Niger","value":"162"},{"label":"Norfolk Island","value":"163"},{"label":"Nigeria","value":"164"},{"label":"Nicaragua","value":"165"},{"label":"Netherlands","value":"166"},{"label":"Norway","value":"167"},{"label":"Nepal","value":"168"},{"label":"Nauru","value":"169"},{"label":"Niue","value":"170"},{"label":"New Zealand","value":"171"},{"label":"Oman","value":"172"},{"label":"Panama","value":"173"},{"label":"Peru","value":"174"},{"label":"French Polynesia","value":"175"},{"label":"Papua New Guinea","value":"176"},{"label":"Philippines","value":"177"},{"label":"Pakistan","value":"178"},{"label":"Poland","value":"179"},{"label":"Saint Pierre and Miq","value":"180"},{"label":"Pitcairn Islands","value":"181"},{"label":"Puerto Rico","value":"182"},{"label":"Palestine","value":"183"},{"label":"Portugal","value":"184"},{"label":"Palau","value":"185"},{"label":"Paraguay","value":"186"},{"label":"Qatar","value":"187"},{"label":"Reunion","value":"188"},{"label":"Romania","value":"189"},{"label":"Serbia","value":"190"},{"label":"Russia","value":"191"},{"label":"Rwanda","value":"192"},{"label":"Saudi Arabia","value":"193"},{"label":"Solomon Islands","value":"194"},{"label":"Seychelles","value":"195"},{"label":"Sudan","value":"196"},{"label":"Sweden","value":"197"},{"label":"Singapore","value":"198"},{"label":"Saint Helena","value":"199"},{"label":"Slovenia","value":"200"},{"label":"Svalbard and Jan May","value":"201"},{"label":"Slovakia","value":"202"},{"label":"Sierra Leone","value":"203"},{"label":"San Marino","value":"204"},{"label":"Senegal","value":"205"},{"label":"Somalia","value":"206"},{"label":"Suriname","value":"207"},{"label":"South Sudan","value":"208"},{"label":"Sao Tome and Princip","value":"209"},{"label":"El Salvador","value":"210"},{"label":"Sint Maarten","value":"211"},{"label":"Syria","value":"212"},{"label":"Swaziland","value":"213"},{"label":"Turks and Caicos Isl","value":"214"},{"label":"Chad","value":"215"},{"label":"French Southern Terr","value":"216"},{"label":"Togo","value":"217"},{"label":"Thailand","value":"218"},{"label":"Tajikistan","value":"219"},{"label":"Tokelau","value":"220"},{"label":"East Timor","value":"221"},{"label":"Turkmenistan","value":"222"},{"label":"Tunisia","value":"223"},{"label":"Tonga","value":"224"},{"label":"Turkey","value":"225"},{"label":"Trinidad and Tobago","value":"226"},{"label":"Tuvalu","value":"227"},{"label":"Taiwan","value":"228"},{"label":"Tanzania","value":"229"},{"label":"Ukraine","value":"230"},{"label":"Uganda","value":"231"},{"label":"U.S. Minor Outlying ","value":"232"},{"label":"United States","value":"233"},{"label":"Uruguay","value":"234"},{"label":"Uzbekistan","value":"235"},{"label":"Vatican City","value":"236"},{"label":"Saint Vincent and th","value":"237"},{"label":"Venezuela","value":"238"},{"label":"British Virgin Islan","value":"239"},{"label":"U.S. Virgin Islands","value":"240"},{"label":"Vietnam","value":"241"},{"label":"Vanuatu","value":"242"},{"label":"Wallis and Futuna","value":"243"},{"label":"Samoa","value":"244"},{"label":"Kosovo","value":"245"},{"label":"Yemen","value":"246"},{"label":"Mayotte","value":"247"},{"label":"South Africa","value":"248"},{"label":"Zambia","value":"249"},{"label":"Zimbabwe","value":"250"}];

$(document).ready( function() {





        $( "#UserCountryName" ).autocomplete({
        source: availableTags1,
		minLength: 3,
        focus: function( event, ui ) {
                    $( "#UserCountryName" ).val( ui.item.label);
                    return false;
                },
                select: function( event, ui ) {
                    $( "#UserCountry" ).val( ui.item.value);

                    return false;
                },
                response: function(event, ui) {


                },
        });




//    $( "#UserState" ).autocomplete({
//
//      source : "states/get_state_list/"+$('#UserCountryId').val(),
//      minLength : 2,
//      select: function( event, ui ) {
//          alert('sdfsd');
//          console.log(event);
//      }
//    });

        $( "#UserStateName" ).autocomplete({
              source: function( request, response ) {
                $.ajax({
                  url: baseUrl+"states/get_state_list/"+$('#UserCountry').val()+'/'+$('#UserStateName').val() ,
                  dataType: "json",
                  data: {
                    q: request.term
                  },
                  success: function( data ) {
                    response( data );
                    console.log(data);
                  }
                });
              },
            focus: function( event, ui ) {
                console.log(event);
                        $( "#UserStateName" ).val( ui.item.label);
                        return false;
                    },
                    select: function( event, ui ) {
                        $( "#UserState" ).val( ui.item.value);

                        return false;
                    },response: function(event, ui) {

                        if (ui.content.length === 0) {
                            $("#add_new_state").css('visibility','visible');

                        }else{
                            $("#add_new_state").css('visibility','hidden');
                        }
                    }
            });


        $( "#UserCityName" ).autocomplete({
              source: function( request, response ) {
                $.ajax({
                  url: baseUrl+"cities/get_city_list/"+$('#UserState').val()+'/'+$('#UserCityName').val() ,
                  dataType: "json",
                  data: {
                    q: request.term
                  },
                  success: function( data ) {
                    response( data );
                    console.log(data);
                  }
                });
              },
            focus: function( event, ui ) {
                console.log(event);
                        $( "#UserCityName" ).val( ui.item.label);
                        return false;
                    },
                    select: function( event, ui ) {
                        $( "#UserCity" ).val( ui.item.value);

                        return false;
                         if(!data.length){

                         }
                    },response: function(event, ui) {

                        if (ui.content.length === 0) {
                            $("#add_new_city").css('visibility','visible');

                        }else{
                            $("#add_new_city").css('visibility','hidden');
                        }
                    }
            });


        /*
         * UI listion - users/select_ambition
         */











});

        function populateStatesList(data){

            $('#state').empty();
            $.each($.parseJSON(data), function( index , element) {
                $('#state').append($('<option>', {
                    text: element.name,
                    value:element.id
                }));

            });
            $('#city').empty();
        }


        function populateCitiesList(data){

            $('#city').empty();
            $.each($.parseJSON(data), function( index , element) {
                $('#city').append($('<option>', {
                    text: element.name,
                    value:element.id
                }));

            });

        }



        function populateAmbSubCategories (data){

                    console.log(data);
            $('#UserProfileAmbitionSubCategories').val("");
            $("#UserProfileAmbitionSubCategories > option").each(function( index ) {
                if(index){
                    $(this).remove();
                }
            });

            $.each($.parseJSON(data), function( index , element) {
                console.log(element);
                $('#UserProfileAmbitionSubCategories').append($('<option>', {
                    text: element.name,
                    value: element.id
                }));

            });
        }
        function populateHobSubCategories (data){


            $('#UserProfileHobbySubCategories').val("");
            $("#UserProfileHobbySubCategories > option").each(function( index ) {
                if(index){
                    $(this).remove();
                }
            });

            $.each($.parseJSON(data), function( index , element) {
                $('#UserProfileHobbySubCategories').append($('<option>', {
                    text: element.name,
                    value: element.id
                }));

            });
        }

        $('#add_new_state').click( function(){
           var country_id = $('#UserCountry').val();
           var state_name = $('#UserStateName').val();
           var data = {country_id : country_id,name: state_name};
           new callAjax(data,'states/add','after_state_add').fire();

        });

        function after_state_add(result) {

            var data = JSON.parse(result);
            $('#UserState').val(data.id);
            $("#add_new_state").css('visibility','hidden');
        }


        $('#add_new_city').click( function(){
           var state_id = $('#UserState').val();
           var city_name = $('#UserCityName').val();
           var data = {state_id : state_id,name: city_name};
           new callAjax(data,'cities/add','after_city_add').fire();

        });

        function after_city_add(result) {
            var data = JSON.parse(result);
            $('#UserCity').val(data.id);
            $("#add_new_city").css('visibility','hidden');
        }


		$('.account').click( function(){

			account = $(this).val();
			if($(this).val() == 'mentor'){

				selectAccont('mentor');
			}
			if($(this).val() == 'user'){

				selectAccont('user');
			}


		});

		function selectAccont(user){

			var newForm = jQuery('<form>', {
				'action': baseUrl+'users/registration',
				'target': '_top',
				'method':'POST',
			}).append(jQuery('<input>', {
				'name': 'account',
				'value': user,
				'type': 'hidden'

			}));
			newForm.appendTo(document.body).submit();
			return true;
		}

$('.homePage').click( function(){

	alert(" go to home ");
	var newForm = jQuery('<form>', {
		'action': baseUrl+'users/homePage',
		'target': '_top',
		'method':'POST',
	}).append(jQuery('<input>', {
		'name': 'account',
		'value': '1',
		'type': 'hidden'

	}));
	newForm.appendTo(document.body).submit();
	return true;

});


/*xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx search for hobbies and ambition  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx*/

var sel_ambition_ids = new Array();
var sel_hobby_ids = new Array();
var sel_expertise_ids = new Array();

$(".search-cate").on("input", function () {

	if ($(this).val().length == 0) {
		$(".search-cate-suggestion").hide();
	} else {

		fetchCategories($(this).val(), $('.search-input-filter').val());
		$(".search-cate-suggestion").show();

	}

});

$(".search-cate").on("focus", function () {
	$(".search-cate-suggestion").show();
});


//search hobbies

$(".search-cate-hob").on("input", function () {

	if ($(this).val().length == 0) {
		$(".search-cate-hob-suggestion").hide();
	} else {

		fetchCategories($(this).val(), $('.search-input-hob-filter').val());
		$(".search-cate-hob-suggestion").show();

	}

});

$(".search-cate-hob").on("focus", function () {
	$(".search-cate-hob-suggestion").show();
})



//search all

$(".search-cate-mentor").on("input", function () {

	if ($(this).val().length == 0) {
		$(".search-mentor-suggestion").hide();
	} else {

		fetchCategories($(this).val(), $('.search-input-mentor-filter').val());
		$(".search-mentor-suggestion").show();

	}

});

$(".search-cate-mentor").on("focus", function () {
	$(".search-cate-hob-suggestion").show();
})



function fetchCategories(key,filter){
	//alert(key+filter);

	var data = {key : key, filter : filter};
	if(filter==1 || filter ==2){
		var result = new callAjax(data,'searches/category','populate_simple_serach').fire();
	}else{
		var result = new callAjax(data,'searches/category','populate_all_simple_serach').fire();

	}




}



function populate_simple_serach(result) {

	var Sresult = JSON.parse(result);
	var msg = '';
	if(Sresult.length>0){

		$(".add-new-amb").css("display","none");
		for(i = 0; i < Sresult.length;i++){
			var about = Sresult[i].about;

			var msg = msg+'<div class="search-row-sugg" >'+
				'<div class="sugg-details amb-cate-sel" data-id="'+Sresult[i]['SubCategory'].id+'" >'+
				'<h2>'+Sresult[i]['SubCategory'].name+'</h2>'+
				'</div>'+
				'</div>';
			type = Sresult[i]['Category'].vertical_id;
		}

	}else{
		$(".add-new-amb").css("display","block");
		var msg ="";

	}



	if(type==1){
		//ambition
		$('#fetch-search-result').html(msg);
	}else if (type ==2){
		$('#fetch-search-hob-result').html(msg);
	}

}


function populate_all_simple_serach(result) {

	var Sresult = JSON.parse(result);
	var msg = '';
	if (Sresult.length > 0) {

		$(".add-new-amb").css("display", "none");
		for (i = 0; i < Sresult.length; i++) {
			var about = Sresult[i].about;

			var msg = msg + '<div class="search-row-sugg" >' +
				'<div class="sugg-details amb-cate-sel" data-id="' + Sresult[i]['SubCategory'].id + '" >' +
				'<h2>' + Sresult[i]['SubCategory'].name + '</h2>' +
				'</div>' +
				'</div>';
			type = Sresult[i]['Category'].vertical_id;
		}

	} else {
		$(".add-new-amb").css("display", "block");
		var msg = "";

	}
	$('#fetch-search-mentor-result').html(msg);
}



	$('.search-cate-suggestion').on('click','.amb-cate-sel', function(){

	subCatId = $(this).attr("data-id");
	subCatName = $(this).find( "h2:first" ).text();
	var template = "<div class='sel-hob-main' id='"+subCatId+"' ><div class='sel-copy' >"+subCatName+"</div><div class='sel-close' ></div></div>";
	$(".ambitions-listsel").append(template);
	sel_ambition_ids.push(subCatId);
	$('.search-cate').val("");
	$(".search-cate-suggestion").hide();

	//change place holder in the input
	if(sel_ambition_ids.length > 0){
		$(".search-cate").attr("placeholder","Add more to the list");
	}else{
		$(".search-cate").attr("placeholder","Describe in 'one word' ");
	}



});

$('.search-cate-suggestion').on('click','.add-new-amb h2 a', function(){

	$(".add-new-amb").css("display","none");
	subCatName = $(".search-cate").val();
	catType = $(".search-input-filter").val();
	subCatId = 0; //user defined sub cate
	subCatName = $.trim(subCatName);
	if(subCatName!=""){
		var data ={name : subCatName, type : catType};
		new callAjax(data,'/sub_categories/addUserDefined','afterAddSubCategory').fire();

	}else{
		alert("Enter your ambition");
		$(".search-cate").focus();
	}
	//call ajax for add new sub_category



});


$('.search-mentor-suggestion').on('click','.add-new-amb h2 a', function(){

	$(".add-new-amb").css("display","none");
	subCatName = $(".search-cate-mentor").val();
	catType = $(".search-input-mentor-filter").val();
	subCatId = 0; //user defined sub cate
	subCatName = $.trim(subCatName);
	if(subCatName!=""){
		var data ={name : subCatName, type : catType};
		new callAjax(data,'sub_categories/addUserDefined','afterAddAllSubCategory').fire();

	}else{
		alert("Enter your ambition");
		$(".search-cate").focus();
	}
	//call ajax for add new sub_category



});


$('.search-cate-hob-suggestion').on('click','.add-new-amb h2 a', function(){

	$(".add-new-amb").css("display","none");
	subCatName = $(".search-cate-hob").val();
	catType = $(".search-input-hob-filter").val();
	subCatId = 0; //user defined sub cate
	subCatName = $.trim(subCatName);
	if(subCatName!=""){
		var data ={name : subCatName, type : catType};
		new callAjax(data,'/sub_categories/addUserDefined','afterAddHobSubCategory').fire();

	}else{
		alert("Enter your ambition");
		$(".search-cate-hob").focus();
	}
	//call ajax for add new sub_category



});



function afterAddSubCategory(result){
	var Sresult = JSON.parse(result);

	if(Sresult.name != "" && Sresult.id != null){
		var template = "<div class='sel-hob-main' id='"+Sresult.id+"' ><div class='sel-copy' >"+Sresult.name+"</div><div class='sel-close' ></div></div>";

	}
	$(".ambitions-listsel").append(template);
	$('.search-cate').val("");
	$(".search-cate-suggestion").hide();

}

function afterAddHobSubCategory(result){
	var Sresult = JSON.parse(result);

	if(Sresult.name != "" && Sresult.id != null){
		var template = "<div class='sel-hob-main' id='"+Sresult.id+"' ><div class='sel-copy' >"+Sresult.name+"</div><div class='sel-close' ></div></div>";

	}
	$(".hobbies-listsel").append(template);
	$('.search-cate-hob').val("");
	$(".search-cate-hob-suggestion").hide();

}

function afterAddAllSubCategory(result){
	var Sresult = JSON.parse(result);

	if(Sresult.name != "" && Sresult.id != null){
		var template = "<div class='sel-hob-main' id='"+Sresult.id+"' ><div class='sel-copy' >"+Sresult.name+"</div><div class='sel-close' ></div></div>";

	}
	$(".expertise-listsel").append(template);
	$('.search-cate-mentor').val("");
	$(".search-mentor-suggestion").hide();

}

$('.search-cate-hob-suggestion').on('click','.amb-cate-sel', function(){

	subCatId = $(this).attr("data-id");
	subCatName = $(this).find( "h2:first" ).text();
	var template = "<div class='sel-hob-main' id='"+subCatId+"' ><div class='sel-copy' >"+subCatName+"</div><div class='sel-close' ></div></div>";
	$(".hobbies-listsel").append(template);
	sel_hobby_ids.push(subCatId);
	$('.search-cate-hob').val("");
	$(".search-cate-hob-suggestion").hide();

	//change place holder in the input
	if(sel_hobby_ids.length > 0){
		$(".search-cate-hob").attr("placeholder","Add more to the list");
	}else{
		$(".search-cate-hob").attr("placeholder","Describe in 'one word' ");
	}

});


$('.search-mentor-suggestion').on('click','.amb-cate-sel', function(){

	subCatId = $(this).attr("data-id");
	subCatName = $(this).find( "h2:first" ).text();
	var template = "<div class='sel-hob-main' id='"+subCatId+"' ><div class='sel-copy' >"+subCatName+"</div><div class='sel-close' ></div></div>";
	$(".expertise-listsel").append(template);
	sel_expertise_ids.push(subCatId);
	$('.search-cate-mentor').val("");
	$(".search-mentor-suggestion").hide();

	//change place holder in the input
	if(sel_expertise_ids.length > 0){
		$(".search-cate-mentor").attr("placeholder","Add more to the list");
	}else{
		$(".search-cate-mentor").attr("placeholder","Describe in 'one word' ");
	}

});




$('#userCategory').submit( function(event) {


	$('<input>').attr({
		type: 'hidden',
		name: 'ambitions',
		value: sel_ambition_ids
	}).appendTo('#userCategory');
	$('<input>').attr({
		type: 'hidden',
		name: 'hobbies',
		value:sel_hobby_ids
	}).appendTo('#userCategory');

	$('<input>').attr({
		type: 'hidden',
		name: 'experty',
		value:sel_expertise_ids
	}).appendTo('#userCategory');



});


$(document.body).on('click', function (e) {
	if (!$(e.target).closest(".search-cate").length) {
		$(".search-cate-suggestion").hide();
	}
	if (!$(e.target).closest(".search-cate-hob").length) {
		$(".search-cate-hob-suggestion").hide();
	}
});


//remove selected amb

$(".ambitions-listsel").on("click", '.sel-close', function () {
	$(this).parents(".sel-hob-main:first").remove();
	var div_id = $(this).parents(".sel-hob-main").attr('id');
	var idIndex = sel_ambition_ids.indexOf(div_id);
	if (idIndex > -1) {
		sel_ambition_ids.splice(idIndex, 1);
	}

	if(sel_ambition_ids.length < 1){
		$(".search-cate").attr("placeholder","Describe in 'one word' ");
	}

});

//remove selected hobbies


$(".hobbies-listsel").on("click", '.sel-close', function () {
	$(this).parents(".sel-hob-main:first").remove();
	var div_id = $(this).parents(".sel-hob-main").attr('id');

	var idIndex = sel_hobby_ids.indexOf(div_id);
	if (idIndex > -1) {
		sel_hobby_ids.splice(idIndex, 1);
	}

	if(sel_hobby_ids.length < 1){
		$(".search-cate-hob").attr("placeholder","Describe in 'one word' ");
	}
});



//remove selected expertice


$(".expertise-listsel").on("click", '.sel-close', function () {
	$(this).parents(".sel-hob-main:first").remove();
	var div_id = $(this).parents(".sel-hob-main").attr('id');

	var idIndex = sel_expertise_ids.indexOf(div_id);
	if (idIndex > -1) {
		sel_expertise_ids.splice(idIndex, 1);
	}

	if(sel_expertise_ids.length < 1){
		$(".search-cate-mentor").attr("placeholder","Describe in 'one word' ");
	}
});

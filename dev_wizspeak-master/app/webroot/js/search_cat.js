
/*xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx search for hobbies and ambition  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx*/
$(document).ready( function() {
	var sel_ambition_ids = new Array();
	var sel_hobby_ids = new Array();
	var sel_expertise_ids = new Array();

	$('.ambitions-listsel .sel-hob-main').each( function(){

		sel_ambition_ids.push($(this).attr("id"));
	});

	$('.hobbies-listsel .sel-hob-main').each( function(){

		sel_hobby_ids.push($(this).attr("id"));
	});

	$('.expertise-listsel .sel-hob-main').each( function(){

		sel_expertise_ids.push($(this).attr("id"));
	});



	$(".search-cate").on("input", function () {

		if ($(this).val().length == 0) {
			$(".search-cate-suggestion").hide();
		} else {

			fetchCategories($(this).val(), 1);
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

			fetchCategories($(this).val(), 2);
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

			fetchCategories($(this).val(),0);
			$(".search-mentor-suggestion").show();

		}

	});

	$(".search-cate-mentor").on("focus", function () {
		$(".search-mentor-suggestion").show();
	})


	function fetchCategories(key, filter) {
		//alert(key+filter);

		var data = {key: key, filter: filter};
		if (filter == 1 || filter == 2) {
			var result = new callAjax(data, 'searches/category', 'populate_simple_serach').fire();
		} else {
			var result = new callAjax(data, 'searches/category', 'populate_all_simple_serach').fire();

		}


	}



	$('.search-cate-suggestion').on('click', '.amb-cate-sel', function () {

		subCatId = $(this).attr("data-id");
		subCatName = $(this).find("h2:first").text();
		if(jQuery.inArray(subCatId,sel_ambition_ids) < 0 ){

			var template = "<div class='sel-hob-main' id='" + subCatId + "' ><div class='sel-copy' >" + subCatName + "</div><div class='sel-close' ></div></div>";
			$(".ambitions-listsel").append(template);
			sel_ambition_ids.push(subCatId);

		}

		$('.search-cate').val("");
		$(".search-cate-suggestion").hide();

		//change place holder in the input
		if (sel_ambition_ids.length > 0) {
			$(".search-cate").attr("placeholder", "Add more to the list");
		} else {
			$(".search-cate").attr("placeholder", "Describe in 'one word' ");
		}


	});

	$('.search-cate-suggestion').on('click', '.add-new-amb h2 a', function () {

		$(".add-new-amb").css("display", "none");
		subCatName = $(".search-cate").val();
		catType = 1;
		subCatId = 0; //user defined sub cate
		subCatName = $.trim(subCatName);
		if (subCatName != "") {
			var data = {name: subCatName, type: catType};
			new callAjax(data, '/sub_categories/addUserDefined', 'afterAddSubCategory').fire();

		} else {
			alert("Enter your ambition");
			$(".search-cate").focus();
		}
		//call ajax for add new sub_category


	});


	$('.search-mentor-suggestion').on('click', '.add-new-amb h2 a', function () {

		$(".add-new-amb").css("display", "none");
		subCatName = $(".search-cate-mentor").val();
		catType = $(".search-input-mentor-filter").val();
		subCatId = 0; //user defined sub cate
		subCatName = $.trim(subCatName);
		if (subCatName != "") {
			var data = {name: subCatName, type: catType};
			new callAjax(data, 'sub_categories/addUserDefined', 'afterAddAllSubCategory').fire();

		} else {
			alert("Enter your ambition");
			$(".search-cate").focus();
		}
		//call ajax for add new sub_category


	});


	$('.search-cate-hob-suggestion').on('click', '.add-new-amb h2 a', function () {

		$(".add-new-amb").css("display", "none");
		subCatName = $(".search-cate-hob").val();
		catType = 2;
		subCatId = 0; //user defined sub cate
		subCatName = $.trim(subCatName);
		if (subCatName != "") {
			var data = {name: subCatName, type: catType};
			new callAjax(data, '/sub_categories/addUserDefined', 'afterAddHobSubCategory').fire();

		} else {
			alert("Enter your ambition");
			$(".search-cate-hob").focus();
		}
		//call ajax for add new sub_category


	});


	$('.search-cate-hob-suggestion').on('click', '.amb-cate-sel', function () {

		subCatId = $(this).attr("data-id");
		subCatName = $(this).find("h2:first").text();

		if(jQuery.inArray(subCatId,sel_hobby_ids) < 0 ) {

			var template = "<div class='sel-hob-main' id='" + subCatId + "' ><div class='sel-copy' >" + subCatName + "</div><div class='sel-close' ></div></div>";
			$(".hobbies-listsel").append(template);
			sel_hobby_ids.push(subCatId);
		}
		$('.search-cate-hob').val("");
		$(".search-cate-hob-suggestion").hide();

		//change place holder in the input
		if (sel_hobby_ids.length > 0) {
			$(".search-cate-hob").attr("placeholder", "Add more to the list");
		} else {
			$(".search-cate-hob").attr("placeholder", "Describe in 'one word' ");
		}

	});


	$('.search-mentor-suggestion').on('click', '.amb-cate-sel', function () {

		subCatId = $(this).attr("data-id");
		subCatName = $(this).find("h2:first").text();
		var template = "<div class='sel-hob-main' id='" + subCatId + "' ><div class='sel-copy' >" + subCatName + "</div><div class='sel-close' ></div></div>";
		$(".expertise-listsel").append(template);
		sel_expertise_ids.push(subCatId);
		$('.search-cate-mentor').val("");
		$(".search-mentor-suggestion").hide();

		//change place holder in the input
		if (sel_expertise_ids.length > 0) {
			$(".search-cate-mentor").attr("placeholder", "Add more to the list");
		} else {
			$(".search-cate-mentor").attr("placeholder", "Describe in 'one word' ");
		}

	});


	$('#userCategory').submit(function (event) {


		$('<input>').attr({
			type: 'hidden',
			name: 'ambitions',
			value: sel_ambition_ids
		}).appendTo('#userCategory');
		$('<input>').attr({
			type: 'hidden',
			name: 'hobbies',
			value: sel_hobby_ids
		}).appendTo('#userCategory');

		$('<input>').attr({
			type: 'hidden',
			name: 'experty',
			value: sel_expertise_ids
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

		if (sel_ambition_ids.length < 1) {
			$(".search-cate").attr("placeholder", "Describe in 'one word' ");
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

		if (sel_hobby_ids.length < 1) {
			$(".search-cate-hob").attr("placeholder", "Describe in 'one word' ");
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

		if (sel_expertise_ids.length < 1) {
			$(".search-cate-mentor").attr("placeholder", "Describe in 'one word' ");
		}
	});



	$("#saveAmb").click( function(){

		var data = {category : sel_ambition_ids,vertical : 1}
		var result = new callAjax(data, 'user_category_relations/add', 'populate_alzl_simple_serach').fire();
		return false;
	});

	$("#saveHob").click( function(){

		var data = {category : sel_hobby_ids,vertical : 2}
		var result = new callAjax(data, 'user_category_relations/add', 'populate_all_simple_seraach').fire();
		return false;
	});

	$("#saveAll").click( function(){

		var data = {category : sel_expertise_ids,vertical : 3}
		var result = new callAjax(data, 'user_category_relations/add', 'populate_all_simple_seraach').fire();
		return false;

	});


});

function populate_all_simple_seraach() {

}
function populate_alzl_simple_serach() {

}


function populate_simple_serach(result) {


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


	if (type == 1) {
		//ambition

		$('.search-cate-suggestion #fetch-search-result').html(msg);
	} else if (type == 2) {

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



function afterAddSubCategory(result) {
	var Sresult = JSON.parse(result);

	if (Sresult.name != "" && Sresult.id != null) {
		var template = "<div class='sel-hob-main' id='" + Sresult.id + "' ><div class='sel-copy' >" + Sresult.name + "</div><div class='sel-close' ></div></div>";

	}
	$(".ambitions-listsel").append(template);
	$('.search-cate').val("");
	$(".search-cate-suggestion").hide();

}

function afterAddHobSubCategory(result) {
	var Sresult = JSON.parse(result);

	if (Sresult.name != "" && Sresult.id != null) {
		var template = "<div class='sel-hob-main' id='" + Sresult.id + "' ><div class='sel-copy' >" + Sresult.name + "</div><div class='sel-close' ></div></div>";

	}
	$(".hobbies-listsel").append(template);
	$('.search-cate-hob').val("");
	$(".search-cate-hob-suggestion").hide();

}

function afterAddAllSubCategory(result) {
	var Sresult = JSON.parse(result);

	if (Sresult.name != "" && Sresult.id != null) {
		var template = "<div class='sel-hob-main' id='" + Sresult.id + "' ><div class='sel-copy' >" + Sresult.name + "</div><div class='sel-close' ></div></div>";

	}
	$(".expertise-listsel").append(template);
	$('.search-cate-mentor').val("");
	$(".search-mentor-suggestion").hide();

}

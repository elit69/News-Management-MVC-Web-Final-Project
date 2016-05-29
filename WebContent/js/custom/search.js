/* Load Time Drop */
$.post("sourcelistwithcode.json", function(data) {	
	var str = "<li id=''><a href=#>ប្រភពព័ត៌មានទូទៅ</a></li>";
	for (var i = 0; i < data.length; i++) {
		str += "<li id=" + data[i].user_info_code + "><a href=#>"
				+ data[i].full_name.toUpperCase() + "</a></li>";
	}
	$("#lstnewsources").html(str);
});
$.post("categorylistwithcode.json", function(data) {
	var str = "<li id=''><a href=#>ប្រភេទព័ត៌មានទូទៅ</a></li>";
	for (var i = 0; i < data.length; i++) {
		str += "<li id=" + data[i].cat_code + "><a href=#>" + data[i].cat_name
				+ "</a></li>";
	}
	$("#lstcategory").html(str);
});
/* function add popular */
// ###################################select value drop down
$('body').on('click', '#lstnewsources li', function() {
	$('#showNews').text($(this).text());
	$('#showNews').attr('value', $(this).attr("id"));
});
$('body').on('click', '#lstcategory li', function() {
	$('#showCategory').text($(this).text());
	$('#showCategory').attr('value', $(this).attr("id"));
});
$('#lsttime li').on('click', function() {
	$('#showTime').text($(this).text());
	$('#showTime').attr('value', $(this).attr("id"));
});
$('#lstItem li').on('click', function() {
	$('#showItem').text('ចំនួនលទ្ធផល ' + $(this).text());	
/*	countItems = parseInt($(this).attr("id"));
	pageNumber = parseInt($(this).attr("id"));
	alert(countItems);*/
});
var countItems = 15;
var pageNumber = 0;
function getResult(pageNumber) {
	$
			.post(
					"listResult.json",
					{
						title : $('#txtsearch-input').val(),
						newsCode : $('#showNews').attr('value'),
						categoryCode : $('#showCategory').attr('value'),
						timeCode : $('#showTime').attr('value'),
						pageCode : pageNumber
					},
					function(data, status) {
						//alert(data.length);
						//if (data.length == null || data.length == '') alert("sdfsd");
						if (data.length > 0) {
							var str = "";
							for (var i = 0; i < data.length; i++) {
								if(data[i].news_path=='')	data[i].news_path = 'article?id=' + data[i].news_id;
								str += "<div class='col-sm-12 search-result clear-paddings'><a href='"
										+ data[i].news_path
										+ "' target='_blank'>"
										+ "<div class='col-md-3 col-sm-3 col-xs-3 clear-paddings'>"
										+ "<div class='search-result-image' style='background-image: url(" + data[i].news_img+ "), url(img/404.jpg);'></div>"
										+ "</div>"
										+ "<div class='col-md-9 col-sm-9 col-xs-9 clear-padding-right'>"
										+ "<h5 class='article-name clear-margin-top text-h5-1'>"
										+ data[i].news_title
										+ "</h5>"
										+ "<strong>ផ្សាយ <kbd>"
										+ data[i].news_published_date
										+ "</kbd></strong>"
										+ "<p class='clear-margin-bottom text-2'>"
										+ data[i].news_desc
										+ "</p>"
										+ "<strong class='news-source'>ប្រភពពត៌មាន <kbd>"
										+ data[i].full_name.toUpperCase()
										+ "</kbd></strong>"
										+ "</div><div class='clearfix'></div></a></div><hr/>";
							}
							str += "<ul class='pager clear-padding-right'>"
									+ "<li class='previous'><a href='#' class='btn btn-lg btn-primary'>ទំព័រមុខ</a></li>"
									+ "<li class='next'><a href='#' class='btn btn-lg btn-primary'>ទំព័រក្រោយ​</a></li>"
									+ "</ul>";
							$('.search-result-wrapper').html(str);
							if (data.length < countItems) {
								$('.next a').addClass('disabled');
								$('body').off('click', '.next a');
							}
							if (pageNumber == 0) {
								$('.previous a').addClass('disabled');
								$('body').off('click', '.previous a');
							}
							//return;
						} else {
							$('.search-result-wrapper').html("");
						}
					//	alert('sdfsd');
					//	$('.search-result-wrapper').html("");
					});
}
$('body').on('click', '.previous', function() {
	getResult(pageNumber -= countItems);
});
$('body').on('click', '.next', function() {
	getResult(pageNumber += countItems);
});

$('body').on('click ', '#btnSubmit', function() {
	pageNumber = 0;
	if ($('#txtsearch-input').val() != '')
		getResult(pageNumber);
	$('html, body').animate({
		scrollTop : $(".search-result-wrapper").offset().top - 70
	}, 500);
});
$('#txtsearch-input').keypress(function(e) {
	if (e.which == 13)	$("#btnSubmit").trigger("click");
});
$("#btnSubmit").trigger("click");
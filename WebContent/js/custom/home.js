//###################################slider
var owl = $("#owl-demo"), i = 0, textholder, booleanValue = false;
owl.owlCarousel({
	// //Set AutoPlay to 3 seconds
	autoPlay : 6000,
	loop : true,
	pagination : false,
	slideSpeed : 300,
	items : 1,
	responsive : true,
	responsiveRefreshRate : 200,
	responsiveBaseWidth : window,
	itemsDesktop : [ 1199, 1 ],
	itemsDesktopSmall : [ 979, 1 ],
	itemsTablet : [ 750, 1 ]
});
$.post("recentnews.json", function(data) {
	var allItem = "";
	for ( var i in data) {
		if(data[i].news_path=='') data[i].news_path = 'article?id=' + data[i].news_id;
		allItem += "<div class='item clear-margins'> " 
				+ "<div class='owl-image' style='background-image: url(" + getBigImage(data[i].news_img)+ "), url(img/404.jpg);' alt='item slider'></div>"
				+ "<div class='news-title-background' id='"+ data[i].news_id +"'>" + "<a href='"
				+ data[i].news_path + "' target='_blank'>"
				+ "<div class='owl-news-title'>"
				+ "<h5 class='text-h5-2-slider clear-margin-top'>"
				+ data[i].news_title + "</h5>"
				+ "<p class='text-5 clear-margin-bottom'>" + data[i].news_desc
				+ "</p>" + "</div>" + "<div class='owl-news-source'>"
				+ "<strong>ប្រភពពត័មាន <kbd>" + data[i].full_name
				+ "</kbd></strong>" + "</div>" + "</a>" + "</div>" + "</div>";
	}
	owl.data('owlCarousel').addItem(allItem);
});
//###################################header
$('#hdhome').attr("class","active");
//###################################side-bar-left
$("#btn-home").click(function() {
	$('html, body').animate({
		scrollTop : $("#owl-demo").offset().top - 100
	}, 350);
});	
$("#btn-localnews").click(function() {
	$('html, body').animate({
		scrollTop : $("#localnews-scroll").offset().top - 75
	}, 500);
});

$("#btn-technews").click(function() {
	$('html, body').animate({
		scrollTop : $("#technews-scroll").offset().top - 75
	}, 500);
});
$("#btn-sportnews").click(function() {
	$('html, body').animate({
		scrollTop : $("#sportnews-scroll").offset().top - 75

	}, 500);
});

$("#btn-knowledgenews").click(function() {
	$('html, body').animate({
		scrollTop : $("#knowledgenews-scroll").offset().top - 75

	}, 500);
});
$("#btn-socialnews").click(function() {
	$('html, body').animate({
		scrollTop : $("#socialnews-scroll").offset().top - 75

	}, 500);
});
$("#btn-Economynews").click(function() {
	$('html, body').animate({
		scrollTop : $("#economicnews-scroll").offset().top - 75

	}, 500);
});
$("#btn-EntertainmentNews").click(function() {
	$('html, body').animate({
		scrollTop : $("#entertainmentnews-scroll").offset().top - 75

	}, 500);
});
$("#btn-LifeAndJobs").click(function() {
	$('html, body').animate({
		scrollTop : $("#lifeandjobsnews-scroll").offset().top - 75

	}, 500);
});

//###################################panel
setData("B020101", "month", "#panelBody_cam");
setData("B010105", "month", "#panelBody_tech");
setData("B020201", "month", "#panelBody_sport");
setData("B020501", "month", "#panelBody_knowledge");
setData("B030102", "month", "#panelBody_social");
setData("B030401", "month", "#panelBody_economy");
setData("B010302", "month", "#panelBody_entertainment");
setData("B010505", "month", "#panelBody_lifeandjob");

$("#listLocal li").click(function() {
	$('#showLocal').text($(this).text());
	setData("B020101", $(this).attr('value'), "#panelBody_cam");
});
$("#listTech li").click(function() {
	$('#showTech').text($(this).text());
	setData("B010105", $(this).attr('value'), "#panelBody_tech");
});

$("#listSport li").click(function() {
	$('#showSport').text($(this).text());
	setData("B020201", $(this).attr('value'), "#panelBody_sport");
});

$("#listKnowledge li").click(function() {
	$('#showKnowledge').text($(this).text());
	setData("B020501", $(this).attr('value'), "#panelBody_knowledge");
});

$("#listSocial li").click(function() {
	$('#showSocial').text($(this).text());
	setData("B030102", $(this).attr('value'), "#panelBody_social");
});

$("#listEconomy li").click(function() {
	$('#showEconomy').text($(this).text());
	setData("B030401", $(this).attr('value'), "#panelBody_economy");
});
$("#listEnterain li").click(
		function() {
			$('#showEnterain').text($(this).text());
			setData("B010302", $(this).attr('value'),
					"#panelBody_entertainment");
});
$("#listlifeandjobs li").click(
		function() {
			$('#showLifeandJobs').text($(this).text());
			setData("B010505", $(this).attr('value'),
					"#panelBody_lifeandjob");
});
function setData(code, time_limit, element) {
	var request = "";
	if (time_limit == "day")
		request = "listnewscategorybydaily.json";
	else if (time_limit == "week")
		request = "listnewscategorybyweekly.json";
	else
		request = "listnewscategorybymonthly.json";
	$
			.post(
					request,
					{
						c_code : code,
						limit : 11,
						offset : 0
					},
					function(news) {
						if (news.length <= 0) {
							$(element).html("");
							return;
						}
						if(news[0].news_path=='') news[0].news_path = 'article?id=' + news[0].news_id;
						var data = "<div class='card-1' id='" + news[0].news_id + "'>"
								+ "<a href='"+ news[0].news_path +"' target='_blank' id='link-1'>"
								+ "<div class='col-md-4 col-sm-4 col-xs-4 clear-paddings'>"
								+ "<div class='card-1-image' style='background-image: url(" + news[0].news_img + "), url(img/404.jpg);' alt='item slider'></div>"
								+ "</div>"
								+ "<div class='col-md-8 col-sm-8 col-xs-8 card-details pull-right '>"
								+ "<h5 class='text-h5-2 article-title' id='title-1'>"
								+ news[0].news_title
								+ "</h5>"
								+ "<p class='text-3 news-description' id='des-1'>"
								+ news[0].news_desc
								+ "</p>"
								+ "<div class='col-md-12 col-sm-12 col-xs-12 clear-paddings news-info' id='info-1'>"
								+ "អាន "
								+ news[0].count_visited
								+ " | "
								+ news[0].news_published_date
								+ " | "
								+ news[0].full_name
								+ "</div>"
								+ "</div>"
								+ "</a>"
								+ "</div>";
						for (var i = 1; i < news.length; i++) {
							if(news[i].news_path=='') news[i].news_path = 'article?id=' + news[i].news_id;
							data += "<div class='card-2 col-md-6 col-sm-6 col-xs-6 clear-paddings'id='" + news[i].news_id + "'>"
									+ "<a href='"
									+ news[i].news_path
									+ "' target='_blank' id='link-2'>"
									+ "<div class='col-md-4 col-sm-4 col-xs-4 clear-paddings'>"
									+ "<div class='card-2-image' style='background-image: url(" + news[i].news_img + "), url(img/404.jpg);' alt='item slider'></div>"
									+ "</div>"
									+ "<div class='col-md-8 col-sm-8 col-xs-8 card-details'>"
									+ "<h6 class='text-h6-2 article-title' id='title-2'>"
									+ news[i].news_title
									+ "</h6>"
									+ "<div class='col-md-12 col-sm-12 col-xs-12 clear-paddings text-1 news-info' id='info-2'>អាន "
									+ news[i].count_visited
									+ " | "
									+ news[i].news_published_date
									+ " | "
									+ news[i].full_name
									+ "</div>"
									+ "</div>" + "</a>" + "</div>";
						}
						$(element).html(data);
					});
}
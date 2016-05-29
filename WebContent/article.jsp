<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>news box site...</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="img/box.png" />
<!-- lib css -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/responsive.css">
<!-- end lib css -->
<!-- custom css -->
<link rel="stylesheet" type="text/css" href="css/custom/index.css">
<link rel="stylesheet" type="text/css" href="css/custom/article.css">
<!-- end custom css -->
</head>
<body>
	<!-- header -->
	<jsp:include page="layouts/header.jsp" />
	<!-- end header -->
	<!-- content area article -->
	<div class="container content-area">
		<!-- article -->
		<!-- search panel -->
		<jsp:include page="layouts/searchbar.jsp" />
		<!-- end search panel -->
		<!-- right panel -->
		<div
			class="col-sm-9 content-left clear-padding-left clear-margins left-panel">
			<div class="panel panel-primary clear-margins">
				<!-- article header-->
				<div class="slider-content-area">
					<div class="news-image"
						style='background-image: url(${ad.getImg_path()}),  url(img/404.jpg)'></div>
					<div class="news-title-block">
						<div class="myclear"></div>
						<div class="news-title">
							<h4 class="article-name">${ad.getNews_title()}</h4>
						</div>
					</div>
				</div>
				<!-- end article header-->
				<!-- article body -->
				<div class="panel-body" style="margin-bottom: 30px;padding:10px;">
					<!-- news-detail -->
					<div class="col-sm-12">
						<!-- news publish date -->
						<p class="col-sm-6 article-info pull-left">
							<strong>ចេញផ្សាយ <kbd>
									<time>${ad.getNews_date()}</time>
								</kbd>
							</strong>
						</p>
						<!-- news category -->
						<p class="col-sm-6 article-info pull-right"
							style="text-align: right;">
							<strong>ប្រភេទព័ត៌មាន<kbd>${ad.getNew_source()}</kbd>
							</strong>
						</p>
						<div class="clear-fix"></div>
					</div>
					<!-- end news-detail -->
					<hr style="margin-top: 5px">
					<!-- paragraph -->
					<div class="col-sm-12 clear-margin-bottom news-content">
						${ad.getNew_content()}</div>
					<!-- end paragraph -->
					<!-- news author -->
					<div class="col-sm-12" style='margin-bottom: 15px'>
						<hr>
						<strong>អត្ថបទដោយ៖ </strong>
						<kbd>${ad.getAuthor()}</kbd>
					</div>
				</div>
				<!-- end article body -->
			</div>
			<div class="panel panel-primary clear-margins">
				<div class="panel-body" style="margin-bottom: 30px; padding: 10px;">
					<div class="fb-comments"
						data-href="https://www.facebook.com/pages/NewsBox/1020022034715346?ref=notif&amp;notif_t=page_new_likes"
						data-width="100%" data-numposts="5"></div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
		<!-- end article -->
		<!-- right panel -->
		<jsp:include page="layouts/right-panel.jsp" />
		<!-- end right panel -->
	</div>
	<!-- end content area article -->
	<!-- footer -->
	<jsp:include page="layouts/footer.jsp" />
	<!-- end footer -->
	<!-- #####################javascript#################### -->
	<!-- lib js -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!-- end lib js -->
	<!-- custom js -->
	<script src="js/custom/home.js"></script>
	<script src="js/custom/right-panel.js"></script>
	<!-- end custom js -->
	<!-- fb js -->
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.4&appId=421003251424688";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
	<!-- end fb js -->
	<!-- #####################end javascript#################### -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>news box site...</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="img/box.png" />
<!-- #####################stylesheet#################### -->
<!-- lib css -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- end lib css -->
<!-- custom css -->
<link rel="stylesheet" type="text/css" href="css/custom/index.css">
<link rel="stylesheet" type="text/css" href="css/custom/search.css">
<link rel="stylesheet" type="text/css" href="css/custom/owl.css">
<!-- end custom css -->
<!-- #####################end stylesheet#################### -->
</head>
<body>
	<!-- header -->
	<jsp:include page="layouts/header.jsp" />
	<!-- end header -->
	<!-- content area -->
	<div class="container content-area content-area-search">

		<!-- left panel -->
		<div
			class="col-sm-9 content-left clear-padding-left left-panel">
			<!-- search form -->
			<div class="panel panel-primary container-fluid clear-margin-right">

				<div class="col-sm-6 form-group clear-paddings search-wrapper">
					<input type="text" placeholder="ស្វែងរក..." id="txtsearch-input"
						value="${param['title']}">
					<button class="btn btn-primary" id="btnSubmit">ស្វែងរក</button>
				</div>
				<div class=" form-group col-sm-6">
					<div class="btn-group combo-news">
						<a class="btn btn-default  search-filter" id="showNews" value="">ប្រភពព័ត៌មាន</a>
						<a class="btn btn-default  dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false"><span class="caret"></span></a>
						<!-- category news-->
						<ul class="dropdown-menu" id="lstnewsources"></ul>
						<!--end category news-->
					</div>
					<div class="btn-group combo-news">
						<a class="btn btn-default search-filter" id="showCategory"
							value="">ប្រភេទព័ត៌មាន</a> <a
							class="btn btn-default dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false"><span class="caret"></span></a>
						<!--news source-->
						<ul class="dropdown-menu" id="lstcategory"></ul>
						<!--end news source-->
					</div>
					<div class="btn-group combo-news">
						<a class="btn btn-default search-filter" id="showTime" value="">ពេលវេលា</a>
						<a class="btn btn-default dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false"><span class="caret"></span></a>
						<!--news source-->
						<ul class="dropdown-menu" id="lsttime">
							<li id=''><a href=#>ពេលវេលាណាមួយ</a></li>
							<li id='daily'><a href=#>២៤ ម៉ោងមុន</a></li>
							<li id='weekly'><a href=#>សប្តាហ៍មុន</a></li>
							<li id='monthly'><a href=#>ខែនេះ</a></li>
						</ul>
						<!--end news source-->
					</div>
					<div class="btn-group combo-news">
						<a class="btn btn-default search-filter" id="showItem" value="">ចំនួនលទ្ធផល​ ១០</a>
						<a class="btn btn-default dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false"><span class="caret"></span></a>
						<!--news source-->
						<ul class="dropdown-menu" id="lstItem">
							<li id='10'><a href=#>១០</a></li>
							<li id='20'><a href=#>២០</a></li>
							<li id='50'><a href=#>៥០</a></li>
							<li id='100'><a href=#>១០០</a></li>
						</ul>
						<!--end news source-->
					</div>
				</div>
				<div class="clearfix"></div>

			</div>
			<!-- end search form -->

			<!-- result list -->
			<div class="panel panel-primary col-sm-12 search-result-wrapper">

			</div>
			<!--end result list -->
		</div>
		<!-- end left panel -->
		<!-- right panel -->
		<jsp:include page="layouts/right-panel.jsp" />
		<%-- <jsp:include page="layouts/topfive.jsp" /> --%>
		<!-- end right panel -->
	</div>
	<!-- end content area -->
	<!-- footer -->
	<jsp:include page="layouts/footer.jsp" />
	<!-- end footer -->

	<!-- #####################javascript#################### -->
	​​
	<!-- lib js -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!-- end lib js -->
	<!-- custom js -->
	<script src="js/custom/search.js"></script>
	<script src="js/custom/right-panel.js"></script>
	<!-- end custom js -->
	<!-- #####################end javascript#################### -->
	​​
</body>
</html>

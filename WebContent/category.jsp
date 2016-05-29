<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Controller.FrontEnd.Category.Category"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>news box site...</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link rel="shortcut icon" href="img/box.png">
<!-- lib css -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/responsive.css">
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/owl.theme.css">
<link rel="stylesheet" href="css/responsive.css">
<!-- end lib css -->
<!-- custom css -->
<link rel="stylesheet" type="text/css" href="css/custom/index.css">
<link rel="stylesheet" type="text/css" href="css/custom/category.css">
<!-- end custom css -->
</head>
<body>
  <%session.removeAttribute("admin");%>
  <!-- header -->
  <jsp:include page="layouts/header.jsp" />
	<!-- end header -->
	<!-- content area -->
	<div class="container content-area">
		<!-- search panel -->
		<jsp:include page="layouts/searchbar.jsp" />
		<!-- end search panel -->
		<!-- right panel -->
		<div class="col-md-9 col-sm-9 col-xs-9 clear-padding-left left-panel">
			<!-- article header-->
			<jsp:include page="layouts/category-header.jsp" />
			<div class="panel panel-primary clear-paddings"
				style="margin-top: 16px;">
				<div class="panel-body" id="panelCategory">
					<!-- End of panel body -->					 
					<c:forEach var="record" items="${rs.rows}">					
						<div class='card-1 col-sm-12 clear-paddings' id='${record.news_id}'>
						  <a href='${record.news_path}' target='_blank' >
						    <div class='col-md-4 col-sm-4 col-xs-4 clear-paddings'>  						    
						      <div class='card-1-image' style='background-image: url(${record.news_img}), url(img/404.jpg);' alt='item slider'></div>
						    </div>
						    <div class='col-md-8 col-sm-8 col-xs-8 card-details pull-right '>
						      <h5 class='text-h5-2 article-title' >${record.news_title}</h5>
						      <p class='text-3 news-description' >${record.news_desc}</p>
						      <div class='col-md-12 col-sm-12 col-xs-12 clear-paddings news-info'>អាន ${record.count_visited} | ${record.news_published_date} | ${record.full_name}</div>
						    </div>
						  </a>
						</div>
					</c:forEach>
				  <c:choose>
            <c:when test="${rs.rowCount==15}">
                <ul class='pager clear-padding-right'>
                  <li class='previous'><a href='#' class='btn btn-lg btn-primary' disabled>ទំព័រមុខ</a></li>
                  <li class='next'><a href='#' class='btn btn-lg btn-primary'>ទំព័រក្រោយ</a></li>
                </ul>
            </c:when>
          </c:choose>
				</div>
			</div>
		</div>
		<!-- end right panel -->
		<!-- left panel -->
		<jsp:include page="layouts/right-panel.jsp" />
		<!-- end left panel -->
	</div>
	<!-- end content area -->
	<!-- footer -->
	<jsp:include page="layouts/footer.jsp" />
	<!-- end footer -->
	<!-- #####################javascript#################### -->​
	<!-- lib js -->
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<!-- end lib js -->
	<!-- custom js -->
	<script src="js/custom/right-panel.js"></script>
	<script src="js/custom/count.js"></script>
	<script src="js/custom/default.js"></script>
	<script src="js/custom/category.js"></script>
	<!-- end custom js -->
	<!-- #####################end javascript#################### -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>news box site...</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="img/box.png" />
​​
<!-- lib css -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- end lib css -->
<!-- custom css -->


<!-- end custom css -->

​​
</head>
<body>
	<%
		session.removeAttribute("admin");
	%>​​
	<!-- header -->
	<!-- end header -->
	<!-- content area -->
	<div class="container content-area">
		<div class="col-md-12 col-sm-12 col-xs-12 clear-padding-left left-panel">
			<h3>សូមអធ្យាស្រ័យ  មិនមានទំព័រនេះទេ!</h3>
			<strong>Error 500!</strong>
		</div>
	</div>
	<!-- end content area -->
	<!-- footer -->
	<!-- end footer -->	
	<script type="text/javascript">
	setTimeout(function() { 
	    window.location.href = "home"; 
	 }, 2000);
	</script>​​
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<title>Login</title>
<link href="css/style.default.css" rel="stylesheet">
<style>
body {
	background-image: url(img/wizard-city.jpg);
}
</style>
</head>
<body class="signin">
	<section>
	<div class="panel panel-signin">
		<div class="panel-body">
			<div class="logo text-center">
				<img class="img-responsive"
					style="width: 50%; height: 50%; margin-left: 78px;"
					src="myimage/logo.png">
			</div>
			<br />
			<h4 class="text-center mb5">Login to your account</h4>
			<hr />

			<form role="form-horizontal" method="post" onsubmit="alert('Thank you for your feedback.');">
				<div class="input-group mb15">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span> <input type="text"
						id="username" name="username" class="form-control"
						placeholder="Username">
				</div>
				<div class="input-group mb15">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-lock"></i></span> <input type="password"
						id="password" name="password" class="form-control"
						placeholder="Password">
				</div>
				<div class="form-group ">
					<div class="checkbox col-sm-9">
						<div class="ckbox ckbox-primary mt10">
							<input type="checkbox" id="rememberMe" value="1">&nbsp;&nbsp;
							<label for="rememberMe">Remember Me</label>
						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-success" style="width: 100%;">Login</button>
				<br /> <br />

			</form>

		</div>
		<!-- panel-body -->
	</div>
	<!-- panel --> </section>


	<!---------------------------Load Script-------------------------->
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/custom.js"></script>
	<!-- <script src="js/dashboard.js"></script> -->
	<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="js/dataTables.bootstrap.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>

	<!----------------------------Custom Javascript---------------- -->
</body>

</html>
<%-- <%@page import="jdk.nashorn.internal.ir.RuntimeNode.Request"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<!-- -----------Load Style reponsive----------- -->
<link href="css/style.default.css" rel="stylesheet">
<link href="css/morris.css" rel="stylesheet">
<link href="css/select2.css" rel="stylesheet" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<!-- <link href="https://bootswatch.com/paper/bootstrap.min.css"
	rel="stylesheet" /> -->

<link rel="stylesheet" href="css/dataTables.bootstrap.css" />
<!-- #####################end stylesheet#################### -->
<title>Manage Profile</title>

<style>
input[type="text"]:disabled {
	background: #FFFFFF;
	cursor: text;
}

#path_image {
	background: #FFFFFF;
	cursor: text;
}

input[type=file] {
	background-color: red;
	width: 92px;
	height: 40px;
	position: absolute;
	margin-top: -33px;
	margin-left: -13px;
	opacity: 0;
	cursor: inherit;
}
</style>

</head>
<%
	if (session.getAttribute("usr") != null) {
%>
<body>
	<jsp:include page="layout/header_navibar.jsp"></jsp:include>

	<section>
		<div class="mainwrapper">
			<jsp:include page="layout/menu_left.jsp"></jsp:include>
			<div class="mainpanel">
				<div class="pageheader">
					<div class="media">
						<div class="pageicon pull-left">
							<i class="fa fa-user"></i>
						</div>
						<div class="media-body">
							<ul class="breadcrumb">
								<li><a href="#"><i class="glyphicon glyphicon-user"></i></a></li>
								<li>Profile Page</li>
							</ul>
							<h4>Profile Page</h4>
						</div>
					</div>
					<!-- media -->
				</div>
				<!-- pageheader -->

				<div class="contentpanel">

					<div class="row row-stat">
						<div class="panel panel-info">
							<div class="panel-body">
								<div class="col-sm-8">
									<table class="table">
										<thead>
											<tr>
												<th colspan="2">CONTACT INFORMATION
													<button class="btn btn-success btn-xs delete" id="edit"
														style="margin-left: 60px;" onclick="edit()">
														<i class="fa fa-user"></i>&nbsp;&nbsp;Edit Profile
													</button>
												</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>UserName *</td>
												<td id="listusername"><input type="text" id="fullname"
													name="fullname" class="form-control" disabled required /></td>
											</tr>
											<tr>
												<td>CompanyName *</td>
												<td id="listcompanyname"><input type="text"
													id="companyname" name="companyname" class="form-control"
													disabled required /></td>
											</tr>
											<tr>
												<td>Email *</td>
												<td id="listemail"><input type="text" id="email"
													name="email" class="form-control" disabled required /></td>
											</tr>
											<tr>
												<td>Phone *</td>
												<td id="listphone"><input type="text" id="phone"
													name="phone" class="form-control" disabled required /></td>
											</tr>
											<tr>
												<td>Address *</td>
												<td id="listaddress"><input type="text" id="address"
													name="address" class="form-control" disabled required /></td>
											</tr>
											<tr>
												<td>Website *</td>
												<td id="listwebsite"><input type="text" id="website"
													name="website" class="form-control" disabled required /></td>
											</tr>
										</tbody>
									</table>
								</div>
								<!-- col-sm-8 -->
								<div class="col-sm-4">
									<div class="col-sm-9">
										<form enctype="multipart/form-data">
											<img class="img-responsive" id="img_thumnail" src=" "
												style="border-radius: 50%; width: 150px; height: 150px; border: 3px solid rgba(76, 71, 71, 0.38);"><br />

											<div class="form-group input-group">
												<span class="input-group-addon"><input type="button"
													id="imguploads"
													style="border: 0px; background-color: #EEEEEE;"
													value="Upload" /></span> <input type="text" class="form-control"
													id="path_image" readonly="readonly"> <span
													class="input-group-btn btn btn-default btn-file"
													style="font-size: 14px;"> Browse ... <input
													type="file" name="photo" id="file_image" />
												</span>
											</div>
											<!-- <input
												type="text" class="form-control" id="path_image"
												readonly="readonly" /> <span
												class="btn btn-primary mr5 btn-file"> Browse ... <input
													type="file" name="dataFile" id="file_image" />
											</span> -->
											<input type="button" class="btn btn-primary mr5"
												id="update_profile" value="Update"> <input
												type="button" class="btn btn-danger mr5" id="cancle"
												value="Cancle">
										</form>
									</div>
								</div>
								<!-- col-sm-4 -->
								<div class="col-sm-4 col-sm-offset-8"></div>
							</div>
							<!--  panel-body -->
						</div>
						<!-- panel panel-info -->
					</div>
					<!-- row row-stat -->
				</div>
				<!-- contentpanel -->
			</div>
			<!-- mainpanel -->
		</div>
		<!-- mainwrapper -->
	</section>




	<!---------------------------Load Script-------------------------->
	<script src="js/dashboard.js"></script>
	<script src="js/jquery-1.11.1.min.js"></script>

	<script src="js/bootstrap.min.js"></script>
	<script src="js/custom.js"></script>
	<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="js/dataTables.bootstrap.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>

	<!-- -------------------------Custom Javascript---------------- -->


	<script type="text/javascript"
		src="js/custom/profile_user_validate_and_edit.js"></script>
	<script type="text/javascript">
		var username='<%=session.getAttribute("usr")%>';
		var usercode;
		var fileuploadname;
		jQuery(document).ready(
				function() {
					jQuery("#edit").click(function() {
						jQuery("input[type='text']").attr("disabled", false);

					});
					/* jQuery("#update_profile").click(function() {
						
					}); */

					jQuery("#cancle").click(function() {
						jQuery("input[type='text']").attr("disabled", true);
					});

					$("#file_image").change(function() {
						readURL(this);
						getPath();
						fileuploadname = $("#path_image").val();
					});

					function readURL(input) {
						if (input.files && input.files[0]) {
							var reader = new FileReader();
							reader.onload = function(e) {
								$('#img_thumnail').attr('src', e.target.result)
										.fadeIn('slow');
							};
							reader.readAsDataURL(input.files[0]);
						}
					}
					
					function getPath() {
						$("#path_image").val($("#file_image").val());
					}
		
					jQuery.post("listUserInfo.json",{name:username},function(userinfo){
						loadprofile(userinfo);

					});
				});
		/* End function ready */
		/*Add data to User Detail Profile */
		function loadprofile(userinfo){
		usercode=userinfo[0].user_info_code;
		$("#fullname").val(userinfo[0].full_name);
		$("#companyname").val(userinfo[0].com_name);
		$("#email").val(userinfo[0].email);
		$("#phone").val(userinfo[0].phone);
		$("#address").val(userinfo[0].addr);
		$("#website").val(userinfo[0].website);
		$("#path_image").val(userinfo[0].logo);
		<%-- <%=session.getAttribute("userinfo")%> --%>
		$("#img_thumnail").attr("src", "../img/profile/"+userinfo[0].logo);
		}
		
		/* $.post("listUserInfo.news",function(data){
			
		}); */
		
		/* sarin upload profile picture */
		$("#imguploads").click(function() { 
		///	 $("#file_image").click(function() {
			
			var data;
			<%session.setAttribute("proimag", "profile");%>
			data = new FormData();
			data.append('file', $('#file_image')[0].files[0]);
		 	$.ajax({
				url : 'UploadServlet.json',
				//url : 'UploadProfiel.news',
				data : data,
				type : 'POST',
				processData : false,
				contentType : false,
				success : function(result) {
					$('#path_image').val("upload file success");
					// jQuery('#filename').val(jQuery("#file_image").val()); 
				}
			}); 
		});
		
	/* sarin btn update user info */	
		jQuery("#update_profile").click(function(){
			jQuery("input[type='text']").attr("disabled", true);
				var img = jQuery("#file_image").val().split("\\");
				
				if(img==""){
					//img="no_image.png";
					img=$("#path_image").val();
				}else{
					//img=jQuery("#file_image").val().split("\\");
					img=img[img.length - 1];
				}
				
				jQuery
						.post(
								"udateUserInfo.json",
								{
									//  news_con_detail  
									user_info_code: usercode,
									full_name : $("#fullname").val(),
									companyname :$("#companyname").val(),									
									email : $("#email").val(),
									phone : $("#phone").val(),
									address : $("#address").val(),
									website :$("#website").val(),
								    img_profile :img
								}, function(data,status) {
									loadprofile(data);
									location.reload();
								});
		});
	</script>
</body>
<%
	} else {
%>
<script type="text/javascript">
	window.open("/articleManagement/Admin/index.jsp","_self");
	</script>
<%
	}
%>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="css/dataTables.bootstrap.css" />
<!-- #####################end stylesheet#################### -->

<title>Manage User</title>
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
								<li>User</li>
								<li>Manage</li>
							</ul>
							<h4>ManagerUser</h4>
						</div>
					</div>
					<!-- media -->
				</div>
				<!-- pageheader -->

				<div class="contentpanel">

					<div class="row row-stat">

						<div class="col-md-12">

							<div class="panel panel-info">
								<div class="panel-body">
									<table id="list"
										class="table table-striped table-bordered table-primary mb30"
										cellspacing="0" width="100%">
										<thead>
											<tr>
												<th>User Name</th>
												<th>User Type</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody id="listdetial">
										</tbody>
									</table>
									<button class="btn btn-success btn-xs delete"
										data-toggle="modal" data-target="#myModal">
										<i class="fa fa-user"></i>&nbsp;&nbsp;Create New User
									</button>
								</div>
								<!--  panel-body -->
							</div>
							<!-- panel panel-info -->
						</div>
						<!-- col-md-12 -->
					</div>
					<!-- row row-stat -->

					<div class="row">
						<!--  row model form -->
						<!--Modal Page User ADD-->
						<div class="modal fade" id="myModal" role="dialog">
							<div class="modal-dialog modal-md">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">AddNewUser</h4>
									</div>
									<div class="modal-body">
										<form id="useradd" method="post">
											<div class="panel-body">
												<div class="row">
													<div class="form-group">
														<label class="col-sm-3 control-label">Username <span
															class="asterisk">*</span></label>
														<div class="col-sm-9">
															<input type="text" id="username" name="username"
																class="form-control" placeholder="Type your username..."
																required />
														</div>
													</div>
													<!-- form-group -->

													<div class="form-group">
														<label class="col-sm-3 control-label">Password <span
															class="asterisk">*</span></label>
														<div class="col-sm-9">
															<input type="password" id="password" name="password"
																class="form-control" placeholder="Type your password..."
																autocomplete="off" required /> <br />
															<div class="pwstrength_viewport_progress"></div>
														</div>
													</div>
													<!-- form-group -->

													<div class="form-group">
														<label class="col-sm-3 control-label">Re-password
															<span class="asterisk">*</span>
														</label>
														<div class="col-sm-9">
															<input type="password" id="repassword" name="repassword"
																class="form-control"
																placeholder="Retype your password..." autocomplete="off"
																required />
														</div>
													</div>
													<!-- form-group -->

													<div class="form-group">
														<label class="col-sm-3 control-label">Usertype <span
															class="asterisk">*</span></label>
														<div class="col-sm-5">
															<select class="form-control" id="usertype"
																name="usertype" required>

															</select>
														</div>
													</div>
													<div class="col-sm-9 col-sm-offset-9">
														<input type="submit" class="btn btn-primary mr5"
															id="adduser" value="Add">
													</div>
												</div>
												<!-- row -->
											</div>
											<!-- panel-body -->
										</form>

									</div>
									<!-- modal-body -->
								</div>
								<!-- modal-content -->
							</div>
						</div>
						<!--End Modal Page User ADD-->
					</div>
					<!-- row model form -->
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

	<!-- script for add and list all user -->
	<script type="text/javascript">
	/* Add New User */
	
	</script>
	<!-- script for validate data strength the password  -->
	<script type="text/javascript" src="js/validate/useradd_validate.js"></script>
	<script type="text/javascript" src="js/validate/pwstrength.js"></script>
	<!-- <script src="js/custom/script_manage_user.js"></script> -->
	<script type="text/javascript">
	 /*------------script for focus on menu -------------- */
	 $("#usermenu").removeClass("parent").addClass("active");
	 /* $("#usermenu").addClass("active" ); */
	 $.post("userinfolist.json", function(data) {
	 	$("#listdetial").html(tblistArticle(data));

	 	/* sarin load data table */
	 	$('#list').dataTable({
	 		"lengthMenu" : [ [ 5, 10, 30, -1 ], [ 5, 10, 30, "All" ] ]
	 	});

	 });
	 $.post("usertypelist.json", function(data) {
	 	$("#usertype").html(usertypeDropList(data));
	 });
	 /* Function Add option to select tag */
	 function usertypeDropList(data) {
	 	var str = "";
	 	for (var i = 0; i < data.length; i++) {
	 		str += "<option value=" + data[i].user_type + ">" + data[i].user_type;
	 	}
	 	str += "</optiont>";
	 	return str;
	 }
	 /* Function Create table For listing User */
	 function tblistArticle(data) {
	 	var str = "";
	 	for (var i = 0; i < data.length; i++) {

	 		str += "<tr>" + "<td id=cat_code" + data[i].user_id + ">"
	 				+ data[i].user_name + "</td>" + "<td>" + data[i].user_type
	 				/*+ "</td>" + "<td style='text-align: center;' >" + btnAction(i)*/
	 				+ "</td>" + "<td style='text-align: center;' >" + changestatus(data[i].user_status,data[i].user_id)
	 				+ "</td>" + "</tr>";
	 	}
	 	return str;
	 }
	 /*function btnAction(i) {  sarin edit button to disable and enable 
	 	var btn = "<button class='btn btn-success btn-xs' id='btnenable" + i + "'>"
	 			+ "<i class='fa fa-thumbs-up'></i>"
	 			+ "&nbsp;&nbsp;Enable</button>&nbsp;"
	 			+ "<button class='btn btn-danger btn-xs delete' id='btndisable" + i
	 			+ "'>"
	 			+ "<i class='fa fa-thumbs-down'></i>&nbsp;&nbsp;Disable</button>";
	 	return btn;
	 }*/
	 $("#adduser").click(function() {
	 	var name = $("#username").val();
	 	var pwd = $("#repassword").val();
	 	var usrtype = $("#usertype option:selected").val();
	 	if(name == "" || pwd == "" || usrtype==""){return;}
	 	else{
	 	$.post("useradd.json", {
	 		user_name : name,
	 		user_pass : pwd,
	 		user_type : usrtype
	 	}, function(data, status) {
	 		
	 	});
	 	}
	 	//alert(222);

	 });




	 /* method changestatus for change value to Icon Active  Or Deactive  sarin */	
	 /* Sarin */
	 function changestatus(data,id){ 
	 	var str="";
	 	if(data){
	 		str+="<a style=' cursor:pointer;'><img src='img/t.png' style='width:30px;height:30px' id="+id+" status='"+data+"' user_id='"+id+"' onclick='checkstatus(this)' /></a>";
	 		
	 	}
	 	else{
	 		str+="<a style='cursor:pointer;'><img src='img/f.png' style='width:30px;height:30px' id="+id+" status='"+data+"'  user_id='"+id+"' onclick='checkstatus(this)' /></a>";
	 		
	 	}
	 	return str;
	 } 


	 /*method checkstatus for  upadate status on databases*/
	 var statusAction=true;
	 function checkstatus(data){
	 	
	 	 var status=$(data).attr("status");			 
	 	  var userid=$(data).attr("user_id");
	 	  if(status=="true"){
	 		  $("#"+$(data).attr("id")).attr("src","img/f.png"); 
	 		  $(data).attr("status","false");	
	 		  status="flase";
	 	  }else{
	 		  $("#"+$(data).attr("id")).attr("src","img/t.png");
	 		  $(data).attr("status","true");
	 		  status="true";
	 	  }
	 	 /* if(status){
	 		 status=0;
	 	 }
	 	else{
	 		 status=1;
	 	 } */
	 	//alert(statusAction);
	 	  $.post("editUserstatus.json", {
	 		    user_id : userid,
	 			user_status : status,
	 		}, function(data2,status) {
	 			
	 		});    
	 } 


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
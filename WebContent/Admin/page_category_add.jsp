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

<title>Manage Category</title>

<!-- <link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.5.1/summernote.css"
	rel="stylesheet"> -->

<!--   <style>
    th{text-align: center;}
    @media screen and (max-width: 600px) {
        #tablerepone {
            overflow: scroll;
        }
    }
    </style> -->
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
							<i class="fa fa-edit"></i>
						</div>
						<div class="media-body">
							<ul class="breadcrumb">
								<li><a href="#"><i class="glyphicon glyphicon-edit"></i></a></li>
								<li>Category</li>
							</ul>
							<h4>ManageCategory</h4>
						</div>
					</div>
					<!-- media -->
				</div>
				<!-- pageheader -->

				<div class="contentpanel">

					<div class="row row-stat">
						<div class="col-md-12">
							<div class="panel panel-info">
								<div class="panel-body" id="tablerepone">
									<table id="t_list_category"
										class="table table-striped table-bordered table-primary mb30"
										cellspacing="0" width="100%">
										<thead>
											<tr>
												<th>CategoryName</th>
												<th>CategoryDescription</th>
												<th >Disable</th>
												<th >Action</th>
											</tr>
										</thead>
										<tbody id="show">

										</tbody>
									</table>
									<button class="btn btn-success btn-xs delete"
										data-toggle="collapse" data-target="#demo" id="btntoggle">
										<i class="fa fa-plus"></i>&nbsp;&nbsp;AddNewArticle
									</button>

									<div class="row">
										<!--  row  form -->
										<br />
										<div
											style="width: 100%; height: 1px; background-color: #BCE8F1;"></div>
										<div id="demo" class="collapse">
											<form id="basicForm">
												<div class="panel-body">
													<div class="row">
														<!-- sarin disable cate_code -->
														<div class="form-group" style="display:none;">
															<div class="col-sm-5">
																<input type="text" id="cate_code" name="cate_code"
																	class="form-control" 
																	 />
															</div>
														</div>
														<!-- form-group -->
														
														<div class="form-group">
															<label class="col-sm-2 control-label">NewCategory
																<span class="asterisk">*</span>
															</label>
															<div class="col-sm-5">
																<input type="text" id="cate_name" name="cate_name"
																	class="form-control" placeholder="categoryname"
																	required />
															</div>
														</div>
														<!-- form-group -->

														<div class="form-group">
															<label class="col-sm-2 control-label">Description
																<span class="asterisk">*</span>
															</label>
															<div class="col-sm-5">
																<input type="text" id="cate_desc" name="cate_desc"
																	class="form-control" placeholder="description" required />
															</div>
														</div>
														<!-- form-group -->

														<div class="col-sm-9 col-sm-offset-2">
															<button class="btn btn-primary mr5" id="adduser"
																onClick="addNewCategory();">Add</button>
																<span><input type="button" value="Cancel"
																		class="btn btn-danger" data-toggle="collapse"
																		data-target="#demo" id="btncancel"></span>
														</div>
													</div>
													<!-- row -->
												</div>
												<!-- panel-body -->
											</form>
											<!-- collapse -->
										</div>
										<!--  row  form -->
									</div>
									<!--  panel-body -->
								</div>
								<!-- panel panel-info -->
							</div>
							<!-- col-md-12 -->
						</div>
						<!-- row -->
					</div>
					<!-- contentpanel -->
				</div>
				<!-- mainpanel -->
			</div>
			<!-- mainwrapper -->
		</div>
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
	
	 <script src="js/custom/script_category_add.js"></script> 
	<script src="js/validate/page_category_validate.js"></script><!--  script for validate form add category sarin -->
	<script type="text/javascript">
	var name='<%=session.getAttribute("usr")%>';
	//alert(name);
	/* list categories on page_category_add.jsp */
	
		$.post("pg_cate_tblistcategory.json", {
			full_name : name
		}, function(data) {
			$('#t_list_category').dataTable().fnDestroy();						
			$("#show").html(tblistcategory(data));
			$("#t_list_category").dataTable({
				"lengthMenu" : [ [ 5, 10, 30, -1 ], [ 5, 10, 30, "All" ] ]
			/* Sarin add datatable */
			
			});
		});
	
	function tblistcategory(data) {
		 var str = "";
		for (var i = 0; i < data.length; i++) {
			str += "<tr>" + "<td id=cat_code" + data[i].cat_desc + ">"
					+ data[i].cat_name + "</td>" + "<td>" + data[i].cat_desc
					+ "</td>"+"<td>"+ changestatus(data[i].cat_status,data[i].cat_code) + "</td>" + "<td>" + actionbutton(data[i].cat_code,data[i].cat_name,data[i].cat_desc) + "</td>" + "</tr>";
		}
		return str; 
	}
	
	
	/* sarin actionbutton */
	function actionbutton(cat_code,cat_name,cat_des){
		var btn="<div class='form-group'>";
		btn+="<button type='button' class='btn btn-success' cat_code='"+cat_code+"'  cat_name='"+cat_name+"' cat_des='"+cat_des+"'  onclick='EditOption(this)'>";		
		btn+="Edit</button>";
		return btn;
	}
	
	/* Sarin edit opton */
	function EditOption(data){
		 $("#cate_code").val($(data).attr("cat_code"));
		 $("#cate_name").val($(data).attr("cat_name"));
		 $("#cate_desc").val($(data).attr("cat_code"));
		 
		 $("#btntoggle").click();
		 //$("#demo").addClass("");
		 /* 
		 $("#add").val("Update");
		 $("#add").attr("onclick","update()"); */
	}
	/* sarin btncancel clear value from textbox */
	jQuery("#btncancel").click(function(){
		 $("#cate_code").val("");
		 $("#cate_name").val("");
		 $("#cate_desc").val("");
	});
	
	
	/* method changestatus for change value to Icon Active  Or Deactive  sarin */

	
	function changestatus(data, id) {
		var str = "";
		if (data) {
			str += "<a style=' cursor:pointer;'><img src='img/t.png' style='width:30px;height:30px' id='"+ id + "' status='"+ data+ "' cat_code='"+ id+ "' onclick='checkstatus(this)' /></a>";

		} else {
			str += "<a style=' cursor:pointer;'><img src='img/f.png' style='width:30px;height:30px' id='"+ id + "' status='"+ data+ "' cat_code='"+ id+ "' onclick='checkstatus(this)' /></a>";

		}
		return str;
	}

	/*method checkstatus for  upadate status on databases sarin*/
	
	function checkstatus(data) {

		var status = $(data).attr("status");
		var catcode = $(data).attr("cat_code");
		if (status == "true") {
			$("#" + $(data).attr("id")).attr("src", "img/f.png");
			$(data).attr("status", "false");
			status = "flase";
		} else {
			$("#" + $(data).attr("id")).attr("src", "img/t.png");
			$(data).attr("status", "true");
			status = "true";
		}
		
		$.post("updateCategoryStatus.json", {
			cat_code : catcode,
			cat_status : status,
		}, function(data2, status) {

		});
	} 
	
	
	
	
	
	/* Action Add New Category */
	function addNewCategory() {
		alert("Add new Category")
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
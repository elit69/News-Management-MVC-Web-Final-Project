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

<title>Manage Article</title>
<link href="css/summernote.css" rel="stylesheet">
<!-- style for laout profile -->
<style>
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

@media screen and (max-width: 1000px) {
	.table_respone {
		overflow: scroll;
	}
} /* class for responsive table scrollbar */
</style>
</head>
<%
String usr = "", adm = "";
	adm = session.getAttribute("ust").toString();
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
								<li>Article</li>
							</ul>
							<h4>Managearticle</h4>
						</div>
					</div>
					<!-- media -->
				</div>
				<!-- pageheader -->

				<div class="contentpanel">
					<div class="row row-stat">
						<div class="col-md-12">
							<div class="panel panel-info">
								<div class="panel-heading">LIST ARTICLE POST

									<br />
								</div>
								<div class="panel-body">
								<%if(adm.equals("admin")){ %>								
								<div class="row">
									 <div class="col-lg-3 col-md-4 col-xs-6">
				                          <label>ប្រភពព័ត៏មាន:</label>
				                          <select class="form-control" id="usertype" name="usertype">
				                           				                            
				                          </select>
				                          <br/>
                        			</div>
                        			 <div class="col-lg-3 col-md-4 col-xs-6">
				                          <label>ប្រភេទព័ត៏មាន:</label>
				                          <select class="form-control" id="newscategory"	name="newscategory">
				                            				                            
				                          </select>
				                          <br/>
                        			</div>
                        			 <div class="col-lg-3 col-md-4 col-xs-6">
				                          <label>ពេលវេលា:</label>
				                          <select class="form-control" id="articleDate" name="articleDate">
				                            <option value="">ទាំងអស់</option>					            
				                            <option value="daily">ថ្ងៃនេះ</option>	
				                            <option value="weekly">សបា្តស៏នេះ</option>	
				                            <option value="monthly">ខែនេះ</option>				                            				                         
				                          </select>
				                          <br/>
                        			</div>
									 
								</div>
								<%} %>
								<!-- input-group mb15 -->
								
								
									<div class="table_respone">
										<!-- sarin table list article post -->

										<table id="t_list_data_post"
											class="table table-striped table-bordered table-primary mb30"
											cellspacing="0" width="100%">
											<thead>
												<tr>
													<th style="width: 531px;" >NewsTitle</th>
													<th>NewsCategory</th>
													<th>NewsImage</th>
													<th>NewsDate</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody id="list_post">
									
											</tbody>
										</table>
									</div>
									<!-- table_respone -->



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

	
	<script src="js/validate/page_article_validate.js"></script>
	<!--  script for validate add aticle sarin -->

	

	<!--  script for validate add aticle sarin -->

	<script type="text/javascript">
	
	
		jQuery("#file_image").change(function() {
			readURL(this);
			/* alert(jQuery('#img_thumnail').attr('src'));/* sarin */ 
			jQuery('#filename').val(jQuery("#file_image").val());/* sarin */
			
		});

		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();

				reader.onload = function(e) {
					jQuery('#img_thumnail').attr('src', e.target.result)
							.fadeIn('slow');
				};
				reader.readAsDataURL(input.files[0]);
			}
		}
	</script>

	<script type="text/javascript">
		var name='<%=session.getAttribute("usr")%>';

		
		
		/* sarin admin list all article */ 
		$("#usertype").on('change', function() {
			selectchanged();
		});
		$("#newscategory").on('change', function() {
			selectchanged();
		});
		$("#articleDate").on('change', function() {
			selectchanged();
		});
		/* Select Change by User sarin*/
		function selectchanged() {

			$('#t_list_data_post').dataTable().fnDestroy();
			var user = $("#usertype").val(); //Globel
			var cat_code=$("#newscategory").val();
			var QueryDate=$("#articleDate").val();
			$.post("listArticleAdmin.json", {
				full_name : user,
				cate_code : cat_code,
				news_date : QueryDate
			}, function(data) {
				$("#list_post").html(tblistArticle(data));
				loadDataTable();
				
			});

		}
		
	function loadDataTable(){
		$('#t_list_data_post').dataTable({
				"lengthMenu" : [ [ 5, 10, 30, -1 ], [ 5, 10, 30, "All" ] ]
		<%if(adm.equals("admin")!=true){ %>
				, "columnDefs": [
				                 {
				                     "targets": [ 4 ],
				                     "visible": false,
				                     "searchable": false
				                 }
				                 ]
				        <%} %>
				        
		});
	}
		
		$.post("listarticle.json", {
			full_name : name
		}, function(data) {
			$('#t_list_data_post').dataTable().fnDestroy();
			$("#list_post").html(tblistArticle(data));
			
			
			loadDataTable();
			/* Sarin add datatable */
			
			//alert(data[0].json_title+"/"+data[0].cat_code+"/"+data[0].json_img+"/"+data[0].json_date);
		});

		function tblistArticle(data) {
			var str = "";
			/* alert(data[i].json_status); */
			/* alert(data.length); */
			for (var i = 0; i < data.length; i++) {
				/*compare full_name */
				str += "<tr>"
						+ "<td style='padding-top:29px' id=news_id" + data[i].news_id + ">"
						+ "<a href="+data[i].news_path+" target='_blank' style='text-decoration:none;'>"
						+ data[i].news_title + "</a></td>" + "<td>"
						+ data[i].cat_name + "</td>" + "<td>"
						+ getimage(data[i].news_img) + "</td>" + "<td>"
						+ data[i].news_date + "</td>"
						/*  + "<td style='text-align: center;'>" + btnAction(i)  */
						+ "<td style='text-align: center;'>"
						+ changestatus(data[i].news_status, data[i].news_id, i)
						+ "</td>" + "</tr>";

			}
			return str;
		}
		/* method changestatus for change value to Icon Active  Or Deactive  sarin */

		function changestatus(data, id, i) {
			var str = "";
			if (data) {
				str += "<a style=' cursor:pointer;'><img src='img/t.png' style='width:30px;height:30px' id="
						+ id
						+ " status='"
						+ data
						+ "' news_id='"
						+ id
						+ "' onclick='checkstatus(this)' /></a>";

			} else {
				str += "<a style='cursor:pointer;'><img src='img/f.png' style='width:30px;height:30px' id="
						+ id
						+ " status='"
						+ data
						+ "'  news_id='"
						+ id
						+ "' onclick='checkstatus(this)' /></a>";

			}
			return str;
		}

		/*method checkstatus for  upadate status on databases*/
		var statusAction = true;
		function checkstatus(data) {

			var status = $(data).attr("status");
			var newsid = $(data).attr("news_id");
			if (status == "true") {
				$("#" + $(data).attr("id")).attr("src", "img/f.png");
				$(data).attr("status", "false");
				status = "flase";
			} else {
				$("#" + $(data).attr("id")).attr("src", "img/t.png");
				$(data).attr("status", "true");
				status = "true";
			}
			
			$.post("updateStatus.json", {
				news_id : newsid,
				news_status : status,
			}, function(data2, status) {

			});
		}

		/* ------------Sarin fucntion get image-------- */
		function getimage(data) {
			var str = "";
			if (data.indexOf("http") != -1) {
				str += "<img src="+data+" width=100px/>";
			} else {
				str += "<img src=../"+data+" width=100px/>"; //sarin
			}
			return str;
		}

		 /* DropList user sarin*/
		$.post("sourceDropList.json", function(data) {
			$("#usertype").html(userDropList(data));

		});
		/* DropList user sarin*/
		function userDropList(data) {
			var str = "";
			for (var i = 0; i < data.length; i++) {
				str += "<option value=" + data[i].full_name + ">"
						+ data[i].full_name;
			}
			str += "</optiont>";
			return str;
		}
		
		/* sarin dropdown category */
		$.post("categoryDropList.json", function(data) {
			$("#newscategory").html(categoryDropList(data));
		});
		function categoryDropList(data) {
			var str = "<option value=''>ទាំងអស់</option>";
			for (var i = 0; i < data.length; i++) {
				str += "<option value=" + data[i].cat_code + ">"
						+ data[i].cat_name;
			}
			str += "</optiont>";
			return str;
		}
		
		 	$("#main_menu_article").removeClass("parent" ).addClass("active parent" );
			$("#page_post_article_menu").addClass( "active" );
		
		
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
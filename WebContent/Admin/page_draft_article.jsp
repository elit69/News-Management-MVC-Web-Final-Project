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
	if (session.getAttribute("usr") != null) {
%>
<body>
<%
		session.removeAttribute("proimag");
	%>
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
								<div class="panel-heading">
									LIST DRAFT ARTICLE									
									<button class="btn btn-success btn-xs delete" style="float:right;"
										data-toggle="collapse" data-target="#demo" id="btntoggle"><!-- sarin -->
										<i class="fa fa-plus"></i>
									</button>
									<br />
								</div>
								<div class="panel-body">

									<div class="row">
										<!--  row  form -->
										<form>

										<div id="demo" class="collapse">

											<div class="panel-body">
												<div class="row">

													<div class="col-sm-6">
														<!-- 1..col-sm-6  -->

														<div class="form-group">
															<label class="col-sm-4 control-label">ចំណងជើងព័ត៏មាន
																*</label>
															<div class="col-sm-12">
																<input type="text" id="newstitle" name="newstitle"
																	class="form-control" placeholder="ចំណងជើងព័ត៏មាន"
																	   />
															</div>
														</div>
														<!-- form-group -->
														<div class="form-group" style="display:none;" >
															<div class="col-sm-12">
																<input type="text" id="newsid" name="newsid"
																	class="form-control" placeholder="ចំណងជើងព័ត៏មាន"
																	 />
															</div>
														</div>



														<div class="form-group">
															<label class="col-sm-4 control-label">ប្រភេទនៃព័ត៏មាន​
																*</label>
															<div class="col-sm-12">
																<select class="form-control" id="newscategory"
																	name="newscategory">

																</select>
															</div>
														</div>
														<!-- form-group -->


														<div class="form-group">
															<label class="col-sm-4 control-label">LinkPage</label>
															<div class="col-sm-12">
																<input type="text" id="newspath" name="newspath"
																	class="form-control" placeholder="http://"    />

															</div>
														</div>
														<!-- form-group -->
														<label class="col-sm-4 control-label">រូបភាពរបស់ព័ត៏មាន</label>
														<div class="col-sm-12">
															<div class="form-group input-group">
																<span class="input-group-addon"><input type="button"
																		id="imguploads"
																		style="border: 0px; background-color: #EEEEEE;" value="Upload" /></span>
																<input type="text" class="form-control" id="filename">
																<!-- <span
																class="input-group-btn">
																<button class="btn btn-default" type="button">
																	<i class="fa fa-search"></i>
																	Browse File
																</button>
															</span> -->

																<span class="input-group-btn btn btn-default btn-file"
																	style="font-size: 14px;"> Browse ... <input
																	type="file" name="photo" id="file_image"    />

																</span>


															</div>
														</div>
													</div>
													<!-- col-sm-6 -->
													<div class="col-sm-6">
														<!--2... col-sm-6 -->

														<div class="form-group">
															<label class="col-sm-4 control-label">ពិពណ័នាអំពីព័ត៏មាន</label>
															<div class="col-sm-12">
																<textarea class="form-control" id="news_des"
																	name="news_des" rows="8" class="form-control"
																	placeholder="Description"   ></textarea>
															</div>
														</div>
														<!-- form-group -->

														<div class="col-sm-6 col-sm-offset-2">
															<br />
															<div class="btn btn-group">
																<span><input type="button" class="btn btn-success"
																		id="btn_update_draft" value="Update"></span>
																<span><input type="button" class="btn btn-primary"
																		id="btn_update_post" value="Post"></span> <span><input type="button"
																		class="btn btn-danger" data-toggle="collapse"
																		data-target="#demo" id="btncancel" value="Cancel" /></span>
															</div>
														</div>
													</div>
													<div class="form-group">
														<br /> <label class="col-sm-12 control-label">អំពីព័ត៏មានលំអិត</label>
														<div class="col-sm-12">
															<!--  <textarea class="form-control ckeditor" name="news_con_detail" id="news_con_detail"></textarea> -->
															<!--   <div id="summernote"></div> -->
															<textarea class="form-control" name="news_con_detail"
																id="news_con_detail"></textarea>
														</div>
														
													</div>
													<!-- form-group -->



													<div style="width: 100%; height: 2px; background-color: #BCE8F1;"></div>



												</div>
												<!-- form-group -->



											</div>
											<!-- row -->
										</div>
										<!-- panel-body -->

										<!-- collapse -->
										</form>
									</div>
									<!-- row form -->




									<div class="table_respone">
										
										<!-- sarin table list article draft -->
										<table id="list_article_draft" 
											class="table table-striped table-bordered table-primary mb30" cellspacing="0" width="100%">
											<thead>
												<tr>
													<th>NewsTitleHello</th>
													<th>NewsCategory</th>
													<th>NewsImage</th>
													<th>NewsDate</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody id="list_draft">

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

	
	<!-- <script src="js/validate/page_article_validate.js"></script> -->
	<!--  script for validate add aticle sarin -->

	

	<!--  script for validate add aticle sarin -->

	<script type="text/javascript">
	
	$.getScript('js/summernote_text_editor.js',
			function() {
				$('#news_con_detail').summernote({
					height : 300,
				});
			});
	
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
		var t=0;
		/* sarin list_draft_news.json query from b_vw_draft_news */
		$.post("list_draft_news.json", {
			full_name : name
		}, function(data) {
			$('#list_article_draft').dataTable().fnDestroy();			
			$("#list_draft").html(tblistArticle(data));
			$('#list_article_draft').dataTable({
				"lengthMenu" : [ [ 5, 10, 30, -1 ], [ 5, 10, 30, "All" ] ]
			/* Sarin add datatable */
			});		
			//alert(data[0].json_title+"/"+data[0].cat_code+"/"+data[0].json_img+"/"+data[0].json_date);
		});

		var mydata;
		function tblistArticle(data) {
			mydata=data;
			var str = "";
			/* alert(data[i].json_status); */
			/* alert(data.length); */
			
			 //alert(data[0].json_id + " "+data[0].json_title  + " "+ data[0].cat_name +" "+data[0].json_path +" "+data[0].json_img   + " "+data[0].json_desc + " "+data[0].json_content); 
			for (var i = 0; i < data.length; i++) {
				/*compare full_name */
				if(data[i].news_draft_status){
					str += "<tr>"
						+ "<td style='padding-top:29px' id=news_id" + data[i].news_id + ">"
						+ "<a href="+data[i].news_path+" target='_blank' style='text-decoration:none;'>"
						+ data[i].news_title + "</a></td>" + "<td>"
						+ data[i].cat_name + "</td>" + "<td>"
						+ getimage(data[i].news_img) + "</td>" + "<td>"
						+ data[i].news_date + "</td>"
						+ "<td style='text-align: center;'>"
						/* + changestatus(data[i].news_status, data[i].news_id, i) */
						+ actionbutton(data[i].news_id)//,data[i].news_title,data[i].cat_code,data[i].news_path,data[i].news_img,data[i].news_desc,data[i].news_content)
						+ "</td>" + "</tr>";
				}
				
				
				/* 
				 */

			}
			return str;
		}
		
		
		/* sarin actionbutton */
		
		function actionbutton(news_id){
			//alert(data.news_title);
			var btn="<div class='form-group'>";
			btn+="<button type='button' class='btn btn-success' id='"+news_id+"' onclick='EditOption("+news_id+")'>"; 		
			btn+="<span class='glyphicon glyphicon-edit'></span></button><span style='margin-left:10px'></span>";
			
			return btn;
		}
		
		
		function EditOption(id){
			for(var k=0; k<mydata.length; k++){
				if(id==mydata[k].news_id){
					 $("#newsid").val(mydata[k].news_id);
					 $("#newstitle").val(mydata[k].news_title);
					 $("#newscategory").val(mydata[k].cat_code);
					 $("#newspath").val(mydata[k].news_path);
					 $("#filename").val(mydata[k].news_img);
					 $("#news_des").val(mydata[k].news_desc);
					 $("#news_con_detail").code(mydata[k].news_content); 
				}
			}
			 
			 
			 $("#btntoggle").click();
			 //$("#demo").addClass("");
			 /* 
			 $("#add").val("Update");
			 $("#add").attr("onclick","update()"); */
		}
		/* sarin clear text box */
		jQuery("#btncancel").click(function(){
			 $("#newsid").val("");
			 $("#newstitle").val("");
			 $("#newscategory").val("");
			 $("#newspath").val("");
			 $("#filename").val("");
			 $("#news_des").val("");
			 $("#news_con_detail").code("");
		});
		
		
		/* ------------Sarin fucntion get image-------- */
		function getimage(data) {
			var str = "";
			if (data.indexOf("http") != -1) {
				str += "<img src="+data+" width=100px/>";
			} else {
				str += "<img src=../"+data+" width=100px/>";
			}
			return str;
		}

		/* upload file */
		$("#imguploads").click(function() {
			var data;
			data = new FormData();
			data.append('file', $('#file_image')[0].files[0]);
			$.ajax({
				url : 'UploadServlet.json',
				data : data,
				type : 'POST',
				processData : false,
				contentType : false,
				success : function(result) {
					$('#filename').val("upload file success");
					/* jQuery('#filename').val(jQuery("#file_image").val()); */
				}
			});
		});
		$.post("categoryDropList.json", function(data) {
			$("#newscategory").html(categoryDropList(data));
		});
		function categoryDropList(data) {
			var str = "<option value=''>-------សូមជ្រើសរើសប្រភេទនៃព័ត៏មាន------</option>";
			for (var i = 0; i < data.length; i++) {
				str += "<option value=" + data[i].cat_code + ">"
						+ data[i].cat_name;
			}
			str += "</optiont>";
			return str;
		}
	
		
		
		jQuery("#btn_update_post")
				.click(
						function() {
							//alert(jQuery("#newsid").val());
							 var img = jQuery("#file_image").val().split("\\");
							 if(img==""){
								 img = jQuery("#filename").val();
							 }
							 else{
								 img="img/"+img[img.length - 1];//sarin
							 }
							  jQuery
								.post("update_article.json",
										{
											//  news_con_detail  
											cat_name : jQuery("#newscategory").val(),
											news_id : jQuery("#newsid").val(),
											news_title : jQuery("#newstitle").val(),
											news_desc : jQuery("#news_des").val(),
											news_path : jQuery("#newspath").val(),
											news_img :img,
											
											news_con_detail : jQuery("#news_con_detail").code(),
											draft_status : false,
											
										}, function(data,status) {
											alert("Update "+status);
											window.location.href ="page_post_article.jsp";
										});
							
						
						
						});
		

		jQuery("#btn_update_draft").click(
				function() {
					//alert(jQuery("#newsid").val());
					 var img = jQuery("#file_image").val().split("\\");
					 if(img==""){ 
						 img = jQuery("#filename").val();
					 }
					 else{
						 img="img/"+img[img.length - 1];
					 }
					 
					 jQuery.post("update_article.json",
								{
									//  news_con_detail  
									cat_name : jQuery("#newscategory").val(),
									news_id : jQuery("#newsid").val(),
									news_title : jQuery("#newstitle").val(),
									news_desc : jQuery("#news_des").val(),
									news_path : jQuery("#newspath").val(),
									news_img : img,
									
									news_con_detail : jQuery("#news_con_detail").code(),
									draft_status : true,
									
								}, function(data,status) {
									alert("Update "+status);
									 location.reload();
								}); 
				});
				
		
		$("#main_menu_article").removeClass("parent" ).addClass("active parent" );
		$("#page_draft_article_menu").addClass( "active" );
		
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
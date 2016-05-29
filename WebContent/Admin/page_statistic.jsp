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
<!-- #####################end stylesheet#################### -->

<title>Data Statistic</title>
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
							<i class="glyphicon glyphicon-indent-left"></i>
						</div>
						<div class="media-body">
							<ul class="breadcrumb">
								<li><a href="#"><i class="glyphicon glyphicon-signal"></i></a></li>
								<li>Statistic</li>
							</ul>
							<h4>Statistic News</h4>
						</div>
					</div>
					<!-- media -->
				</div>
				<!-- pageheader -->
				<div class="contentpanel">

					<div class="row row-stat">

						<div class="col-md-12">

							<div class="panel panel-info">
								<h3 style="padding-left: 16px;">Number of article news</h3>
								<div class="panel-body">
									<select id="sl_source1" onChange="selectSource();">
									</select> <select id="sl_time" onChange="selectSource();">
										<option value="day" selected="selected">Daily</option> s
										<option value="week">Weekly</option>
										<option value="month">Monthly</option>

										<option value="year">Yearly</option>

									</select>
									<div id="chartContainerNews"
										style="height: 300px; width: 100%;"></div>
								</div>
								<!--  panel-body -->

							</div>
							<!-- panel panel-info -->
							<div class="panel panel-info">
								<h3 style="padding-left: 16px;">Number of reading, like,
									dislike</h3>
								<div class="panel-body">
									<select id="sl_source2" onChange="filterView();">
									</select> <select id="sl_count" onChange="filterView();">
										<option value="visit" selected="selected">Visited</option>
										<option value="like">Like</option>
										<option value="dislike">Dislike</option>
									</select>
									<div id="chartContainerViewCount"
										style="height: 300px; width: 100%;"></div>
								</div>
								<!--  panel-body -->

							</div>
							<!-- panel panel-info -->
						</div>
						<!-- col-md-12 -->
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
	<script type="text/javascript" src="js/custom/jquery.min.js"></script>
	<script type="text/javascript" src="js/custom/jquery.canvasjs.min.js"></script>
	<!-- -------------------------Custom Javascript---------------- -->

	<!-- script for add and list all user -->
	<script type="text/javascript">
		/*load function filterView for statistic number of views, like, dislike*/

		$.post("sourceDropList.json", function(data) {
			$("#sl_source1").html(sponsorDropList(data));
			$("#sl_source2").html(sponsorDropList(data));
		});

		function filterView() {
			var source = $("#sl_source2 option:selected").val();
			$.post("filterstatisticView.json", {
				sponsor : source
			}, function(data) {
				countChart(data);
			});
		}

		/* Load Chart Graph For view of news */
		
		function countChart(data) {
			var dataPoints = [];
			var sc = $("#sl_source2 option:selected").val();
			var view = $("#sl_count option:selected").val();
			var y = 0;
			for (var i = 0; i < data.length; i++) {
				if (view == "visit") {
					dataPoints.push({
						y : data[i].count_visited,
						label : data[i].cat_name
					});
				} else if (view == "like") {
					dataPoints.push({
						y : data[i].count_news_like,
						label : data[i].cat_name
					});
				} else if (view == "dislike") {
					dataPoints.push({
						y : data[i].count_news_dislike,
						label : data[i].cat_name
					});
				}
			}
			var chart = new CanvasJS.Chart("chartContainerViewCount", {
				animationEnabled : true,
				title : {
					text : "ចំនួននៃការ " + view + " របស់ " + sc
				},
				theme : "theme4",
				data : [ {
					type : "column", //change type to bar, line, area, pie, etc
					dataPoints : dataPoints
				} ]
			});

			chart.render();
		}
	</script>



	<script type="text/javascript">
		function selectSource() {
			filters();
		}
		/* DropList */
		function sponsorDropList(data) {
			var str = "<option select=selected value=" + data[0].full_name + ">"
					+ data[0].full_name;
			for (var i = 1; i < data.length; i++) {
				str += "<option value=" + data[i].full_name + ">"
						+ data[i].full_name;
			}
			str += "</optiont>";
			return str;
		}
		/* DropList */

		function filters() {
			var source = $("#sl_source1 option:selected").val();
			var time = $("#sl_time option:selected").val();
			$.post("filterstatistic.json", {
				sponsor : source,
				anytime : time
			}, function(data) {
				CreatingChart(data);
			});
		}

		/* Load Chart Graph For Number of news */
		//[{"cat_name":"???????????????","count":1}
		function CreatingChart(data) {
			var dataPoints = [];
			var sc = $("#sl_source1 option:selected").val();
			var y = 0;
			for (var i = 0; i < data.length; i++) {
				dataPoints.push({
					y : data[i].count,
					label : data[i].cat_name
				});
			}
			var chart = new CanvasJS.Chart("chartContainerNews", {
				title : {
					text : "ប្រភពសារព័ត៏មាន " + sc
				},
				animationEnabled : true,
				axisY : {
					title : "ចំនួនសរុបនៃសារព័ត៏មាន"
				},
				legend : {
					verticalAlign : "bottom",
					horizontalAlign : "center"
				},
				theme : "theme4",
				data : [

				{
					type : "bar",
					//showInLegend : true,
					//legendMarkerColor : "grey",
					//legendText : "MMbbl = one million barrels",
					dataPoints : dataPoints
				} ]
			});

			chart.render();
		}
	</script>
	<script type="text/javascript" src="js/canvasjs.min.js"></script>
	<!-- script for validate data strength the password  -->
	<script type="text/javascript">
		/* Sarin */
	<%String usr = "", adm = "";

			if (session.getAttribute("admin") != null) {
				usr = session.getAttribute("admin").toString();
				adm = session.getAttribute("userType").toString();
			}%>
		
	<%if (adm.equals("editor") || adm.equals("visitor")) {%>
		window.location.href = "../home.jsp";
	<%}%>
	$("#pg_statistic_menu").removeClass("parent").addClass("active");
	
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
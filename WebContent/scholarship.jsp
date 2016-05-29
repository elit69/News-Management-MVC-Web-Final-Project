<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>news box site...</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" href="img/box.png">
    <!-- lib css -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="css/owl.theme.css">
    <link rel="stylesheet" href="css/responsive.css">
    <!-- end lib css -->
    <!-- custom css -->
    <link rel="stylesheet" type="text/css" href="css/custom/index.css">
    <link rel="stylesheet" type="text/css" href="css/custom/owl.css">
    <link rel="stylesheet" type="text/css" href="css/custom/category.css">
    <link rel="stylesheet" href="css/dataTables.bootstrap.css"/>
    <!-- end custom css -->
    <style type="text/css">
        #listjob_length, #listjob_info {
            padding-left: 10px;
        }
    </style>
</head>
<body>
<%
    session.removeAttribute("usr");
%>
<!-- header -->
<jsp:include page="layouts/header.jsp"/>
<!-- end header -->
<!-- content area -->
<div class="container content-area">
    <!-- search panel -->
    <jsp:include page="layouts/searchbar.jsp"/>
    <!-- end search panel -->
    <!-- right panel -->
    <div class="col-md-9 col-sm-9 col-xs-9 clear-padding-left left-panel">
        <!-- article header-->
        <div class="category-header col-sm-12 clear-paddings"
             style="overflow: hidden !important;">
            <img
                    src="img/scholarships.jpg"
                    height="300px" width="100%" alt="Mirror Edge">

            <div class="category-title "
                 style="position: absolute; width: 94%; bottom: 7%; overflow: hidden; left: 3%; height: 89px; background-color: #50a253; opacity: 0.97;">
                <h4 class="article-name" style="color: #FFE4F4; font-size: 30px;">អាហារូបករណ៏</h4>
            </div>
        </div>
        <div class="panel panel-primary col-sm-12 clear-paddings"
             style="margin-top: 16px;">

            <div class="panel-body" id="panelCategory" style="overflow-x: auto">
                <table id="listjob"
                       class="table table-condensed table-responsive table-hover table-bordered table-primary mb30"
                       cellspacing="0" width="100%" style="margin:10px;">
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Date Posted</th>
                        <th>Deadline</th>
                    </tr>
                    </thead>
                    <tbody id="tbscholarship">
                    </tbody>
                </table>
            </div>
            <!-- End of panel body -->
        </div>
    </div>
    <!-- end right panel -->
    <!-- left panel -->
    <jsp:include page="layouts/right-panel.jsp"/>
    <!-- end left panel -->
</div>
<!-- end content area -->
<!-- footer -->
<jsp:include page="layouts/footer.jsp"/>
<!-- end footer -->
<!-- #####################javascript#################### -->
<!-- lib js -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<!-- end lib js -->
<!-- custom js -->
<script src="js/custom/owl.js"></script>
<script src="js/custom/right-panel.js"></script>
<script src="js/custom/scholarship.js"></script>

<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.js"></script>
<!-- end custom js -->
<!-- #####################end javascript#################### -->
</body>
</html>
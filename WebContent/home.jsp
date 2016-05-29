<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>News Box</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" href="img/box.png"/>
    <!-- lib css -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="css/owl.theme.css">
    <link rel="stylesheet" href="css/responsive.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <!-- end lib css -->
    <!-- custom css -->
    <link rel="stylesheet" type="text/css" href="css/custom/index.css">
    <link rel="stylesheet" type="text/css" href="css/custom/slider.css">
    <link rel="stylesheet" type="text/css"
          href="css/custom/bottom-slider.css">
    <link rel="stylesheet" type="text/css"
          href="css/custom/left-sidebar-button.css">
    <!-- end custom css -->
</head>
<body>
<%
    session.removeAttribute("usr");
    session.removeAttribute("ust");
    session.removeAttribute("uif");
%>
<!-- header -->
<jsp:include page="layouts/header.jsp"/>
<!-- end header -->
<!-- content area -->
<jsp:include page="layouts/left-sidebar-button.jsp"/>
<div class="container content-area">
    <!-- search panel -->
    <jsp:include page="layouts/searchbar.jsp"/>
    <!--end search panel -->
    <!-- right panel -->
    <div class="col-md-9 col-sm-9 col-xs-9 clear-padding-left left-panel">
        <!-- slider -->
        <jsp:include page="layouts/slider.jsp"/>
        <!-- end slider -->
        <!-- news sections -->
        <!-- Social News -->
        <div class="panel panel-primary" id="localnews-scroll">
            <div class="panel-heading">
                <a href="category?id=B030101"><h3 class="panel-title"
                                                  id="title-panel">ព័ត៌មានជាតិទូទៅ</h3></a>

                <div class="btn-group">
                    <a class="btn cate-date-filter" id="showLocal">ប្រចាំខែ</a> <a
                        href="#" class="dropdown-toggle btn-date" data-toggle="dropdown"
                        aria-expanded="false"><span class="glyphicon glyphicon-list"></span></a>
                    <!-- category news-->
                    <ul class="dropdown-menu" id="listLocal">
                        <li value="day"><a>ប្រចាំថ្ងៃ</a></li>
                        <li value="week"><a>ប្រចាំសប្តាស៍</a></li>
                        <li value="month"><a>ប្រចាំខែ</a></li>
                    </ul>
                    <!--end category news-->
                </div>

            </div>
            <div class="panel-body" id="panelBody_cam"></div>
            <!-- End of panel body -->
        </div>

        <div class="panel panel-primary" id="technews-scroll">
            <div class="panel-heading">
                <a href="category?id=B010105"><h3 class="panel-title"
                                                  id="title-panel">បច្ចេកវិទ្យា</h3></a>

                <div class="btn-group">
                    <a class="btn cate-date-filter" id="showTech">ប្រចាំខែ</a> <a
                        class="dropdown-toggle btn-date" data-toggle="dropdown"
                        aria-expanded="false"><span class="glyphicon glyphicon-list"></span></a>
                    <!-- category news-->
                    <ul class="dropdown-menu" ​ id="listTech">
                        <li value="day"><a>ប្រចាំថ្ងៃ</a></li>
                        <li value="week"><a>ប្រចាំសប្តាស៍</a></li>
                        <li value="month"><a>ប្រចាំខែ</a></li>
                    </ul>
                    <!--end category news-->
                </div>
            </div>
            <div class="panel-body" id="panelBody_tech"></div>
            <!-- End of panel body -->
        </div>
        <div class="panel panel-primary" id="sportnews-scroll">
            <div class="panel-heading">
                <a href="category?id=B020201"><h3 class="panel-title"
                                                  id="title-panel">កីឡា</h3></a>

                <div class="btn-group">
                    <a class="btn cate-date-filter" id="showSport">ប្រចាំខែ</a> <a
                        href="#" class="dropdown-toggle btn-date" data-toggle="dropdown"
                        aria-expanded="false"><span class="glyphicon glyphicon-list"></span></a>
                    <!-- category news-->
                    <ul class="dropdown-menu" id="listSport">
                        <li value="day"><a>ប្រចាំថ្ងៃ</a></li>
                        <li value="week"><a>ប្រចាំសប្តាស៍</a></li>
                        <li value="month"><a>ប្រចាំខែ</a></li>
                    </ul>
                    <!--end category news-->
                </div>
            </div>
            <div class="panel-body" id="panelBody_sport"></div>
            <!-- End of panel body -->
        </div>
        <div class="panel panel-primary" id="knowledgenews-scroll">
            <div class="panel-heading">
                <a href="category?id=B020501"><h3 class="panel-title"
                                                  id="title-panel">ចំនេះដឺង</h3></a>

                <div class="btn-group">
                    <a class="btn cate-date-filter" id="showKnowledge">ប្រចាំខែ</a> <a
                        href="#" class="dropdown-toggle btn-date" data-toggle="dropdown"
                        aria-expanded="false"><span class="glyphicon glyphicon-list"></span></a>
                    <!-- category news-->
                    <ul class="dropdown-menu" ​ id="listKnowledge">
                        <li value="day"><a>ប្រចាំថ្ងៃ</a></li>
                        <li value="week"><a>ប្រចាំសប្តាស៍</a></li>
                        <li value="month"><a>ប្រចាំខែ</a></li>
                    </ul>
                    <!--end category news-->
                </div>
            </div>
            <div class="panel-body" id="panelBody_knowledge"></div>
            <!-- End of panel body -->
        </div>
        <div class="panel panel-primary" id="socialnews-scroll">
            <div class="panel-heading">
                <a href="category?id=B030102"><h3 class="panel-title"
                                                  id="title-panel">សង្គម</h3></a>

                <div class="btn-group">
                    <a class="btn cate-date-filter" id="showSocial">ប្រចាំខែ</a> <a
                        href="#" class="dropdown-toggle btn-date" data-toggle="dropdown"
                        aria-expanded="false"><span class="glyphicon glyphicon-list"></span></a>
                    <!-- category news-->
                    <ul class="dropdown-menu" id="listSocial">
                        <li value="day"><a>ប្រចាំថ្ងៃ</a></li>
                        <li value="week"><a>ប្រចាំសប្តាស៍</a></li>
                        <li value="month"><a>ប្រចាំខែ</a></li>
                    </ul>
                    <!--end category news-->
                </div>
            </div>
            <div class="panel-body" id="panelBody_social"></div>
            <!-- End of panel body -->
        </div>
        <div class="panel panel-primary" id="economicnews-scroll">
            <div class="panel-heading">
                <a href="category?id=B030401"><h3 class="panel-title"
                                                  id="title-panel">សេដ្ឋកិច្ច</h3></a>

                <div class="btn-group">
                    <a class="btn cate-date-filter" id="showEconomy">ប្រចាំខែ</a> <a
                        href="#" class="dropdown-toggle btn-date" data-toggle="dropdown"
                        aria-expanded="false"><span class="glyphicon glyphicon-list"></span></a>
                    <!-- category news-->
                    <ul class="dropdown-menu" id="listEconomy">
                        <li value="day"><a>ប្រចាំថ្ងៃ</a></li>
                        <li value="week"><a>ប្រចាំសប្តាស៍</a></li>
                        <li value="month"><a>ប្រចាំខែ</a></li>
                    </ul>
                    <!--end category news-->
                </div>
            </div>
            <div class="panel-body" id="panelBody_economy"></div>
            <!-- End of panel body -->
        </div>
        <div class="panel panel-primary" id="entertainmentnews-scroll">
            <div class="panel-heading">
                <a href="category?id=B020302"><h3 class="panel-title"
                                                  id="title-panel">សិល្បៈកម្សាន្ត</h3></a>

                <div class="btn-group">
                    <a class="btn cate-date-filter" id="showEnterain">ប្រចាំខែ</a> <a
                        href="#" class="dropdown-toggle btn-date" data-toggle="dropdown"
                        aria-expanded="false"><span class="glyphicon glyphicon-list"></span></a>
                    <!-- category news-->
                    <ul class="dropdown-menu" id="listEnterain">
                        <li value="day"><a>ប្រចាំថ្ងៃ</a></li>
                        <li value="week"><a>ប្រចាំសប្តាស៍</a></li>
                        <li value="month"><a>ប្រចាំខែ</a></li>
                    </ul>
                    <!--end category news-->
                </div>
            </div>
            <div class="panel-body" id="panelBody_entertainment"></div>
            <!-- End of panel body -->
        </div>
        <div class="panel panel-primary" id="lifeandjobsnews-scroll">
            <div class="panel-heading">
                <a href="#"><h3 class="panel-title" id="title-panel">ជីវិត
                    និងការងារ</h3></a>

                <div class="btn-group">
                    <a class="btn cate-date-filter" id="showLifeandJobs">ប្រចាំខែ</a>
                    <a href="#" class="dropdown-toggle btn-date"
                       data-toggle="dropdown" aria-expanded="false"><span
                            class="glyphicon glyphicon-list"></span></a>
                    <!-- category news-->
                    <ul class="dropdown-menu" id="listlifeandjobs">
                        <li value="day"><a>ប្រចាំថ្ងៃ</a></li>
                        <li value="week"><a>ប្រចាំសប្តាស៍</a></li>
                        <li value="month"><a>ប្រចាំខែ</a></li>
                    </ul>
                    <!--end category news-->
                </div>
            </div>
            <div class="panel-body" id="panelBody_lifeandjob"></div>
            <!-- End of panel body -->
        </div>
        <!-- end news sections -->
    </div>
    <!-- end right panel -->
    <!-- left panel -->
    <jsp:include page="layouts/right-panel.jsp"/>
    <!-- end left panel -->
    <a id="btn-show"><i class="fa fa-caret-square-o-right"></i></a>
</div>

<!-- end content area -->
<!-- footer -->
<jsp:include page="layouts/footer.jsp"/>
<!-- end footer -->
<!-- #####################javascript#################### -->
<!-- lib js -->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.cookie.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<!-- end lib js -->
<!-- custom js -->
<script src="js/custom/right-panel.js"></script>
<script src="js/custom/default.js"></script>
<script src="js/custom/home.js"></script>
<script src="js/custom/count.js"></script>
<script src="js/custom/collusion.js"></script>
<!-- end custom js -->
<!-- #####################end javascript#################### --></body>
</html>
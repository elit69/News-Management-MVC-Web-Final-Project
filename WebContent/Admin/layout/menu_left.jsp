
<%
	String usr = "", adm = "";

	if (session.getAttribute("usr") != null) {
		usr = session.getAttribute("usr").toString();
		adm = session.getAttribute("ust").toString();
	}
%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<div class="leftpanel">
	<div class="media profile-left">
		<a class="pull-left profile-thumb" href="page_user_profile.jsp"> <img
			class="img-circle" src="" id="pic_profile" alt="">
		</a>
		<div class="media-body">
			<h4 class="media-heading" id="username_profile"><%=usr%></h4>
			<!-- Title Name for user  -->
			<small class="text-muted" id="user_type_profile"><%=adm%></small>
		</div>
	</div>
	<!-- media -->

	<h5 class="leftpanel-title" id="d">Navigation</h5>
	<%
		if (adm.equals("editor")) {
	%>
	<ul class="nav nav-pills nav-stacked">
		<li id="index_dashboard_menu"><a href="index.jsp"><i
				class="fa fa-home"></i> <span>Dashboard</span></a></li>
		<li id="sub_menu_managearticle"><a href="page_article_add.jsp"><i
				class="fa fa-edit"></i> <span>Add Article</span></a>
		<li id="page_post_article_menu"><a href="page_post_article.jsp"><i
				class="fa fa-list"></i> <span>List Posted Article</span></a>
		<li id="page_draft_article_menu"><a href="page_draft_article.jsp"><i
				class="fa fa-file-text-o"></i> <span>List Draft Article</span></a>
	</ul>
	<%
		}
	%>
	<%
		if (adm.equals("admin")) {
	%>
	<ul class="nav nav-pills nav-stacked">
		<li id="index_dashboard_menu"><a href="index.jsp"><i
				class="fa fa-home"></i> <span>Dashboard</span></a></li>
		<!--  <li><a href="messages.html"><span class="pull-right badge">5</span><i class="fa fa-envelope-o"></i> <span>Messages</span></a></li> -->
		<li class="parent" id="main_menu_article"><a href="#"><i
				class="fa fa-edit"></i> <span>Article</span></a>
			<ul class="children">
				<!-- sarin update menu article -->
				<li id="sub_menu_managearticle"><a href="page_article_add.jsp">Add
						Article</a></li>
				<li id="page_post_article_menu"><a href="page_post_article.jsp">List
						Post Article</a></li>
				<li id="page_draft_article_menu"><a
					href="page_draft_article.jsp">List Draft Article</a></li>
				<li id="sub_menu_managecategory"><a
					href="page_category_add.jsp">Manage Category</a></li>

			</ul></li>

		<li id="usermenu"><a href="page_user_add.jsp"><i
				class="fa fa-user"></i> <span>User</span></a></li>
		<li id="pg_statistic_menu"><a href="page_statistic.jsp"><i
				class="glyphicon glyphicon-signal"></i> <span>Statistic</span></a></li>
		<!-- <li id="usermenu" class="parent"><a href=""><i
				class="glyphicon glyphicon-cog"></i> <span>Setting</span></a>
			<ul class="children">
				<li id="sub_menu_managearticle"><a href="#">Sponsors</a></li>
				<li id="sub_menu_managecategory"><a href="#">Categories</a></li>
				<li id="sub_menu_managecategory"><a href="#">News</a></li>
				<li id="sub_menu_managecategory"><a href="#">Panel</a></li>
			</ul></li> -->
		<!--  <li class="parent"><a href="#"><i class="fa fa-align-justify"></i> <span>Menus</span></a>
                            <ul class="children">
                                <li><a href="#">Addmenu</a></li>
                                <li><a href="#">Managemenu</a></li>
                            </ul>
                        </li> -->
		<!--  <li><a href="#"><i class="fa fa-align-justify"></i> <span>Menus</span></a></li> -->
	</ul>
	<%
		}
	%>
</div>
<!--  leftpanel -->
<script type="text/javascript">
	var obj =
<%=session.getAttribute("uif")%>
	$("#pic_profile").attr("src", "../img/profile/"+obj[0].logo);
	$("#img_thumnail").attr("src", obj[0].logo);
	//alert(obj[0].logo);
</script>
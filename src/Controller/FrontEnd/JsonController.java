package Controller.FrontEnd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.FrontEnd.Home.*;
import Controller.FrontEnd.News.ListArticleAdmin;
import Controller.FrontEnd.News.ListNews;
import Controller.FrontEnd.News.countNews;
import Controller.FrontEnd.News.filterstatisticviewByAccount;
import Controller.BackEnd.FileUpload;
import Controller.BackEnd.filterstatistic;
import Controller.BackEnd.filterstatisticView;
import Controller.BackEnd.typeofarticlespost;
import Controller.BackEnd.updateStatus;
import Controller.BackEnd.Article.AddNews;
import Controller.BackEnd.Article.ListNewsDraft;
import Controller.BackEnd.Article.update_full_article;
import Controller.BackEnd.Category.ListCategory;
import Controller.BackEnd.Category.dropListCategory;
import Controller.BackEnd.Category.dropListSource;
import Controller.BackEnd.Category.updateCategoryStatus;
import Controller.BackEnd.User.AddUser;
import Controller.BackEnd.User.EditStatus;
import Controller.BackEnd.User.ListUser;
import Controller.BackEnd.UserInfo.EditUserInfo;
import Controller.BackEnd.UserInfo.ListUserInfo;
import Controller.BackEnd.UserInfo.ListUserInfoByName;
import Controller.Filter.Login;
//import Controller.Filter.Login;
import Controller.FrontEnd.Category.*;
import Controller.FrontEnd.Scrap.listexchange;
import Controller.FrontEnd.Scrap.listjobs;
import Controller.FrontEnd.Scrap.listscholarship;
import Controller.FrontEnd.Search.categorylistwithcode;
import Controller.FrontEnd.Search.listResult;
import Controller.FrontEnd.Search.sourcelistwithcode;
import Utilities.Logger;

/**
 * Servlet implementation class JsonController
 */
public class JsonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(HttpServletRequest request, HttpServletResponse response){
		
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JsonController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Logger.setPath(request.getSession().getServletContext().getRealPath("/"));
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		//System.out.println(RequestURI);
		/*
		 * System.out.println(contextPath); System.out.println("--" + command);
		 */
		System.err.println("requesting : ["+command+"]");
		switch (command) {
		case "/listResult.json":
			action = new listResult();
			break;
		/* page_scholarship_list.jsp */

		case "/scholarlist.json":
			action = new listscholarship();
			break;
		/* panel list exchange */
		case "/listexchange.json":
			action = new listexchange();
			break;
		/* page_list_job.jsp */
		case "/joblist.json":
			action = new listjobs();
			break;
		/*
		 * case "/listallnews.json": action = new ListAllNews(); break;
		 */
		case "/recentnews.json":
			action = new ListRecentNews();
			break;
		case "/countview.json":
			action = new countView();
			break;
		/* sourcelistwithcode.json */
		case "/sourcelistwithcode.json":
			action = new sourcelistwithcode();
			break;
		/* categorylistwithcode */
		case "/categorylistwithcode.json":
			action = new categorylistwithcode();
			break;
		case "/listnewscategorybydaily.json":
			action = new ListNewsCategoryByDaily();
			break;
		case "/listnewscategorybyweekly.json":
			action = new ListNewsCategoryByWeekly();
			break;
		case "/listnewscategorybymonthly.json":
			action = new ListNewsCategoryByMonthly();
			break;

		/*-------------Bo Add New Case---------------*/
		case "/getrecommendnews.json":
			action = new RecommendNews();
			break;
		case "/getpopularnews.json":
			action = new PopularNews();
			break;

		/*--------------End of New Case--------------*/
		/*-------------------New Case Add----------------------*/
		case "/countNewsByCatCodeDaily.json":
			action = new CountNewsByCatCodeDaily();
			break;
		case "/countNewsByCatCodeWeekly.json":
			action = new CountNewsByCatCodeWeekly();
			break;
		case "/countNewsByCatCodeMonthly.json":
			action = new CountNewsByCatCodeMonthly();
			break;
		case "/showNewsCategoryTop.json":
			action = new ShowNewsCategoryTop();
			break;
		/*-----------------End of New Case--------------------*/

		/* Pisal */
		case "/Admin/useradd.json":
			action = new AddUser();
			break;
		case "/Admin/usertypelist.json":
			action = new ListUser();

			break;

		// access to userinfo url
		case "/Admin/userinfolist.json":
			action = new ListUserInfo();

			break;

		// access to category url
		case "/Admin/pg_cate_tblistcategory.json":

			action = new ListCategory();

			break;

		 //End Case : Category Insert 
		case "/Admin/categoryDropList.json":

			action = new dropListCategory();

			break;

		case "/Admin/sourceDropList.json":
			action = new dropListSource();

			break;

		// for update userinfo sarin 
		case "/Admin/udateUserInfo.json":
			action = new EditUserInfo();

			break;

		// for update full Atricle sarin 
		case "/Admin/update_article.json":
			action = new update_full_article();

			break;

		// for update category Status sarin 
		case "/Admin/updateCategoryStatus.json":
			action = new updateCategoryStatus();

			break;

		// for update status sarin 
		case "/Admin/updateStatus.json":
			action = new updateStatus();

			break;

		// sarin edit user status 
		case "/Admin/editUserstatus.json":
			action = new EditStatus();

			break;
		
			/*sarin listArticleAdmin.json */
		case "/Admin/listArticleAdmin.json":

			action = new ListArticleAdmin();

			break;

		case "/Admin/listarticle.json":

			action = new ListNews();

			break;

		// sarin list_draft_news.json query from b_vw_draft_news 
		case "/Admin/list_draft_news.json":

			action = new ListNewsDraft();

			break;
	//	 sarin listuserinfo 
		case "/Admin/listUserInfo.json":

			action = new ListUserInfoByName();

			break;

		case "/Admin/counts.json":
			action = new countNews();

			break;
		case "/Admin/selectTypeArticles.json":
			action = new typeofarticlespost();

			break;
		case "/Login.json":
			
			action = new Login();

			break;

	//	 Add Article 
		case "/Admin/addarticle.json":
			action = new AddNews();

			break;

		// File Upload 
		case "/Admin/UploadServlet.json":
			action = new FileUpload();
			System.out.println("-------Upload Photo------");

			break;

		// Statistic News 
		case "/Admin/filterstatistic.json":
			action = new filterstatistic();

			break;
		// Statistic Number of view,like,dislike 
		case "/Admin/filterstatisticView.json":
			action = new filterstatisticView();

			break;

		// Statistic Number of view by Account 
		case "/Admin/filterstatisticViewByAccount.json":
			action = new filterstatisticviewByAccount();

			break;
		
		default:
			forward = new ActionForward();
			forward.setPath("404.jsp");
			forward.setRedirect(true);
			break;
		}
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		try {
			action.execute(request, response);
		} catch (Exception e) {
			Logger.writeLogException(e, "Switch Case", "JsonController");
		}
	}
}

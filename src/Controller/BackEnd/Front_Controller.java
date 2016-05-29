/*package Controller.BackEnd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.BackEnd.Article.AddNews;
import Controller.BackEnd.Article.ListNewsDraft;
import Controller.BackEnd.Article.update_full_article;
import Controller.BackEnd.Category.*;
import Controller.BackEnd.User.*;
import Controller.BackEnd.UserInfo.*;
import Controller.Filter.*;
import Controller.FrontEnd.News.*;
import Utilities.Logger;

//import Model.userDAO;

@WebServlet("*.json")
public class Front_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Front_Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String RequestURI = request.getRequestURI();

		System.out.println(RequestURI);
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		System.out.println("--" + command);

		switch (command) {
		// access to user url
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
		case "/Login/Login.json":

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
		}// End of switch;

		try {
			action.execute(request, response);
		} catch (Exception e) {
			Logger.writeLogException(e, request.getContextPath(), response.getContentType());
		}
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}

		}
	}
}
*/
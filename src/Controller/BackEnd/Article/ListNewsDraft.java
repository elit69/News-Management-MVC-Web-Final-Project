package Controller.BackEnd.Article;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.FrontEnd.Action;
import Model.BackEndDAO.NewsDAO;
import Utilities.Convertor;

public class ListNewsDraft implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String name=request.getParameter("full_name");
		String news_List_draft=Convertor.convertResultSetIntoJSON(new NewsDAO().list_News_draft(name)).toString();
		//System.out.println(news_List_draft);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(news_List_draft);

	}

}

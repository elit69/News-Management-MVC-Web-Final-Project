package Controller.FrontEnd.News;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.FrontEnd.Action;
import Model.BackEndDAO.NewsDAO;
import Utilities.Convertor;

public class ListArticleAdmin implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String name=request.getParameter("full_name");
		String cate_code=request.getParameter("cate_code");
		String news_date=request.getParameter("news_date");
		String newsList=Convertor.convertResultSetIntoJSON(new NewsDAO().showArticleAdmin(name,cate_code,news_date)).toString();
		//System.out.println(newsList);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(newsList);
	}

}

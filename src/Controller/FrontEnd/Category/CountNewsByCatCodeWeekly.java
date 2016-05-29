package Controller.FrontEnd.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.FrontEnd.Action;
import Model.FrontEndDAO.NewsDAO;
import Utilities.Convertor;

public class CountNewsByCatCodeWeekly implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String categoryCode = request.getParameter("categoryCode");
		NewsDAO dao = new NewsDAO();
		String newsList=Convertor.convertResultSetIntoJSON(dao.countNewsByCatCodeWeekly(categoryCode)).toString();
		dao.close();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(newsList);
	}
	
}

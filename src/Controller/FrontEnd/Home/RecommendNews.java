package Controller.FrontEnd.Home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.FrontEnd.Action;
import Model.FrontEndDAO.NewsDAO;
import Utilities.Convertor;

public class RecommendNews implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		NewsDAO dao = new NewsDAO();
		String newsList=Convertor.convertResultSetIntoJSON(dao.getRecommendNews()).toString();
		dao.close();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(newsList);
	}

}

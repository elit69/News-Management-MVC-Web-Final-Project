package Controller.FrontEnd.Home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.FrontEnd.Action;
import Model.FrontEndDAO.NewsDAO;
import Utilities.Convertor;
import Utilities.Logger;

public class ListRecentNews implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		NewsDAO dao = new NewsDAO();
		String newsList;
		try {
			newsList = Convertor.convertResultSetIntoJSON(dao.listRecentNews(5)).toString();
			dao.close();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(newsList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Logger.writeLogException(e, "listRecentNews", "Servlet for List Recent News");
		}

	}

}

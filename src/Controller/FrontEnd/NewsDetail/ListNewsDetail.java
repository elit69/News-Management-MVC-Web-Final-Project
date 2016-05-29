package Controller.FrontEnd.NewsDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.BackEnd.Action;
import Model.BackEndDAO.NewsDetailDAO;
import Utilities.Convertor;

import com.google.gson.Gson;

public class ListNewsDetail implements Action {
	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		/* newsList stores records of news as JSON data */
		String newsList = Convertor.convertResultSetIntoJSON(new NewsDetailDAO().retrieveRS()).toString(); 
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		/* Response JSON data to client */
		response.getWriter().write(newsList);
	}
}

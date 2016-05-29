package Controller.FrontEnd.News;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.BackEnd.Action;
import Model.BackEndDAO.NewsDAO;
import Utilities.Convertor;

public class ListAllNews implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String newsList=Convertor.convertResultSetIntoJSON(new NewsDAO().listAllNews()).toString();
		//System.out.println(newsList);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(newsList);
		//System.out.println(newsList);
	}

}

package Controller.FrontEnd.News;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.FrontEnd.Action;
import Model.BackEndDAO.NewsDAO;
import Utilities.Convertor;

public class countNews implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String countList=Convertor.convertResultSetIntoJSON(new NewsDAO().countOfRecords()).toString();
		//System.out.println(countList);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(countList);
	}

}

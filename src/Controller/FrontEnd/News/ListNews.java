package Controller.FrontEnd.News;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Controller.FrontEnd.Action;
import Model.BackEndDAO.NewsDAO;
import Utilities.Convertor;

public class ListNews implements Action {

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name=request.getParameter("full_name");
		
		String newsList=Convertor.convertResultSetIntoJSON(new NewsDAO().showartilcebyname(name)).toString();
		//System.out.println(newsList);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(newsList);
		
	}

}//End of class;










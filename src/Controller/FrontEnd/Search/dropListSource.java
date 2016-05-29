package Controller.FrontEnd.Search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.FrontEnd.Action;
import Model.FrontEndDAO.CategoryDAO;
import Utilities.Convertor;

public class dropListSource implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		/* categoryList stores records of news as JSON data */
		String droplistsource =Convertor.convertResultSetIntoJSON(new CategoryDAO().resourceList()).toString(); 
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		/* Response JSON data to client */
		response.getWriter().write(droplistsource);
		//System.out.println(droplistsource);

	}

}

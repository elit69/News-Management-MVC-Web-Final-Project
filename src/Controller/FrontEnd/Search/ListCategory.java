package Controller.FrontEnd.Search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Controller.FrontEnd.Action;
import Model.FrontEndDAO.CategoryDAO;
import Utilities.Convertor;

public class ListCategory implements Action {

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		/* categoryList stores records of news as JSON data */
		String fullname=request.getParameter("full_name");
		//System.out.println(fullname);
		String categoryList = Convertor.convertResultSetIntoJSON(new CategoryDAO().manageCatUser(fullname)).toString(); 
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		/* Response JSON data to client */
		response.getWriter().write(categoryList);
		//System.out.println(categoryList);
	}

}

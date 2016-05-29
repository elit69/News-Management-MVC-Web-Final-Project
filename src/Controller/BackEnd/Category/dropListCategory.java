package Controller.BackEnd.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.FrontEnd.Action;
import Model.BackEndDAO.CategoryDAO;
import Utilities.Convertor;

public class dropListCategory implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		/* categoryList stores records of news as JSON data */
		String categoryNameList = Convertor.convertResultSetIntoJSON(new CategoryDAO().categoryNameList()).toString(); 
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		/* Response JSON data to client */
		response.getWriter().write(categoryNameList);
		//System.out.println(categoryNameList);
	}

}

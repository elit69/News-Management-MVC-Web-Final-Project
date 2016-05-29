package Controller.FrontEnd.Search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.FrontEndDAO.UserInfoDAO;
import Utilities.Convertor;
import Utilities.Logger;
import Controller.FrontEnd.Action;

public class sourcelistwithcode implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		UserInfoDAO dao = new UserInfoDAO();
		try {
			String obj=Convertor.convertResultSetIntoJSON(dao.listuserCodeName()).toString();
			dao.close();
			response.getWriter().write(obj);	
		} catch (Exception e) {
			Logger.writeLogException(e, "sourcelistwithcode", "Servlet for Source List With Code Class");
		}
				
		//System.out.println("sourcelistwithcode");			
	}

}

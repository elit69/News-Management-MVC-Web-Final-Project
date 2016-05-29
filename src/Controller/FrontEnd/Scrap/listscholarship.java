package Controller.FrontEnd.Scrap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.FrontEnd.Action;
import Model.FrontEndDAO.Scrap.JsoupDAO;
import Utilities.Convertor;
import Utilities.Logger;

public class listscholarship implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		//System.out.println("listscholarship");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsoupDAO dao = new JsoupDAO();
		String obj;
		try {
			obj = Convertor.convertResultSetIntoJSON(dao.retrievScholarship()).toString();
			dao.close();
			//System.out.println(obj);
			response.getWriter().write(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Logger.writeLogException(e, "listScholarship", "Servlet for List Scholarship Class");
		}
	
	}

}

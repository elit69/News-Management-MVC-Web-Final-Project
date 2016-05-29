package Controller.FrontEnd.Scrap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.FrontEnd.Action;
import Model.FrontEndDAO.Scrap.JsoupDAO;
import Utilities.Convertor;
import Utilities.Logger;

public class listexchange implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		//System.out.println("listexchange");
	      response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
		JsoupDAO dao = new JsoupDAO();
		String obj;
		try {
			obj = Convertor.convertResultSetIntoJSON(dao.retrieveExchange()).toString();
			dao.close();
			response.getWriter().write(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Logger.writeLogException(e, "listExchange", "Servlet of List Exchange Class");
		}
		
		

	}
	/*public static void main(String[] args) throws Exception {
		System.out.println(Convertor.convertResultSetIntoJSON(new JsoupDAO().retrieveExchange()).toString());
	}*/
}

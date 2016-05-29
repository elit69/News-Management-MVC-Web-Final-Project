package Controller.FrontEnd.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.FrontEnd.Action;
import Model.FrontEndDAO.NewsDAO;
import Utilities.Convertor;
import Utilities.Logger;

public class ShowNewsCategoryTop implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		try{
			NewsDAO dao = new NewsDAO();
			String categoryCode = request.getParameter("c_code");
			String newsList=Convertor.convertResultSetIntoJSON(dao.showNewsCategoryTop(categoryCode)).toString();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(newsList);
			dao.close();
		}catch(Exception e){
		  e.printStackTrace();
			Logger.writeLogException(e, "ShowNewsCategoryTop", "ShowNewsCategoryTop");
		}
		
	}

}

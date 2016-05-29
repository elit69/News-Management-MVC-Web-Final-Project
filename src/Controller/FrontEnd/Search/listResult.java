package Controller.FrontEnd.Search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.FrontEnd.Action;
import Model.FrontEndDAO.NewsDAO;
import Utilities.Convertor;
import Utilities.Logger;

public class listResult implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		System.out.println("listResult");
		
		String title = request.getParameter("title");
		String timeCode = request.getParameter("timeCode");
		String categoryCode = request.getParameter("categoryCode");
		String newsCode = request.getParameter("newsCode");
		int page = Integer.parseInt(request.getParameter("pageCode"));
		
		/*System.out.println(title);
		System.out.println(timeCode);
		System.out.println(categoryCode);
		System.out.println(newsCode);
		System.out.println(page);*/
		NewsDAO dao = new NewsDAO();
		String droplistsource;
		try {
			droplistsource = Convertor.convertResultSetIntoJSON(dao.searchNewsFilterTime(title,categoryCode,newsCode,timeCode, 15, page)).toString();
			dao.close();
			//System.out.println(droplistsource);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(droplistsource);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Logger.writeLogException(e, "listResult", "Servlet of List Result Class");
		}
			
	}
}

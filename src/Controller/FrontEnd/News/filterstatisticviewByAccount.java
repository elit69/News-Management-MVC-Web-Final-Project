package Controller.FrontEnd.News;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BackEndDAO.NewsDAO;
import Utilities.Convertor;
import Controller.FrontEnd.Action;

public class filterstatisticviewByAccount implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sponsor = request.getParameter("sponsor");
		String statisticData = null;
		statisticData = Convertor.convertResultSetIntoJSON(new NewsDAO().filterbyViewAccount(sponsor)).toString();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		//System.out.println(statisticData);
		response.getWriter().write(statisticData);
		
	}

}

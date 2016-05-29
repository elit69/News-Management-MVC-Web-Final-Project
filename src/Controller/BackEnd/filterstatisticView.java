package Controller.BackEnd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BackEndDAO.NewsDAO;
import Utilities.Convertor;
import Controller.FrontEnd.Action;

public class filterstatisticView implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * sponsor : source
		 */

		String sponsor = request.getParameter("sponsor");
		String statisticData = null;

		statisticData = Convertor.convertResultSetIntoJSON(
				new NewsDAO().filterbyView(sponsor)).toString();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(statisticData);

	}

}

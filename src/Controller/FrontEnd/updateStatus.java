package Controller.FrontEnd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controller.FrontEnd.Action;
import Model.BackEndDAO.NewsDAO;
import Utilities.Convertor;

public class updateStatus implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int news_id= Integer.parseInt(request.getParameter("news_id"));
		boolean news_status=Boolean.parseBoolean(request.getParameter("news_status"));
		new NewsDAO().updateNewstatus(news_id,news_status);
	}

}

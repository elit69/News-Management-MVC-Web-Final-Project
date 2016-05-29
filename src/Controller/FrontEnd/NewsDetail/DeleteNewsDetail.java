package Controller.FrontEnd.NewsDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.BackEnd.Action;
import Model.BackEndDAO.NewsDetailDAO;

public class DeleteNewsDetail implements Action {
	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/* Get data from client request */
		int newsDetailId = 0;
		if(new NewsDetailDAO().delete(newsDetailId)){
			response.getWriter().write("News Has been Deleted"); /* Delete Successful */
		}
		else{
			response.getWriter().write("Delete Unsuccessful"); /* Delete Unsuccessful */
		}
		
	}
}

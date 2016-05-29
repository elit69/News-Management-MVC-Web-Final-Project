package Controller.BackEnd.Article;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.BackEnd.Action;
import Model.BackEndDAO.NewsDAO;

public class DeleteNews implements Action {

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/* Get data from client request */
		int newsId = 0;
		if(new NewsDAO().delete(newsId)){
			response.getWriter().write("News Has been Deleted"); /* Delete Successful */
		}
		else{
			response.getWriter().write("Delete Unsuccessful"); /* Delete Unsuccessful */
		}
		
	}

}

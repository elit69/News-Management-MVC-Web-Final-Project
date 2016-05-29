package Controller.FrontEnd.NewsDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.BackEnd.Action;
import Model.BackEndDAO.NewsDetailDAO;
import Model.DTO.NewsDetail;

public class UpdateNewsDetail implements Action {
	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/* Get data from client request */
		int newsDetailId = 0;
		int newsId = 0;
		String newsContent = "";
		NewsDetailDAO dao = new NewsDetailDAO(); /* Instantiate DAO object */

		if(dao.update(new NewsDetail(newsDetailId, newsId, newsContent))){
			response.getWriter().write("News Updated"); /* Updated Successful */
		}
		else{
			response.getWriter().write("New Add Unsuccessfuly"); /* Updated Unsuccessful */
		}
		
		
	}
}

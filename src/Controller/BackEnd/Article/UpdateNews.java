package Controller.BackEnd.Article;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.BackEnd.Action;
import Model.BackEndDAO.NewsDAO;
import Model.DTO.News;

public class UpdateNews implements Action {

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/* Get data from client request */
		int newsId = 1000;
		String catCode = "";
		String userInfoCode = "";
		String newsTittle = "";
		String newsDesc = "";
		String newsPath = "";
		String newsImg = "";
		String newsDate = "";
		NewsDAO dao = new NewsDAO(); /* Instantiate DAO object */
		
		if(dao.update(new News(newsId, catCode, userInfoCode, 
				newsTittle, newsDesc, newsPath, newsImg, newsDate))){
			response.getWriter().write("News Updated"); /* Update Successful */
		}
		else{
			response.getWriter().write("New Update Unsuccessfuly"); /* Update Unsuccessful */
		}
		

	
	}

}

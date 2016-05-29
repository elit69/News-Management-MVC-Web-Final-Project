package Controller.BackEnd.Article;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controller.FrontEnd.Action;

import Model.BackEndDAO.NewsDAO;
import Model.DTO.News;

public class update_full_article implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String catCode = request.getParameter("cat_name");
		int newsid=Integer.parseInt(request.getParameter("news_id"));
		String newsTittle = request.getParameter("news_title");
		String newsDesc = request.getParameter("news_desc");
		String newsPath = request.getParameter("news_path");
		String newsImg = request.getParameter("news_img");
		boolean draft_status =Boolean.parseBoolean(request.getParameter("draft_status"));
		
		//System.out.println(draft_status);
		String newsDate = new SimpleDateFormat().format(new Date());
		
		String newsConDetail = request.getParameter("news_con_detail");
		
		NewsDAO dao = new NewsDAO();
		News newdto = new News();
		
		//1181,'B020501','Test','testupdate','http://www.facebook.com','Jellyfish.jpg','8/30/15 8:27 AM','testupdatecontent','f'
		
		newdto.setNews_id(newsid);
		newdto.setCat_code(catCode);
		newdto.setNews_title(newsTittle);
		newdto.setNews_desc(newsDesc);
		newdto.setNews_path(newsPath);
		newdto.setNews_img(newsImg);
		newdto.setNews_date(newsDate);		
		if(dao.update_article(newdto, newsConDetail,draft_status)){
			response.getWriter().write("News Added");  //Add Successful 
		}
		else{
			response.getWriter().write("New Add Unsuccessfuly");  //Add Unsuccessful 
		}
		
		
	}

	}



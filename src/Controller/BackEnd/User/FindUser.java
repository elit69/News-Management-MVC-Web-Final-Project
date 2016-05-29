package Controller.BackEnd.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Controller.BackEnd.Action;
import Model.BackEndDAO.UserDAO;
import Utilities.Convertor;

public class FindUser implements Action  {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("user_id"));
		String obj=Convertor.convertResultSetIntoJSON(new UserDAO().uFind(id)).toString();
		 
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		/* Response JSON data to client */
		response.getWriter().write(obj);
		//System.out.println(obj);
	}

}

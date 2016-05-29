package Controller.BackEnd.User;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.FrontEnd.Action;
import Model.BackEndDAO.UserDAO;



public class EditStatus implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int  user_id= Integer.parseInt(request.getParameter("user_id"));
		boolean user_status=Boolean.parseBoolean(request.getParameter("user_status"));
		new UserDAO().editUserStatus(user_id,user_status);
		/*String countList=Convertor.convertResultSetIntoJSON(new NewsDAO().articlepost(fullname)).toString();*/
		/*response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(countList);*/

	}
}

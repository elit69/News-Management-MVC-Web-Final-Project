package Controller.BackEnd.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BackEndDAO.UserDAO;
import Model.BackEndDAO.UserInfoDAO;
import Utilities.Convertor;

import com.google.gson.Gson;

import Controller.FrontEnd.Action;

public class ListUserInfoByName implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String name = request.getParameter("name");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String obj=Convertor.convertResultSetIntoJSON(new UserInfoDAO().returnUserInformation(name)).toString();
		response.getWriter().write(obj);
		//System.err.println(obj);

	}

}

package Controller.BackEnd.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Controller.FrontEnd.Action;
import Model.BackEndDAO.JsoupDAO;
import Model.BackEndDAO.UserDAO;
import Model.BackEndDAO.UserInfoDAO;
import Model.DTO.User;
import Model.DTO.UserInfo;
import Utilities.Convertor;

public class EditUserInfo implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//System.out.println("udateUserInfo");
		UserInfo u_in = new UserInfo();
		u_in.setFull_name(request.getParameter("full_name"));
		u_in.setCom_name(request.getParameter("companyname"));
		u_in.setPhone(request.getParameter("phone"));
		u_in.setEmail(request.getParameter("email"));
		u_in.setAddr(request.getParameter("address"));
		u_in.setWebsite(request.getParameter("website"));
		u_in.setLogo(request.getParameter("img_profile"));
		u_in.setUser_info_code(request.getParameter("user_info_code"));
		
		System.err.println(new UserInfoDAO().update(u_in));
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String obj=new Gson().toJson(u_in);
		response.getWriter().write(obj);
		//System.out.println(obj);
		
	}
}

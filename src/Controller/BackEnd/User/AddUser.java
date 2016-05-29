package Controller.BackEnd.User;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Controller.FrontEnd.Action;
import Model.BackEndDAO.UserDAO;
import Model.DTO.User;
import Utilities.Convertor;
import Utilities.Logger;

public class AddUser implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		User userdto=new User();
		String name = request.getParameter("user_name");
		String password = request.getParameter("user_pass");
		String usertype = request.getParameter("user_type");
		/*String name = "Acer123";
		String password = "121212";
		String usertype = "admin";*/
		userdto.setUser_name(name);
		userdto.setUser_pass(password);
		userdto.setUser_type(usertype);
		if(new UserDAO().insert(userdto)){
			response.getWriter().write("User have been inserted.");
			System.out.println("Yes");
		}else{
			response.getWriter().write("inserted Fail");
		}
	}
}

package Controller.BackEnd.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.BackEnd.Action;
import Model.BackEndDAO.UserDAO;
import Model.DTO.User;

public class EditUser implements Action {

	@Override
	public  void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		User userdto = new User();
		int id = Integer.parseInt(request.getParameter("user_id"));
		String name = request.getParameter("user_name");
		String password = request.getParameter("user_pass");
		String usertype = request.getParameter("user_type");
		request.getContextPath();
		userdto.setUser_id(id);
		userdto.setUser_name(name);
		userdto.setUser_pass(password);
		userdto.setUser_type(usertype);
		response.setContentType("text/plain");
		if (new UserDAO().update(userdto)) {
			System.out.println("Update SUCCESS");
			response.getWriter().write("success");
		} else {
			System.err.println("Update FAIL");
			response.getWriter().write("fail");
		}
	}
}

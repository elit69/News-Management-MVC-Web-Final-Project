/**
 * 
 */
package Controller.BackEnd.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Controller.FrontEnd.Action;
import Model.BackEndDAO.UserDAO;
import Utilities.Convertor;

/**
 * @author Pisal
 *
 */
public class ListUserInfo implements Action {

	/* (non-Javadoc)
	 * @see Controller.Action#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		//String obj= new Convertor().convertResultSetIntoJSON(new UserDAO().retrieveRS()).toString();
		String obj=Convertor.convertResultSetIntoJSON(new UserDAO().retrieveRS()).toString();
		response.getWriter().write(obj);		
		//System.out.println(obj);
	}

}

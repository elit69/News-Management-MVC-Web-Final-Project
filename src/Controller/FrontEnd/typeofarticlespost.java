/**
 * 
 */
package Controller.FrontEnd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BackEndDAO.NewsDAO;
import Utilities.Convertor;

/**
 * @author Pisal
 *
 */
public class typeofarticlespost implements Action {

	/* (non-Javadoc)
	 * @see Controller.Action#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String fullname=request.getParameter("full_name");
		String countList=Convertor.convertResultSetIntoJSON(new NewsDAO().articlepost(fullname)).toString();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(countList);
		
	}

}

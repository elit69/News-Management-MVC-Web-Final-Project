/**
 * 
 */
package Controller.BackEnd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BackEndDAO.NewsDAO;
import Utilities.Convertor;
import Controller.FrontEnd.Action;

/**
 * @author PC1
 *
 */
public class filterstatistic implements Action {

	/* (non-Javadoc)
	 * @see Controller.BackEnd.Action#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*sponsor : source,
		anytime : time*/
				
		String sponsor=request.getParameter("sponsor");
		String time = request.getParameter("anytime");
		//System.out.println(time);
		String statisticData=null;
		switch (time.toLowerCase()) {
		case "day":
			statisticData=Convertor.convertResultSetIntoJSON(new NewsDAO().filterbyTime(sponsor,1)).toString();
			break;
		case "week":
			statisticData=Convertor.convertResultSetIntoJSON(new NewsDAO().filterbyTime(sponsor,2)).toString();
			break;
		case "month":
			statisticData=Convertor.convertResultSetIntoJSON(new NewsDAO().filterbyTime(sponsor,3)).toString();
			break;
		case "year":
			statisticData=Convertor.convertResultSetIntoJSON(new NewsDAO().filterbyTime(sponsor,4)).toString();
			break;

		default:
			System.err.println("Invalid Time");
			break;
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(statisticData);
	}

}

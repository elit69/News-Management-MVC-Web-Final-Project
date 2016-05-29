package Controller.BackEnd.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.BackEnd.Action;
import Model.BackEndDAO.CategoryDAO;

public class DeleteCategory implements Action {

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/* Get data from client request */
		int categoryId = 0;
		if(new CategoryDAO().delete(categoryId)){
			response.getWriter().write("Category Has been Deleted"); /* Delete Successful */
		}
		else{
			response.getWriter().write("Category Delete Unsuccessful"); /* Delete Unsuccessful */
		}
		
	}

}

package Controller.BackEnd.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.BackEnd.Action;
import Model.BackEndDAO.CategoryDAO;
import Model.DTO.Category;

public class AddCategory implements Action {

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/* Get data from client request */
		int catId = Integer.parseInt(request.getParameter("cat_id"));
		String catCode = request.getParameter("cat_code");
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		String catName = request.getParameter("cat_name");
		String catDesc = request.getParameter("cat_desc");
		CategoryDAO dao = new CategoryDAO(); /* Instantiate DAO object */

		if(dao.insert(new Category(catId, catCode, parentId, catName, catDesc))){
			response.getWriter().write("Category Added"); /* Add Successful */
		}
		else{
			response.getWriter().write("Category Add Unsuccessfuly"); /* Add Unsuccessful */
		}
		
	}

}

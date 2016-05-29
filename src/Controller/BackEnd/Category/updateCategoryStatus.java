package Controller.BackEnd.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.FrontEnd.Action;
import Model.BackEndDAO.CategoryDAO;

public class updateCategoryStatus implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String cat_code= request.getParameter("cat_code");
		boolean cat_status=Boolean.parseBoolean(request.getParameter("cat_status"));
		new CategoryDAO().updatCatstatus(cat_code,cat_status);

	}

}

package Controller.FrontEnd.Category;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

import Model.FrontEndDAO.CategoryDAO;
import Model.FrontEndDAO.NewsDAO;

/**
 * Servlet implementation class BeerAppServlet
 */
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("###########################Category Controller");
		try {
			if (new CategoryDAO().checkCategory(request.getParameter("id"))) {
				//System.out.println(request.getParameter("id"));
				String id = request.getParameter("id");
				int offset = 0;
				if(request.getParameter("offset") != null)  offset = Integer.parseInt(request.getParameter("offset"));
        Result rs = ResultSupport.toResult(new NewsDAO()
        .listNewsCategoryByMonthly(id, 15, offset));
				request.setAttribute("rs", rs);
				request.getRequestDispatcher("category.jsp").forward(request,
						response);
			} else {
				request.getRequestDispatcher("404.jsp").forward(request,
						response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

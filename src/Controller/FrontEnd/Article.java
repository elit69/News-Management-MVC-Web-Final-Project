package Controller.FrontEnd;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DTO.ArticleDetail;
import Model.FrontEndDAO.ArticleDAO;

/**
 * Servlet implementation class BeerAppServlet
 */
public class Article extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Article() {
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
		//System.out.println("###########################Article Controller");
		try {
			if (request.getParameter("id") != null) {
				int id = Integer.parseInt(request.getParameter("id"));
				if (new ArticleDAO().checkArticle(id)) {
					//System.out.println(request.getParameter("id"));
					ArticleDetail ad = new ArticleDAO().getArticle(id);
					request.setAttribute("ad", ad);
					request.getRequestDispatcher("article.jsp").forward(
							request, response);
					return;
				} 				
			}
			request.getRequestDispatcher("404.jsp").forward(request,
					response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

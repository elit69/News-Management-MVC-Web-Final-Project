package Controller.FrontEnd.Search;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BeerAppServlet
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess( request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess( request,  response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("###########################Search Controller");
		request.setCharacterEncoding("UTF-8") ;

		/*System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("timeCode"));
		System.out.println(request.getParameter("categoryCode"));
		System.out.println(request.getParameter("newsCode"));*/
		//System.out.println(request.getParameter("pageCode"));
		//int page = Integer.parseInt(request.getParameter("pageCode"));
		//System.out.println(page);
		/*String title = request.getParameter("title");
		String timeCode = request.getParameter("timeCode");
		String categoryCode = request.getParameter("categoryCode");
		String newsCode = request.getParameter("newsCode");
		int page = Integer.parseInt(request.getParameter("pageCode"));*/
		
/*		try {
			new NewsDAO().searchNewsFilterTime(title,timeCode,categoryCode,newsCode, 15, page);
		} catch (SQLException e) {		
			e.printStackTrace();
		}*/
		request.getRequestDispatcher("search.jsp").forward(request,response);
	}

}

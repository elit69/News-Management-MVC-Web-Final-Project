package Controller.BackEnd.sub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.corba.se.spi.orbutil.fsm.FSM;
import com.sun.corba.se.spi.orbutil.fsm.Input;

import Model.BackEndDAO.CategoryDAO;
import Utilities.Convertor;

public class newsCategory implements Action {

	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		@SuppressWarnings("static-access")
		String obj = new Convertor().convertResultSetIntoJSON(new CategoryDAO().retrieveRS()).toString();
		response.getWriter().write(obj);
	
	}

	@Override
	public void doIt(FSM arg0, Input arg1) {
		// TODO Auto-generated method stub
		
	}

}

package Controller.FrontEnd;

import javax.servlet.http.*;

public interface Action {
	public void execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}

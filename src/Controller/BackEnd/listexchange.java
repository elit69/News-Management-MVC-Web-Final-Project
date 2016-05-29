package Controller.BackEnd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Model.BackEndDAO.JsoupDAO;
import Model.DTO.exchangeRateDTO;
import Utilities.Convertor;

import com.google.gson.Gson;

public class listexchange implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

	      response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
		String obj = Convertor.convertResultSetIntoJSON(new JsoupDAO().retrieveExchange()).toString();
		//System.out.println(obj);
		response.getWriter().write(obj);

	}
	/*public static void main(String[] args) throws Exception {
		System.out.println(Convertor.convertResultSetIntoJSON(new JsoupDAO().retrieveExchange()).toString());
	}*/
}

package Controller.FrontEnd;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Model.BackEndDAO.JsoupDAO;
import Model.DTO.jobDTO;
import Model.DTO.scholarshipDTO;
import Utilities.Convertor;

import com.google.gson.Gson;

public class listscholarship implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String obj = Convertor.convertResultSetIntoJSON(new JsoupDAO().retrievScholarship()).toString();
		//System.out.println(obj);
		response.getWriter().write(obj);
	}
}

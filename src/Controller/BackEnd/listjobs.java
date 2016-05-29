package Controller.BackEnd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Model.BackEndDAO.JsoupDAO;
import Model.DTO.jobDTO;
import Utilities.Convertor;

import com.google.gson.Gson;

public class listjobs implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String obj=Convertor.convertResultSetIntoJSON(new JsoupDAO().retrievJobs()).toString();
		response.getWriter().write(obj);
	}
	/*public static void main(String[] args) throws Exception {
		System.out.println(Convertor.convertResultSetIntoJSON(new JsoupDAO().retrievJobs()).toString());
	}*/
}

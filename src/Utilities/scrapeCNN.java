package Utilities;

import java.io.File;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import com.jaunt.component.Form;

import Model.BackEndDAO.JsoupDAO;

public class scrapeCNN {
	public static void main(String[] args) throws JauntException {
		
		try {
		//	Document d=Jsoup.connect("http://edition.cnn.com/search/?text=cambodia").userAgent("Mozilla").get();
			
			//System.out.println(d.select("body"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
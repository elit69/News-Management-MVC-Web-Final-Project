package Utilities;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class scrapeTest {
	public static void main(String[] args) {
		try {
			   // Extract jSessionId from startURL for Cookies
			   String startURL =  "http://edition.cnn.com/search/?text=cambodia";
			   Document startPage = Jsoup.connect(startURL).userAgent("Mozilla").get();
			  // Element jSessionElement = startPage.getElementById("jSessionElementID");
			   
			   System.out.println(startPage.html());
			   // use html parser of JSoup to extract content

			} catch (IOException e) {
			   e.printStackTrace();
			}
	}
}

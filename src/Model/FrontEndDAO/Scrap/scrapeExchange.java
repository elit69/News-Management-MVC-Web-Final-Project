package Model.FrontEndDAO.Scrap;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Model.DTO.exchangeRateDTO;

public class scrapeExchange {
	public boolean scrapingExchange() {
		try {
			Document doc = Jsoup.connect("http://www.acledabank.com.kh/kh/khm/").get();

			Elements table = doc.select("table tr");

			ArrayList<exchangeRateDTO> e = new ArrayList<exchangeRateDTO>();
			exchangeRateDTO r = null;
			Element t = null;
			for (int i = 1; i < table.size(); i++) {
				t = table.get(i);
				Elements td = t.select("td");
				r = new exchangeRateDTO();
				r.setCurrency(td.get(0).text());
				r.setBid(td.get(1).text());
				r.setAsk(td.get(2).text());
				e.add(r);
			}
			//System.out.println(e.size());
			return new JsoupDAO().updateExchange(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

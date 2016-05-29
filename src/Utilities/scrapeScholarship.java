package Utilities;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import Model.BackEndDAO.JsoupDAO;
import Model.DTO.scholarshipDTO;

public class scrapeScholarship {
	public boolean scrapingScholarshipe() {
		try {
			String link = "http://www.iknow.com.kh/studyinfo-scholarship/?cat_ID=c4ca4238a0b923820dcc509a6f75849b.3";
			Document document = Jsoup.connect(link).timeout(10000).get();
			Elements nofs = document.select("div.general_result_cate");
			Elements stb = document.select("div");
			ArrayList<scholarshipDTO> asdto = new ArrayList<scholarshipDTO>();
			System.out.println(nofs.select("h4").get(0).text());
			scholarshipDTO sdtfirst = new scholarshipDTO();

			scholarshipDTO sdt = null;
			sdtfirst.setTitle(stb.select("div.study_box").get(0).select("h2").text());
			sdtfirst.setDescription(stb.select("div.study_box").get(0).select("p").text());
			sdtfirst.setPosted(stb.select("div.study_box").get(0).select("p.post").text());
			sdtfirst.setDeadline(stb.select("div.study_box").get(0).select("p.deadline").text());
			sdtfirst.setLink(stb.select("div.study_box").get(0).select("a").attr("href"));
			asdto.add(0, sdtfirst);
			for (int i = 0; i < stb.select("div.study_box").size() - 1; i++) {
				sdt = new scholarshipDTO();
				sdt.setTitle(stb.select("div.study_box").get(i).nextElementSibling().select("h2").text());
				sdt.setDescription(stb.select("div.study_box").get(i).nextElementSibling().select("p").text());
				sdt.setPosted(stb.select("div.study_box").get(i).nextElementSibling().select("p.post").text());
				sdt.setDeadline(stb.select("div.study_box").get(i).nextElementSibling().select("p.deadline").text());
				sdt.setLink(stb.select("div.study_box").get(i).nextElementSibling().select("a").attr("href"));
				asdto.add(sdt);
			}
			return new JsoupDAO().insertScholarship(asdto);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	public boolean updatescrapingScholarshipe() {
		try {
			String link = "http://www.iknow.com.kh/studyinfo-scholarship/?cat_ID=c4ca4238a0b923820dcc509a6f75849b.3";
			Document document = Jsoup.connect(link).timeout(10000).get();
			Elements nofs = document.select("div.general_result_cate");
			Elements stb = document.select("div");
			ArrayList<scholarshipDTO> asdto = new ArrayList<scholarshipDTO>();
			System.out.println(nofs.select("h4").get(0).text());
			scholarshipDTO sdtfirst = new scholarshipDTO();

			scholarshipDTO sdt = null;
			sdtfirst.setTitle(stb.select("div.study_box").get(0).select("h2").text());
			sdtfirst.setDescription(stb.select("div.study_box").get(0).select("p").text());
			sdtfirst.setPosted(stb.select("div.study_box").get(0).select("p.post").text());
			sdtfirst.setDeadline(stb.select("div.study_box").get(0).select("p.deadline").text());
			sdtfirst.setLink(stb.select("div.study_box").get(0).select("a").attr("href"));
			asdto.add(0, sdtfirst);
			for (int i = 0; i < stb.select("div.study_box").size() - 1; i++) {
				sdt = new scholarshipDTO();
				sdt.setTitle(stb.select("div.study_box").get(i).nextElementSibling().select("h2").text());
				sdt.setDescription(stb.select("div.study_box").get(i).nextElementSibling().select("p").text());
				sdt.setPosted(stb.select("div.study_box").get(i).nextElementSibling().select("p.post").text());
				sdt.setDeadline(stb.select("div.study_box").get(i).nextElementSibling().select("p.deadline").text());
				sdt.setLink(stb.select("div.study_box").get(i).nextElementSibling().select("a").attr("href"));
				asdto.add(sdt);
			}
			return new JsoupDAO().updateScholarship(asdto);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}

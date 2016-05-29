package Model.FrontEndDAO.Scrap;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import Model.DTO.jobDTO;

public class scrapeJob {
	public boolean scrapingJob() {
		try {
			Document document = null;
			document = Jsoup.connect("http://www.bongthom.com/Jobs/ipgejobslist.asp").timeout(20000).get();
			Elements table = document.select("table#tblList tr");
			ArrayList<jobDTO> joblist = new ArrayList<jobDTO>();
			jobDTO job = null;
			String Title = "";
			String closingDate = "";
			String Category = "";
			String CompanyName = "";
			String Link = "";
			for (int i = 1; i < table.select("tr").size(); i++) {
				job = new jobDTO();
				Title = table.select("tr").get(i).select("td.JobsCol").get(1).text();
				CompanyName = table.select("tr").get(i).select("td.JobsCol").get(2).text();
				closingDate = table.select("tr").get(i).select("td.JobsCol").get(3).text();
				Category = table.select("tr").get(i).select("td.JobsCol").get(4).text();
				Link = table.select("tr").get(i).select("td.JobsCol").select("a").attr("href");
				job.setTitle(Title);
				job.setCompany(CompanyName);
				job.setCloseDate(closingDate);
				job.setCategory(Category);
				job.setLink("http://www.bongthom.com/Jobs/" + Link);
				joblist.add(job);
			}
			return new JsoupDAO().insertJob(joblist);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
}

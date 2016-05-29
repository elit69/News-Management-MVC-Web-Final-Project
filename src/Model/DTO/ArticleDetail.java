package Model.DTO;

public class ArticleDetail {
	private String img_path;
	private String news_title;
	private String news_date;
	private String new_source;
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public String getNews_date() {
		return news_date;
	}
	public void setNews_date(String news_date) {
		this.news_date = news_date;
	}
	public String getNew_source() {
		return new_source;
	}
	public void setNew_source(String new_source) {
		this.new_source = new_source;
	}
	public String getNew_content() {
		return new_content;
	}
	public void setNew_content(String new_content) {
		this.new_content = new_content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	private String new_content;
	private String author;
}

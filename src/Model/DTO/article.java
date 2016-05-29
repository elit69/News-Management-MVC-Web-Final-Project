package Model.DTO;

import java.io.Serializable;

public class article implements Serializable{
	private int news_id;
	private String cat_code;
	private String user_info_code;
	private String news_title;
	private String news_desc;
	private String news_path;
	private String news_img;
	private String news_date;
	/**
	 * @return the news_id
	 */
	public int getNews_id() {
		return news_id;
	}
	/**
	 * @param news_id the news_id to set
	 */
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	/**
	 * @return the cat_code
	 */
	public String getCat_code() {
		return cat_code;
	}
	/**
	 * @param cat_code the cat_code to set
	 */
	public void setCat_code(String cat_code) {
		this.cat_code = cat_code;
	}
	/**
	 * @return the user_info_code
	 */
	public String getUser_info_code() {
		return user_info_code;
	}
	/**
	 * @param user_info_code the user_info_code to set
	 */
	public void setUser_info_code(String user_info_code) {
		this.user_info_code = user_info_code;
	}
	/**
	 * @return the news_title
	 */
	public String getNews_title() {
		return news_title;
	}
	/**
	 * @param news_title the news_title to set
	 */
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	/**
	 * @return the news_desc
	 */
	public String getNews_desc() {
		return news_desc;
	}
	/**
	 * @param news_desc the news_desc to set
	 */
	public void setNews_desc(String news_desc) {
		this.news_desc = news_desc;
	}
	/**
	 * @return the news_path
	 */
	public String getNews_path() {
		return news_path;
	}
	/**
	 * @param news_path the news_path to set
	 */
	public void setNews_path(String news_path) {
		this.news_path = news_path;
	}
	/**
	 * @return the news_img
	 */
	public String getNews_img() {
		return news_img;
	}
	/**
	 * @param news_img the news_img to set
	 */
	public void setNews_img(String news_img) {
		this.news_img = news_img;
	}
	/**
	 * @return the news_date
	 */
	public String getNews_date() {
		return news_date;
	}
	/**
	 * @param news_date the news_date to set
	 */
	public void setNews_date(String news_date) {
		this.news_date = news_date;
	}
	
}

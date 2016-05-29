/**
 * 
 */
package Model.DTO;

import java.io.Serializable;

/**
 * @author Pisal
 * 
 */
public class NewsDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int news_detail_id;
	private int news_id;

	public NewsDetail() {
	}

	public NewsDetail(int news_detail_id, int news_id, String new_content) {
		super();
		this.news_detail_id = news_detail_id;
		this.news_id = news_id;
		this.new_content = new_content;
	}

	public int getNews_detail_id() {
		return news_detail_id;
	}

	public void setNews_detail_id(int news_detail_id) {
		this.news_detail_id = news_detail_id;
	}

	public int getNews_id() {
		return news_id;
	}

	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}

	public String getNew_content() {
		return new_content;
	}

	public void setNew_content(String new_content) {
		this.new_content = new_content;
	}

	private String new_content;
}

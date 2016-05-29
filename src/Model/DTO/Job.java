/**
 * 
 */
package Model.DTO;

import java.io.Serializable;

/**
 * @author Pisal
 * 
 */
public class Job implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6468858716227430574L;
	private int job_id;
	private String cat_code;
	private String user_info_code;
	private String job_title;
	private String job_desc;
	private String job_path;
	private String job_img;
	private String job_date;
	private String job_close_date;

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public String getCat_code() {
		return cat_code;
	}

	public void setCat_code(String cat_code) {
		this.cat_code = cat_code;
	}

	public String getUser_info_code() {
		return user_info_code;
	}

	public void setUser_info_code(String user_info_code) {
		this.user_info_code = user_info_code;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getJob_desc() {
		return job_desc;
	}

	public void setJob_desc(String job_desc) {
		this.job_desc = job_desc;
	}

	public String getJob_path() {
		return job_path;
	}

	public void setJob_path(String job_path) {
		this.job_path = job_path;
	}

	public String getJob_img() {
		return job_img;
	}

	public void setJob_img(String job_img) {
		this.job_img = job_img;
	}

	public String getJob_date() {
		return job_date;
	}

	public void setJob_date(String job_date) {
		this.job_date = job_date;
	}

	public String getJob_close_date() {
		return job_close_date;
	}

	public void setJob_close_date(String job_close_date) {
		this.job_close_date = job_close_date;
	}

}

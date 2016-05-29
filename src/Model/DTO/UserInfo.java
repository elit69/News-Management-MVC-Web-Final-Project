/**
 * 
 */
package Model.DTO;

import java.io.Serializable;

/**
 * @author Pisal
 * 
 */
public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8612275154457488242L;

	public UserInfo() {
	}

	public UserInfo(int user_info_id, int user_id, String user_info_code,
			String full_name, String com_name, String addr, String email,
			String website, String phone, String logo) {
		super();
		this.user_info_id = user_info_id;
		this.user_id = user_id;
		this.user_info_code = user_info_code;
		this.full_name = full_name;
		this.com_name = com_name;
		this.addr = addr;
		this.email = email;
		this.website = website;
		this.phone = phone;
		this.logo = logo;
	}

	private int user_info_id;
	private int user_id;
	private String user_info_code;
	private String full_name;
	private String com_name;
	private String addr;
	private String email;
	private String website;
	private String phone;
	private String logo;

	public int getUser_info_id() {
		return user_info_id;
	}

	public void setUser_info_id(int user_info_id) {
		this.user_info_id = user_info_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_info_code() {
		return user_info_code;
	}

	public void setUser_info_code(String user_info_code) {
		this.user_info_code = user_info_code;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getCom_name() {
		return com_name;
	}

	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
}

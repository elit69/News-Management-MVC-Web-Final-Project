package Model.DTO;

import java.io.Serializable;

/**
 * @author Pisal
 * 
 */
public class UserRole implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_role_id;
	private String user_type;
	private String user_desc;

	public UserRole() {
	}

	public UserRole(int user_role_id, String user_type, String user_desc) {
		super();
		this.user_role_id = user_role_id;
		this.user_type = user_type;
		this.user_desc = user_desc;
	}

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getUser_desc() {
		return user_desc;
	}

	public void setUser_desc(String user_desc) {
		this.user_desc = user_desc;
	}
}

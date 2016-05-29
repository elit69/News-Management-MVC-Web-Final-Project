/**
 * 
 */
package Model.DTO;

import java.io.Serializable;

/**
 * @author Pisal
 * 
 */
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cat_id;
	private String cat_code;
	private int parent_id;
	private String cat_name;
	private String cat_desc;

	public Category() {
	}

	public Category(int cat_id, String cat_code, int parent_id,
			String cat_name, String cat_desc) {
		super();
		this.cat_id = cat_id;
		this.cat_code = cat_code;
		this.parent_id = parent_id;
		this.cat_name = cat_name;
		this.cat_desc = cat_desc;
	}

	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_code() {
		return cat_code;
	}

	public void setCat_code(String cat_code) {
		this.cat_code = cat_code;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getCat_desc() {
		return cat_desc;
	}

	public void setCat_desc(String cat_desc) {
		this.cat_desc = cat_desc;
	}
}

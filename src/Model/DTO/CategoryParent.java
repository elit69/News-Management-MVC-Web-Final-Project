/**
 * 
 */
package Model.DTO;

import java.io.Serializable;

/**
 * @author Pisal
 * 
 */
public class CategoryParent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int parent_id;
	private String parent_desc;

	public CategoryParent() {
	}

	public CategoryParent(int parent_id, String parent_desc) {
		super();
		this.parent_id = parent_id;
		this.parent_desc = parent_desc;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public String getParent_desc() {
		return parent_desc;
	}

	public void setParent_desc(String parent_desc) {
		this.parent_desc = parent_desc;
	}

}

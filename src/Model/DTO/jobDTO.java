package Model.DTO;

public class jobDTO {
	private String id;
	private String title;
	private String company;
	private String closeDate;
	private String category;
	private String link;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the closeDate
	 */
	public String getCloseDate() {
		return closeDate;
	}
	/**
	 * @param closeDate the closeDate to set
	 */
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
}

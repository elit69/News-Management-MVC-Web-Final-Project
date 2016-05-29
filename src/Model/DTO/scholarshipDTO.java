package Model.DTO;

public class scholarshipDTO {
	private String id;
	private String title;
	private String description;
	private String posted;
	private String deadline;
	private String link;
	public String getLink() {
		return link;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPosted() {
		return posted;
	}
	public void setPosted(String posted) {
		this.posted = posted;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
}

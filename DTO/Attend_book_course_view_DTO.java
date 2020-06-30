package lmsTeamPro.DTO;

public class Attend_book_course_view_DTO {
	private String enroll_name;
	private String std_status;
	
	public Attend_book_course_view_DTO() {
		super();
	}
	
	public Attend_book_course_view_DTO(String enroll_name, String std_status) {
		super();
		this.enroll_name = enroll_name;
		this.std_status = std_status;
	}
	
	public String getEnroll_name() {
		return enroll_name;
	}
	public void setEnroll_name(String enroll_name) {
		this.enroll_name = enroll_name;
	}
	public String getStd_status() {
		return std_status;
	}
	public void setStd_status(String std_status) {
		this.std_status = std_status;
	}
	
	
	
}

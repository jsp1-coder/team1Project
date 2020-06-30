package lmsTeamPro.DTO;

public class Attend_book_Student_list_DTO {
	
	private String enroll_name;
	private String course_name;
	private String std_status;
	private String subj_part;
	
	
	
	
	
	public Attend_book_Student_list_DTO() {
		super();
	}
	public Attend_book_Student_list_DTO(String enroll_name, String course_name, String std_status
			,String subj_part) {
		this.enroll_name = enroll_name;
		this.course_name = course_name;
		this.std_status = std_status;
		this.subj_part = subj_part;
	}
	
	
	
	public String getSubj_part() {
		return subj_part;
	}
	public void setSubj_part(String subj_part) {
		this.subj_part = subj_part;
	}
	public String getEnroll_name() {
		return enroll_name;
	}
	public void setEnroll_name(String enroll_name) {
		this.enroll_name = enroll_name;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getStd_status() {
		return std_status;
	}
	public void setStd_status(String std_status) {
		this.std_status = std_status;
	}
	
	
	
	
	
}

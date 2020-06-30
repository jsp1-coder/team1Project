package lmsTeamPro.DTO;

public class Attend_book_Course_list_DTO {
	private String course_name;
	private String subj_part;
	public Attend_book_Course_list_DTO() {
		super();
	}
	public Attend_book_Course_list_DTO(String course_name, String subj_part) {
		super();
		this.course_name = course_name;
		this.subj_part = subj_part;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getSubj_part() {
		return subj_part;
	}
	public void setSubj_part(String subj_part) {
		this.subj_part = subj_part;
	}
	
	
	
	
}	

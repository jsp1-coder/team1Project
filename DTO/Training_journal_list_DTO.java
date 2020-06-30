package lmsTeamPro.DTO;

import java.sql.Date;

public class Training_journal_list_DTO {
	private String course_name;
	private Date lec_rec_date;
	
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public Date getLec_rec_date() {
		return lec_rec_date;
	}
	public void setLec_rec_date(Date lec_rec_date) {
		this.lec_rec_date = lec_rec_date;
	}
	
	
}

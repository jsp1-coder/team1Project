package lmsTeamPro.after.model;

import java.util.Date;

public class Aftercard_class_DTO {	
	// fields
	
	private String course_name;
	private int subj_part;
	private String enroll_name;
	private String aftercard_std;
	
	//
	
	public String getCourse_name() {
		return course_name;
	}
	public String getAftercard_std() {
		return aftercard_std;
	}
	public void setAftercard_std(String aftercard_std) {
		this.aftercard_std = aftercard_std;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getSubj_part() {
		return subj_part;
	}
	public void setSubj_part(int subj_part) {
		this.subj_part = subj_part;
	}
	public String getEnroll_name() {
		return enroll_name;
	}
	public void setEnroll_name(String enroll_name) {
		this.enroll_name = enroll_name;
	}
	

	
	
	

}


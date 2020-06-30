package lmsTeamPro.after.model;

import java.util.Date;

public class EmpconfirmDTO {	
	// fields
	
	private String course_name;
	private int subj_part;
	private Date startdate;
	private Date enddate;
	private String edu_in;
	private String course_type;
	private String teacher;
	private String week;		
	private String st_number;
	private String management;
	
	//getter, setter
	public String getCourse_name() {
		return course_name;
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
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getEdu_in() {
		return edu_in;
	}
	public void setEdu_in(String edu_in) {
		this.edu_in = edu_in;
	}
	public String getCourse_type() {
		return course_type;
	}
	public void setCourse_type(String course_type) {
		this.course_type = course_type;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getSt_number() {
		return st_number;
	}
	public void setSt_number(String st_number) {
		this.st_number = st_number;
	}
	public String getManagement() {
		return management;
	}
	public void setManagement(String management) {
		this.management = management;
	}
	
	
	
	

}


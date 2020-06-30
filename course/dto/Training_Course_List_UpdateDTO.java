package lmsTeamPro.course.dto;

import java.sql.Date;

public class Training_Course_List_UpdateDTO {
	private String course_name;
	private String c_t_name;
	private String staff_name;
	private Date subj_startdate;
	private Date subj_enddate;
	private int subj_part;
	private int subj_ppl;
	private String classroom;
	private String day_of_week;
	private String course_code_code;
	private String course_code;
	private String subj_d_code;
	private String c_t_code;
	private String edu_in_code;
	private String mngr_info_code;
	
	
	public String getEdu_in_code() {
		return edu_in_code;
	}
	public void setEdu_in_code(String edu_in_code) {
		this.edu_in_code = edu_in_code;
	}
	public String getMngr_info_code() {
		return mngr_info_code;
	}
	public void setMngr_info_code(String mngr_info_code) {
		this.mngr_info_code = mngr_info_code;
	}
	public String getC_t_code() {
		return c_t_code;
	}
	public void setC_t_code(String c_t_code) {
		this.c_t_code = c_t_code;
	}
	public String getSubj_d_code() {
		return subj_d_code;
	}
	public void setSubj_d_code(String subj_d_code) {
		this.subj_d_code = subj_d_code;
	}
	public String getCourse_code() {
		return course_code;
	}
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	public String getDay_of_week() {
		return day_of_week;
	}
	public void setDay_of_week(String day_of_week) {
		this.day_of_week = day_of_week;
	}
	public String getCourse_code_code() {
		return course_code_code;
	}
	public void setCourse_code_code(String course_code_code) {
		this.course_code_code = course_code_code;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getC_t_name() {
		return c_t_name;
	}
	public void setC_t_name(String c_t_name) {
		this.c_t_name = c_t_name;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public Date getSubj_startdate() {
		return subj_startdate;
	}
	public void setSubj_startdate(Date subj_startdate) {
		this.subj_startdate = subj_startdate;
	}
	public Date getSubj_enddate() {
		return subj_enddate;
	}
	public void setSubj_enddate(Date subj_enddate) {
		this.subj_enddate = subj_enddate;
	}
	public int getSubj_part() {
		return subj_part;
	}
	public void setSubj_part(int subj_part) {
		this.subj_part = subj_part;
	}
	public int getSubj_ppl() {
		return subj_ppl;
	}
	public void setSubj_ppl(int subj_ppl) {
		this.subj_ppl = subj_ppl;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	
	
	
}

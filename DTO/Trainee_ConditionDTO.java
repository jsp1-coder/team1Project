package lmsTeamPro.DTO;

import java.util.Date;

public class Trainee_ConditionDTO {

	private String course_name;
    private int subj_part;
    private String subj_d_code;
  
	private Date subj_startdate;
    private Date subj_enddate;
    private String edu_in_name;
    private String c_t_name;
    private String staff_name;
    private String day_of_week;
    private int subj_ppl;
    private String classroom;
    
    public String getSubj_d_code() {
  		return subj_d_code;
  	}
  	public void setSubj_d_code(String subj_d_code) {
  		this.subj_d_code = subj_d_code;
  	}
    
    
	public String getCourse_name() {
		return course_name;
	}
	public int getSubj_part() {
		return subj_part;
	}
	public Date getSubj_startdate() {
		return subj_startdate;
	}
	public Date getSubj_enddate() {
		return subj_enddate;
	}
	public String getEdu_in_name() {
		return edu_in_name;
	}
	public String getC_t_name() {
		return c_t_name;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public String getDay_of_week() {
		return day_of_week;
	}
	public int getSubj_ppl() {
		return subj_ppl;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public void setSubj_part(int subj_part) {
		this.subj_part = subj_part;
	}
	public void setSubj_startdate(Date subj_startdate) {
		this.subj_startdate = subj_startdate;
	}
	public void setSubj_enddate(Date subj_enddate) {
		this.subj_enddate = subj_enddate;
	}
	public void setEdu_in_name(String edu_in_name) {
		this.edu_in_name = edu_in_name;
	}
	public void setC_t_name(String c_t_name) {
		this.c_t_name = c_t_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public void setDay_of_week(String day_of_week) {
		this.day_of_week = day_of_week;
	}
	public void setSubj_ppl(int subj_ppl) {
		this.subj_ppl = subj_ppl;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}


	
	
}

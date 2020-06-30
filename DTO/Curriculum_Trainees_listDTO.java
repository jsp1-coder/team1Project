package lmsTeamPro.DTO;

import java.util.Date;

public class Curriculum_Trainees_listDTO {

	private String course_name;
	private Date subj_startdate;
	private Date subj_enddate;
	private String std_num;
	private String enroll_name;
	private String enroll_phone;
	private String enroll_rrn;
	private Date hrd_startdate;
	private String std_status;
	private String subj_d_code;
	
	
	
	
	
	public String getSubj_d_code() {
		return subj_d_code;
	}
	public void setSubj_d_code(String subj_d_code) {
		this.subj_d_code = subj_d_code;
	}
	public String getCourse_name() {
		return course_name;
	}
	public Date getSubj_startdate() {
		return subj_startdate;
	}
	public Date getSubj_enddate() {
		return subj_enddate;
	}
	public String getStd_num() {
		return std_num;
	}
	public String getEnroll_name() {
		return enroll_name;
	}
	public String getEnroll_phone() {
		return enroll_phone;
	}
	public String getEnroll_rrn() {
		return enroll_rrn;
	}
	public Date getHrd_startdate() {
		return hrd_startdate;
	}
	public String getStd_status() {
		return std_status;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public void setSubj_startdate(Date subj_startdate) {
		this.subj_startdate = subj_startdate;
	}
	public void setSubj_enddate(Date subj_enddate) {
		this.subj_enddate = subj_enddate;
	}
	public void setStd_num(String std_num) {
		this.std_num = std_num;
	}
	public void setEnroll_name(String enroll_name) {
		this.enroll_name = enroll_name;
	}
	public void setEnroll_phone(String enroll_phone) {
		this.enroll_phone = enroll_phone;
	}
	public void setEnroll_rrn(String enroll_rrn) {
		this.enroll_rrn = enroll_rrn;
	}
	public void setHrd_startdate(Date hrd_startdate) {
		this.hrd_startdate = hrd_startdate;
	}
	public void setStd_status(String std_status) {
		this.std_status = std_status;
	}


	
	
}

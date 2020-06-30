package lmsTeamPro.DTO;

import java.sql.Date;
import java.util.ArrayList;

public class Answer_Set_Back_DTO {

	
	private String subj_d_code;
	private ArrayList<String> surv_qs;
	private String surv_write; 
	private String set_surv_code;
	private Date set_surv_date;
	private String staff_code;
	private String subj_code;
	private String subj_name;
	private String course_name;
	private int subj_part;
	private Date subj_startdate;
	private Date subj_enddate;
	private String c_t_name;
	private String staff_name;
	private int subj_ppl;

	
	
	public int surv_qs_size(){
		return surv_qs.size();
		}
	public ArrayList<String> getSurv_qs() {
		return surv_qs;
	}
	public void setSurv_qs(ArrayList<String> surv_qs) {
		this.surv_qs = surv_qs;
	}
	public int getSubj_ppl() {
		return subj_ppl;
	}
	public void setSubj_ppl(int subj_ppl) {
		this.subj_ppl = subj_ppl;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getC_t_name() {
		return c_t_name;
	}
	public void setC_t_name(String c_t_name) {
		this.c_t_name = c_t_name;
	}
	public Date getSubj_startdate() {
		return subj_startdate;
	}
	public Date getSubj_enddate() {
		return subj_enddate;
	}
	public void setSubj_startdate(Date subj_startdate) {
		this.subj_startdate = subj_startdate;
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
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getSubj_name() {
		return subj_name;
	}
	public void setSubj_name(String subj_name) {
		this.subj_name = subj_name;
	}

	public String getSubj_d_code() {
		return subj_d_code;
	}
	
	public void setSubj_d_code(String subj_d_code) {
		this.subj_d_code = subj_d_code;
	}
	
	public String getSurv_write() {
		return surv_write;
	}
	public String getSet_surv_code() {
		return set_surv_code;
	}
	public Date getSet_surv_date() {
		return set_surv_date;
	}
	public String getStaff_code() {
		return staff_code;
	}
	public String getSubj_code() {
		return subj_code;
	}
	

	public void setSurv_write(String surv_write) {
		this.surv_write = surv_write;
	}
	public void setSet_surv_code(String set_surv_code) {
		this.set_surv_code = set_surv_code;
	}
	public void setSet_surv_date(Date set_surv_date) {
		this.set_surv_date = set_surv_date;
	}
	public void setStaff_code(String staff_code) {
		this.staff_code = staff_code;
	}
	public void setSubj_code(String subj_code) {
		this.subj_code = subj_code;
	}
	
	
	
	
	
}

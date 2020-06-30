package lmsTeamPro.DTO;

import java.util.ArrayList;
import java.util.Date;

public class AnswerDTO {
	private String course_name;
	private int subj_part;
	private String subj_d_code;

	private Date subj_startdate;
	private Date subj_enddate;
	private String c_t_name;
	private String staff_name;

	private int subj_ppl;

	//private ArrayList<String> subj_name; 
	private String subj_name;
	private String set_surv_code;

	
	
	
	
	
	
	public String getSet_surv_code() {
		return set_surv_code;
	}

	public void setSet_surv_code(String set_surv_code) {
		this.set_surv_code = set_surv_code;
	}

	public String getSubj_name() {
		return subj_name;
	}

	public void setSubj_name(String subj_name) {
		this.subj_name = subj_name;
	}

	public String getCourse_name() {
		return course_name;
	}

	/*
	 * public ArrayList<String> getSubj_name() { return subj_name; }
	 * 
	 * 
	 * public void setSubj_name(ArrayList<String> subj_name) { this.subj_name =
	 * subj_name; }
	 * 
	 * 
	 * 
	 */
	
	
	
	public int getSubj_part() {
		return subj_part;
	}

	public String getSubj_d_code() {
		return subj_d_code;
	}

	public Date getSubj_startdate() {
		return subj_startdate;
	}

	public Date getSubj_enddate() {
		return subj_enddate;
	}

	public String getC_t_name() {
		return c_t_name;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public int getSubj_ppl() {
		return subj_ppl;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public void setSubj_part(int subj_part) {
		this.subj_part = subj_part;
	}

	public void setSubj_d_code(String subj_d_code) {
		this.subj_d_code = subj_d_code;
	}

	public void setSubj_startdate(Date subj_startdate) {
		this.subj_startdate = subj_startdate;
	}

	public void setSubj_enddate(Date subj_enddate) {
		this.subj_enddate = subj_enddate;
	}

	public void setC_t_name(String c_t_name) {
		this.c_t_name = c_t_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public void setSubj_ppl(int subj_ppl) {
		this.subj_ppl = subj_ppl;
	}

}

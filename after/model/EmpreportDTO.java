package lmsTeamPro.after.model;

import java.sql.Date;

public class EmpreportDTO {
	//1~4
	private String course_name;
	private Date subj_startdate;
	private Date subj_enddate;
	private int comp_number;
	private int fail_number;
	private int notcomp_number;
	private int earlyjob_number;
	private int compjob_number;
	private String job_rate;
	private String fail_rate;
	
	//5	
	private String enroll_name;
	private String gender;
	private String birth;
	private Date fu_startdate;
	private String fu_comp_name;
	private String loc;
	private String fu_comp_num;
	private String fu_field;
	private String fu_insu;
	
	
	
	
	
	//getter, setter
	
	
	public String getCourse_name() {
		return course_name;
	}
	
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
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
	public int getComp_number() {
		return comp_number;
	}
	public void setComp_number(int comp_number) {
		this.comp_number = comp_number;
	}
	public int getFail_number() {
		return fail_number;
	}
	public void setFail_number(int fail_number) {
		this.fail_number = fail_number;
	}
	public int getNotcomp_number() {
		return notcomp_number;
	}
	public void setNotcomp_number(int notcomp_number) {
		this.notcomp_number = notcomp_number;
	}
	public int getEarlyjob_number() {
		return earlyjob_number;
	}
	public void setEarlyjob_number(int earlyjob_number) {
		this.earlyjob_number = earlyjob_number;
	}
	public int getCompjob_number() {
		return compjob_number;
	}
	public void setCompjob_number(int compjob_number) {
		this.compjob_number = compjob_number;
	}
	public String getJob_rate() {
		return job_rate;
	}
	public void setJob_rate(String job_rate) {
		this.job_rate = job_rate;
	}
	public String getFail_rate() {
		return fail_rate;
	}
	public void setFail_rate(String fail_rate) {
		this.fail_rate = fail_rate;
	}
	public String getEnroll_name() {
		return enroll_name;
	}
	public void setEnroll_name(String enroll_name) {
		this.enroll_name = enroll_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Date getFu_startdate() {
		return fu_startdate;
	}
	public void setFu_startdate(Date fu_startdate) {
		this.fu_startdate = fu_startdate;
	}
	public String getFu_comp_name() {
		return fu_comp_name;
	}
	public void setFu_comp_name(String fu_comp_name) {
		this.fu_comp_name = fu_comp_name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	public String getFu_field() {
		return fu_field;
	}
	public void setFu_field(String fu_field) {
		this.fu_field = fu_field;
	}
	public String getFu_insu() {
		return fu_insu;
	}
	public void setFu_insu(String fu_insu) {
		this.fu_insu = fu_insu;
	}

	public String getFu_comp_num() {
		return fu_comp_num;
	}

	public void setFu_comp_num(String fu_comp_num) {
		this.fu_comp_num = fu_comp_num;
	}
	
	
	
	
	
	
}

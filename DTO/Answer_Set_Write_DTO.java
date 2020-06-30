package lmsTeamPro.DTO;

import java.sql.Date;

public class Answer_Set_Write_DTO {

	private String subj_d_code;
	private String set_surv_code;
	private Date set_surv_date;
	private String staff_code;
	private String subj_code;
	private String subj_name;
	
	
	
	
	
	
	
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

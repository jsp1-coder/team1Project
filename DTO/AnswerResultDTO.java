package lmsTeamPro.DTO;

import java.util.Date;

public class AnswerResultDTO {

	private String course_name;
  
    private String subj_d_code;
  
	private Date set_surv_date;
    
    private String subj_name;
    
    private Date subj_startdate;
    private Date subj_enddate;
    
    

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

	public String getCourse_name() {
		return course_name;
	}

	public String getSubj_d_code() {
		return subj_d_code;
	}

	public Date getSet_surv_date() {
		return set_surv_date;
	}

	public String getSubj_name() {
		return subj_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public void setSubj_d_code(String subj_d_code) {
		this.subj_d_code = subj_d_code;
	}

	public void setSet_surv_date(Date set_surv_date) {
		this.set_surv_date = set_surv_date;
	}

	public void setSubj_name(String subj_name) {
		this.subj_name = subj_name;
	}

    
	
	
}

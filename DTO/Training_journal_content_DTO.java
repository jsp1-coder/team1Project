package lmsTeamPro.DTO;

import java.sql.Date;

public class Training_journal_content_DTO {
	private int lec_rec_std;
	private int lec_atd;
	private int lec_abs;
	private int lec_late;
	private int lec_earlyleave;
	
	
	private int lec_period;
	private String lec_subj;
	private String lec_lectr;
	private String lec_content;
	
	
	
	private String lec_note;
	private Date lec_rec_date;
	
	
	public int getLec_period() {
		return lec_period;
	}
	public void setLec_period(int lec_period) {
		this.lec_period = lec_period;
	}
	public String getLec_subj() {
		return lec_subj;
	}
	public void setLec_subj(String lec_subj) {
		this.lec_subj = lec_subj;
	}
	public String getLec_lectr() {
		return lec_lectr;
	}
	public void setLec_lectr(String lec_lectr) {
		this.lec_lectr = lec_lectr;
	}
	public String getLec_content() {
		return lec_content;
	}
	public void setLec_content(String lec_content) {
		this.lec_content = lec_content;
	}
	public String getLec_note() {
		return lec_note;
	}
	public void setLec_note(String lec_note) {
		this.lec_note = lec_note;
	}
	public Date getLec_rec_date() {
		return lec_rec_date;
	}
	public void setLec_rec_date(Date lec_rec_date) {
		this.lec_rec_date = lec_rec_date;
	}
	public int getLec_rec_std() {
		return lec_rec_std;
	}
	public void setLec_rec_std(int lec_rec_std) {
		this.lec_rec_std = lec_rec_std;
	}
	public int getLec_atd() {
		return lec_atd;
	}
	public void setLec_atd(int lec_atd) {
		this.lec_atd = lec_atd;
	}
	public int getLec_abs() {
		return lec_abs;
	}
	public void setLec_abs(int lec_abs) {
		this.lec_abs = lec_abs;
	}
	public int getLec_late() {
		return lec_late;
	}
	public void setLec_late(int lec_late) {
		this.lec_late = lec_late;
	}
	public int getLec_earlyleave() {
		return lec_earlyleave;
	}
	public void setLec_earlyleave(int lec_earlyleave) {
		this.lec_earlyleave = lec_earlyleave;
	}
	
	
}

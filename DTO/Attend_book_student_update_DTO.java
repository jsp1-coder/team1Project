package lmsTeamPro.DTO;

public class Attend_book_student_update_DTO {
	private String atd_insert_time;
	private String std_info_code;
	private String atd_date;
	
	public Attend_book_student_update_DTO() {
		super();
	}

	public Attend_book_student_update_DTO(String atd_insert_time, String std_info_code, String atd_date) {
		super();
		this.atd_insert_time = atd_insert_time;
		this.std_info_code = std_info_code;
		this.atd_date = atd_date;
	}

	public String getAtd_insert_time() {
		return atd_insert_time;
	}

	public void setAtd_insert_time(String atd_insert_time) {
		this.atd_insert_time = atd_insert_time;
	}

	public String getStd_info_code() {
		return std_info_code;
	}

	public void setStd_info_code(String std_info_code) {
		this.std_info_code = std_info_code;
	}

	public String getAtd_date() {
		return atd_date;
	}

	public void setAtd_date(String atd_date) {
		this.atd_date = atd_date;
	}
	
	
	
}

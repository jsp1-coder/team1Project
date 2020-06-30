package lmsTeamPro.DTO;

public class Attend_book_student_view_DTO {
	private String atd_book_date;
	private String atd_status;
	
	public Attend_book_student_view_DTO() {
		super();
	}

	public Attend_book_student_view_DTO(String atd_book_date, String atd_status) {
		super();
		this.atd_book_date = atd_book_date;
		this.atd_status = atd_status;
	}

	public String getAtd_book_date() {
		return atd_book_date;
	}

	public void setAtd_book_date(String atd_book_date) {
		this.atd_book_date = atd_book_date;
	}

	public String getAtd_status() {
		return atd_status;
	}

	public void setAtd_status(String atd_status) {
		this.atd_status = atd_status;
	}
	
	
	
}

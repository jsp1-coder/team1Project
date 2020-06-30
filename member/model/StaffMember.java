package lmsTeamPro.member.model;

import java.util.Date;

public class StaffMember {

	private String staff_code;
	private String staff_name;
	private String staff_id;
	private String staff_pwd;
	
	public StaffMember(String staff_code, String staff_name, String staff_id, String staff_pwd) {
		super();
		this.staff_code = staff_code;
		this.staff_name = staff_name;
		this.staff_id = staff_id;
		this.staff_pwd = staff_pwd;
	}

	public String getStaff_code() {
		return staff_code;
	}
	

	public String getStaff_name() {
		return staff_name;
	}
	

	public String getStaff_id() {
		return staff_id;
	}

	
	public String getStaff_pwd() {
		return staff_pwd;
	}
	
	
	public boolean matchPassword(String staff_pwd) {
		return this.staff_pwd.equals(staff_pwd);
	}
	
	
	
}


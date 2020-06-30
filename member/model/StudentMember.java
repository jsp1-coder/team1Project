package lmsTeamPro.member.model;

import java.util.Date;

public class StudentMember {

	private String std_mbr_info_code;
	private String std_id;
	private String std_pwd;
	
	
	
	public StudentMember(String std_mbr_info_code, String std_id, String std_pwd) {
		super();
		this.std_mbr_info_code = std_mbr_info_code;
		this.std_id = std_id;
		this.std_pwd = std_pwd;
	}

		

	public String getStd_mbr_info_code() {
		return std_mbr_info_code;
	}


	public String getStd_id() {
		return std_id;
	}


	public String getStd_pwd() {
		return std_pwd;
	}


	public boolean matchPassword(String std_pwd) {
		return this.std_pwd.equals(std_pwd);
	}
	
	
	
}


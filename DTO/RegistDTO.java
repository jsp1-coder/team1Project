package lmsTeamPro.DTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistDTO {
	private String staff_Code;
	private String staff_Name;
	private String staff_Id;
	private String staff_Pwd;
	private String staff_Phone;
	private Date staff_Startdate;
	private Date staff_Enddate;
	private String auth;
	private String job_rank;
	
	
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		
		this.auth = auth;
	}
	public String getJob_rank() {
		
		return job_rank;
	}
	public void setJob_rank(String job_rank) {
		this.job_rank = job_rank;
	}
	public String getStaff_Code() {
		return staff_Code;
	}
	public void setStaff_Code(String staff_Code) {
		this.staff_Code = staff_Code;
	}
	public String getStaff_Name() {
		return staff_Name;
	}
	public void setStaff_Name(String staff_Name) {
		this.staff_Name = staff_Name;
	}
	public String getStaff_Id() {
		return staff_Id;
	}
	public void setStaff_Id(String staff_Id) {
		this.staff_Id = staff_Id;
	}
	public String getStaff_Pwd() {
		return staff_Pwd;
	}
	public void setStaff_Pwd(String staff_Pwd) {
		this.staff_Pwd = staff_Pwd;
	}
	public String getStaff_Phone() {
		return staff_Phone;
	}
	public void setStaff_Phone(String staff_Phone) {
		this.staff_Phone = staff_Phone;
	}

	public Date getStaff_Startdate() {
		return staff_Startdate;
	}
	public void setStaff_Startdate(Date staff_Startdate) {
		this.staff_Startdate = staff_Startdate;
	}
	public Date getStaff_Enddate() {
		return staff_Enddate;
	}
	public void setStaff_Enddate(Date staff_Enddate) {
		this.staff_Enddate = staff_Enddate;
	}
	
	public String getJob_RankCode(Connection conn, String job_rank) throws SQLException {
		ResultSet rs = null;
		try(PreparedStatement pstmt = 
				conn.prepareStatement("select  job_rank_code from job_rank where job_rank = ?")){
			pstmt.setString(1, job_rank);
			rs = pstmt.executeQuery();
			rs.next();
			String job_rankcode;
			job_rankcode = rs.getString("job_rank_code");
			return job_rankcode;
		}
	}
	
	
}



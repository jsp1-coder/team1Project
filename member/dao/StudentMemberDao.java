package lmsTeamPro.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.util.JdbcUtil;

import lmsTeamPro.member.model.StudentMember;
import lmsTeamPro.member.model.StudentMember;

public class StudentMemberDao {

	public StudentMember selectById(Connection conn, String std_id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	try {
		String sql = "select  std_mbr_info_code, std_id, std_pwd from std_mbr_info where std_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, std_id);
		rs = pstmt.executeQuery();
		StudentMember member = null;
		if (rs.next()) {
			member = new StudentMember(
													rs.getString("std_mbr_info_code")
													,rs.getString("std_id")													
													,rs.getString("std_pwd"));
		}
		return member;
	} finally {
		JdbcUtil.close(rs);
		JdbcUtil.close(pstmt);
		
	}	
		
		
	}

	
	
	
}

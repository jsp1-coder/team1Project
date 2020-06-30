package lmsTeamPro.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.util.JdbcUtil;

import lmsTeamPro.member.model.StaffMember;

public class StaffMemberDao {

	public StaffMember selectById(Connection conn, String staff_id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	try {
		String sql = "select  staff_code, staff_name, staff_id, staff_pwd from staff where staff_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, staff_id);
		rs = pstmt.executeQuery();
		StaffMember member = null;
		if (rs.next()) {
			member = new StaffMember(
													rs.getString("staff_code")
													,rs.getString("staff_name")
													,rs.getString("staff_id")
													,rs.getString("staff_pwd"));
		}
		return member;
	} finally {
		JdbcUtil.close(rs);
		JdbcUtil.close(pstmt);
		
	}	
		
		
	}

	
	
	
}

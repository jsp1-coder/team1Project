package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lmsTeamPro.DTO.Course_DTO;

public class Course_code_DAO {
	
	private static Course_code_DAO dao = null;
	private Course_code_DAO() {}
	public static Course_code_DAO getInstance() {
		if( dao == null ) {
			dao = new Course_code_DAO();
		}
		return dao;
	}
	
	
	
	public String getCourse_code(Connection conn
			, String course_name) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement("select  course_code from course where course_name = ?");
			pstmt.setString(1, course_name);
			rs = pstmt.executeQuery();
			rs.next();
			String course_Code;
			course_Code = rs.getString("course_code");
			return course_Code;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
		
		}
		
		
		return null;

	}
	
}

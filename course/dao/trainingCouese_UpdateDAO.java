package lmsTeamPro.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lmsTeamPro.course.dto.Training_Course_UpdateDTO;

public class trainingCouese_UpdateDAO {
	
	private static trainingCouese_UpdateDAO dao = null;
	private trainingCouese_UpdateDAO() {}
	public static trainingCouese_UpdateDAO getInstance() {
		if(dao == null) {
			dao = new trainingCouese_UpdateDAO();
		}
		return dao;
	}
	
	

	public int update_Course(Connection conn, Training_Course_UpdateDTO dto) {
		PreparedStatement pstmt = null;		
		int result = 0;

		String sql = " UPDATE COURSE SET c_t_code = ? where course_code = ?  ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getC_t_code());
			pstmt.setString(2, dto.getCourse_code());
			result = pstmt.executeUpdate();
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			//try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		}
		return result;
	}
	
	
}

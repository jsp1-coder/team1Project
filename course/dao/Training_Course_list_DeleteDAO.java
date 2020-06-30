package lmsTeamPro.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lmsTeamPro.course.dto.Training_Course_list_DeleteDTO;

public class Training_Course_list_DeleteDAO {
	private static Training_Course_list_DeleteDAO dao = null;
	private Training_Course_list_DeleteDAO() {}
	public static Training_Course_list_DeleteDAO getInstance() {
		if( dao == null ) {
			dao = new Training_Course_list_DeleteDAO();
		}
		return dao;
	}
	
	
	    
	//delete from course where course_code = ? -- 3번삭제
	//delete from subj_d where subj_d_code = ? -- 2번삭제
	//delete from subj where subj_d_code = 'SUBD0002'; --1번 삭제
	
	public int Delete_subj(Connection conn, Training_Course_list_DeleteDTO dto) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = " delete from subj where subj_d_code = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubj_d_code());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			//try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		}
		
		return result;

	}

	public int Delete_subj_d(Connection conn, Training_Course_list_DeleteDTO dto) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = " delete from subj_d where subj_d_code = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubj_d_code());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			//try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		}
		
		return result;
		
	}

	public int Delete_course(Connection conn, Training_Course_list_DeleteDTO dto) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = " delete from course where course_code = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCourse_code());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			//try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		}
		
		return result;
		
	}
	//delete from std_info where subj_d_code = ?
	public int Delete_std_info(Connection conn, Training_Course_list_DeleteDTO dto) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = " delete from std_info where subj_d_code = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubj_d_code());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			//try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		}
		
		return result;
		
	}

}

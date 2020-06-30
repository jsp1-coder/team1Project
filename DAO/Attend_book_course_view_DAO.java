package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.DTO.Attend_book_course_view_DTO;

public class Attend_book_course_view_DAO {

	private static Attend_book_course_view_DAO dao = null;
	private Attend_book_course_view_DAO() {}
	public static Attend_book_course_view_DAO getInstance() {
		if( dao == null ) {
			dao = new Attend_book_course_view_DAO();
		}
		return dao;
	}
	
	public List<Attend_book_course_view_DTO> selectList(
			Connection conn, String course_name, String subj_part){

		  String sql ="select a.enroll_name , c.std_status " + 
		  		"from enroll a, std_info b, std_status c , subj_d d, course e " + 
		  		"where a.enroll_code = b.enroll_code " + 
		  		"and b.std_status_code = c.std_status_code " + 
		  		"and b.subj_d_code = d.subj_d_code " + 
		  		"and d.course_code = e.course_code " + 
		  		"and e.course_name = ? " + 
		  		"and d.subj_part = ? " ;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Attend_book_course_view_DTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,course_name);
			pstmt.setString(2,subj_part);
			rs = pstmt.executeQuery();
			Attend_book_course_view_DTO dto = null;
			while(rs.next()) {
				dto = new Attend_book_course_view_DTO(
						rs.getString("enroll_name")
						, rs.getString("std_status"));
				list.add(dto);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
			try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		}
		return list;		
	}
	
}

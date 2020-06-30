package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.DTO.Attend_book_Student_list_DTO;
import lmsTeamPro.DTO.Training_journal_list_DTO;

public class Attend_book_Student_list_DAO {
	private static Attend_book_Student_list_DAO dao = null;
	private Attend_book_Student_list_DAO() {}
	public static Attend_book_Student_list_DAO getInstance() {
		if( dao == null ) {
			dao = new Attend_book_Student_list_DAO();
		}
		return dao;
	}
	
	
	public List<Attend_book_Student_list_DTO> selectList(
			Connection conn){
		Course_code_DAO course_code_DAO = null;
		
		String sql =" select a.enroll_name, d.course_name, e.std_status, c.subj_part " + 
				" from enroll a, std_info b, subj_d c, course d, std_status e " + 
				" where b.std_status_code = e.std_status_code " +
				" and b.enroll_code = a.enroll_code " + 
				" and b.subj_d_code = c.subj_d_code " + 
				" and c.course_code = d.course_code ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		

		ArrayList<Attend_book_Student_list_DTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Attend_book_Student_list_DTO dto = null;
			while(rs.next()) {
				dto =  new Attend_book_Student_list_DTO(
						rs.getString("enroll_name")
						,rs.getString("course_name")
						, rs.getString("std_status")
						, rs.getString("subj_part"));
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

package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.DTO.Attend_book_Course_list_DTO;

public class Attend_book_Course_list_DAO  {
	
	private static Attend_book_Course_list_DAO dao = null;
	private Attend_book_Course_list_DAO() {}
	public static Attend_book_Course_list_DAO getInstance() {
		if( dao == null ) {
			dao = new Attend_book_Course_list_DAO();
		}
		return dao;
	}
	
	
	public List<Attend_book_Course_list_DTO> selectList(
			Connection conn){
		
		String sql =" select a.course_name, b.subj_part " + 
				"from course a, subj_d b " + 
				"where a.course_code = b.course_code ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Attend_book_Course_list_DTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Attend_book_Course_list_DTO dto = null;
			while(rs.next()) {
				dto =  new Attend_book_Course_list_DTO(
						rs.getString("course_name")
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

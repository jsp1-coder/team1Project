package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.DTO.Attend_book_student_view_DTO;

public class Attend_book_student_view_DAO {

	private static Attend_book_student_view_DAO dao = null;
	private Attend_book_student_view_DAO() {}
	public static Attend_book_student_view_DAO getInstance() {
		if( dao == null ) {
			dao = new Attend_book_student_view_DAO();
		}
		return dao;
	}
	
	
	public List<Attend_book_student_view_DTO> selectList(
			Connection conn, String enroll_name){

		  String sql ="select a.atd_book_date, b.atd_status " + 
		  		"from atd_book a, atd_status b, std_info c, enroll d " + 
		  		"where a.atd_status_code = b.atd_status_code " + 
		  		"and c.enroll_code = d.enroll_code " + 
		  		"and a.std_info_code = c.std_info_code " + 
		  		"and d.enroll_name= ? " ;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Attend_book_student_view_DTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,enroll_name );
			rs = pstmt.executeQuery();
			Attend_book_student_view_DTO dto = null;
			while(rs.next()) {
				dto =  new Attend_book_student_view_DTO(
						  rs.getString("atd_book_date").substring(0, rs.getString("atd_book_date").length()-9)
						, rs.getString("atd_status"));
			
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

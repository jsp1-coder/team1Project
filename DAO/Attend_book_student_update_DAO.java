package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.DTO.Attend_book_student_update_DTO;
import lmsTeamPro.DTO.Attend_book_student_view_DTO;
import lmsTeamPro.DTO.Training_journal_write_DTO;

public class Attend_book_student_update_DAO {
	private static Attend_book_student_update_DAO dao = null;
	private Attend_book_student_update_DAO() {}
	public static Attend_book_student_update_DAO getInstance() {
		if( dao == null ) {
			dao = new Attend_book_student_update_DAO();
		}
		return dao;
	}
	
	public List<Attend_book_student_update_DTO> select(Connection conn) {

		Course_code_DAO cdao = null;
		cdao.getInstance();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			String sql = "select atd_insert_time, std_info_code, atd_date " + 
					"from atd_mng " + 
					"order by std_info_code ";
			ArrayList< Attend_book_student_update_DTO> list = new ArrayList<Attend_book_student_update_DTO>();
			
			try {
				pstmt =  conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					Attend_book_student_update_DTO dto = new Attend_book_student_update_DTO(
							rs.getString("atd_insert_time")
							,rs.getString("std_info_code")
							,rs.getString("atd_date"));
					list.add(dto);
				}
				

				
				return list;
			}catch (SQLException e) { 
				e.printStackTrace();
			} finally {
				try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
				try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
			}
			return null;
		}
	
}

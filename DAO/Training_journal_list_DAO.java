package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.DTO.Training_journalDTO;
import lmsTeamPro.DTO.Training_journal_list_DTO;

public class Training_journal_list_DAO {

	private static Training_journal_list_DAO dao = null;
	private Training_journal_list_DAO() {}
	public static Training_journal_list_DAO getInstance() {
		if( dao == null ) {
			dao = new Training_journal_list_DAO();
		}
		return dao;
	}
	
	
	public List<Training_journal_list_DTO> selectList(
			Connection conn, String course_name){
		Course_code_DAO course_code_DAO = null;
		
		String sql =" select a.course_name, b.lec_rec_date " + 
				"from course a , lec_rec b " + 
				"where a.course_code = b.course_code " + 
				"and b.course_code= ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		

		ArrayList<Training_journal_list_DTO> list = new ArrayList<>();
		try {
			String course_code = course_code_DAO.getInstance().getCourse_code(conn, course_name);
			System.out.println("course_code:"+course_code);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, course_code);
			rs = pstmt.executeQuery();
			Training_journal_list_DTO dto = null;
			while(rs.next()) {
				dto =  new Training_journal_list_DTO();
					dto.setCourse_name(rs.getString("course_name"));
					dto.setLec_rec_date(rs.getDate("lec_rec_date"));		
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

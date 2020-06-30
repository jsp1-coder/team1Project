package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.DTO.Training_journalDTO;

public class Training_journalDAO {
	
	private static Training_journalDAO dao = null;
	private Training_journalDAO() {}
	public static Training_journalDAO getInstance() {
		if( dao == null ) {
			dao = new Training_journalDAO();
		}
		return dao;
	}
	
	
	public List<Training_journalDTO> selectList(
			Connection conn){
		String sql ="select course_name from course ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Training_journalDTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Training_journalDTO dto = null;
			while(rs.next()) {
				dto =  new Training_journalDTO();
					dto.setCourse_name(rs.getString("course_name"));
							
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

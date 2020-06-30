package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lmsTeamPro.DTO.Answer_Set_Write_DTO;

public class Answer_Set_Write_DAO {
	private static Answer_Set_Write_DAO dao = null;
	private Answer_Set_Write_DAO() {}
	public static Answer_Set_Write_DAO getInstance() {
		if( dao == null ) {
			dao = new Answer_Set_Write_DAO();
		}
		return dao;
	}
	
	
	public ArrayList<Answer_Set_Write_DTO> selectList(
			Connection conn, String ans_subj_d_code){
		System.out.println("Äõ¸® ½ÇÇà!!!!");
		String sql ="\r\n" + 
				"select c.course_name, sd.subj_d_code, sd.subj_startdate, sd.subj_enddate, sub.subj_name\r\n" + 
				"from subj_d sd\r\n" + 
				"left outer join subj sub\r\n" + 
				"on sd.subj_d_code = sub.subj_d_code\r\n" + 
				"left outer join course c\r\n" + 
				"on sd.course_code = c.course_code\r\n" + 
				"where sd.subj_d_code = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Answer_Set_Write_DTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ans_subj_d_code);
			rs = pstmt.executeQuery();
			Answer_Set_Write_DTO dto = null;
			while(rs.next()) {
				dto =  new Answer_Set_Write_DTO();
				  
					dto.setSubj_name(rs.getString("subj_name"));
					dto.setSubj_d_code(rs.getString("subj_d_code"));
				
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

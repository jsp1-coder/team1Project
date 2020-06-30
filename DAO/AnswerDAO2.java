package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import lmsTeamPro.DTO.AnswerDTO;


public class AnswerDAO2 {

	
	private static AnswerDAO2 dao2 = null;
	private AnswerDAO2() {}
	public static AnswerDAO2 getInstance() {
		if( dao2 == null ) {
			dao2 = new AnswerDAO2();
		}
		return dao2;
	}
	
	public ArrayList<AnswerDTO> selectList(
			Connection conn, String ans_subj_d_code){
		String sql = "select subj_name\r\n" + 
				"from subj;";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<AnswerDTO> list2 = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			AnswerDTO dto = null;
			
			while(rs.next()) {
				System.out.println("Äõ¸®222 ½ÇÇà!!!!");
				dto =  new AnswerDTO();
				/*
				 * ArrayList<String> a = new ArrayList<String>(); for (int i = 0; i < a.size();
				 * i++) { a.add(rs.getString("subj_name")); } dto.setSubj_name(a);
				 */
					
				dto.setSubj_name(rs.getString("subj_name"));
				dto.setSubj_d_code(rs.getString("subj_d_code"));
					System.out.println("dto2 >>"+ rs.getString("subj_name"));
				list2.add(dto);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
			try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		}
		return list2;		
	}
	
	
}

package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lmsTeamPro.DTO.AnswerResultDTO;

public class AnswerResultDAO {
	private static AnswerResultDAO dao = null;
	private AnswerResultDAO() {}
	public static AnswerResultDAO getInstance() {
		if( dao == null ) {
			dao = new AnswerResultDAO();
		}
		return dao;
	}
	
	public ArrayList<AnswerResultDTO> selectList(
			Connection conn, String ans_subj_d_code){
		System.out.println("Äõ¸® ½ÇÇà!!!!");
		String sql ="select sub.subj_name, sub.subj_d_code, c.course_name, surv.set_surv_date, sd.subj_enddate, sd.subj_startdate\r\n" + 
				"from set_surv surv\r\n" + 
				"left outer join subj sub\r\n" + 
				"on sub.subj_code = surv.subj_code\r\n" + 
				"left outer join subj_d sd\r\n" + 
				"on sub.subj_d_code = sd.subj_d_code\r\n" + 
				"left outer join course c\r\n" + 
				"on sd.course_code = c.course_code\r\n" + 
				"where sd.subj_d_code = ?" ;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<AnswerResultDTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ans_subj_d_code);
			rs = pstmt.executeQuery();
			AnswerResultDTO dto = null;
			while(rs.next()) {
				dto =  new AnswerResultDTO();
				    dto.setSubj_d_code(rs.getString("subj_d_code"));
					dto.setCourse_name(rs.getString("course_name"));
					dto.setSet_surv_date(rs.getDate("set_surv_date"));
					dto.setSubj_name(rs.getString("subj_name"));
					dto.setSubj_startdate(rs.getDate("subj_startdate"));
					dto.setSubj_enddate(rs.getDate("subj_enddate"));
							
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

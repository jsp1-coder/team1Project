package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lmsTeamPro.DTO.AnswerDTO;


public class AnswerDAO {

	
	private static AnswerDAO dao = null;
	private AnswerDAO() {}
	public static AnswerDAO getInstance() {
		if( dao == null ) {
			dao = new AnswerDAO();
		}
		return dao;
	}
	
	public ArrayList<AnswerDTO> selectList(
			Connection conn){
		System.out.println("Äõ¸® ½ÇÇà!!!!");
		String sql ="\r\n" + 
				"select sd.subj_d_code, c.course_name, sd.subj_part, sd.subj_startdate, \r\n" + 
				"sd.subj_enddate, ct.c_t_name, s.staff_name, sd.subj_ppl\r\n" + 
				"from subj_d sd\r\n" + 
				"left outer join course c \r\n" + 
				"on sd.course_code = c.course_code\r\n" + 
				"left outer join lecturer_info l\r\n" + 
				"on sd.lectr_info_code = l.lectr_info_code\r\n" + 
				"left outer join course_type ct\r\n" + 
				"on c.c_t_code = ct.c_t_code\r\n" + 
				"left outer join staff s\r\n" + 
				"on l.staff_code = s.staff_code\r\n" + 
				"order by sd.subj_d_code" ;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<AnswerDTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, set_surv_code);
			rs = pstmt.executeQuery();
			AnswerDTO dto = null;
			while(rs.next()) {
				dto =  new AnswerDTO();
				    dto.setSubj_d_code(rs.getString("subj_d_code"));
					dto.setCourse_name(rs.getString("course_name"));
					dto.setC_t_name(rs.getString("c_t_name"));
					dto.setStaff_name(rs.getString("staff_name"));
					dto.setSubj_enddate(rs.getDate("subj_enddate"));
					dto.setSubj_part(rs.getInt("subj_part"));
					dto.setSubj_startdate(rs.getDate("subj_startdate"));
					dto.setSubj_ppl(rs.getInt("subj_ppl"));
				
					
				/* dto.setList2(AnswerDAO2.getInstance().selectList(conn, )); */
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

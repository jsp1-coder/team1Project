package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lmsTeamPro.DTO.Curriculum_Trainees_listDTO;

public class Curriculum_Trainees_listDAO {

	private static Curriculum_Trainees_listDAO dao = null;
	private Curriculum_Trainees_listDAO() {}
	public static Curriculum_Trainees_listDAO getInstance() {
		if( dao == null ) {
			dao = new Curriculum_Trainees_listDAO();
		}
		return dao;
	}
	
	public ArrayList<Curriculum_Trainees_listDTO> selectList(
			Connection conn, String curriculum_subj_d_code){
		System.out.println("Äõ¸® ½ÇÇà!!!!");
		String sql =" select c.course_name, sd.subj_startdate, sd.subj_enddate, e.enroll_name, e.enroll_phone, e.enroll_rrn\r\n" + 
				", e.hrd_startdate, ss.std_status, si.std_num \r\n" + 
				"from subj_d sd\r\n" + 
				"left outer join course c \r\n" + 
				"on sd.course_code = c.course_code\r\n" + 
				"left outer join std_info si\r\n" + 
				"on sd.subj_d_code = si.subj_d_code\r\n" + 
				"left outer join enroll e\r\n" + 
				"on si.enroll_code = e.enroll_code\r\n" + 
				"left outer join std_status ss\r\n" + 
				"on si.std_status_code = ss.std_status_code\r\n" + 
				"where sd.subj_d_code = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Curriculum_Trainees_listDTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, curriculum_subj_d_code);
			rs = pstmt.executeQuery();
			Curriculum_Trainees_listDTO dto = null;
			
			while(rs.next()) {
				dto =  new Curriculum_Trainees_listDTO();
					dto.setCourse_name(rs.getString("course_name"));
					dto.setEnroll_name(rs.getString("enroll_name"));
					dto.setEnroll_phone(rs.getString("enroll_phone"));
					dto.setEnroll_rrn(rs.getString("enroll_rrn"));
					dto.setHrd_startdate(rs.getDate("hrd_startdate"));
					dto.setStd_num(rs.getString("std_num"));
					dto.setSubj_enddate(rs.getDate("subj_enddate"));
					dto.setStd_status(rs.getString("std_status"));
					dto.setSubj_startdate(rs.getDate("subj_startdate"));
					
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

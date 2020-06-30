package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.DTO.Trainee_ConditionDTO;

public class Trainee_ConditionDAO {

	private static Trainee_ConditionDAO dao = null;
	private Trainee_ConditionDAO() {}
	public static Trainee_ConditionDAO getInstance() {
		if( dao == null ) {
			dao = new Trainee_ConditionDAO();
		}
		return dao;
	}
	
	public ArrayList<Trainee_ConditionDTO> selectList(
			Connection conn){
		System.out.println("Äõ¸® ½ÇÇà!!!!");
		String sql =" select c.course_name, sd.subj_d_code, sd.subj_part, sd.subj_startdate, \r\n" + 
				"sd.subj_enddate, e.edu_in_name, ct.c_t_name, s.staff_name, sd.day_of_week, sd.subj_ppl, sd.classroom\r\n" + 
				"from subj_d sd\r\n" + 
				"left outer join course c \r\n" + 
				"on sd.course_code = c.course_code\r\n" + 
				"left outer join lecturer_info l\r\n" + 
				"on sd.lectr_info_code = l.lectr_info_code\r\n" + 
				"left outer join edu_in e\r\n" + 
				"on sd.edu_in_code = e.edu_in_code\r\n" + 
				"left outer join course_type ct\r\n" + 
				"on c.c_t_code = ct.c_t_code\r\n" + 
				"left outer join staff s\r\n" + 
				"on l.staff_code = s.staff_code"
				+ " order by sd.subj_d_code asc ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Trainee_ConditionDTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Trainee_ConditionDTO dto = null;
			while(rs.next()) {
				dto =  new Trainee_ConditionDTO();
				    dto.setSubj_d_code(rs.getString("subj_d_code"));
					dto.setCourse_name(rs.getString("course_name"));
					dto.setC_t_name(rs.getString("c_t_name"));
					dto.setClassroom(rs.getString("classroom"));
					dto.setDay_of_week(rs.getString("day_of_week"));
					dto.setEdu_in_name(rs.getString("edu_in_name"));
					dto.setStaff_name(rs.getString("staff_name"));
					dto.setSubj_enddate(rs.getDate("subj_enddate"));
					dto.setSubj_part(rs.getInt("subj_part"));
					dto.setSubj_startdate(rs.getDate("subj_startdate"));
					dto.setSubj_ppl(rs.getInt("subj_ppl"));
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

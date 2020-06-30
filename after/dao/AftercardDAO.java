package lmsTeamPro.after.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.after.model.AftercardDTO;



public class AftercardDAO {
	// 싱글톤
	private static AftercardDAO dao = null;
	private AftercardDAO() {}
	public static AftercardDAO getInstance() {
		if( dao == null ) {
			dao = new AftercardDAO();
		}
		return dao;
	}


	// 전체 게시글 페이징 처리 없이 가져오는 메서드
	public List<AftercardDTO> selectList(
			Connection conn){
		String sql = " select distinct " + 
			 
				"        c.course_name as course_name " + 
				"        ,sd.subj_part as subj_part " + 
				"        ,sd.subj_startdate   as startdate " + 
				"        ,sd.subj_enddate    as enddate " + 
				"        ,e.edu_in_name as edu_in " + 
				"        ,ct.c_t_name as course_type " + 
				"        ,s.staff_name as teacher " + 
				"        ,sd.day_of_week as week " + 
				"        ,sd.subj_ppl || '/' || (select count(std_status_code) from std_info where std_status_code = 'STST0001' and subj_d_code = sd.subj_d_code ) " + 
				"            as st_number " + 
				"        ,'교육생별사후관리현황' as management " + 
				 
				" from    course c  " + 
				" join subj_d sd    on     c.course_code = sd.course_code " + 
				" join edu_in e     on     sd.edu_in_code = e.edu_in_code " + 
				" join course_type ct on   c.c_t_code = ct.c_t_code " + 
				" join lecturer_info l on  sd.lectr_info_code = l.lectr_info_code " + 
				" join staff s     on l.staff_code = s.staff_code   " + 
			 
				" ORDER BY sd.subj_startdate desc ";
		
		//System.out.println( sql );
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<AftercardDTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			AftercardDTO dto = null;
			while(rs.next()) {
				dto =  new AftercardDTO();
					dto.setCourse_name(rs.getString("course_name"));
					dto.setSubj_part(rs.getInt("subj_part"));
					dto.setStartdate(rs.getDate("startdate"));
					dto.setEnddate(rs.getDate("enddate"));
					dto.setEdu_in(rs.getString("edu_in"));
					dto.setCourse_type(rs.getString("course_type"));
					dto.setTeacher(rs.getString("teacher"));
					dto.setWeek(rs.getString("week"));
					dto.setSt_number(rs.getString("st_number"));
					dto.setManagement(rs.getString("management"));
				
					
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



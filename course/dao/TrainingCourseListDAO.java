package lmsTeamPro.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.course.dto.TrainingCourseListDTO;

public class TrainingCourseListDAO {
	
		private static TrainingCourseListDAO dao = null;
		private TrainingCourseListDAO() {}
		public static TrainingCourseListDAO getInstance() {
			if(dao == null) {
				dao = new TrainingCourseListDAO();
			}
			return dao;
		}

	public List<TrainingCourseListDTO> selectList(Connection conn) {
		String sql =	 	" select distinct c.course_name, c.course_code "
							+" ,ct.c_t_name , s.subj_d_code  "
							+" ,c.course_code_code "
							+" ,s.day_of_week "
							+" ,sf.staff_name  "
							+" ,to_char(s.subj_startdate, 'YYYY-MM-DD') as startdate  "
							+" ,to_char(s.subj_enddate, 'YYYY-MM-DD') as enddate "
							+" ,s.subj_part   "
							+" ,s.subj_ppl  "
							+" ,s.classroom   "
							+" from course c , course_type ct ,staff sf, mngr_info m, subj_d s "
							+" where c.c_t_code = ct.c_t_code "
							+" and c.course_code = s.course_code "
							+" and s.mngr_info_code = m.mngr_info_code "
							+" and sf.staff_code = m.staff_code ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TrainingCourseListDTO> list = new ArrayList<>();
		try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				TrainingCourseListDTO dto = null;
				while (rs.next()) {
					dto = new TrainingCourseListDTO();
					dto.setCourse_code(rs.getString("course_code"));
					dto.setCourse_name(rs.getString("course_name"));
					dto.setCourse_code_code(rs.getString("course_code_code"));
					dto.setDay_of_week(rs.getString("day_of_week"));
					dto.setC_t_name(rs.getString("c_t_name"));
					dto.setStaff_name(rs.getString("staff_name"));
					dto.setSubj_startdate(rs.getString("startdate"));
					dto.setSubj_enddate(rs.getString("enddate"));
					dto.setSubj_part(rs.getString("subj_part"));
					dto.setSubj_ppl(rs.getInt("subj_ppl"));
					dto.setClassroom(rs.getString("classroom"));
					dto.setSubj_d_code(rs.getString("subj_d_code"));
					list.add(dto);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
			try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		}
		
		return list;
		
	}
	public TrainingCourseListDAO selectOne(Connection conn, String c_t_name) {
	
				
		
		
		return null;
		
	}
	
	
}

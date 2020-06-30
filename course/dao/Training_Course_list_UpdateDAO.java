package lmsTeamPro.course.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lmsTeamPro.course.dto.Training_Course_List_UpdateDTO;

public class Training_Course_list_UpdateDAO {

	private static Training_Course_list_UpdateDAO dao = null;
	private Training_Course_list_UpdateDAO() {}
	public static Training_Course_list_UpdateDAO getInstance() {
		if(dao == null) {
			dao = new Training_Course_list_UpdateDAO();
		}
		return dao;
	}
	
	public List<Training_Course_List_UpdateDTO> select_List(Connection conn, Training_Course_List_UpdateDTO dto) {
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
				+" and sf.staff_code = m.staff_code "
				+" and s.subj_d_code = ?  ";
				
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Training_Course_List_UpdateDTO> list = new ArrayList<>();
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getSubj_d_code());
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
			String startdate = rs.getString("startdate");
			String enddate = rs.getString("enddate");
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = (Date) formatter.parse(startdate);
			Date date2 = (Date) formatter.parse(enddate);
			
			java.sql.Date start_date = new java.sql.Date(date1.getTime());
			java.sql.Date end_date = new java.sql.Date(date2.getTime());
			
			//System.out.println(start_date);
			dto = new Training_Course_List_UpdateDTO();
			dto.setCourse_code(rs.getString("course_code"));
			dto.setCourse_name(rs.getString("course_name"));
			dto.setCourse_code_code(rs.getString("course_code_code"));
			dto.setDay_of_week(rs.getString("day_of_week"));
			dto.setC_t_name(rs.getString("c_t_name"));
			dto.setStaff_name(rs.getString("staff_name"));
			dto.setSubj_startdate(start_date);
			dto.setSubj_enddate(end_date);
			dto.setSubj_part(rs.getInt("subj_part"));
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
	
	public int update_Course(Connection conn, Training_Course_List_UpdateDTO dto) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "update course set  course_name = ? , course_code_code = ? , c_t_code = ? where course_code = ?";

				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, dto.getCourse_name());
					pstmt.setString(2, dto.getCourse_code_code());
					pstmt.setString(3, dto.getC_t_code());
					pstmt.setString(4, dto.getCourse_code());
					
					result = pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
					//try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
				}
				
				return result;

	}

		public int update_subj_d(Connection conn, Training_Course_List_UpdateDTO dto) {
			PreparedStatement pstmt = null;
			int result = 0;
			String sql = " update subj_d set subj_startdate = ? , subj_enddate = ? , subj_part = ?, " + 
					" day_of_week = ?, subj_ppl = ?, mngr_info_code = ? , edu_in_code = ? where subj_d_code = ? ";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setDate(1, dto.getSubj_startdate());
				pstmt.setDate(2, dto.getSubj_enddate());
				pstmt.setInt(3, dto.getSubj_part());
				pstmt.setString(4, dto.getDay_of_week());
				pstmt.setInt(5, dto.getSubj_ppl());
				pstmt.setString(6, dto.getMngr_info_code());
				pstmt.setString(7, dto.getEdu_in_code());
				pstmt.setString(8, dto.getSubj_d_code());
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
				//try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
			}
			
			return result;
					
		}
	
	
	
	
}

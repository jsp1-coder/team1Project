package lmsTeamPro.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.JdbcUtil;

import lmsTeamPro.course.dto.Training_Course_Registr_CourseDTO;

public class Training_Course_Registr_CourseDAO {
	private static Training_Course_Registr_CourseDAO dao = null;
	private Training_Course_Registr_CourseDAO() {}
	public static Training_Course_Registr_CourseDAO getInstance() {
		if(dao == null) {
			dao = new Training_Course_Registr_CourseDAO();
		}
		return dao;
	
		
	}
	
	public int insertCourse(Connection conn, Training_Course_Registr_CourseDTO dto) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = " insert into course values('COUR' || lpad(seq_course.nextval,4,0),?,?,?) ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCourse_name());
			pstmt.setString(2, dto.getCourse_code_code());
			pstmt.setString(3, dto.getC_t_code());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}

		return result;
		
	}
	
	
	
	
	public int insertSubj_d(Connection conn, Training_Course_Registr_CourseDTO dto) {
		PreparedStatement pstmt = null;
		int result = 0;
		Couse_DAO couse_DAO = null;
		String course_code = couse_DAO.getInstance().getCourse_code(conn, dto.getCourse_name());
	
		String sql =    "   insert into subj_d values( " + 
				" 'SUBD' || lpad(seq_subj_d.nextval,4,0) " + 
				" ,?,?,?,?,?,?,?,?, ? ) ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, dto.getSubj_startdate());
			pstmt.setDate(2, dto.getSubj_enddate());
			pstmt.setInt(3, dto.getSubj_part());
			pstmt.setString(4, dto.getDay_of_week());
			pstmt.setString(5, dto.getClassroom());
			pstmt.setInt(6, dto.getSubj_ppl());
			pstmt.setString(7, course_code);
			pstmt.setString(8, dto.getMngr_info_code());
			pstmt.setString(9, dto.getEdu_in_code());
			

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}
		
		
		return result;
	}

	public List<Training_Course_Registr_CourseDTO> selectCourse_type(Connection conn) {
		String sql =  " select c_t_code , c_t_name from course_type ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Training_Course_Registr_CourseDTO> course_list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Training_Course_Registr_CourseDTO dto = null;
			while (rs.next()) {
				dto = new Training_Course_Registr_CourseDTO();
				dto.setC_t_code(rs.getString("c_t_code"));
				dto.setC_t_name(rs.getString("c_t_name"));
				
				course_list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
			try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		
		}
		
		
		return course_list;
		
	}
	
	public List<Training_Course_Registr_CourseDTO> selectStaff_name(Connection conn) {
		String sql = " select m.mngr_info_code, s.staff_name from staff s , mngr_info m where s.staff_code =m.staff_code  ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Training_Course_Registr_CourseDTO> staffName_list  = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Training_Course_Registr_CourseDTO dto = null;
			while (rs.next()) {
				dto = new Training_Course_Registr_CourseDTO();
				dto.setMngr_info_code(rs.getString("mngr_info_code"));
				dto.setStaff_name(rs.getString("staff_name"));
				
				staffName_list.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
			try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		
		}
		
		return staffName_list;
	}
	
	public List<Training_Course_Registr_CourseDTO> selectEdu_in(Connection conn) {
		String sql = " select edu_in_code , edu_in_name from edu_in ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Training_Course_Registr_CourseDTO> eduName_list  = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Training_Course_Registr_CourseDTO dto = null;
			while (rs.next()) {
				dto = new Training_Course_Registr_CourseDTO();
		
				dto.setEdu_in_code(rs.getString("edu_in_code"));
				dto.setEdu_in_name(rs.getString("edu_in_name"));
				eduName_list.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
			try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		
		}
		
		return eduName_list;
	}
	
	
	
	
	
}

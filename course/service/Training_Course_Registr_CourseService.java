package lmsTeamPro.course.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;
import com.util.JdbcUtil;

import lmsTeamPro.course.dao.Training_Course_Registr_CourseDAO;
import lmsTeamPro.course.dto.Training_Course_Registr_CourseDTO;

public class Training_Course_Registr_CourseService  {
	
	public List<Training_Course_Registr_CourseDTO> select_EduName() {
		Training_Course_Registr_CourseDAO dao = Training_Course_Registr_CourseDAO.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()){
			List<Training_Course_Registr_CourseDTO> eduName_list = dao.selectEdu_in(conn);
			
			
			return eduName_list;
			
		} catch (SQLException | NamingException e)  {
			throw new RuntimeException();
		
		}
	
	}
	public List<Training_Course_Registr_CourseDTO> select_StaffName() {
		Training_Course_Registr_CourseDAO dao = Training_Course_Registr_CourseDAO.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()){
			List<Training_Course_Registr_CourseDTO> staffName_list = dao.selectStaff_name(conn);
			
			
			return staffName_list;
			
		} catch (SQLException | NamingException e)  {
			throw new RuntimeException();
		
		}
		
		
	}
	public List<Training_Course_Registr_CourseDTO> select_Course(){
		Training_Course_Registr_CourseDAO dao = Training_Course_Registr_CourseDAO.getInstance();
		try(Connection conn = ConnectionProvider.getConnection()) {
			List<Training_Course_Registr_CourseDTO> course_list = dao.selectCourse_type(conn);
			
		
			return course_list;
		
		} catch (SQLException | NamingException e)  {
			throw new RuntimeException();
		
		}
		
	}

	public int insert_Course(Training_Course_Registr_CourseDTO dto) {
		Training_Course_Registr_CourseDAO dao = Training_Course_Registr_CourseDAO.getInstance();
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			int insertedCount = dao.insertCourse(conn, dto);
			conn.setAutoCommit(true);
			
			if (insertedCount == 0) {
				throw new RuntimeException("insert 실패");
			}
			return insertedCount;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} catch (NamingException e) {  
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
			
	public int insert_Subj_d(Training_Course_Registr_CourseDTO dto) {
		Training_Course_Registr_CourseDAO dao = Training_Course_Registr_CourseDAO.getInstance();
		Connection conn = null;
		try {

			conn = ConnectionProvider.getConnection();
			int insertedCount = dao.insertSubj_d(conn, dto);
			conn.setAutoCommit(true);
			if (insertedCount == 0) {
				throw new RuntimeException("insert 실패");
			}
			return insertedCount;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} catch (NamingException e) {  
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
			




}
		
		
		
		
	


package lmsTeamPro.course.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.util.ConnectionProvider;
import com.util.JdbcUtil;

import lmsTeamPro.course.dao.Training_Course_list_DeleteDAO;
import lmsTeamPro.course.dto.Training_Course_list_DeleteDTO;


public class Training_Course_list_DeleteService {
	
	public int delete_subj(Training_Course_list_DeleteDTO dto) {
		Training_Course_list_DeleteDAO dao = Training_Course_list_DeleteDAO.getInstance();
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			int insertedCount = dao.Delete_subj(conn, dto);
			conn.setAutoCommit(true);

			if (insertedCount == 0) {
				throw new RuntimeException("delete 실패");
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
	
	
	
	public int delete_subj_d(Training_Course_list_DeleteDTO dto) {
		Training_Course_list_DeleteDAO dao = Training_Course_list_DeleteDAO.getInstance();
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			int insertedCount = dao.Delete_subj_d(conn, dto);
			conn.setAutoCommit(true);

			if (insertedCount == 0) {
				throw new RuntimeException("delete 실패");
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
	

	public int delete_Course(Training_Course_list_DeleteDTO dto) {
		Training_Course_list_DeleteDAO dao = Training_Course_list_DeleteDAO.getInstance();
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			int insertedCount = dao.Delete_course(conn, dto);
			conn.setAutoCommit(true);

			if (insertedCount == 0) {
				throw new RuntimeException("delete 실패");
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
	public int delete_std_info(Training_Course_list_DeleteDTO dto) {
		Training_Course_list_DeleteDAO dao = Training_Course_list_DeleteDAO.getInstance();
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			int insertedCount = dao.Delete_std_info(conn, dto);
			conn.setAutoCommit(true);

			if (insertedCount == 0) {
				throw new RuntimeException("delete 실패");
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

package lmsTeamPro.course.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;
import com.util.JdbcUtil;

import lmsTeamPro.course.dao.Training_Course_list_UpdateDAO;
import lmsTeamPro.course.dto.Training_Course_List_UpdateDTO;

public class Training_Course_list_UpdateService {

	public List<Training_Course_List_UpdateDTO> select(Training_Course_List_UpdateDTO dto) {
		Training_Course_list_UpdateDAO dao = Training_Course_list_UpdateDAO.getInstance();
		
		try(Connection conn = ConnectionProvider.getConnection()) {
			List<Training_Course_List_UpdateDTO> select_list = dao.select_List(conn, dto);

			return select_list;
			
		} catch (SQLException  | NamingException e) {
			throw new RuntimeException(e);
		} 
		
		
	}
	
	public int update_Course(Training_Course_List_UpdateDTO dto) {
		Training_Course_list_UpdateDAO dao = Training_Course_list_UpdateDAO.getInstance();
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			int insertedCount = dao.update_Course(conn, dto);
			conn.setAutoCommit(true);

			if (insertedCount == 0) {
				throw new RuntimeException("update 실패");
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
	
	public int update_subj_d(Training_Course_List_UpdateDTO dto) {
		Training_Course_list_UpdateDAO dao = Training_Course_list_UpdateDAO.getInstance();
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			int insertedCount = dao.update_subj_d(conn, dto);
			conn.setAutoCommit(true);

			if (insertedCount == 0) {
				throw new RuntimeException("update 실패");
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

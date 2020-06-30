package lmsTeamPro.course.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.util.ConnectionProvider;
import com.util.JdbcUtil;

import lmsTeamPro.course.dao.trainingCouese_UpdateDAO;
import lmsTeamPro.course.dto.Training_Course_UpdateDTO;

public class Training_Course_UpdateService {

	public int update_Course(Training_Course_UpdateDTO dto) {
		trainingCouese_UpdateDAO dao = trainingCouese_UpdateDAO.getInstance();
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			int insertedCount = dao.update_Course(conn, dto);
			conn.setAutoCommit(true);
			
			if (insertedCount == 0) {
				throw new RuntimeException("update ½ÇÆÐ");
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

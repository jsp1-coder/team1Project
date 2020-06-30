package lmsTeamPro.Service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.util.ConnectionProvider;
import com.util.JdbcUtil;

import lmsTeamPro.DAO.Training_journal_write_DAO;
import lmsTeamPro.DTO.Training_journal_write_DTO;

public class Training_journal_write_service  {

	public int write( Training_journal_write_DTO dto ) {
		Training_journal_write_DAO dao = Training_journal_write_DAO.getInstance();		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();	
			int insertedCount = dao.insert(conn, dto); 
			if (insertedCount == 0) {
				//throw new RuntimeException("fail to insert article");
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

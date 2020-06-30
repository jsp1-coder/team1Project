package lmsTeamPro.Service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.util.ConnectionProvider;
import com.util.JdbcUtil;

import lmsTeamPro.DAO.Staff_registDAO;
import lmsTeamPro.DTO.RegistDTO;

public class Staff_Regist_Service {
	
	public int write( RegistDTO dto ) {
		Staff_registDAO dao = Staff_registDAO.getInstance();		
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

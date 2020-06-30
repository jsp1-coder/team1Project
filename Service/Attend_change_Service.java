package lmsTeamPro.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;
import com.util.JdbcUtil;

import lmsTeamPro.DAO.Attend_change_DAO;
import lmsTeamPro.DTO.Atd_Status__DTO;
import lmsTeamPro.DTO.Atd_chg_DTO;
import lmsTeamPro.DTO.Training_journal_write_DTO;

public class Attend_change_Service {
	
	public List<Atd_Status__DTO> select() {
		Attend_change_DAO dao = Attend_change_DAO.getInstance();		
		try (Connection conn = ConnectionProvider.getConnection()) {			
			List<Atd_Status__DTO> list = dao.selectList(conn);
			// �α� ó��
			// 
			//
			return list;
		} catch (SQLException | NamingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int insert( Atd_chg_DTO dto , String enroll_name, String atd_book_date) {
		Attend_change_DAO dao = Attend_change_DAO.getInstance();		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();	
			int insertedCount = dao.insert(conn, dto,enroll_name,atd_book_date); 
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
	
	public int update( Atd_chg_DTO dto , String enroll_name, String atd_book_date, String atd_status) {
		Attend_change_DAO dao = Attend_change_DAO.getInstance();		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();	
			int insertedCount = dao.update(conn, dto,enroll_name,atd_book_date, atd_status); 
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

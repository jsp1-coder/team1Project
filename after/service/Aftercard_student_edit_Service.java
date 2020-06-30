package lmsTeamPro.after.service;

import java.sql.Connection;
import java.sql.SQLException;


import javax.naming.NamingException;

import com.util.ConnectionProvider;
import com.util.JdbcUtil;

import lmsTeamPro.after.dao.Aftercard_student_DAO;
import lmsTeamPro.after.model.Aftercard_student_edit_DTO;


public class Aftercard_student_edit_Service {
	
	private Aftercard_student_DAO aftercard_student_dao = new Aftercard_student_DAO();
	
	   public int modify(Aftercard_student_edit_DTO dto) {
		      Connection conn = null;
		      
		      try {
		         conn = ConnectionProvider.getConnection();
		         int insertedCount = aftercard_student_dao.update(conn, dto);
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

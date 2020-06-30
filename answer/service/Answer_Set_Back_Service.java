package lmsTeamPro.answer.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;
import com.util.JdbcUtil;

import lmsTeamPro.DAO.Answer_Set_Back_DAO;
import lmsTeamPro.DTO.Answer_Set_Back_DTO;


public class Answer_Set_Back_Service {
	
	
	public int insertSetSurv(Answer_Set_Back_DTO dto, String subj_name, String ans_subj_d_code) {
	      Answer_Set_Back_DAO dao = Answer_Set_Back_DAO.getInstance();
	      Connection conn = null;
	      try {

	         conn = ConnectionProvider.getConnection();
	         System.out.println("Service insertSetSurv 실행");
	         int insertedCount = dao.insertSetSurv(conn, dto, subj_name, ans_subj_d_code);
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
	         
	
		   public int insertSurvQ(Answer_Set_Back_DTO dto, String subj_name, String ans_subj_d_code) {
		      Answer_Set_Back_DAO dao = Answer_Set_Back_DAO.getInstance();
		      Connection conn = null;
		      
		      try {
		         conn = ConnectionProvider.getConnection();
		         
		         int insertedCount = dao.insertSurvQ(conn, dto, subj_name, ans_subj_d_code);
		         conn.setAutoCommit(true);
		         System.out.println("Service insertsurvQ 실행");
		         
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
		         
		   

		   public List<Answer_Set_Back_DTO> selectList() {
			      Answer_Set_Back_DAO dao = Answer_Set_Back_DAO.getInstance();
			      try (Connection conn = ConnectionProvider.getConnection()){
			         List<Answer_Set_Back_DTO> list = dao.selectList(conn);
			         
			         System.out.println("Service selectList 실행");
			         return list;
			         
			      } catch (SQLException | NamingException e)  {
			         throw new RuntimeException();
			      
			      }
			   
			   }
	
}

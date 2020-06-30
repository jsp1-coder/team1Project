package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lmsTeamPro.DTO.Answer_Set_DTO;

public class Answer_Set_Code_DAO {

	  private static Answer_Set_Code_DAO dao = null;
	   private Answer_Set_Code_DAO() {}
	   public static Answer_Set_Code_DAO getInstance() {
	      if( dao == null ) {
	         dao = new Answer_Set_Code_DAO();
	      }
	      return dao;
	   }
	   
	   
	   
	   public String getSet_Surv_code(Connection conn
	         , String subj_name, String ans_subj_d_code) {
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      Answer_Set_Subj_Code_DAO Answer_Set_Subj_Code_DAO = null;
	      String subj_code = Answer_Set_Subj_Code_DAO.getInstance().getSubj_Code(conn, subj_name, ans_subj_d_code);
	      System.out.println("Getset_surv_code ÇÔ¼ö : subj_code>>"+ subj_code );
	      try{
	         pstmt = conn.prepareStatement("select s.set_surv_code \r\n" + 
	         		"from set_surv s\r\n" + 
	         		"where s.subj_code = ?");
	         pstmt.setString(1, subj_code);
	         rs = pstmt.executeQuery();
	         String set_surv_code = null;
	         rs.next();
	        set_surv_code = rs.getString("set_surv_code");
				
	        System.out.println("set_surv_code>>"+set_surv_code);
	         return set_surv_code;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         try { pstmt.close();} catch (SQLException e) {   e.printStackTrace();   }
	         try {rs.close();    } catch (SQLException e) {   e.printStackTrace();}
	      
	      }
	      
	      
	      return null;

	   }
	
	
}

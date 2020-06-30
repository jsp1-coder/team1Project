package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Answer_Set_Subj_Code_DAO {
	
	private static Answer_Set_Subj_Code_DAO dao = null;
	   private Answer_Set_Subj_Code_DAO() {}
	   public static Answer_Set_Subj_Code_DAO getInstance() {
	      if( dao == null ) {
	         dao = new Answer_Set_Subj_Code_DAO();
	      }
	      return dao;
	   }
	   
	   
	   
	   public String getSubj_Code(Connection conn
	         , String subj_name, String ans_subj_d_code) {
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try{
	         pstmt = conn.prepareStatement("select sub.subj_code\r\n" + 
	         		"from subj sub\r\n" + 
	         		"where sub.subj_name = ? and sub.subj_d_code = ? ");
	         pstmt.setString(1, subj_name);
	         pstmt.setString(2, ans_subj_d_code);
	         rs = pstmt.executeQuery();
	         String subj_code = null;
	         rs.next();
	         subj_code = rs.getString("subj_code");
	        
	         return subj_code;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         try { pstmt.close();} catch (SQLException e) {   e.printStackTrace();   }
	         try {rs.close();    } catch (SQLException e) {   e.printStackTrace();}
	      
	      }
	      
	      
	      return null;

	   }
	
	
}

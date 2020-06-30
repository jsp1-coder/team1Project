package lmsTeamPro.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Couse_DAO {

		   
		   private static Couse_DAO dao = null;
		   private Couse_DAO() {}
		   public static Couse_DAO getInstance() {
		      if( dao == null ) {
		         dao = new Couse_DAO();
		      }
		      return dao;
		   }
		   
		   
		   
		   public String getCourse_code(Connection conn
		         , String course_name) {
		      
		      ResultSet rs = null;
		      try(PreparedStatement pstmt = 
		            conn.prepareStatement("select  course_code from course where course_name = ?")){
		         pstmt.setString(1, course_name);
		         rs = pstmt.executeQuery();
		         rs.next();
		         String course_Code;
		         course_Code = rs.getString("course_code");
		         return course_Code;
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return course_name;

		   }

	
	
}

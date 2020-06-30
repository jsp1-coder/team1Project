package lmsTeamPro.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Atd_book_DAO {
	
	private static Atd_book_DAO dao = null;
	private Atd_book_DAO() {}
	public static Atd_book_DAO getInstance() {
		if( dao == null ) {
			dao = new Atd_book_DAO();
		}
		return dao;
	}
	
	public String getAtd_book_Code(Connection conn,String enroll_name
			,String atd_book_date) throws SQLException {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select c.atd_book_code " + 
				"from enroll a, std_info b , atd_book c " + 
				"where c.std_info_code = b.std_info_code " + 
				"and a.enroll_code = b.enroll_code " + 
				"and a.enroll_name = ? " + 
				"and c.atd_book_date = ? ";
		try{
			pstmt = 
					conn.prepareStatement(sql);
			pstmt.setString(1, enroll_name);
			pstmt.setString(2, atd_book_date);
			
			rs = pstmt.executeQuery();
			rs.next();
			String atd_book_Code;
			atd_book_Code = rs.getString("atd_book_Code");
			return atd_book_Code;
			
		}finally {
			
		}
		}
	
	
}

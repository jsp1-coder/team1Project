package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Atd_status_DAO {

	private static Atd_status_DAO dao = null;
	private Atd_status_DAO() {}
	public static Atd_status_DAO getInstance() {
		if( dao == null ) {
			dao = new Atd_status_DAO();
		}
		return dao;
	}
	
	public String getAtd_book_Code(Connection conn
			,String atd_status) throws SQLException {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = " select atd_status_code " + 
				" from atd_status " + 
				" where atd_status= ? ";
		try{
			pstmt = 
					conn.prepareStatement(sql);
			pstmt.setString(1, atd_status);
			
			rs = pstmt.executeQuery();
			rs.next();
			String atd_status_code;
			atd_status_code = rs.getString("atd_status_code");
			return atd_status_code;
			
		}finally {
			
		}
		}
	
}

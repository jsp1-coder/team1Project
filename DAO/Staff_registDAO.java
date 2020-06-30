package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lmsTeamPro.DTO.RegistDTO;

public class Staff_registDAO {
	private static Staff_registDAO dao = null;
	private Staff_registDAO() {}
	public static Staff_registDAO getInstance() {
		if( dao == null ) {
			dao = new Staff_registDAO();
		}
		return dao;
	}
	
	public int insert(Connection conn, RegistDTO dto) {
		AuthDAO adao = new AuthDAO();
		Job_RankDAO jdao = new Job_RankDAO();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result  = 0;
			String sql = "insert into staff "
					+ "values('STCO'||(lpad(seq_staff.nextval,4,0)),?,?,?,?,?,?,?,?)";
			try {
				pstmt =  conn.prepareStatement(sql);
				pstmt.setString(1, dto.getStaff_Name());
				pstmt.setString(2, dto.getStaff_Id());
				pstmt.setString(3, dto.getStaff_Pwd());
				pstmt.setDate(4, dto.getStaff_Startdate());
				pstmt.setDate(5, dto.getStaff_Enddate());
				pstmt.setString(6, dto.getStaff_Phone());
				pstmt.setString(7, adao.getAuthCode(conn, dto.getAuth()));
				pstmt.setString(8, jdao.getjob_rankCode(conn, dto.getJob_rank()));
				
				result = pstmt.executeUpdate();
				return result;
			}catch (SQLException e) { 
				e.printStackTrace();
			} finally {
				try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
				try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
			}
			return 0;
		}
		
		
		
		
	
	
}

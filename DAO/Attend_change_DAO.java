package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.DTO.Atd_Status__DTO;
import lmsTeamPro.DTO.Atd_chg_DTO;
import lmsTeamPro.DTO.Attend_book_Student_list_DTO;
import lmsTeamPro.DTO.Training_journal_write_DTO;

public class Attend_change_DAO {
	
	private static Attend_change_DAO dao = null;
	private Attend_change_DAO() {}
	public static Attend_change_DAO getInstance() {
		if( dao == null ) {
			dao = new Attend_change_DAO();
		}
		return dao;
	}
	
	public List<Atd_Status__DTO> selectList(
			Connection conn){

		String sql =" select * " + 
				"from atd_status ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Atd_Status__DTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Atd_Status__DTO dto = null;
			while(rs.next()) {
				dto =  new Atd_Status__DTO();
				dto.setAtd_status(rs.getString("atd_status"));
				
				list.add(dto);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
			try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		}
		return list;		
	}
	
	
	public int insert(Connection conn, Atd_chg_DTO dto, String enroll_name
			,String atd_book_date) {

		Atd_book_DAO adao = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result  = 0;
			String sql = "insert into atd_chg values('ATCH'||(lpad(SEQ_ATD_CHG.nextval,4,0)),?,?) ";
			try {
				pstmt =  conn.prepareStatement(sql);
				pstmt.setString(1, dto.getAtd_chg_reason());
				pstmt.setString(2,adao.getInstance().getAtd_book_Code(conn, enroll_name, atd_book_date) );
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
	
	
	public int update(Connection conn, Atd_chg_DTO dto, String enroll_name
			,String atd_book_date, String atd_status) {

		Atd_book_DAO adao = null;
		Atd_status_DAO sdao= null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result  = 0;
			String sql = "UPDATE atd_book " + 
					" SET atd_status_code = ? " + 
					" where atd_book_code = ? ";
			try {
				pstmt =  conn.prepareStatement(sql);
				pstmt.setString(1,sdao.getInstance().getAtd_book_Code(conn, atd_status));
				pstmt.setString(2,adao.getInstance().getAtd_book_Code(conn, enroll_name, atd_book_date) );
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

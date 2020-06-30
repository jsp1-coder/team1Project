package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lmsTeamPro.DTO.RegistDTO;
import lmsTeamPro.DTO.Training_journal_write_DTO;

public class Training_journal_write_DAO {
	private static Training_journal_write_DAO dao = null;
	private Training_journal_write_DAO() {}
	public static Training_journal_write_DAO getInstance() {
		if( dao == null ) {
			dao = new Training_journal_write_DAO();
		}
		return dao;
	}
	
	public int insert(Connection conn, Training_journal_write_DTO dto) {

		Course_code_DAO cdao = null;
		cdao.getInstance();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result  = 0;
			String sql = "insert into lec_rec values('LERE'||(lpad(SEQ_LEC_REC.nextval,4,0)),?,?,?,?,?,?,?,?)";

			try {
				pstmt =  conn.prepareStatement(sql);
				pstmt.setInt(1, dto.getLec_rec_std());
				pstmt.setInt(2, dto.getLec_atd());
				pstmt.setInt(3, dto.getLec_abs());
				pstmt.setInt(4, dto.getLec_late());;
				pstmt.setInt(5, dto.getLec_earlyleave());
				pstmt.setString(6, dto.getLec_note());
				pstmt.setDate(7, dto.getLec_rec_date());
				pstmt.setString(8, cdao.getCourse_code(conn, dto.getCourse_code()));
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

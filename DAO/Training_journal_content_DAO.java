package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.DTO.Training_journal_content_DTO;
import lmsTeamPro.DTO.Training_journal_list_DTO;

public class Training_journal_content_DAO {
	private static Training_journal_content_DAO dao = null;
	private Training_journal_content_DAO() {}
	public static Training_journal_content_DAO getInstance() {
		if( dao == null ) {
			dao = new Training_journal_content_DAO();
		}
		return dao;
	}
	
	public List<Training_journal_content_DTO> selectList(
			Connection conn, String training_jounal_content){
		
		  String sql ="select a.lec_rec_std, a.lec_atd, a.lec_abs, a.lec_late "
		  		+ ",a.lec_earlyleave, b.lec_period, b.lec_subj, b.lec_lectr, b.lec_content "
		  		+ ", a.lec_note, a.lec_rec_date "
		  		+ " from lec_rec a , lecture b "
		  		+ " where a.lec_rec_code = b.lec_rec_code  and "
		  		+ " a.lec_rec_date =  ?  " ;
		 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Training_journal_content_DTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,training_jounal_content );
			rs = pstmt.executeQuery();
			Training_journal_content_DTO dto = null;
			while(rs.next()) {
				dto =  new Training_journal_content_DTO();
				dto.setLec_rec_std(rs.getInt("lec_rec_std"));	;
				dto.setLec_atd(rs.getInt("lec_atd"));
				dto.setLec_abs(rs.getInt("lec_abs"));
				dto.setLec_late(rs.getInt("lec_late"));
				dto.setLec_earlyleave(rs.getInt("lec_earlyleave"));
				dto.setLec_period(rs.getInt("lec_period"));
				dto.setLec_subj(rs.getString("lec_subj"));
				dto.setLec_lectr(rs.getString("lec_lectr"));
				dto.setLec_content(rs.getString("lec_content"));
				dto.setLec_note(rs.getString("lec_note"));
				dto.setLec_rec_date(rs.getDate("lec_rec_date"));
				
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
	
}

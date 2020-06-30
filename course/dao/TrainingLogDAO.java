package lmsTeamPro.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.course.dto.TrainingLogDTO;

public class TrainingLogDAO {

	private static TrainingLogDAO dao = null;
	private TrainingLogDAO() {}
	public static TrainingLogDAO getInstance() {
		if(dao == null) {
			dao = new TrainingLogDAO();
		}
		return dao;
	
		
	}
	
	public List<TrainingLogDTO> select_lecture(Connection conn, TrainingLogDTO dto) {
		String sql = " select c.course_code, r.lec_rec_code, r.lec_rec_std, r.lec_atd, r.lec_abs " + 
				" ,r.lec_late, r.lec_earlyleave, r.lec_note, r.lec_rec_date " + 
				" , l.lec_code, l.lec_period, l.lec_subj, l.lec_lectr, l.lec_content " + 
				" from course c, lec_rec r, lecture l " + 
				" where c.course_code = r.course_code " + 
				" and r.lec_rec_code = l.lec_rec_code " + 
				" and c.course_code = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TrainingLogDTO> lecture_list  = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCourse_code());
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				dto = new TrainingLogDTO();
				dto.setCourse_code(rs.getString("course_code"));
				dto.setLec_rec_code(rs.getString("lec_rec_code"));
				dto.setLec_rec_std(Integer.parseInt(rs.getString("lec_rec_std")));
				dto.setLec_atd(Integer.parseInt(rs.getString("lec_atd")));
				dto.setLec_abs(Integer.parseInt(rs.getString("lec_abs")));
				dto.setLec_late(Integer.parseInt(rs.getString("lec_late")));
				dto.setLec_earlyleave(Integer.parseInt(rs.getString("lec_earlyleave")));
				dto.setLec_note(rs.getString("lec_note"));
				dto.setLec_rec_date(rs.getString("lec_rec_date"));
				dto.setLec_code(rs.getString("lec_code"));
				dto.setLec_period(Integer.parseInt(rs.getString("lec_period")));
				dto.setLec_subj(rs.getString("lec_subj"));
				dto.setLec_lectr(rs.getString("lec_lectr"));
				dto.setLec_content(rs.getString("lec_content"));
				
				lecture_list.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
			try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		
		}
		
		return lecture_list;
	}
	
	
}

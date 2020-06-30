package lmsTeamPro.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.course.dto.TrainingCourse_RegistrationDTO;

public class TrainingCourse_RegistrationDAO {
	private static TrainingCourse_RegistrationDAO dao = null;
	private TrainingCourse_RegistrationDAO() {}
	public static TrainingCourse_RegistrationDAO getInstance() {
		if(dao == null) {
			dao = new TrainingCourse_RegistrationDAO();
		}
		return dao;
	}
	public List<TrainingCourse_RegistrationDTO> selectStaffName(Connection conn) {
		String sql = " select s.staff_name, l.lectr_info_code  from staff s, lecturer_info l "  
						+ " where s.staff_code = l.staff_code " ;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TrainingCourse_RegistrationDTO> staff_list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			TrainingCourse_RegistrationDTO dto = null;
			while (rs.next()) {
				dto = new TrainingCourse_RegistrationDTO();
				dto.setStaff_name(rs.getString("staff_name"));
				dto.setLectr_info_code(rs.getString("lectr_info_code"));
				staff_list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
			try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		}
		
		return staff_list;
		
	}
	public List<TrainingCourse_RegistrationDTO> selectSubj_gr(Connection conn) {
		String sql = " select subj_gr, subj_gr_code from subj_gr " ;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TrainingCourse_RegistrationDTO> subj_gr = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			TrainingCourse_RegistrationDTO dto = null;
			while (rs.next()) {
				dto = new TrainingCourse_RegistrationDTO();
				dto.setSubj_gr(rs.getString("subj_gr"));
				dto.setSubj_gr_code(rs.getString("subj_gr_code"));
				subj_gr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
			try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		}
		
		return subj_gr;
		
	}
	
	public int insert(Connection conn, TrainingCourse_RegistrationDTO dto) {
		String sql = " insert into subj values('SUBJ' || lpad(seq_subj.nextval,4,0), ? , ? , ?, ?, ?, ?) ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubj_name());
			pstmt.setString(2, dto.getSubj_ability());
			pstmt.setString(3, dto.getSubj_group_num());
			pstmt.setString(4, dto.getLectr_info_code());
			//pstmt.setString(5, ); 과정코드 받아오기
			pstmt.setString(6, dto.getSubj_gr_code());
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		
		
		return 0;
		
	}
	
	
	
}

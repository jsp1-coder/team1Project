package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.util.JdbcUtil;

import lmsTeamPro.DTO.Answer_Set_Back_DTO;

public class Answer_Set_Back_DAO {

	private static Answer_Set_Back_DAO dao = null;
	private Answer_Set_Back_DAO() {}
	public static Answer_Set_Back_DAO getInstance() {
		if(dao == null) {
			dao = new Answer_Set_Back_DAO();
		}
		return dao;


	}

	public int insertSurvQ(Connection conn, Answer_Set_Back_DTO dto, String subj_name, String ans_subj_d_code) {
		PreparedStatement pstmt = null;
		int result = 0;
		Answer_Set_Code_DAO Answer_Set_Code_DAO = null;
		String set_surv_code = Answer_Set_Code_DAO.getInstance().getSet_Surv_code(conn,subj_name, ans_subj_d_code);
	System.out.println("insertSurvQ >>"+set_surv_code);
		String sql = " insert into surv_q values('SURV' || lpad(seq_surv_q.nextval,4,0),?,?,?) ";
		try {
			
			for (int i = 0; i < dto.surv_qs_size(); i++) {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getSurv_qs().get(i));
				pstmt.setString(2, dto.getSurv_write());
				pstmt.setString(3, set_surv_code);
				
				result = pstmt.executeUpdate();
			}
			} catch (Exception e) {
				
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}
		
		return result;
		
	}

	
	public int insertSetSurv(Connection conn, Answer_Set_Back_DTO dto, String subj_name, String ans_subj_d_code) {
		PreparedStatement pstmt = null;
		int result = 0;
		Answer_Set_Subj_Code_DAO Answer_Set_Subj_Code_DAO = null;
		String subj_code = Answer_Set_Subj_Code_DAO.getInstance().getSubj_Code(conn, subj_name, ans_subj_d_code);
System.out.println("innsertSetSurv >>"+subj_code);
		String sql =   "insert into set_surv values( 'SESU' || lpad(seq_set_surv.nextval,4,0) ,?,?,?) ";
		try {
			pstmt = conn.prepareStatement(sql);
			Calendar cal = new GregorianCalendar();
			Date date = new Date(cal.getTimeInMillis());
			pstmt.setDate(1, date);
			pstmt.setString(2, "STCO0001");
			pstmt.setString(3, subj_code);


			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}


		return result;
	}


	
	public ArrayList<Answer_Set_Back_DTO> selectList(
			Connection conn){
		String sql = "select subj_name from subj";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Answer_Set_Back_DTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Answer_Set_Back_DTO dto = null;
			
			while(rs.next()) {
				
				dto =  new Answer_Set_Back_DTO();
				dto.setSubj_name(rs.getString("subj_name"));
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




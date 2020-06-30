package lmsTeamPro.after.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;
import com.util.JdbcUtil;

import lmsTeamPro.after.dao.Aftercard_student_DAO;
import lmsTeamPro.after.model.AftercardDTO;

import lmsTeamPro.after.model.Aftercard_student_DTO;


public class Aftercard_student_Service {
	
	public Aftercard_student_DTO selectOne(String enroll_name) {
		Aftercard_student_DTO dto = null;
		Aftercard_student_DAO dao = Aftercard_student_DAO.getInstance();		
		Connection conn = null ; 
		try{	
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
				
				dto = dao.selectOne(conn, enroll_name);
			conn.commit();
		} catch (SQLException | NamingException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} 
		return dto;
		
	}

	
	
 
	}

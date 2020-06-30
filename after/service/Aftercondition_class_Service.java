package lmsTeamPro.after.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;
import com.util.JdbcUtil;

import lmsTeamPro.after.dao.Aftercard_class_DAO;
import lmsTeamPro.after.model.AftercardDTO;
import lmsTeamPro.after.model.Aftercard_class_DTO;


public class Aftercondition_class_Service {
	
	public List<Aftercard_class_DTO> selectOne(String course_name, int subj_part) {
		Aftercard_class_DAO dao = Aftercard_class_DAO.getInstance();
		try(	Connection conn = 	ConnectionProvider.getConnection() ) { 
			List<Aftercard_class_DTO> list =	dao.selectOne(conn, course_name, subj_part);
		
		return list;
		
	}catch (SQLException | NamingException e) { throw new RuntimeException(e); }
		  
		  }
	
	
 
	}

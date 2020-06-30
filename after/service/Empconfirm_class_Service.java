package lmsTeamPro.after.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;
import com.util.JdbcUtil;

import lmsTeamPro.after.dao.Empconfirm_class_DAO;
import lmsTeamPro.after.model.EmpconfirmDTO;
import lmsTeamPro.after.model.Empconfirm_class_DTO;


public class Empconfirm_class_Service {
	
	public List<Empconfirm_class_DTO> selectOne(String course_name, int subj_part) {
		Empconfirm_class_DAO dao = Empconfirm_class_DAO.getInstance();
		try(	Connection conn = 	ConnectionProvider.getConnection() ) { 
			List<Empconfirm_class_DTO> list =	dao.selectOne(conn, course_name, subj_part);
		
		return list;
		
	}catch (SQLException | NamingException e) { throw new RuntimeException(e); }
		  
		  }
	
	
 
	}

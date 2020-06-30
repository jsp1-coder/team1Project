package lmsTeamPro.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.DAO.Training_journal_list_DAO;
import lmsTeamPro.DTO.Training_journal_list_DTO;

public class Training_jouranl_list_Service {
	
	public List<Training_journal_list_DTO> select(String course_name) {
		Training_journal_list_DAO dao = Training_journal_list_DAO.getInstance();		
		try (Connection conn = ConnectionProvider.getConnection()) {			
			List<Training_journal_list_DTO> list = dao.selectList(conn,course_name);
			// �α� ó��
			// 
			//
			return list;
		} catch (SQLException | NamingException e) {
			throw new RuntimeException(e);
		}
	}
	
}

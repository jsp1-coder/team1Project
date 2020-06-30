package lmsTeamPro.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.DAO.Training_journalDAO;
import lmsTeamPro.DAO.Training_journal_list_DAO;
import lmsTeamPro.DTO.Training_journalDTO;


public class Training_journal_Service {
	
	
	public List<Training_journalDTO> select() {
		Training_journalDAO dao = Training_journalDAO.getInstance();		
		try (Connection conn = ConnectionProvider.getConnection()) {			
			List<Training_journalDTO> list = dao.selectList(conn);
			// �α� ó��
			// 
			//
			return list;
		} catch (SQLException | NamingException e) {
			throw new RuntimeException(e);
		}
	}
}

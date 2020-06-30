package lmsTeamPro.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.DAO.Training_journal_content_DAO;
import lmsTeamPro.DTO.Training_journal_content_DTO;

public class Training_jounal_content_Service {
	public List<Training_journal_content_DTO> select(String training_jounal_content) {
		Training_journal_content_DAO dao = Training_journal_content_DAO.getInstance();		
		try (Connection conn = ConnectionProvider.getConnection()) {			
			List<Training_journal_content_DTO> list = dao.selectList(conn, training_jounal_content );
			// �α� ó��
			// 
			//
			return list;
		} catch (SQLException | NamingException e) {
			throw new RuntimeException(e);
		}
	}
}

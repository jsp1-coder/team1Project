package lmsTeamPro.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.DAO.Attend_book_Course_list_DAO;
import lmsTeamPro.DTO.Attend_book_Course_list_DTO;

public class Attend_book_course_list_Service {

	public List<Attend_book_Course_list_DTO> select() {
		Attend_book_Course_list_DAO dao = Attend_book_Course_list_DAO.getInstance();		
		try (Connection conn = ConnectionProvider.getConnection()) {			
			List<Attend_book_Course_list_DTO> list = dao.selectList(conn);
			// �α� ó��
			// 
			//
			return list;
		} catch (SQLException | NamingException e) {
			throw new RuntimeException(e);
		}
	}
	
}

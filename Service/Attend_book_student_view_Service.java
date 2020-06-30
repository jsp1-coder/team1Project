package lmsTeamPro.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.DAO.Attend_book_student_view_DAO;
import lmsTeamPro.DTO.Attend_book_student_view_DTO;

public class Attend_book_student_view_Service {
	
	public List<Attend_book_student_view_DTO> select(String enroll_name) {
		Attend_book_student_view_DAO dao = Attend_book_student_view_DAO.getInstance();		
		try (Connection conn = ConnectionProvider.getConnection()) {			
			List<Attend_book_student_view_DTO> list = dao.selectList(conn,enroll_name );
			// �α� ó��
			// 
			//
			return list;
		} catch (SQLException | NamingException e) {
			throw new RuntimeException(e);
		}
	}
}

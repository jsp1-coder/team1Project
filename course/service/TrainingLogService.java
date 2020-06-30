package lmsTeamPro.course.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.course.dao.TrainingLogDAO;
import lmsTeamPro.course.dto.TrainingLogDTO;

public class TrainingLogService {

	public List<TrainingLogDTO> select_lecture(TrainingLogDTO dto) {
		TrainingLogDAO dao = TrainingLogDAO.getInstance();
		try(Connection conn = ConnectionProvider.getConnection()) {
			List<TrainingLogDTO> lecture_list = dao.select_lecture(conn, dto);
			
		
			return lecture_list;
		
		} catch (SQLException | NamingException e)  {
			throw new RuntimeException();
		
		}
	}
}

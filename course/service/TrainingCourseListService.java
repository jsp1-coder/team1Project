package lmsTeamPro.course.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.course.dao.TrainingCourseListDAO;
import lmsTeamPro.course.dto.TrainingCourseListDTO;

public class TrainingCourseListService {
 public List<TrainingCourseListDTO> select() {
	 TrainingCourseListDAO dao = TrainingCourseListDAO.getInstance();
	try(Connection conn = ConnectionProvider.getConnection()) {
		List<TrainingCourseListDTO> list = dao.selectList(conn);
	 
	 return list;
	 
	} catch (SQLException  | NamingException e) {
		throw new RuntimeException(e);
	} 
	 
 }
}

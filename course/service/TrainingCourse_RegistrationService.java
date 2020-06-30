package lmsTeamPro.course.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.course.dao.TrainingCourse_RegistrationDAO;
import lmsTeamPro.course.dto.TrainingCourse_RegistrationDTO;

public class TrainingCourse_RegistrationService {
	 public List<TrainingCourse_RegistrationDTO> select_staff_list() {
		 TrainingCourse_RegistrationDAO dao = TrainingCourse_RegistrationDAO.getInstance();
		try(Connection conn = ConnectionProvider.getConnection()) {
			List<TrainingCourse_RegistrationDTO> staff_list = dao.selectStaffName(conn);
			
		 return staff_list ;
		 
		} catch (SQLException  | NamingException e) {
			throw new RuntimeException(e);
		} 
		 
	 }
	 public List<TrainingCourse_RegistrationDTO> select_subj_gr() {
		 TrainingCourse_RegistrationDAO dao = TrainingCourse_RegistrationDAO.getInstance();
		try(Connection conn = ConnectionProvider.getConnection()) {
			List<TrainingCourse_RegistrationDTO> subj_gr = dao.selectSubj_gr(conn);
			
		 return subj_gr ;
		 
		} catch (SQLException  | NamingException e) {
			throw new RuntimeException(e);
		} 
		 
	 }
	
}

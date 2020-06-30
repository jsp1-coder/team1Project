package lmsTeamPro.student.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.DAO.Trainee_ConditionDAO;
import lmsTeamPro.DAO.Trainee_ConditionDAO2;
import lmsTeamPro.DTO.Trainee_ConditionDTO;

public class Trainee_Condition_Service {

	public ArrayList<Trainee_ConditionDTO> selectList(){
	
		Trainee_ConditionDAO dao =Trainee_ConditionDAO.getInstance();
	
		
		System.out.println("서비스셀렉트실행!!!!");
		try(Connection conn=ConnectionProvider.getConnection()) {
			
			ArrayList<Trainee_ConditionDTO> list =  dao.selectList(conn);
			return list;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
			
	}
	
}

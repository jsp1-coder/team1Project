package lmsTeamPro.student.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.DAO.Trainee_ConditionDAO;
import lmsTeamPro.DAO.Trainee_ConditionDAO2;
import lmsTeamPro.DTO.Trainee_ConditionDTO;

public class Trainee_Condition_Service2 {

	public ArrayList<Trainee_ConditionDTO> selectList(){
	
		Trainee_ConditionDAO2 dao2 =Trainee_ConditionDAO2.getInstance();
		
		
		System.out.println("서비스셀렉트실행!!!!");
		try(Connection conn=ConnectionProvider.getConnection()) {
			
			ArrayList<Trainee_ConditionDTO> list2 =  dao2.selectList(conn);
			return list2;
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

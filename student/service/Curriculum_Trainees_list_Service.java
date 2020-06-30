package lmsTeamPro.student.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.DAO.Curriculum_Trainees_listDAO;
import lmsTeamPro.DTO.Curriculum_Trainees_listDTO;


public class Curriculum_Trainees_list_Service {

	public ArrayList<Curriculum_Trainees_listDTO> selectList(String curriculum_subj_d_code){
		
		Curriculum_Trainees_listDAO dao = Curriculum_Trainees_listDAO.getInstance();
	
		
		System.out.println("서비스실행!!!!");
		try(Connection conn=ConnectionProvider.getConnection()) {
			
			ArrayList<Curriculum_Trainees_listDTO> list =  dao.selectList(conn, curriculum_subj_d_code);
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

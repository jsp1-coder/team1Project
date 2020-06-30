package lmsTeamPro.answer.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.DAO.Answer_Set_DAO;
import lmsTeamPro.DTO.Answer_Set_DTO;


public class Answer_Set_Service {
public ArrayList<Answer_Set_DTO> selectList(String ans_subj_d_code){
	
	Answer_Set_DAO dao = Answer_Set_DAO.getInstance();
	
	System.out.println("서비스실행!!!!");
	try(Connection conn=ConnectionProvider.getConnection()) {
		
		ArrayList<Answer_Set_DTO> list =  dao.selectList(conn, ans_subj_d_code);
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

package lmsTeamPro.answer.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.DAO.AnswerResultDAO;
import lmsTeamPro.DTO.AnswerResultDTO;



public class Answer_Result_Service {
public ArrayList<AnswerResultDTO> selectList(String ans_subj_d_code){
		
		AnswerResultDAO dao = AnswerResultDAO.getInstance();
	
		
		System.out.println("서비스실행!!!!");
		try(Connection conn=ConnectionProvider.getConnection()) {
			
			ArrayList<AnswerResultDTO> list =  dao.selectList(conn, ans_subj_d_code);
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

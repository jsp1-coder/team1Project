package lmsTeamPro.answer.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.DAO.AnswerDAO;
import lmsTeamPro.DAO.AnswerDAO2;
import lmsTeamPro.DTO.AnswerDTO;

public class Answer_Service2 {

	public ArrayList<AnswerDTO> selectList(String ans_subj_d_code){
		
		AnswerDAO2 dao2 = AnswerDAO2.getInstance();
	
		
		System.out.println("서비스셀렉트2실행!!!!");
		try(Connection conn=ConnectionProvider.getConnection()) {
			
			ArrayList<AnswerDTO> list2 =  dao2.selectList(conn, ans_subj_d_code);
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

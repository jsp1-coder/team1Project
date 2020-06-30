package lmsTeamPro.answer.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.DAO.AnswerDAO;
import lmsTeamPro.DTO.AnswerDTO;

public class Answer_Service {

	public ArrayList<AnswerDTO> selectList(){
		
		AnswerDAO dao = AnswerDAO.getInstance();
	
		System.out.println("서비스셀렉트실행!!!!");
		try(Connection conn=ConnectionProvider.getConnection()) {
			
			ArrayList<AnswerDTO> list =  dao.selectList(conn);
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

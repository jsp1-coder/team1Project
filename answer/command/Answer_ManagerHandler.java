package lmsTeamPro.answer.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.DTO.AnswerDTO;
import lmsTeamPro.answer.service.Answer_Service;
import lmsTeamPro.answer.service.Answer_Service2;
import lmsTeamPro.command.CommandHandler;


public class Answer_ManagerHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Answer_Service service = new Answer_Service();
		
		
		//Answer_Service2 service2 = new Answer_Service2();
	
		ArrayList<AnswerDTO> list =   service.selectList();
		//ArrayList<AnswerDTO> list2 =   service2.selectList(ans_subj_d_code);
		
	
		// 객체 메소드 호출
		
		request.setAttribute("list", list);
		//request.setAttribute("list2", list2);
		
		// view에 list라는 파라미터를 넘기는 것
		

		return "manager/answer/answer";
	}

}

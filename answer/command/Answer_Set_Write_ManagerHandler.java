package lmsTeamPro.answer.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.DTO.Answer_Set_DTO;
import lmsTeamPro.answer.service.Answer_Set_Service;
import lmsTeamPro.command.CommandHandler;


public class Answer_Set_Write_ManagerHandler implements CommandHandler {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("Set_write 핸들러 실행~");
		
		String subj_name = request.getParameter("subj_sname");
		
		return "manager/answer/answer_set_write";
	}
}

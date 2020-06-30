package lmsTeamPro.answer.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.DTO.Answer_Set_DTO;
import lmsTeamPro.answer.service.Answer_Set_Service;
import lmsTeamPro.command.CommandHandler;


public class Answer_Set_ManagerHandler implements CommandHandler {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("Set 핸들러 실행~");
		String ans_subj_d_code = request.getParameter("ans_subj_d_code");
		
		Answer_Set_Service service = new Answer_Set_Service();
		
		ArrayList<Answer_Set_DTO> list = service.selectList(ans_subj_d_code);
		 
		request.setAttribute("list", list);

		return "manager/answer/answer_set";
	}
}

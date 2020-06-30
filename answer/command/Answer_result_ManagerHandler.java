package lmsTeamPro.answer.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.DTO.AnswerResultDTO;
import lmsTeamPro.answer.service.Answer_Result_Service;
import lmsTeamPro.command.CommandHandler;

public class Answer_result_ManagerHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String ans_subj_d_code = request.getParameter("ans_subj_d_code");
		
		Answer_Result_Service service = new Answer_Result_Service();
		ArrayList<AnswerResultDTO> list = service.selectList(ans_subj_d_code);
		 
		request.setAttribute("list", list);

		return "manager/answer/answer_result";
	}

}

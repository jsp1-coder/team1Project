package lmsTeamPro.student.student.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;

public class Answer_StudentHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "student/answer/answer";
	}

}

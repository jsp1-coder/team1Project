package lmsTeamPro.teacher.assessment.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;

public class Before_score_card_TeacherHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "teacher/assessment/before_score_card";
	}

}

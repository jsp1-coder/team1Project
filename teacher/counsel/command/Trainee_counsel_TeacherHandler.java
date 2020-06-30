package lmsTeamPro.teacher.counsel.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;

public class Trainee_counsel_TeacherHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "teacher/school_register/trainee_counsel";
	}
	

}

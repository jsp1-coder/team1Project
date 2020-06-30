package lmsTeamPro.teacher.student.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;

public class Curriculum_Trainees_list_TeacherHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "teacher/curriculum_Trainees/curriculum_Trainees_list";
	}

}

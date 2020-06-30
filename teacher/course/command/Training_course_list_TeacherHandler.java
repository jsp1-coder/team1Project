package lmsTeamPro.teacher.course.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;

public class Training_course_list_TeacherHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		return "teacher/training_Course/training_Course_list";
	}

}

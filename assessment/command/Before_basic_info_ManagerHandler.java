package lmsTeamPro.assessment.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.course.dto.TrainingCourseListDTO;
import lmsTeamPro.course.service.TrainingCourseListService;

public class Before_basic_info_ManagerHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			TrainingCourseListService service = new TrainingCourseListService();
			List<TrainingCourseListDTO> list = service.select();
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "manager/assessment/before_basic_info";
	}

}

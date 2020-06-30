package lmsTeamPro.course.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.course.dto.TrainingCourseListDTO;
import lmsTeamPro.course.service.TrainingCourseListService;

public class TrainingCourse_list_ManagerHandler implements CommandHandler {

	private static final String FORM_VIEW = "manager/training_Course/training_Course_list";
	//private TrainingCourseListService listService = new TrainingCourseListService();
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request, response);
		} else if (request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);
		}else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		
		
		return null;
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		try {
			TrainingCourseListService service = new TrainingCourseListService();
			List<TrainingCourseListDTO> list = service.select();
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FORM_VIEW;
	}

}

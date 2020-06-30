package lmsTeamPro.course.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.course.dto.TrainingCourseListDTO;
import lmsTeamPro.course.dto.Training_Course_Registr_CourseDTO;
import lmsTeamPro.course.dto.Training_Course_UpdateDTO;
import lmsTeamPro.course.service.TrainingCourseListService;
import lmsTeamPro.course.service.Training_Course_Registr_CourseService;
import lmsTeamPro.course.service.Training_Course_UpdateService;

public class Training_Course_Update_ManagerHandler implements CommandHandler{
	private static final String FORM_VIEW = "manager/training_Course/training_Course_Update";
	
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
		Training_Course_UpdateDTO dto = new Training_Course_UpdateDTO();
		dto.setC_t_code(request.getParameter("c_t_code"));
		dto.setCourse_code(request.getParameter("course_code"));
		try {
			TrainingCourseListService service2 = new TrainingCourseListService();
			Training_Course_UpdateService service = new Training_Course_UpdateService();
			service.update_Course(dto);
			
			List<TrainingCourseListDTO> list = service2.select();
			request.setAttribute("list", list);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "manager/training_Course/training_Course_list";
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		try {
			TrainingCourseListService service = new TrainingCourseListService();
			Training_Course_Registr_CourseService service2 = new Training_Course_Registr_CourseService();
			List<TrainingCourseListDTO> list = service.select();
			request.setAttribute("list", list);
			List<Training_Course_Registr_CourseDTO> course_list = service2.select_Course();
			request.setAttribute("course_list", course_list);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FORM_VIEW;
	}
}

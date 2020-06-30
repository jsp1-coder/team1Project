package lmsTeamPro.course.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.course.dto.TrainingLogDTO;
import lmsTeamPro.course.service.TrainingLogService;

public class Training_Course_TrainingLog_List_ManagerHandler implements CommandHandler{
	private static final String FORM_VIEW = "manager/training_Course/training_Course_TrainingLog_List";
	///lmsTeamPro/manager/training_Course/training_Course_TrainingLog_List.jsp

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
		String course_code = request.getParameter("course_code");		
		TrainingLogDTO dto = new TrainingLogDTO();
		dto.setCourse_code(course_code);
		
		try {
			
			TrainingLogService service = new TrainingLogService();
			List<TrainingLogDTO> list = service.select_lecture(dto);
			request.setAttribute("list", list);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return FORM_VIEW;
	}
}

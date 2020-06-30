package lmsTeamPro.course.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.course.dto.TrainingCourseListDTO;
import lmsTeamPro.course.dto.Training_Course_list_DeleteDTO;
import lmsTeamPro.course.service.TrainingCourseListService;
import lmsTeamPro.course.service.Training_Course_list_DeleteService;

public class Training_Course_list_Delete_ManagerHandler implements CommandHandler{
	
	private static final String FORM_VIEW = "manager/training_Course/training_Course_list";
	
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
		// TODO Auto-generated method stub
		return null;
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		Training_Course_list_DeleteDTO dto = new Training_Course_list_DeleteDTO();
		dto.setCourse_code(request.getParameter("course_code"));
		dto.setSubj_d_code(request.getParameter("subj_d_code"));
		try {
			TrainingCourseListService service = new TrainingCourseListService();
			Training_Course_list_DeleteService service2 = new Training_Course_list_DeleteService();
			service2.delete_subj(dto);
			service2.delete_std_info(dto);
			service2.delete_subj_d(dto);
			service2.delete_Course(dto);
			
			List<TrainingCourseListDTO> list = service.select();
			request.setAttribute("list", list);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return FORM_VIEW;
	}
	
}

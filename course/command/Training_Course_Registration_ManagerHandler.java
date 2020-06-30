package lmsTeamPro.course.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.course.dto.TrainingCourse_RegistrationDTO;
import lmsTeamPro.course.service.TrainingCourse_RegistrationService;

public class Training_Course_Registration_ManagerHandler implements CommandHandler{
	private static final String FORM_VIEW = "manager/training_Course/training_Course_list_Registration";
	
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
		TrainingCourse_RegistrationDTO dto = new TrainingCourse_RegistrationDTO();
		dto.setLectr_info_code(request.getParameter("lectr_info_code"));
		dto.setSubj_gr_code(request.getParameter("subj_gr_code"));
		dto.setSubj_name(request.getParameter("subj_name"));
		dto.setSubj_ability(request.getParameter("subj_ability"));
		dto.setSubj_group_num(request.getParameter("subj_group_num"));
		
		return null;
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			TrainingCourse_RegistrationService service = new TrainingCourse_RegistrationService();
			List<TrainingCourse_RegistrationDTO> staff_list = service.select_staff_list();
			List<TrainingCourse_RegistrationDTO> subj_gr = service.select_subj_gr();
			
			request.setAttribute("staff_list", staff_list);
			request.setAttribute("subj_gr",subj_gr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FORM_VIEW;
	}

}

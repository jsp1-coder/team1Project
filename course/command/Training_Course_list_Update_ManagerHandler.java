package lmsTeamPro.course.command;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.course.dto.TrainingCourseListDTO;
import lmsTeamPro.course.dto.Training_Course_List_UpdateDTO;
import lmsTeamPro.course.dto.Training_Course_Registr_CourseDTO;
import lmsTeamPro.course.service.TrainingCourseListService;
import lmsTeamPro.course.service.Training_Course_Registr_CourseService;
import lmsTeamPro.course.service.Training_Course_list_UpdateService;

public class Training_Course_list_Update_ManagerHandler implements CommandHandler{
	private static final String FORM_VIEW = "manager/training_Course/training_Course_list_Update";
	
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
		Training_Course_List_UpdateDTO dto = new Training_Course_List_UpdateDTO();
		dto.setCourse_name(request.getParameter("course_name"));
		dto.setCourse_code_code(request.getParameter("course_code_code"));
		dto.setEdu_in_code(request.getParameter("edu_in_code"));
		dto.setC_t_code(request.getParameter("c_t_code"));
		dto.setMngr_info_code(request.getParameter("mngr_info_code"));
		dto.setSubj_startdate(Date.valueOf(request.getParameter("subj_startdate")));
		dto.setSubj_enddate(Date.valueOf(request.getParameter("subj_enddate")));
		dto.setDay_of_week(request.getParameter("day_of_week"));
		dto.setSubj_part(Integer.parseInt(request.getParameter("subj_part")));
		dto.setSubj_ppl(Integer.parseInt(request.getParameter("subj_ppl")));
		dto.setClassroom(request.getParameter("classroom"));
		dto.setCourse_code(request.getParameter("course_code"));
		dto.setSubj_d_code(request.getParameter("subj_d_code"));
		try {
			Training_Course_list_UpdateService service = new Training_Course_list_UpdateService();
			service.update_Course(dto);
			service.update_subj_d(dto);
			
			TrainingCourseListService service2= new TrainingCourseListService();
			List<TrainingCourseListDTO> list = service2.select();
			request.setAttribute("list", list);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
		
		
		return "manager/training_Course/training_Course_list";
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		String subj_d_code = request.getParameter("subj_d_code");
		
		
		
		try {
		Training_Course_List_UpdateDTO dto = new Training_Course_List_UpdateDTO();	
			dto.setSubj_d_code(subj_d_code);
			Training_Course_list_UpdateService service2 = new Training_Course_list_UpdateService();
			service2.select(dto);
			Training_Course_Registr_CourseService service = new Training_Course_Registr_CourseService();
			List<Training_Course_Registr_CourseDTO> staff_list = service.select_StaffName();
			List<Training_Course_Registr_CourseDTO> course_list = service.select_Course();
			List<Training_Course_Registr_CourseDTO> edu_list = service.select_EduName();
			List<Training_Course_List_UpdateDTO> select_list = service2.select(dto);
			request.setAttribute("edu_list", edu_list);
			request.setAttribute("staff_list", staff_list);
			request.setAttribute("course_list", course_list);
			request.setAttribute("list", select_list);
		} catch (Exception e) {
		
		
		}
			
		
		
		return FORM_VIEW;
	}
}

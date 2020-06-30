package lmsTeamPro.journal.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.Service.Training_journal_write_service;
import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.DTO.Training_journal_write_DTO;

public class Training_journal_write_ManagerHandler implements CommandHandler {

	private static final String FORM_VIEW 	= "manager/journal/traing_jounal_write";
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		if (request.getMethod().equals("GET")) {
			
			return processForm(request, response);
			
		} else if(request.getMethod().equals("POST")) {
			
			return processSubmit(request, response);
		}
		
		return "";
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		
		Training_journal_write_DTO dto = new Training_journal_write_DTO();
		dto.setLec_rec_std(Integer.parseInt(request.getParameter("lec_rec_std")));
		dto.setLec_atd(Integer.parseInt(request.getParameter("lec_atd")));
		dto.setLec_abs(Integer.parseInt(request.getParameter("lec_abs")));
		dto.setLec_rec_std(Integer.parseInt(request.getParameter("lec_rec_std")));
		dto.setLec_rec_std(Integer.parseInt(request.getParameter("lec_rec_std")));
		dto.setLec_late(Integer.parseInt(request.getParameter("lec_late")));
		dto.setLec_earlyleave(Integer.parseInt(request.getParameter("lec_earlyleave")));
		
		dto.setLec_period1(Integer.parseInt(request.getParameter("lec_period1")));
		dto.setLec_subj1(request.getParameter("lec_subj1"));
		dto.setLec_lectr1(request.getParameter("lec_lectr1"));
		dto.setLec_content1(request.getParameter("lec_content1"));
		dto.setLec_period2(Integer.parseInt(request.getParameter("lec_period2")));
		dto.setLec_subj2(request.getParameter("lec_subj2"));
		dto.setLec_lectr2(request.getParameter("lec_lectr2"));
		dto.setLec_content2(request.getParameter("lec_content2"));
		dto.setLec_period3(Integer.parseInt(request.getParameter("lec_period3")));
		dto.setLec_subj3(request.getParameter("lec_subj3"));
		dto.setLec_lectr3(request.getParameter("lec_lectr3"));
		dto.setLec_content3(request.getParameter("lec_content3"));
		
		dto.setLec_note(request.getParameter("lec_note"));
		dto.setLec_rec_date(Date.valueOf(request.getParameter("lec_rec_date")));
		dto.setCourse_code(request.getParameter("course_name"));
		System.out.println("�ڽ����� >> "+ request.getParameter("course_name"));
		try {
			Training_journal_write_service service = new Training_journal_write_service();
			int result = service.write(dto);
			if( result == 1)	response.sendRedirect("/lmsTeamPro/manager/journal/training_jounal_list.do?training_jounal_list="+ request.getParameter("course_name"));
		} catch (Exception e) { 
				e.printStackTrace();
		}
		

		return null;
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		return FORM_VIEW;
	}

}

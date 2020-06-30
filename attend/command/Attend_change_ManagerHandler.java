package lmsTeamPro.attend.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.Service.Attend_change_Service;
import lmsTeamPro.Service.Training_journal_write_service;
import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.DTO.Atd_Status__DTO;
import lmsTeamPro.DTO.Atd_chg_DTO;

public class Attend_change_ManagerHandler implements CommandHandler {

	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getMethod().equals("GET")){
			
			return processForm(request, response);
			
		} else if(request.getMethod().equals("POST")) {
			
			return processSubmit(request, response);
		}
		
		
		return "manager/attend/attend_change";
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		
		String atd_chg_reason = request.getParameter("atd_chg_reason");
		String atd_status = request.getParameter("atd_status");
		String enroll_name= request.getParameter("enroll_name");
		String	atd_book_date = request.getParameter("atd_book_date");
		System.out.println("���� >> "+atd_chg_reason);
		System.out.println("���� >> "+atd_status);
		System.out.println("�̸� >> "+enroll_name);
		System.out.println("��¥ >> "+atd_book_date);
		
		Atd_chg_DTO dto = new Atd_chg_DTO();
		dto.setAtd_chg_reason(atd_chg_reason);
		Atd_Status__DTO adto = new Atd_Status__DTO();
		adto.setAtd_status(atd_status);
		
		try {
			Attend_change_Service attend_change_Service = new Attend_change_Service();
			
			int result = attend_change_Service.insert(dto, enroll_name,atd_book_date);
			int result2 = attend_change_Service.update(dto, enroll_name,atd_book_date,atd_status);
			if( result == 1 && result2 ==1)	response.sendRedirect("/lmsTeamPro/manager/attend/attend_book_student_list.do");
		} catch (Exception e) { 
				e.printStackTrace();
		}
		
		
		
	
		
		
		return null;
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		
		
		String atd_book_date = request.getParameter("atd_book_date");
		String enroll_name = request.getParameter("enroll_name");
		String std_status = request.getParameter("std_status");
		
		Attend_change_Service attend_change_Service = new Attend_change_Service();
		List<Atd_Status__DTO> list = attend_change_Service.select();
		
		request.setAttribute("list", list);
		
		return  "manager/attend/attend_change";
	}

}

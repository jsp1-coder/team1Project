package lmsTeamPro.attend.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.Service.Attend_book_Student_list_Service;
import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.DTO.Attend_book_Student_list_DTO;

public class Attend_book_student_list_ManagerHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Attend_book_Student_list_Service attend_book_Student_list_Service
		= new Attend_book_Student_list_Service();
		
		List<Attend_book_Student_list_DTO> list =  attend_book_Student_list_Service.select();
		
		request.setAttribute("list",list);
		
		return "manager/attend/attend_book_student_list";
	}

	
	
}

package lmsTeamPro.attend.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.Service.Attend_book_student_view_Service;
import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.DTO.Attend_book_student_view_DTO;

public class Attend_book_student_view_ManagerHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String enroll_name = request.getParameter("enroll_name");
		
		Attend_book_student_view_Service attend_book_student_view_Service
		 = new Attend_book_student_view_Service();
		List<Attend_book_student_view_DTO> list =   attend_book_student_view_Service.select(enroll_name);
		
		request.setAttribute("list", list);
		
		return "manager/attend/attend_book_student_view";
	}

}

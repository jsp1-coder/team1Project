package lmsTeamPro.attend.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.Service.Attend_book_course_view_Service;
import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.DTO.Attend_book_course_view_DTO;

public class Attend_book_course_view_ManagerHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String course_name = request.getParameter("course_name");
		String subj_part = request.getParameter("subj_part");
		Attend_book_course_view_Service attend_book_course_view_Service
		 = new Attend_book_course_view_Service();
		List<Attend_book_course_view_DTO> list = attend_book_course_view_Service.select(course_name, subj_part);
		request.setAttribute("list", list);
		
		return "manager/attend/attend_book_course_view";
	}

}

package lmsTeamPro.journal.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.Service.Training_jouranl_list_Service;
import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.DTO.Training_journal_list_DTO;

public class Training_journal_list_ManagerHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String course_name = request.getParameter("training_jounal_list");
		
		System.out.println(course_name);
		
		
		Training_jouranl_list_Service training_jouranl_list_Service = new Training_jouranl_list_Service();
		List<Training_journal_list_DTO> list =  training_jouranl_list_Service.select(course_name);
	
		request.setAttribute("list", list);
		
		return "manager/journal/traing_jounal_list";
	}

	
}

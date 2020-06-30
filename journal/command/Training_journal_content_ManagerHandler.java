package lmsTeamPro.journal.command;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.Service.Training_jounal_content_Service;
import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.DTO.Training_journal_content_DTO;

public class Training_journal_content_ManagerHandler  implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Training_jounal_content_Service training_jounal_content_Service = new Training_jounal_content_Service();
		String training_jounal_content = request.getParameter("training_jounal_content");
		
		List<Training_journal_content_DTO> list = training_jounal_content_Service.select(training_jounal_content);
		request.setAttribute("list", list);
		
		return "manager/journal/traing_jounal_content";
	}

}

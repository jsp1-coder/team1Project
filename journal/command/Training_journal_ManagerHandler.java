package lmsTeamPro.journal.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.Service.Training_journal_Service;
import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.DTO.Training_journalDTO;

public class Training_journal_ManagerHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Training_journal_Service training_journal_service = new Training_journal_Service();
		
		List<Training_journalDTO> list = training_journal_service.select(); 
		
		request.setAttribute("list", list);
		
		return "manager/journal/traing_jounal";
	}

}

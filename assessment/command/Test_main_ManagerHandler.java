package lmsTeamPro.assessment.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;

public class Test_main_ManagerHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "manager/test/testmain";
		
	}

}
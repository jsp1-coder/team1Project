package lmsTeamPro.student.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;

public class Daily_Gathering_Status_ManagerHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "manager/daily_Gathering_Status/daily_Gathering_Status";
	}

}

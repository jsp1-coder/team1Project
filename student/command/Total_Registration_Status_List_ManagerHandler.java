package lmsTeamPro.student.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;

public class Total_Registration_Status_List_ManagerHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "manager/registration_Status/total_Registration_Status_List";
	}

}

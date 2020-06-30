package lmsTeamPro.regist.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.Service.Staff_Regist_Service;
import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.DTO.RegistDTO;

public class Regist_ManagerHandler implements CommandHandler{
	private static final String FORM_VIEW ="manager/regist/regist";
	private Staff_Regist_Service staff_regist = new Staff_Regist_Service();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equals("GET")) {
			return prossForm(request,response);
			
		} else if(request.getMethod().equals("POST")) {
			return processSubmit(request,response);
		}
		
					return "FORM_VIEW";
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		
		RegistDTO dto = new RegistDTO();

		dto.setStaff_Name(request.getParameter("name"));
		dto.setStaff_Id(request.getParameter("id"));
		dto.setStaff_Pwd(request.getParameter("pwd"));
		dto.setStaff_Phone(request.getParameter("phonenumber"));
		dto.setStaff_Startdate(Date.valueOf(request.getParameter("startdate")));
		dto.setStaff_Enddate(Date.valueOf(request.getParameter("enddate")));
		dto.setAuth(request.getParameter("auth"));
		dto.setJob_rank(request.getParameter("job_rank"));

	try {
		Staff_Regist_Service service = new Staff_Regist_Service();
		int result = service.write(dto);
		if( result == 1)	response.sendRedirect("/lmsTeamPro/manager/regist/regist.do");
	} catch (Exception e) { 
			e.printStackTrace();
	}
	return null;
	}

	private String prossForm(HttpServletRequest request, HttpServletResponse response) {
		
		return FORM_VIEW;
	}

} // �ڵ鷯


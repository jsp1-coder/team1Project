package lmsTeamPro.login.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.login.service.LoginFailException;
import lmsTeamPro.login.service.StaffLoginService;
import lmsTeamPro.login.service.StaffUser;

public class Login_ManagerHandler implements CommandHandler {

	private static final String FORM_VIEW = "main/login/manager_login";
	private StaffLoginService loginService = new StaffLoginService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest request
			, HttpServletResponse response) 
	throws Exception {
		String staff_id = trim(request.getParameter("staff_id"));
		String staff_pwd = trim(request.getParameter("staff_pwd"));

		Map<String, Boolean> errors = new HashMap<>();
		request.setAttribute("errors", errors);

		if (staff_id == null || staff_id.isEmpty())
			errors.put("staff_id", Boolean.TRUE);
		if (staff_pwd == null || staff_pwd.isEmpty())
			errors.put("staff_pwd", Boolean.TRUE );

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}


		try {
			StaffUser user = loginService.login(staff_id, staff_pwd);
			request.getSession().setAttribute("authUser", user);	// ���ǿ� ����
			response.sendRedirect(request.getContextPath() + "/main/manager_main.do");
			return null;			
			
		} catch (LoginFailException e) {			
			errors.put("idOrPwNotMatch", Boolean.TRUE );
			return FORM_VIEW;
		}
	}

	private String trim(String str) {
		return str == null ? null : str.trim();
	}
}

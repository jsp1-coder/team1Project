package lmsTeamPro.login.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.login.service.LoginFailException;
import lmsTeamPro.login.service.StudentLoginService;
import lmsTeamPro.login.service.StudentUser;

public class Login_StudentHandler implements CommandHandler{

	private static final String FORM_VIEW = "main/login/student_login";
	private StudentLoginService loginService = new StudentLoginService();
	
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
		String std_id = trim(request.getParameter("std_id"));
		String std_pwd = trim(request.getParameter("std_pwd"));

		Map<String, Boolean> errors = new HashMap<>();
		request.setAttribute("errors", errors);

		if (std_id == null || std_id.isEmpty())
			errors.put("std_id", Boolean.TRUE);
		if (std_pwd == null || std_pwd.isEmpty())
			errors.put("std_pwd", Boolean.TRUE );

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}


		try {
			StudentUser user = loginService.login(std_id, std_pwd);
			request.getSession().setAttribute("authUser", user);	// 세션에 저장
			response.sendRedirect(request.getContextPath() + "/main/student_main.do");
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

package lmsTeamPro.student.student.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;
import student.model.Before_AppraisalDTO;
import student.service.Before_AppraisalListService;

public class Before_appraisal_StudentHandler implements CommandHandler{

		
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("핸들러실행");
		try {
			Before_AppraisalListService service = new Before_AppraisalListService();
		List<Before_AppraisalDTO> list= service.before_appraisalSelect();
		request.setAttribute("list",list);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "student/before_appraisal/before_appraisal";
	}

}

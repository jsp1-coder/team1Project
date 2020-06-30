package lmsTeamPro.student.student.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;
import student.model.AfterCardDTO;

import student.service.AfterCardListService;


public class After_card_StudentHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			AfterCardListService service = new AfterCardListService();
			List<AfterCardDTO> list= service.afterCardSelect();
			request.setAttribute("list",list);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return "student/after_card/after_card";
	}

}

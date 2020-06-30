package lmsTeamPro.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.model.CardDTO;
import student.service.CardListService;

public class Main_StudentHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("핸들러실행");
		try {
		CardListService service = new CardListService();
		List<CardDTO> list= service.cardSelect();
		request.setAttribute("list",list);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "student/main/student_main";
	}

}

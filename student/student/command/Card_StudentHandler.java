package lmsTeamPro.student.student.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.course.dto.TrainingCourseListDTO;
import lmsTeamPro.course.service.TrainingCourseListService;
import student.model.CardDTO;
import student.service.CardListService;
import student.service.CardUpdateService;

public class Card_StudentHandler implements CommandHandler {
	  

	  @Override
	   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      if (request.getMethod().equalsIgnoreCase("GET")) {
	         return processForm(request, response);
	      } else if (request.getMethod().equalsIgnoreCase("POST")) {
	         return processSubmit(request, response);
	      }else {
	         response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	         return null;
	      }
	   }
	  
	
	 //GET
	public String processForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("핸들러실행");
		try {
		CardListService service = new CardListService();
		List<CardDTO> list= service.cardSelect();
		request.setAttribute("list",list);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "student/card/card";
	}
	
	//POST
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {

	     
	      return "student/card/card";
	   }
	
	
}

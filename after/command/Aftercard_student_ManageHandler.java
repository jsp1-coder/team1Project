package lmsTeamPro.after.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.after.model.Aftercard_student_DTO;
import lmsTeamPro.after.service.Aftercard_student_Service;
import lmsTeamPro.command.CommandHandler;

public class Aftercard_student_ManageHandler implements CommandHandler {

	private static final String FORM_VIEW = "manager/after/aftercard_student";
	   
	   private Aftercard_student_Service aftercard_student_Service = new Aftercard_student_Service();	
	
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

	   private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
	      
	      
	      return null;
	   }

	   private String processForm(HttpServletRequest request, HttpServletResponse response) {
		   
		   try {
		    	  
		    	 String enroll_name = request.getParameter("enroll_name");
		    	 
		         Aftercard_student_DTO dto = this.aftercard_student_Service.selectOne(enroll_name);
		         request.setAttribute("dto", dto);
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		      return FORM_VIEW;
		   }
	
	
}

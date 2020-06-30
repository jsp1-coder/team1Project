package lmsTeamPro.after.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.after.model.AftercardDTO;
import lmsTeamPro.after.model.Aftercard_class_DTO;
import lmsTeamPro.after.service.AftercardService;
import lmsTeamPro.after.service.Aftercard_class_Service;

public class Aftercard_class_ManageHandler implements CommandHandler {

   private static final String FORM_VIEW = "manager/after/aftercard_class";
   
   private Aftercard_class_Service aftercard_classService = new Aftercard_class_Service();
   
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
	    	  Aftercard_class_Service service = new Aftercard_class_Service();
	    	  
	    	 String course_name = request.getParameter("course_name");
	    	 int subj_part = Integer.parseInt(request.getParameter("subj_part"));
	    	 
	         List<Aftercard_class_DTO> list = service.selectOne(course_name, subj_part);
	         request.setAttribute("list", list);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return FORM_VIEW;
	   }

}
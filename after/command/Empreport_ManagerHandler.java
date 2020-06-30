package lmsTeamPro.after.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.after.model.EmpreportDTO;
import lmsTeamPro.after.service.EmpreportService;

public class Empreport_ManagerHandler implements CommandHandler {

   private static final String FORM_VIEW = "manager/after/empreport_list";
   
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
    	  EmpreportService service = new EmpreportService();
         List<EmpreportDTO> list1 = service.select1();
         List<EmpreportDTO> list2 = service.select2();
         List<EmpreportDTO> list3 = service.select3();
         List<EmpreportDTO> list4 = service.select4();
         List<EmpreportDTO> list5 = service.select5();
         
         request.setAttribute("list1", list1);
         request.setAttribute("list2", list2);
         request.setAttribute("list3", list3);
         request.setAttribute("list4", list4);
         request.setAttribute("list5", list5);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return FORM_VIEW;
   }

}
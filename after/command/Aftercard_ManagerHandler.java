package lmsTeamPro.after.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.after.model.AftercardDTO;
import lmsTeamPro.after.service.AftercardService;

public class Aftercard_ManagerHandler implements CommandHandler {

   private static final String FORM_VIEW = "manager/after/aftercard_list";
   
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
    	  AftercardService service = new AftercardService();
         List<AftercardDTO> list = service.select();
         request.setAttribute("list", list);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return FORM_VIEW;
   }

}
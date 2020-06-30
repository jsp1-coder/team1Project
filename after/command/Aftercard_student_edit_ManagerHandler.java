package lmsTeamPro.after.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBConn;

import lmsTeamPro.after.dao.Aftercard_student_DAO;

import lmsTeamPro.after.model.Aftercard_student_DTO;
import lmsTeamPro.after.model.Aftercard_student_edit_DTO;

import lmsTeamPro.after.service.Aftercard_student_Service;
import lmsTeamPro.after.service.Aftercard_student_edit_Service;

import lmsTeamPro.command.CommandHandler;

public class Aftercard_student_edit_ManagerHandler implements CommandHandler{

	private static final String FORM_VIEW = "manager/after/aftercard_edit";

	private Aftercard_student_edit_Service aftercard_student_edit_Service = new Aftercard_student_edit_Service();	
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

		Aftercard_student_edit_DTO dto = new Aftercard_student_edit_DTO();

		System.out.println(request.getParameter("desired_loc1")); 
  	  
    	dto.setStd_info_code(request.getParameter("std_info_code")); 
    	dto.setEnroll_name(request.getParameter("enroll_name"));
    	dto.setDesired_loc1( request.getParameter("desired_loc1"));
    	dto.setDesired_loc2(request.getParameter("desired_loc2"));
    	dto.setDesired_loc3(request.getParameter("desired_loc3"));
    	dto.setDesired_field(request.getParameter("desired_field"));
    	dto.setDesired_sal(request.getParameter("desired_sal"));
    	dto.setDesired_employment(request.getParameter("desired_employment"));
    	dto.setDesired_work(request.getParameter("desired_work"));
    	dto.setDesired_workhours(request.getParameter("desired_workhours"));
    	dto.setDesired_note(request.getParameter("desired_note"));
    	 
    
    	 try {   
    	 Aftercard_student_edit_Service service = new Aftercard_student_edit_Service();
    	
         service.modify(dto);
         
         
         Aftercard_student_Service service2= new Aftercard_student_Service();
         Aftercard_student_DTO dto2 = service2.selectOne(dto.getEnroll_name());
         request.setAttribute("dto", dto2);

    	 
      } catch (Exception e) {
         e.printStackTrace();
      }
      return "manager/after/aftercard_student";

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

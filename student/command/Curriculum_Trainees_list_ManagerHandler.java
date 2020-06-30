package lmsTeamPro.student.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.DTO.Curriculum_Trainees_listDTO;
import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.student.service.Curriculum_Trainees_list_Service;

public class Curriculum_Trainees_list_ManagerHandler implements CommandHandler{

		
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String curriculum_subj_d_code = request.getParameter("curriculum_subj_d_code");
		System.out.println(curriculum_subj_d_code);
		Curriculum_Trainees_list_Service service = new Curriculum_Trainees_list_Service();
		ArrayList<Curriculum_Trainees_listDTO> list =   service.selectList(curriculum_subj_d_code);
		 
		request.setAttribute("list", list);
		return "manager/curriculum_Trainees/curriculum_Trainees_list";
	}

}

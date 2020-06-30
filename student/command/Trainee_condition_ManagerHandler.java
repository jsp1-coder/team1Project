package lmsTeamPro.student.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.DTO.Trainee_ConditionDTO;
import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.student.service.Trainee_Condition_Service;
import lmsTeamPro.student.service.Trainee_Condition_Service2;

public class Trainee_condition_ManagerHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Trainee_Condition_Service service = new Trainee_Condition_Service();
		Trainee_Condition_Service2 service2 = new Trainee_Condition_Service2();
		
		//서비스 객체 생성해서 
		
		ArrayList<Trainee_ConditionDTO> list =   service.selectList();
		ArrayList<Trainee_ConditionDTO> list2 =   service2.selectList();
		// 객체 메소드 호출
		
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		// view에 list라는 파라미터를 넘기는 것
		
		return "manager/school_register/trainee_condition";
	}

}

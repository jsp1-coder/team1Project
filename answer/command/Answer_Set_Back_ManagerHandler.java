package lmsTeamPro.answer.command;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.DTO.AnswerDTO;
import lmsTeamPro.DTO.Answer_Set_Back_DTO;
import lmsTeamPro.answer.service.Answer_Service;
import lmsTeamPro.answer.service.Answer_Set_Back_Service;
import lmsTeamPro.command.CommandHandler;


public class Answer_Set_Back_ManagerHandler implements CommandHandler {

	private static final String FORM_VIEW = "manager/answer/answer";
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("process 실행!");
		//String ans_subj_d_code = request.getParameter("ans_subj_d_code");
		String subj_name = request.getParameter("subj_sname");

		String num = request.getParameter("num");


		if(request.getMethod().equalsIgnoreCase("GET"))
		{ return processForm(request,response); 
		} 
		else if(request.getMethod().equalsIgnoreCase("POST")) 
		{ 
			return processSubmit(request, response); 
		}
		else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); return null;
		}
	}

	@SuppressWarnings("null")
	private String processSubmit(HttpServletRequest request, HttpServletResponse
			response) { 
		String subj_name = request.getParameter("subj_name");
		String ans_subj_d_code = request.getParameter("ans_subj_d_code");
		System.out.println("post ans_subj_d_code>>"+ans_subj_d_code);
		System.out.println("post subj_name >>" + subj_name);
		System.out.println("processSubmit 실행");
		Answer_Set_Back_DTO dto = new Answer_Set_Back_DTO();
		//dto.setCourse_name(request.getParameter("course_name"));
		// dto.setSurv_q(request.getParameterValues("surv_q"));
		// dto.setSubj_name(request.getParameter("subj_name"));
		dto.setSurv_write(request.getParameter("surv_write"));
		String [] surv_q_array = request.getParameterValues("surv_q");
		for (int i = 0; i < surv_q_array.length; i++) {
			System.out.println(surv_q_array[i]);
		}

		ArrayList<String> surv_qs = new ArrayList<String>();

		for (int i = 0; i < surv_q_array.length; i++) {
			surv_qs.add(surv_q_array[i]);
		}
		dto.setSurv_qs(surv_qs);

		Enumeration<String> pnames = request.getParameterNames();
		while (pnames.hasMoreElements()) {
			String pn = (String) pnames.nextElement();
			System.out.println( ">> " +  pn );

		}

		System.out.println("주관식여부>>"+request.getParameter("surv_write"));


		try { Answer_Set_Back_Service service = new Answer_Set_Back_Service();
		Answer_Set_Back_Service service2 = new Answer_Set_Back_Service(); 
		service2.insertSurvQ(dto, subj_name, ans_subj_d_code);
		service2.insertSetSurv(dto, subj_name, ans_subj_d_code); 
		//if (insert_Course == 1 || insert_subj_d == 1)
		// response.sendRedirect("/lmsTeamPro/manager/answer/answer.do" );

		List<Answer_Set_Back_DTO> list = service.selectList();
		request.setAttribute("list", list); } catch (Exception e) {
			e.printStackTrace(); }
		Answer_Service service5 = new Answer_Service();
		ArrayList<AnswerDTO> list =   service5.selectList();
		//ArrayList<AnswerDTO> list2 =   service2.selectList(ans_subj_d_code);


		// 객체 메소드 호출

		request.setAttribute("list", list);

		return "manager/answer/answer";


	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		try {
			Answer_Set_Back_Service service = new Answer_Set_Back_Service();
			List<Answer_Set_Back_DTO> list = service.selectList();
			request.setAttribute("list", list);
			System.out.println("processForm 실행");

		} catch (Exception e) {


		}


		return FORM_VIEW;
	}





}



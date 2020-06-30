package lmsTeamPro.after.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.after.model.Aftercard_student_DTO;
import lmsTeamPro.after.model.Aftercard_student_edit_DTO;



public class Aftercard_student_DAO {
	// 싱글톤
	private static Aftercard_student_DAO dao = null;
	public Aftercard_student_DAO() {}
	public static Aftercard_student_DAO getInstance() {
		if( dao == null ) {
			dao = new Aftercard_student_DAO();
		}
		return dao;
	}

	
	// 게시글 얻어오기
		public Aftercard_student_DTO selectOne(Connection conn, String enroll_name) {
			String sql = " select " + 
					"    e.enroll_name as enroll_name " + 
					"    ,e.enroll_phone as enroll_phone " + 
					 
					"    ,(       select DECODE(SUBSTR(e.enroll_RRN, 8, 1) " + 
					"                , '1', '남' " + 
					"                , '2', '여' " + 
					"                , '3', '남' " + 
					"                , '4', '여') from dual " + 
					"          )                          as gender " + 
					 
					"    ,SUBSTR(e.enroll_RRN, 1, 6)   as birth " + 
					"    ,e.enroll_adrs as enroll_adrs " + 
					"    ,c.course_name as course_name " + 
					"    ,to_char(sd.subj_startdate, 'YYYY.MM.DD') || '-' || to_char(sd.subj_enddate, 'YYYY.MM.DD') as edu_period " + 
					"    ,d.univ as univ " + 
					"    ,d.major as major " + 
					"    ,si.std_info_code as std_info_code " + 
				  					
					"    ,d.desired_loc1 as desired_loc1 " + 
					"    ,d.desired_loc2 as desired_loc2 " + 
					"    ,d.desired_loc3 as desired_loc3 " + 
					"    ,d.desired_field as desired_field " + 
					"    ,d.desired_sal as desired_sal " + 
					"    ,d.desired_employment as desired_employment " + 
					"    ,d.desired_work as desired_work " + 
					"    ,d.desired_workhours as desired_workhours " + 
					"    ,d.desired_note as desired_note " + 
					
					" ,f.fu_comp_name as fu_comp_name " + 
					"   ,f.fu_comp_num as fu_comp_num " + 
					"   ,f.fu_field as fu_field " + 
					"   ,f.fu_adrs as fu_adrs " + 
					"   ,f.fu_insu as fu_insu " + 
					"   ,f.fu_startdate as fu_startdate " + 
					"   ,f.fu_job_cert as fu_job_cert  " +
					
					" from enroll e " + 
					" join std_info si    on e.enroll_code = si.enroll_code " + 
					" join subj_d sd      on si.subj_d_code = sd.subj_d_code " + 
					" join course c       on sd.course_code = c.course_code " + 
					" join desired_job d  on si.std_info_code = d.std_info_code " + 
					" join  fu_mng f      on si.std_info_code = f.std_info_code " + 
					 
					" where e.enroll_name = ? ";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;		
			
			Aftercard_student_DTO dto = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, enroll_name);				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					dto =  new Aftercard_student_DTO();
						// 학생기본신상
						dto.setEnroll_name(rs.getString("enroll_name"));
						dto.setEnroll_phone(rs.getString("enroll_phone"));
						dto.setGender(rs.getString("gender"));
						dto.setBirth(rs.getString("birth"));
						dto.setEnroll_adrs(rs.getString("enroll_adrs"));
						dto.setCourse_name(rs.getString("course_name"));
						dto.setEdu_period(rs.getString("edu_period"));
						dto.setUniv(rs.getString("univ"));
						dto.setMajor(rs.getString("major"));
						dto.setStd_info_code(rs.getString("std_info_code"));
						
						//취업후 원하는 분야
						dto.setDesired_loc1(rs.getString("desired_loc1"));
						dto.setDesired_loc2(rs.getString("desired_loc2"));
						dto.setDesired_loc3(rs.getString("desired_loc3"));
						dto.setDesired_field(rs.getString("desired_field"));
						dto.setDesired_sal(rs.getString("desired_sal"));
						dto.setDesired_employment(rs.getString("desired_employment"));
						dto.setDesired_work(rs.getString("desired_work"));
						dto.setDesired_workhours(rs.getString("desired_workhours"));						
						dto.setDesired_note(rs.getString("desired_note"));
						
						//사후관리카드
						dto.setFu_comp_name(rs.getString("fu_comp_name"));
						dto.setFu_comp_num(rs.getString("fu_comp_num"));
						dto.setFu_field(rs.getString("fu_field"));
						dto.setFu_adrs(rs.getString("fu_adrs"));
						dto.setFu_insu(rs.getString("fu_insu"));
						dto.setFu_startdate(rs.getDate("fu_startdate"));
						dto.setFu_job_cert(rs.getString("fu_job_cert"));
						
						
				}
			} catch (SQLException e) { 
				e.printStackTrace();
			} finally {
				try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
				try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
				
			}
			return dto;
		}
	
		
		// 게시글 수정하기
		public int update(Connection conn, Aftercard_student_edit_DTO dto		
				) throws SQLException{
			
			String sql = " update desired_job set " + 
					" desired_loc1 = ?, desired_loc2 = ?, desired_loc3 = ?, desired_field = ?, desired_sal = ?, " + 
					" desired_employment = ?, desired_work = ?, desired_workhours = ?, desired_note = ?  " + 
					" where std_info_code = ? ";			
	
			try{		
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
						
				int a = 0;
				
				pstmt.setString(1, dto.getDesired_loc1());			
				pstmt.setString(2, dto.getDesired_loc2());			
				pstmt.setString(3, dto.getDesired_loc3());			
				pstmt.setString(4, dto.getDesired_field());			
				pstmt.setString(5, dto.getDesired_sal());			 
				pstmt.setString(6, dto.getDesired_employment());			
				pstmt.setString(7, dto.getDesired_work());			
				pstmt.setString(8, dto.getDesired_workhours());			
				pstmt.setString(9, dto.getDesired_note());			
				pstmt.setString(10, dto.getStd_info_code());			
				
				a = pstmt.executeUpdate();
				System.out.println("update() 쿼리 실행");

				System.out.println(a);
				
				return a;
		}finally {
			System.out.println("finally 블록");
		}
	
	}
		
		
		
}



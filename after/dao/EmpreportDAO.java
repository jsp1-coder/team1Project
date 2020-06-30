package lmsTeamPro.after.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.after.model.EmpreportDTO;



public class EmpreportDAO {
	// 싱글톤
	private static EmpreportDAO dao = null;
	private EmpreportDAO() {}
	public static EmpreportDAO getInstance() {
		if( dao == null ) {
			dao = new EmpreportDAO();
		}
		return dao;
	}


	// 1) 과정별 출력(국가기간)
	public List<EmpreportDTO> selectList1(
			Connection conn){
		String sql = "select distinct  " + 
				"        c.course_name as course_name " + 

				"        ,sd.subj_startdate   as subj_startdate " + 
				"        ,sd.subj_enddate    as subj_enddate " + 

				"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0001' and subj_d_code = sd.subj_d_code )  as comp_number      " + 
				"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0003' and subj_d_code = sd.subj_d_code )  as fail_number " + 
				"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0002' and subj_d_code = sd.subj_d_code )  as notcomp_number " + 
				"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0004' and subj_d_code = sd.subj_d_code )  as earlyjob_number " + 
				"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0005' and subj_d_code = sd.subj_d_code ) as compjob_number " + 

				"        , floor((select count(std_status_code) from std_info where std_status_code = 'STST0005' and subj_d_code = sd.subj_d_code ) " + 
				"            / (select count(std_status_code) from std_info where std_status_code = 'STST0001' and subj_d_code = sd.subj_d_code )  *100) || '%'  as job_rate " + 

				"        , floor((select count(std_status_code) from std_info where std_status_code = 'STST0003' and subj_d_code = sd.subj_d_code ) " + 
				"            / (select count(std_status_code) from std_info where std_status_code = 'STST0001' and subj_d_code = sd.subj_d_code )  *100) || '%'  as fail_rate  " + 

				" from    course_type ct , course c , subj_d sd, subj s, lecturer_info li, staff ss, std_info sti " + 
				" where   ct.c_t_code = c.c_t_code " + 
				" and     c.course_code = sd.course_code " + 
				" and     sd.subj_d_code = s.subj_d_code " + 
				" and     s.lectr_info_code = li.lectr_info_code " + 
				" and     li.staff_code = ss.staff_code " + 
				" and     sd.subj_d_code = sti.subj_d_code   " + 
				" and     c.c_t_code = 'COTY0001' " +

				" ORDER BY sd.subj_startdate ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpreportDTO> list1 = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			EmpreportDTO dto = null;
			while(rs.next()) {
				dto =  new EmpreportDTO();
				dto.setCourse_name(rs.getString("course_name"));
				dto.setSubj_startdate(rs.getDate("subj_startdate"));
				dto.setSubj_enddate(rs.getDate("subj_enddate"));
				dto.setComp_number(rs.getInt("comp_number"));
				dto.setFail_number(rs.getInt("fail_number"));
				dto.setNotcomp_number(rs.getInt("notcomp_number"));
				dto.setEarlyjob_number(rs.getInt("earlyjob_number"));
				dto.setCompjob_number(rs.getInt("compjob_number"));
				dto.setJob_rate(rs.getString("job_rate"));
				dto.setFail_rate(rs.getString("fail_rate"));


				list1.add(dto);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
			try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		}
		return list1;		
	}

	//2) 과정별 출력(사업주위탁)
	public List<EmpreportDTO> selectList2(
			Connection conn){
		String sql = "select distinct  " + 
				"        c.course_name as course_name " + 

				"        ,sd.subj_startdate   as subj_startdate " + 
				"        ,sd.subj_enddate    as subj_enddate " + 

				"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0001' and subj_d_code = sd.subj_d_code )  as comp_number      " + 
				"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0003' and subj_d_code = sd.subj_d_code )  as fail_number " + 
				"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0002' and subj_d_code = sd.subj_d_code )  as notcomp_number " + 
				"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0004' and subj_d_code = sd.subj_d_code )  as earlyjob_number " + 
				"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0005' and subj_d_code = sd.subj_d_code ) as compjob_number " + 

				"        , floor((select count(std_status_code) from std_info where std_status_code = 'STST0005' and subj_d_code = sd.subj_d_code ) " + 
				"            / (select count(std_status_code) from std_info where std_status_code = 'STST0001' and subj_d_code = sd.subj_d_code )  *100) || '%'  as job_rate " + 

				"        , floor((select count(std_status_code) from std_info where std_status_code = 'STST0003' and subj_d_code = sd.subj_d_code ) " + 
				"            / (select count(std_status_code) from std_info where std_status_code = 'STST0001' and subj_d_code = sd.subj_d_code )  *100) || '%'  as fail_rate  " + 

				" from    course_type ct , course c , subj_d sd, subj s, lecturer_info li, staff ss, std_info sti " + 
				" where   ct.c_t_code = c.c_t_code " + 
				" and     c.course_code = sd.course_code " + 
				" and     sd.subj_d_code = s.subj_d_code " + 
				" and     s.lectr_info_code = li.lectr_info_code " + 
				" and     li.staff_code = ss.staff_code " + 
				" and     sd.subj_d_code = sti.subj_d_code   " + 
				" and     c.c_t_code = 'COTY0002' " +

				" ORDER BY sd.subj_startdate ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpreportDTO> list2 = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			EmpreportDTO dto = null;
			while(rs.next()) {
				dto =  new EmpreportDTO();
				dto.setCourse_name(rs.getString("course_name"));
				dto.setSubj_startdate(rs.getDate("subj_startdate"));
				dto.setSubj_enddate(rs.getDate("subj_enddate"));
				dto.setComp_number(rs.getInt("comp_number"));
				dto.setFail_number(rs.getInt("fail_number"));
				dto.setNotcomp_number(rs.getInt("notcomp_number"));
				dto.setEarlyjob_number(rs.getInt("earlyjob_number"));
				dto.setCompjob_number(rs.getInt("compjob_number"));
				dto.setJob_rate(rs.getString("job_rate"));
				dto.setFail_rate(rs.getString("fail_rate"));


				list2.add(dto);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
			try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		}
		return list2;		
	}

	//3) 과정별 출력(일반과정)
	public List<EmpreportDTO> selectList3(
			Connection conn){
		String sql = "select distinct  " + 
				"        c.course_name as course_name " + 

					"        ,sd.subj_startdate   as subj_startdate " + 
					"        ,sd.subj_enddate    as subj_enddate " + 

					"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0001' and subj_d_code = sd.subj_d_code )  as comp_number      " + 
					"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0003' and subj_d_code = sd.subj_d_code )  as fail_number " + 
					"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0002' and subj_d_code = sd.subj_d_code )  as notcomp_number " + 
					"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0004' and subj_d_code = sd.subj_d_code )  as earlyjob_number " + 
					"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0005' and subj_d_code = sd.subj_d_code ) as compjob_number " + 

					"        , floor((select count(std_status_code) from std_info where std_status_code = 'STST0005' and subj_d_code = sd.subj_d_code ) " + 
					"            / (select count(std_status_code) from std_info where std_status_code = 'STST0001' and subj_d_code = sd.subj_d_code )  *100) || '%'  as job_rate " + 

					"        , floor((select count(std_status_code) from std_info where std_status_code = 'STST0003' and subj_d_code = sd.subj_d_code ) " + 
					"            / (select count(std_status_code) from std_info where std_status_code = 'STST0001' and subj_d_code = sd.subj_d_code )  *100) || '%'  as fail_rate  " + 

					" from    course_type ct , course c , subj_d sd, subj s, lecturer_info li, staff ss, std_info sti " + 
					" where   ct.c_t_code = c.c_t_code " + 
					" and     c.course_code = sd.course_code " + 
					" and     sd.subj_d_code = s.subj_d_code " + 
					" and     s.lectr_info_code = li.lectr_info_code " + 
					" and     li.staff_code = ss.staff_code " + 
					" and     sd.subj_d_code = sti.subj_d_code   " + 
					" and     c.c_t_code = 'COTY0003' " +

					" ORDER BY sd.subj_startdate ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpreportDTO> list3 = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			EmpreportDTO dto = null;
			while(rs.next()) {
				dto =  new EmpreportDTO();
				dto.setCourse_name(rs.getString("course_name"));
				dto.setSubj_startdate(rs.getDate("subj_startdate"));
				dto.setSubj_enddate(rs.getDate("subj_enddate"));
				dto.setComp_number(rs.getInt("comp_number"));
				dto.setFail_number(rs.getInt("fail_number"));
				dto.setNotcomp_number(rs.getInt("notcomp_number"));
				dto.setEarlyjob_number(rs.getInt("earlyjob_number"));
				dto.setCompjob_number(rs.getInt("compjob_number"));
				dto.setJob_rate(rs.getString("job_rate"));
				dto.setFail_rate(rs.getString("fail_rate"));


				list3.add(dto);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
			try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		}
		return list3;		
	}

	//4) 과정별 출력(계좌제)
	public List<EmpreportDTO> selectList4(
			Connection conn){
		String sql = "select distinct  " + 
				"        c.course_name as course_name " + 

					"        ,sd.subj_startdate   as subj_startdate " + 
					"        ,sd.subj_enddate    as subj_enddate " + 

					"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0001' and subj_d_code = sd.subj_d_code )  as comp_number      " + 
					"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0003' and subj_d_code = sd.subj_d_code )  as fail_number " + 
					"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0002' and subj_d_code = sd.subj_d_code )  as notcomp_number " + 
					"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0004' and subj_d_code = sd.subj_d_code )  as earlyjob_number " + 
					"        ,(select count(std_status_code) from std_info where std_status_code = 'STST0005' and subj_d_code = sd.subj_d_code ) as compjob_number " + 

					"        , floor((select count(std_status_code) from std_info where std_status_code = 'STST0005' and subj_d_code = sd.subj_d_code ) " + 
					"            / (select count(std_status_code) from std_info where std_status_code = 'STST0001' and subj_d_code = sd.subj_d_code )  *100) || '%'  as job_rate " + 

					"        , floor((select count(std_status_code) from std_info where std_status_code = 'STST0003' and subj_d_code = sd.subj_d_code ) " + 
					"            / (select count(std_status_code) from std_info where std_status_code = 'STST0001' and subj_d_code = sd.subj_d_code )  *100) || '%'  as fail_rate  " + 

					" from    course_type ct , course c , subj_d sd, subj s, lecturer_info li, staff ss, std_info sti " + 
					" where   ct.c_t_code = c.c_t_code " + 
					" and     c.course_code = sd.course_code " + 
					" and     sd.subj_d_code = s.subj_d_code " + 
					" and     s.lectr_info_code = li.lectr_info_code " + 
					" and     li.staff_code = ss.staff_code " + 
					" and     sd.subj_d_code = sti.subj_d_code   " + 
					" and     c.c_t_code = 'COTY0004' " +

					" ORDER BY sd.subj_startdate ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpreportDTO> list4 = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			EmpreportDTO dto = null;
			while(rs.next()) {
				dto =  new EmpreportDTO();
				dto.setCourse_name(rs.getString("course_name"));
				dto.setSubj_startdate(rs.getDate("subj_startdate"));
				dto.setSubj_enddate(rs.getDate("subj_enddate"));
				dto.setComp_number(rs.getInt("comp_number"));
				dto.setFail_number(rs.getInt("fail_number"));
				dto.setNotcomp_number(rs.getInt("notcomp_number"));
				dto.setEarlyjob_number(rs.getInt("earlyjob_number"));
				dto.setCompjob_number(rs.getInt("compjob_number"));
				dto.setJob_rate(rs.getString("job_rate"));
				dto.setFail_rate(rs.getString("fail_rate"));


				list4.add(dto);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
			try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		}
		return list4;		
	}


	//5) 월별 출력
	public List<EmpreportDTO> selectList5(
			Connection conn){
		String sql =  "  		 select distinct 	 "
						+"		        c.course_name as course_name 	"					
						+"		        ,sd.subj_startdate   as subj_startdate		"
						+"		        ,sd.subj_enddate    as subj_enddate		"						
						+"		        ,e.enroll_name as enroll_name		"						
						+"		        , (		"
						+"		            select DECODE(SUBSTR(e.enroll_RRN, 8, 1)		"
						+"		                , '1', '남'		"
						+"		                , '2', '여'		"
						+"		                , '3', '남'		"
						+"		                , '4', '여') from dual		"
						+"		          )                          as gender        		"						
						+"		        ,SUBSTR(e.enroll_RRN, 1, 6)   as birth		"
						+"		        		"
						+"		        ,f.fu_startdate as fu_startdate		"
						+"		        ,f.fu_comp_name as fu_comp_name		"
						+"		        		"
						+"		        ,dbms_lob.substr(f.fu_adrs, 3, 1)      as loc		"
						+"		        		"
						+"		        ,f.fu_comp_num  as fu_comp_num		"
						+"		        ,f.fu_field     as fu_field		"
						+"		        		"
						+"		        ,f.fu_insu      as fu_insu                		"
						+"		from    course c , subj_d sd, std_info sti, enroll e, fu_mng f		"
						+"		where   c.course_code = sd.course_code		"
						+"		and     sd.subj_d_code = sti.subj_d_code		"
						+"		and     sti.enroll_code = e.enroll_code		"
						+"		and     sti.std_info_code = f.std_info_code  		"
				
						+"		ORDER BY sd.subj_startdate 		";
						
						
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpreportDTO> list5 = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			EmpreportDTO dto = null;
			while(rs.next()) {
				dto =  new EmpreportDTO();
					dto.setCourse_name(rs.getString("course_name"));
					dto.setSubj_startdate(rs.getDate("subj_startdate"));
					dto.setSubj_enddate(rs.getDate("subj_enddate"));
					dto.setEnroll_name(rs.getString("enroll_name"));
					dto.setGender(rs.getString("gender"));
					dto.setBirth(rs.getString("birth"));
					dto.setFu_startdate(rs.getDate("fu_startdate"));
					dto.setFu_comp_name(rs.getString("fu_comp_name"));
					dto.setLoc(rs.getString("loc"));
					dto.setFu_comp_num(rs.getString("fu_comp_num"));
					dto.setFu_field(rs.getString("fu_field"));
					dto.setFu_insu(rs.getString("fu_insu"));


				list5.add(dto);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
			try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		}
		return list5;		
	}
}



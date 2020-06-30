package lmsTeamPro.after.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.after.model.DailychartDTO;



public class DailychartDAO {
	// 싱글톤
	private static DailychartDAO dao = null;
	private DailychartDAO() {}
	public static DailychartDAO getInstance() {
		if( dao == null ) {
			dao = new DailychartDAO();
		}
		return dao;
	}


	// 전체 게시글 페이징 처리 없이 가져오는 메서드
	public List<DailychartDTO> selectList(
			Connection conn){
		String sql = " select distinct  ct.c_t_name as c_t_name "
							+" ,c.course_name as course_name "
							+" ,ss.staff_name  as staff_name " 
							+" ,to_char(sd.subj_startdate, 'YYYY.MM.DD') || '-' || to_char(sd.subj_enddate, 'YYYY.MM.DD') as subj_date "
							+" ,sd.subj_ppl  as subj_ppl" 
							+" ,(select count(std_status_code) from std_info where std_status_code = 'STST0001' and subj_d_code = sd.subj_d_code )  as complete " 
							+" ,(select count(std_status_code) from std_info where std_status_code = 'STST0003' and subj_d_code = sd.subj_d_code ) as notcomplete  "
							+" ,(select count(std_status_code) from std_info where std_status_code = 'STST0005' and subj_d_code = sd.subj_d_code ) as compjob  " 
							+" , floor((select count(std_status_code) from std_info where std_status_code = 'STST0005' and subj_d_code = sd.subj_d_code ) " 
							+" / (select count(std_status_code) from std_info where std_status_code = 'STST0001' and subj_d_code = sd.subj_d_code )  *100) || '%'  as jobrate "
							+" , floor((select count(std_status_code) from std_info where std_status_code = 'STST0001' and subj_d_code = sd.subj_d_code )/sd.subj_ppl*100) || '%' as comprate " 
							+" from    course_type ct , course c , subj_d sd, subj s, lecturer_info li, staff ss, std_info sti " 
							+" where   ct.c_t_code = c.c_t_code " 
							+" and     c.course_code = sd.course_code " 
							+" and     sd.subj_d_code = s.subj_d_code " 
							+" and     s.lectr_info_code = li.lectr_info_code " 
							+" and     li.staff_code = ss.staff_code " 
							+" and     sd.subj_d_code = sti.subj_d_code    " 
							+" ORDER BY ct.c_t_name";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<DailychartDTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			DailychartDTO dto = null;
			while(rs.next()) {
				dto =  new DailychartDTO();
					dto.setC_t_name(rs.getString("c_t_name"));
					dto.setCourse_name(rs.getString("course_name"));
					dto.setStaff_name(rs.getString("staff_name"));
					dto.setSubj_date(rs.getString("subj_date"));
					dto.setSubj_ppl(rs.getInt("subj_ppl"));
					dto.setComplete(rs.getInt("complete"));
					dto.setNotcomplete(rs.getInt("notcomplete"));
					dto.setCompjob(rs.getInt("compjob"));				
					dto.setJobrate(rs.getString("jobrate"));
					dto.setComprate(rs.getString("comprate"));
				
					
				list.add(dto);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
			try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
			try {conn.close();  } catch (SQLException e) {	e.printStackTrace();}
		}
		return list;		
	}

	

	
	
	
}



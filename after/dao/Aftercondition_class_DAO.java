package lmsTeamPro.after.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.after.model.Aftercard_class_DTO;



public class Aftercondition_class_DAO {
	// 싱글톤
	private static Aftercondition_class_DAO dao = null;
	private Aftercondition_class_DAO() {}
	public static Aftercondition_class_DAO getInstance() {
		if( dao == null ) {
			dao = new Aftercondition_class_DAO();
		}
		return dao;
	}

	
	// 게시글 얻어와서 리스트에 저장하기
		public List<Aftercard_class_DTO> selectOne(Connection conn, String course_name, int subj_part) {
			String sql = "select " + 
					"		   e.enroll_name as enroll_name " + 
					"		  ,'학생사후관리표' as aftercard_std " + 
				 
					"			 from enroll e " + 
					"			 join std_info si    on e.enroll_code = si.enroll_code " + 
					"			 join subj_d sd       on si.subj_d_code = sd.subj_d_code " + 
					"			 join course c       on sd.course_code = c.course_code " + 
				  
					"			 where c.course_name = ? " + 
					"			 and    sd.subj_part = ? " + 
				 
					"			 order by e.enroll_name ";
			PreparedStatement pstmt = null;
			ResultSet rs = null;		
			
			ArrayList<Aftercard_class_DTO> list = new ArrayList<>();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, course_name);
				pstmt.setInt(2, subj_part);
				rs = pstmt.executeQuery();
				Aftercard_class_DTO dto = null;
				
				while(rs.next()) {
					dto =  new Aftercard_class_DTO();
					dto.setEnroll_name(rs.getString("enroll_name"));
					dto.setAftercard_std(rs.getString("aftercard_std"));

					list.add(dto);
				}
			} catch (SQLException e) { 
				e.printStackTrace();
			} finally {
				try { pstmt.close();} catch (SQLException e) {	e.printStackTrace();	}
				try {rs.close();    } catch (SQLException e) {	e.printStackTrace();}
				
			}
			return list;
		}
	
	
	
}



package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lmsTeamPro.DTO.Trainee_ConditionDTO;

public class Trainee_ConditionDAO2 {

	private static Trainee_ConditionDAO2 dao2 = null;
	private Trainee_ConditionDAO2() {}
	public static Trainee_ConditionDAO2 getInstance() {
		if( dao2 == null ) {
			dao2 = new Trainee_ConditionDAO2();
		}
		return dao2;
	}
	
	public ArrayList<Trainee_ConditionDTO> selectList(
			Connection conn){
		System.out.println("Äõ¸® ½ÇÇà!!!!");
		String sql =" select course_name from course ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Trainee_ConditionDTO> list2 = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Trainee_ConditionDTO dto = null;
			while(rs.next()) {
				dto =  new Trainee_ConditionDTO();
					dto.setCourse_name(rs.getString("course_name"));
					
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

	
	
}

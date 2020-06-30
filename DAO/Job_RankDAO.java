package lmsTeamPro.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.DTO.AuthDTO;
import lmsTeamPro.DTO.Job_RankDTO;

public class Job_RankDAO {

String sql ="select job_rank from job_rank";
	
	ArrayList<Job_RankDTO> list = null;
	PreparedStatement pstmt =null;
	Connection conn = null;
	ResultSet rs = null;
	
	
public ArrayList<Job_RankDTO> getJob_Rank(){
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String job_rank;
				
				Job_RankDTO dto;
				list = new ArrayList<Job_RankDTO>();
				do {
					dto = new Job_RankDTO();
					job_rank = rs.getString("job_rank");
					dto.setJob_Rank(job_rank);
					list.add(dto);
					
				} while (rs.next());
				
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(list.get(1));
		return list;
		
	}
	
public String getjob_rankCode(Connection conn,String job_rank) throws SQLException {
	ResultSet rs = null;
	try(PreparedStatement pstmt = 
			conn.prepareStatement("select  job_rank_code from job_rank where job_rank = ?")){
		pstmt.setString(1, job_rank);
		rs = pstmt.executeQuery();
		rs.next();
		String job_rank_code;
		job_rank_code = rs.getString("job_rank_code");
		return job_rank_code;
	}
}

	
}

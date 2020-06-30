package lmsTeamPro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.DTO.AuthDTO;
import oracle.jdbc.driver.DBConversion;

public class AuthDAO  {
	

	String sql ="select auth from auth";
	
	ArrayList<AuthDTO> list = null;
	PreparedStatement pstmt =null;
	Connection conn = null;
	ResultSet rs = null;
	
	public ArrayList<AuthDTO> getAuth(){
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String auth;
				
				AuthDTO dto;
				list = new ArrayList<AuthDTO>();
				do {
					dto = new AuthDTO();
					auth = rs.getString("auth");
					dto.setAuth(auth);
					list.add(dto);
					
				} while (rs.next());
				
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(list.get(1));
		return list;
		
	}
	
	public String getAuthCode(Connection conn,String auth) throws SQLException {
		ResultSet rs = null;
		try(PreparedStatement pstmt = 
				conn.prepareStatement("select  auth_code from auth where auth = ?")){
			pstmt.setString(1, auth);
			rs = pstmt.executeQuery();
			rs.next();
			String authCode;
			authCode = rs.getString("auth_code");
			return authCode;
		}
	}
	
	
}












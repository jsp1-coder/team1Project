package lmsTeamPro.login.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.util.ConnectionProvider;


import lmsTeamPro.member.dao.StudentMemberDao;
import lmsTeamPro.member.model.StudentMember;



public class StudentLoginService {

	private StudentMemberDao memberDao = new StudentMemberDao();

	public StudentUser login(String std_id, String std_pwd) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			StudentMember member = memberDao.selectById(conn, std_id);
			if (member == null) {
				throw new LoginFailException();
			}
			if ( !member.matchPassword(std_pwd)) {
				throw new LoginFailException();
			}
			return new StudentUser(member.getStd_id(), member.getStd_pwd());
		} catch (SQLException | NamingException e) {
			throw new RuntimeException(e);
		}  
	}
}


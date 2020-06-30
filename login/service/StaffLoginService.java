package lmsTeamPro.login.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.member.dao.StaffMemberDao;
import lmsTeamPro.member.model.StaffMember;



public class StaffLoginService {

	private StaffMemberDao memberDao = new StaffMemberDao();

	public StaffUser login(String staff_id, String staff_pwd) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			StaffMember member = memberDao.selectById(conn, staff_id);
			if (member == null) {
				throw new LoginFailException();
			}
			if ( !member.matchPassword(staff_pwd)) {
				throw new LoginFailException();
			}
			return new StaffUser(member.getStaff_id(), member.getStaff_name());
		} catch (SQLException | NamingException e) {
			throw new RuntimeException(e);
		}  
	}
}


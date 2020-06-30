package lmsTeamPro.after.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.after.dao.EmpconfirmDAO;
import lmsTeamPro.after.model.EmpconfirmDTO;

public class EmpconfirmService {
 public List<EmpconfirmDTO> select() {
	 EmpconfirmDAO dao = EmpconfirmDAO.getInstance();
   try(Connection conn = ConnectionProvider.getConnection()) {
      List<EmpconfirmDTO> list = dao.selectList(conn);
    
    return list;
    
   } catch (SQLException  | NamingException e) {
      throw new RuntimeException(e);
   } 
    
 }
}
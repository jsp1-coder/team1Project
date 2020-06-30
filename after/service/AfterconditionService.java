package lmsTeamPro.after.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.after.dao.AfterconditionDAO;
import lmsTeamPro.after.model.AfterconditionDTO;

public class AfterconditionService {
 public List<AfterconditionDTO> select() {
	 AfterconditionDAO dao = AfterconditionDAO.getInstance();
   try(Connection conn = ConnectionProvider.getConnection()) {
      List<AfterconditionDTO> list = dao.selectList(conn);
    
    return list;
    
   } catch (SQLException  | NamingException e) {
      throw new RuntimeException(e);
   } 
    
 }
}
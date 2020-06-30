package lmsTeamPro.after.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.after.dao.AftercardDAO;
import lmsTeamPro.after.model.AftercardDTO;

public class AftercardService {
 public List<AftercardDTO> select() {
	 AftercardDAO dao = AftercardDAO.getInstance();
   try(Connection conn = ConnectionProvider.getConnection()) {
      List<AftercardDTO> list = dao.selectList(conn);
    
    return list;
    
   } catch (SQLException  | NamingException e) {
      throw new RuntimeException(e);
   } 
    
 }
}
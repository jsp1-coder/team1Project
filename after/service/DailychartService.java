package lmsTeamPro.after.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.after.dao.DailychartDAO;
import lmsTeamPro.after.model.DailychartDTO;

public class DailychartService {
 public List<DailychartDTO> select() {
	 DailychartDAO dao = DailychartDAO.getInstance();
   try(Connection conn = ConnectionProvider.getConnection()) {
      List<DailychartDTO> list = dao.selectList(conn);
    
    return list;
    
   } catch (SQLException  | NamingException e) {
      throw new RuntimeException(e);
   } 
    
 }
}
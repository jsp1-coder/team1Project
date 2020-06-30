package lmsTeamPro.after.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.util.ConnectionProvider;

import lmsTeamPro.after.dao.EmpreportDAO;
import lmsTeamPro.after.model.EmpreportDTO;

public class EmpreportService {
	
	//1
 public List<EmpreportDTO> select1() {
	 System.out.println("select1 호출됨");
	 EmpreportDAO dao = EmpreportDAO.getInstance();
   try(Connection conn = ConnectionProvider.getConnection()) {
      List<EmpreportDTO> list1 = dao.selectList1(conn);
    
    return list1;
    
   } catch (SQLException  | NamingException e) {
      throw new RuntimeException(e);
   } 
    
 }
 
 //2
 public List<EmpreportDTO> select2() {
	 System.out.println("select2 호출됨");
	 EmpreportDAO dao = EmpreportDAO.getInstance();
   try(Connection conn = ConnectionProvider.getConnection()) {
      List<EmpreportDTO> list2 = dao.selectList2(conn);
    
    return list2;
    
   } catch (SQLException  | NamingException e) {
      throw new RuntimeException(e);
   } 
    
 }
 
 //3
 public List<EmpreportDTO> select3() {
	 System.out.println("select3 호출됨");
	 EmpreportDAO dao = EmpreportDAO.getInstance();
   try(Connection conn = ConnectionProvider.getConnection()) {
      List<EmpreportDTO> list3 = dao.selectList3(conn);
    
    return list3;
    
   } catch (SQLException  | NamingException e) {
      throw new RuntimeException(e);
   } 
    
 }
 
 //4
 public List<EmpreportDTO> select4() {
	 System.out.println("select4 호출됨");
	 EmpreportDAO dao = EmpreportDAO.getInstance();
   try(Connection conn = ConnectionProvider.getConnection()) {
      List<EmpreportDTO> list4 = dao.selectList4(conn);
    
    return list4;
    
   } catch (SQLException  | NamingException e) {
      throw new RuntimeException(e);
   } 
    
 }
 
 //5
 public List<EmpreportDTO> select5() {
	 System.out.println("select5 호출됨");
	 EmpreportDAO dao = EmpreportDAO.getInstance();
   try(Connection conn = ConnectionProvider.getConnection()) {
      List<EmpreportDTO> list5 = dao.selectList5(conn);
    
    return list5;
    
   } catch (SQLException  | NamingException e) {
      throw new RuntimeException(e);
   } 
    
 }
 
 
}
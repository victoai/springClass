package com.acorn.dbtran;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;


 
public class MemberService3 {
	
 
	 
	 MemberDao dao2;
 
	 
	 
	 DataSource ds;
 
	 
	 //no transaction  : 한 개는 입력되고 하나는 입력 안되는 상태
	 public void registerMember(Member member) throws Exception {    		 
	      dao2.insertUser(member);
		  dao2.insertUser(member); 
	 }
	 
	 // transaction 처리 방법 , 같은  connection으로  시작해야 한다.
	 // 같은 connection인 경우면 같은 transaction으로 묶인다.
	 	 
	 public void registerMemberTran(Member member) throws Exception {    		
		  Connection conn = ds.getConnection(); 		
		  try {		  
				 
			  conn.setAutoCommit(false);
		      dao2.insertUser2(member , conn );  // 같은  connection을 제공함 
			  dao2.insertUser2(member , conn );  // 같은  connection을 제공함 
			  conn.commit();		    // db반영
		  }catch(Exception e) {
			  e.printStackTrace();
			  conn.rollback();   // 문제가 발생시  rollback() 처리함
		  }finally {
			  conn.close();
		  }	 
       
	 }
	 
	 
	 // 스프링을 이용하여  트랜잭션 관리
	  public void insertA1WithTx(Member member) throws Exception {
	        PlatformTransactionManager tm = new DataSourceTransactionManager(ds);	       
	        TransactionStatus status = tm.getTransaction(  new DefaultTransactionDefinition()  );	      
	        try {
	        	  System.out.println("one");
	        	  dao2.insertUser(member);
	    		  dao2.insertUser(member);
	              tm.commit(status);
	        } catch (Exception e) {
	            e.printStackTrace();	          
	            tm.rollback(status);
	            throw e;
	        } finally {
	        	
	        }
 
	    }
	  
	  
	 
	  public void insertA1WithTx2(Member member) throws Exception {	   
		  
		  		  System.out.println("ddddd");
	        	  dao2.insertUser(member);
	    		  dao2.insertUser(member);
	      

	    }
	  
	  

}

package com.acorn.dbtran;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;


 
public class MemberService2 {
	
	 
	 MemberDao2 dao2;
	  
	 
	 PlatformTransactionManager tm;	  
	 
	 // 스프링을 이용하여  트랜잭션 관리
	  public void insertA1WithTx(Member member) throws Exception {
	    //    PlatformTransactionManager tm = new DataSourceTransactionManager(ds);	       
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
	 	  
		  		  System.out.println("trantwo");
	        	  dao2.insertUser(member);
	    		  dao2.insertUser(member);
	      

	    }
	  
	  

}

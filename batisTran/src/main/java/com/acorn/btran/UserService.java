package com.acorn.btran;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;


@Component
public class UserService {
	   @Autowired
	   MemberDao dao;
	 
	   @Autowired	
	    private   PlatformTransactionManager tm; 
	
	 
	  
	  public void createUser( ) throws Exception {
		 
		  TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());

	    try {    	
	    
	      dao.insert(new Member("test289","000","김길동"));	
	      dao.insert(new Member("test289","000","나길동"));	
	      
	      tm.commit(status);
	    } catch (Exception e) {
	      tm.rollback(status);
	      System.out.println( "rollback 한다");
	      throw e;
	    }
	   
	  } 
	  
	 
	  public void createUser2(Member m) throws Exception {		 
		      dao.insert(m);  
		      
		   		   
	  } 
	}
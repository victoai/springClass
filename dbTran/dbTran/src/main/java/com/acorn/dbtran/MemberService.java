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


 @Component
public class MemberService {
	
 
	 @Autowired
	 MemberDao dao2;
 
	 
	  
	  @Transactional(rollbackFor = SQLException.class )
	  public void insertA1WithTx2(Member member) throws Exception {	   
		  
		  		  System.out.println("ddddd");
	        	  dao2.insertUser(member);
	    		  dao2.insertUser(member);
	      

	    }
	  
	  

}

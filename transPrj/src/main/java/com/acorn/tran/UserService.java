package com.acorn.tran;

 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus; 
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
public class UserService {

	@Autowired
	UserDao dao;

	@Autowired
	PlatformTransactionManager tm;

	
	// 스프링을 이용하여 트랜잭션 관리
	public void insertA1WithTx( ) throws Exception { 

		TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());		
		
		try {
			
			dao.insertUser(new User("hong77", "1234"));
			dao.insertUser(new User("hong77", "1234"));
			tm.commit(status);
			
		} catch (Exception e) {			
			e.printStackTrace();
			tm.rollback(status);
			throw e;
			
		}
	}

}

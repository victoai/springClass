package com.acorn.tran;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
 


 
 @Controller
public class TranTestControllerUser {
	 
	@Autowired
	UserService  service; 
	  

	@RequestMapping("/tranUser")   
	public void insert1(  )    {			 
		   
			try {
				service.insertA1WithTx( );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 
	}  
	 
	
}

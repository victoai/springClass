package com.acorn.ex;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionCatcher3 { 
	
	@RequestMapping("/db4")	
	public void method1() throws SQLException    { 		 			
		throw new SQLException();		 
	}	
	
	@RequestMapping("/db5")	
	public void method2() throws SQLException    { 		 			
		throw new SQLException();		 
	}
}

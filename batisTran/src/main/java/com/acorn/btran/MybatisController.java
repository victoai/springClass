package com.acorn.btran;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

 
 
 
 
 
@Controller
public class MybatisController {
	
	@Autowired
	UserService service; 
	  

	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	@ExceptionHandler(Exception.class)		
	public String catcher(  Model model, Exception ex) {
		model.addAttribute("ex", ex);
		return "err";
	}
	
	 
 
	@RequestMapping("/insert")
	public void test3( ) throws Exception {			 
		  service.createUser( )  ;		 	   
	}
 
	 
 
	  
	 

}

package com.acorn.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
		
	@Autowired
	MyService service;
	
	
	@RequestMapping( value="/member")
	public String test( ) {		 
		 return  "register";
	}	
	
	
	@RequestMapping( value="/member" , method =RequestMethod.POST )
	public void test(Member member) {		 
		service.registerMember( member);
	}

}

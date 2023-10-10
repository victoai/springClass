package com.acorn.db;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class Test2Controller { 
	
	@GetMapping("/test2")
	public String  test() {	
	
		 return "test2" ;
	} 

	@GetMapping("/test3")                                                                  
	public String  test2() {	
	
		 return "test3" ;
	}
}

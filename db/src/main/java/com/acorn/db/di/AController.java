package com.acorn.db.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AController {
	
	@Autowired
	AService service;
	
	
	@GetMapping("/di1")
	public void method1() {		
		
		System.out.println("di1");
	}
	
	@GetMapping("/di2")
	public void method2(Model model) {				
	  String result  = service.method1();
	  model.addAttribute("result", result);  	  
	}
}

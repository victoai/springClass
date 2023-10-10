package com.acorn.db.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgramController {
	
	@Autowired
	Program program;	
		
	@GetMapping("/addNumber")
	public void addNumber() {
		program.printNumers(3, 5);		
	}
	
	
}

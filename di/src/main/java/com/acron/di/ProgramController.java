package com.acron.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProgramController {

	@Autowired
	Program p;	
	
	@GetMapping("/program")
	public void test( ) {		
		p.addNumber(5, 3);		
	}	
}

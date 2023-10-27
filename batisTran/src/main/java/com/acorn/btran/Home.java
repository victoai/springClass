package com.acorn.btran;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home { 
	
	@GetMapping("/homeT")
	public void test() {
		
	}
}

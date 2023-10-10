package com.acorn.db;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImgController {

	
	@GetMapping("/img")
	 public String  imgs() {
		 
		return "test";
	 }
}

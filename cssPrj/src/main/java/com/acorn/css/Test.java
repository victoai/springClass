package com.acorn.css;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class Test {

	@RequestMapping("/css")
	public String css() {
		return "css";
	}
}

package com.acorn.day3.서버응답;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mvc응답  {

	
	@GetMapping("/mvc1")
	public void test1() {
		
	}
	
	@GetMapping("/mvc2")
	public String test2() {	
		return "뷰이름";
	}
	
	
	@GetMapping("/mvc3")
	public ModelAndView test3() {
		ModelAndView mv =new ModelAndView("뷰이름2");		
		return mv;
		
	}
	
}

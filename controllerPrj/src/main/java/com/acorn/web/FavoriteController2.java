package com.acorn.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FavoriteController2 {
	
	@GetMapping("/hi")   //요청
	public void method1( ) {			
		//모델
		//view  : 요청의 이름을 view로 
	}
	
	@GetMapping("/hi2")
	public String method2( Model  model) {
		//모델
		//뷰정보 : String 리턴값
		model.addAttribute("data", "spring hi~~~");		
		return "view";
	}
	
}

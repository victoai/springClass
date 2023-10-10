package com.acorn.day2;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//매핑을 매서드 단위로 한다
//1.문제
@Controller
public class TestController {
	
	@Autowired
	TestService service; 
 
		 
	@RequestMapping("/gugudan")  // c
	public String  test1( int dan  , Model model) {					
		ArrayList<String> danList = service.getDan(dan);
		model.addAttribute("list", danList);
		System.out.println( dan);
		return "test";  //v
	}

}

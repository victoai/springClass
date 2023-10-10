package com.acorn.day1.di;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pController3 {
	
	//매서드 단위의 매핑 	
	//주입
	@Autowired
	TestService service;	
	
	@GetMapping("/list")	
	public String test1( Model model) {			
		//Model
		ArrayList<String > list = service.getList();
		model.addAttribute("list", list);
		return "memberList";
	}
	

}

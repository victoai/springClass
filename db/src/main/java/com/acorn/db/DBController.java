package com.acorn.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DBController {

	@Autowired
	TestDAO  dao;
		
	@GetMapping("/db")
	public  String dbtest() {		
		dao.select();
		return "home";
	}
	
}

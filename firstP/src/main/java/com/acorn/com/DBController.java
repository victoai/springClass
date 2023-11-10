package com.acorn.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DBController {

	@Autowired
	TestDAO  dao;
	
	@RequestMapping("/tt")
	public String test1() {		
		dao.select();
		return "db";
	}
	
	
 
	@RequestMapping("/test")
	public String dfdfd()  {
		return "test";
	}
}

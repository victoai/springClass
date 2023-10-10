package com.acorn.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Test {
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi( ) { 
		 
		
		return "hi";
	}
}

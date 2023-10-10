package com.acorn.db;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Test1Controller  implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("test1");
		mv.addObject("data", "spring hi!!!");
		return mv;
		
	}

	
	
}

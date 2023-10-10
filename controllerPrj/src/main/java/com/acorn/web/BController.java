package com.acorn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class BController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//view, model
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view2");
		mv.addObject("data", "spring hello~~");
		return mv;
	}

}

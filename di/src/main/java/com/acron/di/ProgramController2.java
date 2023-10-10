package com.acron.di;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
 

 
public class ProgramController2  implements Controller{

	

Program p;	



public void setP(Program p) {
	this.p = p;
}


 


@Override
public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	 
	p.addNumber(5, 3);
	return null;
}

 

 
}

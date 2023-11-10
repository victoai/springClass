package com.spring.project.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface MainController {
	public String main(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String introduce(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String support(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public void sendEmail(HttpServletRequest request, HttpServletResponse response) throws Exception;
}

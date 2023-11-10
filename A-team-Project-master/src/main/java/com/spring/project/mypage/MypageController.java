package com.spring.project.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface MypageController {
	public ModelAndView mypagemain(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String myreservation(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String myreview(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String mytravle(HttpServletRequest request, HttpServletResponse response) throws Exception;
}

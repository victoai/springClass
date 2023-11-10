package com.spring.project.mypage.controller;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface MyReservationController {
	public ModelAndView mypagereservation( HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView airreservation(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception;
}

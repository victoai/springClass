package com.spring.project.activity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.activity.dto.ReviewDTO;

public interface ActivityController {
	public String activity(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String crs(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView activityDetail(@RequestParam("ac_no") int ac_no, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView myReview(@RequestParam("ac_no") int ac_no, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public void addReview(@ModelAttribute("review") ReviewDTO review, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView myPick(@RequestParam("ac_no") int ac_no, @RequestParam("pick") boolean pick,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}

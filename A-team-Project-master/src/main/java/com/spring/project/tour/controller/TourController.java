package com.spring.project.tour.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.tour.dto.ReviewDTO;


public interface TourController {
	public String tourmain(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public String orumm(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public String beach(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public ModelAndView tourDetail(@RequestParam("tr_no") int tr_no, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public ModelAndView myReview(@RequestParam("tr_no") int tr_no, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public void addReview(@ModelAttribute("review") ReviewDTO review, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView myPick(@RequestParam("tr_no") int tr_no,@RequestParam("pick") boolean pick,
		HttpServletRequest request, HttpServletResponse response) throws Exception;
}


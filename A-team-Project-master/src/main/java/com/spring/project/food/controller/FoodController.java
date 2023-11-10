package com.spring.project.food.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.food.dto.ReviewDTO;

public interface FoodController {
	public String restaurant(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public String cafe(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public ModelAndView resDetail(@RequestParam("fd_no") int fd_no, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public ModelAndView reviewForm(@RequestParam("fd_no") int fd_no, HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public void addReview(@ModelAttribute("review") ReviewDTO review, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView myPick(@RequestParam("fd_no") int fd_no,@RequestParam("pick") boolean pick,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
}

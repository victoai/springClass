package com.spring.project.event.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.event.dto.AirplaneDTO;
import com.spring.project.event.dto.LodgingResDTO;
import com.spring.project.event.dto.ReviewDTO;
import com.spring.project.event.dto.RoomInfoDTO;



public interface EventController {
	public String airport(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public String lodging(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public ModelAndView airDetail(@ModelAttribute("air") AirplaneDTO air, 
			HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public ModelAndView checkReserv(@RequestParam("air_no_from") int air_no_from, @RequestParam("air_no_to") int air_no_to, 
			HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public void airReserv(@RequestParam("air_no1") int air_no1, @RequestParam("air_no2") int air_no2, 
			HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public ModelAndView lodDetail(@RequestParam("page") int page,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView lodDetailHotel(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView lodDetailResort(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView lodDetailHouse(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView lodInfo(@RequestParam("lod_id") int lod_id, @RequestParam("resultDay") int resultDay,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView roomRes(@ModelAttribute("room")  RoomInfoDTO room, @RequestParam("resultDay") int resultDay, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String resPay(HttpServletRequest request, HttpServletResponse response)
			throws Exception ;
	public void resPay(@ModelAttribute("res")LodgingResDTO res, HttpServletRequest request, HttpServletResponse response)
			throws Exception ;
	public ModelAndView myPick(@RequestParam("lod_id") int lod_id, @RequestParam("pick") boolean pick,
			HttpServletRequest request, HttpServletResponse response) throws Exception ;
	public ModelAndView myReview(@RequestParam("lod_id") int lod_id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public void addReview(@ModelAttribute("review") ReviewDTO review, HttpServletRequest request, HttpServletResponse response) throws Exception ;
	
}


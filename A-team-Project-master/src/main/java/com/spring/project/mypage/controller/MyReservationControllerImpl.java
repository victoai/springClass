package com.spring.project.mypage.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.member.dto.MemberDTO;
import com.spring.project.mypage.dto.MyReservationDTO;
import com.spring.project.mypage.service.MyReservationService;

@Controller
@RequestMapping("/myreservation")
public class MyReservationControllerImpl implements MyReservationController{
	@Autowired
	MyReservationService reservationService;

	@Override
	@RequestMapping("/reservation")
	public ModelAndView mypagereservation(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName); 
		return mav;
	}
	@Override
	@RequestMapping("/airreservation")
	public ModelAndView airreservation(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		ModelAndView mav = null;
		
		String viewName = (String) request.getAttribute("viewName");
		mav = new ModelAndView(viewName);
		List<MyReservationDTO> myres = reservationService.reservationAirList(member.getId());
		mav.addObject("mypage", myres);
		return mav;
	}

}

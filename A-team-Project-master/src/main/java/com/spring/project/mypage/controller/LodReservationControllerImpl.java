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
import com.spring.project.mypage.dto.LodReservationDTO;
import com.spring.project.mypage.service.LodReservationService;

@Controller
@RequestMapping("/mylodreservation")
public class LodReservationControllerImpl implements LodReservationController {
	
	@Autowired
	LodReservationService lodreservationService;

	@Override
	@RequestMapping("/lodreservation")
	public ModelAndView lodreservation(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		ModelAndView mav = null;
		
		String viewName = (String) request.getAttribute("viewName");
		mav = new ModelAndView(viewName);
		List<LodReservationDTO> myres = lodreservationService.lodreservationList(member.getId());
		mav.addObject("mypage", myres);
		return mav;
	}


}

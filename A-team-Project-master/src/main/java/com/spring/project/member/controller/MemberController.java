package com.spring.project.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.project.member.dto.MemberDTO;

public interface MemberController {

	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public void addMember(@ModelAttribute("member") MemberDTO member, HttpServletRequest request, HttpServletResponse response) throws Exception;

	public void modMember(@ModelAttribute("member") MemberDTO memberDTO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public void delMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public void login(@ModelAttribute("member") MemberDTO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse resposne) throws Exception;
	public int idChk(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public void findId(MemberDTO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response)
			throws Exception;
	public void findPwd(MemberDTO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response)
			throws Exception;
}

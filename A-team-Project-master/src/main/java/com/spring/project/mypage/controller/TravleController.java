package com.spring.project.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.member.dto.MemberDTO;
import com.spring.project.mypage.dto.TravleDTO;

public interface TravleController {
	public ModelAndView travle(@RequestParam("id")String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String schedule(@RequestBody String json , HttpServletRequest request) throws Exception;
	public List<TravleDTO> setSchedule(HttpServletRequest request, HttpServletResponse response)throws Exception;
	public String modSchedule(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) throws Exception;
}

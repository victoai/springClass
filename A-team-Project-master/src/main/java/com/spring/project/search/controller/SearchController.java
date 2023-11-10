package com.spring.project.search.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface SearchController {
	public ModelAndView searchKey(@RequestParam("search")String search, HttpServletRequest request, HttpServletResponse response)throws Exception;
}

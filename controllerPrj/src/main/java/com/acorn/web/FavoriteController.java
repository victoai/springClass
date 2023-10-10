package com.acorn.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FavoriteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ModelAndView  mv = new ModelAndView();
		//view정보등록
		mv.setViewName("favoriteView");
		
		//model작성
		 ArrayList<String> list = new ArrayList<>();
		 list.add("모범택시2");
		 list.add("도기&고은");		
		 
		 //model정보 등록
		 mv.addObject("list", list);
		return mv;
	}

}

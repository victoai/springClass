package com.spring.project.search.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.activity.dto.ActivityDTO;
import com.spring.project.event.dto.LodgingDTO;
import com.spring.project.food.dto.FoodDTO;
import com.spring.project.search.service.SearchService;
import com.spring.project.tour.dto.TourDTO;

@Controller
@EnableAspectJAutoProxy
@RequestMapping("/search")
public class SearchControllerImpl implements SearchController{
	@Autowired
	private SearchService searchService;

	@Override
	@RequestMapping("/search.do")
	public ModelAndView searchKey(@RequestParam("search")String search,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// food 검색
		List<FoodDTO> foodSearch = searchService.foodSearch(search);
//		// lodging 검색
		List<LodgingDTO> lodgingSearch = searchService.lodgingSearch(search);
//		// activity 검색
		List<ActivityDTO> activitySearch = searchService.activitySearch(search);
//		// tour 검색
		List<TourDTO> tourSearch = searchService.tourSearch(search);
		
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("foodSearch",foodSearch);
		mav.addObject("lodgingSearch",lodgingSearch);
		mav.addObject("activitySearch",activitySearch);
		mav.addObject("tourSearch",tourSearch);
		return mav;
	}
}

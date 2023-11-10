package com.spring.project.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.activity.dto.ActivityDTO;
import com.spring.project.event.dto.LodgingDTO;
import com.spring.project.food.dto.FoodDTO;
import com.spring.project.search.dao.SearchDAO;
import com.spring.project.tour.dto.TourDTO;

@Service
public class SearchServiceImpl implements SearchService{
	@Autowired
	private SearchDAO searchDAO;

	@Override
	public List<FoodDTO> foodSearch(String search) throws Exception {
		// TODO Auto-generated method stub
		return searchDAO.foodSearch(search);
	}

	@Override
	public List<LodgingDTO> lodgingSearch(String search) {
		// TODO Auto-generated method stub
		return searchDAO.lodgingSearch(search);
	}

	@Override
	public List<ActivityDTO> activitySearch(String search) {
		// TODO Auto-generated method stub
		return searchDAO.activitySearch(search);
	}

	@Override
	public List<TourDTO> tourSearch(String search) {
		// TODO Auto-generated method stub
		return searchDAO.tourSearch(search);
	}
}

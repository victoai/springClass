package com.spring.project.search.service;

import java.util.List;

import com.spring.project.activity.dto.ActivityDTO;
import com.spring.project.event.dto.LodgingDTO;
import com.spring.project.food.dto.FoodDTO;
import com.spring.project.tour.dto.TourDTO;

public interface SearchService {

	public List<FoodDTO> foodSearch( String search) throws Exception;

	public List<LodgingDTO> lodgingSearch(String search);

	public List<ActivityDTO> activitySearch(String search);

	public List<TourDTO> tourSearch(String search);

}

package com.spring.project.search.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.activity.dto.ActivityDTO;
import com.spring.project.event.dto.LodgingDTO;
import com.spring.project.food.dto.FoodDTO;
import com.spring.project.tour.dto.TourDTO;

@Repository
public class SearchDAOImpl implements SearchDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<FoodDTO> foodSearch(String search) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.search.foodSearch",search);
	}

	@Override
	public List<LodgingDTO> lodgingSearch(String search) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.search.lodgingSearch",search);
	}

	@Override
	public List<ActivityDTO> activitySearch(String search) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.search.activitySearch",search);
	}

	@Override
	public List<TourDTO> tourSearch(String search) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.search.tourSearch",search);
	}
}

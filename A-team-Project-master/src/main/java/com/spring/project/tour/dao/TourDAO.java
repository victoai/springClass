package com.spring.project.tour.dao;

import java.util.List;
import java.util.Map;

import com.spring.project.tour.dto.ReviewDTO;
import com.spring.project.tour.dto.TourDTO;

public interface TourDAO {

	public int allTourCnt();

	public int allOrummCnt();

	public int allBeachCnt();

	public List<TourDTO> beachList(Map<String, Integer> page);

	public List<TourDTO> orummList(Map<String, Integer> page);

	public List<TourDTO> tourList(Map<String, Integer> page);


	public TourDTO selectOne(int tr_no);

	public int addReview(com.spring.project.tour.dto.ReviewDTO review);

	public List<ReviewDTO> reviewList(int tr_no);

	public void myPick(Map pickMap);
	
	public void delPick(Map pickMap);

	public int checkPcik(Map pickMap);

	public Double average(int tr_no);

}

package com.spring.project.tour.service;

import java.util.List;
import java.util.Map;

import com.spring.project.tour.dto.ReviewDTO;
import com.spring.project.tour.dto.TourDTO;

public interface TourService {

	public int allTourCnt();

	public int allOrummCnt();

	public int allBeachCnt();

	public List<TourDTO> tourList(int start, int end);

	public List<TourDTO> orummList(int start, int end);

	public List<TourDTO> beachList(int start, int end);

	public TourDTO selectOne(int tr_no);

	public List<ReviewDTO> reviewList(int tr_no);

	public void myPick(Map pickMap);

	public void delPick(Map pickMap);

	public int addReview(ReviewDTO review);

	public int checkPick(Map pickMap);

	public Double average(int tr_no);

}

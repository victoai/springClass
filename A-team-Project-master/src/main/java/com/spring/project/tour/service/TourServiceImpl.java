package com.spring.project.tour.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.tour.dao.TourDAO;
import com.spring.project.tour.dto.ReviewDTO;
import com.spring.project.tour.dto.TourDTO;

@Service
public class TourServiceImpl implements TourService {
	@Autowired
	TourDAO tourDAO;
	
	@Override
	public int allTourCnt() {
		// TODO Auto-generated method stub
		return tourDAO.allTourCnt();
	}

	@Override
	public int allOrummCnt() {
		// TODO Auto-generated method stub
		return tourDAO.allOrummCnt();
	}

	@Override
	public int allBeachCnt() {
		// TODO Auto-generated method stub
		return tourDAO.allBeachCnt();
	}

	@Override
	public List<TourDTO> tourList(int start, int end) {
		// TODO Auto-generated method stub
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		return tourDAO.tourList(page);
	}

	@Override
	public List<TourDTO> orummList(int start, int end) {
		// TODO Auto-generated method stub
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		return tourDAO.orummList(page);
	}

	@Override
	public List<TourDTO> beachList(int start, int end) {
		// TODO Auto-generated method stub
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		return tourDAO.beachList(page);
	}

	@Override
	public TourDTO selectOne(int tr_no) {
		// TODO Auto-generated method stub
		return tourDAO.selectOne(tr_no);
	}


	@Override
	public int addReview(com.spring.project.tour.dto.ReviewDTO review) {
		// TODO Auto-generated method stub
		return tourDAO.addReview(review);
	}

	@Override
	public List<ReviewDTO> reviewList(int tr_no) {
		// TODO Auto-generated method stub
		return tourDAO.reviewList(tr_no);
	}

	@Override
	public void myPick(Map pickMap) {
		// TODO Auto-generated method stub
		tourDAO.myPick(pickMap);
	}

	@Override
	public void delPick(Map pickMap) {
		// TODO Auto-generated method stub
		tourDAO.delPick(pickMap);
	}

	@Override
	public int checkPick(Map pickMap) {
		// TODO Auto-generated method stub
		return tourDAO.checkPcik(pickMap);
	}

	@Override
	public Double average(int tr_no) {
		// TODO Auto-generated method stub
		return tourDAO.average(tr_no);
	}
	
}

package com.spring.project.food.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.project.food.dao.FoodDAO;
import com.spring.project.food.dto.FoodDTO;
import com.spring.project.food.dto.ReviewDTO;

@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	FoodDAO foodDAO;

	@Override
	public FoodDTO selectOne(int fd_no) {
		// 먹으멍 상세 정보
		return foodDAO.selectOne(fd_no);
	}

	@Override
	public int addReview(ReviewDTO review) {
		// 리뷰쓰기
		return foodDAO.addReview(review);
	}

	@Override
	public List<FoodDTO> foodList(int start, int end) {
		// 맛집 정보 리스트
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		return foodDAO.foodList(page);
	}

	@Override
	public void dbInsert(FoodDTO food) {
		// DB저장
		foodDAO.dbInsert(food);
	}

	@Override
	public List<FoodDTO> cafeList(int start, int end) {
		// 카페 정보 리스트
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		return foodDAO.cafeList(page);
	}

	@Override
	public int allFoodCnt() {
		// 맛집 정보 갯수
		return foodDAO.allFoodCnt();
	}

	@Override
	public int allCafeCnt() {
		// 카페 정보 갯수
		return foodDAO.allCafeCnt();
	}

	@Override
	public List<ReviewDTO> reviewList(int fd_no) {
		// 먹으멍 상세 리뷰리스트
		return foodDAO.reviewList(fd_no);
	}

	@Override
	public void myPick(Map pickMap) {
		// 내가 찜한 내용
		foodDAO.myPick(pickMap);
	}

	@Override
	public void delPick(Map pickMap) {
		// 찜취소
		foodDAO.delPick(pickMap);
	}

	@Override
	public int checkPick(Map pickMap) {
		// 찜하기
		return foodDAO.checkPick(pickMap);
	}

	@Override
	public Double average(int fd_no) {
		// 평점 
		Double avg = foodDAO.average(fd_no);
		return avg;
	}
}

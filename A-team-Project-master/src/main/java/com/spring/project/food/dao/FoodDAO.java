package com.spring.project.food.dao;

import java.util.List;
import java.util.Map;

import com.spring.project.food.dto.FoodDTO;
import com.spring.project.food.dto.ReviewDTO;

public interface FoodDAO {

	public FoodDTO selectOne(int fd_no);

	public int addReview(ReviewDTO review);

	public List<FoodDTO> foodList(Map<String, Integer> page);

	public void dbInsert(FoodDTO food);

	public List<FoodDTO> cafeList(Map<String, Integer> page);

	public int allFoodCnt();

	public int allCafeCnt();

	public List<ReviewDTO> reviewList(int fd_no);

	public void myPick(Map pickMap);

	public void delPick(Map pickMap);

	public int checkPick(Map pickMap);

	public Double average(int fd_no);


}

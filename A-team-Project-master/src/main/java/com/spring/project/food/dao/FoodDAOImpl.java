package com.spring.project.food.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.food.dto.FoodDTO;
import com.spring.project.food.dto.ReviewDTO;

@Repository
public class FoodDAOImpl implements FoodDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public FoodDTO selectOne(int fd_no) {
		// 맛집 정보 리스트
		FoodDTO food = (FoodDTO) sqlSession.selectOne("mapper.food.selectfd_no", fd_no);
		return food;
	}

	@Override
	public int addReview(ReviewDTO review) {
		// 리뷰쓰기
		return sqlSession.insert("mapper.food.addReview", review);
	}

	@Override
	public List<FoodDTO> foodList(Map<String, Integer> page) {
		// 맛집 정보 리스트
		return sqlSession.selectList("mapper.food.foodList",page);
	}

	@Override
	public void dbInsert(FoodDTO food) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.food.dbInsert",food);
	}

	@Override
	public List<FoodDTO> cafeList(Map<String, Integer> page) {
		// 카페 정보 리스트
		return sqlSession.selectList("mapper.food.cafeList",page);
	}

	@Override
	public int allFoodCnt() {
		// 맛집 정보 갯수
		return sqlSession.selectOne("mapper.food.allFoodCnt");
	}

	@Override
	public int allCafeCnt() {
		// 카페 정보 갯수 
		return sqlSession.selectOne("mapper.food.allCafeCnt");
	}

	@Override
	public List<ReviewDTO> reviewList(int fd_no) {
		// 먹으멍 상세 리뷰리스트
		return sqlSession.selectList("mapper.food.reviewList",fd_no);
	}

	@Override
	public void myPick(Map pickMap) {
		// 내가 찜한 내용
		sqlSession.insert("mapper.food.myPick",pickMap);
	}

	@Override
	public void delPick(Map pickMap) {
		// 찜취소
		sqlSession.delete("mapper.food.delPick",pickMap);
	}

	@Override
	public int checkPick(Map pickMap) {
		// 찜하기
		return sqlSession.selectOne("mapper.food.checkPick", pickMap);
	}

	@Override
	public Double average(int fd_no) {
		// 평점
		String avg_result = sqlSession.selectOne("mapper.food.average", fd_no);
		Double avg = 0.0;
		if(avg_result==null) {
			avg_result = "0";
			avg = Double.parseDouble(avg_result)/1.0;
			return avg;
		} else {
			avg = Double.parseDouble(avg_result)/1.0;
		}
		return avg;
	}

}

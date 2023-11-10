package com.spring.project.tour.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.tour.dto.ReviewDTO;
import com.spring.project.tour.dto.TourDTO;

@Repository
public class TourDAOImpl implements TourDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int allTourCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.tour.allTourCnt");
	}

	@Override
	public int allOrummCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.tour.allOrummCnt");
	}

	@Override
	public int allBeachCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.tour.allBeachCnt");
	}

	@Override
	public List<TourDTO> beachList(Map<String, Integer> page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.tour.beachList",page);
	}

	@Override
	public List<TourDTO> orummList(Map<String, Integer> page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.tour.orummList",page);
	}

	@Override
	public List<TourDTO> tourList(Map<String, Integer> page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.tour.tourList",page);
	}

	@Override
	public TourDTO selectOne(int tr_no) {
		// TODO Auto-generated method stub
		TourDTO tour =sqlSession.selectOne("mapper.tour.selecttr_no", tr_no);
		return tour;
	}


	@Override
	public int addReview(com.spring.project.tour.dto.ReviewDTO review) {
		// TODO Auto-generated method stub
		return sqlSession.insert("mapper.tour.addReview", review);
	}

	@Override
	public List<ReviewDTO> reviewList(int tr_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.tour.reviewList", tr_no);
	}

	@Override
	public void myPick(Map pickMap) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.tour.tour_myPick", pickMap);
	}

	@Override
	public void delPick(Map pickMap) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.tour.tour_delPick", pickMap);
	}

	@Override
	public int checkPcik(Map pickMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.tour.checkPick", pickMap);
	}

	@Override
	public Double average(int tr_no) {
		// TODO Auto-generated method stub
		String avg_result = sqlSession.selectOne("mapper.tour.average", tr_no);
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

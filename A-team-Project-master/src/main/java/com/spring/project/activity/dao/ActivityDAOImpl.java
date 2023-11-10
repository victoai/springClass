package com.spring.project.activity.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.activity.dto.ActivityDTO;
import com.spring.project.activity.dto.ReviewDTO;

@Repository
public class ActivityDAOImpl implements ActivityDAO{
	@Autowired
	private SqlSession sqlSession;


	@Override
	public List<ActivityDTO> crsList(Map<String, Integer> page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.activity.crsList", page);
	}

	@Override
	public List<ActivityDTO> activityList(Map<String, Integer> page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.activity.activityList", page);
	}

	@Override
	public void dbInsert(ActivityDTO activity) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.activity.dbInsert", activity);
	}

	@Override
	public int allActivityCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.activity.allActivityCnt");
	}

	@Override
	public int allCrsCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.activity.allCrsCnt");
	}

	@Override
	public ActivityDTO selectOne(int ac_no) {
		// TODO Auto-generated method stub
		ActivityDTO activity = sqlSession.selectOne("mapper.activity.selectac_no", ac_no);
		return activity;
	}

	@Override
	public List<ReviewDTO> reviewList(int ac_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.activity.reviewList", ac_no);
	}

	@Override
	public void myPick(Map pickMap) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.activity.activity_myPick", pickMap);
	}

	@Override
	public void delPick(Map pickMap) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.activity.activity_delPick", pickMap);
	}

	@Override
	public int checkPick(Map pickMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.activity.checkPick", pickMap);
	}

	@Override
	public int addReview(ReviewDTO review) {
		// TODO Auto-generated method stub
		return sqlSession.insert("mapper.activity.addReview", review);
	}

	@Override
	public Double average(int ac_no) {
		// TODO Auto-generated method stub
		String avg_result = sqlSession.selectOne("mapper.activity.average", ac_no);
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

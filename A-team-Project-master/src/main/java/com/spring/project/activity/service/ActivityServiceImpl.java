package com.spring.project.activity.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.activity.dao.ActivityDAO;
import com.spring.project.activity.dto.ActivityDTO;
import com.spring.project.activity.dto.ReviewDTO;

@Service
public class ActivityServiceImpl implements ActivityService{
	@Autowired
	ActivityDAO activityDAO;
	
	
	@Override
	public int allActivityCnt() {
		// TODO Auto-generated method stub
		return activityDAO.allActivityCnt();
	}

	@Override
	public int allCrsCnt() {
		// TODO Auto-generated method stub
		return activityDAO.allCrsCnt();
	}

	@Override
	public List<ActivityDTO> activityList(int start, int end) {
		// TODO Auto-generated method stub
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		
		return activityDAO.activityList(page);
	}

	@Override
	public List<ActivityDTO> crsList(int start, int end) {
		// TODO Auto-generated method stub
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		
		return activityDAO.crsList(page);
	}

	@Override
	public ActivityDTO selectOne(int ac_no) {
		// TODO Auto-generated method stub	
		return activityDAO.selectOne(ac_no);
	}

	@Override
	public List<ReviewDTO> reviewList(int ac_no) {
		// TODO Auto-generated method stub
		return activityDAO.reviewList(ac_no);
	}

	@Override
	public void myPick(Map pickMap) {
		// TODO Auto-generated method stub
		activityDAO.myPick(pickMap);
	}

	@Override
	public void delPick(Map pickMap) {
		// TODO Auto-generated method stub
		activityDAO.delPick(pickMap);
	}

	@Override
	public int checkPick(Map pickMap) {
		// TODO Auto-generated method stub
		return activityDAO.checkPick(pickMap);
	}

	@Override
	public int addReview(ReviewDTO review) {
		// TODO Auto-generated method stub
		return activityDAO.addReview(review);
	}

	@Override
	public Double average(int ac_no) {
		// TODO Auto-generated method stub
		return activityDAO.average(ac_no);
	}

}

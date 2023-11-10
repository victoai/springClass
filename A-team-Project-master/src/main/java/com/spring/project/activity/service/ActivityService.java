package com.spring.project.activity.service;

import java.util.List;
import java.util.Map;

import com.spring.project.activity.dto.ActivityDTO;
import com.spring.project.activity.dto.ReviewDTO;

public interface ActivityService {

	public int allActivityCnt();
	
	public int allCrsCnt();

	public List<ActivityDTO> activityList(int start, int end);

	public List<ActivityDTO> crsList(int start, int end);

	public ActivityDTO selectOne(int ac_no);

	public List<ReviewDTO> reviewList(int ac_no);

	public void myPick(Map pickMap);

	public void delPick(Map pickMap);
	
	public int checkPick(Map pickMap);

	public int addReview(ReviewDTO review);

	public Double average(int ac_no);

}

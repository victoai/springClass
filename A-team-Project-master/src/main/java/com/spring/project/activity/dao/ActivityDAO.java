package com.spring.project.activity.dao;

import java.util.List;
import java.util.Map;

import com.spring.project.activity.dto.ActivityDTO;
import com.spring.project.activity.dto.ReviewDTO;


public interface ActivityDAO {

	public void dbInsert(ActivityDTO activity);

	List<ActivityDTO> crsList(Map<String, Integer> page);

	List<ActivityDTO> activityList(Map<String, Integer> page);

	public int allActivityCnt();

	public int allCrsCnt();

	public ActivityDTO selectOne(int ac_no);

	public List<ReviewDTO> reviewList(int ac_no);

	public void myPick(Map pickMap);

	public void delPick(Map pickMap);

	public int checkPick(Map pickMap);

	public int addReview(ReviewDTO review);

	public Double average(int ac_no);

}

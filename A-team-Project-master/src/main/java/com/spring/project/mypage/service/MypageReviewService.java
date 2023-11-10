package com.spring.project.mypage.service;

import java.util.List;


import com.spring.project.mypage.dto.ReviewDTO;

public interface MypageReviewService {

	public List<ReviewDTO> reviewList(String id);

	public void reviewDel(int re_no);

	public ReviewDTO reviewModList(int re_no);

	public int modReview(ReviewDTO review);

}

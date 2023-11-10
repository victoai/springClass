package com.spring.project.mypage.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.project.mypage.dto.ReviewDTO;

@Repository
public class MypageReviewDAOImpl implements MypageReviewDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ReviewDTO> reviewList(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.mypage.reviewList", id);

	}

	@Override
	public void reviewDel(int re_no) {
		// TODO Auto-generated method stub
			sqlSession.delete("mapper.mypage.reviewDel", re_no);
	}

	@Override
	public ReviewDTO reviewModForm(int re_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.mypage.reviewModForm", re_no);
	}

	@Override
	public int modReview(ReviewDTO review) {
		// TODO Auto-generated method stub
		return sqlSession.update("mapper.mypage.modReview", review);
	}

	

}

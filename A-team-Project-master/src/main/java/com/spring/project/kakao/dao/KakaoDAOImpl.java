package com.spring.project.kakao.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.member.dto.MemberDTO;

@Repository("kakaoDAO")
public class KakaoDAOImpl implements KakaoDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 정보 저장
	@Override
	public void kakaoInsert(HashMap<String, Object> userInfo) {
		sqlSession.insert("mapper.kakao.insert", userInfo);
	}
	
	// 정보 확인
	@Override
	public MemberDTO findKakao(HashMap<String, Object> userInfo) {
//		System.out.println("RN : " + userInfo.get("name"));
//		System.out.println("daoimpl의 id email gender" + userInfo.get("id") + userInfo.get("gender") + userInfo.get("email"));
		
		return sqlSession.selectOne("mapper.kakao.kakao", userInfo);
	}

	@Override
	public MemberDTO kakaoLogin(MemberDTO userInfo) {
		// TODO Auto-generated method stub
		MemberDTO memberDTO = sqlSession.selectOne("mapper.kakao.kakaoLogin");
		return memberDTO;
	}
}

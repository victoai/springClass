package com.spring.project.kakao.dao;

import java.util.HashMap;

import com.spring.project.member.dto.MemberDTO;

public interface KakaoDAO {

	void kakaoInsert(HashMap<String, Object> userInfo);

	MemberDTO findKakao(HashMap<String, Object> userInfo);

	MemberDTO kakaoLogin(MemberDTO userInfo);

}

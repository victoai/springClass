package com.spring.project.kakao.service;

import java.util.HashMap;

import com.spring.project.member.dto.MemberDTO;

public interface KakaoService {

	public MemberDTO findKakao(HashMap<String, Object> userInfo);

	public void kakaoInsert(HashMap<String, Object> userInfo);

	public MemberDTO kakaoLogin(MemberDTO userInfo);

}

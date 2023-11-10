package com.spring.project.member.dao;

import com.spring.project.member.dto.MemberDTO;

public interface MemberDAO {
	public void addMember(MemberDTO member);
	public int modMember(MemberDTO member);
	public int delMember(String id);
	public MemberDTO login(MemberDTO member);
	public int idChk(String id);
	public String findId(MemberDTO member);
	public String findPwd(MemberDTO member);
}

package com.spring.project.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.member.dao.MemberDAO;
import com.spring.project.member.dto.MemberDTO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public void addMember(MemberDTO member) {
		// TODO Auto-generated method stub
		memberDAO.addMember(member);
	}

	@Override
	public int modMember(MemberDTO member) {
		// TODO Auto-generated method stub
		return memberDAO.modMember(member);
	}

	@Override
	public int delMember(String id) {
		// TODO Auto-generated method stub
		return memberDAO.delMember(id);
	}

	@Override
	public MemberDTO login(MemberDTO member) {
		// TODO Auto-generated method stub
		return memberDAO.login(member);
	}

	@Override
	public int idChk(String id) {
		// TODO Auto-generated method stub
		int result = memberDAO.idChk(id);
		return result;
	}

	@Override
	public String findId(MemberDTO member) {
		// TODO Auto-generated method stub
		return memberDAO.findId(member);
	}

	@Override
	public String findPwd(MemberDTO member) {
		// TODO Auto-generated method stub
		return memberDAO.findPwd(member);
	}

}

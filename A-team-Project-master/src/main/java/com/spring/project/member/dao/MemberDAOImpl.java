package com.spring.project.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.member.dto.MemberDTO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addMember(MemberDTO member) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.member.insertMember", member);
	}

	@Override
	public int idChk(String id) {
		// TODO Auto-generated method stub
		int result = sqlSession.selectOne("mapper.member.idChk", id);
		return result;
	}

	@Override
	public int modMember(MemberDTO member) {
		// TODO Auto-generated method stub
		int result = sqlSession.update("mapper.member.updateMember", member);
		return result;
	}

	@Override
	public int delMember(String id) {
		// TODO Auto-generated method stub
		int result = sqlSession.delete("mapper.member.deleteMember", id);
		return result;
	}

	@Override
	public MemberDTO login(MemberDTO member) {
		// TODO Auto-generated method stub
		MemberDTO memberDTO = sqlSession.selectOne("mapper.member.loginById", member);
		return memberDTO;
	}

	@Override
	public String findId(MemberDTO member) {
		// TODO Auto-generated method stub
		String findId = sqlSession.selectOne("mapper.member.findId", member);
		return findId;
	}

	@Override
	public String findPwd(MemberDTO member) {
		// TODO Auto-generated method stub
		String findPwd = sqlSession.selectOne("mapper.member.findPwd", member);
		return findPwd;
	}

}
















package com.spring.project.mypage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.mypage.dto.LodReservationDTO;

@Repository
public class LodReservationDAOImpl implements LodReservationDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<LodReservationDTO> lodreservationList(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.mypage.lodreservationcheck", id);
	}

}

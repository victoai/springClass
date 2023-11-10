package com.spring.project.mypage.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.mypage.dto.MyReservationDTO;

@Repository
public class MyReservationDAOImpl implements MyReservationDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<MyReservationDTO> reservationAirList(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.mypage.reservationcheck", id);
	}

}

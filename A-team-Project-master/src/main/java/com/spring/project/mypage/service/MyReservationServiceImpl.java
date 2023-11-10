package com.spring.project.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.mypage.dto.MyReservationDTO;
import com.spring.project.mypage.dao.MyReservationDAO;

@Service
public class MyReservationServiceImpl implements MyReservationService{
	@Autowired
	private MyReservationDAO myreservationDAO;

	@Override
	public List<MyReservationDTO> reservationAirList(String id) {
		// TODO Auto-generated method stub
		return myreservationDAO.reservationAirList(id);
	}

}

package com.spring.project.mypage.dao;

import java.util.List;

import com.spring.project.mypage.dto.MyReservationDTO;

public interface MyReservationDAO {
	
	public List<MyReservationDTO> reservationAirList(String id);

}

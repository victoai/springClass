package com.spring.project.mypage.service;

import java.util.List;


import com.spring.project.mypage.dto.MyReservationDTO;

public interface MyReservationService {
	
	public List<MyReservationDTO> reservationAirList(String id);

}

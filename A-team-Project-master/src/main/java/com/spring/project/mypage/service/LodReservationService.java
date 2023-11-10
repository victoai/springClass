package com.spring.project.mypage.service;

import java.util.List;

import com.spring.project.mypage.dto.LodReservationDTO;

public interface LodReservationService {
	
	public List<LodReservationDTO> lodreservationList(String id);

}

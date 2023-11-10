package com.spring.project.mypage.dao;

import java.util.List;

import com.spring.project.mypage.dto.LodReservationDTO;

public interface LodReservationDAO {
	
	public List<LodReservationDTO> lodreservationList(String id);
}

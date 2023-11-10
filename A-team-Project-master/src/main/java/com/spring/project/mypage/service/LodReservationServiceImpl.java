package com.spring.project.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.mypage.dao.LodReservationDAO;
import com.spring.project.mypage.dto.LodReservationDTO;

@Service
public class LodReservationServiceImpl implements LodReservationService {
	
	@Autowired
	private LodReservationDAO lodreservationDAO;

	@Override
	public List<LodReservationDTO> lodreservationList(String id) {
		// TODO Auto-generated method stub
		return lodreservationDAO.lodreservationList(id);
	}

}

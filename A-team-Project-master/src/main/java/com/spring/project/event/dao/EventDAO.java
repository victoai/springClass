package com.spring.project.event.dao;

import java.util.List;
import java.util.Map;

import com.spring.project.event.dto.AirplaneDTO;
import com.spring.project.event.dto.LodgingDTO;
import com.spring.project.event.dto.LodgingResDTO;
import com.spring.project.event.dto.ResAirplaneDTO;
import com.spring.project.event.dto.ReviewDTO;
import com.spring.project.event.dto.RoomInfoDTO;

public interface EventDAO {

	public AirplaneDTO selectAir_no_from(int air_no_from);

	public AirplaneDTO selectAir_no_to(int air_no_to);

	public void resetAir();

	public void addAirplane(AirplaneDTO air);

	public int allLodCnt();

	public List<LodgingDTO> lodList(Map<String, Integer> page);

	public LodgingDTO lodDatail(int lod_id);

	public List<RoomInfoDTO> roomList(int lod_id);

	public RoomInfoDTO roomInfo(RoomInfoDTO room);

	public int addLodRes(LodgingResDTO res);

	public List<AirplaneDTO> airListTo();

	public List<AirplaneDTO> airListFrom();

	public void myPick(Map pickMap);

	public void delPick(Map pickMap);

	public int checkPcik(Map pickMap);

	public int addReview(ReviewDTO review);

	public List<ReviewDTO> reviewList(int lod_id);

	public ResAirplaneDTO selectAir(int air_no);

	public int resAirplane(ResAirplaneDTO resAir);

	public int allHotelCnt();

	public List<LodgingDTO> hotelList(Map<String, Integer> page);

	public int allResortCnt();

	public List<LodgingDTO> resortList(Map<String, Integer> page);

	public int allHouseCnt();

	public List<LodgingDTO> houseList(Map<String, Integer> page);

	public Double average(int lod_id);




}

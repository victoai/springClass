package com.spring.project.event.service;

import java.util.List;
import java.util.Map;

import com.spring.project.event.dto.AirplaneDTO;
import com.spring.project.event.dto.LodgingDTO;
import com.spring.project.event.dto.LodgingResDTO;
import com.spring.project.event.dto.ResAirplaneDTO;
import com.spring.project.event.dto.ReviewDTO;
import com.spring.project.event.dto.RoomInfoDTO;

public interface EventService {

	public List<AirplaneDTO> departList(AirplaneDTO air) throws Exception ;
	
	public List<AirplaneDTO> arrivalList(AirplaneDTO air) throws Exception ;

	public List<AirplaneDTO> checkReserv(int air_no_from, int air_no_to);

	public void resetAir();

	public int allLodCnt();

	public List<LodgingDTO> lodList(int start, int end);

	public LodgingDTO lodDatail(int lod_id);

	public List<RoomInfoDTO> roomList(int lod_id);

	public RoomInfoDTO roomInfo(RoomInfoDTO room);

	public int addLodRes(LodgingResDTO res);

	public void myPick(Map pickMap);

	public void delPick(Map pickMap);

	public int checkPick(Map pickMap);

	 public int addReview(ReviewDTO review);

	public List<ReviewDTO> reviewList(int lod_id);

	public ResAirplaneDTO selectAir(int air_no1);

	public int resAirplane(ResAirplaneDTO depart);

	public int allHotelCnt();

	public List<LodgingDTO> hotelList(int start, int end);

	public int allResortCnt();

	public List<LodgingDTO> resortList(int start, int end);

	public int allHouseCnt();

	public List<LodgingDTO> houseList(int start, int end);

	public Double average(int lod_id);
	

}

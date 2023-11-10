package com.spring.project.event.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.event.dto.AirplaneDTO;
import com.spring.project.event.dto.LodgingDTO;
import com.spring.project.event.dto.LodgingResDTO;
import com.spring.project.event.dto.ResAirplaneDTO;
import com.spring.project.event.dto.ReviewDTO;
import com.spring.project.event.dto.RoomInfoDTO;

@Repository
public class EventDAOImpl implements EventDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public AirplaneDTO selectAir_no_from(int air_no_from) {
		// TODO Auto-generated method stub
		// 가는 편 정보
		AirplaneDTO  airplane_from = sqlSession.selectOne("mapper.event.selectAir_no_from", air_no_from);
		return airplane_from;
	}


	@Override
	public AirplaneDTO selectAir_no_to(int air_no_to) {
		// TODO Auto-generated method stub
		// 오는 편 정보
		AirplaneDTO  airplane_to = sqlSession.selectOne("mapper.event.selectAir_no_to", air_no_to);
		return airplane_to;
	}


	@Override
	public void resetAir() {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.event.resetAir");
	}


	@Override
	public void addAirplane(AirplaneDTO air) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.event.addAirplane",air);
	}


	@Override
	public int allLodCnt() {
		// TODO Auto-generated method stub
		// 숙박 테이블 총갯수
		return sqlSession.selectOne("mapper.event.allLodCnt");
	}


	@Override
	public List<LodgingDTO> lodList(Map<String, Integer> page) {
		// TODO Auto-generated method stub
		// 숙박테이블 리스트
		return sqlSession.selectList("mapper.event.lodList",page);
	}


	@Override
	public LodgingDTO lodDatail(int lod_id) {
		// TODO Auto-generated method stub
		// 선택한 숙박업체 상세정보
		return sqlSession.selectOne("mapper.event.lodDetail",lod_id);
	}


	@Override
	public List<RoomInfoDTO> roomList(int lod_id) {
		// TODO Auto-generated method stub
		// 선택한 숙박업체 객실 리스트
		return sqlSession.selectList("mapper.event.roomList",lod_id);
	}


	@Override
	public RoomInfoDTO roomInfo(RoomInfoDTO room) {
		// TODO Auto-generated method stub
		// 객실 상세 정보
		return sqlSession.selectOne("mapper.event.roomInfo",room);
	}


	@Override
	public int addLodRes(LodgingResDTO res) {
		// TODO Auto-generated method stub
		// 예약 정보 인서트
		return sqlSession.insert("mapper.event.addLodRes",res);
	}


	@Override
	public List<AirplaneDTO> airListTo() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.event.airListTo");
	}


	@Override
	public List<AirplaneDTO> airListFrom() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.event.airListFrom");
	}


	@Override
	public void myPick(Map pickMap) {
		// TODO Auto-generated method stub
		// 찜하기 인서트
		sqlSession.insert("mapper.event.lod_myPick", pickMap);
	}


	@Override
	public void delPick(Map pickMap) {
		// TODO Auto-generated method stub
		// 찜하기 취소
		sqlSession.insert("mapper.event.lod_delPick", pickMap);
	}


	@Override
	public int checkPcik(Map pickMap) {
		// TODO Auto-generated method stub
		// 찜하기 체크
		return sqlSession.selectOne("mapper.event.checkPick", pickMap);
	}

	@Override
	public int addReview(ReviewDTO review) {
		// TODO Auto-generated method stub
		// 리뷰 등록 인서트
		return sqlSession.insert("mapper.event.addReview", review);
	}


	@Override
	public List<ReviewDTO> reviewList(int lod_id) {
		// TODO Auto-generated method stub
		// 리뷰 리스트
		return sqlSession.selectList("mapper.event.reviewList",lod_id);
	}


	@Override
	public ResAirplaneDTO selectAir(int air_no) {
		// TODO Auto-generated method stub
		// 예약을 위한 정보
		return sqlSession.selectOne("mapper.event.selectAir",air_no);
	}


	@Override
	public int resAirplane(ResAirplaneDTO resAir) {
		// TODO Auto-generated method stub
		// 예약 완료 인서트
		return sqlSession.insert("mapper.event.resAirplane",resAir);
	}


	@Override
	public int allHotelCnt() {
		// TODO Auto-generated method stub
		// 호텔관련 총갯수 카운트
		return sqlSession.selectOne("mapper.event.allHotelCnt");
	}


	@Override
	public List<LodgingDTO> hotelList(Map<String, Integer> page) {
		// TODO Auto-generated method stub
		// 호텔 리스트
		return sqlSession.selectList("mapper.event.hotelList",page);
	}


	@Override
	public int allResortCnt() {
		// TODO Auto-generated method stub
		// 리조트 총갯수 카운트
		return sqlSession.selectOne("mapper.event.allResortCnt");
	}


	@Override
	public List<LodgingDTO> resortList(Map<String, Integer> page) {
		// TODO Auto-generated method stub
		// 리조트 리스트
		return sqlSession.selectList("mapper.event.resortList",page);
	}


	@Override
	public int allHouseCnt() {
		// TODO Auto-generated method stub
		// 펜션/게하 총 갯수 카운트
		return sqlSession.selectOne("mapper.event.allHouseCnt");
	}


	@Override
	public List<LodgingDTO> houseList(Map<String, Integer> page) {
		// TODO Auto-generated method stub
		// 펜션/게하 리스트
		return sqlSession.selectList("mapper.event.houseList",page);
	}


	@Override
	public Double average(int lod_id) {
		// TODO Auto-generated method stub
		// 평점
		String avg_result = sqlSession.selectOne("mapper.event.average", lod_id);
		Double avg = 0.0;
		if(avg_result==null) {
			avg_result = "0";
			avg = Double.parseDouble(avg_result)/1.0;
			return avg;
		} else {
			avg = Double.parseDouble(avg_result)/1.0;
		}
		return avg;
	}
	
}

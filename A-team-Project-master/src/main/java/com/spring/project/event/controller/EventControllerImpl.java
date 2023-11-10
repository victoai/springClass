package com.spring.project.event.controller;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.event.dto.AirplaneDTO;
import com.spring.project.event.service.EventService;
import com.spring.project.event.dto.ReviewDTO;
import com.spring.project.member.dto.MemberDTO;


import com.spring.project.event.dto.LodgingDTO;
import com.spring.project.event.dto.LodgingResDTO;
import com.spring.project.event.dto.ResAirplaneDTO;
import com.spring.project.event.dto.RoomInfoDTO;

@Controller("eventController")
@RequestMapping("/event")
public class EventControllerImpl implements EventController {
	@Autowired
	EventService eventService;
	
	@Override
	@RequestMapping("/main")
	public String airport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 상단 바에서 이벤트를 눌렀을 때 혹은 이벤트안에서 항공 버튼을 눌렀을 때 가는 항공편 메인 페이지
		return "/event/airmain";
	}

	@Override
	@RequestMapping("/lodmain")
	public String lodging(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 이벤트안에서 숙박 버튼을 눌렀을 때 가는 숙박 예약 메인 페이지
		return "/event/lodmain";
	}

	@Override
	@RequestMapping("/airDetail")
	public ModelAndView airDetail(@ModelAttribute("air") AirplaneDTO air, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		// 출도착 공항과 날짜를 입력 후 그 정보에 맞는 항공편을 보여주는 메서드
		eventService.resetAir();
		String date = request.getParameter("date");
		// 가는 날
		String fromdate = date.substring(0,10);
		// 오는 날
		String todate= date.substring(13);
		
		air.setAir_date(fromdate);
		// 가는 날 항공편을 항공편 스케줄 api를 실행해서 담는 리스트
		List<AirplaneDTO> airplaneList = eventService.arrivalList(air);
		air.setAir_date(todate);
		// 오는 날 항공편을 항공편 스케줄 api를 실행해서 담는 리스트
		List<AirplaneDTO> airplaneList2 = eventService.departList(air);
		
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		// 가는 날 오는 날 오는 날 항공편 리스트를 jsp로 보내주기
		mav.addObject("airplaneList", airplaneList);
		mav.addObject("airplaneList2", airplaneList2);
		
		return mav;
	}

	@Override
	@RequestMapping("/checkReserv")
	public ModelAndView checkReserv(@RequestParam("air_no_from") int air_no_from,@RequestParam("air_no_to") int air_no_to, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 선택한 항공편을 가져와서 확인하고 예약을 진행하는 페이지
		List<AirplaneDTO> airplaneList = eventService.checkReserv(air_no_from, air_no_to);
		
		int price_from = airplaneList.get(0).getAir_price();
		int price_to = airplaneList.get(1).getAir_price();
		int sum = price_from + price_to; 
		
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		// 가는 편 오는편이 저장된 리스트와 가격을 합친 sum값을 jsp로 보내주기
		mav.addObject("airplaneList", airplaneList);
		mav.addObject("sum", sum);
		return mav;
	}

	@Override
	@RequestMapping("/airReserve")
	public void airReserv(int air_no1, int air_no2, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 가는편 예약 테이블 인서트
		ResAirplaneDTO depart = eventService.selectAir(air_no1);
		depart.setId(request.getParameter("id"));
		depart.setName(request.getParameter("name"));
		depart.setBirth(Integer.parseInt(request.getParameter("birth")));
		depart.setPayment(request.getParameter("payment"));
		int result = eventService.resAirplane(depart);
		
		out.println("<script>");
		if(result == 1) {
			// 오는편 예약 테이블 인서트
			ResAirplaneDTO comeBack = eventService.selectAir(air_no2);
			comeBack.setId(request.getParameter("id"));
			comeBack.setName(request.getParameter("name"));
			comeBack.setBirth(Integer.parseInt(request.getParameter("birth")));
			comeBack.setPayment(request.getParameter("payment"));
			int result2 = eventService.resAirplane(comeBack);
		
			if(result2 == 1) {
				out.println("alert('항공권 예약이 완료 되었습니다. 예약된 내역은 [마이페이지 > 내 예약확인]에서 확인하실 수 있습니다.')");
			}else {
				out.println("alert('예약이 되지 않았습니다. 다시 시도해 주세요.');");
			}
		} else {
			out.println("alert('예약이 되지 않았습니다. 다시 시도해 주세요.');");
		}
		out.println("location.href='"+ request.getContextPath()+ "/main/main.do';");
		out.println("</script>");
	}

	@Override
	@RequestMapping("/lodDetail")
	public ModelAndView lodDetail(@RequestParam("page") int page, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
				
		HttpSession session = request.getSession();
		// 처음 페이지 
		if(!(request.getParameter("lodDate") == null)) {
			session.setAttribute("checkIn", request.getParameter("checkIn"));
			session.setAttribute("checkOut", request.getParameter("checkOut"));

			// 숙박일 수 계산
			String CheckIn = (String) session.getAttribute("checkIn");
			String CheckOut = (String) session.getAttribute("checkOut");

			LocalDate StartDate = LocalDate.parse(CheckIn);
			LocalDate EndDate = LocalDate.parse(CheckOut);

			Period period = Period.between(StartDate, EndDate);

			int resultDay = period.getDays();
			mav.addObject("resultDay", resultDay); 
		} 
		
		
		// 두번째 이후 페이지 - 숙박일 수 계산
		String CheckIn = (String) session.getAttribute("checkIn");
		String CheckOut = (String) session.getAttribute("checkOut");

		LocalDate StartDate = LocalDate.parse(CheckIn);
		LocalDate EndDate = LocalDate.parse(CheckOut);

		Period period = Period.between(StartDate, EndDate);

		int resultDay = period.getDays();
		mav.addObject("resultDay", resultDay); 
		
		
		int lodCnt = eventService.allLodCnt();
		int postNum = 12;
		int pageNum = (int)Math.ceil((double)lodCnt/postNum);
		
		int start = 0;
		if(page == 1) {
			start = 1;
		}else {
			start = (page-1) * postNum + 1;
		}
		int end = start + (postNum-1);
		
		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)page / (double)pageNum_cnt) * pageNum_cnt);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		// 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)lodCnt / (double)postNum));
		 
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= lodCnt ? false : true;
		// 선택한 페이지번호로 계산된 만큼에 숙박 정보를 담은 리스트
		List<LodgingDTO> lodList = eventService.lodList(start, end);
		mav.addObject("lodList", lodList);
		mav.addObject("pageNum", pageNum);
		// 시작 및 끝 번호
		mav.addObject("startPageNum", startPageNum);
		mav.addObject("endPageNum", endPageNum);

		// 이전 및 다음 
		mav.addObject("prev", prev);
		mav.addObject("next", next);
		return mav;
	}
	

	@Override
	@RequestMapping("/lodDetail_hotel")
	public ModelAndView lodDetailHotel(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		HttpSession session = request.getSession();
		
		// 숙박일 수 계산
		String CheckIn = (String) session.getAttribute("checkIn");
		String CheckOut = (String) session.getAttribute("checkOut");
				
		LocalDate StartDate = LocalDate.parse(CheckIn);
		LocalDate EndDate = LocalDate.parse(CheckOut);

		Period period = Period.between(StartDate, EndDate);
				
		int resultDay = period.getDays();
		mav.addObject("resultDay", resultDay); //
				
		int HotelCnt = eventService.allHotelCnt();
		int postNum = 12;
		int pageNum = (int)Math.ceil((double)HotelCnt/postNum);
		
		int start = 0;
		if(page == 1) {
			start = 1;
		}else {
			start = (page-1) * postNum + 1;
		}
		int end = start + (postNum-1);
		
		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)page / (double)pageNum_cnt) * pageNum_cnt);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		// 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)HotelCnt / (double)postNum));
		 
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= HotelCnt ? false : true;
		List<LodgingDTO> hotelList = eventService.hotelList(start, end);
		mav.addObject("hotelList", hotelList);
		mav.addObject("pageNum", pageNum);
		// 시작 및 끝 번호
		mav.addObject("startPageNum", startPageNum);
		mav.addObject("endPageNum", endPageNum);

		// 이전 및 다음 
		mav.addObject("prev", prev);
		mav.addObject("next", next);
		return mav;
	}
	
	
	@Override
	@RequestMapping("/lodDetail_resort")
	public ModelAndView lodDetailResort(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		HttpSession session = request.getSession();
		
		// 숙박일 수 계산
		String CheckIn = (String) session.getAttribute("checkIn");
		String CheckOut = (String) session.getAttribute("checkOut");
				
		LocalDate StartDate = LocalDate.parse(CheckIn);
		LocalDate EndDate = LocalDate.parse(CheckOut);

		Period period = Period.between(StartDate, EndDate);
				
		int resultDay = period.getDays();
		mav.addObject("resultDay", resultDay); //
		
		int ResortCnt = eventService.allResortCnt();
		int postNum = 12;
		int pageNum = (int)Math.ceil((double)ResortCnt/postNum);
		
		int start = 0;
		if(page == 1) {
			start = 1;
		}else {
			start = (page-1) * postNum + 1;
		}
		int end = start + (postNum-1);
		
		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)page / (double)pageNum_cnt) * pageNum_cnt);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		// 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)ResortCnt / (double)postNum));
		 
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= ResortCnt ? false : true;

		List<LodgingDTO> resortList = eventService.resortList(start, end);
		mav.addObject("resortList", resortList);
		mav.addObject("pageNum", pageNum);
		// 시작 및 끝 번호
		mav.addObject("startPageNum", startPageNum);
		mav.addObject("endPageNum", endPageNum);

		// 이전 및 다음 
		mav.addObject("prev", prev);
		mav.addObject("next", next);
		return mav;
	}
	
	
	
	@Override
	@RequestMapping("/lodDetail_house")
	public ModelAndView lodDetailHouse(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		HttpSession session = request.getSession();
		
		// 숙박일 수 계산
		String CheckIn = (String) session.getAttribute("checkIn");
		String CheckOut = (String) session.getAttribute("checkOut");
				
		LocalDate StartDate = LocalDate.parse(CheckIn);
		LocalDate EndDate = LocalDate.parse(CheckOut);

		Period period = Period.between(StartDate, EndDate);
				
		int resultDay = period.getDays();
		mav.addObject("resultDay", resultDay); //
		
		int HouseCnt = eventService.allHouseCnt();
		int postNum = 12;
		int pageNum = (int)Math.ceil((double)HouseCnt/postNum);
		
		int start = 0;
		if(page == 1) {
			start = 1;
		}else {
			start = (page-1) * postNum + 1;
		}
		int end = start + (postNum-1);
		
		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)page / (double)pageNum_cnt) * pageNum_cnt);

		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		// 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)HouseCnt / (double)postNum));
		 
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= HouseCnt ? false : true;

		List<LodgingDTO> houseList = eventService.houseList(start, end);
		mav.addObject("houseList", houseList);
		mav.addObject("pageNum", pageNum);
		// 시작 및 끝 번호
		mav.addObject("startPageNum", startPageNum);
		mav.addObject("endPageNum", endPageNum);

		// 이전 및 다음 
		mav.addObject("prev", prev);
		mav.addObject("next", next);
		return mav;
	}
	
	@Override
	@RequestMapping("/lodInfo")
	public ModelAndView lodInfo(@RequestParam("lod_id") int lod_id, @RequestParam("resultDay") int resultDay,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 하나의 숙박 업체를 선택했을 시 선택한 업체의 상세 설명 객실정보를 보여주는 메서드
		HttpSession session = request.getSession();
		Boolean isLogOn = (Boolean) session.getAttribute("isLogOn");
		LodgingDTO lodging = eventService.lodDatail(lod_id);
		List<RoomInfoDTO> roomList = eventService.roomList(lod_id);
		List<ReviewDTO> reviewList = eventService.reviewList(lod_id);
		String viewName = (String) request.getAttribute("viewName");
		// 평점
		Double avg = eventService.average(lod_id);
				
		ModelAndView mav = new ModelAndView(viewName);
		if(isLogOn!=null && isLogOn==true) {
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			Map pickMap = new HashMap();
			pickMap.put("id", member.getId());
			pickMap.put("lod_id", lod_id);
			
			int result = eventService.checkPick(pickMap);
			
			if(result==1) {
				mav.addObject("pick", true);
			}
		} 
		// 평점, 숙박 일수 계산, 선택한 업체 정보, 선택한 업체의 객실 리스트, 선택한 업체에 달린 리뷰 리스트를 jsp로 전송
		mav.addObject("avg", avg);
		mav.addObject("resultDay", resultDay);
		mav.addObject("lodging",lodging);
		mav.addObject("roomList",roomList);
		mav.addObject("reviewList",reviewList);
		return mav;
	}

	@Override
	@RequestMapping("/roomRes")
	public ModelAndView roomRes(@ModelAttribute("room") RoomInfoDTO room, @RequestParam("resultDay") int resultDay,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 객실 선택 시 객실 상세정보를 확인 후 예약을 진행하는 메서드
		room = eventService.roomInfo(room);
		LodgingDTO lodging = eventService.lodDatail(Integer.parseInt(room.getLod_id()));
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		// 선택한 객실 정보, 숙박 일수 를 jsp로 전송
		mav.addObject("room",room);
		mav.addObject("lodging",lodging);
		mav.addObject("resultDay", resultDay);
		return mav;
	}
	
	
	@Override
	@RequestMapping("/resPay")
	public String resPay(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		// 결제 하기 버튼을 누를 때 결제중 이라는 팝업창이 뜨도록 하는 메서드
		return "event/resPay";
	}

	@Override
	@RequestMapping(value="/resConfirmation",method = RequestMethod.POST)
	public void resPay(@ModelAttribute("res") LodgingResDTO res, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		// 예약이 완료되고 숙박 예약 테이블에 저장되면서 완료 alert를 띄워 주는 메서드
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int result = eventService.addLodRes(res);
		out.println("<script>");
		if(result == 1) {
			session.removeAttribute("from");
			session.removeAttribute("to");
			out.println("alert('예약이 완료되었습니다. 예약 내역은 [마이페이지 > 내 예약보기]에서 확인하실 수 있습니다.')");
		} else {
			out.println("alert('예약에 실패했습니다. 다시 시도해 주세요.');");
		}
		out.println("location.href='"+ request.getContextPath() 
				+ "/main/main.do';");
		out.println("</script>");
		
	}
	
	@Override
	@RequestMapping(value="/myPick", method=RequestMethod.GET)
	public ModelAndView myPick(@RequestParam("lod_id") int lod_id, @RequestParam("pick") boolean pick,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 찜하기
			response.setContentType("text/html;charset=utf-8");
			
			HttpSession session = request.getSession();
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			Boolean isLogOn = (Boolean) session.getAttribute("isLogOn");
			
			ModelAndView  mav = new ModelAndView("event/lodInfo");
			if(!(isLogOn!=null && isLogOn==true)) {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인 후 이용가능합니다..');");
				out.println("location.href='" + request.getContextPath() +"/member/loginForm.do';");
				out.println("</script>");
				return null;
			}
			
			LodgingDTO lodging = eventService.lodDatail(lod_id);
			List<RoomInfoDTO> roomList = eventService.roomList(lod_id);
			List<ReviewDTO> reviewList = eventService.reviewList(lod_id);
			mav.addObject("lodging", lodging);
			mav.addObject("roomList",roomList);
			mav.addObject("reviewList",reviewList);
			
			Map pickMap = new HashMap();
			pickMap.put("id", member.getId());
			pickMap.put("lod_id", lod_id);
			
			if(pick) {
				eventService.myPick(pickMap);
				mav.addObject("pick",true);
			}else {
				eventService.delPick(pickMap);
				mav.addObject("pick",false);
			}
			return mav;
	}
	@Override
	@RequestMapping("/reviewForm")    
	public ModelAndView myReview(@RequestParam("lod_id") int lod_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		// 리뷰 작성 폼
		HttpSession session = request.getSession();
		Boolean isLogOn = (Boolean) session.getAttribute("isLogOn");
		ModelAndView mav = null;
		if(isLogOn!=null && isLogOn==true) {
			String viewName = (String) request.getAttribute("viewName");
			mav = new ModelAndView(viewName);
			mav.addObject("lod_id",lod_id);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 이용가능합니다..');");
			out.println("location.href='" + request.getContextPath() +"/member/loginForm.do';");
			out.println("</script>");
			return null;
		}
		
		return mav;
	}

	@Override
	@RequestMapping(value="/addReview", method=RequestMethod.POST)
	public void addReview(@ModelAttribute("review") ReviewDTO review, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 리뷰 작성 후 db에 저장되고 리뷰 등록 완료 alert창 띄워주는 메서드
		response.setContentType("text/html;charset=utf-8");
		
		int result = eventService.addReview(review);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(result == 1) {
			out.println("alert('리뷰등록이 완료 되었습니다. 작성하신 리뷰는 [마이페이지 > 나의 리뷰보기]에서 확인하실 수 있습니다.')");
		} else {
			out.println("alert('리뷰가 등록되지 않았습니다.');");
		}
		out.println("location.href='"+ request.getContextPath() 
				+ "/event/lodInfo?lod_id="+review.getLod_id()+"&resultDay=0';"); 
		out.println("</script>");
		
	}

}

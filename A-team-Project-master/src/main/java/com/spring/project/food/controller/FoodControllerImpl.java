package com.spring.project.food.controller;

import java.io.PrintWriter;
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

import com.spring.project.food.dto.FoodDTO;
import com.spring.project.food.dto.ReviewDTO;
import com.spring.project.food.service.FoodService;
import com.spring.project.member.dto.MemberDTO;

@Controller("foodController")
@RequestMapping("/food")
public class FoodControllerImpl implements FoodController {
	@Autowired
	FoodService foodService;
	
	@Override
	@RequestMapping("/main")
	public String restaurant(@RequestParam("page") int page,HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		// 맛집 정보 갯수 불러오기
		int FoodCnt = foodService.allFoodCnt();
		
		int postNum = 12;
		
		int pageNum = (int)Math.ceil((double)FoodCnt/postNum);
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
		int endPageNum_tmp = (int)(Math.ceil((double)FoodCnt / (double)postNum));
		 
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= FoodCnt ? false : true;
		
		// 맛집 정보 리스트로 가져오기
		List<FoodDTO> foodList = foodService.foodList(start, end);
		request.setAttribute("foodList", foodList);
		request.setAttribute("pageNum", pageNum);
		// 시작 및 끝 번호
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		return "/food/foodmain";
	}
	
	@Override
	@RequestMapping("/cafe")
	public String cafe(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 카페 정보 갯수 불러오기
		int cafeCnt = foodService.allCafeCnt();
		
		int postNum = 12;
		
		int pageNum = (int)Math.ceil((double)cafeCnt/postNum);
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
		int endPageNum_tmp = (int)((double)cafeCnt / (double)postNum);
		
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= cafeCnt ? false : true;

		// 카페 정보 리스트로 불러오기 
		List<FoodDTO> cafeList = foodService.cafeList(start, end);
		request.setAttribute("cafeList", cafeList);
		request.setAttribute("pageNum", pageNum);
		// 시작 및 끝 번호
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		return "/food/cafe";
	}

	@Override
	@RequestMapping("/resDetail")
	public ModelAndView resDetail(@RequestParam("fd_no") int fd_no, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Boolean isLogOn = (Boolean) session.getAttribute("isLogOn");
		ModelAndView mav = null;
		
		// 먹으멍(맛집,카페) 상세정보
		FoodDTO food = foodService.selectOne(fd_no);
		// 리뷰 리스트
		List<ReviewDTO> reviewList = foodService.reviewList(fd_no);
		// 평점
		Double avg = foodService.average(fd_no);
		
		String[] category = food.getFd_category().split(",");
		String viewName = (String) request.getAttribute("viewName");
		mav = new ModelAndView(viewName);
		
		// 찜한 내역 보기
		if(isLogOn!=null && isLogOn==true) {
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			Map pickMap = new HashMap();
			pickMap.put("id", member.getId());
			pickMap.put("fd_no", fd_no);
			
			int result = foodService.checkPick(pickMap);
			
			if(result==1) {
				mav.addObject("pick", true);
			}
		} 
		mav.addObject("avg", avg);
		mav.addObject("food", food);
		mav.addObject("category",category);
		mav.addObject("reviewList",reviewList);
		
		return mav;
	}

	@Override
	@RequestMapping("/reviewForm")
	public ModelAndView reviewForm(@RequestParam("fd_no") int fd_no, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		Boolean isLogOn = (Boolean) session.getAttribute("isLogOn");
		ModelAndView mav = null;
		
		// 리뷰쓰기 클릭시 - 회원만 이용
		if(isLogOn!=null && isLogOn==true) {
			String viewName = (String) request.getAttribute("viewName");
			mav = new ModelAndView(viewName);
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
		response.setContentType("text/html;charset=utf-8");
		// 리뷰작성
		int result = foodService.addReview(review);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(result == 1) {
			out.println("alert('리뷰등록이 완료 되었습니다. 작성하신 리뷰는 [마이페이지 > 나의 리뷰보기]에서 확인하실 수 있습니다.')");
		} else {
			out.println("alert('리뷰가 등록되지 않았습니다.');");
		}
		out.println("location.href='"+ request.getContextPath() 
				+ "/food/resDetail?fd_no="+review.getFd_no()+"';");
		out.println("</script>");
	}
	
	@Override
	@RequestMapping(value="/myPick", method=RequestMethod.GET)
	public ModelAndView myPick(@RequestParam("fd_no") int fd_no, @RequestParam("pick") boolean pick,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
			response.setContentType("text/html;charset=utf-8");
			
			HttpSession session = request.getSession();
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			Boolean isLogOn = (Boolean) session.getAttribute("isLogOn");
			ModelAndView mav = null;
			
			// 찜하기 - 회원만 이용
			if(isLogOn!=null && isLogOn==true) {
				String viewName = (String) request.getAttribute("viewName");
				mav = new ModelAndView(viewName);
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인 후 이용가능합니다..');");
				out.println("location.href='" + request.getContextPath() +"/member/loginForm.do';");
				out.println("</script>");
				return null;
			}
			
			FoodDTO food = foodService.selectOne(fd_no);
			List<ReviewDTO> reviewList = foodService.reviewList(fd_no);
			
			String[] category = food.getFd_category().split(",");
			
			mav = new ModelAndView("food/resDetail");
			mav.addObject("food", food);
			mav.addObject("category",category);
			mav.addObject("reviewList",reviewList);
			
			// 찜하기 기능 
			Map pickMap = new HashMap();
			pickMap.put("id", member.getId());
			pickMap.put("fd_no", fd_no);
			if(pick) {
				foodService.myPick(pickMap);
				mav.addObject("pick",true);
			}else {
				foodService.delPick(pickMap);
				mav.addObject("pick",false);
			}
			return mav;
	}
}

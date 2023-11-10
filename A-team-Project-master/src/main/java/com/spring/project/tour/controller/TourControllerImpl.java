package com.spring.project.tour.controller;

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

import com.spring.project.tour.dto.ReviewDTO;
import com.spring.project.member.dto.MemberDTO;
import com.spring.project.tour.dto.TourDTO;
import com.spring.project.tour.service.TourService;

@Controller("tourController")
@RequestMapping("/tour")
public class TourControllerImpl implements TourController {
	@Autowired
	TourService tourService;
	
	@Override
	@RequestMapping("/main")
	public String tourmain(@RequestParam("page") int page,HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int TourCnt = tourService.allTourCnt();
		
		int postNum = 12;
		
		int pageNum = (int)Math.ceil((double)TourCnt/postNum);
		
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
		int endPageNum_tmp = (int)(Math.ceil((double)TourCnt / (double)postNum));
		 
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= TourCnt ? false : true;

		List<TourDTO> tourList = tourService.tourList(start, end);
		request.setAttribute("tourList", tourList);
		request.setAttribute("pageNum", pageNum);
		// 시작 및 끝 번호
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		return "/tour/tourmain";
	}
	
	@Override
	@RequestMapping("/orumm")
	public String orumm(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int orummCnt = tourService.allOrummCnt();
		
		int postNum = 12;
		
		int pageNum = (int)Math.ceil((double)orummCnt/postNum);
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
		int endPageNum_tmp = (int)(Math.ceil((double)orummCnt / (double)postNum));
		 
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= orummCnt ? false : true;

		List<TourDTO> orummList = tourService.orummList(start, end);
		request.setAttribute("orummList", orummList);
		request.setAttribute("pageNum", pageNum);
		// 시작 및 끝 번호
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		return "/tour/orumm";
	}
	
	@Override
	@RequestMapping("/beach")
	public String beach(@RequestParam("page") int page, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int beachCnt = tourService.allBeachCnt();
		
		int postNum = 12;
		
		int pageNum = (int)Math.ceil((double)beachCnt/postNum);
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
		int endPageNum_tmp = (int)(Math.ceil((double)beachCnt / (double)postNum));
		 
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= beachCnt ? false : true;

		List<TourDTO> beachList = tourService.beachList(start, end);
		request.setAttribute("beachList", beachList);
		request.setAttribute("pageNum", pageNum);
		// 시작 및 끝 번호
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		return "/tour/beach";
	}

	@Override
	@RequestMapping("/tourDetail")
	public ModelAndView tourDetail(@RequestParam("tr_no") int tr_no, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		

		HttpSession session = request.getSession();
		Boolean isLogOn = (Boolean) session.getAttribute("isLogOn");
		ModelAndView mav = null;
		TourDTO tour = tourService.selectOne(tr_no);
		List<ReviewDTO> reviewList = tourService.reviewList(tr_no);
		
		//평점
		Double avg = tourService.average(tr_no);
		
		String[] category = tour.getTr_category().split(",");
		
		String viewName = (String) request.getAttribute("viewName");
		mav = new ModelAndView(viewName);
		if(isLogOn!=null && isLogOn==true) {
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			Map pickMap = new HashMap();
			pickMap.put("id", member.getId());
			pickMap.put("tr_no", tr_no);
			
			int result = tourService.checkPick(pickMap);
			// http://localhost:8080/project/food/myPick?fd_no=924&pick=true
			
			if(result==1) {
				mav.addObject("pick", true);
			}
		} 
		mav.addObject("avg", avg);
		mav.addObject("tour", tour);
		mav.addObject("category", category);
		mav.addObject("reviewList", reviewList);
		
		return mav;
	}

	@Override
	@RequestMapping("/reviewForm")    
	public ModelAndView myReview(@RequestParam("tr_no") int tr_no, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		Boolean isLogOn = (Boolean) session.getAttribute("isLogOn");
		ModelAndView mav = null;
		if(isLogOn!=null && isLogOn==true) {
			String viewName = (String) request.getAttribute("viewName");
			mav = new ModelAndView(viewName);
			mav.addObject("tr_no",tr_no);
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
		
		int result = tourService.addReview(review);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(result == 1) {
			out.println("alert('리뷰등록이 완료 되었습니다. 작성하신 리뷰는 [마이페이지 > 나의 리뷰보기]에서 확인하실 수 있습니다.')");
		} else {
			out.println("alert('리뷰가 등록되지 않았습니다.');");
		}
		out.println("location.href='"+ request.getContextPath() 
				+ "/tour/tourDetail?tr_no="+review.getTr_no()+"';");
		out.println("</script>");
		
	}

	
	@Override
	@RequestMapping(value="/myPick", method=RequestMethod.GET)
	public ModelAndView myPick(@RequestParam("tr_no") int tr_no,@RequestParam("pick") boolean pick,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
			response.setContentType("text/html;charset=utf-8");
			
			HttpSession session = request.getSession();
			MemberDTO member = (MemberDTO) session.getAttribute("member");
			Boolean isLogOn = (Boolean) session.getAttribute("isLogOn");
			ModelAndView mav = null;
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
			
			TourDTO tour = tourService.selectOne(tr_no);
			List<ReviewDTO> reviewList = tourService.reviewList(tr_no);
			String[] category = tour.getTr_category().split(",");
			mav = new ModelAndView("tour/tourDetail");
			mav.addObject("tour", tour);
			mav.addObject("category",category);
			mav.addObject("reviewList",reviewList);
			
			Map pickMap = new HashMap();
			pickMap.put("id", member.getId());
			pickMap.put("tr_no", tr_no);
			
			if(pick) {
				tourService.myPick(pickMap);
				mav.addObject("pick",true);
			}else {
				tourService.delPick(pickMap);
				mav.addObject("pick",false);
			}
			return mav;
	}
}

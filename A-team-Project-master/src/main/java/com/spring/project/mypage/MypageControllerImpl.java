package com.spring.project.mypage;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mypage")
public class MypageControllerImpl implements MypageController{
	
	@Override
	@RequestMapping(value="/mypagemain", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mypagemain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
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
		return mav;
	}

	@Override
	@RequestMapping(value="/myreservation", method= {RequestMethod.GET, RequestMethod.POST})
	public String myreservation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/mypage/myreservation";
	}

	@Override
	@RequestMapping(value="/myreview", method= {RequestMethod.GET, RequestMethod.POST})
	public String myreview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/mypage/myreview";
	}

	@Override
	@RequestMapping(value="/mytravle", method= {RequestMethod.GET, RequestMethod.POST})
	public String mytravle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/mypage/mytravle";
	}
}

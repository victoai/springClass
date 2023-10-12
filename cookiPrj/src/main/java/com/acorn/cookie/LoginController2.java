package com.acorn.cookie;


import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController2 {
	
	@RequestMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	 
	

	@RequestMapping(value="/login" , method =RequestMethod.POST )
	public String login(String id, String pwd, boolean rememberId, HttpServletResponse response , HttpServletRequest request	) throws Exception {
		System.out.println("id="+id);
		System.out.println("pwd="+pwd);		
		System.out.println("rememberId="+rememberId);
		
	  
		 
		
		if(rememberId) {
		//     1. 쿠키를 생성
			Cookie cookie = new Cookie("id", id);  
//		       2. 응답에 저장
			response.addCookie(cookie);
		} else {
// 		       1. 쿠키를 삭제
			Cookie cookie = new Cookie("id", id);   
			cookie.setMaxAge(0); // 쿠키를 삭제
//		       2. 응답에 저장
			response.addCookie(cookie);
		}
//		
		
		return "redirect:/";   //3. 홈으로 이동
	}

	
	
	 
}
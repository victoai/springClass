package com.acorn.cookie.visit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitController {
	
	@GetMapping("/count")
	public String count( HttpServletRequest request ,  HttpServletResponse response) {
		
		 Cookie[] cookies= request.getCookies();
		 int count =0;
		 for( Cookie cookie : cookies) {
			    System.out.println("쿠키 이름: " + cookie.getName());
		        System.out.println("쿠키 값: " + cookie.getValue());  
			 
		        if(  cookie.getName().equals("count")) {
		        	String count_ =cookie.getValue();
		        	count=Integer.parseInt(count_);		        	 
		        	break;
		        }
		 }
		 count++;
		 Cookie cookie = new Cookie("count", String.valueOf(count));    // 10 - > "10"   숫자 10 => 문자열 10으로
    	 response.addCookie(cookie);
		 
		return "visitHome";
	}

}

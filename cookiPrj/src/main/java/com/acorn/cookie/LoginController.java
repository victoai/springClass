package com.acorn.cookie;


import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	

	@RequestMapping("/logOut")
	public String logOut( HttpServletRequest request) {		
		System.out.print( " log OUt!!!!!!!");
		HttpSession session  = request.getSession();
		session.invalidate();  // session  삭제
		return "redirect:/";
	}
	
	

	@RequestMapping(value="/login" , method =RequestMethod.POST )
	public String login(String id, String pwd, boolean rememberId, HttpServletResponse response , HttpServletRequest request	) throws Exception {
		System.out.println("id="+id);
		System.out.println("pwd="+pwd);		
		System.out.println("rememberId="+rememberId);
		
		// 1. id와 pwd를 확인
		if(!loginCheck(id, pwd)) {
			 
		    String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");	
			 //String msg =  "id 또는 pwd가 일치하지 않습니다.";		    
		     // 2-1   일치하지 않으면, loginForm으로 이동
			return "redirect:/login/login?msg="+msg;   //  param으로 msg내용을 확인할 수 있다
		}
		 
		  
		
		// 2-2. id와 pwd가 일치하면 세션에 저장하기		
		// 서버측에 하나의 사용자가 사용하는 저장공간
		System.out.println(" sessionId : =" + id);
		HttpSession session = request.getSession();
		session.setAttribute("sessionId", id);   // key, value
		
		
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

	
	
	private boolean loginCheck(String id, String pwd) {
		// 테스트로 
		// 실제로는 dao의 기능을 써서 확인해야 함
		return "acorn".equals(id) && "1234".equals(pwd);
	}
}
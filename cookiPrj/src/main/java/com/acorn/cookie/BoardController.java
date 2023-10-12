package com.acorn.cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController{
   @RequestMapping("/list")
   public String list( HttpServletRequest request) {
     if( !loginCheck(request))   //false가 오면 참이 된다 (즉 로그인이 되어 있지 않으면)
        return  "redirect:/login/login";   
     return "boardList"  ;   
  }

   //로그인이 되어 있는지 확인하는 매서드 
    private boolean loginCheck( HttpServletRequest  request ) {
      HttpSession session = request.getSession();
      boolean result = session.getAttribute("sessionId") != null;
      return  result ;   
  }
}
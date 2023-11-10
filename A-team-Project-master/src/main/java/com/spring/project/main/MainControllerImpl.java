package com.spring.project.main;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.project.member.dto.MemberDTO;


@Controller
@RequestMapping("/main")
public class MainControllerImpl implements MainController{
	@Autowired
	MailService mailService;
	
	// 메인화면
	@Override 
	@RequestMapping(value="/main.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/main/main";
	}
	
	// '제주가고싶조' 소개화면
	@RequestMapping("/introduce")
	public String introduce(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/main/introduce";
	}
	
	// 1:1문의 화면
	@RequestMapping("/support")
	public String support(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/main/support";
	}
	
	// 1:1문의 메일발송 
	@RequestMapping(value="/sendEmail", method=RequestMethod.POST)
	public void sendEmail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		
		String id = member.getId();
		String email =request.getParameter("email");
		String title =request.getParameter("title");
		String content = request.getParameter("content");
		
		mailService.sendMail(email, id+"님의 문의 내용:: "+ title, content);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('문의가 완료되었습니다.');");
		out.println("location.href='http://localhost:8080/project/main/main.do';");
		out.println("</script>");
	}
	
}




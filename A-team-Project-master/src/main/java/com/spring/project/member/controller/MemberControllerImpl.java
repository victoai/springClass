package com.spring.project.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.project.member.dto.MemberDTO;
import com.spring.project.member.service.MemberService;

@Controller("memberController")
@EnableAspectJAutoProxy
public class MemberControllerImpl extends MultiActionController implements MemberController {
	@Autowired
	private MemberService memberService;

	@Override
	@RequestMapping(value="/member/*Form.do", method=RequestMethod.GET)
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/addMember.do", method=RequestMethod.POST)
	public void addMember(@ModelAttribute("member") MemberDTO member, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		memberService.addMember(member);
		PrintWriter out = response.getWriter();
		out.println("<script>");			
		out.println("alert('회원가입이 완료되었습니다');");
		out.println("location.href='"+ request.getContextPath() +"/main/main.do';");
		out.println("</script>");	
	}
	
	@Override
	@ResponseBody
	@RequestMapping(value="/idChk")
	public int idChk(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int result = memberService.idChk(id);
		return result;
	}


	@Override
	@RequestMapping(value="/member/modMember.do", method= {RequestMethod.POST,RequestMethod.GET})
	public void modMember(@ModelAttribute("member") MemberDTO member,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		session.setAttribute("isLogOn", true);
		
		
		int result = memberService.modMember(member);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(result == 1) {
			out.println("alert('수정이 완료되었습니다');");
			out.println("location.href='"+ request.getContextPath() +"/mypage/mypagemain';");
		} else {
			out.println("alert('수정이 완료되지 못했습니다. 다시 수정하세요');");
			out.println("location.href='"+ request.getContextPath() +"/member/modMember.do?id="+member.getId()+"';");
		}
		out.println("</script>");
	}


 	@Override
	@RequestMapping(value="/member/delMember.do", method= {RequestMethod.POST,RequestMethod.GET})
	public void delMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
 		
 		request.setCharacterEncoding("utf-8");
 		response.setContentType("text/html;charset=utf-8");
 		HttpSession session = request.getSession();

		
		
		int result = memberService.delMember(id);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(result == 1) {
			out.println("alert('탈퇴가 완료되었습니다');");
			session.invalidate();
		} else {
			out.println("alert('탈퇴가 완료되지 못했습니다. 다시 진행해주세요.');");
		}
		out.println("location.href='"+ request.getContextPath() +"/main/main.do';");
		out.println("</script>");
	}

	@Override
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public void login(@ModelAttribute("member") MemberDTO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		MemberDTO memberDTO = memberService.login(member);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(memberDTO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberDTO);
			session.setAttribute("isLogOn", true);
			session.setAttribute("kakao", false);
			out.println("alert('"+memberDTO.getId()+"님 로그인 되었습니다');");
			out.println("location.href='"+request.getContextPath() +"/main/main.do';"); 
		} else {
			out.println("alert('아이디나 비밀번호가 틀립니다. 다시 로그인 하세요!.');");
			out.println("location.href='"+request.getContextPath() +"/member/loginForm.do';");
		}
		out.println("</script>");
	}
			
	@Override
	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse resposne) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
//		session.removeAttribute("member");
//		session.removeAttribute("isLogOn");
		
		session.invalidate();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/loginForm.do");
		return mav;
	}

	@RequestMapping(value="/member/memberDetail" , method=RequestMethod.GET)
	public String memberDetail(HttpServletRequest request, HttpServletResponse resposne) throws Exception {
		return "/member/memberDetail";
	}
	
	@Override
	@RequestMapping(value="/member/findId.do", method=RequestMethod.POST)
	public void findId(@ModelAttribute("member") MemberDTO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String findId = memberService.findId(member);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(findId != null) {
			out.println("alert('찾으시는 아이디는 "+findId+" 입니다.');");
			out.println("location.href='"+request.getContextPath() +"/member/findIdForm.do';"); 
		} else {
			out.println("alert('입력하신 정보와 일치한 아이디가 없습니다.');");
			out.println("location.href='"+request.getContextPath() +"/member/findIdForm.do';");
		}
		out.println("</script>");
	}
	
	@Override
	@RequestMapping(value="/member/findPwd.do", method=RequestMethod.POST)
	public void findPwd(@ModelAttribute("member") MemberDTO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String findPwd = memberService.findPwd(member);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(findPwd != null) {
			out.println("alert('찾으시는 아이디의 비밀번호는 "+findPwd+" 입니다.');");
			out.println("location.href='"+request.getContextPath() +"/member/findPwdForm.do';"); 
		} else {
			out.println("alert('입력하신 정보가 일치하지 않습니다.');");
			out.println("location.href='"+request.getContextPath() +"/member/findPwdForm.do';");
		}
		out.println("</script>");
	}




}




















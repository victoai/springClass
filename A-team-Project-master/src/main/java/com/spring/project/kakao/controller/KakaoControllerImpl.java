package com.spring.project.kakao.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.spring.project.kakao.service.KakaoService;
import com.spring.project.member.dto.MemberDTO;

@Controller("kakaoController")
@EnableAspectJAutoProxy
public class KakaoControllerImpl implements KakaoController {

	@Autowired
	private KakaoService kakaoService;
	
	@Override
	@RequestMapping(value="/kakao/kakaoLogout.do", method=RequestMethod.GET)
	public ModelAndView kakaoLogout(HttpServletRequest request, HttpServletResponse resposne) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/main/main.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/kakao/kakaoLogin.do", method= {RequestMethod.POST,RequestMethod.GET})
	public void kakaoLogin(@RequestParam(value="code", required = false) String code, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("인가코드를 받아왔으면 인가코드는" + code);
		
		String access_Token = getAccessToken(code);
		MemberDTO userInfo = getUserInfo(access_Token);
		System.out.println("userInfo = getUserInfo 진입!" + userInfo);
		
		System.out.println("###access_Token#### : " + access_Token);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(userInfo != null) {
			System.out.println("if문 진입@@");
			HttpSession session = request.getSession();
			session.setAttribute("member", userInfo);
			session.setAttribute("isLogOn", true);
			session.setAttribute("kakao", true);
			System.out.println(session.getAttribute("kakao"));
			out.println("alert('"+userInfo.getId()+"님 로그인 되었습니다');");
			out.println("location.href='"+request.getContextPath() +"/main/main.do';"); 
		} else {
			out.println("alert('아이디나 비밀번호가 틀립니다. 다시 로그인 하세요!.');");
			out.println("location.href='"+request.getContextPath() +"/member/loginForm.do';");
		}
		out.println("</script>");

	}
	
	@Override
	public String getAccessToken(String authorize_code) {
		// TODO Auto-generated method stub
		String access_Token = "";
		String refresh_Token = "";
		System.out.println("reqURL 잘되는지 검사하기전");
		String reqURL = "https://kauth.kakao.com/oauth/token";
		System.out.println("reqURL 잘되는지 검사 후");
		
		try {
			URL url = new URL(reqURL);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			// POST 요청을 위해 기본 값이 false인 setDoOutput을 true로 변경
			
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			// POST  요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			// BufferedWriter 간단하게 파일을 끊어서 보내기로 토근값을 받아오기 위해 전송
			
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=7c06fcfbfeffe9bdd6963f11f30aaf2d");
			sb.append("&redirect_uri=http://localhost:8080/project/kakao/kakaoLogin.do");
			sb.append("&code=" + authorize_code);
			bw.write(sb.toString());
			bw.flush();
			
			// 결과 코드가 200이라면 성공
			// 여기서 안되는 경우가 많으니 필수 확인
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode + "확인");
			
			// 요청을 통해 얻은 JSON 타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";
			
			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result + "결과");
			
			// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			
			access_Token = element.getAsJsonObject().get("access_token").getAsString();
			refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
			
			System.out.println("access_token : " + access_Token);
			System.out.println("refresh_token : " + refresh_Token);
			
			br.close();
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return access_Token;
	}

	@Override
	public MemberDTO getUserInfo(String access_Token) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		
		String requestURL = "https://kapi.kakao.com/v2/user/me";
		
		try {
			URL url = new URL(requestURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Authorization", "Bearer " + access_Token);
			
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode + "여긴가");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = "";
			String result = "";
			while ((line = buffer.readLine()) != null) {
				result += line;
			}
			
			System.out.println("response body : " + result);
			
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
			JsonObject profile = kakao_account.getAsJsonObject().get("profile").getAsJsonObject();
			
			String id = kakao_account.getAsJsonObject().get("email").getAsString();
			String name = profile.getAsJsonObject().get("nickname").getAsString();
			String gender = kakao_account.getAsJsonObject().get("gender").getAsString();
			String email = kakao_account.getAsJsonObject().get("email").getAsString();
			userInfo.put("id", id);
			userInfo.put("name", name);
			userInfo.put("gender", gender);
			userInfo.put("email", email);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		MemberDTO result = kakaoService.findKakao(userInfo);
		
		System.out.println("S : " + result);
		if(result == null) {
			kakaoService.kakaoInsert(userInfo);
			return kakaoService.findKakao(userInfo);
		} else {
			return result;
		}
	}
}

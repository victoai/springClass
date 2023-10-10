package com.acorn.day3.서버응답;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class 데이터응답 {

	@GetMapping("/test1")
	public void test1(HttpServletResponse response) throws IOException {
		String message = "서버가 보낸 데이터 message";
		response.setContentType("text/plain;charset=utf-8");
		response.setHeader("Content-Length", String.valueOf(message.getBytes().length));
		response.getWriter().println(message);

	}

	@GetMapping("/test2")
	public ResponseEntity<String> test2() {
		String message = "서버가 보내는 message !!!!";
		return ResponseEntity.ok().header("Content-Type", "text/plain;charset=utf-8")
				.header("Content-Length", String.valueOf(message.getBytes().length)).body(message);
	}
	
	
	@ResponseBody
	@RequestMapping( value="/test3"  , produces = "text/plain;charset=UTF-8" )
	public String test3() {
		String message = "서버가 보내는 message !!!!";
		return message;
		 
	}
	
	

}
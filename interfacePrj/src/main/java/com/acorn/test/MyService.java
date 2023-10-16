package com.acorn.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class   MyService  {
	 
	
	@Autowired
	 GoogleApi  api; 
	 

 
	public double[] 위도경도가지오기() {		  
		double[] result  = api.위도경도구하기();
		return result;
	}
	

	 
	public int registerMember( Member member) {	  
		double[] result  = 위도경도가지오기();		
		System.out.println( result[0] + " : " + result[1]);		 
		member.setLatitude( result[0]);
		member.setLongitude( result[1]);
		//회원등록 로직
		return 1;
	}

}

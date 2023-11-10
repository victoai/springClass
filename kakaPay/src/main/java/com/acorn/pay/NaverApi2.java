package com.acorn.pay;

 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

 
public class NaverApi2 {
 
    public static void main(String[] args) {
       
        
        //요청 URL
         String apiURL = "https://kapi.kakao.com/v1/payment/ready?"     // JSON 결과
         		+  "cid=TC0ONETIME" // 가맹점 코드
				+ "&partner_order_id=partner_order_id" // 가맹점 주문번호
				+ "&partner_user_id=partner_user_id" // 가맹점 회원 id
				+ "&item_name=초코파이" // 상품명
				+ "&quantity=1" // 상품 수량
				+ "&total_amount=5000" // 총 금액
				+ "&vat_amount=200" // 부가세
				+ "&tax_free_amount=0" // 상품 비과세 금액
				+ "&approval_url=http://localhost:8090/pay/kakaoPaySuccess" // 결제 성공 시
				+ "&fail_url=http://localhost:8090/pay" // 결제 실패 시
				+ "&cancel_url=http://localhost:8090/pay"; // 결제 취소 시

 
        HttpURLConnection  con; //  네이버서버에 api요청시 사용
        StringBuilder body ;    // 문자열연결시 사용
        
        try {
            URL url = new URL(apiURL);
            con= (HttpURLConnection)url.openConnection();            
            con.setRequestProperty("Authorization" , "KakaoAK 5f91f4c01cf24278d02a076fd7ddd21f");
            con.setRequestProperty("Content-type" , "application/x-www-form-urlencoded;charset=utf-8");             
            con.setRequestMethod("POST");  
            
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
            	 InputStreamReader streamReader = new InputStreamReader(con.getInputStream());
                 try (BufferedReader lineReader = new BufferedReader(streamReader)) {
                    body = new StringBuilder();
                     String line;
                     while ((line = lineReader.readLine()) != null) {
                         body.append(line);
                     }                      
                 } catch (IOException e) {
                     throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
                 }
             
            } else { // 오류 발생
            	
           	 InputStreamReader streamReader = new InputStreamReader(con.getInputStream());
             try (BufferedReader lineReader = new BufferedReader(streamReader)) {
                  body = new StringBuilder();
                 String line;
                 while ((line = lineReader.readLine()) != null) {
                     body.append(line);
                 }                  
             } catch (IOException e) {
                 throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
             }                
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiURL, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiURL, e);
        }  
        
        System.out.println( body.toString());
    } 
 
    
}

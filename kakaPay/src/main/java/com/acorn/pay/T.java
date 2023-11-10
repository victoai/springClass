package com.acorn.pay;

import java.io.BufferedReader;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.java.Log;
@Log
@Controller
class T{
	
	String tid;
	@GetMapping("kakaopay")
	@ResponseBody
	public String kakaopay() {
		try {
			// 보내는 부분
			
			
			URL address = new URL("https://kapi.kakao.com/v1/payment/ready");
			HttpURLConnection connection = (HttpURLConnection) address.openConnection(); // 서버연결
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Authorization", "KakaoAK 5f91f4c01cf24278d02a076fd7ddd21f"); // 어드민 키
			connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			connection.setDoOutput(true);  
			String parameter = "cid=TC0ONETIME" // 가맹점 코드
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

			OutputStream send = connection.getOutputStream(); 
			DataOutputStream dataSend = new DataOutputStream(send);  
			dataSend.writeBytes(parameter);  
			dataSend.close(); //  
			
			int result = connection.getResponseCode(); 
			InputStream receive; // 받다
			
			if(result == 200) {
				receive = connection.getInputStream();
			}else {
				receive = connection.getErrorStream(); 
			}
			// 읽는 부분
			InputStreamReader read = new InputStreamReader(receive); // 받은걸 읽는다.
			BufferedReader change = new BufferedReader(read); // 바이트를 읽기 위해 형변환 버퍼리더는 실제로 형변환을 위해 존제하는 클레스는 아니다.
			// 받는 부분
			String a =  change.readLine(); //  
			System.out.println( a);			
			
			/**
			 * 
			<dependency>
				<groupId>org.json</groupId>
				<artifactId>json</artifactId>
				<version>20180130</version>
			</dependency>	
			
			 */
			
			// String -> JSON
			
			JSONObject obj = new JSONObject( a);
			System.out.print("tid " +  obj.getString("tid"));
			this.tid = obj.getString("tid"); 			
			return a;
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	 
	 
	    @ResponseBody
	    @GetMapping("/kakaoPaySuccess")
	  public String String(   String pg_token   ) {
		    try {
		        // 보내는 부분
		        URL address = new URL("https://kapi.kakao.com/v1/payment/approve");
		        HttpURLConnection connection = (HttpURLConnection) address.openConnection();
		        connection.setRequestMethod("POST");
		        connection.setRequestProperty("Authorization", "KakaoAK 6269aa4d1550235e3d6bc1d57d6fd461");
		        connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		        connection.setDoOutput(true);

		        
		    	//+ "&partner_order_id=partner_order_id" // 가맹점 주문번호
				//+ "&partner_user_id=partner_user_id" // 가맹점 회원 id
		        
		        String parameter = "cid=TC0ONETIME" 
		            + "&partner_order_id=partner_order_id" 
		            + "&partner_user_id=partner_user_id" 
		            + "&total_amount=5000" 
		            + "&tid="+tid
		        	+ "&pg_token="+pg_token;

		        OutputStream send = connection.getOutputStream();
		        DataOutputStream dataSend = new DataOutputStream(send);
		        dataSend.writeBytes(parameter);
		        dataSend.close();

		        int result = connection.getResponseCode();
		        InputStream receive;

		        if (result == 200) {
		            receive = connection.getInputStream();
		        } else {
		            receive = connection.getErrorStream();
		        }

		        // 읽는 부분
		        InputStreamReader read = new InputStreamReader(receive);
		        BufferedReader change = new BufferedReader(read);

		        // 받는 부분
		        String response = change.readLine();
		        change.close();
		        return response;

		    } catch (MalformedURLException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    return "";
		}


}
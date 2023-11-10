package com.acorn.kaka;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestMain {

	public static void main(String[] args) {
		  try {
	            // 카카오페이 API 엔드포인트 및 키
	            String apiUrl = "https://kapi.kakao.com/v1/payment/ready";
	            String apiKey = "bee1249e75215568ce7bcec76552cca0";
	            	 

	            // 결제 요청 생성
	            String requestPayload = "cid=TC0ONETIME&partner_order_id=ORDER_ID&partner_user_id=USER_ID&item_name=상품명&quantity=1&total_amount=10000&tax_free_amount=0&approval_url=https://example.com/success&cancel_url=https://example.com/cancel&fail_url=https://example.com/fail";

	            URL url = new URL(apiUrl);
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	            connection.setRequestMethod("POST");
	            connection.setRequestProperty("Authorization", "KakaoAK " + apiKey);
	            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	            connection.setDoOutput(true);

	            DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
	            dataOutputStream.writeBytes(requestPayload);
	            dataOutputStream.flush();
	            dataOutputStream.close();

	            int responseCode = connection.getResponseCode();
	            if (responseCode == 200) {
	                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	                String inputLine;
	                StringBuffer response = new StringBuffer();

	                while ((inputLine = in.readLine()) != null) {
	                    response.append(inputLine);
	                }

	                in.close();
	                System.out.println(response.toString());
	            } else {
	                System.out.println("HTTP Request failed with error code: " + responseCode);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	}

}

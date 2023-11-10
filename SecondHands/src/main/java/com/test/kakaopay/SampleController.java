package com.test.kakaopay;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.login.domain.LoginDTO;
import com.sh.order.domain.OrderDTO;
import com.sh.order.service.OrderServiceI;

import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Controller
public class SampleController {

    @Setter(onMethod_ = @Autowired)
    private KakaoPayService kakaopay;

    @Autowired
    OrderServiceI service;

    @GetMapping("/kakaoPay")
    public String kakaoPayGet() {
        return "kakaoPay"; // 경로에 맞게 설정 (kakaoPay.jsp 파일이 있어야 함)
    }

    @PostMapping("/kakaoPay")
    public String kakaoPay(HttpSession session, @RequestParam("orderId") String orderId, Model model) {
    	
    	
    	
    	System.out.println(orderId  );
    	
        log.info("kakaoPay post............................................");
        LoginDTO loggedInUser = (LoginDTO) session.getAttribute("user");

        // OrderServiceI를 통해 특정 주문 정보를 가져옴
        List<OrderDTO> orderDTOList = service.getOrdersByUserCode(orderId);

        if (orderDTOList != null && !orderDTOList.isEmpty()) {
            for (OrderDTO orderDTO : orderDTOList) {
                if (orderDTO.getUser_id().equals(loggedInUser.getUser_id())) {
                    // 주문이 존재하고 해당 주문이 현재 로그인한 사용자의 것이면 KakaoPayService의 kakaoPayReady 메서드 호출
                    model.addAttribute("user", loggedInUser);
                    model.addAttribute("orderDTO", orderDTO);
                    return "redirect:" + kakaopay.kakaoPayReady(orderDTO);
                }
            }
        }
        

        // 주문이 없거나 주문이 현재 사용자의 것이 아닌 경우에 대한 처리
        log.info("Order not found or unauthorized access. OrderId: " + orderId);
        // 처리 방법에 따라 적절한 응답 반환
        return "redirect:/errorPage"; // 예시: 오류 페이지로 리다이렉트
    }

    @GetMapping("/kakaoPaySuccess")
    public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
        log.info("kakaoPaySuccess get............................................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);
        model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token));
        return "kakaoPaySuccess"; // 경로에 맞게 설정 (kakaoPaySuccess.jsp 파일이 있어야 함)
    }

    @GetMapping("/kakaoPayCancel")
    public String kakaoPayCancel(Model model) {
        // 여기에 취소 시 동작하는 코드를 추가하세요.
        model.addAttribute("message", "Payment was canceled.");
        return "kakaoPayCancel"; // 경로에 맞게 설정 (kakaoPayCancel.jsp 파일이 있어야 함)
    }

    @GetMapping("/kakaoPaySuccessFail")
    public String kakaoPaySuccessFail(Model model) {
        // 여기에 실패 시 동작하는 코드를 추가하세요.
        model.addAttribute("message", "Payment failed.");
        return "kakaoPaySuccessFail"; // 경로에 맞게 설정 (kakaoPaySuccessFail.jsp 파일이 있어야 함)
    }
}
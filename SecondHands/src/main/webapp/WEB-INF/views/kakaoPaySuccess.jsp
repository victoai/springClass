<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ page import="com.sh.login.domain.LoginDTO"%>
          <%@ page import="com.sh.product.domain.ProductDTO"%>
          <%@ page import="java.util.*"%>
          
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>KakaoPay Success</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>

<h1>카카오페이 결제 성공</h1>
<p>결제가 정상적으로 완료되었습니다.</p>
<p>결제일시: ${info.approved_at}</p>
<p>주문번호: ${info.partner_order_id}</p>
<p>상품명: ${info.item_name}</p>
<p>상품수량: ${info.quantity}</p>
<p>결제금액: ${info.amount.total}</p>
<p>결제방법: ${info.payment_method_type}</p>

</body>
</html>
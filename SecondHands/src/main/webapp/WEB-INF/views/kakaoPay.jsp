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
    <title>KakaoPay Test</title>
</head>
<body>

<h1>카카오페이로 결제하기</h1>
<form method="post" action="/testing/pay">
    <input type="hidden" name="orderId" value="${orderDTO.order_id}">
    <button>카카오페이로 결제하기</button>
</form>

</body>
</html>
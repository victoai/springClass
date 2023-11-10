<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"   isELIgnored="false"
   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약확인</title>
<style>
form {
   display: inline;
}
.button {
	font-family: 'Hanna', serif;
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 18px 40px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	transition-duration: 0.4s;
	cursor: pointer;
}
.button1 {
	background-color: white;
	color: black;
	border: 2px solid #f44336;
}

.button1:hover {
	background-color: #f44336;
	color: white;
}
img {
	margin: -13px 2px;
}
#btn_res {
	margin-left:41%;
	
}
</style>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
</head>
<body>
	<h1 style="text-align:center;">내 예약확인</h1>
	<div id="btn_res">
		<img src="${path }/resources/image/airplane.png" width="40">
		<button class="button button1" type="button" onClick="location.href='${path }/myreservation/airreservation'">항공예약보기</button>
	</div>
	<div id="btn_res">	
		<img src="${path }/resources/image/hotel.png" width="40">
		<button class="button button1" type="button" onClick="location.href='${path }/mylodreservation/lodreservation'">숙소예약보기</button>
	</div>
	<br><br>
</body>
</html>
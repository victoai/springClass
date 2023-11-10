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
<title>마이페이지</title>
<style>
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
	border: 2px solid #4CAF50;
}

.button1:hover {
	background-color: #4CAF50;
	color: white;
}

.button2 {
	background-color: white;
	color: black;
	border: 2px solid #008CBA;
}

.button2:hover {
	background-color: #008CBA;
	color: white;
}

.button3 {
	background-color: white;
	color: black;
	border: 2px solid #f44336;
}

.button3:hover {
	background-color: #f44336;
	color: white;
}

.button4 {
	background-color: white;
	color: black;
	border: 2px solid orange;
}

.button4:hover {
	background-color: orange;
}

</style>
</head>
<body>
	<h1 style="text-align:center;">마이페이지</h1>
	<div id="btn_group1" align="center">
		<c:if test="${kakao == true }">
			<button class="button button1" type="button" onClick="alert('카카오 계정은 정보를 수정할 수 없습니다.');">내 정보수정</button>
		</c:if>
		<c:if test="${kakao != true }">
			<button class="button button1" type="button" onClick="location.href='${path }/member/memberDetail'">내 정보수정</button>
		</c:if>
		<button class="button button2" type="button" onClick="location.href='${path }/myreview/review'">내가 쓴리뷰</button>
	</div>
	<div id="btn_group2" align="center">
		<button class="button button3" type="button" onClick="location.href='${path }/myreservation/reservation'">내 예약확인</button>
		<button class="button button4" type="button" onClick="location.href='${path }/travle/mytravle'">내 여행일정</button>
	</div>
	<br><br>
</body>
</html>
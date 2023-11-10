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
<meta charset="EUC-KR">
<title>항공 예약보기</title>
<style>
form {
   display: inline;
}

#airmyres {
  border-spacing: 0px;
  border-style: none;
  padding: 0px;
  border-collapse:collapse;
  border-radius:25px;
  width: 80%;
  margin-left:auto;
  margin-right:auto;
}
#airmyres tr{
  border: 1px solid #ddd;
}
#airmyres td {
  padding: 10px;
  width:100px;
  text-align:center;
}

#airmyres th {
  font-weight: lighter;
  padding: 8px;
  padding-bottom: 12px;
  text-align: left;
  background-color:#B8E6E1;
  color: black;

#airmyres tr:nth-child(even){background-color:white;}

#airmyres tr:hover {background-color: #ddd;}

h1 {
	text-align:center;
}
</style>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
</head>
<body>
		<div id="airreservation" align="center">
			<h1>내 항공 예약보기</h1>
		</div>
		<table id="airmyres">
		<c:forEach var="mypage" items="${mypage }" varStatus="status">
			<tr>
				<th colspan="4"><c:choose>
						<c:when test="${(status.count%2)==1}">
						&nbsp;&nbsp;&nbsp;&nbsp;가는 편 일정 [${mypage.air_departPlace } → ${mypage.air_arrivalPlace }]
						</c:when>
						<c:when test="${(status.count%2)==0}">
						&nbsp;&nbsp;&nbsp;&nbsp;오는 편 일정 [${mypage.air_departPlace } → ${mypage.air_arrivalPlace }]
						</c:when>
					</c:choose>
				</th>
				<th style="text-align:right;">${mypage.air_date}</th>
			</tr>
			<tr>
				<td><pre>항공사</pre>${mypage.air_airline }</td>
				<td><pre>출발시간</pre>${mypage.air_departTime }</td>
				<td>〓〓〓〓〓〓▶</td>
				<td><pre>도착시간</pre>${mypage.air_arrivalTime}</td>
				<td><pre>항공가</pre>${mypage.air_price }</td>
			</tr>
	</c:forEach>
		</table>
		<br><br>
</body>
</html>
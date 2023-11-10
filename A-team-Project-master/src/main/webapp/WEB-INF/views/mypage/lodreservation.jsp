<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"   isELIgnored="false"
   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>숙소 예약보기</title>
<style>
form {
   display: inline;
}
table {
	text-align:center;
    border-spacing: 0px;
    border-style: none;
    padding: 0px;}
#lodmyres {
  border-collapse:collapse;
  border-radius:25px;
  width: 90%;
  margin-left:auto;
  margin-right:auto;
}
#lodmyres tr{
  border: 1px solid #ddd;
}
#lodmyres td {
  padding: 10px;
}

#lodmyres th {
  font-weight: lighter;
  padding: 8px;
  padding-bottom: 12px;
  background-color:#B8E6E1;
  color: black;

#airmyres tr:nth-child(even){background-color:white;}

#lodmyres tr:hover {background-color: #ddd;}
</style>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
</head>
<body>
		<div id="lodreservation" align="center">
			<h1>내 숙소 예약보기</h1>
		</div>
		<table id="lodmyres">
			<c:forEach var="mypage" items="${mypage }">
			<tr>
				<th>아이디</th>
				<th>예약자명</th>
				<th>전화번호</th>
				<th>숙소이름</th>
				<th>객실이름</th>
				<th>체크인</th>
				<th>체크인 시간</th>
				<th>체크아웃</th>
				<th>체크아웃 시간</th>
			</tr>
			<tr>
				<td width="50px">${mypage.id}</td>
				<td width="50px">${mypage.res_name}</td>
				<td width="100px">${mypage.res_tel}</td>
				<td width="150px"><a href="${path }/event/lodInfo?lod_id=${mypage.lod_id}&resultDay=1">${mypage.lod_title}</a></td>
				<td width="150px">${mypage.r_title}</td>
				<td width="80px">${mypage.res_from}</td>
				<td width="80px">${mypage.lod_checkIn}</td>
				<td width="80px">${mypage.res_to}</td>
				<td width="80px">${mypage.lod_checkOut}</td>
			</tr>
			</c:forEach>
		</table>
		<br><br>
</body>
</html>
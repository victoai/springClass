<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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
<title>이벤트 항공 상세페이지</title>
<script>
	// 로그인 확인
	function airRes(){
		let id = '${member.id}';
		if(id == null || id == ""){
			alert('로그인 후 이용 가능합니다.');
			location.href='${path}/member/loginForm.do';
		} else {
			let airFrm = document.airFrm;
			
			airFrm.method="GET";
			airFrm.action="${path}/event/checkReserv"
			airFrm.submit();
		}
		
	}
</script>
<style>
form {
	display: inline;
	border:1px;
}
th {
	background-color:#B8E6E1;
	width:100px;
	text-align:center;
}
td {
	width:100px;
	text-align:center;
	font-weight:lighter; 
}
h1 {
	text-align:center;
}

</style>
</head>
<body>
	<form name="event1" action="/project/event/main">
		<input class="category" type='submit' value='항공' />
	</form>
	<form name="event2" action="/project/event/lodmain">
		<input class="category" type='submit' value='숙박' />
	</form>
	<br>
	<br>
	<!-- 가는 편 오는 편 선택 -->
	<form name="airFrm">
	<h1>가는 편 선택</h1>
	<table align="center" border="1">
		<tr>
			<th align="center">번호</th>
			<th align="center">항공사</th>
			<th align="center">출발일자</th>
			<th align="center">출발장소</th>
			<th align="center">출발시간</th>
			<th align="center">도착장소</th>
			<th align="center">도착시간</th>
			<th align="center">금액</th>
			<th align="center">선택하기</th>
		</tr>
		<c:forEach var="airplane" items="${airplaneList }">
		<tr>
			<td>${airplane.air_no }</td>
			<td>${airplane.air_airline }</td>
			<td>${airplane.air_date }</td>
			<td>${airplane.air_departPlace }</td>
			<td>${airplane.air_departTime }</td>
			<td>${airplane.air_arrivalPlace }</td>
			<td>${airplane.air_arrivalTime }</td>
			<td>${airplane.air_price }</td>
			<!-- <td><a href="${path }/event/air_resv?air_no=${airplane.air_no}">선택</a></td> -->
			<td><input type="radio"  name="air_no_from" value="${airplane.air_no }"></td>
		</tr>
		</c:forEach>
	</table>
	<h1>오는 편 선택</h1>
		<table align="center" border="1">
		<tr>
			<th align="center">번호</th>
			<th align="center">항공사</th>
			<th align="center">출발일자</th>
			<th align="center">출발장소</th>
			<th align="center">출발시간</th>
			<th align="center">도착장소</th>
			<th align="center">도착시간</th>
			<th align="center">금액</th>
			<th align="center">선택하기</th>
		</tr>
		<c:forEach var="airplane2" items="${airplaneList2 }">
		<tr>
			<td>${airplane2.air_no }</td>
			<td>${airplane2.air_airline }</td>
			<td>${airplane2.air_date }</td>
			<td>${airplane2.air_departPlace }</td>
			<td>${airplane2.air_departTime }</td>
			<td>${airplane2.air_arrivalPlace }</td>
			<td>${airplane2.air_arrivalTime }</td>
			<td>${airplane2.air_price }</td>
			<!-- <td><a href="${path }/event/air_resv?air_no=${airplane.air_no}">선택</a></td> -->
			<td><input type="radio" name="air_no_to" value="${airplane2.air_no }"></td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<div align="center">
	<input type="button" onclick="airRes()" value="선택완료">
	<input type="reset" value="다시선택">
	</div>
	</form>
	<br><br><br>
</body>
</html>
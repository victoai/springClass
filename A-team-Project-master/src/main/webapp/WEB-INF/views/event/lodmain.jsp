<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>이벤트 숙박페이지</title>
<style>
form {
	display: inline;
}

#Search td{
	text-align:center;
	padding: 10px;
	font-size: 24px;
}
</style>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>  
	// 체크인, 체크아웃 날짜 선택 페이지
  $( function() {
	    $( "#checkIn" ).datepicker({
	      dateFormat: 'yy-mm-dd',
	      showOtherMonths: true,
	      selectOtherMonths: true
	    });
	  } );
  
  $( function() {
	    $( "#checkOut" ).datepicker({
	      dateFormat: 'yy-mm-dd',
	      showOtherMonths: true,
	      selectOtherMonths: true
	    });
	  } );
  
  </script>
</head>
<body>
	<form name="event1" action="/project/event/main">
		<input class="category" type='submit' value='항공' />
	</form>
	<form name="event2" action="/project/event/lodmain">
		<input class="category" type='submit' value='숙박' />
	</form>
	<br>
	<!-- 체크인 날짜 체크아웃 날짜 선택 페이지 -->
	<div id="Search" align="center">
	<h1>일정선택</h1>
	<form name="selectDate" action="${path }/event/lodDetail">
	<input type="hidden" name="page" value="1">
	<input type="hidden" name="lodDate" value="true">
	<table>
		<tr>
			<td>체크인</td>
			<td><input type="text" id="checkIn" name="checkIn"></td>
		</tr>
		<tr>
			<td>체크아웃</td>
			<td><input type="text" id="checkOut" name="checkOut"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="선택완료">
				<input type="reset" value="다시선택">
			</td>
		</tr>
	</table>
	</form>
	</div>
	<br>
</body>
</html>
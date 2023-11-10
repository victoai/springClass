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
<html lang="en">
<head>
<title>검색페이지</title>
<meta charset="utf-8">
<style>
	table{
		width: 70%;
	}
	b {
		color: orange;
		font-size: 20px;
	}
	.img {
		width:100px;
		height: 80px;
		object-fit : fill;
	}
</style>
</head>
<body>
<b>'먹으멍'</b>의 검색결과
<hr width="100%">
	<table align="center">
		<c:forEach var="food" items="${foodSearch }">
			<tr>
				<td rowspan="2"><a href="${path }/food/resDetail?fd_no=${food.fd_no}">
				<img class="img" src="${food.fd_imgPath }"></a></td>
				<td><span style="font-size: 20px;">${food.fd_title }</span></td>
			</tr>
			<tr>
				<td><span style="color:gray;">${food.fd_info }</span></td>
			</tr>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
		</c:forEach>
	</table>
	<b>'보멍'</b>의 검색결과
	<hr>
	<table align="center">
		<c:forEach var="tour" items="${tourSearch }">
			<tr>
				<td rowspan="2"><a href="${path }/tour/tourDetail?tr_no=${tour.tr_no}">
				<img class="img"  src="${tour.tr_imgPath }"></a></td>
				<td><span style="font-size: 20px;">${tour.tr_title }</span></td>
			</tr>
			<tr>
				<td><span style="color:gray;">${tour.tr_info }</span></td>
			</tr>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
		</c:forEach>
	</table>
	<b>'즐기멍'</b>의 검색결과
	<hr>
	<table align="center">
		<c:forEach var="act" items="${activitySearch }">
			<tr>
				<td rowspan="2"><a href="${path }/activity/activityDetail?ac_no=${act.ac_no}">
				<img class="img"  src="${act.ac_imgPath }"></a></td>
				<td><span style="font-size: 20px;">${act.ac_title }</span></td>
			</tr>
			<tr>
				<td><span style="color:gray;">${act.ac_info }</span></td>
			</tr>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
		</c:forEach>
	</table>
	<b>'숙박'</b>의 검색결과
	<hr>
	<table align="center">
		<c:forEach var="lod" items="${lodgingSearch }">
			<tr>
				<td rowspan="2"><a href="${path }/event/lodInfo?lod_id=${lod.lod_id}&resultDay=0">
				<img class="img"  src="${lod.lod_imgPath }"
				onerror="this.src='${path }/resources/image/empty_img.png'"></a></td>
				<td><span style="font-size: 20px;">${lod.lod_title }</span></td>
			</tr>
			<tr>
				<td><span style="color:gray;">${lod.lod_info }</span></td>
			</tr>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
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
<title>main</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.img_content {
	margin: auto 0;
	padding: 500px 300px 100px 100px;
	background-repeat: no-repeat;
	background-size: cover;
	color: white;
	font-size: 24px;
}
span {
	color: orange;
}

.point {
	font-size: 34px;
	font-style: italic;
}
</style>
</head>
<body>
		<h1 style="padding:5px;">About <span>'제주가고싶조'</span></h1>
	<hr color="lightblue">
	<div>
		<p class="img_content"style="background-image:url('/project/resources/image/traveler.jpg');">
		<span class="point">'제주가고싶조'</span>는 제주도를 여행하고자 하는<br>
		여행자들에게 맛집, 관광지, 액티비티 등<br>
		제주도와 관련된 정보를 제공함으로써 편리하게<br>
		여행을 할 수 있도록 돕고자 만들어 졌습니다.</p>
	</div>
	<div>
		<p class="img_content" style="background-image:url('/project/resources/image/schedule.jpg');color:black;">
		<span class="point">여행 일정짜기 어려울땐?</span><br>
		육지사람부터 제주도민까지<br>
		모두가 좋아할만한 코스들로 준비했으니<br>
		찜하기를 하여 내 일정짜기에 추가할 수 있어요<br>
		여행자들에게 맛집, 관광지, 액티비티 등<br>
		제주도와 관련된 정보를 제공함으로써 편리하게<br>
		여행을 할 수 있도록 돕고자 만들어 졌습니다.</p>
	</div>
	<div>
		<p class="img_content" style="background-image:url('/project/resources/image/oreum.jpg');">
		<span class="point">제주여행을 최저가로?</span><br>
		'제주가고싶조' 회원이라면<br>
		제주도 항공권과 숙박업체를 온라인 단독<br>
		최저가로 만나실 수 있어요.<br>
		오직 제주가고싶조에서!</p>
	</div>
</body>
</html>

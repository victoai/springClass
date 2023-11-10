<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맛집 상세페이지</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=LIBRARY"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer,drawing"></script>
<script>
	function myPick() {
		let heart = document.getElementById("heart");
		let imgName = heart.getAttribute("src");
		if (imgName == "${path }/resources/image/empty_heart.jpg") {
			if (confirm('찜 하시겠습니까?')) {
				location.href = '${path}/food/myPick?fd_no=${food.fd_no}&pick=true';
			}
		} else {
			location.href = '${path}/food/myPick?fd_no=${food.fd_no}&pick=false';
		}
	}
</script>
<style>
form {
	display: inline;
}

#myMenu {
	width: 100%;
	bottom: 0%;
	padding: 5px;
}

li button {
	border: 0;
	background: transparent;
	color: black;
}

#myMenuList {
	margin: 0px;
}

#myMenuList li {
	list-style-type: none;
	float: right;
	padding-right: 20px;
}

.myPick:hover, .myReview:hover {
	color: black;
}
h3 {
	color:orange;
}
</style>
</head>
<body>
<!-- 카테고리 -->
	<form name="food1" action="/project/food/main">
		<input type="hidden" name="page" value="1">
        <input class="category" type='submit' value='맛집'/>
    </form>
	<form name="food2" action="/project/food/cafe">
		<input type="hidden" name="page" value="1">
        <input class="category" type='submit' value='카페'/>
    </form>
    <br><br><br>
<!-- 먹으멍 상세정보 테이블 -->
	<table align="center">
		<tr>
			<td colspan="2" align="center"><img src="${food.fd_imgPath }"
				width="700" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><h2>${food.fd_title }&nbsp;</h2>
				<h3>평점&nbsp;${avg }</h3> <c:forEach var="tag" items="${category}">
 					#${tag }
 				</c:forEach></td>
		</tr>
		<tr>
			<td width="100">설명 :</td>
			<td width="600">${food.fd_info }</td>
		</tr>
		<tr>
			<td width="100">전화번호 :</td>
			<td>${food.fd_phoneNo }</td>
		</tr>
		<tr>
			<td width="100">지번주소 :</td>
			<td>${food.fd_address }</td>
			<%-- api로 추후연결하기 --%>
		</tr>
		<tr>
			<td width="100">도로명 주소 :</td>
			<td>${food.fd_roadAddress }</td>
		</tr>
		<tr>
			<td colspan="2"></td>
		</tr>
	</table>
<!-- 지도 -->
	<div id="map" style="width:500px;height:400px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=19304f7b1ee5a07ed9d039dba756e0bb&libraries=services"></script>
	<script type="text/javascript">
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 

	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	// 주소로 좌표를 검색합니다
	geocoder.addressSearch("${food.fd_roadAddress}", function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        
        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });
        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;"><a href="https://map.kakao.com/link/search/${food.fd_title}">${food.fd_title}</a></div>'
        });
        infowindow.open(map, marker);
		
        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    	} 
	});  
	</script>
    <!-- 찜&리뷰 -->
    <div id="myMenu">
	<ul id="myMenuList">
		<li><a class="myReview" href="${path }/food/reviewForm?fd_no=${food.fd_no}">리뷰쓰기</a></li>
		<li>
			<%-- <a class="myPick" href="${path }/food/myPick">찜하기</a> --%>
			<button id="myPick" onclick="myPick()">
				<c:choose>
				<c:when test="${pick }">
					<img id="heart" src="${path }/resources/image/not_empty_heart.png" width="15">&nbsp;찜하기
				</c:when>
				<c:otherwise>
					<img id="heart" src="${path }/resources/image/empty_heart.jpg" width="15">&nbsp;찜하기
				</c:otherwise>
				</c:choose>
			</button>
		</li>
	</ul>
	</div>
	<br><br>
	<!-- 리뷰리스트 -->
	<hr>
	<div>
		<table align="center" style="width: 60%;">
			<c:forEach var="review" items="${reviewList }">
			<tr>
				<td>${review.id }</td>
				<td>${review.re_writeDate }</td>
				<td><div class="star-ratings">
					<div 
				    class="star-ratings-fill space-x-2 text-lg"
				    style=" width: ${review.re_score * 20}%">
						<span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
					</div>
					<div class="star-ratings-base space-x-2 text-lg">
						<span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
					</div>
				</div></td>
			</tr>
			<tr>
				<td colspan="3">
					<p>${review.re_content }</p>
				</td>
			</tr>
			<tr><td colspan="3"><hr></td></tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
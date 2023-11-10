<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
  Date date = new Date();
%>
<c:set var="nowMonth" value="<%= date.getMonth()+1 %>" />
<c:set var="nowDay" value="<%= date.getDay() %>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숙소 리스트 페이지</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=LIBRARY"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer,drawing"></script>
<script>
	function myPick(){
		let heart = document.getElementById("heart");
		let imgName = heart.getAttribute("src");
		if(imgName == "${path }/resources/image/empty_heart.jpg"){
			if(confirm('찜 하시겠습니까?')){
				location.href='${path}/event/myPick?lod_id=${lodging.lod_id}&pick=true';
			}
		} else {
			location.href='${path}/event/myPick?lod_id=${lodging.lod_id}&pick=false';
		}
	}
	function encoder(r_title, lod_id, resultDay){
		r_title = encodeURIComponent(r_title);
		location.href='${path}/event/roomRes?lod_id='+lod_id+'&r_title='+r_title+'&resultDay='+resultDay;
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
td {
	padding-top: 10px;
}
h3 {
	color:orange;
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
	<!-- 선택한 숙박업소 상세 페이지 -->
    <br><br><br>
    <table align="center" >
    	<tr>
 			<td colspan="2" align="center"><img src="${lodging.lod_imgPath }"
 				onerror="this.src='${path }/resources/image/empty_img.png'" width="700"/></td>
     	</tr>
     	<tr>
 			<td colspan="2" align="center"><h2>${lodging.lod_title }&nbsp;</h2><h3>평점&nbsp;${avg }</h3>
 			</td>
     	</tr>
     	<tr>
 			<td width="100">설명 :</td>
 			<td width="600">${lodging.lod_info } </td>
     	</tr>
     	<tr>
 			<td width="100">전화번호 :</td>
 			<td>${lodging.lod_tel }</td>
     	</tr>
     	<tr>
 			<td width="100">체크인 시간 :</td>
 			<td>${lodging.lod_checkIn }</td>
     	</tr>
     	<tr>
 			<td width="100">체크아웃 시간 :</td>
 			<td>${lodging.lod_checkOut }</td>
     	</tr>
     	<tr>
 			<td width="100">객실 수 :</td>
 			<td>${lodging.lod_roomCnt }</td>
     	</tr>
     	<tr>
 			<td width="100">홈페이지 :</td>
 			<td>${lodging.lod_homePage } </td>
     	</tr>
     	<tr>
 			<td width="100">주소 :</td>
 			<td>${lodging.lod_address }</td> 
     	</tr>
    </table>
    
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
	geocoder.addressSearch("${lodging.lod_address}", function(result, status) {

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
            content: '<div style="width:150px;text-align:center;padding:6px 0;"><a href="https://map.kakao.com/link/search/${lodging.lod_title}">${lodging.lod_title}</a></div>'
        });
        infowindow.open(map, marker);
		
        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    	} 
    	
	});  
	</script>
	
	
   <div id="myMenu">
	<ul id="myMenuList">
		<li><a class="myReview" href="${path }/event/reviewForm?lod_id=${lodging.lod_id}">리뷰쓰기</a></li>
		<li>
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
	<hr>
	<!-- 숙박업체 룸정보 -->
	<div id="roomInfo">
	<h4 align="center">${checkIn } ~ ${checkOut } [${resultDay }박]</h4>
	<c:forEach var="room" items="${roomList }">
		<a href="javascript:encoder('${room.r_title}', ${room.lod_id }, ${resultDay })" 
					style="color:black; text-decoration: none;">
		<table align="center" width="40%" style="border-bottom: 1px solid gray;">
				<tr>
					<td rowspan="3" width="200">
						<img src="${room.r_imgPath }"
 						onerror="this.src='${path }/resources/image/empty_img.png'" width="200"/>
					</td>
					<td colspan="2"><b style="font-size: 25px;">${room.r_title }</b></td>
				</tr>
				<tr>
					<td colspan="2">${room.r_info }</td>
				</tr>
				<tr>
					<td>기준인원 ${room.r_person }명/최대인원 ${room.r_person+2 }명 </td>
					<td>
						<c:choose>
							<c:when test="${nowMonth >= 5  and nowMonth <= 10  }">
								<c:choose>
									<c:when test="${nowDay == 6 or nowDay == 7 }">
										[1박 기준]${room.peak_weekend }
									</c:when>
									<c:otherwise>
										[1박 기준]${room.peak_weekDay }
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${nowDay == 6 or nowDay == 7 }">
										[1박 기준]${room.low_weekend }
									</c:when>
									<c:otherwise>
										[1박 기준]${room.low_weekDay }
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
						원
					</td>
				</tr>
		</table>
		</a>
		</c:forEach>	
	</div>
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
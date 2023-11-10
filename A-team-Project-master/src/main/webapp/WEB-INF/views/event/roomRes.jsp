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
<title>숙소 상세페이지</title>
<script>
	let openPay;
	function reservation(){
		let id = '${member.id}';
		if(id == null || id == ""){
			alert('로그인 후 이용 가능합니다.');
			location.href='${path}/member/loginForm.do';
		} else {
			let reservation = document.getElementById('reservation');
			reservation.style.display='block';
		}
		
	}
	function resPay(){
		openPay = window.open("resPay","결제창","width=570, height=350, resizable = no, scrollbars = no");
		setTimeout( function(){ 
		openPay.window.close();
		let frm = document.frm;
		
		frm.method="post";
		frm.action="${path}/event/resConfirmation";
		frm.submit();
		},5000);
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
#reservation input {
	padding: 10px;
	box-sizing: border-box;
	border-radius: 5px;
}

.in {
	width: 100%;
	border: 1px solid black;
}

#btn {
	background-color: #FD9F28;
	margin-bottom: 10px;
	color: white;
	border: none;
	width: 50%;
}
#reservation td{
	text-align: center;
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
	<br>
	<!-- 객실 상세 정보와 예약 페이지 -->
	<table align="center">
		<tr>
			<td colspan="2" align="center"><img src="${room.r_imgPath }"
				onerror="this.src='${path }/resources/image/empty_img.png'"
				width="700" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><h2>${room.r_title }</h2></td>
		</tr>
		<tr>
			<td colspan="2" align="center">기준인원 ${room.r_person }명/최대인원 ${room.r_person+2 }명</td>
		</tr>
		<tr>
			<td colspan="2" align="center" style="color:blue;"><c:choose>
					<c:when test="${nowMonth >= 5  and nowMonth <= 10  }">
						<c:choose>
							<c:when test="${nowDay == 6 or nowDay == 7 }">
								<c:set var="price" value="${room.peak_weekend }" />
								${price }원 * ${resultDay }박
								= 총 ${price * resultDay }원
							</c:when>
							<c:otherwise>
								<c:set var="price" value="${room.peak_weekDay }" />
								${price }원 * ${resultDay }박
								= 총 ${price * resultDay }원
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${nowDay == 6 or nowDay == 7 }">
								<c:set var="price" value="${room.low_weekend }" />
								${price }원 * ${resultDay }박
								= 총 ${price * resultDay }원
							</c:when>
							<c:otherwise>
								<c:set var="price" value="${room.low_weekDay }" />
								${price}원 * ${resultDay }박
								= 총 ${price * resultDay }원
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose> 
			</td>
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
			<td colspan="2">${room.r_info }</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<h4>
				<c:if test="${room.r_bathfacility eq 'Y    '}">
					목욕용품 &nbsp;&nbsp;
				</c:if>
				<c:if test="${room.r_aircon eq 'Y    ' }">
					에어컨 &nbsp;&nbsp;
				</c:if>
				<c:if test="${room.r_tv eq 'Y    ' }">
					TV &nbsp;&nbsp;
				</c:if>
				<c:if test="${room.r_internet eq 'Y    ' }">
					인터넷 &nbsp;&nbsp;
				</c:if>
				<c:if test="${room.r_toiletries eq 'Y    ' }">
					세면도구 &nbsp;&nbsp;
				</c:if>
				<c:if test="${room.r_cook eq 'Y    ' }">
					취사용품 &nbsp;&nbsp;
				</c:if>
				<c:if test="${room.r_hairdryer eq 'Y    ' }">
					헤어드라이기 &nbsp;&nbsp;
				</c:if>
				</h4>
			</td>
		</tr>
	</table>
	
	<div align="right" style="margin-right: 30px;">
		<h3><a href="javascript:reservation()" style="text-decoration: none; color:black;">예약하기</a></h3>
	</div>
	<!-- 예약진행 -->
	<div id="reservation" style="display: none; margin: 30px;">
	<hr>
		<form name="frm">
			<input type="hidden" name="lod_id" value="${lodging.lod_id }">
			<input type="hidden" name="id" value="${member.id }">
			<input type="hidden" name="lod_title" value="${lodging.lod_title }">
			<input type="hidden" name="r_title" value="${room.r_title }">
			<input type="hidden" name="lod_checkIn" value="${lodging.lod_checkIn }">
			<input type="hidden" name="lod_checkOut" value="${lodging.lod_checkOut }">
			<input type="hidden" name="res_from" value="${checkIn }">
			<input type="hidden" name="res_to" value="${checkOut }">
			<input type="hidden" name="price" value="${price * resultDay}"> 
			<table align="center" width="40%">
				<tr>
					<td colspan="2">${checkIn } ~ ${checkOut } [${resultDay }박]</td>
				</tr>
				<tr>
					<td>성명 : </td>
					<td><input type="text" class="in" name="res_name" value="${member.name }" placeholder="성명을 입력해주세요" ></td>
				</tr>
				<tr>
					<td>전화번호 : </td>
					<td><input type="text" class="in" name="res_tel" value="${member.tel }" placeholder="'-'는 빼고 입력해주세요" ></td>
				</tr>
				<tr>
					<td colspan="2"><div class="select">
    					 <input class="in" type="radio" id="select" name="payment" value="간편계좌결제">
    					 <label for="select">간편계좌결제</label>
    					 <input class="in" type="radio" id="select2" name="payment" value="카카오페이">
    					 <label for="select2">카카오페이</label>
    					 <input class="in" type="radio" id="select3" name="payment" value="네이버페이">
    					 <label for="select3">네이버페이</label><br>
    					 <input class="in" type="radio" id="select4" name="payment" value="토스페이">
    					 <label for="select4">토스페이</label>
    					 <input class="in" type="radio" id="select5" name="payment" value="카드">
    					 <label for="select5">카드</label>
    					 <input class="in" type="radio" id="select6" name="payment" value="페이코">
    					 <label for="select6">페이코</label>
					</div></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input id="btn" type="button" onclick="resPay()" value="예약하기">
						<input id="btn" type="reset" value="취소">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
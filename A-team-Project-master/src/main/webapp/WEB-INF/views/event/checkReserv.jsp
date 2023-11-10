<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 항공 상세페이지_오는편</title>
<script>
	// 팝업 스크립트 5초뒤 닫고 예약 완료
	let openPay;
	function resPay(){
		openPay = window.open("resPay","결제창","width=570, height=350, resizable = no, scrollbars = no");
		setTimeout( function(){ 
		openPay.window.close();
		let frm = document.frm;
		
		frm.method="post";
		frm.action="${path}/event/airReserve";
		frm.submit();
		},5000);
	}
</script>
<style>
form {
	display: inline;
	border: 1px;
}

th {
	background-color: #B8E6E1;
	width: 100px;
	text-align: center;
}

td {
	width: 100px;
	text-align: center;
	font-weight: lighter;
}

h1 {
	text-align: center;
}

.cautionBx {
	margin: auto;
	width: 940px;
	border: dotted;
}

.red {
	color: red;
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
	<!-- 항공편 확인 후 예약 진행 페이지 -->
	<form name="frm">
		<h1>내가 선택한 여정</h1>
		<table align="center" style="border: 1px solid black;">
			<tr>
				<th align="center">구분</th>
				<th align="center">항공번호</th>
				<th align="center">항공사</th>
				<th align="center">출발일자</th>
				<th align="center">출발장소</th>
				<th align="center">출발시간</th>
				<th align="center">도착장소</th>
				<th align="center">도착시간</th>
				<th align="center">금액</th>
			</tr>
			<c:forEach var="airplane" items="${airplaneList }" varStatus="status">
				<tr>
					<c:if test="${status.first }">
						<td>가는편</td>
					</c:if>
					<c:if test="${status.last }">
						<td>오는편</td>
					</c:if>
					<td>${airplane.air_no }</td>
					<td>${airplane.air_airline }</td>
					<td>${airplane.air_date }</td>
					<td>${airplane.air_departPlace }</td>
					<td>${airplane.air_departTime }</td>
					<td>${airplane.air_arrivalPlace }</td>
					<td>${airplane.air_arrivalTime }</td>
					<td>${airplane.air_price }</td>
				</tr>
				<input type="hidden" name="air_no${status.count }"
					value="${airplane.air_no }">
			</c:forEach>
			<tr bgcolor="lightgray">
				<td colspan="8" align="center">총 금액</td>
				<td>${sum}</td>
			</tr>
		</table>
		<br>
		<div align="center">
			<h3>탑승자 정보</h3>
			<input type="hidden" name="id" value="${member.id }">
			<table>
				<tr>
					<td>성명 : </td>
					<td><input type="text" name="name" placeholder="성명"></td>
				</tr>
				<tr>
					<td>생년월일 : </td>
					<td><input type="text" name="birth" placeholder="예) 19000101"></td>
				</tr>
				<tr>
					<td colspan="2"><div class="select">
						<span>결제수단</span><br><br>
    					 <input class="in" type="radio" id="select" name="payment" value="간편계좌결제">
    					 <label for="select">간편계좌결제</label>
    					 <input class="in" type="radio" id="select2" name="payment" value="카카오페이">
    					 <label for="select2">카카오페이</label><br>
    					 <input class="in" type="radio" id="select3" name="payment" value="네이버페이">
    					 <label for="select3">네이버페이</label>
    					 <input class="in" type="radio" id="select4" name="payment" value="토스페이">
    					 <label for="select4">토스페이</label><br>
    					 <input class="in" type="radio" id="select5" name="payment" value="카드">
    					 <label for="select5">카드</label>
    					 <input class="in" type="radio" id="select6" name="payment" value="페이코">
    					 <label for="select6">페이코</label>
					</div></td>
				</tr>
			</table>
		</div>
		<br>
		<div class="cautionBx">
			<div>
				<h3 style="color: red;">&nbsp;! 유의사항</h3>
				<h4>
					<ul class="wt-ul">
						<li><strong class="red">항공권 예약완료 후 즉시결제하지 않으시면 예약은
								자동취소됩니다.</strong></li>
						<li>상단의 선택하신 항공 여정을 다시 한번 확인해주시기 바랍니다.</li>
						<li><span class="red">예약 후 이름/스케쥴/항공사/인원 변경은 불가하며 취소 후
								재예약하셔야 합니다.</span></li>
						<li>취소 후 재예약 시 좌석이 없을 수도 있으니, 가는편과 오는편의 시간을 정확히 확인해주시기 바랍니다.</li>
						<li><span class="red">왕복 예약시 카드정보를 한번만 입력하셔도 됩니다. <br>(승인은
								가는편/오는편 각각 진행이 되므로 결제 후 정상승인여부를 꼭 확인해주시기 바랍니다.)
						</span></li>
						<li>결제 시 여행사 발권업무 대행수수료 1인당 편도 1,000원이 항공권 금액과 별도로 추가 승인됩니다.</li>
						<li>하단의 항공사 주의사항을 꼭 확인해주시기 바랍니다.</li>
						<li>항공권 결제는 신용/체크카드로만 결제가 가능합니다. (현금결제 불가)</li>
						<li>여행사 법인카드, 여행사 임직원카드는 사용불가하며, 문제발생 시 법적인 책임소지가 따릅니다.</li>
						<li>항공권은 항공사 사정 및 천재지변으로 인하여 시간변경 또는 결항될 수 있습니다.</li>
						<li>취소 시 여행사취소수수료 1인당 편도 1,000원이 부과될 수 있으며 취소수수료 추가결제 후 항공권
							취소가 완료됩니다. (당일 취소시 취소수수료 면제)</li>
						<li>가는편 수하물 정보 : 무료위탁수하물 : 15KG, 기내수하물 : 10KG / 오는편 수하물 정보 :
							무료위탁수하물 : 20KG, 기내수하물 : 10KG</li>
					</ul>

				</h4>
				<p class="cb"></p>
			</div>
			<p class="rb"></p>
		</div>
		<br>
		<div align="center">
			<input type="button" onclick="resPay()" value="예약하기">
		</div>
	</form>
	<br>
	<br>
	<br>
</body>
</html>
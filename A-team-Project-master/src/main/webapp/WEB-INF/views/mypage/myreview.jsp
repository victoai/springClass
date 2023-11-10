<%@page import="com.spring.project.mypage.dto.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"   isELIgnored="false"
   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path"  value="${pageContext.request.contextPath}" />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 리뷰</title>
<style>
form {
	display: inline;
}
td {
	text-align:left;
	height:50px;
}
th {
	height:30px;
	background-color:#EEEEEE;
}
table {
	vertical-align : middle;
	width: 30%;
	border-spacing: 0px;
  	padding: 10px;
  	border-collapse:collapse;
  	border-radius:25px;
  	margin-left:auto;
  	margin-right:auto;
}

tr{
 border: 1px solid #ddd;
}
#btn{
	display:inline-block;
}
.button4:hover {background-color: #ddd;}

.button {
  background-color: #EEEEEE;
  border: none;
  color: black;
  padding: 5px;
  text-align:center;
  text-decoration: none;
  font-size: 12px;
  cursor: pointer;
}
.button4 {border-radius: 8px;}
/* 클릭전 */
#review_a:link {
  color: black;
  text-decoration: none;
}
/* 클릭후 */
#review_a:visited {
  color: gray;
  font-size:12px;
  text-decoration: none;
}
/* 마우스오버 */
#review_a:hover {
  color: orange;
  text-decoration: underline;
}
/* 클릭시 */
#review_a:active {
  color: blue;
  text-decoration: none;
}
</style>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
function fn_reviewDel(url, re_no){
	if(confirm('정말로 삭제하시겠습니까?')){
		let form = document.createElement("form");

		let Input = document.createElement("Input");
		Input.setAttribute("type", "hidden");
		Input.setAttribute("name", "re_no");
		Input.setAttribute("value", re_no);
		form.appendChild(Input);

		document.body.appendChild(form);
		
		form.action=url;
		form.submit();
	} else {
		alert("삭제가 취소 되었습니다.");
	}
}

function fn_reviewModForm(url, re_no){
	let form = document.createElement("form");
	
	let Input = document.createElement("Input");
	Input.setAttribute("type", "hidden");
	Input.setAttribute("name", "re_no");
	Input.setAttribute("value", re_no);
	form.appendChild(Input);

	document.body.appendChild(form);
	 
	form.action=url;
	form.submit();
	
}
</script>
</head>
<body>
		<div id="review" align="center">
			<h1>내가 쓴 리뷰</h1>
		</div>
		<form name="reviewForm" method="POST">
		<table>
			<c:forEach var="review" items="${reviewList }">
			<tr>
				<th width="80%" align="left" >
					<c:choose>
					<c:when test="${ review.fd_no != 0 }">
						<a id="review_a" href="${path }/food/resDetail?fd_no=${review.fd_no }">
						${review.title }</a>
					</c:when>
					<c:when test="${review.lod_id != 0 }">
						<a id="review_a" href="${path}/event/lodInfo?lod_id=${review.lod_id}&resultDay=0">
						${review.title }</a>
					</c:when>
					<c:when test="${review.ac_no != 0 }">
						<a id="review_a" href="${path}/activity/activityDetail?ac_no=${review.ac_no}">
						${review.title }</a>
					</c:when>
					<c:otherwise>
						<a id="review_a" href="${path}/tour/tourDetail?tr_no=${review.tr_no}">
						${review.title }</a>
					</c:otherwise>
				</c:choose>
			</th>
				<th align="right"><div class="star-ratings">
					<div 
				    class="star-ratings-fill space-x-2 text-lg"
				    style=" width:${review.re_score * 20}%">
						<span>&nbsp;★</span><span>★</span><span>★</span><span>★</span><span>★</span>
					</div>
					<div class="star-ratings-base space-x-2 text-lg">
						<span>&nbsp;★</span><span>★</span><span>★</span><span>★</span><span>★</span>
					</div>
				</div></th>
			</tr>
			<tr>
				<td>&nbsp;${review.re_writeDate }일 리뷰<br>&nbsp;"${review.re_content }"</td>
				<td><div id="btn"><input type="button" class="button button4" value="수정" onClick="fn_reviewModForm('${path}/myreview/reviewModForm', ${review.re_no })">
				<input type="button" class="button button4" value="삭제" onClick="fn_reviewDel('${path}/myreview/reviewDel', ${review.re_no })"></div></td>
			</tr>
			</c:forEach>
		</table>
		</form>
		<br>
		<br>
</body>
</html>
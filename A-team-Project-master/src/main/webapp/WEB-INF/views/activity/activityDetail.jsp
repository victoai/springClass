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
<title>즐기멍 상세페이지</title>
<script>
	function myPick(){
		let heart = document.getElementById("heart");
		let imgName = heart.getAttribute("src");
		if(imgName == "${path }/resources/image/empty_heart.jpg"){
			if(confirm('찜 하시겠습니까?')){
				location.href='${path}/activity/myPick?ac_no=${activity.ac_no}&pick=true';
			}
		} else {
			location.href='${path}/activity/myPick?ac_no=${activity.ac_no}&pick=false';
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
h3{
	color:orange;
}
</style>
</head>
<body>
	<form name="activity" action="/project/activity/main">
		<input type="hidden" name="page" value="1">
        <input class="category" type='submit' value='액티비티'/>
    </form>
	<form name="crs" action="/project/activity/crs">
		<input type="hidden" name="page" value="1">
        <input class="category" type='submit' value='여행코스'/>
    </form>
    
    <br><br><br>
    <table align="center">
    	<tr>
 			<td colspan="2" align="center"><img src="${activity.ac_imgPath }" width="700"/></td>
     	</tr>
     	<tr>
 			<td colspan="2" align="center"><h2>${activity.ac_title }&nbsp;</h2><h3>평점&nbsp;${avg }</h3>
 			<c:forEach var="tag" items="${category}">
 					#${tag }
 				</c:forEach>
 			</td>
     	</tr>
     	<tr>
 			<td width="100">설명 :</td>
 			<td width="600">${activity.ac_info }</td>
     	</tr>
    </table>
    
    
    <div id="myMenu">
	<ul id="myMenuList">
		<li><a class="myReview" href="${path }/activity/reviewForm?ac_no=${activity.ac_no}">리뷰쓰기</a></li>
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
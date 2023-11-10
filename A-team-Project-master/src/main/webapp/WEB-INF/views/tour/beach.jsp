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
<title>Insert title here</title>
<style>
	form {
		display:inline;
	}
</style>
</head>
<body>
	<form name="tour1" action="/project/tour/main">
		<input type="hidden" name="page" value="1">
        <input class="category" type='submit' value='관광'/>
    </form>
	<form name="tour2" action="/project/tour/orumm">
		<input type="hidden" name="page" value="2">
        <input class="category" type='submit' value='오름'/>
    </form>
    <form name="tour3" action="/project/tour/beach">
		<input type="hidden" name="page" value="3">
        <input class="category" type='submit' value='바다'/>
    </form>
    <br><br><br>
    <table align="center">
    <tr align="center" >
    		<c:forEach var="tour" items="${beachList }" varStatus="status">
	 			<td><a href="${path}/tour/tourDetail?tr_no=${tour.tr_no}" style="padding:10px;">
	 				<img class="imgSize" src="${tour.tr_thumbnailPath }" width="350"/></a>
	 				<p>${tour.tr_title }</p></td>
	 			<c:if test="${(status.count%3) == 0 }">
	 				</tr>
	 				<tr align="center">
	 			</c:if>
 			</c:forEach>
 				</tr>
    </table>
 <div class="page">
 <h3>
    <c:if test="${prev}">
 <span>[ <a href="${path }/tour/beach?page=${startPageNum - 1}">이전</a> ]</span>
</c:if>

<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
  <span>
   <a href="${path }/tour/beach?page=${num}">${num}</a> 
 </span>
</c:forEach>

<c:if test="${next}">
 <span>[ <a href="${path }/tour/beach?page=${endPageNum + 1}">다음</a> ]</span>
</c:if>
</h3>
</div>
</body>
</html>
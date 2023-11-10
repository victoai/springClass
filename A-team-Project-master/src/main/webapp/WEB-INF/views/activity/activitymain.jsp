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
<title>즐기멍</title>
<style>
	form {
		display:inline;
	}
	#line {
		word-wrap: break-word;
		width:350px;
		height:32px;
		text-align:center;
	}
</style>
</head>
<body>
	<form name="activity1" action="/project/activity/main">
		<input type="hidden" name="page" value="1">
        <input class="category" type='submit' value='액티비티'/>
    </form>
	<form name="crs" action="/project/activity/crs">
		<input type="hidden" name="page" value="1">
        <input class="category" type='submit' value='여행코스'/>
    </form>
    <br><br><br>
    <table align="center" style="border-spacing:0;">
    <tr>
    		<c:forEach var="activity" items="${activityList }" varStatus="status">
	 			<td style="border-spacing:0;"><a href="${path}/activity/activityDetail?ac_no=${activity.ac_no}" style="padding:10px;">
	 				<img class="imgSize" src="${activity.ac_thumbnailPath }"/></a>
	 				<p id="line">${activity.ac_title }</p></td>
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
 <span>[ <a href="${path }/activity/main?page=${startPageNum - 1}">이전</a> ]</span>
</c:if>

<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
  <span>
   <a href="${path }/activity/main?page=${num}">${num}</a> 
 </span>
</c:forEach>

<c:if test="${next}">
 <span>[ <a href="${path }/activity/main?page=${endPageNum + 1}">다음</a> ]</span>
</c:if>
</h3>
</div>
</body>
</html>
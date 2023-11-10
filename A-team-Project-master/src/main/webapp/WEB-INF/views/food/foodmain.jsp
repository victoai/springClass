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
<!-- 맛집 정보 테이블 -->    
    <table align="center">
    <tr align="center" >
    		<c:forEach var="fd" items="${foodList }" varStatus="status">
	 			<td><a href="${path}/food/resDetail?fd_no=${fd.fd_no}" style="padding:10px;">
	 				<img class="imgSize" src="${fd.fd_thumbnailPath }" width="350"/></a>
	 				<p>${fd.fd_title }</p></td>
	 			<c:if test="${(status.count%3) == 0 }">
	 				</tr>
	 				<tr align="center">
	 			</c:if>
 			</c:forEach>
 				</tr>
    </table>
<!-- 페이지 이동 -->
	<div class="page">
		<h3>
			<c:if test="${prev}">
				<span>[ <a href="${path }/food/main?page=${startPageNum - 1}">이전</a>
					]
				</span>
			</c:if>

			<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
				<span> <a href="${path }/food/main?page=${num}">${num}</a>
				</span>
			</c:forEach>

			<c:if test="${next}">
				<span>[ <a href="${path }/food/main?page=${endPageNum+1}">다음</a>
					]
				</span>
			</c:if>
		</h3>
	</div>
</body>
</html>

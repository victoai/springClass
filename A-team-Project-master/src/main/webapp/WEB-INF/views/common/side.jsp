<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="path" value="${pageContext.request.contextPath }" />
  <a href="${path }/main/introduce">제주가고싶조</a>
  <a href="${path }/food/main?page=1">먹으멍</a> 
  <a href="${path }/tour/main?page=1">보멍</a>
  <a href="${path }/activity/main?page=1">즐기멍</a>
  <a href="${path }/event/main">이벤트</a>
  <img src="${path }/resources/image/icon.png" width="40">
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
  Home 
</h1>
 

<c:if test="${ empty sessionScope.sessionId}">
	<a href="<c:url value='/login/login' />"> 로그인</a>
</c:if>
<c:if test="${ not empty sessionScope.sessionId}">
	<a href="<c:url value='/login/logOut'/>">로그아웃</a>
	<a href="<c:url value='/board/list' />"> 게시판입니다</a>
</c:if>

 
 <h2> 로그인상황에 따른  login / loginOut  보여주기 </h2>
<c:set var="loginOutLink" value="${sessionScope.sessionId == null? '/login/login' : '/login/logOut'}" />
<c:set var="loginOut" value="${ sessionScope.sessionId==null ? '로그인' : '로그아웃'}" />
<a href="<c:url value='${loginOutLink}' />"> ${loginOut} </a>
 
 
 
 
</body>
</html>

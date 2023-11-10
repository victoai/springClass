<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<div id="loginBar">

	<c:choose>	
  		<c:when test="${isLogOn == true && member != null && kakao == true }">	
		<ul id="loginBarList">
			<li>${member.name }님 <a href="https://kauth.kakao.com/oauth/logout?client_id=7c06fcfbfeffe9bdd6963f11f30aaf2d&logout_redirect_uri=http://localhost:8080/project/kakao/kakaoLogout.do"> 로그아웃</a></li>
			<li><a href="${path}/mypage/mypagemain?id=${member.id}">마이페이지</a></li>
		</ul>
		</c:when>
		
		<c:when test="${isLogOn == true && member != null }">	
		<ul id="loginBarList">
			<li>${member.name }님 <a href="${path }/member/logout.do"> 로그아웃</a></li>
			<li><a href="${path}/mypage/mypagemain?id=${member.id}">마이페이지</a></li>
		</ul>
		</c:when>
		
		
	<c:otherwise>
	<ul id="loginBarList">
		<li><a class="addMemBtn" href="${path }/member/memberForm.do">회원가입</a></li>
		<li><a class="loginBtn" href="${path }/member/loginForm.do">로그인</a></li>
	</ul>
	</c:otherwise>
	</c:choose>
</div>

<div id="head">
<a href="${path}/main/main.do"><img src="${path }/resources/image/logo.png" width="150" height="150" ></a>
<form action="${path}/search/search.do">
	<div class="search">
     	<input type="text" name="search" id="inputSearch" placeholder="검색어를 입력해주세요." style="width:500px;">
      	<button class="search_btn">검색</button>
</div>
</form>
</div>

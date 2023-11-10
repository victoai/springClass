<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.0.1/kakao.min.js" integrity="sha384-eKjgHJ9+vwU/FCSUG3nV1RKFolUXLsc6nLQ2R1tD0t4YFPCvRmkcF8saIfOZNWf/" crossorigin="anonymous"></script>
<script>
		Kakao.init('19304f7b1ee5a07ed9d039dba756e0bb');
		console.log(Kakao.isInitialized());
	
	function kakaoLogin() {
        Kakao.Auth.authorize({
        	redirectUri: 'http://localhost:8080/project/kakao/kakaoLogin.do',
        });
      }
	
</script>
<style>
input {
	width: 20%;
	padding: 10px;
	box-sizing: border-box;
	border-radius: 5px;
	border: none;
}

.in {
	margin-bottom: 20px;
	border: 1px solid black;
}

.btn {
	background-color: #FD9F28;
	margin-bottom: 10px;
	color: white;
}

a {
	color: black;
}
</style>
</head>
<body>
	<div align="center">
		<h3>로그인</h3>
		<form name="login_frm" method="post" action="/project/member/login.do">
			<input type="text" name="id" placeholder="아이디" class="in"><br>
			<input type="password" name="pwd" placeholder="비밀번호" class="in"><br>
			<input type="submit" class="btn" value="로그인"><br>
			<input type="reset" class="btn" value="다시입력"><br>
			
			<a href="javascript:kakaoLogin()">
				<img src='../resources/image/kakao_login_medium_narrow.png' />
			</a>
			
			<br><br>
			<a href="${contextPath}/project/member/findIdForm.do" style="text-decoration: none;">아이디 찾기</a>  | 
			<a href="${contextPath}/project/member/findPwdForm.do" style="text-decoration: none;">비밀번호 찾기</a> | 
			<a href="${contextPath}/project/member/memberForm.do" style="text-decoration: none;">회원가입</a> 
		</form>
		
	</div>
	<div style="margin: 120px;"></div>
</body>
</html>
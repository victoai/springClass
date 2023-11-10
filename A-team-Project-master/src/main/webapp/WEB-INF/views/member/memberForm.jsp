<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

	function fn_selected(obj){
		obj.style.color= "black";
	}
	
	window.onload = function() {
		$("#idChk").text("영어대소문자 또는 숫자 3 ~ 15자리");
		$("#pwdChk").text("영어대소문자 또는 숫자 3 ~ 15자리");
		$("#telChk").text("ex) 01012345678");
		$("#emailChk").text("ex) test@test.com");
		// id 와 pw 적합여부 검사(4~12자리, 영어대소문자, 숫자만 가능)
		/* let val = /^[a-zA-Z0-9]{4,15}$/ */
		let val = /^[a-z|A-Z|0-9]{3,15}$/
		
		// 이메일형식 적합여부 검사
		let email_val = /^[a-zA-Z0-9]([-_\.]?[a-zA-Z0-9])*@[a-zA-Z0-9]([-_\.]?[a-zA-Z0-9])*\.[a-zA-Z0-9]{2,3}$/i
		
		// 폰번호 적합여부 검사
		let tel_val = /^010\d{8}$/
		
		// 형식검사 메서드
		function check(val,target){
			if(val.test(target)){
				return true;
			}
		}
		
		// id 중복 검사
		$("#id").blur(function(){
			var id = $("#id").val();
			if(id != '') {
				if(check(val, id)){
					$.ajax({
						url: '/project/idChk',
						type: 'GET',
						dataType : "json",
						data : {"id" : $("#id").val()},
						success: function(data){
							if(data == "0") {
								$("#idChk").text("사용할 수 있는 ID입니다.");
								$("#idChk").css("color", "blue");
							} else if(data == "1") {
								$("#idChk").text("사용중인 ID입니다.");
								$("#idChk").css("color", "red");
								$("#id").val("");
							}
						},
						error: function(){
							console.log("id 중복확인의 ajax 에러");
						}
					})
				} else {
					$("#idChk").text("ID가 형식에 맞지않습니다.");
					$("#idChk").css("color", "red");
					$("#id").val("");
				}
			} else {
				$("#idChk").text("영어대소문자 또는 숫자 3 ~ 15자리");
				$("#idChk").css("color", "black");
			}
		})
		
		// pwd 형식 검사
		$("#pwd").blur(function(){
			var pwd = $("#pwd").val();
			if(pwd != '') {
				if(check(val, pwd)){
					$("#pwdChk").text("사용할 수 있는 패스워드입니다.");
					$("#pwdChk").css("color", "blue");
				} else {
					$("#pwdChk").text("패스워드가 형식에 맞지않습니다. ( 영어대소문자 또는 숫자 3 ~ 15자리 )");
					$("#pwdChk").css("color", "red");
					$("#pwd").val("");
				}
			} else {
				$("#pwdChk").text("영어대소문자 또는 숫자 3 ~ 15자리");
				$("#pwdChk").css("color", "black");
			}
		})
		
		// pwd , pwd확인 검사
		$("#pwdpwd").blur(function(){
			var pwd = $("#pwd").val();
			var pwdpwd = $("#pwdpwd").val();
			if(pwdpwd != '') {
				if(pwdpwd == pwd){
					$("#pwdpwdChk").text("패스워드가 일치 합니다.");
					$("#pwdpwdChk").css("color", "blue");
				} else {
					$("#pwdpwdChk").text("패스워드가 일치하지 않습니다.");
					$("#pwdpwdChk").css("color", "red");
					$("#pwdpwdChk").val("");
				}
			} else {
				$("#pwdpwdChk").text("");
			}
		})
		
		// 전화번호 형식 검사
		$("#tel").blur(function(){
			var tel = $("#tel").val();
			if(tel != '') {
				if(check(tel_val, tel)){
					$("#telChk").text("");
					$("#telChk").css("color", "blue");
				} else {
					$("#telChk").text("전화번호가 형식에 맞지않습니다. ex) 01012345678");
					$("#telChk").css("color", "red");
					$("#tel").val("");
				}
			} else {
				$("#telChk").text("ex) 01012345678");
				$("#telChk").css("color", "black");
			}
		})
		
		// 이메일 형식 검사
		$("#email").blur(function(){
			var email = $("#email").val();
			if(email != '') {
				if(check(email_val, email)){
					$("#emailChk").text("");
					$("#emailChk").css("color", "blue");
				} else {
					$("#emailChk").text("이메일이 형식에 맞지않습니다. ex) test@test.com");
					$("#emailChk").css("color", "red");
					$("#email").val("");
				}
			} else {
				$("#emailChk").text("ex) test@test.com");
				$("#emailChk").css("color", "black");
			}
		})
		
	}
	
	function fn_genderCheck(){
		var gender = document.getElementById("gender");
		var genderValue = gender.options[gender.selectedIndex].value;
		return genderValue;
	}	
	
	function fn_checkForm(){
		var checkForm = document.checkForm;
		var id = checkForm.id.value;
		var pwd = checkForm.pwd.value;
		var pwdpwd = checkForm.pwdpwd.value;
		var name = checkForm.name.value;
		var age = checkForm.age.value;
		var tel = checkForm.tel.value;
		var email = checkForm.email.value;
		var gender = fn_genderCheck();

		if(!id){
			alert("아이디가 입력되지 않았습니다.")
		} else if (!pwd){
			alert("비밀번호가 입력되지 않았습니다.")
		} else if (!pwdpwd){
			alert("비밀번호 확인이 입력되지 않았습니다.")
		} else if (!name){
			alert("이름이 입력되지 않았습니다.")
		} else if (!age){
			alert("나이가 입력되지 않았습니다.")
		} else if (!tel){
			alert("전화번호가 입력되지 않았습니다.")
		} else if (!email){
			alert("이메일이 입력되지 않았습니다.")
		} else if (gender == "N"){
			alert("성별이 선택되지 않았습니다.")
		} else {
			checkForm.submit();
		}
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

/* input type number 일 때 우측에 화살표 없애기 */
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
}

.in {
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

select {
	width: 20%;
	padding: 10px;
	box-sizing: border-box;
	border-radius: 5px;
	margin-bottom: 20px;
	border: 1px solid black;
	color: gray;
}

.check{
	width: 20%;
	font-size: 10px;
	margin-left: 15px;
	display: inline-flex;
	margin-top: 10px;
	margin-bottom: 10px;
}

</style>
</head>
<body>
	<div align="center">
		<h3>회원가입</h3>
		<form method="post" name="checkForm" action="/project/member/addMember.do">
			<input type="text" id="id" name="id" placeholder="아이디" class="in"><br>
			<span id="idChk" class="check"></span><br>
			<input type="password" id="pwd" name="pwd" placeholder="비밀번호" class="in"><br>
			<span id="pwdChk" class="check"></span><br>
			<input type="password" id="pwdpwd" name="pwdpwd" placeholder="비밀번호 확인" class="in"><br>
			<p id="pwdpwdChk" class="check"></p><br>
			<input type="text" name="name" placeholder="이름" class="in"><br>
			<p class="check"></p><br>
			<input type="number" name="age" placeholder="나이" class="in"><br>
			<p class="check"></p><br>
			<input type="text" id="tel" name="tel" placeholder="전화번호" class="in"><br>
			<p id="telChk" class="check"></p><br>
			<input type="email" id="email" name="email" placeholder="이메일" class="in"><br>
			<p id="emailChk" class="check"></p><br>
			<select class="select" id="gender" name="gender" onclick="fn_selected(this)">
				<option selected disabled hidden value="N">성별</option>
				<option value="M">남성</option>
				<option value="W">여성</option>
			</select>
			<br>
			<input type="button" class="btn" value="회원가입" onclick="fn_checkForm()"><br>
			<input type="reset" class="btn" value="다시입력"><br>
		</form>
	</div>
	<div style="margin: 120px;"></div>	
</body>
</html>
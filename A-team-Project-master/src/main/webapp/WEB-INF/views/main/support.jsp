<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	function success(){
		let form = document.supportForm;
		
		let email = form.email.value;
		let title = form.title.value;
  		let content = form.content.value;
		
		form.method="post";
  		form.action="${path }/project/main/sendEmail";
		form.submit();
	}
	function backToList(){
		let form = document.supportForm;
		form.action="${path}/project/main/main.do";
		form.submit();
	}
</script>
</head>
<body>
	<h1 style="text-align:center;">1:1 문의하기</h1>
	<form name="supportForm" method="post" action="${path }/main/sendEmail">
		<table border="0" align="center">
			<tr>
				<th align="right">메일주소 : </th>
				<td colspan="2"><input type="email" size="63" maxlength="500" name="email"></td>
			</tr>
			<tr>
				<th align="right">문의제목 : </th>
				<td colspan="2"><input type="text" size="63" maxlength="500" name="title"></td>
			</tr>
			<tr>
				<th align="right">문의내용 : </th>
				<td colspan="2">
					<textarea name="content" rows="10" cols="65" maxlength="4000" style="resize:none;">
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="button" value="문의하기" onClick="success()">
					<input type="button" value="돌아가기" onClick="backToList()">
				</td>
		</table>	
	</form>
	<br><br>
	</body>
</html>
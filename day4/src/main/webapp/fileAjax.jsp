<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
	function a() {

		alert("dfdfdf");
		let formData = new FormData(document.getElementById('myForm'));
		alert( formData + "dfdfdfdf");
		$.ajax({
			type : "POST",
			enctype : 'multipart/form-data',
			processData : false,
			contentType : false,
			url : "/day4/ftest",
			data : formData,
			success : function(data) {
				console.log("success")
			}
			
		});

	}
</script>
</head>
<body>


	<form id="myForm">
		<label>파일 업로드:</label> <input type="file" name="file">
		<button type="button" onclick="a()">전송</button>
	</form>
</body>
</html>
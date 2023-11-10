<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>

	function callA(){
		
		let user = { id:"test" ,pw:"dfdfdfdf"};
		
		$.ajax({
			type:"get",
			url:"ajax1",
			data: user,
			success: function( data){
				alert( data);
			},
			err:function(){
				alert("dkfdfkdfk");
			}
			
		});
	}
	
	
	function callB(){		
		let user = { id:"test" ,pw:"dfdfdfdf"};		
		$.ajax({
			type:"get",
			url:"ajax2",
			data: user,
			success: function( data){
				alert( data);
			},
			err:function(){
				alert("dkfdfkdfk");
			}
			
		});
	}
	
	
	
	// 반드시 post할 것    오류발생함
	// 비고: HTTP 요청 파싱 오류들이 더 발생하는 경우 DEBUG 레벨 로그로 기록될 것입니다.
// java.lang.IllegalArgumentException: 요청 타겟에서 유효하지 않은 문자가 발견되었습니다. 유효한 문자들은 RFC 7230과 RFC 3986에 정의되어 있습니다.
function callC(){
		alert("callZ");
		
		let user = {id:"test",pw:"dfdfdfdf"};		
		$.ajax({
			type:"post",
			url:"/ajax/bbb",
			data: JSON.stringify(user),
			contentType: 'application/json',
			success: function( data){
				alert( data);
			},
			err:function(){
				alert("dkfdfkdfk");
			}
			
		});
	}
</script>
</head>
<body>
<button  onclick="callA()">클릭</button>
<button  onclick="callB()">클릭</button>
<button  onclick="callC()">클릭</button>
</body>
</html>
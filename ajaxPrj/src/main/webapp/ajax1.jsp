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
			type:"post",
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
			type:"post",
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
</script>
</head>
<body>
<button  onclick="callA()">클릭</button>
<button  onclick="callB()">클릭</button>
</body>
</html>
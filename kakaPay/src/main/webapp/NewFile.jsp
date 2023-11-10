<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button id="btn-kakaopay" class="btn btn-primary">카카오페이</button>
 
<script>
$(function(){
	
	$('#btn-kakaopay').click(function(){
		$.ajax({
			url:'kakaopay',
			dataType:'json',
			success:function(resp){
				 alert(resp.tid); //결제 고유 번호
				 console.log( resp);
				var box = resp.next_redirect_pc_url;
				//window.open(box); // 새창 열기
				location.href = box;
			},
			error:function(error){
				alert(error);
			}
		});
	});
});
</script>

</body>
</html>
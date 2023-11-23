<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
function a( index  ){
	
	let y=document.getElementById("y");
	let m=document.getElementById("m");
	alert( index);
	if( index ==1 ){
		// 여행지가 보이고 // 맛집보이지 않게 	
		y.style.display="block";
		m.style.display="none";		
	}else if( index==2){
		y.style.display="none";
		m.style.display="block";		
	}
}

</script>

<style>
div{
border:1px solid black;
}

</style>

</head>
<body>


<button  onclick="a(1)">여행지</button><button onclick="a(2)">맛집</button>

<div id="y">
  여행지 
  <p>여행지 제목</p>
  <ul>
  <li>ddfdf</li>
  <li>ddfdf</li>
  <li>ddfdf</li>
  <li>ddfdf</li>
  
  </ul>
  
</div>

<div id="m">
  맛집
</div>



</body>
</html>
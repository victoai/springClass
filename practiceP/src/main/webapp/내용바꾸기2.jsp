<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>


$(document).ready(function(){ //문서가 로드가 완료되면
    $("button").click(function(){
    	 // alert("하이");   	
     
        var index = $(this).index() ;  // 버튼의 순서(인덱스)를 가져옴  첫번째 :0 , 두번째  :1
        if(index === 0){
            // 여행지가 보이고 // 맛집보이지 않게 	
            $("#y").show();
            $("#m").hide();
        } else if(index === 1){
            $("#y").hide();
            $("#m").show();
        }
        alert(index);
        
         
    }
    
    );
});
</script>

<style>
div {
    border: 1px solid black;
}
</style>

</head>
<body>

<button>여행지</button><button>맛집</button>

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
    
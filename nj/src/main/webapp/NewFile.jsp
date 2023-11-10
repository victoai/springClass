<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

ul{
list-style:none;
}
   
   .outer{
   
   		display:flex;
   		border:1px solid black;
   }

</style>
</head>
<body>




	<div id="wrap"></div>



	<script>
		let data = [ {
			sigungucode : '31007',
			name : '군포시'
		}, {
			sigungucode : '31008',
			name : '김포시'
		}, {
			sigungucode : '31009',
			name : '남양주시'
		}, {
			sigungucode : '31010',
			name : '동두천시'
		}, {
			sigungucode : '31011',
			name : '부천시'
		}, {
			sigungucode : '31012',
			name : '성남시'
		}, {
			sigungucode : '31013',
			name : '수원시'
		},
		 {
			sigungucode : '31007',
			name : '군포시'
		}, {
			sigungucode : '31008',
			name : '김포시'
		}, {
			sigungucode : '31009',
			name : '남양주시'
		}, {
			sigungucode : '31010',
			name : '동두천시'
		}, {
			sigungucode : '31011',
			name : '부천시'
		}, {
			sigungucode : '31012',
			name : '성남시'
		}, {
			sigungucode : '31013',
			name : '수원시'
		}];

		let cnt = Math.floor(data.length / 3);    //7  => 2   ( 2-1) :5개씩
		let cnt2 = data.length % 3;     // 1

		console.log(data);
		alert("cbt" + cnt);

		

		let result = "<ul  class='outer'>";

		let index = 0;

		for (let i = 0; i < cnt; i++) {

			// 4
			result += "<li  >";

			result += "<ul>";

			if (i == cnt - 1) {

				for (let j = 0; j < cnt2; j++) {
					console.log(data[index].name);
					result += "<li>" +  data[index].sigungucode  +  ":"  +   data[index].name + "</li>";
					console.log("<li>" + data[index].name + "</li>");
					index++;
				}

			} else {
				for (let j = 0; j < 4; j++) {
					console.log(data[index].name);
					result += "<li>" +  data[index].sigungucode  +      ":"  +  data[index].name + "</li>";
					console.log("<li>" + data[index].name + "</li>");
					index++;

				}
			}
			result += "</ul>";

			result += "</li>";
		}
		result += "</ul>"

		alert(result);
		
		let wrap = document.getElementById("wrap");
		wrap.innerHTML  = result;
	</script>
</body>
</html>
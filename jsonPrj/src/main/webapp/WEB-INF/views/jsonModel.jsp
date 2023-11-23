<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 
 

<script>
var jsonData1 = ${item1};
var jsonData2 = ${item2};
console.log( jsonData1);
console.log( jsonData2);


let jstr= JSON.stringify( jsonData1);
console.log( jstr);
</script>

</body>
</html>
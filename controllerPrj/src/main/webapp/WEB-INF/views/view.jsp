<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




 ${data}
   
 <% String data  = (String) request.getAttribute("data"); %>
 <%=data%>
 
 
 <% String test="test입니다"  ;%>
 <%= test %> 
 
 <%  //pageContext.setAttribute("test", test); %>  
${test}


test2 !!!!!  <br>
<% String test2="test입니다"; %>
${test2}

<c:set var="test2" value="test입니다"></c:set>  
<c:set var="test3" value="test입니다" />
변수선언하면  pageContext저장소에 자동으로 저장이 된다. 
그래서 EL 사용 가능함 
 
${test2}
${test3}

 

 


 
 
 
 
 
 
 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


<c:forEach var="item" items="${list}">
${item}
</c:forEach>



<% ArrayList<String>  list  =( ArrayList<String>)  request.getAttribute("list");
   for( int i =0 ;  i< list.size() ; i++){
	    String item = list.get(i);
	    out.println( item);
   }
%>


</body>
</html>
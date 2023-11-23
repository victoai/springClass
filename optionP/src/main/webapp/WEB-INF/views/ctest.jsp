<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


메뉴이름: 




옵션정보 출력

<ul>
 
<c:forEach var="item"  items="${fn:split(cart.options, '/')}" varStatus="st" >	
	 <c:if test="${!st.first}">
        <p>${item}</p>
    </c:if>
</c:forEach> 

</ul>
</body>
</html>
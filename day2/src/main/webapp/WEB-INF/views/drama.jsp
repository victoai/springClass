<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>드라마 리스트</title>
</head>
<body>
<h2>드라마 리스트</h2>
<table border="1">
  <tr>
    <th>코드</th>
    <th>제목</th>
    <th>배우</th>
  </tr>
  <c:forEach var="drama" items="${dList}">
    <tr>
      <td>${drama.code}</td>
      <td>${drama.title}</td>
      <td>${drama.actors}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
 




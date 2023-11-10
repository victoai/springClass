<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css?after">
</head>
<body>
   <div id="container">
      <div class="header">
         <tiles:insertAttribute name="header" />
      </div>
      <div class="topnav">
         <tiles:insertAttribute name="side" />
      </div>
      <div class="content">
         <tiles:insertAttribute name="body" />
      </div>
      <div class="footer">
         <tiles:insertAttribute name="footer" />
      </div>
   </div>
</body>
</html>
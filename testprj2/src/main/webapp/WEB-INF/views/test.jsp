<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Test Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function insertTestData() {
            $.ajax({
                type: "POST",
                url: "<%= request.getContextPath() %>/test/insert",
                data: $("#insertForm").serialize(),
                success: function () {
                    location.reload();
                },
                error: function (error) {
                    console.log(error);
                }
            });
        }

        function updateTestDate() {
            $.ajax({
                type: "POST",
                url: "<%= request.getContextPath() %>/test/updateDate",
                data: { test_id: $("#updateTestId").val() },
                success: function () {
                    location.reload();
                },
                error: function (error) {
                    console.log(error);
                }
            });
        }
    </script>
</head>
<body>

<h2>Test List</h2>

<ul>
    <c:forEach var="test" items="${testList}">
        <li>${test.test_id} - ${test.test_name} - ${test.test_date}</li>
    </c:forEach>
</ul>

<hr>

<form id="insertForm">
    <label for="testId">Test ID:</label>
    <input type="text" id="testId" name="test_id" required>
    <label for="testName">Test Name:</label>
    <input type="text" id="testName" name="test_name" required>
    <button type="button" onclick="insertTestData()">Insert Test</button>
</form>

<hr>

<form id="updateForm">
    <label for="updateTestId">Test ID to Update:</label>
    <input type="text" id="updateTestId" name="test_id" required>
    <button type="button" onclick="updateTestDate()">Update Test Date</button>
</form>

</body>
</html>
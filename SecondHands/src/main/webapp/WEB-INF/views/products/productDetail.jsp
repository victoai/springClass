<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.sh.login.domain.LoginDTO"%>
<%@ page import="com.sh.product.domain.ProductDTO"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<style>
body {
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
	margin: 0;
}

.product-container {
	display: flex;
	border: 1px solid black;
	margin-bottom: 20px;
	padding: 10px;
}

.product-details {
	flex-grow: 1;
}

.product-details div {
	margin-bottom: 10px;
}
</style>
</head>
<body>

	<%
	List<ProductDTO> products = (List<ProductDTO>) session.getAttribute("products");
	List<LoginDTO> selectedUserList = (List<LoginDTO>) session.getAttribute("selectedUser");
	ProductDTO a = (ProductDTO) request.getAttribute("product");

	out.println(a);

	LoginDTO user = (LoginDTO) session.getAttribute("user");
	if (selectedUserList != null && !selectedUserList.isEmpty() && products != null && !products.isEmpty()) {
		// 수정: selectedUserList에서 selectedUser 가져오기
		LoginDTO selectedUser = selectedUserList.get(0);

		// 수정: products의 첫 번째 아이템 가져오기
		ProductDTO product = products.get(0);
	%>



	<!-- 로그인한 유저 코드와 게시글 작성한 유저 코드가 일치할시 수정/삭제버튼이 나옴 -->
	<c:set var="owner"
		value="${product.user_code  == selectedUser[0].user_code}"></c:set>

	<h2><%=selectedUser.getUser_nickname()%>
		님
	</h2>

	<form action="/testing/products" method="get"
		enctype="multipart/form-data">
		<div>
			<!-- 로그인한 유저 코드와 게시글 유저코드를 불러옴 -->
			<input type="hidden" name="user_code1" id="user_code1"
				value="<%=selectedUser.getUser_code()%>" required> <input
				type="hidden" name="user_code3" id="user_code3"
				value="${product.user_code}" required>

			<div class="product-container">
				<div class="product-image">
					<img src="<c:url value='/images/${product.board_Img}' />"
						alt="Product Image" style="max-width: 500px; max-height: 500px;">
				</div>
				<div class="product-details">
					<div>제목: ${product.board_Title} 작성자: ${product.user_nickname }</div>
					<div>작성일: ${product.board_Date} 조회수: ${product.board_Click}</div>
					<div>지역: ${product.loc_code}/${product.detail_loc}</div>

					<div>내용: ${product.board_Text}</div>
					<div>가격: ${product.board_Price}</div>
				</div>
			</div>


		</div>
	</form>

	<c:if test="${owner}">
		<!-- 수정부분 -->
		<form action="/testing/products/update" method="get">
			<input type="hidden" name="user_code1" id="user_code1"
				value="<%=selectedUser.getUser_code()%>" required> <input
				type="hidden" name="user_code3" id="user_code3"
				value="<%=product.getUser_code()%>" required> <input
				type="hidden" name="boardId" value="${product.board_Id}">
			<button type="submit">수정</button>
		</form>
		<!-- 삭제부분 -->
		<form action="/testing/products/delete" method="post">
			<input type="hidden" name="user_code1" id="user_code1"
				value="<%=selectedUser.getUser_code()%>" required> <input
				type="hidden" name="user_code3" id="user_code3"
				value="<%=product.getUser_code()%>" required> <input
				type="hidden" name="boardId" value="${product.board_Id}">
			<button type="submit">삭제</button>
		</form>
		<form action="/testing/products/updateDate" method="post"
			id="updateDateForm">
			<input type="hidden" name="boardId" value="${product.board_Id}">
			<button type="submit">날짜 갱신</button>
		</form>

	</c:if>
	<form action="/testing/products/likes" method="post">
		<input type="text" name="user_code1" id="user_code1"
			value="<%=selectedUser.getUser_code()%>" required> <input
			type="hidden" name="boardId" value="${product.board_Id}">
		<button id="likeButton">좋아요 추가</button>
	</form>
	<%
	} else {
	// products나 selectedUserList가 비어있을 때 예외 처리
	out.println("상품 정보를 찾을 수 없습니다.");
	}
	%>
	<form action="/testing/products">
		<button type="submit">상품</button>
	</form>

	<form action="/testing/order">
		<input type="hidden" name="boardId" value="${product.board_Id}">
		<button type="submit">상품 구매</button>
	</form>

	<form action="/testing/logout" method="post">
		<button type="submit">로그아웃</button>
	</form>
</body>
</html>
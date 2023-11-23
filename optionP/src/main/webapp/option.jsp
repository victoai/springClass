<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	display: flex;
	flex-direction: column;
	align-items: center;
	height: 100vh;
}

section {
	width: 1280px;
	flex: 8;
}

section {
	overflow-y: auto; /*섹션의 내용이 넘치는 경우 스크롤이 가능*/
	-ms-overflow-style: none; /* 스크롤바 없애기 */
}

section::-webkit-scrollbar { /* 스크롤바 없애기 */
	display: none;
}

.nav-var {
	padding: 10px 0px 10px 0px;
	font-size: 20px;
	font-weight: bolder;
	display: flex;
	width: 1280px;
	margin: 0 auto;
	justify-content: space-between;
}

hr {
	margin: 0 auto;
	width: 100%;
	border-width: 2px;
}

.menu-img {
	width: 200px;
	height: 200px;
	background-color: purple;
	margin: 20px auto;
	padding: 10px;
}

.menu-name {
	text-align: center;
	margin: 10px auto;
	font-size: 35px;
	margin: 0 auto;
	padding: 20px;
	width: 70%;
	border-top: 1px solid gray;
}

.option-list-wrap {
	width: 70%;
	border: 1px solid black;
	margin: 0 auto;
	padding: 20px 40px 20px 40px;
}

.option-category {
	font-size: 25px;
}

.option-list {
	padding-bottom: 20px;
}

.plus-cart-but {
	display: flex;
	width: 100%;
	justify-content: center;
}
</style>

<script>

let resultArr = [];
let optionString ="" ;
function insertCart(){
	
	
	let option = 'input[name="option"]:checked';
	let optionList = document.querySelectorAll(option);
	resultArr = [];
	  optionList.forEach((el) => {
	    resultArr.push(el.value +"");
	  });
	  
	  console.log(resultArr);
	  
	  optionString = resultArr.toString();  //
	  
	  
   
}


function sendOptionJson() {
    let test  = { options :resultArr };
    optionString = resultArr.toString();
    alert(optionString)
    document.frm.options.value  = optionString;
    document.frm.submit();
}



</script>

</head>
<body>
	 
	<nav class="nav-var">
		<a href="">치킨</a><a>피자</a><a>햄버거</a><a>족발,보쌈</a><a>한식</a><a>중식</a><a>일식</a><a>양식</a><a>분식</a><a>디저트</a><a>야식</a>
	</nav>
	<hr>
	<section>
		<div>
			<form name="frm" method="post"
				action="/baemin/cartList?menuCode=${menuCode}">
				<div>
					<div class="menu-img"></div>
					<div class="menu-name">메뉴선택에서 불러와야함</div>
				</div>
				<div class="option-list-wrap">
					<c:forEach items="${Categorylist}" var="item">
						<div>
							<span class="option-category">${item}</span><br>
							<c:forEach items="${list}" var="items">
								<c:if test="${item eq items.optionCategory}">
									<c:choose>
										<c:when test="${items.optionSelectType eq 1 }">
											<div class="option-list">
												<input type="radio" name="option"
													value="${items.optionCode}" onclick="insertCart()">
												<span>${items.optionName}</span> <span>${items.optionPrice}</span>
												<input type="hidden" name="${items.optionCode}"
													value="${items.optionCode}">
											</div>
										</c:when>
										<c:otherwise>
											<div class="option-list">
												<input type="checkbox" name="option"
													value="${items.optionCode} / ${items.optionName} / ${items.optionPrice} "
													onclick="insertCart()"> <span>${items.optionName}</span>
												<span>${items.optionPrice}</span> <input type="hidden"
													name="${items.optionCode}" value="${items.optionCode}" >
											</div>
										</c:otherwise>
									</c:choose>
								</c:if>
							</c:forEach>
						</div>
					</c:forEach>
					<input type="hidden" name="options">
				</div>

				<div class="plus-cart-but">
					<button type="button" onclick="sendOptionJson()">장바구니에 추가</button>
				</div>
			</form>
		</div>

 
</body>
</html>
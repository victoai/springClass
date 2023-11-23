<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${list}" var="items">
							<c:if test="${item.optionCategory eq items.optionCategory}">
								<c:choose>
									<c:when test="${items.optionSelectType eq 1 }">
										<div class="option-list">
											<input type="radio" name="${item}"> 
											<input value="${items.optionName}" class="upOptionName">
											<input value="${items.optionPrice}" class="upOptionPrice">
											<select name="upoptionStatus">
											<option value="1">비공개</script></option>
											<option value="0">공개</script> </option>
											</select>
											<button onclick="updateSellerOption(${items.optionCode},this)">수정</button>
											<button onclick="optiondelete(${items.optionCode})">삭제</button>
											
											
										</div>
									</c:when>
									<c:otherwise>
										<div class="option-list">
											<input type="checkbox" name="${item}"> 
											<input value="${items.optionName}" class="upOptionName">
											<input value="${items.optionPrice}" class="upOptionPrice">
											<select name="upoptionStatus"  id="upoptionStatus">
											<option value="1">비공개</option>
											<option value="0">공개</option>
											</select>
											<button onclick="updateSellerOption(${items.optionCode},this)">수정</button>
											<button onclick="optiondelete(${items.optionCode})">삭제</button>

											<script>
											
											  let upoptionStatus  = document.getElementById("upoptionStatus");
											  alert(    ${items.optionStatus} );
											  upoptionStatus.value= '${items.optionStatus}';
											
											
											</script>
											
										</div>
									</c:otherwise>
								</c:choose>
							</c:if>
						</c:forEach>
</body>
</html>
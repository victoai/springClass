<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path"  value="${pageContext.request.contextPath}"  />
<c:set var="id" value="${id }" />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 리뷰 수정</title>
<style>
form {
   display: inline;
}
.star-rating :checked ~ label {
  color:#f90;
}
</style>
<script>
	function backToList() {
		let form = document.modReview;
		form.action = "${path}/myreview/review";
		form.submit();
	}
</script>
</head>
<body>
   <form name="modReview" action="${path }/myreview/modReview" method="POST">
      <table align="center">
         <tr>
         	<td colspan="2">
         		<h3 style="text-align:left">리뷰수정</h3>
         		<h5>아이디: ${id }</h5>
         		<input type="hidden" name="re_no" value="${selectReview.re_no }">
         	</td>
         </tr>
        <tr>
            <td>
               <textarea name="re_content" rows="10" cols="50" maxlength="4000" style="resize:none;">
               ${selectReview.re_content }
               </textarea>
            </td>
         </tr>
         <tr>
         	<td align="left">별점: 
         	<div class="star-rating">
						<c:choose>
							<c:when test="${selectReview.re_score == 5}">
								<input type="radio" checked="${selectReview.re_score }"
									id="5-stars" name="re_score" value="5">
								<label for="5-stars" class="star">&#9733;</label>
								<input type="radio" id="4-stars" name="re_score" value="4" />
								<label for="4-stars" class="star">&#9733;</label>
								<input type="radio" id="3-stars" name="re_score" value="3" />
								<label for="3-stars" class="star">&#9733;</label>
								<input type="radio" id="2-stars" name="re_score" value="2" />
								<label for="2-stars" class="star">&#9733;</label>
								<input type="radio" id="1-star" name="re_score" value="1" />
								<label for="1-star" class="star">&#9733;</label>
							</c:when>
							<c:when test="${selectReview.re_score == 4}">
								<input type="radio" id="5-stars" name="re_score" value="5" />
								<label for="5-stars" class="star">&#9733;</label>
								<input type="radio" checked="${selectReview.re_score }"
									id="4-stars" name="re_score" value="4">
								<label for="4-stars" class="star">&#9733;</label>
								<input type="radio" id="3-stars" name="re_score" value="3" />
								<label for="3-stars" class="star">&#9733;</label>
								<input type="radio" id="2-stars" name="re_score" value="2" />
								<label for="2-stars" class="star">&#9733;</label>
								<input type="radio" id="1-star" name="re_score" value="1" />
								<label for="1-star" class="star">&#9733;</label>
							</c:when>
							<c:when test="${selectReview.re_score == 3}">
								<input type="radio" id="5-stars" name="re_score" value="5" />
								<label for="5-stars" class="star">&#9733;</label>
								<input type="radio" id="4-stars" name="re_score" value="4" />
								<label for="4-stars" class="star">&#9733;</label>
								<input type="radio" checked="${selectReview.re_score }"
									id="3-stars" name="re_score" value="3">
								<label for="3-stars" class="star">&#9733;</label>
								<input type="radio" id="2-stars" name="re_score" value="2" />
								<label for="2-stars" class="star">&#9733;</label>
								<input type="radio" id="1-star" name="re_score" value="1" />
								<label for="1-star" class="star">&#9733;</label>
							</c:when>
							<c:when test="${selectReview.re_score == 2}">
								<input type="radio" id="5-stars" name="re_score" value="5" />
								<label for="5-stars" class="star">&#9733;</label>
								<input type="radio" id="4-stars" name="re_score" value="4" />
								<label for="4-stars" class="star">&#9733;</label>
								<input type="radio" id="3-stars" name="re_score" value="3" />
								<label for="3-stars" class="star">&#9733;</label>
								<input type="radio" checked="${selectReview.re_score }"
									id="2-stars" name="re_score" value="2">
								<label for="2-stars" class="star">&#9733;</label>
								<input type="radio" id="1-star" name="re_score" value="1" />
								<label for="1-star" class="star">&#9733;</label>
							</c:when>
							<c:when test="${selectReview.re_score == 1}">
								<input type="radio" id="5-stars" name="re_score" value="5" />
								<label for="5-stars" class="star">&#9733;</label>
								<input type="radio" id="4-stars" name="re_score" value="4" />
								<label for="4-stars" class="star">&#9733;</label>
								<input type="radio" id="3-stars" name="re_score" value="3" />
								<label for="3-stars" class="star">&#9733;</label>
								<input type="radio" id="2-stars" name="re_score" value="2" />
								<label for="2-stars" class="star">&#9733;</label>
								<input type="radio" checked="${selectReview.re_score }"
									id="1-stars" name="re_score" value="1">
								<label for="1-star" class="star">&#9733;</label>
							</c:when>
						</c:choose>
					</div>
				</td>
         </tr>
         <tr>
            <td colspan="2" align="right">
               <input type="submit" value="리뷰수정">
               <input type="button" value="돌아가기" onClick="backToList()">
            </td>
         </tr>
      </table>   
   </form>
   <br><br>
</body>
</html>
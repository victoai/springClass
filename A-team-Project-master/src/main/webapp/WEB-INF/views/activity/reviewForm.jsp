<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path"  value="${pageContext.request.contextPath}"  />
<c:set var="tr_no" value="${param.tr_no }" />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐기멍 리뷰</title>
<style>
form {
   display: inline;
}

</style>
<script>
   function backToList() {
      let form = document.tour_reviewForm;
      form.action = "${path}/activity/activityDetail?ac_no=${ac_no}";
      form.submit();
   }
</script>
</head>
<body>
   <form name="activity_reviewForm" method="post" action="${path }/activity/addReview">
   	<input type="hidden" name="ac_no" value="${ac_no }">
         <table align="center">
         <tr>
         	<td >
         		<h3 style="text-align:left">리뷰쓰기</h3>
         		<h5>아이디: ${member.id }</h5>
         		<input type="hidden" name="id" value="${member.id }">
         	</td>
         </tr>
         <tr>
            <td>
               <textarea name="re_content" rows="10" cols="50" maxlength="4000" style="resize:none;">
               </textarea>
            </td>
         </tr>
         <tr>
         	<td align="left">별점: 
         	<div class="star-rating">
			<input type="radio" id="5-stars" name="re_score" value="5" />
			<label for="5-stars" class="star">&#9733;</label>
			<input type="radio" id="4-stars" name="re_score" value="4" />
			<label for="4-stars" class="star">&#9733;</label>
			<input type="radio" id="3-stars" name="re_score" value="3" />
			<label for="3-stars" class="star">&#9733;</label>
			<input type="radio" id="2-stars" name="re_score" value="2" />
			<label for="2-stars" class="star">&#9733;</label>
			<input type="radio" id="1-star" name="re_score" value="1" />
			<label for="1-star" class="star">&#9733;</label>
			</div>
			</td>
         </tr>
         <tr>
            <td colspan="2" align="right">
               <input type="submit" value="리뷰등록">
               <input type="button" value="돌아가기" onClick="backToList()">
            </td>
         </tr>
      </table>   
   </form>
   <br><br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/style.css" rel="stylesheet">
<style type="text/css">
   .flex-container, footer{
       display: flex;
        justify-content: center;
   }
   
   #header{
      background-image: url('../images/head.jpg');
      width: 1300px;
      height: 200px;
   }
   
   #footer{
      background: #538C51;
      width: 1300px;
      height: 100px;
   }
 h3, table { text-align: center; }
table {
	width:50%; 
    margin-left:25%; 
    margin-right:25%;
  	border-collapse: separate;
  	border-spacing: 0;

    
}

th,td {
  padding: 6px 15px;
}

th {
  width:20%;
  color:black;
  background: #AFBF73;
  text-align: center;
}

td {
  border-right: 1px solid #c6c9cc;
  border-bottom: 1px solid #c6c9cc;
}
 
#btn1, #btn2, #btn3 {
  font-size:14px;
  padding:10px 15px;
  border:1px solid #ddd;
  background-color:#0a76b7;
  border-radius:5px;
  color:#fff;
  font-weight:bold;
} 
.color_a{
  background-color:#F2B84B;
}
</style>

</head>
<body style="background-image: url('../images/body-bg.jpg');">

   <header class="flex-container">
      <div id="header"></div>
   </header>

	<main class="flex-container" style ="margin-bottom: 50px;">
		<div
			style="margin-top: 0px; width: 1300px; margin-bottom: 0px;"
			class="font">
			<%@include file ="../header.jsp" %>
			<h3>내 가게 리스트</h3>

			<br /> <br />
			<div>
				<a href="${pageContext.request.contextPath }/restaurant/add.do">
					<input type="button" value="가게추가" style="color: black; margin-right: 330px;margin-bottom:30px;float: right;">
				</a><br />
				<c:if test="${empty list}">
					<br />
					<br />
					추가한 가게가 없습니다.
				<br />
				</c:if>

				<c:if test="${not empty list}">
					<form>
						<c:forEach var="vo" items="${list }">
							<table border="1">
								<tr>
									<td rowspan="4"><img src="${vo.imgPath }"
										style="width: 200px; height: 150px"></td>
									<td class="color_a">매장이름</td>
									<td>${vo.name }</td>
								</tr>
								<tr>
									<td class="color_a">매장주소</td>
									<td>${vo.address }</td>
								</tr>
								<tr>
									<td class="color_a">매장정보</td>
									<td>${vo.restIntro }</td>
								</tr>
								<tr>
									<td class="color_a">운영시간</td>
									<td>${vo.restOpenT}시 - ${vo.restCloseT}시</td>
								</tr>
								<tr>
									<td colspan="3"><input type="button" value="예약리스트 확인"
										onclick="javaScript:location.href='${pageContext.request.contextPath }/reservation/restlist.do?restSeq=${vo.restSeq }'">
										<input type="button" value="수정"
										onclick="javaScript:location.href='${pageContext.request.contextPath }/restaurant/edit.do?restSeq=${vo.restSeq }'">
										<input type="button" value="삭제"
										onclick="javaScript:location.href='${pageContext.request.contextPath }/restaurant/delete.do?restSeq=${vo.restSeq }'"></td>
								</tr>
							</table>
						</c:forEach>
					</form>
				</c:if>
			</div>
		</div>
	</main>

	<footer>
      <%@include file = "../footer.jsp" %>
   </footer>

</body>
</html>
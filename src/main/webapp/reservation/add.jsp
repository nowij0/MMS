<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/bootstrap-3.3.2-dist/css/bootstrap.min.css"
   rel="stylesheet">
<link href="${pageContext.request.contextPath }/style.css"
	rel="stylesheet">
<style type="text/css">
.flex-container, footer {
	display: flex;
	justify-content: center;
}

#header {
	width: 1300px;
	height: 200px;
	background-image: url('../images/head.jpg');
}

#footer {
	width: 1300px;
	height: 100px;
	background-color:#538C51;
}

.a {
	font-family: 'IBM Plex Sans KR', sans-serif;
	color: #000000;
}
input[type="button"] {
	font-family: 'IBM Plex Sans KR', sans-serif;
	color: #000000;
}
</style>
<script type="text/javascript">
const check = () => {
	alert("줄서기 예약 완료");
	f.submit();
}
</script>
</head>
<body>

   <header class="flex-container">
      <div id="header"></div>
   </header>

	<main class="flex-container">
		      <div style="background-color:#F5DE83;height: 800px;margin-top: 0px; width: 1300px; margin-bottom:0px;"class="font">
         <div>
         <%@include file ="../header.jsp" %>
			<form action="${pageContext.request.contextPath }/reservation/add.do" method="post" name="f"
			style=" margin-bottom: 50px;margin-top: 30px;height: 450px;">
				<input type="hidden" name="restSeq" value="${vo.restSeq }"> 
				<input type="hidden" name="memberSeq" value="${Mvo.memberSeq }"> 
				<img alt="" src="">
				<table style="margin-top: 50px; margin-left: auto; margin-right: auto">
					<tr>
						<td colspan="3"><img src="${vo.imgPath}" style="height: 300px;"></td>
						<td style="padding-left: 30px;">
							<h3>식당이름 : ${vo.name }</h3>
							<h3>카테고리 : ${vo.category }</h3>
							<h3>주소 : ${vo.address }</h3>
							<h3>전화번호📞 : ${vo.tel }</h3>
							<h3>운영시간🕒 : ${vo.restOpenT }시 ~ ${vo.restCloseT }시</h3>
							<h3>매장소개 : ${vo.restIntro }</h3>
							<%-- <h3>
								별점 :
								<c:if test="${vo.gradeAvg == 0 }">
								후기 없습니다.
								</c:if>
								<c:if test="${vo.gradeAvg == 1 }">
								★
								</c:if>
								<c:if test="${vo.gradeAvg == 2 }">
								★★
								</c:if>
								<c:if test="${vo.gradeAvg == 3 }">
								★★★
								</c:if>
								<c:if test="${vo.gradeAvg == 4 }">
								★★★★
								</c:if>
								<c:if test="${vo.gradeAvg == 5 }">
								★★★★★
								</c:if>
							</h3> --%>

						</td>
					</tr>
				</table>

				<table border="1"style= "background-color:white;margin-top: 100px;margin-left: 500px;">
					<tr >
						<td colspan="3" style="text-align:center;background-color: #F2B84B; "> 줄서기 정보 입력</td>
					</tr>
					<tr>
						<th style="background-color: #F2B84B">이름</th>
						<td><input type="text" value="${Mvo.name }"class="a" readonly></td>
						<td rowspan="3"><input type="button" value="줄서기" onclick="check()"></td>
					</tr>
					<tr>
						<th style="background-color: #F2B84B">전화번호</th>
						<td><input type="text"value="${Mvo.tel }" class="a" readonly></td>
					</tr>
					<tr>
						<th style="background-color: #F2B84B">인원</th>
						<td><input type="number" name="people" class="a"></td>
					</tr>
				</table>
			</form>
		</div>
		</div>
	</main>

	<footer>
     <%@include file = "../footer.jsp" %>
   </footer>

</body>
</html>
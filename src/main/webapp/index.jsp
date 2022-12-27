<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/style.css" rel="stylesheet">
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

</style>
</head>
<body style="background-image: url('../images/body-bg.jpg')s">
   <header class="flex-container">
      <div id="header"></div>
   </header>

	<main class="flex-container">
		<div style="height: 800px; margin-top: 0px; width: 1300px; background-color:#F5DE83; margin-bottom:0px;"class="font">
			<div>
				<%@include file ="../header.jsp" %>
				<div style="height: 180px;background-color:#F5DE83;">
					<div style="float: left; margin-left: 370px; margin-top: 50px;">
						<h4>가게명으로 검색</h4>
						<form
							action="${pageContext.request.contextPath }/restaurant/searchByName.do"
							method="post">
							<input type="text" name="name"> <input type="submit"
								value="검색">
						</form>
					</div>

					<div
						style="float: left; margin-top: 50px; margin-left: 45px; margin-left: 45px;">
						<h4>주소로 검색</h4>
						<form
							action="${pageContext.request.contextPath }/restaurant/searchByAddr.do"
							method="post">
							<input type="text" name="addr"> <input type="submit"
								value="검색">
						</form>
					</div>
				</div>
				<br /> <br />

				<form action="${pageContext.request.contextPath }/restaurant/list.do" method="post" >
				<div class=container style="padding-left:70px;" >
				<c:forEach var="vo" items="${list }">
				<div style= "width: 350px; height: 200px; float:left; padding-top: 20px;padding-left: 20px;padding-right: 20px;
							">
				<div style="width: 150px; height: 150px; float:left">
					 <a href="${pageContext.request.contextPath }/review/list.do?restSeq=${vo.restSeq }&address=${vo.address}"><img src="${vo.imgPath }" style="width: 150px; height: 150px"></a></div>
				<div style="width: 150px; height: 150px; background-color:#F2B84B; float:left;text-align: center; padding-top: 15px;">
					<a href="${pageContext.request.contextPath }/restaurant/customerDetail.do?restSeq=${vo.restSeq }&id=${sessionScope.loginId}"
					style="color:black;">
										${vo.name }</a>
										<br/> 
										카테고리 : ${vo.category } 
										<br/>
										매장주소 : ${vo.address } 
										<br/>
<!-- 										별점 :  -->
<%-- 										<c:if test="${vo.gradeAvg==0 }">후기없음</c:if> --%>
<%-- 										<c:if test="${vo.gradeAvg==1 }">★</c:if> --%>
<%-- 										<c:if test="${vo.gradeAvg==2 }">★★</c:if> --%>
<%-- 										<c:if test="${vo.gradeAvg==3 }">★★★</c:if> --%>
<%-- 										<c:if test="${vo.gradeAvg==4 }">★★★★</c:if> --%>
<%-- 										<c:if test="${vo.gradeAvg==5 }">★★★★★</c:if> --%>
										<br/>
					<a href="${pageContext.request.contextPath }/restaurant/customerDetail.do?restSeq=${vo.restSeq }&id=${sessionScope.loginId}">
					<input type="button" value="줄서기" style="color:dimgray;"></a>
				</div>
				</div>
				</c:forEach>
				</div>
				</form>
			</div>
		</div>
	</main>
	<footer><%@include file ="../footer.jsp" %></footer>
</body>
</html>
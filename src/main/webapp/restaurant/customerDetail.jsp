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

.line {
    margin-top: 0px;
    margin-bottom: 0px;
    width: 116px;
    height: 26px;
    margin-left: 220px;
}

.a{
	text-align: right;
	color: #ff3f3f;
	margin-bottom: 5px;
	margin-top: 2px;
}
.b{
	color: #ff3f3f;
	margin-top: 20px;
}
.button_a{
	margin-left:0px;
	width:66px;
	margin-top:20px;
}
.button_b{
	margin-left:0px;
	width:66px;
	margin-top:50px;
}
.menu_a{
	float:left;
	padding-left: 50px;
	padding-right: 50px;
	margin: 0 10px;
}
.box{
	width:50px;
	height:50px;
	float:left;
	margin: 0 10px;
}
.box-wrapper{
	width:250px;
	margin:0 auto;
}
</style>
<script type="text/javascript">
const nope = () => {
	alert("로그인을 해주세요");
	location.href = "${pageContext.request.contextPath }/member/login.do";
}
</script>
</head>
<body style="background-image: url('../images/body-bg.jpg');">

	<header class="flex-container">
	
		<div id="header"></div>
	</header>

	<main class="flex-container" >
		      <div style="margin-top: 0px;margin-bottom: 0px; width: 1300px; background-color:#F5DE83" class="font">
         <div>
         <%@include file ="../header.jsp" %>
 
				<form action="${pageContext.request.contextPath }/DispatcherServlet"
					method="post">
					<table
						style="margin-top: 50px; margin-left: auto; margin-right: auto">
						<tr>
							<td colspan="3"><img src="${vo.imgPath }"
								style="height: 300px;"> <br />
								 <c:if test="${vo.resOpen==0}">
								 	<c:if test="${sessionScope.loginId==null }">
								 	<input type="button" value="줄서기" class="line" style="margin-top: 20px"
										 onclick= "nope()">
								 	</c:if>
								 	<c:if test="${sessionScope.loginId!=null }">
									<input type="button" value="줄서기" class="line" style="margin-top: 20px"
										onclick="javaScript:location.href='${pageContext.request.contextPath }/reservation/add.do?restSeq=${vo.restSeq }&id=${sessionScope.loginId }'">
									</c:if>
								</c:if> 
								<c:if test="${vo.resOpen==1 }">
									<h4 class="a">금일 예약 마감 되었습니다.</h4>
								</c:if></td>
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
								<c:if test="${vo.resOpen==0}">
									<h4 class="b">현재 줄서기 ${line} 명 대기중</h4></c:if>
							</td>
						</tr>
					</table>
				</form>
				<h4 style=" text-align-last: center;">&nbsp;&nbsp;&nbsp;매장 메뉴 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<c:if test="${mVo.memberSeq==vo.memberSeq }">
					<input type="button" value="메뉴 추가" class="button_b"
						 onclick="javaScript:location.href='${pageContext.request.contextPath }/menu/add.do?restSeq=${vo.restSeq }'" style="font-size:small">
				</c:if>	
				</h4>
				<div style="margin-left: 150px;margin-right: 100px;text-align: -webkit-center;">
				<table>
				<c:forEach var="menu" items="${meList }">
					<div class="menu_a">
					<img src="${menu.imgPath }" style="width:100px; height:100px">
					<br/>
					이름 : ${menu.name}
					<br/>
					가격 : ${menu.price }원
					</div>
					</c:forEach>
				</table><br/>
				</div>
				</div>
				<div style="text-align: -webkit-center;">
				<table border="1" style="width: 800px; text-align-last: center; margin-top: 150px; margin-bottom: 50px;">
				<tr>
					<td colspan="2" style ="background-color:#F2B84B">매장 공지사항💬</td>
				</tr>
					<tr style="background-color: #F5DE83;">
						<th>제목</th>
						<th>내용</th>
					</tr>
					<c:forEach var="n" items="${noList }">
						<tr>
							<td>${n.title}</td>
							<td>${n.content }</td>

						</tr>
					</c:forEach>
				</table>
				<c:if test="${mVo.memberSeq==vo.memberSeq }">
					<input type="button" value="공지 추가" class="button_a" style="margin-bottom:20px"
						onclick="javaScript:location.href='${pageContext.request.contextPath }/notice/add.do?restSeq=${vo.restSeq }'">
					<br />
				</c:if>
				</div>
			</div>
			</main>

	<footer>
		   <%@include file = "../footer.jsp" %>
	</footer>

</body>
</html>
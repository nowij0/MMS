<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/bootstrap-3.3.2-dist/css/bootstrap.min.css"rel="stylesheet">
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

#menubar {
  background : #AFBF73;
  text-align: center;
  margin : 0;
  padding : 0;
  height : 30px;
  line-height: 30px;
  width:50%; 
  margin-left:25%; 
  margin-right:25%;
}

#menubar a {
  color : white;
  text-decoration : none;
  font-family:'나눔고딕';
  font-size:15px;
  font-weight:500;
}

#menubar a:hover {
  color : yellow;
}

a:hover {
  background: yellowgreen;
}

h3, table { text-align: center; }

table {
	width:50%; 
    margin-left:25%; 
    margin-right:25%;
  	border-collapse: separate;
  	border-spacing: 0;
}

th,
td {
  padding: 6px 15px;
}

th {
  background: #AFBF73;
  color: #fff;
  text-align: center;
}

#btn_1 {
  font-size:14px;
  padding:10px 15px;
  border:1px solid #ddd;
  background-color:#0a76b7;
  border-radius:5px;
  color:#fff;
  font-weight:bold;
}
</style>
<script type="text/javascript">
	const cancel = (resSeq) =>{
		location.href = "${pageContext.request.contextPath }/reservation/delete2.do?resSeq="+resSeq;
	}
</script>
</head>
<body style="background-image: url('../images/body-bg.jpg');">

   <header class="flex-container">
      <div id="header"></div>
   </header>
   
   <main class="flex-container">
   
         <div style="height: 800px;margin-top: 0px; width: 1300px;"class="font">
         <div>
         <%@include file ="../header.jsp" %>
			<h3>줄서기(예약) 내역</h3>
			<nav id="menubar">
				<a href="${pageContext.request.contextPath }/member/detail.do?id=${sessionScope.loginId}">회원정보수정</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/reservation/list.do">줄서기(예약) 내역</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/review/list2.do">리뷰 작성내역</a>
			</nav>
			<hr>
			<form action="${pageContext.request.contextPath }/reservation/list.do" method="post">
				<table border="1">
					<tr>
						<th>식당이름</th>
						<th>인원수</th>
						<th>줄서기(예약) 일시</th>
						<th>입장여부</th>
						<th>취소</th>
					</tr>
					<c:forEach var="vo" items="${list }">
						<input type ="hidden"  value ="${vo.resSeq }" name = "resSeq">
						<tr>
							<td>${vo.name }</td>
							<td>${vo.people }</td>
							<td>${vo.resDate }</td>
							<td>
							<c:if test="${vo.entrance == 0}">미예약</c:if>
							<c:if test="${vo.entrance == 1}">입장</c:if>
							<c:if test="${vo.entrance == 2}">미입장</c:if>
							</td>
							<td><input type="button" id="btn_1" value="취소" onclick="cancel(${vo.resSeq})"></td>
						</tr>
					</c:forEach>
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

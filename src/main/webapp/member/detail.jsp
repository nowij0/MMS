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

</style>
</head>
<body style="background-image: url('../images/body-bg.jpg');">

   <header class="flex-container">
      <div id="header"></div>
   </header>
   
   <main class="flex-container">
   	<div style="height: 800px; margin-top: 0px; width: 1300px;margin-bottom:0px;" class ="font">
				<div>
					<%@include file ="../header.jsp" %>
			<h3>회원정보</h3>
			<br/><br/>
	<div style="height: 40px;">
            <div style="padding-left: 880px">
    <c:if test="${sessionScope.type==2}">    
   <a href="${pageContext.request.contextPath }/member/edit.do?id=${sessionScope.loginId}" style = "font-size:20px;color:black; border: 1px solid black">&nbsp;정보수정&nbsp;</a><br/>
	</c:if>
	<c:if test="${sessionScope.type==1}">    
   <a href="${pageContext.request.contextPath }/member/edit.do?id=${sessionScope.loginId}" style = "font-size:20px;color:black; border: 1px solid black">&nbsp;정보수정&nbsp;</a><br/>
	</c:if>
	</div>
	</div>
			<table border="1">
				<tr>
					<th>아이디</th>
					<td>${vo.id }</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${vo.name }</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>${vo.pwd }</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>${vo.tel }</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${vo.email }</td>
				</tr>
				<tr>
					<th>회원유형</th>
					<td>
					<c:if test="${vo.type == 0}">관리자</c:if>
					<c:if test="${vo.type == 1}">일반회원</c:if>
					<c:if test="${vo.type == 2}">가게회원</c:if>
					</td>
				</tr>
			</table>
		</div>
      </div>
   </main>
   <footer><%@include file ="../footer.jsp" %></footer>

</body>
</html>

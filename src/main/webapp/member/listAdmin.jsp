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
</style>
</head>
<body class="font" style="background-image: url('../images/body-bg.jpg');">

	<header class="flex-container" style="color: #538C51;">
		<div id="header"></div>
	</header>

	<main class="flex-container">
		<div style="height: 800px; margin-top: 0px; width: 1300px; margin-bottom:0px;" class ="font">
				<div>
					<%@include file ="../header.jsp" %>
		<div style="height: 600px; width: 1300px;">
			<h3>회원목록조회</h3>
			<br/><br/>
			<div id="list" style="margin-left: 415px;">
			<form action="${pageContext.request.contextPath }/member/listAdmin.do" method="post">
				<table border="1" style = "width:800px; text-align:center;margin-left:-150px">
					<tr>
						<th style="text-align: center;">회원번호</th>
						<th style="text-align: center;">아이디</th>
						<th style="text-align: center;">이름</th>
						<th style="text-align: center;">이메일</th>
						<th style="text-align: center;">회원유형</th>
					</tr>
					<c:forEach var="vo" items="${list }">
						<tr>
							<td style="text-align: center;">${vo.memberSeq }</td>
							<td style="text-align: center;">${vo.id }</td>
							<td style="text-align: center;">${vo.name }</td>
							<td style="text-align: center;">${vo.email }</td>
							<td>
							<c:if test="${vo.type == 0}">관리자</c:if>
							<c:if test="${vo.type == 1}">소비자</c:if>
							<c:if test="${vo.type == 2}">판매자</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
			</div>
			</div>
			</div>
			</div>
	</main>
	 <footer><%@include file ="../footer.jsp" %></footer>

</body>
</html>

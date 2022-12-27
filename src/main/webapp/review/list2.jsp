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
			<h3>리뷰작성목록</h3>
			<br/><br/>
			<table border="1" style = "width:800px; text-align:center;margin-left:240px">
				<tr>
					<th style="width:100px;">식당이름</th>
					<th style="width:500px;">내용</th>
					<th style="width:200px;">별점</th>
				</tr>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td>${vo.name }</td>
						<td>${vo.content }</td>
						<td>${vo.grade }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
      </div>
   </main>
   
   <footer>
          <%@include file = "../footer.jsp" %>
   </footer>

</body>
</html>

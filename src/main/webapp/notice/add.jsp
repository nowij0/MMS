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
  background: #F5DE83;
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
<body style="background-image: url('../images/body-bg.jpg');">
	<header class="flex-container">
      <div id="header"></div>
   </header>
	<main class="flex-container">
     <div style="height: 800px; margin-top: 0px; width: 1300px; margin-bottom: 0px;" class="font">
     <%@include file ="../header.jsp" %>
       <br /> <br />
      <h3>공지 등록</h3>
      <br /> <br />
      <form action="${pageContext.request.contextPath }/notice/add.do" method="post" name="f">
   		<input type="hidden" value=${restSeq } name="restSeq">
   		<input type="hidden" value=${sessionScope.loginId } name="id">
      <table border="1">
      <tr>
      	<th>제목</th><td><input type = "text" name = "title" style="float:left"></td>
      </tr>
      <tr>	
      	<th>내용</th>
      	<td>
      	<textarea rows="10" cols="30" name="content" style="float:left"></textarea>
      	</td>
      </tr>
       <tr>
   	  	<th>등록하기</th><td><input type="submit" value ="공지 등록하기" style="float:left"></td>
   	  </tr>
      </table>
      </form>
      </div>
   </main>
    <footer><%@include file ="../footer.jsp" %></footer>
</body>
</html>
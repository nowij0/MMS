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
 background-color:#538C51;
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
  float:left;
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

.btn_a{
	margin-top:20px;
    margin-left: 600px;
    width: 116px;
	
}
</style>
</head>
<body style="background-image: url('../images/body-bg.jpg');">
	<header class="flex-container">
      <div id="header"></div>
   </header>
	<main class="flex-container">
      <div style="height: 800px; width: 1300px;">
      <%@include file ="../header.jsp" %>
			  <br /> <br />
      <h3 class="font">메뉴 정보 등록</h3>
        <br /> <br />
    <div class="font">
      <form action="${pageContext.request.contextPath }/menu/add.do" method="post" name="f" enctype="multipart/form-data">
   		<input type="hidden" value=${restSeq } name="restSeq">
   		<input type="hidden" value=${sessionScope.loginId } name="id">
      <table border="1" style="width:">
      <tr>
      	<th>메뉴이름</th><td><input type = "text" name = "name"></td>
      </tr>
      <tr>	
      	<th>가격</th><td><input type="number" name="price" ></td>
      </tr>
	   <tr>
      	<th>메뉴사진</th><td><input type="file" name="file"></td>
      </tr>
      </table>
   	  	<input type="submit" value ="메뉴 등록하기" class="btn_a">
      </form>
    </div>
      </div>
   </main>
    <footer><%@include file ="../footer.jsp" %></footer>
   
</body>
</html>
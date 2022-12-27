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
<body style="background-image: url('../images/body-bg.jpg');">
<header class="flex-container">
      <div id="header"></div>
   </header>
   
   <main class="flex-container">
        <div style="height: 800px; margin-top: 0px; width: 1300px;margin-bottom:0px;" class ="font">
				<div>
					<%@include file ="/header.jsp" %>
      <h3>추천 게시글 작성</h3>
      <br/><br/>
      <form action="${pageContext.request.contextPath }/recommend/add.do" method="post" enctype="multipart/form-data">
      <table border = "1">
      <tr>
       <th colspan ="2"><a href="${pageContext.request.contextPath }/recommend/list.do" style = "float:right;color:black" >목록으로 돌아가기</a></th>
      </tr>
      <tr>
      	<th>작성자</th><td><input type="text" name="writer" value="${sessionScope.loginId }" readonly
      	style = "float:left"></td>
      </tr>
      <tr>
      	<th>제목</th><td><input type="text" name="title" style = "float:left;width:500px;"></td>
      <tr>
      	<th>글내용</th><td><textarea rows ="20" cols ="30" name ="content" style ="width:500px;height:200px;float:left"></textarea></td>
      </tr>
      <tr>
      	<th>이미지 자료</th><td><input type="file" name="file" style = "float:left"></td>
      </tr>
   	  <tr>
   	  	<th>업로드</th><td><input type="submit" value ="업로드하기" style = "float:left" id ="btn2"></td>
   	  </tr>
      </table>
      </form>
      </div>
      </div>
      </main>
      <footer><%@include file ="../footer.jsp" %></footer>
</body>
</html>
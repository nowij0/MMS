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
	.flex-container, footer{
		display: flex;
		justify-content: center;
	}
   
    #header{
		width: 1300px;
		height: 200px;
		background-image: url('../images/head.jpg');
    }
   
    #footer{
       	width: 1300px;
       	height: 100px;
       	background-color:#538C51;
    }
   
    h3, table { text-align: center; }

    table {
    	width:50%;
    	margin-left:25%;
    	margin-right:25%;
  		border-collapse: separate;
  		border-spacing: 0;
   	}

	th, td {
		padding: 6px 15px;
	}

	th {
		background: #F2B84B;
		color: black;
		text-align: center;
	}

	#btn_1 {
  		font-size:14px;
  		padding:10px 15px;
  		border:1px solid #ddd;
  		background-color:#F2B84B;
  		border-radius:5px;
  		color:#fff;
  		font-weight:bold;
  		margin-left:25%;
	}

	#btn_2 {
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
   
         <div style="height: 800px;margin-top: 0px; width: 1300px;"class="font">
         <div>
					<%@include file ="/header.jsp" %>
      <h3>내 식당 정보 등록</h3>
 
      <a href="${pageContext.request.contextPath }/restaurant/listByMemberSeq.do?memberSeq=${sessionScope.memberSeq }">
      <input type="button" id="btn_1" value="목록으로 돌아가기"></a><br/>
      <form action="${pageContext.request.contextPath }/restaurant/add.do" method="post" name="f" enctype="multipart/form-data">
      <table border="1">
      <tr>
      	<th>식당이름</th><td><input type = "text" name = "name"></td>
      </tr>
      <tr>
      	<th>식당종류</th>
      	<td><input type ="radio" name="category" value="한식">한식
      	<input type ="radio" name="category" value="양식">양식
      	<input type ="radio" name="category" value="일식">일식
      	<input type ="radio" name="category" value="중식">중식
      	<input type ="radio" name="category" value="카페/디저트">카페/디저트
      		<br/>
		</td></tr>
      <tr>	
      	<th>식당주소</th><td><input type="text" name="address" ></td></tr>
      <tr>
      	<th>연락처</th><td><input type="text" name="tel"></td>
      </tr>
      <tr>
      	<th>운영시간</th><td><input type="text" name="restOpenT"> ~ 
     		<input type="text" name="restCloseT"></td>
      </tr>
	  <tr>
	  	<th>소개글</th><td><textarea rows=15 cols=45 name="restIntro"></textarea></td>
	  </tr>
	   <tr>
      	<th>업체사진</th><td><input type="file" name="file"></td>
      </tr>
       <tr>
   	  	<th>등록하기</th><td><input type="submit" id="btn_2" value ="식당 등록하기"></td>
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
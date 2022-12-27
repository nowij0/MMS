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
/*       border: 3px red solid; */
      width: 1300px;
      height: 200px;
      background-image: url('../images/head.jpg');
   }
   
   #footer{
/*       border: 3px blue solid; */
      width: 1300px;
      height: 100px;
      background-color:#538C51;
   }
   
   
   div{
   
   text-align: center;
   }
   
   th{
   width: 130px;
   text-align: center;
   background-color: #F2B84B;
   }
   
   input[type="text"]{
   text-align: center;
   width: 350px;
   }
</style>
<script>
window.onload = () => {
	let arr = ["한식", "양식", "일식", "중식", "카페/디저트"];
	let cate = document.getElementById("cate");
	html = "";
	for (let x of arr) {
		console.log(x);
		if ("${vo.category}"==x) {
			html += "<input type ='radio' name='category' value='"+x+"' checked>"+x;
		} else {
			html += "<input type ='radio' name='category' value='"+x+"'>"+x;
		}
	}
	cate.innerHTML = html;
}
</script>
</head>
<body class="font" style="background-image: url('../images/body-bg.jpg');">
<header class="flex-container">
 		<div id="header"></div>
    </header>
   <main class="flex-container">	  
      <div style="height: 970px; width: 1300px;">
      <div>
					<%@include file ="../header.jsp" %>
      <div>
      <h3>가게정보 수정</h3>
      </div>
 	
 	<div>
      <a href="${pageContext.request.contextPath }/restaurant/getall.do">
      <input type="button" value="목록으로 돌아가기" style="color: black; margin-bottom: 20px;"></a><br/>
      </div>
      
      
      <div>
      <form action="${pageContext.request.contextPath }/restaurant/edit.do" method="post" name="f" enctype="multipart/form-data">
      <table border="1" style="width: 600px; height:800px;  margin-left: 350px;">
      <tr>
      	<th>식당이름</th><td><input type = "text" name = "name" value="${vo.name }"></td>
      </tr>
      <tr>
      	<th>식당종류</th>
      	<td id="cate">
<!--       	<input type ="radio" name="category" value="한식">한식 -->
<!--       	<input type ="radio" name="category" value="양식">양식 -->
<!--       	<input type ="radio" name="category" value="일식">일식 -->
<!--       	<input type ="radio" name="category" value="중식">중식 -->
<!--       	<input type ="radio" name="category" value="카페/디저트">카페/디저트 -->
<!--       		<br/> -->
		</td></tr>
      <tr>	
      	<th>식당주소</th><td><input type="text" name="address" value="${vo.address }"></td></tr>
      <tr>
      	<th>연락처</th><td><input type="text" name="tel" value="${vo.tel }"></td>
      </tr>
      <tr>
      	<th>운영시간</th><td><input type="text" name="restOpenT"  value="${vo.restOpenT }" style="width: 40px;"> ~ 
     		<input type="text" name="restCloseT" value="${vo.restCloseT }" style="width: 40px;"></td>
      </tr>
	  <tr>
	  	<th>소개글</th><td><textarea rows=15 cols=45 name="restIntro" style="width:400px; height: 180px;">${vo.restIntro }</textarea></td>
	  </tr>
	   <tr>
      	<th>업체사진</th><td><img src="${vo.imgPath }" style="width:400px;height:250px"><br/>
      	<div style="margin-left: 140px; margin-top:20px;">
      	<input type="file" name="file"></div></td>
      </tr>
       <tr>
      	<th>예약가능 여부</th><td><input type="radio" name="resOpen" value=0>가능
      		<input type="radio" name="resOpen" value=1>불가능</td>
      </tr>
       <tr>
   	  	<th>수정하기</th><td><input type="submit" value ="가게정보 수정"></td></tr>
   	  
      </table>
      <input type="hidden" name="restSeq" value="${vo.restSeq }">
      <input type="hidden" name="imgPath" value="${vo.imgPath }">
      <input type="hidden" name="gradeAvg" value="${vo.gradeAvg }">
      <input type="hidden" name="memberSeq" value="${vo.memberSeq }">
      
      </form>
      </div>
      </div>
      </div>
   </main>
     <footer>
         <%@include file = "../footer.jsp" %>
   </footer>
</body>
</html>
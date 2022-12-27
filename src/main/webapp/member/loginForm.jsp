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
   <link href="${pageContext.request.contextPath }/style.css" rel="stylesheet">
<style type="text/css">

/* table { */
	
/* 	height:200px; */
/*     width:400px;  */
/*     text-align: center; */
/*     margin-left:50%;  */
/*     margin-right:50%; */
/* } */

 .flex-container, footer{
       display: flex;
       justify-content: center;
        
   }
   
   #header{
/*       border: 3px red solid; */
      width: 1300px;
      height: 200px;
   }
   
   #footer{
/*       border: 3px blue solid; */
      width: 1300px;
      height: 100px;
   }
   
/* .loginform{ */
/*     text-align: center; */
/*   	display: flex;  */
/* } */

th{
  height: 70px;
}
</style>
</head>
<body style="background-image: url('../images/body-bg.jpg');">

   <header class="flex-container">
      <div id="header"></div>
   </header>
   
   <main class="flex-container">
   
         <div style="height: 350px; width: 1300px;"class="font">
         
      <div style="margin-left: 35px; margin-top:30px;">
      <img src="${pageContext.request.contextPath }/images/bear.jpg" style="width: 80px;height:80px;margin-left: 665px;margin-bottom: 5px;"><br/>
      <form action="${pageContext.request.contextPath }/member/login.do" method="post">
      <table style="margin-left: 440px;">
      <tr>
         <td colspan="2">
         <a href="${pageContext.request.contextPath }/restaurant/getall.do"><input type="button" value="홈으로" style="color: black; margin-left: 207px;"></a>
         <a href="${pageContext.request.contextPath }/member/add.do"><input type="button" value="회원가입" style="color: black;"></a>
         </td>
      </tr>
      <tr>
         <th>아&nbsp;이&nbsp;디</th>
         <td><input type="text" name="id" style="width: 270px; height: 25px;">
         </td>
      </tr>
	  <tr>
	     <th style="padding-right: 10px;">비밀번호</th>
	     <td><input type="password" name="pwd" style="width: 270px; height: 25px;"></td></tr>
      <tr><th colspan="2"><input type="submit" value="로그인" style="margin-left: 167px; margin-bottom: 30px;"></th></tr>
      </table>
      </form>
      </div>

</div>
   </main>
  

</body>
</html>
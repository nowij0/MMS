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


h3 { text-align: center; }


th,td {
  padding: 6px 15px;
}

th {
  
  color:black;
  background: #F2B84B;
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
<script type="text/javascript">
const entrance =(count)=>{
	const xhttp = new XMLHttpRequest();
		 document.getElementById("finish"+count).style.visibility = "hidden";
		 let resSeq = document.getElementById("resSeq_"+count).value;
		 let param = "resSeq="+resSeq;
		 
         xhttp.open("post", "${pageContext.request.contextPath }/reservation/editEntrance.do");
         xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
   // 4. 요청보냄
         xhttp.send(param);

         xhttp.onload = () => {
        	
        	let list = JSON.parse(xhttp.responseText);
          	console.log(xhttp.responseText);
            for(let obj of list){
           	if(obj.entrance == 1){
           		document.getElementById("finish"+count).style.visibility = "hidden";
            	}
            }      
         }
        }
const infoentrance =()=>{
	let msg = "호출을 요청했습니다.";
	alert(msg);
}        
        
const cancel = (resSeq) =>{
	location.href = "${pageContext.request.contextPath }/reservation/delete.do?resSeq="+resSeq;
}
</script>
</head>
<body style="background-image: url('../images/body-bg.jpg');">
<header class="flex-container">
   <div id="header"></div>
</header>
   
   <main class="flex-container">
  <div style="height: 800px; margin-top: 0px; width: 1300px;margin-bottom:0px;" class ="font">
				<div>
					<%@include file ="../header.jsp" %>
      <h3>우리식당 줄서기(예약) 목록</h3>
      <br/><br/>
      <table border="1" style = "width:1000px; text-align:center;margin-left:150px">
      <tr>
      	<th style = "width:150px">목록</th>
      	<th>연락처</th>
      	<th>인원수</th>
      	<th>호출</th>
      	<th>입장여부</th>
      	<th>입장확인</th>
      	<th>입장취소</th>
      </tr>
       <c:forEach var="vo" items="${list }" varStatus = "status" >
        <input type ="hidden"  value ="${vo.resSeq }" id = "resSeq_${status.count }">
       <tr>
       <td>${status.count }</td>
       <td>${vo.tel }</td>
       <td>${vo.people }</td>
       <td><input type = "button" value = "호출하기" onclick = "infoentrance()">
       <td><c:if test="${vo.entrance == 1}">입장</c:if>
		   <c:if test="${vo.entrance == 2}">미입장</c:if>
	   </td>
	   <c:if test="${vo.entrance != 1}">
       <td id = "finish${status.count}"><input type = "button" value = "입장 확인" onclick = "entrance(${status.count})"></td>
       </c:if>
       <td><input type = "button" value = "입장 취소" onclick = "cancel(${vo.resSeq})"></td>
       </tr>
       </c:forEach>
      </table>
      </div>
      </div>
      </div>
   </main>
   <footer>
       <%@include file = "../footer.jsp" %>
   </footer>
</body>
</html>
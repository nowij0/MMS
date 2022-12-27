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
<script type ="text/javascript">

const edit = (recSeq) => {
	location.href = "${pageContext.request.contextPath }/recommend/edit.do?recSeq="+recSeq;
}
const del = (recSeq) => {
	location.href = "${pageContext.request.contextPath }/recommend/delete.do?recSeq="+recSeq;
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
      <h3>추천게시판 상세내용</h3>
      <br/><br/>
       <div style = "height:800px">
      <form action="${pageContext.request.contextPath }/recommend/edit.do" method="post" name="f"
       enctype="multipart/form-data">
      <table border="1">
       <tr>
       <th colspan ="2"><a href="${pageContext.request.contextPath }/recommend/list.do" style = "float:right;color:black" >목록으로 돌아가기</a></th>
      </tr>
      <tr>
      	<th>글번호</th><td><input type = "text" name = "recSeq" value = "${vo.recSeq }" readonly
      	style = "float:left"></td>
      </tr>
      <tr>
      	<th>작성자</th><td><input type="text" name="writer" value="${vo.writer }" readonly
      	style = "float:left"></td></tr>
      <tr>	
      	<th>제목</th><td><input type="text" name="title" value="${vo.title }" ${str } readonly 
      	style = "float:left;"></td></tr>
      <tr>
      	<th>작성일</th><td><input type="text" name="wDate" value ="${vo.WDate }" readonly
      	style = "float:left"></td></tr>
      <tr>
      	<th>글내용</th><td><textarea rows ="20" cols ="50" name ="content" style ="float:left;height:100px" placeholder="${vo.content }" readonly></textarea></td></tr>
      <tr><th>이미지</th>
      <td><img src ="${vo.imgFolder}" style="width:300px;height:200px;float:left"></img><br/>
   	  </tr>
	  <tr>
	  	<th>조회수</th><td style = "text-align:left">${vo.cnt }</td>
	  </tr>
	  	<c:if test="${sessionScope.loginId == vo.writer }">
	 	<tr><th>수정/삭제</th>
		<td><input type="button" value="수정" id = "btn1" style ="float:left" onclick="edit(${vo.recSeq})">
			<input type="button" value="삭제" id = "btn2" style ="float:left" onclick="del(${vo.recSeq})"> </tr>
		</c:if>	
      </table>
      <input type="hidden" name="imgFolder" value="${vo.imgFolder }">
      </form>
      </div>
      </div>
      </div>
   </main>
	 <footer><%@include file ="../footer.jsp" %></footer>
</body>
</html>
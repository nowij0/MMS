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

h3 { text-align: center; }

#btn_1, #btn_2 {
  font-size:14px;
  padding:10px 15px;
  border:1px solid #ddd;
  background-color:#0a76b7;
  border-radius:5px;
  color:#fff;
  font-weight:bold;
}

h3, div { text-align: center; }

div { font-weight: bold; }
</style>
<script>
	const out = (id) => {
		alert("회원 탈퇴 완료");
		location.href="${pageContext.request.contextPath}/member/out.do?id=" + id;
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
			<h3>회원정보수정</h3>
			<br/><br/>
			<form action="${pageContext.request.contextPath }/member/edit.do" method="post">
				<div>회원 ID</div><input type="text" value="${vo.id }" name="id" readonly><br />
				<div>이름(or 별명)</div><input type="text" value="${vo.name }" name="name"><br />
				<div>비밀번호</div><input type="text" value="${vo.pwd }" name="pwd"><br />
				<div>연락처</div><input type="text" value="${vo.tel }" name="tel"><br />
				<div>이메일</div><input type="text" value="${vo.email }" name="email"><br /><br>
				<input type="hidden" value="${vo.memberSeq }" name="memberSeq">
				<input type="submit" id="btn_1" value="수정">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" id="btn_2" value="탈퇴" onclick="out('${vo.id }')">
			</form>
		</div>
      </div>
   </main>
   
    <footer><%@include file ="../footer.jsp" %></footer>

</body>
</html>

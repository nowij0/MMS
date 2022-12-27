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
	background-color:#D95E32;
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
	width:50%; 
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
  color: #fff;
  text-align: center;
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
            <table style="float: right">
            <c:if test="${sessionScope.loginId==null }">
               <ul class="nav nav-tabs" style="background-color: #F2B84B; font-family: IBM Plex Sans KR; padding-right: 50px;padding-left: 50px">
                  <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/recommend/list.do">추천게시판</a></li>
                  <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/member/login.do">로그인</a></li>
                  <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/member/add.do">회원가입</a></li>
               </ul>
              </c:if>
               <c:if test="${sessionScope.loginId!=null }">
               <ul class="nav nav-tabs" style="background-color: #F2B84B; font-family: IBM Plex Sans KR">
                  <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/recommend/list.do">추천게시판</a></li>
              	  <c:if test="${sessionScope.type==2 }">	
              	  <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/restaurant/listByMemberSeq.do?memberSeq=${sessionScope.memberSeq}">내 가게 리스트</a></li>
				  <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/member/detail.do?id=${sessionScope.loginId}">내정보(판매자)</a></li>              	 
              	  </c:if>
              	  <c:if test="${sessionScope.type==1 }">
              	  <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/member/detail.do?id=${sessionScope.loginId}">내정보(구매자)</a>
              	  </c:if>
              	  <c:if test="${sessionScope.type==0 }">
              	  <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/member/listAdmin.do">관리기능</a>
              	  </c:if>
                  <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/member/detail.do?id=${sessionScope.loginId}">회원정보수정</a></li>
                  <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/member/logout.do">로그아웃</a></li>
               </ul>
              </c:if>  
            </table> 
			<h3>회원정보</h3>
			<nav id="menubar">
				<a href="${pageContext.request.contextPath }/member/edit.do?id=${sessionScope.loginId}">회원정보수정</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/reservation/list.do">줄서기(예약) 내역</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/review/list2.do">게시글 작성내역</a>
			</nav>
			<hr>
			<table border="1">
				<tr>
					<th>아이디</th>
					<td>${vo.id }</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${vo.name }</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>${vo.pwd }</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>${vo.tel }</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${vo.email }</td>
				</tr>
				<tr>
					<th>회원유형</th>
					<td>${vo.type }</td>
				</tr>
			</table>
		</div>
      </div>
   </main>
   
   <footer>
      <div id="footer"></div>
   </footer>

</body>
</html>

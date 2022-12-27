<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>		
			<div>
				<table style="float: right">
					<c:if test="${sessionScope.loginId==null }">
						<ul class="nav nav-tabs"
							style="background-color: #F2B84B; font-family: IBM Plex Sans KR; padding-right: 50px; padding-left: 50px">
							<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/restaurant/getall.do">홈으로</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath }/recommend/list.do">추천게시판</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath }/member/login.do">로그인</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath }/member/add.do">회원가입</a></li>
						</ul>
					</c:if>
					<c:if test="${sessionScope.loginId!=null }">
						<ul class="nav nav-tabs"
							style="background-color: #F2B84B; font-family: IBM Plex Sans KR">
                    		 <li class="nav-item"><a class="nav-link" style ="color:black">${sessionScope.loginId }님 로그인</a></li>
							<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/restaurant/getall.do">홈으로</a></li>
							<c:if test="${sessionScope.type==2 }">
								<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath }/recommend/list.do">추천게시판</a></li>
								<li class="nav-item"><a class="nav-link"
									href="${pageContext.request.contextPath }/restaurant/listByMemberSeq.do?memberSeq=${sessionScope.memberSeq}">내
										가게 리스트</a></li>
								<li class="nav-item"><a class="nav-link"
									href="${pageContext.request.contextPath }/member/detail.do?id=${sessionScope.loginId}">내정보(가게회원)</a></li>
							</c:if>
							<c:if test="${sessionScope.type==1 }">
								<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath }/recommend/list.do">추천게시판</a></li>
								<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath }/review/list2.do">리뷰작성목록</a></li>
								<li class="nav-item"><a class="nav-link"
									href="${pageContext.request.contextPath }/member/detail.do?id=${sessionScope.loginId}">내정보(일반회원)</a>
							</c:if>
							<c:if test="${sessionScope.type==0 }"> 
									<li class="nav-item"><a class="nav-link"
									href="${pageContext.request.contextPath }/member/listAdmin.do">회원목록조회</a></li>
								<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath }/recommend/admin.do">추천게시판(관리)</a></li>
							</c:if>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath }/member/logout.do">로그아웃</a></li>
								
						</ul>
					</c:if>
					
             
				</table>
				
				</div>
				

</body>
</html>
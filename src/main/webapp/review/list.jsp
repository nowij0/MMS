<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무맛소</title>
<link href="${pageContext.request.contextPath }/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/style.css" rel="stylesheet">
<style type="text/css">
	.flex-container, footer{
		 display: flex;
 		 justify-content: center;
 		 text-align: center;
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
	
	.list{
		border: 1px solid black; 
		height: 1200px; 
		width: 1300px;
	}
	
	#myform fieldset{
    display: inline-block; /* 하위 별점 이미지들이 있는 영역만 자리를 차지함.*/
    border: 0; /* 필드셋 테두리 제거 */
	}
	#myform input[type=radio]{
	    display: none; /* 라디오박스 감춤 */
	}
	#myform label{
	    font-size: 18px; /* 이모지 크기 */
	    color: transparent; /* 기존 이모지 컬러 제거 */
	    text-shadow: 0 0 0 #f0f0f0; /* 새 이모지 색상 부여 */
	}
	
	#myform label:hover{
    text-shadow: 0 0 0 #FFC83D; /* 마우스 호버 */
	}
	#myform label:hover ~ label{
	    text-shadow: 0 0 0 #FFC83D; /* 마우스 호버 뒤에오는 이모지들 */
	}
	
	#myform fieldset{
    display: inline-block; /* 하위 별점 이미지들이 있는 영역만 자리를 차지함.*/
    direction: rtl; /* 이모지 순서 반전 */
    border: 0; /* 필드셋 테두리 제거 */
	}
	
	#myform input[type=radio]:checked ~ label{
    text-shadow: 0 0 0 #FFC83D; /* 마우스 클릭 체크 */
	}
	
	input[ytpe=text]{
	width: 500px;
	height: 30px;
	font-size: 13px;
	border: 0;
  	border-radius: 15px;
  	outline: none;
  	padding-left: 10px;
  	background-color: rgb(233, 233, 233);
	}	
	
	.menu_a{
	float:left;
	padding-top: 80px;
	padding-left: 20px;
	padding-right: 20px;
	margin: 0 10px;
}	

	.reviewList{
		margin-top: 50px; 
		margin-left: auto;
		margin-bottom: 50px;
	}
</style>
<script>
	const mkDiv = (object) => {
	   	//저장할 div 만들기
		let rDiv = document.createElement("div");
	   	rDiv.setAttribute("id", "list_" + object.reviewSeq);

	   	//내용물출력
	   	let grade = object.grade;
	   	let star;
	   	if(grade == 1){
	   		star = "⭐";
	   	} else if (grade == 2){
	   		star = "⭐⭐";
	   	} else if (grade == 3){
	   		star = "⭐⭐⭐";
	   	} else if (grade == 4){
	   		star = "⭐⭐⭐⭐";
	   	} else if (grade == 5){
	   		star = "⭐⭐⭐⭐⭐";
	   	}
	   	
	   	let html = "<div id='list_'" + object.reviewSeq+">";
	   	html += "<div id='grade'>" + star +"</div>";
	   	html += object.content+"(작성자:"+object.writer+")</div>";
	   
	   	//작성자와 로그인사용자가 동일하면 수정/삭제 버튼 생성
	   	let writer = object.writer;
	   	let loginId = '${sessionScope.loginId }';
	   	if(writer==loginId){
	   		html += "<input type='button' value='삭제' onclick=reviewDel("+object.reviewSeq+")>";
	   	}
	   	html += "<br/>";
	   
	   	//작성한 내용 div 태그에 저장해서 return
	   	rDiv.innerHTML = html;
	   	return rDiv;
	}

	const addReview = (restSeq, reviewSeq) => {
		
		const xhttp = new XMLHttpRequest();
		xhttp.onload = () => {
			
			console.log(xhttp.responseText);
		    let div = document.getElementById("rest_"+restSeq);
			
			//받아온 ajax값 arr에 넣기
		    let arr = JSON.parse(xhttp.responseText);
		    div.innerHTML = "";
		    let html = "";
		    for(let object of arr){
		   		let review = mkDiv(object);
		   		div.appendChild(review);
		   	}
		    document.getElementById("revContext").value = " ";
		   //별점 지우기 고민 ... 
		}   
		
		//보내줘야할 값들 받아서, param에 저장
		let revContext = document.getElementById("revContext").value;
		let param = "restSeq="+restSeq;
		param += "&writer=${sessionScope.loginId}";
		param += "&grade="+myform.rating.value;
		param += "&content="+revContext;
		revContext="";
		
		//post방식으로 param을 /review/add.do(ReviewAdd)에 보내주기
		xhttp.open("post", "${pageContext.request.contextPath }/review/add.do");
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send(param);
	}
	
	const cancel = () => {
		let hiddenDiv = document.getElementById("hidden");
		let editForm = document.getElementById("edit_form");
		hiddenDiv.appendChild(editForm);
		editForm.style.display='none';
	}	
	const reviewDel = (reviewSeq) => {
		   let rDiv = document.getElementById("list_"+reviewSeq);
		   rDiv.remove();
		   
		   const xhttp = new XMLHttpRequest();
		   xhttp.open("post", "${pageContext.request.contextPath }/review/del.do");
		   xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		   xhttp.send("reviewSeq="+reviewSeq);
	}
</script>
</head>
<body style="background-image: url('../images/body-bg.jpg');">
	<header class="flex-container">
		<div id="header">
			
		</div>
	</header>
	
	<main class="flex-container">
		<div class="font" style="height: 800px; margin-top: 0px; width: 1300px; background-color:#F5DE83; margin-bottom:0px;">				
			<div id="menu"><%@include file ="/header.jsp" %> </div>
		
			<div id="rightSection" style="float:right; width:500px; margin-bottom: 100px;">
				
					<div id="reviewList"  style="width:500px; height:150px;  position: relative; top: 50px; text-align: center;">
						<form name="myform" id="myform"  style="text-align:center;">
						<fieldset>
							<input type="radio" name="rating" value="5" id="rate1"><label for="rate1">⭐</label>
						    <input type="radio" name="rating" value="4" id="rate2"><label for="rate2">⭐</label>
						    <input type="radio" name="rating" value="3" id="rate3"><label for="rate3">⭐</label>
						    <input type="radio" name="rating" value="2" id="rate4"><label for="rate4">⭐</label>
						    <input type="radio" name="rating" value="1" id="rate5"><label for="rate5">⭐</label>
						</fieldset>
						</form>
						<input type="text" id="revContext" >
						<input type="button" value="작성" onclick="addReview(${vo.restSeq})">		
					</div>
						
					<div id="rest_${vo.restSeq}" >
						<c:forEach var="reviewList" items="${reviewList }">
							<div id="list_${reviewList.reviewSeq }" style="text-align:center;">
								<div id="grade">
									<c:set var="grade" value="${reviewList.grade }"/>
									<c:choose>
										<c:when test="${grade eq 0}"></c:when>
										<c:when test="${grade eq 1}">⭐</c:when>
										<c:when test="${grade eq 2}">⭐⭐</c:when>
										<c:when test="${grade eq 3}">⭐⭐⭐</c:when>
										<c:when test="${grade eq 4}">⭐⭐⭐⭐</c:when>
										<c:when test="${grade eq 5}">⭐⭐⭐⭐⭐</c:when>
									</c:choose>
								</div>
								${reviewList.content }  (작성자: ${reviewList.writer })
								<c:if test="${reviewList.writer == sessionScope.loginId }">
								    <input type="button" value="삭제" onclick="reviewDel(${reviewList.reviewSeq })">
								</c:if>
							</div>				
						</c:forEach>
				</div>
			
			</div>
		
			<div id="leftSection" style="float: left; width: 800px;">
				<div id="restDetail" style="width:800px; height:200px; ">	<!-- 식당 상세 정보   -->
				<div id="center" style="width:400px; height:200px; justify-content: center; margin-top: 100px; margin-left: 200px;">
				<div style="positon:relative; left:300px;"><img src="${vo.imgPath}" style=" width:200px; height: 200px; float:left;"></div>
					<table border="1"  style="float:right; width:200px; height:200px;">
						<tr>
							<td>식당명</td>
							<td>${vo.name }</td>
						</tr>
						<tr>
							<td>분류</td>
							<td>${vo.category }</td>
						</tr>
						<tr>
							<td>주소</td>
							<td>${vo.address }</td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td>${vo.tel }</td>
						</tr>
						<tr>
							<td>영업 시간</td>
							<td>${vo.restOpenT } ~ ${vo.restCloseT }</td>
						</tr>
						<tr>
							<td>소개</td>
							<td>${vo.restIntro }</td>
						</tr>
					</table>
					</div>
				</div>
			 
				<div id="menuList" style="text-align: -webkit-center; width: 800px; height:400px;"><!--  식당  메뉴  --> 
					<table>
						<c:forEach var="menuList" items="${menuList }">
							<div class="menu_a">
								<img src="${menuList.imgPath }" style="width:100px; height:100px">
								<br/>이름 : ${menuList.name }<br/>가격 : ${menuList.price }원
							</div>
						</c:forEach>
					</table><br/>
				</div>
				
		</div>
		
			<div id="bottomSection" style="float:right; width:470px;  justify-content: center;" >
				<div id="addrNearList" >
				<h5 style="text-align: left;">주변 맛집  </h5>
			<c:forEach var="addrNearList" items="${addrNearList }">
			<div style="float:left; margin-right:0px;"><img src="${addrNearList.imgPath}" style=" width:130px; height: 148px;"></div>
			<table style="float:right; width: 300px; height:148px; text-align:left;">
			<tr>
				<td>${addrNearList.name }</td>
			</tr>
			<tr>
				<td>${addrNearList.category }</td>
			</tr>
			<tr>
				<td>${addrNearList.address }</td>
			</tr>
			<tr>
				<td>${addrNearList.tel }</td>
			</tr>
			<tr>
				<td>${addrNearList.restOpenT }시 ~ ${addrNearList.restCloseT }시 </td>
			</tr>
			<tr>
				<td>${addrNearList.restIntro }</td>
			</tr>
			</table>
			</c:forEach>
		</div>
			</div>
		</div>
	</main>
	
	<footer><%@include file ="../footer.jsp" %></footer>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/bootstrap-3.3.2-dist/css/bootstrap.min.css"
   rel="stylesheet">
   <link href="${pageContext.request.contextPath }/style.css" rel="stylesheet">
   
<style type="text/css">
   .flex-container, footer{
       display: flex;
        justify-content: center;
   }
   
   #header{
/*       border: 3px red solid; */
      width: 1300px;
      height: 180px;
   }
   
   #footer{
/*       border: 3px blue solid; */
      width: 1300px;
      height: 100px;
   }
   
  input[type="text"], input[type="password"]{
  	width:200px;
  	height:23px;
  }
   
</style>

<script type="text/javascript">
let idflag = false;
let pwdflag = false;
const checkId = () => {
	const xhttp = new XMLHttpRequest();
	xhttp.onload = () => {
		
	
	  let obj = JSON.parse(xhttp.responseText);
	  let div = document.getElementById("ch_res");
	  div.innerHTML = obj.msg; //응답 텍스트
// 	  if(obj.idflag){
// 		  idflag='true';
// 	  }
	  idflag = obj.idflag;
	}
	
	//먼저 id의 길이 검사
	let id = f.id.value;
	if(id.length<5){
		alert('5자이상 입력해주세요');
		f.id.select();
		return;
	}
	let param = "id="+f.id.value;
	xhttp.open("post", "${pageContext.request.contextPath }/member/idcheck.do");
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(param);
}

const checkPwd = () =>{
	let pwd = f.pwd1.value;
	if(pwd.length<4){
		alert('비밀번호는 4자이상');
		f.pwd1.select();
		return;
	}
	if(f.pwd1.value ==f.pwd2.value){
		pwdflag = true;
		alert("비밀번호 확인 완료");
	}else{
		alert("비밀번호가 일치하지 않습니다");
		f.pwd1.select();
	}
}


const join = () =>{
	if(!idflag){
		alert('아이디 중복확인을 해주세요');
		return;
	}
	
	if(!pwdflag){
		alert('비밀번호를 입력해주세요');
		return;
	}
	
	f.submit();//전송
	alert("가입이 완료되었습니다")
}




</script>

</head>
<body class="font" style="background-image: url('../images/body-bg.jpg');">

   <header class="flex-container">
      <div id="header"></div>
   </header>
   
   <main class="flex-container">
      <div style="height: 500px; width: 1300px;">
<div>   
<form action="${pageContext.request.contextPath }/member/add.do" method="post" name="f">

<table style="width: 400px; height: 410px; margin-left: 440px;">

<tr>
<td colspan="2">
<img src="${pageContext.request.contextPath }/images/bear.jpg" style="width: 80px;height:80px;margin-left: 173px; margin-top:20px;"></td>
</tr>
<tr>
<td colspan="2">
<a href="${pageContext.request.contextPath }/restaurant/getall.do">
<input type="button" value="홈으로" style="width:70px;color: black;margin-left: 180px;margin-bottom: 30px;"></a>
</td></tr>
<tr><th>회&nbsp;원&nbsp;타&nbsp;입</th>
	<td>
		<input type="radio" name="type" value="1" checked>일반회원
		<input type="radio" name="type" value="2">가게회원
	</td>
</tr>
<tr><th>아&nbsp;&nbsp;이&nbsp;&nbsp;디</th><td><input type="text" name="id"><input type="button" value="중복체크" onclick="checkId()" style="width: 69px; margin-left: 6px;">
<div id="ch_res"></div>
</td></tr>
<tr><th>비&nbsp;밀&nbsp;번&nbsp;호</th><td><input type="password" name="pwd1" style="width: 275px;"></td></tr>
<tr><th>비밀번호확인</th><td><input type="password" name="pwd2">
<input type="button" value="확인" onclick="checkPwd()" style="width:69px; margin-left: 3px;"></td></tr>
<tr><th>이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름</th><td><input type="text" name="name" style="width: 275px;"></td></tr>
<tr><th>전&nbsp;화&nbsp;번&nbsp;호</th><td><input type="text" name="tel" style="width: 275px;"></td></tr>
<tr><th>이&nbsp;&nbsp;메&nbsp;&nbsp;일</th><td><input type="text" name="email" style="width: 275px;"></td></tr>

<tr><th colspan="2"><input type="button" value="가입완료" onclick="join()"style="width:70px;margin-left: 85px;margin-top: 10px;"></th></tr>
</table>
</form>
</div>
      </div>
   </main>
   

</body>
</html>
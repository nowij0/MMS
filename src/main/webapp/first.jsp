<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MMS</title>
<style>
	.wrapper {
	  display: flex;
	  justify-content: center;
	  align-items: center;
	  min-height: 100vh;
	}
</style>
<script>
	const pop = () => {
		bear.style.display="none";
		start.style.display="";
	}
</script>
</head>
<body>

<div class="wrapper">
	<div class="content">
		<span onclick="pop()">
			<img id="bear" src="${pageContext.request.contextPath }/images/bear.jpg" style="width:150px; height: 150px; display:block;">
		</span>
		<a href="${pageContext.request.contextPath }/restaurant/getall.do">
			<img id="start" src="${pageContext.request.contextPath }/images/first.jpg" style="width:800px; height: 350px; display: none;">
		</a>
	</div>
</div>
</body>
</html>
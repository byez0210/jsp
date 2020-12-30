<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<%-- 개인정보를 전송하므로 url에 노출되지 않도록 request body영역에 파라미터를 전송 ==> method="POST" --%>
	<form action="<%=request.getContextPath() %>/loginController" method="post">
		user id : <input type="text" name="userid" value="test"><br>
		user id : <input type="text" name="userid" value="test1"><br>
		password : <input type="password" name="pass" value="1234"><br> 
		<input type="submit" value="전송">
	</form>
</body>
</html>
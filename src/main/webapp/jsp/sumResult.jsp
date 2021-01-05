<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=session.getAttribute("num1") %> 부터
	<%=session.getAttribute("num2") %>  까지의 합은 ?
	<%=session.getAttribute("sumResult") %>
</body>
</html>
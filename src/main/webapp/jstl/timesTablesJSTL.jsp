<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 100%;
}
td {
	border : 1px solid black;
	text-align : center;
	height: 50px;
}
</style>
</head>
<body>
	
<table>
	<c:forEach begin="1" end="9" var="j">
		<tr>
			<c:forEach begin="2" end="9" var="i">
				<td>
					${i} * ${j} = ${i*j}
				</td>
			</c:forEach>
		</tr>
	</c:forEach>
</table>
		
</body>
</html>
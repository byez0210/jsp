<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	}
</style>
</head>
<body>
	<table>
		<% for (int j =1; j<= 9; j++){ %>
		<tr>
			<% for (int i= 2; i<= 9; i++){ %>
				<td>
					<%=  i %> * <%=j %>  = <%= i*j %> 	
				</td>
			<% }%>
			</tr>
		<% }%>
	</table>
</body>
</html>
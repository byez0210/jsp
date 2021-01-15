<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 서버에 등록된 자원을 요청할 떼 가져오는 객체
		InitialContext context = new InitialContext();
		
		//서버에 등록된 컨넥션 풀 자원 요청
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oracleDB");
		
		//시작
		long startTime = System.currentTimeMillis();
		
		//컨넥션을 데이터 소스로부터 얻고 반환하는 반복작업
		for ( int i =0; i< 30; i++){
			Connection connection =  ds.getConnection();
			connection.close();
			
		}
		// 종료 (작업시간확인)
		long endTime =  System.currentTimeMillis();
		out.print("duration : " +(endTime-startTime)); 
	%>

</body>
</html>
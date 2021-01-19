<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--page scope에 속성이름 price, 값은 1000000 추가 --%>
<%
	//pageContext.setAttribute("price", 100000);
%>
<c:set var="price" value="100000"/> <%-- 100000(숫자) => 100,000(문자) --%>
<c:set var="priceStr" value="100,000"/> <%-- 100,000(문자) => 100000(숫자) --%>
price : ${price } <br>
price fmt : <fmt:formatNumber value="${price }" /> <br>
price fmt number : <fmt:formatNumber value="${price }" type="number"/> <br>
price fmt currency : <fmt:formatNumber value="${price }" type="currency"/> <br>
price fmt percent : <fmt:formatNumber value="${price }" type="percent"/> <br>
price fmt pattern : <fmt:formatNumber value="${price }" pattern="00000000000.00"/> <br>
priceStr parse : <fmt:parseNumber value="${priceStr }" /> <br>


<h3>de_germany</h3>
<fmt:setLocale value="de"/>
price : ${price } <br>
price fmt : <fmt:formatNumber value="${price }" /> <br>
price fmt number : <fmt:formatNumber value="${price }" type="number"/> <br>
price fmt currency : <fmt:formatNumber value="${price }" type="currency"/> <br>
price fmt percent : <fmt:formatNumber value="${price }" type="percent"/> <br>
price fmt pattern : <fmt:formatNumber value="${price }" pattern="00000000000.00"/> <br>
</body>
</html>
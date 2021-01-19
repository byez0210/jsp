<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/common_lib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$(".lang").on(change, function(){
		${"#frm"}
	})
})
</script>
</head>
<body>
<form id ="" action="${context. }">
	<select class="lang" onchange="changeLangSelect()">
		<option value="ko">한국어</option>
		<option value="en">english</option>
		<option value="ja">日本語</option>
		<option>기타</option>
	</select>
</form>
<br><br>

<%-- select box로 설정한 언어로 GREETING.LANG값 표현 
	 select box는 사용자가 설정한 언어 값으로 선택이 되어있게 설정 --%>
<fmt:setLocale value="en"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="LANG"/> 	<br>
		<fmt:message key="GREETTING">
			<fmt:param value="brown"/>
		</fmt:message>	<br>
	</fmt:bundle>
</body>
</html>
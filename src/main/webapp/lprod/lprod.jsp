<%@page import="kr.or.ddit.lprod.model.LprodVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
List<LprodVo> lprodList = (List<LprodVo>) request.getAttribute("lprodList");
%>
[
	<%
	for (int i = 0; i < lprodList.size(); i++) {
		LprodVo vo = lprodList.get(i);
		if (i > 0)
			out.print(",");
	%>
		{ 
			"Lprod_id" : "<%=vo.getLprod_id()%>", 
		 	"Lprod_nm" : "<%=vo.getLprod_nm()%>",
		 	"Lprod_gu" : "<%=vo.getLprod_gu()%>"
		   }
	<%
	}
	%>
]

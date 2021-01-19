
<%@page import="kr.or.ddit.lprod.model.LprodVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<%@ include file="/common/common_lib.jsp"%>

<link href="${cp} /css/dashboard.css"rel="stylesheet">
<link href="${cp}/css/blog.css" rel="stylesheet">

<script type="text/javascript">

	$(function() {
		$.ajax({
			url : '/allLprod',
			type : 'get',
			dataType : 'json',
			success : function(res) {
				code = "<table class=table table-striped>";
				code += "<tr>";
				code += "<th>제품 아이디</th>";
				code += "<th>제품 번호</th>";
				code += "<th>제품 별명</th>";
				code += "</tr>";
				$.each(res, function(i, v) {
					code += "<tr>";
					code += "<td>" + v.Lprod_id + "</td>";
					code += "<td>" + v.Lprod_nm + "</td>";
					code += "<td>" + v.Lprod_gu + "</td>";
					code += "</tr>";
				})
				code += "</table>";
				$("#tt").html(code);
			},
		error : function(xhr) {
			alert("상태 :" + xhr.status)
		}
		})
	});
</script>
</head>

<body>

	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/common/left.jsp"%>
			</div>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


			<div class="row">
				<div class="col-sm-8 blog-main">
					<h2 class="sub-header">사용자</h2>
					<div class="table-responsive" id="tt">
						
					</div>

					<a class="btn btn-default pull-right">사용자 등록</a>

					<div class="text-center">
						<ul class="pagination">
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

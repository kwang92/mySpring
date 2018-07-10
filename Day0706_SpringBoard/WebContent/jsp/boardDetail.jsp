<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% request.setAttribute("path", request.getContextPath()); %>
<link rel="stylesheet" type="text/css" href="${path}/css/mainForm.css">
</head>
<body>
	<jsp:include page="/jsp/head.jsp"/>
	<div id = "wrap" align = "center">
		<table>
			<tr>
				<th>제목</th>
				<td>${brd.title}</td>
				<th>조회수</th>
				<td>${brd.readCount}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${brd.name}</td>
				<th>이메일</th>
				<td>${brd.email}</td>
			</tr>
			<tr>
				<td colspan = "4">제목</td>
			</tr>
			<tr>
				<td colspan = "4">${brd.title}</td>
			</tr>
			<tr>
				<td colspan = "4">
					${brd.content}
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
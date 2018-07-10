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
	<div id = "wrap">
		<form action = "join">
			<table>
				<tr>
					<th>아이디 </th>
					<td><input type = "text" name = "ID" id = "ID"></td>
				</tr>
				<tr>
					<th>비밀번호 </th>
					<td><input type = "password" name = "PASSWORD" id = "PASSWORD"></td>
				</tr>
				<tr>
					<th>이름 </th>
					<td><input type = "text" name = "NAME" id = "NAME"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type = "text" name = "EMAIL" id = "EMAIL"></td>
				</tr>
				<tr>
					<td><input type = "button" value = "취소" onclick = "location.href = history.back(-1);"></td>
					<td><input type = "submit" value = "회원가입"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "wrap">
		<h2>회원가입</h2>
		<form action = "join">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type = "text" name = "ID" autofocus></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type = "password" name = "PASSWORD"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type = "text" name = "NAME"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type = "text" name = "EMAIL"></td>
				</tr>
				<tr>
					<td colspan = "2">
						<input type = "submit" value = "회원가입">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
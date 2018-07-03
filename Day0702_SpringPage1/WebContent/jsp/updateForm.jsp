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
		<form action = "update">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type = "text" name = "ID" value = "${member.ID}"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type = "password" name = "PASSWORD" value = "${member.PASSWORD}"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type = "text" name = "NAME" value = "${member.NAME}"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type = "text" name = "EMAIL" value = "${member.EMAIL}"></td>
				</tr>
				<tr>
					<td>
						<input type = "submit" value = "수정">
					</td>
					<td>
						<input type = "button" value = "뒤로가기" onclick = "history.back(-1);">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
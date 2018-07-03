<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "wrap" align = "center">
		<form action = "login">
			<h2>Login</h2>
			<table>
				<tr>
					<th>아이디</th>
					<td colspan = "2"><input type = "text" name = "id" placeholder = "아이디입력" autofocus></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td colspan = "2"><input type = "password" name = "password" placeholder = "비밀번호 입력"></td>
				</tr>
				<tr>
					<td>
						<input type = "button" value = "회원가입" onclick = "location.href = 'joinForm'">
					</td>
					<td>
						<input type = "submit" value = "로그인">
					</td>
					<td>
						<input type = "button" value = "메인으로" onclick = "location.href = 'main'">	
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
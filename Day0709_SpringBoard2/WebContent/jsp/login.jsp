<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap" align="center">
		<div id="content" style = "width : 480px; margin-top : 300px;">
			<form action="checkMember" method="post">
				<fieldset>
					<legend>로그인</legend>
					<table>
						<tr>
							<th>아이디</th>
							<td><input type="text" name="ID"></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="PWD"></td>
						</tr>
						<tr>
							<td><input type="button" value="뒤로가기"
								onclick="history.back(-1);"></td>
							<td><input type="submit" value="로그인"></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>
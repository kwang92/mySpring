<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setAttribute("path", request.getContextPath()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% request.setAttribute("path", request.getContextPath()); %>
<link rel="stylesheet" type="text/css" href="${path}/css/mainForm.css">
</head>
<body>
	<div id="total" style = "width : 100%">
		<jsp:include page="/jsp/head.jsp" />
		<div id="wrap" align="center" style="width: 760px; margin : 0 auto;">
			<fieldset>
				<legend>로그인</legend>
				<form action="${path}/member/login">
					<table>
						<tr>
							<td>아이디</td>
							<td><input type="text" id="id" name="ID"></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" id="password" name="PASSWORD"></td>
						</tr>
					</table>
					<input type="button" value="뒤로가기" onclick="history.back(-1);">
					<input type="button" value="회원가입"
						onclick="location.href = '${path}/member/joinForm'"> <input
						type="submit" value="로그인">
				</form>
			</fieldset>
		</div>
	</div>
</body>
</html>
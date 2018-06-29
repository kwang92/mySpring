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
		<form action = "../My/test.do">
			<table>
				<tr>
					<th>번호입력</th>
					<td><input type = "text" name = "SNUM"></td>
				</tr>
				<tr>
					<th>이름입력</th>
					<td><input type = "text"  name = "SNAME"></td>
				</tr>
				<tr>
					<th>학년입력</th>
					<td><input type = "text" name = "SGRADE"></td>
				</tr>
				<tr>
					<td colspan = "2"><input type = "submit" value = "추가"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
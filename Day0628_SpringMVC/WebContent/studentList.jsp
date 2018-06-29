<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생정보</title>
</head>
<body>
	<h1>test</h1>
	<table>
		<c:forEach items="${studentList}" var="stu">
			<tr>
				<td>${stu.sname}</td>
				<td>${stu.snum} </td>
				<td>${stu.sgrade}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
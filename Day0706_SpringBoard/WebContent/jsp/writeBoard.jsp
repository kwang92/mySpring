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
	<div id="total" style = "width : 100%;">
		<jsp:include page="/jsp/head.jsp" />
		<div id="wrap" align="center" style="margin-top: 100px; width : 780px; margin : 0 auto;">
			<form action="writeBoard">
				<table>
					<tr>
						<th>제목</th>
						<td><input type="text" name="TITLE" id="title"></td>
					</tr>
					<tr>
						<th colspan="2">내용</th>
					</tr>
					<tr>
						<td colspan="2"><textarea rows="50" cols="100" name="CONTENT">
						
						</textarea></td>
					</tr>
					<tr>
						<td><input type="button" value="취소"
							onclick="location.href = history.back(-1);"> <input
							type="submit" value="등록"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
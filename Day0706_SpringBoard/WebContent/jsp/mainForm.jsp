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
	<div id = "total" style = "width : 100%">
		<jsp:include page="/jsp/head.jsp"/>
		<div id = "wrap" align = "center" style = "margin : 0 auto;">
		메인페이지입니다ㅣ
		</div>
	</div>
</body>
</html>
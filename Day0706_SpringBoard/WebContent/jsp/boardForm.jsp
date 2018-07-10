<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% request.setAttribute("path", request.getContextPath()); %>
<link rel="stylesheet" type="text/css" href="${path}/css/mainForm.css">
<style type="text/css">
th, td {
	border: 1px solid black;
	padding: 10px;
	width: 90px;
}

#title {
	width: 200px;
}

#view {
	width: 50px;
}
</style>
</head>
<body>
	<jsp:include page="/jsp/head.jsp" />
	<hr>
	<div id="wrap" align="center" style="width: 100%">
		<table>
			<tr>
				<th>게시번호</th>
				<th id="title">제목</th>
				<th>작성자</th>
				<th id="view">조회수</th>
				<th></th>
			</tr>
			<c:forEach items="${viewData.bList}" var="board">
				<tr>
					<td>${board.num}</td>
					<td><a href="viewDetail?num=${board.num}">${board.title}</a></td>
					<td>${board.name}</td>
					<td>${board.readCount}</td>
					<td><c:if test="${board.id == user.id}">
							<input type="button" value="삭제"
								onclick="location.href = 'delBoard?num=${board.num}'">
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<%--여기에 네비게이션 표시  --%>
		<!-- 처음 이전  1 2 3 4 5 6 7 8 9 10 다음  마지막 -->
		<!-- 1 2 3 4 5 다음 마지막 -->
		<!-- 처음 이전    11  12  13     20 -->
		<c:if test="${viewData.startPage !=1 }">
			<a href="messageList?page=1">[처음]</a>
			<a href="messageList?page=${viewData.startPage-1}">[이전]</a>
		</c:if>
		<c:forEach var="pageNum" begin="${viewData.startPage}"
			end="${viewData.endPage < viewData.pageTotalCount ? viewData.endPage : viewData.pageTotalCount}">
			<c:choose>
				<c:when test="${pageNum == viewData.currentPage}">
					<b>[${pageNum}]</b>
				</c:when>
				<c:otherwise>
					<a href="messageList?page=${pageNum}">[${pageNum}]</a>
				</c:otherwise>
			</c:choose>


		</c:forEach>
		<c:if test="${viewData.endPage < viewData.pageTotalCount}">
			<a href="messageList?page=${viewData.endPage+1}">[다음]</a>
			<a href="messageList?page=${viewData.pageTotalCount}">[마지막]</a>
		</c:if>
		<hr>
		<input type="button" value="글쓰기" onclick="location.href = 'writeForm'">
	</div>
</body>
</html>
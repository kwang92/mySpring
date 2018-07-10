<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%request.setAttribute("contextPath", request.getContextPath());%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/board.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script type = "text/javascript">
	$(function(){
		var url;
		if(!('${user}')){
			$("#inOut").val("로그인");
			url = '${contextPath}/member/loginForm';
		} else{
			$("#inOut").val("로그아웃");
			url = '${contextPath}/member/logout';
		}
		$("#inOut").on('click',function(){
			location.href = url;
		});
	});

</script>
</head>
<body>
	<div class="wrap" align="center">
		<table class="list">
			<tr>
				<td colspan="4" style = "border-right : 0"><a href="write">게시글 등록</a></td>
				<td style = "text-align: right; border-left : 0"><input type = "button" id = "inOut" value = "로그인"></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>

			<c:forEach items="${viewData.boardList}" var="board">
				<tr>
					<td>${board.RNUM}</td>
					<td><a href="view?num=${board.NUM}">${board.TITLE} <c:if
								test="${board.RCOUNT > 0}"> [${board.RCOUNT}]</c:if>
					</a></td>
					<td>${board.NAME}</td>
					<td>${board.WRITEDATE}</td>
					<td>${board.READCOUNT}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5"><c:if test="${viewData.startPage !=1 }">
						<a href="boardList?page=1
							<c:if test="${viewData.type != null}">&type=${viewData.type}</c:if>
							<c:if test="${viewData.keyword != null}">&keyword=${viewData.keyword}</c:if>
						">[처음]</a>
						<a href="boardList?page=${viewData.startPage-1}
							<c:if test="${viewData.type != null}">&type=${viewData.type}</c:if>
							<c:if test="${viewData.keyword != null}">&keyword=${viewData.keyword}</c:if>
						">[이전]</a>
					</c:if> <c:forEach var="pageNum" begin="${viewData.startPage}"
						end="${viewData.endPage < viewData.pageTotalCount ? viewData.endPage : viewData.pageTotalCount}">
						<c:choose>
							<c:when test="${pageNum == viewData.currentPage}">
								<b>[${pageNum}]</b>
							</c:when>
							<c:otherwise>
								<a href="boardList?page=${pageNum}
									<c:if test="${viewData.type != null}">&type=${viewData.type}</c:if>
									<c:if test="${viewData.keyword != null}">&keyword=${viewData.keyword}</c:if>
								">[${pageNum}]</a>
							</c:otherwise>
						</c:choose>

					</c:forEach> <c:if test="${viewData.endPage < viewData.pageTotalCount}">
						<a href="boardList?page=${viewData.endPage+1}
							<c:if test="${viewData.type != null}">&type=${viewData.type}</c:if>
							<c:if test="${viewData.keyword != null}">&keyword=${viewData.keyword}</c:if>
						">[다음]</a>
						<a href="boardList?page=${viewData.pageTotalCount}
							<c:if test="${viewData.type != null}">&type=${viewData.type}</c:if>
							<c:if test="${viewData.keyword != null}">&keyword=${viewData.keyword}</c:if>
						">[마지막]</a>
					</c:if></td>
			</tr>
			<tr>
				<td colspan="5">
					<!-- 검색어 입력받아서 컨트롤러로 전달 -->
					<form action="boardList">
						<select name="type">
							<option value="1">제목</option>
							<option value="2">작성자</option>
							<option value="3">제목+작성자</option>
							<option value="4">내용</option>
						</select> <input type="text" name="keyword"> <input type="submit"
							value="검색">
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
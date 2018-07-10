<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setAttribute("path", request.getContextPath()); %>

<div id="navi">
	<ul>
		<li><a href="${path}/board/boardListForm">게시판</a></li>
		<li><a href="${path}/member/myPage">마이페이지</a></li>
		<li><a href="${path}/member/loginForm">로그인</a></li>
	</ul>
</div>
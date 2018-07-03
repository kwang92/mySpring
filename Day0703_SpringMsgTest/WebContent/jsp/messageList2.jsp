<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메시지 리스트</title>
<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script type = "text/javascript">
	function writeMessage(){
		var name = $("#guestName").val();
		var pwd = $("#guestPassword").val();
		var content = $("#writeMsg").val();
		$.ajax({
			url : "sendMsg",
			type : "get",
			data : {"name" : name, "pwd" : pwd, "content" : content},
			dataType : "json",
			success : function(data){
				
			},
			error : function(){
				alert("fail");
			}
			
		});
		return false;
	};
</script>
</head>
<body>
	<%-- messgeList 속성에 들어있는 데이터를 하나씩 화면에 출력하기  --%>
<%-- 	${messageList} --%>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>메시지</th>
		</tr>
		<c:forEach items="${viewData.messageList}" var = "message">
			<tr>
				<td>${message.id}</td>
				<td>${message.name}</td>
				<td>${message.message }</td>
				<td><button onclick="location.href='confirmDeletion?id=${message.id}'">삭제</button></td>
			</tr>
		</c:forEach>
		
	</table>
	<br>

	<c:if test="${viewData.startPage !=1 }">
		<a href = "messageList?pageNum=1">[처음]</a>
		<a href = "messageList?pageNum=${viewData.startPage-1}">[이전]</a>
	</c:if>
	<c:forEach var = "pageNum" begin="${viewData.startPage}" end="${viewData.endPage < viewData.pageTotalCount ? viewData.endPage : viewData.pageTotalCount}">
		<c:choose>
			<c:when test="${pageNum == viewData.currentPage}">
				<b>[${pageNum}]</b>
			</c:when>
			<c:otherwise>
				<a href="messageList?pageNum=${pageNum}">[${pageNum}]</a>	
			</c:otherwise>
		</c:choose>
		
		
	</c:forEach>
	<c:if test = "${viewData.endPage < viewData.pageTotalCount}">
		<a href = "messageList?page=${viewData.endPage+1}">[다음]</a>
		<a href = "messageList?page=${viewData.pageTotalCount}">[마지막]</a>
	</c:if>
	

	<form action="write" method="post" onSubmit = 'return writeMessage()'>
		<fieldset>
			<legend> 메시지 입력</legend>
			<p><label>이름 : <input type="text" id = "guestName" name="guestName"> </label></p>
			<p><label>암호 : <input type="password" id = "guestPassword" name="password"> </label></p>
			<p>
				<textarea rows="3" cols="30" id = "writeMsg" name = "message"></textarea>
			</p>
		</fieldset>
			<input type="submit" value = "메시지 저장!">	
		
	</form>
</body>
</html>










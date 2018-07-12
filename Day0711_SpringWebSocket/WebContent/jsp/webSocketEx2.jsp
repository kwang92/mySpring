<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var = "contextPath" value = "<%=request.getContextPath()%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script type = "text/javascript" src = "${contextPath}/js/sockjs.js"></script>
<script type = "text/javascript">	
	// SockJS 버젼
	var sock;
	var stompClient = null;
	
	function connect(){
		alert("connect 호출");
		sock = new SockJS('http://localhost:8081/Day0711_SpringWebSocket/chat');
		stompClient = Stomp.over(sock);	// Stomp 라이브러리의 over메소드를 이용해 connect
		stompClient.connect({}, function(){
			stompClient.subscribe('/topic/msg', function(message){
				alert("Message : " + message);
				console.log("Message : " + message);
			});
		});
	};
	function sendMessage(){
		stompClient.send('/client/greeting',{},"반갑습니다.");
	};
	
	
	$(function(){
		connect();
	});
	
</script>
</head>
<body>
	<div id = "wrap" align = "center">
		<input type = "button" value = "전송" id = "btn" onclick = "sendMessage();">
	</div>
</body>
</html>
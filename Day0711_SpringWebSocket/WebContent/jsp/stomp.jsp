<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script type="text/javascript" src="${contextPath}/js/sockjs.js"></script>
<script type="text/javascript" src="${contextPath}/js/stomp.js"></script>
<script type="text/javascript">	
	// SockJS 버젼
	var sock;
	var stompClient = null;
	
	function connect(){
		alert("connect 호출");
// 		sock = new SockJS('http://localhost:8081/Day0711_SpringWebSocket/chat');
		sock = new SockJS('${contextPath}/chat');
		
		stompClient = Stomp.over(sock);	// Stomp 라이브러리의 over메소드를 이용해 connect
		stompClient.connect({}, function(){
			stompClient.subscribe('/topic/msg/${param.memberid}', function(message){
				var data = JSON.parse(message.body);
 				addMessage(data.body);
			});
		
			
		});
	};
	function send(){	// input에 입력한 text message를 textarea에 추가 후 전송
		var msgText = $("#chatMsg").val();
		$("#chatMsg").val("");
		$("#chatContent").append("나 : "+msgText+"\n");
		var target = $("#target").val();
		stompClient.send('/client/greeting/${param.memberid}/'+target,{}, msgText);
	};
	
	function addMessage(data){	// 들어온 message를 textarea에 추가
		$("#chatContent").append(data+"\n");
	};
	
	$(function(){
		connect();
	});
	
</script>
</head>
<body>
	<div id="wrap" align="center">
		접속한 사용자 : ${param.memberid}<br>
		<div id="content" style="width: 500px;">
			<textarea rows="5" cols="30" id="chatContent"></textarea>
			<hr>
			상대id : <input type="text" id="target" style="width: 80px;"> <input
				type="text" id="chatMsg"> <input type="button" value="전송"
				onclick="send();">
		</div>
	</div>
</body>
</html>
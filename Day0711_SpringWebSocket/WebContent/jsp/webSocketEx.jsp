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
	var ws;
	
	function connect(){
		alert("connect 호출");
	
		ws = new WebSocket('ws://localhost:8081/Day0711_SpringWebSocket/chat');
		
		ws.onopen = function(){		// 웹 소켓이 연결되었을 때 실행할 함수
			register();
			console.log("연결됨!");
		};
		
		ws.onmessage = function(evt){	// 메시지를 받았을 때 실행할 함수
			var data = evt.data;
			console.log("메시지 받음 : "+data);
			
			$("#chatContent").append(data+"\n");
		};
		
		ws.onclose = function(){	// 웹 소켓 연결이 끊겼을 때 실행할 함수
			console.log("연결종료!");
		};
	};
	
	$(function(){
		connect();
	});
	
	function register(){
		var msg = {
			type : "register",
			memberid : '${param.memberid}'
		}
		ws.send(JSON.stringify(msg));
	};

	function send(){
		var msgText = $("#chatMsg").val();
		$("#chatMsg").val("")
		var msg = {
			type : "chat",
			target : $("#target").val(),
			message : msgText
		}
		$("#chatContent").append("나 : "+msgText+"\n");
		ws.send(JSON.stringify(msg));
	};
</script>
</head>
<body>
	<div id = "wrap" align = "center">
		<div id = "content" style = "width : 500px;">
			<textarea rows="5" cols="30" id = "chatContent"></textarea>
			<hr>
			상대id : <input type = "text" id = "target" style = "width : 80px;">
			<input type = "text" id = "chatMsg">
			<input type = "button" value = "전송" onclick = "send();">
		</div>
	</div>
</body>
</html>
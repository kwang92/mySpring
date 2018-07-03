<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메시지 리스트</title>
<style type = "text/css">
	a{
		text-decoration: none;
		color : black;
	}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
	
</script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url : "getMsgs",
			type : "get",
			dataType : "json",
			success : function(data){
				createTable(data);
			},
			error : function(){
				alert("로딩실패");
			}
		});
	});
	function writeMessage() {
		var name = $("#guestName").val();
		var pwd = $("#guestPassword").val();
		var content = $("#writeMsg").val();
		$.ajax({
			url : "sendMsg",
			type : "get",
			data : {
				"name" : name,
				"pwd" : pwd,
				"content" : content
			},
			dataType : "json",
			success : function(data) {
				clearInput();
				clearList();
				clearNavi();
				createTable(data);
			},
			error : function() {
				alert("writeMessage fail");
			}
		});
		return false;
	};
	function executeNavi(page) {
		$.ajax({
			url : "pageList",
			type : "get",
			data : {
				"page" : page
			},
			dataType : "json",
			success : function(data) {
				clearList();
				clearNavi();
				createTable(data);
			},
			error : function() {
				alert("executeNavi Fail");
			}
		});
	};
	function createTable(data) {
		var table = $("#listTable")
		var msgList = data.messageList;
		for ( var i in msgList) {
			var tr = $("<tr>");
			$("<td>").text(msgList[i].id).appendTo(tr);
			$("<td class = 'name'>").text(msgList[i].name).appendTo(tr);
			$("<td class = 'message'>").text(msgList[i].message).appendTo(tr);
			var td = $("<td>");
			$("<input type = 'button' value = '삭제' onclick = 'location.href =\"confirmDeletion?id="+msgList[i].id+"\"'>").appendTo(td);
			td.appendTo(tr);
			tr.appendTo(table);
		}
		createNavi(data);
	};
	function createNavi(data){
		var navi = $("<div id = 'navi'>");
		if(data.startPage != 1){
			$("<a href = 'javascript:executeNavi(1)'>[ 처음 ]").appendTo(navi);
			$("<a href = 'javascript:executeNavi("+(data.startPage-1)+")'").appendTo(navi);	
		}
		for(var pageNum = data.startPage; pageNum <= (data.endPage < data.pageTotalCount ? data.endPage : data.pageTotalCount); pageNum++){
			if(pageNum == data.currentPage){
				$("<b>").text("[ "+pageNum+" ]").appendTo(navi);
			}	
			else{
				$("<a href = 'javascript:executeNavi("+pageNum+")'>").text("[ "+pageNum+" ]").appendTo(navi);
			}
		}
		if(data.endPage < data.pageTotalCount){
			$("<a href = 'javascript:executeNavi("+(data.endPage+1)+")'>[ 다음 ]").appendTo(navi);
			$("<a href = 'javascript:executeNavi("+data.pageTotalCount+")'>[ 마지막 ]")
		}
		var naviWrap = $("#naviWrap");
		navi.appendTo(naviWrap);
	};
	function clearNavi(){
		$("#navi").remove();
	};
	function clearList() {
		$("#listTable tr:gt(0)").remove();
	};
	function clearInput() {
		$("#guestName").val("");
		$("#guestPassword").val("");
		$("#writeMsg").val("");
	};
</script>
</head>
<body>
	<%-- messgeList 속성에 들어있는 데이터를 하나씩 화면에 출력하기  --%>
	<%-- 	${messageList} --%>
	<div id="wrap" align="center">
		<table id="listTable">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>메시지</th>
			</tr>
		</table>
		<br>
		<div id = "naviWrap">
			
		</div>

		

		<form action="write" method="post" onSubmit='return writeMessage()' style = "width : 580px;">
			<fieldset>
				<legend> 메시지 입력</legend>
				<p>
					<label>이름 : <input type="text" id="guestName"
						name="guestName">
					</label>
				</p>
				<p>
					<label>암호 : <input type="password" id="guestPassword"
						name="password">
					</label>
				</p>
				<p>
					<textarea rows="3" cols="30" id="writeMsg" name="message"></textarea>
				</p>
			</fieldset>
			<input type="submit" value="메시지 저장!">

		</form>
	</div>
</body>
</html>










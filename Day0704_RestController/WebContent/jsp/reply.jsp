<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setAttribute("contextPath", request.getContextPath()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script type="text/javascript">
	function addReply(){
		var boardNum = 26;
		var replyWriter = $("#replyWriter").val();
		var replyContent = $("#replyContent").val();
		$.ajax({
			url : '${contextPath}'+"/replies",
			method : "post",
			data : {"boardNum":boardNum, "replyWriter":replyWriter, "replyContent":replyContent},
			dataType : "json",
			success : function(result){
				if(result){
					alert("success");
				}else{
					alert("failed");
				}
				getReplyList();
			},
			error : function(){
				alert("error");
			}
		});
		return false;
	};
	function getReplyList(){
		//비동기 적으로 화면에 그릴 댓글목록 가져오고
		//가져온 댓글 목록을 이용하여 화면 그리기 
		var boardNum = 26;
		$.ajax({
			url:"${contextPath}/replies/all/"+boardNum,
			type:"get",
			dataType:"json",
			success : function(data){
				//data의 요소를 가지고 한번씩 반복하면서 function 실행
				//jQuery foreach
// 				{"replyNum":1,"boardNum":41,"replyContent":"댓글입니다. 1","replyWriter":"작성자 1","regDate":1530687094000}
				var str = "";
				$(data).each(function(){
					var rNum = this.replyNum;
					var bNum = this.boardNum;
					var rContent = this.replyContent;
					var rWriter = this.replyWriter;
					var date = new Date(this.regDate);
					
					str += "<li>"+rNum+"/"+rContent+"/"+rWriter+"/"+date+"</li>";
					$("#replies").html(str);
				});
			}	
		});
	}
</script>
</head>
<body>
	댓글화면 입니다. ${boardNum}번 게시글 댓글 화면 입니다.

	<form>
		이름 : <input type="text" name="replyWriter" id="replyWriter">
		내용 : <input type="text" name="replyContent" id="replyContent">
		<input type="button" value="등록" onclick = "addReply();">
	</form>
	<ul id = "replies">
		
	</ul>
</body>
</html>
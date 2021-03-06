<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setAttribute("contextPath", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#modal-modify{
		width: 300px;
		height: 150px;
		background-color: gray;
		position: absolute;
		top: 40%;
		left: 40%;
		padding: 10px;
		margin-top: -100px;
		margin-left: -100px;
		z-index: 1000;
	}
</style>  
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script type="text/javascript">
	$(function(){
		getReplyList();
		$("#replyForm").on("submit",function(){
			alert("submit 이벤트 발생!!");
			var replyWriter = $("#replyWriter").val();
			var replyContent = $("#replyContent").val();
			//ajax로 요청 처리
			$.ajax({
				url:"${contextPath}/replies",
				type:"post",
				data:{boardNum : boardNum,
					replyWriter : replyWriter,
					replyContent : replyContent
				},
				dataType:"json" ,
				success : function(result){
					if(result){
						alert("등록되었습니다.");
					}else{
						alert("등록 실패하였습니다.");
					}
					getReplyList();
					//목록 새로 그리기..
				}
			});
			return false; //이벤트를 더이상 진행하지 않음
		});
		//모달 보이기 버튼 이벤트 처리  input[type='button']   ==  :button
		$("#replies").on("click",":button",function(){
			
			
			//alert("!!!!!");
			var reply = $(this).parent();
// 			alert(reply.text());
			$("#modal-modify").attr("data-rNum",reply.attr("data-rNum"));
			$("#modal-replyContent").val(reply.text());
			//모달 보이기 
			$("#modal-modify").show("slow");
		});
		
		//모달 숨기기 
		$("#btn-close").on("click", function() {
			$("#modal-modify").hide("slow");
		});
		
		//삭제버튼 처리 
		$("#btn-replyDelete").on("click",function(){
			var rNum = $("#modal-modify").attr("data-rNum");
			$.ajax({
				url : "${contextPath}/replies/"+rNum,
				type :"delete",
				dataType : "text",
				success : function(data){
					if(data){
						alert("삭제되었습니다.")
						$("#modal-modify").hide("slow");
						getReplyList();
					}else{
						alert("삭제실패!!")
						$("#modal-modify").hide("slow");
					}
				},
				error : function(request,status,error){
					alert("request :" + request + "\n"+
							"status :" + status + "\n"+
							"error :" + error);
				}
			});
				
		});
	});
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
		var replies = $("#replies");
		replies.html("");
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
					var li = $("<li>");
					var btn = $("<input type = 'button' value ='수정'>");
					var rNum = this.replyNum;
					var bNum = this.boardNum;
					var rContent = this.replyContent;
					var rWriter = this.replyWriter;
					var date = new Date(this.regDate);
					var y = date.getFullYear();
					var m = date.getMonth()+1;
					var d = date.getDate();
					//html5에서 요소에 변수처럼 간단한 값을 저장할 수 있음
					//요소에  data-* 속성을 만들어서 변수처럼 사용가능
					li.text(rContent+"/"+rWriter+"/"+y+"-"+m+"-"+d+" ");
					li.attr("data-rNum",rNum);
					btn.appendTo(li);
					li.appendTo(replies);
					
// 					str += "<li>"+rNum+"/"+rContent+"/"+rWriter+"/"+date+"</li>"
// 					$("#replies").html(str);
				});
			}	
		});
	}
	
</script>
</head>
<body>
	<div id = "modal-modify" style="display: none;">
		<div> 
			<input type = "text" id = "modal-replyContent">
		</div>
		<div>
			<input type="button" id = "btn-replyModifiy" value="수정">
			<input type="button" id = "btn-replyDelete" value ="삭제">
			<input type="button" id = "btn-close" value="닫기">
		</div>
	</div>
	<form>
		이름 : <input type="text" name="replyWriter" id="replyWriter">
		내용 : <input type="text" name="replyContent" id="replyContent">
		<input type="button" value="등록" onclick="addReply();">
	</form>
	<ul id="replies">

	</ul>
</body>
</html>
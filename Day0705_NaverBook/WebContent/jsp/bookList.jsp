<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>네이버 책 검색</title>

<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script type = "text/javascript">
	function getBooks(){
		var keyword = $("#keyword").val();
		$("#keyword").val("");
		$.ajax({
			url : "bookSearch?keyword="+keyword,
			method : "post",
			dataType : "json",
			success : function(data){
				createBookInfo(data);
			},
			error : function(){
				alert("fail");
			}
		});
	};
	function createBookInfo(data){
		var con = $("#content");
		removeDiv();
		$(data).each(function(){
			var div = $("<div class = 'book'>");
			$("<img src = "+this.image+">").appendTo(div);
			$("<br>").appendTo(div);
			
			var title = this.title.replace(/"<br>"/,'');
			$("<b>").html(this.title).appendTo(div);
			$("<br>").appendTo(div);
			$("<b>").text(this.author).appendTo(div);
			$("<br>").appendTo(div);
			$("<b>").text(this.price).appendTo(div);
			$("<br>").appendTo(div);
			$("<b>").text(this.publisher).appendTo(div);
			$("<br>").appendTo(div);
			$("<hr>").appendTo(div);
			div.appendTo(con);
		});
	}
	function removeDiv(){
		$(".book").remove();
	};
</script>
</head>
<body>
	<div id = "wrap" align = "center">
		<input type = "text" id = "keyword" name = "keyword" placeholder = "검색할 키워드 입력">
		<input type = "button" value = "검색" onclick = "getBooks();"> 
	</div>
	<div id = "conWrap" align = "center" style = "width : 100%;">
		<div id = "content" style = "width : 680px">
			
		</div>
	</div>
</body>
</html>
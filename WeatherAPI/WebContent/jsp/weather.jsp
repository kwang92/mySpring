<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setAttribute("path", request.getContextPath());%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type = "text/css">
	img{
		border : 1px solid white;
		border-radius: 100px;
	}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script type="text/javascript">
	var x, y;
	var getLocation = function(){
		return new Promise(function (resolve, reject){
			if(navigator.geolocation){
				navigator.geolocation.getCurrentPosition(function(position){
					x = position.coords.latitude;
					y = position.coords.longitude;
					resolve({posX : x, posY : y });
				});
			}
		});
		
		
	};

	function doWeather(){
		getLocation().then(function (result){
			$.ajax({
				url : "show?posX="+x+"&posY="+y,
				dataType : "text",
				method : "post",
				success : function(weather){
					var weather_Info = weather.split(",");
					var city = weather_Info[0];
					var status = weather_Info[1];	// Clouds, Haze ,
					var degree = parseInt(weather_Info[2]);
				
					alert(status);
					
					var box = $("#imgBox");
					
					if(status == "Rain"){
						$("<img src = '${path}/img/rainy.PNG'>").appendTo(box);
					}else if(status == "Sunny"){
						$("<img src = '${path}/img/sunny.PNG'>").appendTo(box);
					}else if(status == "Haze"){
						$("<img src = '${path}/img/Haze.PNG'>").appendTo(box);
					}else if(status == "Clouds"){
						$("<img src = '${path}/img/cloudy.PNG'>").appendTo(box);
					}
					
					
					


					$("#place").text(city);
					$("#temp").text(degree+"˚");
				}
			});
		});
	};

</script>
</head>
<body>
	<input type="button" value="날씨조회" onclick="doWeather();">
	<div id="imgBox"></div>

	<h2 id="place"></h2>
	<h2 id="temp"></h2>

</body>
</html>
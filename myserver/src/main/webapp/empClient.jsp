<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
	<div id="list"></div>
	<script>
		$.ajax({
			url : "empSelect",
			success : function(result) {
				console.log(result);
			}
		})
		
		$.ajax({
			url : "req",
			method : "post",
			async : false,
			//async옵션을 쓰면 동기(false), 비동기(true) 가능
			data : JSON.stringify({first_name:"gildong", last_name:"kim"}),
			contentType : "json",
			//보내는 파라미터가 json String
			//data : {first_name:"gildong", last_name:"kim"},
			//post 방식일때 form데이터로 받고 get방식일때 쿼리 string타입으로 받음
			//data : "first_name=gildong&last_name=kim",
			dataType : "json",
			//자동파싱되므로 생략가능
			success : function(result) {
				console.log("결과는")
				console.log(result);
				//메소드가 없으면 기본은 get방식
			}
		})
		console.log("요청");
	</script>
</body>
</html>
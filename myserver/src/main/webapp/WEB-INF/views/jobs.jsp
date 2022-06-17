<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
  <script>
  	$(function(){
      //아코디언
      $("#accd").accordion({
        collapsible: true,
        active: 0,
        activate: function( event, ui ) {
          console.log(ui.newHeader.text())
        }
      });
  	})
  </script>
</head>
<body>
<div id="accd">
	<c:forEach var="job" items="${jobs }">
		<h3>${job.job_title }</h3>
		<div>
			<c:forEach var="emp" items="${job.employees }">
				<div>${emp.employee_id }, ${emp.first_name }</div>
			</c:forEach>
		</div>
	</c:forEach>
</div>
</body>
</html>
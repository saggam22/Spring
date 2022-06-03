<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/jquery-3.6.0.min.js"></script>
</head>
<style>
	table tr:hover {
		cursor: pointer;
		background: gray;
	}
</style>
<body>
<div align="center">
	<div><h1>공지사항 목록</h1></div>
	<div>
		<form id="frm" action="#" method="post">
			<select name="state" id="state">
				<option value="1">전 체</option>
				<option value="2">작성자</option>
				<option value="3">제 목</option>
				<option value="4">내 용</option>
			</select>&nbsp;
			<input type="text" id="key" name="key">&nbsp;
			<button type="button" onclick="searchNotice2()">검 색</button>
		</form>
	</div><br>
	<div>
		<table id="tb" border="1">
			<thead>
				<tr>
					<th width="70">순번</th>
					<th width="150">작성자</th>
					<th width="300">제 목</th>
					<th width="150">작성일자</th>
					<th width="70">조회수</th>
					<th width="70">첨부파일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty notices }">
					<c:forEach items="${notices }" var="n">
						<tr onclick="eventList(${n.noticeId})">
							<td>${n.noticeId }</td>
							<td>${n.noticeName }</td>
							<td>${n.noticeTitle }</td>
							<td>${n.noticeDate }</td>
							<td>${n.noticeHit }</td>
							<td>${n.noticeAttech }</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty notices}">
					<tr>
						<td colspan="6" align="center">게시글이 존재하지 않습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
			<form id="frm2" action="getContent.do" method="post">
				<input type="hidden" id="noticeId" name="noticeId">
			</form>
	</div><br/>
	<div>
		<button type="button" onclick="location.href='noticeInsertForm.do'">글 등록</button>
	</div>
</div>
</body>

<script>
function searchNotice2() {
//jQuery 사용하기
let state = $("#state").val(); //document.getElementById("state").value 와 같다
let key = $("#key").val();

$.ajax({
	 url : "ajaxSearchList.do", //url
	 type : "post", //전송방식
	 data : {"state" : state, "key" : key}, //전달할 데이터
		 dataType : "json", //돌려받을 결과의 데이터 타입 html, text, xml, json, jsonp
		 success : function(data) { //성공했을때 실행할 함수 결과는 data에 담김
			 //수행할 영역
			 htmlConvert(data);
		 },
		 error : function() { //실패했을때 실행할 함수
			 alert("의도치 않는 오류가 발생했습니다.")
		 }
})

function htmlConvert(data) {
	$("tbody").remove(); //tbody삭제
	let tbody = $("<tbody/>");
	$.each(data,function(index, n) {
		var row = $("<tr onclick='eventList("+n.noticeId+")'/>").append(
				$("<td/>").text(n.noticeId),
				$("<td/>").text(n.noticeName),
				$("<td/>").text(n.noticeTitle),
				$("<td/>").text(n.noticeDate),
				$("<td/>").text(n.noticeHit),
				$("<td/>").text(n.noticeAttech),
		);
		tbody.append(row); //행을 추가
	});
	$("#tb").append(tbody); //tbody를 추가
}
}

</script>

<!-- 그룹이벤트 생성(상세조회) -->
<script type="text/javascript">
function eventList(data) {
	 //let list = document.querySelector('tbody');
	 //list.addEventListener('click', function(ev) {
		 //if(ev.target.tagName === 'TD') {			 
		 //console.log(ev.target.parentNode.children[0].textContent);
		 //frm2.noticeId.value = ev.target.parentNode.children[0].textContent;
		 //frm2.action="getContent.do"로 action을 지정해줄수도 있음
		 frm2.noticeId.value = data;
		 frm2.submit();
		 //}
		 //location.href = 'getContent.do?noticeId='+ev.target.parentNode.children[0].textContent;
	 //})
}

	 function searchNotice() {
		 let fields = ['noticeId', 'noticeName', 'noticeTitle', 'noticeDate', 'noticeHit', 'noticeAttech'];
		 let allTr = document.querySelectorAll('tbody>tr');
         allTr.forEach(function (tr) {
        	 tr.remove();
         })
		 let list = document.querySelector('tbody');
         
         
		 fetch('ajaxSearchList.do', {
			 method: 'POST',
			 body : new FormData(document.getElementById('frm'))
		})
		 .then(response => response.json())
		 .then(data => {
			 data.forEach(d => {
			 let tr = document.createElement('tr');
			 fields.forEach(f => {
		       let td = document.createElement('td');
		       td.innerHTML = d[f];
		       tr.appendChild(td); 
			 })
				 list.appendChild(tr);
			 })
		 })
	 }
	 
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>게시글 상세</h1></div>
	<br>
	<div>
		<table id="tb" border="1">
			<tr>
				<th width="70">작 성 자</th>
				<td width="870">${content.boardName }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${content.boardTitle }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${content.boardDate }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${content.boardHit }</td>
			</tr>
			<tr>
				<th height="400">작성글</th>
				<td>${content.boardContents }</td>
			</tr>
		</table>
		<form id="frm" action="#" method="post">
				<input type="hidden" id="boardId" name="boardId">
		</form>
	</div><br/>
	<div>
		<button type="button" onclick="eventPath('update', ${content.boardId})">글 수정</button>
		<button type="button" onclick="eventPath('delete', ${content.boardId})">글 삭제</button>
		<button type="button" onclick="location.href='boardList.do'">글 목록</button>
	</div>
</div>
</body>
<script type="text/javascript">
function eventPath(path, data) {
	 frm.boardId.value = data;
	 if (path == 'update') {		 
	 		frm.action = "boardUpdateForm.do";
	 } else if (path == 'delete') {
		 frm.action = "boardDelete.do"; 
	 }
	 frm.submit();
}
</script>
</html>
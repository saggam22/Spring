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
	<div><h1>게시글 등록</h1></div>
	<div>
		<form action="noticeInsert.do" method="post" enctype="multipart/form-data">
			<div>
				<table border="1">
					<tr>
						<th width="100">작성자</th>
						<td width="150"><input type="text" id="noticeName" name="noticeName"></td>
						<th width="100">작성일자</th>
						<td width="150"><input type="date" id="noticeDate" name="noticeDate"></td>
					</tr>
					<tr>
						<th width="100">제목</th>
						<td colspan="3" width="150"><input type="text" id="noticeTitle" name="noticeTitle" size="58"></td>
					</tr>
					<tr>
						<th width="100">내용</th>
						<td colspan="3">
						<textarea rows="10" cols="60" id="noticeContents" name="noticeContents"></textarea></td>
					</tr>
					<tr>
						<th width="100">첨부파일</th>
						<td colspan="3">
						<input type="file" id="file" name="file"></td>
					</tr>	
				</table>
			</div><br/>
			<div>
				<input type="submit" value="저장">&nbsp;&nbsp;
				<input type="reset" value="취소">&nbsp;&nbsp;
				<input type="button" value="목록" onclick="location.href='noticeList.do'">
			</div>
		</form>
	</div>
</div>
</body>
</html>
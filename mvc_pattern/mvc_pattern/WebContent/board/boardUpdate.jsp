<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.trinity.vo.Board" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글등록</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  
  <style type="text/css">
	#update_wrap{width:99%; padding-top:2%;}
	.update_table{width:85%; margin:0 auto; border:1px solid #c3c3c3;}
  </style>
  
</head>
<body>
<div id="update_wrap">
<center>
<form action="board?action=boardUpdate" method="post">
  <input type="hidden"  name="boardNum" value="${requestScope.board.boardNum}" />

	<table class = "table update_table" style = "margin : 0px 100px 100px 100px">
		<colgroup>
			<col width="20%"/>
			<col width="80%"/>
		</colgroup>
		<tr>
		     <td colspan="2"><h2>게시판 글 수정</h2></td>
		</tr>
		<tr>
		     <td style="text-align:center; background:#f2f2f2; border-right:1px solid #c3c3c3;">제목</td>
		     <td>
		     	<input type="text"  name="title" value="${requestScope.board.title}" style="border:1px solid #c3c3c3; padding-left:5px;"/>
		     </td>
		</tr>
		<tr>
		     <td style="text-align:center; background:#f2f2f2; border-right:1px solid #c3c3c3;">작성자</td>
		     <td>
		        ${requestScope.board.writer}
		       	<input type="hidden" name="writer" value="${requestScope.board.writer}"/>
		</tr>
		<tr>
		     <td colspan="2">
		     <textarea rows="20" cols="60"  class = "form-control" name="contents">${requestScope.board.contents}</textarea>
		     </td>
		</tr>
		<tr>
		     <td style="text-align:center; background:#f2f2f2; border-right:1px solid #c3c3c3;">파일첨부</td>
		     <td> <input type = "file" name="fileName" multiple/></td>
		</tr>
		<tr style="text-align:right;">
		     <td colspan="2">
		     	<input type="submit" class = "btn btn-success btn-sm" value = "저장">
			 <input type="reset" class = "btn btn-warning btn-sm" value = "취소">
		     </td>
		</tr>
	</table>
</form> 

</center>
</div><!-- update_wrap -->
</body>
</html>
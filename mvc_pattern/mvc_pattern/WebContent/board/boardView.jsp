<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.trinity.vo.Board" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글 상세보기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
	function deleteBoard(boardNum){
		window.location.href="board?action=boardDelete&boardNum="+boardNum;
	}
	function listBoard(boardNum){
		window.location.href="board?action=boardList";
	}	
</script>

<style type="text/css">
	#view_wrap{width:99%; padding-top:2%;}
	.view_table{width:85%; margin:0 auto; border:1px solid #c3c3c3;}
	.view_table tr{border:1px solid #c3c3c3;}
</style>


</head>
<body>
<div id="view_wrap">
<center>
<form action="board?action=boardUpdate" method="post">
  <input type="hidden"  name="boardNum" value="${requestScope.board.boardNum}" />

	<table class = "table view_table" style = "margin : 0px 100px 100px 90px">
		<colgroup>
			<col width="20%"/>
			<col width="80%"/>
		</colgroup>
		<tr>
		     <td colspan="2"><h2>게시판 글 보기</h2></td>
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
		<c:if test="${cookie.userId.value==board.writer}">
		<tr style="text-align:right;">
		     <td colspan="2">
			    <input type="button" class = "btn btn-success" value="목록보기"  onclick="listBoard()"/>&nbsp;&nbsp;
		     	<input type="submit" class = "btn btn-info" value="글수정"  />&nbsp;&nbsp;
		     	<input type="button" class = "btn btn-warning" value="글삭제" onclick="deleteBoard('${requestScope.board.boardNum}')"/>
		     </td>
		</tr>
		</c:if>
		<c:if test="${cookie.userId.value!=board.writer}">
		<tr>
			 <td colspan="2" align="right">
			     	<input type="button" class = "btn btn-success" value="목록보기"  onclick="listBoard()"/>
		     </td>
		</tr>
	    </c:if>
	</table>
</form>
</center>
</div><!-- view_wrap -->
</body>
</html>
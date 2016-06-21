<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<style type="text/css">
	#input_wrap{width:99%; padding-top:2%;}
</style>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글 등록</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  
  <link rel="stylesheet" type = "text/css" href="css/index.css">
</head>
<body>
<div id="input_wrap">
<center>
<form action="board?action=boardSave" method="post" enctype = "multipart/form-data">
	<table class = "table " border="1" style="width:85%; margin:0px 100px 100px 70px; border:1px solid #c3c3c3;">
		<colgroup>
			<col width="20%"/>
			<col width="80%"/>
		</colgroup>
		<tr>
		     <td colspan="2"><h2>게시판 글등록</h2></td>
		</tr>
		<tr>
		     <td style="text-align:center; background:#f2f2f2; border-right:1px solid #c3c3c3;">제목</td>
		     <td>
		     	<input type="text" class = "form-control" name="title"/>
		     </td>
		</tr>
		<tr>
		     <td style="text-align:center; background:#f2f2f2; border-right:1px solid #c3c3c3;">작성자</td>
		     <td>
		       	<%=session.getAttribute("userId")%>
		       	<!-- input type="hidden" name="writer" value="<%=session.getAttribute("userId")%>"/-->
			   	<input type="hidden" name="writer" value="${cookie.userId.value}"/>
		     </td>
		</tr>
		<tr>
		     <td colspan="2">
		     <textarea rows="20" cols="60" class = "form-control" name="contents"></textarea>
		     </td>
		</tr>
		<tr>
		     <td style="text-align:center; background:#f2f2f2; border-right:1px solid #c3c3c3;">파일첨부</td>
		     <td> <input type = "file" name="fileName" multiple/></td>
		       	
		</tr>
		<tr style="text-align:right;">
		     <td colspan="2">
		     <input type="submit" class = "btn btn-success btn-sm" value = "글작성">
			 <input type="reset" class = "btn btn-warning btn-sm" value = "취소">
		     </td>
		</tr>
	</table>
</form> 

</center>
</div><!-- input_wrap -->
</body>
</html>
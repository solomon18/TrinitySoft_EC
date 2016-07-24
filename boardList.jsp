<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList,kr.co.trinity.vo.Board" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <script>
function check()
{
	window.open('inputPassword.jsp','new','resizable=no width=300 height=100');	
}

  </script>

<title>게시판 목록</title>

<style type="text/css">
.container{padding:0% 10% 0 10%;} /*상 우 하 좌*/
.board_table thead tr th{background:#f2f2f2; text-align:center;}
</style>

</head>
<body>
<div class = "container">
<%-- ArrayList<Board> boardList =(ArrayList)request.getAttribute("boardList"); --%>
	<c:set var="board" scope="session" value="${requestScope.boardList}"/>
	<c:set var="pageNumber" scope="session" value="${requestScope.pageInfo.getPageNumber()}"/>
	<c:set var="pageSize" scope="session" value="${requestScope.pageInfo.getPageSize() }"/>
	<c:set var="totalPage" scope="session" value="${requestScope.pageInfo.getTotalPage()}"/>
	<c:set var="beginRow" scope="session" value="${requestScope.pageInfo.getBeginRow()}"/>
	<c:set var="endRow" scope="session" value="${requestScope.pageInfo.getEndRow()}"/>
	<fmt:parseNumber scope="session" var="totalCount" type="number" value="${requestScope.boardList.size()}"/>
	<c:set var="perPage" scope="session"  value="${5}"/>

    <h2 style="padding-bottom:20px; color : #111111"> 게시판</h2>
	<table class = "table table-hover table-bordered board_table">
		<colgroup><!-- 테이블 세로 넓이값 -->
			<col width="8%"/>
			<col width=""/>
			<col width="10%"/>
			<col width="10%"/>
			<col width="10%"/>
		</colgroup>
		<thead>
			<tr>
				<th class="title">번호</th>
				<th class="title">제&nbsp;&nbsp;&nbsp;목</th> 
				<th class="title">작성자 </th>
				<th class="title">작성일 </th> 
				<th class="title"><img src="images/lock.png"></th>
			</tr>
		</thead>
		
		<c:choose>
		<c:when test="${totalCount gt 0}">
			<c:forEach items="${requestScope.boardList}" var="board" begin="${beginRow-1 }" end="${endRow-1 }">
			<tr>
				<td style="text-align:center;">${board.boardNum}</td>
				<td style="padding-left:20px;">
					<c:choose>
						<c:when test="${board.password != null}">
							<a href="board?action=boardView&boardNum=${board.boardNum}&mode=private">
								${board.title}
							</a> 	    
			       		</c:when>
			       		<c:otherwise>
			       			<a href="board?action=boardView&boardNum=${board.boardNum}&mode=public">
				     			${board.title}
				     		</a>
				     	</c:otherwise>			     
					</c:choose>
				</td>
				<td style="text-align:center;">${board.writer}</td>
				<td style="text-align:center;">${board.writeDate}</td>
				<td style="text-align:center;">
					<c:choose>
						<c:when test="${board.password != null}">
							<img src="images/lock.png"> 	    
			       		</c:when>
					</c:choose>
				</td>
			</tr>
			</c:forEach>
		</c:when>
		</c:choose>
	</table>
	
	<c:forEach var="i" begin="1" end="${totalPage }" step="1">
		<a href="board?action=boardList&pageNumber=${i }&pageSize=${perPage }">${i }</a>
	</c:forEach>
	
	<div style ="text-align:right; margin: 0 0 100px 0">
		<a href="board?action=boardInput&mode=private"><input type="button" class = "btn btn-warning" value ="비밀글 작성"></a>&nbsp;&nbsp;
		<a href="board?action=boardInput&mode=public"><input type="button" class = "btn btn-success" value="글작성" ></a>&nbsp;&nbsp;
	</div>
</div>

</body>
</html>

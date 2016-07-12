<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,kr.co.trinity.vo.Board" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<style type="text/css">
.container{padding:0% 10% 0 10%;} /*상 우 하 좌*/
.board_table thead tr th{background:#f2f2f2; text-align:center;}
</style>


</head>
<body>
<%-- 
<% ArrayList<String> AdminList =(ArrayList)request.getAttribute("AdminList"); %>
	
	<table>
	<%if(AdminList.size()>3){ %>
		<%for(int i=0; i < AdminList.size(); i++){%>
					<tr>
						<% if(i%2==0){ %>
							<td style="text-align:center;">ID : <%=AdminList.get(i) %></td>
						<%}else{ %>
							<td style="text-align:center;">Password : <%=AdminList.get(i) %></td>
						<%} %>
					</tr>
	
		<%} %>
	<%} %>
	</table>
--%>
<form action="admin?action=backup" method="post">
	<input type = "submit" value = "DB 백업">
	<input type = "hidden" value = "test" name = "cmd"> 
</form>	

</body>
</html>
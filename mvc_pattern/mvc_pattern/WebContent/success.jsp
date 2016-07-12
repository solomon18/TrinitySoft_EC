<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>success message page</title>
</head>
<body>
<center>
	<h3> <%=request.getAttribute("message") %></h3><br/><br/>
	<a href="index.jsp/customer?action=home">로그인 페이지로 이동</a>
</center>
</body>
</html> 
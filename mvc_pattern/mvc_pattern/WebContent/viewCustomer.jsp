<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kr.co.trinity.vo.Customer"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객정보</title>
</head>
<body>
<center>
        <h2>회 원 정 보</h2>
	  	<table border='1'>
	  	    <tr><td>아이디</td><td>${requestScope.customer.userId}</td></tr>
	  	    <tr><td>암호</td><td>${requestScope.customer.password}</td></tr>
	  	    <tr><td>이름</td><td>${requestScope.customer.userName}</td></tr>
	  	    <tr><td>이메일</td><td>${requestScope.customer.email}</td></tr>
	  	</table>
		</center>
</body>
</html>
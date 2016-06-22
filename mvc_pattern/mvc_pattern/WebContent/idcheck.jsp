<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 관리</title>
 <script src="member.js"></script>
</head>
<body>
	<h2> 아이디 중복확인 </h2>
	<form action="customer?action=idcheck" method="post" name="form">
	아이디 <input type="text" name="userId">
		<input type="submit" value="중복체크">
		<br>
		
		<c:if test="${result == true}">
			<script type="text/javascript">
				opener.document.form.userId.value="";
			</script>
			${userId}는 이미 사용 중인 아이디입니다.
		</c:if>
		<c:if test="${result == false}">
			${userId}는 사용 가능한 아이디입니다.
			<input type="button" value="사용" class="cancle" onclick="idUsable()">
		</c:if>
	</form>
</body>
</html>
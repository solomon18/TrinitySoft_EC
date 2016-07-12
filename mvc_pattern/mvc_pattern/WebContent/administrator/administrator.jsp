<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script>
	function register(){
		document.loginForm.action="admin?action=adminlogin";
		document.loginForm.submit();
	}
</script>


<title>Insert title here</title>
</head>
<body>
	<div class="admin_all">
		<input type = "image" src = "images/main_title.gif">
		<form action="admin?action=adminlogin" method = "post" name="loginForm">
			<table>
				<tbody>
					<tr>
						<th>아이디</th>
						<td>
							<input type = "text" name = "adminid" style="margin-bottom:6px;">
						</td>
						<td></td>
					</tr>
					<tr>
						<th>비밀번호&nbsp;</th>
							<td>
								<input type = "password" name = "adminpassword">
							</td>
							<td>
								<span class = "login_form_submit login_2">
								<input type="submit" value="LOGIN"/>
								</span>
							</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<!--id : admin, password : 1234 -->
</body>
</html>
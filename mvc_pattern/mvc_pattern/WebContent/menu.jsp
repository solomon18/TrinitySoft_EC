<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script>
$(document).ready(function(){
    $(".dropdown-toggle").dropdown();
});

</script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
<link href="css/style.css" rel="stylesheet" type="text/css" />

</head>
<body>
<nav class="navbar navbar-default" >
	<div class="container-fluid" >
    <div class="navbar-header">
      <a href="company?action=home">
	       <img src="images/logo.gif" alt = "copyright" style="width :100px height  : 50px;">
      </a>
    </div>
      <ul class="nav navbar-nav" >
        <li class = "dropdown">
          <a class = "dropdown-toggle" data-toggle = "dropdown" href="#" style="color:#ffffff; font-size:22px";>회사소개	
            <span class = "caret"></span>
          </a>
		  <ul class = "dropdown-menu" >
				<li><a href="company?action=company&number=1">회사개요 및 위치 </a></li>
				<li><a href="company?action=company&number=2">연혁 </a></li>
				<li><a href="company?action=company&number=3">인증/수상 </a></li>
				<li><a href="company?action=company&number=4">경영이념 </a></li>
				<li><a href="company?action=company&number=5">인사말 </a></li>
		  </ul>
	    </li>

      
       <li class = "dropdown">
		  <a class = "dropdown-toggle" data-toggle = "dropdown" href="#" style="color:#ffffff; font-size:22px";>제품소개
			<span class = "caret"></span></a>
			<ul class = "dropdown-menu" style = "font-size : 15px";>
				<li><a href="company?action=solution&number=1">웹스레이</a></li>
				<li><a href="company?action=solution&number=2">코드레이엑스지</a></li>
				<li><a href="company?action=solution&number=3">스캔레이</a></li>
			</ul>
       </li>

      <li class = "dropdown">
			<a class = "dropdown-toggle" data-toggle = "dropdown" href="#" style="color:#ffffff ; font-size:22px";>시큐어코딩
			<span class = "caret"></span></a>
			<ul class = "dropdown-menu" style = "font-size : 15px";>
				<li><a href="#">injection</a></li>				
	        </ul>
      </li>
	  
	<!--  style = "font-size : 16px"; -->

	</ul>

       <ul class="nav navbar-nav navbar-right">
       			<c:choose>
	       			<c:when test="${empty sessionScope.userId}">
		       			<li>
					        <a href="index.jsp?content=login.html" style="color:#ffffff; font-size:20px";>
					        <span class="glyphicon glyphicon-log-in"></span> Login</a>
				        </li>
				    </c:when>
				    <c:otherwise>
				    	<li style="color:#ffffff" >
				    		<br>${sessionScope.userId}님 로그인.
				    	</li>
				    	<li>
					        <a href="customer?action=logout" style="color:#ffffff; font-size:20px";>
					        <span class="glyphicon glyphicon-log-out"></span> LogOut</a>
				        </li>
				    </c:otherwise>
			    </c:choose>
			    
					  <li>
							<a href="http://cafe.naver.com/sec" target="_blank"><img src="images/lnb_menu01.gif" alt=""
							 onmouseover="this.src='images/lnb_menu01_ov.gif'"
							   onmouseout="this.src='images/lnb_menu01.gif'"/></a>
					  </li>
					  <li>
							<a href="https://www.facebook.com/trinitysoft" target="_blank"><img src="images/lnb_menu03.gif" alt="íì´ì¤ë¶"
							onmouseover="this.src='images/lnb_menu03_ov.gif'"
							   onmouseout="this.src='images/lnb_menu03.gif'"/></a>
					  </li>
        <!-- <li><a href="#" style="color:#ffffff";><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        -->
	        
		</ul>

  </div>
  </nav>
</body>
</html>
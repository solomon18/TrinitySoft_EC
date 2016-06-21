<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center> 
<%-- //Cookie Check
   Cookie [] cookieList = request.getCookies();
   HashMap<String, String> cookieInfo=new HashMap<String, String>();
   for(Cookie c: cookieList){
          cookieInfo.put(c.getName(), c.getValue());		
   }
 --%>
 <%
 //session Check
    HttpSession s = request.getSession(false);
    if(s !=null && s.getAttribute("userId")!=null){
       //session 사용
    }
 %>
		<h3><%= session.getAttribute("userId")%>님 <%= request.getAttribute("message") %></h3>
</center>
</body>
</html>

 
 
 
 
 
 
 
 
 
 
 
 




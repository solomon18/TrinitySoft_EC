package kr.co.trinity.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//session 소멸
		HttpSession session =request.getSession(false);
		if(session != null ) session.invalidate();
		
		//view select
		return "index.jsp?content=login.html";
	}

}

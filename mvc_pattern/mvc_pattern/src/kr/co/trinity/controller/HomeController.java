package kr.co.trinity.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 //view select
		return "index.jsp?content=login.html";
	}

}

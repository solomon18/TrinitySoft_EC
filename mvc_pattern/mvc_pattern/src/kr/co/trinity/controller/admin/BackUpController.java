package kr.co.trinity.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.trinity.controller.Controller;

/**
 * Servlet implementation class BackUpController
 */
public class BackUpController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String value = request.getParameter("cmd");
		
		
		
		System.out.println("연동");
		return "index.jsp?content=administrator/adminlist.jsp";
	}

}

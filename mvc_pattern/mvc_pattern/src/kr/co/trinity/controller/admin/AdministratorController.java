package kr.co.trinity.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.trinity.controller.Controller;

/**
 * Servlet implementation class AdministratorController
 */
public class AdministratorController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "index.jsp?content=administrator/administrator.jsp";
	}
	
}

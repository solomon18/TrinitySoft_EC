package kr.co.kyobo.controller.company;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kyobo.controller.Controller;

public class CompanyController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 //view select
		int number=Integer.parseInt(request.getParameter("number"));
		if(number==1)
			return "index.jsp?content=company/company_01.html";
		else if(number==2)
			return "index.jsp?content=company/company_02.html";
		else if(number==3)
			return "index.jsp?content=company/company_03.html";
		else if(number==4)
			return "index.jsp?content=company/company_04.html";
		else
			return "index.jsp?content=company/company_05.html";
	}
}

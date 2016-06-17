package kr.co.kyobo.controller.solution;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kyobo.controller.Controller;

public class SolutionController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 //view select
		int number=Integer.parseInt(request.getParameter("number"));
		if(number==1)
			return "index.jsp?content=solution/solution01.html";
		else if(number==21 || number==2)
			return "index.jsp?content=solution/solution02_1.html";
		else if(number==22)
			return "index.jsp?content=solution/solution02_2.html";
		else if(number==23)
			return "index.jsp?content=solution/solution02_3.html";
		else if(number==24)
			return "index.jsp?content=solution/solution02_4.html";
		else
			return "index.jsp?content=solution/solution03.html";
	}
}

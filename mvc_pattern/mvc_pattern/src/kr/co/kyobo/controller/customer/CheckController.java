package kr.co.kyobo.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kyobo.controller.Controller;
import kr.co.kyobo.dao.CustomerDAO;

public class CheckController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String userId = request.getParameter("userId");
		String nextPage = null;
		
		CustomerDAO custDao = new CustomerDAO();
		Boolean idChk  = custDao.loginCheck(userId);
		String result = "";
		
		if(idChk)
			result = "true";
		else
			result = "false" ;
		
		request.setAttribute("userId", userId);
		request.setAttribute("result", result);
		nextPage = "idcheck.jsp";
		
		return nextPage;
	}
	
}

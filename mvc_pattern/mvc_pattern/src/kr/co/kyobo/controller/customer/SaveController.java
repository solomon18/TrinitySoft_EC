package kr.co.kyobo.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kyobo.controller.Controller;
import kr.co.kyobo.dao.CustomerDAO;
import kr.co.kyobo.dao.CustomerDAOIF;
import kr.co.kyobo.exception.DulplicateException;
import kr.co.kyobo.vo.Customer;

public class SaveController implements Controller {
    CustomerDAOIF dao=new CustomerDAO();
	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nextPage=null;
		//data check
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		
		//business method 호출
		try {
			dao.insert(new Customer(userId, password,userName, age,email));
			//일정범위에 데이터 저장,view select
			request.setAttribute("message",userId+"님 회원가입 되었습니다.");
			nextPage = "index.jsp?content=success.jsp";
		} catch (DulplicateException e) {
			//일정범위에 데이터 저장,view select
			request.setAttribute("message", e.getMessage());
			nextPage="index.jsp?content=error.jsp";
		}
	
		return nextPage;
	}

}

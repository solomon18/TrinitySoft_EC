package kr.co.kyobo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kyobo.dao.CustomerDAO;
import kr.co.kyobo.dao.CustomerDAOIF;

public class LoginController implements Controller {
    CustomerDAOIF dao=new CustomerDAO();
	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String nextPage=null;
		//data check
		String userId = request.getParameter("userId");
		String password=request.getParameter("password");
		
		//business logic호출
		boolean loginSuccess=false;
		loginSuccess = dao.loginCheck(userId, password);
	
		//일정범위에 데이터 저장
		//view select
		if(loginSuccess){
			//Cookie 생성
			Cookie userIdCookie = new Cookie("userId", userId);
			Cookie passwordCookie = new Cookie("password", password);
			userIdCookie.setMaxAge(60*60);
			passwordCookie.setMaxAge(60*60);
			//userIdCookie.setHttpOnly(true);  //안전한 코드
			//passwordCookie.setSecure(true);  //안전한 코드
			
			//Cookie setting
			response.addCookie(userIdCookie);
			response.addCookie(passwordCookie);
			
		 //안전한 코드 : cookie대신 session 사용
			//session생성
			HttpSession session=request.getSession(); //request.getSession(true);
			//session정보 저장
			session.setAttribute("userId",userId);
			session.setAttribute("password", password);
		          			
			request.setAttribute("message", "로그인 성공!!");
			nextPage="index.jsp?content=result.jsp";
		}else{
			nextPage="index.jsp?content=login.html";
		}
		
		return nextPage;
		
	}

}

package kr.co.trinity.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.trinity.controller.Controller;
import kr.co.trinity.dao.BoardDAO;
import kr.co.trinity.dao.BoardDAOIF;
import kr.co.trinity.exception.RecordNotFoundException;

public class DeleteController implements Controller {
    BoardDAOIF dao= new BoardDAO();
	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nextPage=null;
	    //data check, business method 호출, 일정범위에 결과저장, view select
		int boardNum=Integer.parseInt(request.getParameter("boardNum"));
				
		try {
			dao.delete(boardNum);
			request.setAttribute("message",boardNum+" 글 삭제 되었습니다.");
			nextPage="index.jsp?content=result.jsp";
		} catch (RecordNotFoundException e) {
			request.setAttribute("message", e.getMessage());
			nextPage="index.jsp?content=result.jsp";
		}
		
		return nextPage;
	}

}

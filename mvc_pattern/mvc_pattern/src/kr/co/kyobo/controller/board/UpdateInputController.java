package kr.co.kyobo.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kyobo.controller.Controller;
import kr.co.kyobo.dao.BoardDAO;
import kr.co.kyobo.dao.BoardDAOIF;
import kr.co.kyobo.exception.RecordNotFoundException;
import kr.co.kyobo.vo.Board;

public class UpdateInputController implements Controller {
    BoardDAOIF dao= new BoardDAO();
	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nextPage=null;
	    //data check, business method 호출, 일정범위에 결과저장, view select
		int boardNum=Integer.parseInt(request.getParameter("boardNum"));
				
		try {
			Board board= dao.getBoard(boardNum);
			request.setAttribute("board", board);
			nextPage="index.jsp?content=board/boardUpdate.jsp";
		} catch (RecordNotFoundException e) {
			request.setAttribute("message", e.getMessage());
			nextPage="index.jsp?content=result.jsp";
		}
		
		return nextPage;
	}

}

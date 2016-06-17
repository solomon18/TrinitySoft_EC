package kr.co.kyobo.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kyobo.controller.Controller;
import kr.co.kyobo.dao.BoardDAO;
import kr.co.kyobo.dao.BoardDAOIF;
import kr.co.kyobo.vo.Board;

public class ListController implements Controller {
   BoardDAOIF dao=new BoardDAO();
	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nextPage=null;
		//data check, business method call, scope에 data save, view select
		ArrayList<Board> boardList = dao.getAllBoard();
		request.setAttribute("boardList", boardList);
		nextPage="index.jsp?content=board/boardList.jsp";
		
		return nextPage;
	}

}

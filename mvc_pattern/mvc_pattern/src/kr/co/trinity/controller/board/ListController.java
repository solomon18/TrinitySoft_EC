package kr.co.trinity.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.trinity.controller.Controller;
import kr.co.trinity.dao.BoardDAO;
import kr.co.trinity.dao.BoardDAOIF;
import kr.co.trinity.vo.Paging;
import kr.co.trinity.vo.Board;

public class ListController implements Controller {
   BoardDAOIF dao = new BoardDAO();
	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		//data check, business method call, scope�뿉 data save, view select
		String pageNumber = null, pageSize = null, url = null;
		int totalCount = 0;
		ArrayList<Board> boardList = dao.getAllBoard();
		
		pageNumber = request.getParameter("pageNumber") ;
		pageSize = request.getParameter("pageSize") ;
		totalCount = dao.getTotalCount();
		url = "index.jsp?"; 
		
		Paging pageInfo
			= new Paging(pageNumber, pageSize, totalCount, url) ;
		
		System.out.println("ListController 들어왔숑");
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("boardList", boardList);
		nextPage="index.jsp?content=board/boardList.jsp";
		System.out.println(pageInfo.toString());
		
		return nextPage;
	}

}

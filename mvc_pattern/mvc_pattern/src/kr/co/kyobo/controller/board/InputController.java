package kr.co.kyobo.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kyobo.controller.Controller;

public class InputController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 //view select
			return "index.jsp?content=board/boardInput.jsp";
	}

}

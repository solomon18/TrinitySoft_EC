package kr.co.kyobo.controller.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.kyobo.controller.Controller;
import kr.co.kyobo.dao.BoardDAO;
import kr.co.kyobo.dao.BoardDAOIF;
import kr.co.kyobo.vo.Board;

public class SaveController implements Controller {
    BoardDAOIF dao=new BoardDAO();
    String file;
    String file_name;
    String ori_file_name;
    
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		String savePath = "upload";
		
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "UTF-8";
		
		
		ServletContext context =  request.getSession().getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		MultipartRequest multi = new MultipartRequest(
				request,
				uploadFilePath,
				uploadFileSizeLimit,
				encType,
				new DefaultFileRenamePolicy());
		
		Enumeration files = multi.getFileNames();
		
		while(files.hasMoreElements()){
			file = (String) files.nextElement();
			file_name = multi.getFilesystemName(file);
			//중복된 파일을 업로드할 경우 파일명이 바뀐다.
			ori_file_name = multi.getOriginalFileName(file);
		}
		String nextPage=null;
		
	    //data check, business method 호출, 일정범위에 결과저장, view select
		String title=multi.getParameter("title");
		String writer=multi.getParameter("writer");
		String contents=multi.getParameter("contents");
		
		//******file upload 추가 ...
		String filename = multi.getFilesystemName("fileName");
		
		/*
		Board bVo = new Board();
		bVo.setTitle(title);
		bVo.setWriter(writer);
		bVo.setContents(contents);
		bVo.setFileName(file_name);
		*/
		
		dao.insert(new Board(title, writer, contents, ori_file_name));
		
		request.setAttribute("message", "글등록 되었습니다....");
		nextPage="index.jsp?content=result.jsp";
		return nextPage;

	}
}

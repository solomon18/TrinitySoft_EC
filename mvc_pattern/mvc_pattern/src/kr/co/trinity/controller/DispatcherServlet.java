package kr.co.trinity.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//web.xml init-param
		String file=config.getInitParameter("configLoaction");
		//application 실제 위치
		String fileName=getServletContext().getRealPath(file);
		HandlerMapping.mapping(fileName);
		System.out.println("fileName"+fileName);
		System.out.println("file"+file);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
        String action=request.getParameter("action");
        Controller controller = HandlerMapping.getAction(action);
       
        String nextPage=null;
		try {
			nextPage = controller.handleRequest(request, response);
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			nextPage="error.jsp";
			e.printStackTrace();
			System.out.println("message" + "아놔 에러");
		}
        request.getRequestDispatcher(nextPage).forward(request, response);

	}

	
}








